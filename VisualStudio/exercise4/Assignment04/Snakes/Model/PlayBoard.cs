using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Snakes.Model
{
    public class PlayBoard
    {
        public ObservableCollection<bool> Cells;
        private List<int> Targets; 
        public PlayBoard()
        {
            Init();
        }

        public void Init()
        {
            Cells = new ObservableCollection<bool>();
            for (int i = 0; i < 20 * 20; i++)
                Cells.Add(false);
            Targets = new List<int>();
        }
        public void AddRandomTarget()
        {
            int random = new Random().Next(0, 400);
            
            Targets.Add(random);
            Cells[random] = true;
        }

        public bool CheckForTarget(int field)
        {
            if (Cells[field])
            {
                Cells[field] = false;
                return true;
            }
            return false;
        }
    }
}
