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
        private float Lives = 0;
        //float for the amount of cells
        private float Cells = 0;
        //Enum for the Directions
        private enum Direction
        {
            LEFT, RIGHT, UP, DOWN
        }
        private int[] Position = new int[2];

        // ToDo: Include attributes named Direction, Position, Length, Cells, Lives. 
        // ToDo: Link them to the model and communicate if they are changed via OnPorpertyChanged
        #endregion

        #region Commands
        private ICommand _directionUP;
        public ICommand DirectionUP
        {
            get
            {
                _directionUP = new RelayCommand(
                    param => )
            }
        }
        private ICommand _directionDown;
        private ICommand _directionLeft;
        private ICommand _directionRight;
        // ToDo: Include commands named DirectionUp, DirectionDown, DirectionLeft, DirectionRight
        #endregion

        public void setDirection(Enum direction)
        {
            switch (Direction)
            {
                case Direction.RIGHT:
                    

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
