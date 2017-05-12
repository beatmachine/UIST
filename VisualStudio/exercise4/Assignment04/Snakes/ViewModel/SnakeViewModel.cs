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
        // ToDo: Include attributes named Direction, Position, Length, Cells, Lives. 
        // ToDo: Link them to the model and communicate if they are changed via OnPorpertyChanged
        #endregion

        #region Commands
        // ToDo: Include commands named DirectionUp, DirectionDown, DirectionLeft, DirectionRight
        #endregion

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
