using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace Snakes.Model
{
    public enum Direction{up, down, left, right}

    public class Snake
    {
        public Direction Direction { set; get; }
        public Tuple<int, int> Position { set; get; }
        public int Length { set; get; }
        public ObservableCollection<bool> Cells { set; get; }
        public int Lives;

        private List<int> BodyParts;
        private Direction _LastMovedDirection;

        private int _longPosition
        {
            get { return Position.Item1*20 + Position.Item2; }
        }
        public Snake()
        {
            Init();
        }

        public void Init()
        {
            Lives = 3;
            Direction = Direction.left;
            _LastMovedDirection = Direction.left;
            BodyParts = new List<int>();
            Position = new Tuple<int, int>(10, 10);
            Length = 1;
            Cells = new ObservableCollection<bool>();

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 20; j++)
                    Cells.Add(false);

            Cells[Position.Item1 * 20 + Position.Item2] = true;
            BodyParts.Add(Position.Item1 * 20 + Position.Item2);
        }
        public bool ChangeDirection(Direction d)
        {
            if (d == _LastMovedDirection) return false;
            if ((Direction == Direction.right && d == Direction.left) ||
                (Direction == Direction.left && d == Direction.right) ||
                (Direction == Direction.up && d == Direction.down) || (Direction == Direction.down && d == Direction.up))
                return false;
            if (Direction != _LastMovedDirection) return false;

            Direction = d;
            return true;
        }

        public bool CheckCollision()
        {
            return BodyParts.FindAll(delegate (int position)
            {
                return position == _longPosition;
            }).Count > 1;
        }
        public void Move()
        {
            _LastMovedDirection = Direction;
            switch (Direction)
            { 
                case Direction.down:
                    Position = new Tuple<int, int>(Position.Item1 + 1, Position.Item2);
                    break;
                case Direction.up:
                    Position = new Tuple<int, int>(Position.Item1 - 1, Position.Item2);
                    break;
                case Direction.left:
                    Position = new Tuple<int, int>(Position.Item1, Position.Item2 - 1);
                    break;
                case Direction.right:
                    Position = new Tuple<int, int>(Position.Item1, Position.Item2 + 1);
                    break;
            }
            if (Position.Item1 < 0)
            {
                Position = new Tuple<int, int>(19, Position.Item2);
            }
            if (Position.Item1 >= 20)
            {
                Position = new Tuple<int, int>(0, Position.Item2);
            }
            if (Position.Item2 < 0)
            {
                Position = new Tuple<int, int>(Position.Item1, 19);
            }
            if (Position.Item2 >= 20)
            {
                Position = new Tuple<int, int>(Position.Item1, 0);
            }

            BodyParts.Add(_longPosition);
            Cells[_longPosition] = true;

            while (BodyParts.Count > Length)
            {
                Cells[BodyParts[0]] = false;
                BodyParts.RemoveAt(0);
            }
            
        }
    }
}
