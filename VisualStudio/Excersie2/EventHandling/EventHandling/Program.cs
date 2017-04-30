using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static EventHandling.UserController;

namespace EventHandling
{
    class Program
    {

        private static void HandleNewUserEvent(object send, UserEventArgs args)
        {
            Console.WriteLine(args.id);
        }

        private static void HandleUserEditedEvent(object sender, UserEventArgs args)
        {
            Console.WriteLine(args.id);
        }

        private static void HandleErrorEvent(object sender, ErrorEventArgs args)
        {
            Console.WriteLine(args.Message);
        }
        //Initiating the userController Class
        static UserController userController = new UserController();

        /*
         * Main Method where the Application will be started
         */
        static void Main(string[] args)
        {
            //Initiating the Enum
            EventHandling.UserController.State state = UserController.State.Init;
            //The loop which will get the input from the user
            while (true)
            {
                String userInput = Console.ReadLine();
                //if the user types exit the application will be terminated
                if (userInput.Equals("exit"))
                {
                    Environment.Exit(0);
                }
                //if the user types new the state will be set to New
                if (userInput.Equals("new"))
                {
                    state = UserController.State.New;
                }
                //if the user tpyes edit the state will be set to Edit
                if (userInput.Equals("edit"))
                {
                    state = UserController.State.Edit;
                }

                //the switch which decides which method will be called
                switch (state)
                {
                    //if the state is edit Edit User will be called
                    case UserController.State.Edit:
                        {
                            userController.EditUser(userInput);
                            userController.NewUserEvent += HandleUserEditedEvent;
                            break;
                        }
                        //if the state is new New User will be called
                    case UserController.State.New:
                        {
                            userController.NewUser(userInput);
                            userController.NewUserEvent += HandleNewUserEvent;
                            break;
                        }

                }
            }
        }
    }
}
