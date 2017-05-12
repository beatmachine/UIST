using System;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Reflection;

namespace Snakes.ViewModel
{
    public abstract class ViewModel
    {
        protected ViewModel()
        {

        }

        /// <summary>
        /// Call this method when a property has changed
        /// </summary>
        /// <param name="propertyName">Name of the property.</param>
        /// <remarks></remarks>
        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChangedEventHandler handler = PropertyChanged;

            if (handler != null)
                handler(this, new PropertyChangedEventArgs(propertyName));
        }

        /// <summary>
        /// Event handler for property changes
        /// </summary>
        /// <remarks></remarks>
        public event PropertyChangedEventHandler PropertyChanged;
    }

    public abstract class ViewModel<T> : ViewModel, IViewModel<T> where T : class
    {
        private T model;
        /// <summary>
        /// Changes the model and propagates all changed properties
        /// </summary>
        [Browsable(false)]
        [Bindable(false)]
        public T Model
        {
            get
            {
                return model;
            }
            set
            {
                if (Model != value)
                {
                   CommunicateModelChanges(value);
                }
            }
        }

        private void CommunicateModelChanges(T newModel)
        {
            var properties = this.GetType().GetProperties(BindingFlags.Public |BindingFlags.Instance);
            var oldValues = properties.Select(p => p.GetValue(this, null));
            var enumerator = oldValues.GetEnumerator();
            model = newModel;
            try { 
            foreach (var property in properties)
            {
                enumerator.MoveNext();
                var oldValue = enumerator.Current;
                var newValue = property.GetValue(this, null);

                if ((oldValue == null && newValue != null)
                    || (oldValue != null && newValue == null)
                    || (!oldValue.Equals(newValue)))
                {
                    OnPropertyChanged(property.Name);
                }
            }
            }catch(Exception e) { }
        }

        public ViewModel(T model)
            : base()
        {
            this.model = model;
        }
    }
}
