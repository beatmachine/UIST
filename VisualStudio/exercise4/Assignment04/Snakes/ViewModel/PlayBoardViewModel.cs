using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Snakes.Model;

namespace Snakes.ViewModel
{
    public class PlayBoardViewModel : ViewModel<PlayBoard>
    {
        public ObservableCollection<bool> Cells
        {
            get { return Model.Cells; }
        }

        public void AddRandomTarget()
        {
            Model.AddRandomTarget();
        }

        public bool CheckForTarget(int field)
        {
            return Model.CheckForTarget(field);
        }

        public void Reset()
        {
            Model.Init();
        }
        public PlayBoardViewModel(PlayBoard model) : base(model)
        {

        }
    }
}
