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

namespace SnakeGame
{
    /// <summary>
    /// Interaktionslogik für GameView.xaml
    /// </summary>
    public partial class GameView : UserControl
    {
        private const int ROW_AMOUNT = 20;
        private const int COULUMN_AMOUNT = 20;
        private String _name;

        public new String Name
        {
            get
            {
                return this._name;
            }
            set
            {
                this._name = value;
            }
        }
        public GameView()
        {
            InitializeComponent();
            Init();
        }
        /*
         * Method for initiating the GameField 
         */
        public void Init()
        {

            for (int i = 0; i < ROW_AMOUNT; i++)
            {
                //Add the Rows
                GridLayout.RowDefinitions.Add(new RowDefinition());
                //Add the Columns
                GridLayout.ColumnDefinitions.Add(new ColumnDefinition());
            }
            for (int i = 0; i < ROW_AMOUNT; i++)
            {
                for(int k = 0; k < COULUMN_AMOUNT; k++)
                {
                    //Create Lables for all Columns and Rows
                    Label l = new Label() { Content = i + ", " + k };
                    l.SetValue(Grid.ColumnProperty, k);
                    l.SetValue(Grid.RowProperty, i);
                    //TODO: WTF? Test both!
                    //l.Background = new LinearGradientBrush(Colors.Gray, Colors.Gray, 90);
                    l.Background = Brushes.Gray;
                    //Add the Label to the Layout
                    GridLayout.Children.Add(l);

                }
            }
        }
    }
}
