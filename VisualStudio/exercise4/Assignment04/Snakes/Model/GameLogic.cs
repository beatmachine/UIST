using System;
using System.Diagnostics;
using System.Threading;
using ThreadState = System.Threading.ThreadState;

namespace Snakes.Model
{
    public class GameLogic
    {
        private bool isRunning = false;
        private int difficulty = 0;

        public int Difficulty
        {
            set { difficulty = value; }
            get { return difficulty; }
        }
        public bool IsRunning
        {
            set
            {
                isRunning = value;
            }
            get { return isRunning; }
        }


        public GameLogic()
        {
            
        }


    }

    public class NewFrameEventArgs : EventArgs
    {
        public bool CreateNewTarget;
    } 
}