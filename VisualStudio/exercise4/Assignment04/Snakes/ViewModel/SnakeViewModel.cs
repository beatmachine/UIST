using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using ViewModelBase;
using Snakes.Model;

namespace Snakes.ViewModel
{
    public class SnakeViewModel : ViewModel<Snake>
    {
        #region Attributes
        //float for the amount of lives
        public int Lives
        {
            set
            {
                if (Model.Lives != value)
                {
                    Model.Lives = value;
                    OnPropertyChanged("Lives");

                }
            }
            get { return Model.Lives; }
        }

        //float for the amount of cells
        public ObservableCollection<bool> Cells
        {
            set
            {
                if(Model.Cells != value)
                {
                    Model.Cells = value;
                    OnPropertyChanged("Cells");
                }
            }
            get { return Model.Cells; }
        }
        //Enum for the Directions
        private Direction Direction
        {
            set
            {
                if(Model.Direction != value)
                {
                    Model.Direction = value;
                    OnPropertyChanged("Direction");
                }
            }
            get { return Model.Direction; }
        }

        public Tuple<int, int> Position {
            set
            {
                if(Model.Position != value)
                {
                    Model.Position = value;
                    OnPropertyChanged("Position");
                }
               
            }
            get { return Model.Position; }
        }

        public int Length {
            set
            {
                if(Model.Length != value)
                {
                    Model.Length = value;
                    OnPropertyChanged("Length");
                    
                }
            }
            get { return Model.Length; }
        }

        // ToDo: Include attributes named Direction, Position, Length, Cells, Lives. 
        // ToDo: Link them to the model and communicate if they are changed via OnPorpertyChanged
        #endregion

        #region Commands
        /*
        * The I Command for the Direction to the UP 
        */
        private ICommand _directionUP;
        public ICommand DirectionUP
        {
            get
            {
                if(_directionUP == null)
                {
                    _directionUP = new RelayCommand(param => setDirection(Direction.up));
                }
                return _directionUP;
            }
        }
        /*
         * The I Command for the Direction to the Down 
         */
        private ICommand _directionDown;
        public ICommand DirectionDown
        {
            get
            {
                if(_directionDown == null)
                {
                    _directionDown = new RelayCommand(param => setDirection(Direction.down));

                }
                return _directionDown;
            }

        }
        /*
         * The I Command for the Direction to the Left 
         */
        private ICommand _directionLeft;
        public ICommand DirectionLeft
        {
            get
            {
                if(_directionLeft == null)
                {
                    _directionLeft = new RelayCommand(param => setDirection(Direction.left));
                }
                return _directionLeft;
            }
        }
        /*
         * The I Command for the Direction to the Right 
         */
        private ICommand _directionRight;
        public ICommand DirectionRight
        {
            get
            {
                if (_directionRight == null)
                {
                    _directionRight = new RelayCommand(param => setDirection(Direction.right));
                }
                return _directionRight;
            }
        }

        

        // ToDo: Include commands named DirectionUp, DirectionDown, DirectionLeft, DirectionRight
        #endregion
        /*
         * Method for Changing the Direction 
         */
        public void setDirection(Enum direction)
        {
            switch (direction)
            {
                case Direction.right: Model.ChangeDirection(Snakes.Model.Direction.right);
                    break;
                case Direction.left: Model.ChangeDirection(Snakes.Model.Direction.left);
                    break;
                case Direction.up: Model.ChangeDirection(Snakes.Model.Direction.up);
                    break;
                case Direction.down: Model.ChangeDirection(Snakes.Model.Direction.down);
                    break;
            }
        }
        public void Move()
        {
            Model.Move();
            if (Model.CheckCollision())
            {
                Lives--;
            }
        }

        public void Reset()
        {
           Model.Init();
        }

        public SnakeViewModel(Snake model) : base(model)
        {
          
        }
       
    }
}
