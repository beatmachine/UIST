using System;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;
using Snakes.Model;
using Snakes.View;
using Snakes.ViewModel;
using System.Media;

namespace Snakes
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private SnakeViewModel _svm;
        private SnakeViewModel _svm2;
        //ToDo: Include second SnakeViewModel
        private PlayBoardViewModel _pbvm;
        private GameLogicViewModel gl;
        private int playerCount = 1;

        private SoundPlayer collectSound = new SoundPlayer(Snakes.Resources.ding);
        private SoundPlayer crashSound = new SoundPlayer(Snakes.Resources.chord);

        public MainWindow()
        {
            InitializeComponent();
            InitGameViews();
            InitStatisticView();
            InitControlView();  
            InitBoardView();

            _svm.PropertyChanged += GameOver;
            _svm2.PropertyChanged += GameOver;
            //ToDo: Adjust for Two Players
        }

        /*
         * The Method for Changing the Direction via. Keyboard. 
         * Both the Keys and ASDW are for chaning direction.
         */
        private void Window_KeyDown(object sender, KeyEventArgs e)
        {
            SnakeViewModel reference = _svm;
            //For left movement
            if (e.Key == Key.Left || e.Key == Key.A)
            {
                if(e.Key == Key.Left)
                _svm.setDirection(Direction.left);
                else
                {
                    _svm2.setDirection(Direction.left);
                }
            }
            //for right movement
            if(e.Key == Key.Right || e.Key == Key.D)
            {
                if (e.Key == Key.Right)
                    _svm.setDirection(Direction.right);
                else
                {
                    _svm2.setDirection(Direction.right);
                }
            }
            //for up movement
            if(e.Key == Key.Up || e.Key == Key.W)
            {
                if (e.Key == Key.Up)
                    _svm.setDirection(Direction.up);
                else
                {
                    _svm2.setDirection(Direction.up);
                }
            }
            //for down movement
            if(e.Key == Key.Down || e.Key == Key.S)
            {
                if (e.Key == Key.Down)
                    _svm.setDirection(Direction.down);
                else
                {
                    _svm2.setDirection(Direction.down);
                }
            }
        }
        private void InitStatisticView()
        {
            StatisticsView.DataContext = _svm;
            StatisticsView2Players.LivesP1.DataContext = _svm;
            StatisticsView2Players.PointsP1.DataContext = _svm;
            //ToDo: Adjust for Two Players
            StatisticsView2Players.LivesP2.DataContext = _svm2;
            StatisticsView2Players.PointsP2.DataContext = _svm2;


            
        }

        private void InitBoardView()
        {
            _pbvm = new PlayBoardViewModel(new PlayBoard());

            PlayBoardView.DataContext = _pbvm;
            PlayBoardView.Init();
        }
        private void InitControlView()
        {
            gl = new GameLogicViewModel(new GameLogic());
            gl.NewFrameEventHandler += OnNewFrame;
            ControlView.DataContext = _svm;
            ControlView.Start.DataContext = gl;
            ControlView.Pause.DataContext = gl;
            ControlView.ChangePlayerEventHandler += ChangePlayerNumber;
        }


        private void InitGameViews()
        {
            _svm = new SnakeViewModel(new Snake());
            _svm2 = new SnakeViewModel(new Snake());
            //ToDo: Adjust for Two Players

            SnakeView.DataContext = _svm;
            SnakeView.referenceBrush = Brushes.Chocolate;
            SnakeView.Init();
            //Now for the Second one
            
            //ToDo: Adjust for Two Players

        }

        private void ChangePlayerNumber(object sender, ChangePlayersEventArgs e)
        {
            if (e.numPlayers == 1)
            {

                if (playerCount == 2)
                {
                    SnakeView3.Visibility = Visibility.Hidden;
                }
                playerCount = 1;
                SnakeView2.Visibility = Visibility.Hidden;
                StatisticsView2Players.Visibility = Visibility.Hidden;
                StatisticsView.Visibility = Visibility.Visible;
            }
            else if (e.numPlayers == 2)
            {
                playerCount = 2;

                SnakeView3.DataContext = _svm2;
                SnakeView3.referenceBrush = Brushes.Red;
                SnakeView3.Init();


                SnakeView3.Visibility = Visibility.Visible;
                StatisticsView2Players.Visibility = Visibility.Visible;
                StatisticsView.Visibility = Visibility.Hidden;
                //ToDo: Adjust for Two Players
            }
        }

        private void OnNewFrame(object sender, NewFrameEventArgs newFrameEventArgs)
        {
            _svm.Move();
            _svm2.Move();

            if (_pbvm.CheckForTarget(_svm.Position.Item1 * 20 + _svm.Position.Item2))
                _svm.Length++;
            if (_pbvm.CheckForTarget(_svm2.Position.Item1 * 20 + _svm2.Position.Item2))
                _svm2.Length++;

            //ToDo: Adjust for Two Players

            if (newFrameEventArgs.CreateNewTarget)
                _pbvm.AddRandomTarget();           
        }

        private void GameOver(object sender, EventArgs args)
        {
            try
            {
                PropertyChangedEventArgs args2 = (PropertyChangedEventArgs)args;
    
                if (_svm.Lives > 0 && _svm2.Lives > 0)
                {
                    collectSound.Play();
                    return;
                }

                if (_svm.Lives == 0 || _svm2.Lives == 0)
                {
                    crashSound.Play();
                    gl.IsRunning = false;
                    //_svm.Reset();
                    //_svm2.Reset();
                    //_pbvm.Reset();
                }
            }
            catch (Exception)
            {
            }
        }
    }
}
