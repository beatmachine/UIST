using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Snakes.View
{
    /// <summary>
    /// Interaktionslogik für ControlView.xaml
    /// </summary>
    public partial class ControlView : UserControl
    {
        public event EventHandler<ChangePlayersEventArgs> ChangePlayerEventHandler;

        public ControlView()
        {
            InitializeComponent();
            Button b1 = new Button();
            b1.Click += PlayerMode;
        }

        private void PlayerMode(object sender, RoutedEventArgs e)
        {
            EventHandler<ChangePlayersEventArgs> handler = ChangePlayerEventHandler;
            if (handler != null) { 
                if (TwoPlayers.Content.Equals("2 Players"))
                {
                    handler(this, new ChangePlayersEventArgs() {numPlayers = 2});
                    TwoPlayers.Content = "1 Player";
                }
                else
                {
                    handler(this, new ChangePlayersEventArgs() { numPlayers = 1});
                    TwoPlayers.Content = "2 Players";
                }
            }
        }
    }

    public class ChangePlayersEventArgs : EventArgs
    {
        public int numPlayers;
    }
}
