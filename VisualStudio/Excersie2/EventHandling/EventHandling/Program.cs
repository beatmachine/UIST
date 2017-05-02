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
            Console.WriteLine("A new User is safed. He has the ID {0}", args.id);
            userController.NewUserEvent -= HandleNewUserEvent;

        }

        private static void HandleUserEditedEvent(object sender, UserEventArgs args)
        {
            Console.WriteLine("The User with the ID {0} was edited!", args.id);
            userController.UserEditedEvent -= HandleUserEditedEvent;
        }

        private static void HandleErrorEvent(object sender, ErrorEventArgs args)
        {
            Console.WriteLine(args.Message);
            userController.ErrorEvent -= HandleErrorEvent;

        }
        //Initiating the userController Class
        static UserController userController = new UserController();
        
        /*
         * These Methods are for adding a Event 
         */

        public static void addErrorEvent()
        {
            userController.ErrorEvent += HandleErrorEvent;
        }

        public static void addNewUserEvent()
        {
            userController.NewUserEvent += HandleNewUserEvent;
        }

        public static void addNewUserEditedEvent()
        {
            userController.UserEditedEvent += HandleUserEditedEvent;
        }

        /*
         * Main Method where the Application will be started
         */
        static void Main(string[] args)
        {
            //Initiating the Enum
            EventHandling.UserController.State state = UserController.State.Init;
            //The loop which will get the input from the user
            Console.WriteLine("Use one of the following commands:\n" +
                      "new\n" +
                      "edit\n" +
                      "print\n"
                      );
            while (true)
            {

                String userInput = Console.ReadLine();
                //if the user types exit the application will be terminated
                if (userInput.Equals("exit"))
                {
                    Environment.Exit(0);
                }
                //if the user types new the state will be set to New
                else if (userInput.Equals("new"))
                {
                    Console.WriteLine("You are now in the 'new' mode");
                    userController.NewUserEvent -= HandleNewUserEvent;
                    userController.ErrorEvent -= HandleErrorEvent;
                    state = UserController.State.New;

                }
                //if the user tpyes edit the state will be set to Edit
                else if (userInput.Equals("edit"))
                {
                    Console.WriteLine("You are now in the 'edit' mode");
                    userController.NewUserEvent -= HandleUserEditedEvent;
                    userController.ErrorEvent -= HandleErrorEvent;
                    state = UserController.State.Edit;

                }
                /*
                 * TODO: Remove after testing! 
                 */

                else if (userInput.Equals("print"))
                {
                    userController.printAll();
                }
                else
                {
                    //the switch which decides which method will be called
                    switch (state)
                    {
                        //if the state is edit Edit User will be called
                        case UserController.State.Edit:
                            {
                                userController.EditUser(userInput);
                                //Register Eventhandler
                                //userController.NewUserEvent += HandleUserEditedEvent;
                                //userController.ErrorEvent += HandleErrorEvent;
                                break;
                            }
                        //if the state is new New User will be called
                        case UserController.State.New:
                            {
                                userController.NewUser(userInput);
                                //Register Eventhander
                                //userController.NewUserEvent += HandleNewUserEvent;
                                //userController.ErrorEvent += HandleErrorEvent;
                                break;
                            }

                    }

                }
            }
        }
    }
}
