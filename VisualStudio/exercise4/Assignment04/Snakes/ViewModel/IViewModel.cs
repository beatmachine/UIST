using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Snakes.ViewModel
{
    public interface IViewModel : INotifyPropertyChanged
    {
    }

    /// <summary>
    /// The ViewModel Interface
    /// </summary>
    /// <typeparam name="T">The used Model.</typeparam>
    public interface IViewModel<T> : IViewModel
    {
        [Browsable(false)]
        [Bindable(false)]
        T Model { get; set; }
    }
}

