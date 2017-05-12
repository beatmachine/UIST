using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Input;
using ViewModelBase;
using Snakes.Model;

namespace Snakes.ViewModel
{
    class GameLogicViewModel : ViewModel<GameLogic>
    {
        #region Attributes
        public event EventHandler<NewFrameEventArgs> NewFrameEventHandler;
        private Thread gameThread;
        private ICommand _play;
        private ICommand _stop;
        public bool IsRunning
        {
            set
            {
                if (IsRunning == value) return;
                Model.IsRunning = value;
                OnPropertyChanged("IsRunning");

                if (value)
                {
                    gameThread = new Thread(Run) { IsBackground = true };
                    gameThread.Start();
                }
            }
            get { return Model.IsRunning; }
        }
        #endregion

        #region Commands
        
        //Start the Game
        public ICommand Play
        {
            get
            {
                if(_play == null)
                {
                    _play = new RelayCommand(
                        param => this.setPlay(true));
                }
                return _play;
            }
        }
        //Stop the Game
        public ICommand Stop
        {
            get
            {
                if(_stop == null)
                {
                    _stop = new RelayCommand(
                        param => this.setPlay(false));

                }
                return _stop;
            }
        }
        private void setPlay(Boolean play)
        {
            this.IsRunning = play;
        }
 
        //ToDo: Include the commands for play and pause
        #endregion

        #region Threading
        private void Run()
        {
            int frame = 0;
            int nextTarget = 0;

            while (true)
            {
                EventHandler<NewFrameEventArgs> handler = NewFrameEventHandler;
                frame++;

                if (handler != null)
                {
                    handler(this, new NewFrameEventArgs() { CreateNewTarget = (frame >= nextTarget) });
                }

                int diff = Model.Difficulty * 10;
                if (diff > 230) diff = 230;

                if (frame >= nextTarget)
                {
                    frame = 0;
                    Model.Difficulty++;
                    nextTarget = new Random().Next(8 + diff / 2, 25 + diff / 2);
                }

                Thread.Sleep(300 - diff);
                if (!IsRunning) return;
            }
        }
        #endregion

        public GameLogicViewModel(GameLogic model) : base(model)
        {
            gameThread = new Thread(Run) { IsBackground = true };
        }
    }
}
