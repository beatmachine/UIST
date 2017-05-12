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
using Snakes.ViewModel;

namespace Snakes.View
{
    /// <summary>
    /// Interaktionslogik für GameView.xaml
    /// </summary>
    public partial class GameView : UserControl
    {
        public Brush referenceBrush = Brushes.Gray;
        public GameView()
        {
            InitializeComponent();
        }

        public void Init()
        {
            for (int i = 0; i < 20; i++)
            {
                GridView.RowDefinitions.Add(new RowDefinition());
            }
            for (int j = 0; j < 20; j++)
            {
                GridView.ColumnDefinitions.Add(new ColumnDefinition());
            }
            for (int i = 0; i < 20; i++)
            {
                for (int j = 0; j < 20; j++)
                {
                  
                    Label l = new Label {Background = referenceBrush};
                    l.Margin = new Thickness(1, 1, 1, 1);
                    l.SetValue(Grid.ColumnProperty, j);
                    l.SetValue(Grid.RowProperty, i);
                    Binding binding = new Binding("Cells[" + ((i*20) + j) + "]");
                    binding.Converter = new BooleanToVisibilityConverter();
                    l.SetBinding(VisibilityProperty, binding);
                    GridView.Children.Add(l);
                }
            }
        }
    }
}
