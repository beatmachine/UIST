using System;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;
using Snakes.Model;
using Snakes.View;
using Snakes.ViewModel;

namespace Snakes
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private SnakeViewModel _svm;
        //ToDo: Include second SnakeViewModel
        private PlayBoardViewModel _pbvm;
        private GameLogicViewModel gl;
        private int playerCount = 1;

        public MainWindow()
        {
            InitializeComponent();
            InitGameViews();
            InitStatisticView();
            InitControlView();  
            InitBoardView();

            _svm.PropertyChanged += GameOver;
            //ToDo: Adjust for Two Players
        }

        private void InitStatisticView()
        {
            StatisticsView.DataContext = _svm;
            StatisticsView2Players.LivesP1.DataContext = _svm;
            StatisticsView2Players.PointsP1.DataContext = _svm;
            //ToDo: Adjust for Two Players
            
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
            //ToDo: Adjust for Two Players

            SnakeView.DataContext = _svm;
            SnakeView.referenceBrush = Brushes.Chocolate;
            SnakeView.Init();
            //ToDo: Adjust for Two Players

        }

        private void ChangePlayerNumber(object sender, ChangePlayersEventArgs e)
        {
            if (e.numPlayers == 1)
            {
                playerCount = 1;
                SnakeView2.Visibility = Visibility.Hidden;
                StatisticsView2Players.Visibility = Visibility.Hidden;
                StatisticsView.Visibility = Visibility.Visible;
            }
            else if (e.numPlayers == 2)
            {
                //ToDo: Adjust for Two Players
            }
        }

        private void OnNewFrame(object sender, NewFrameEventArgs newFrameEventArgs)
        {
            _svm.Move();

            if (_pbvm.CheckForTarget(_svm.Position.Item1 * 20 + _svm.Position.Item2))
                _svm.Length++;


            //ToDo: Adjust for Two Players

            if (newFrameEventArgs.CreateNewTarget)
                _pbvm.AddRandomTarget();           
        }

        private void GameOver(object sender, EventArgs args)
        {
            try
            {
                PropertyChangedEventArgs args2 = (PropertyChangedEventArgs) args;

                if (args2.PropertyName != "Lives") return;
                if (_svm.Lives != 0) return;

                gl.IsRunning = false;

                _svm.Reset();

                //ToDo: Adjust for Two Players
                _pbvm.Reset();
            }
            catch (Exception)
            {
            }
        }

        private void Window_KeyDown(object sender, KeyEventArgs e)
        {
            SnakeViewModel reference = _svm;
            //ToDo: Change direction of Snake
        }
    }
}
