using System;
using System.Collections.Generic;

namespace EventHandling
{
    public class UserController
    {
        //Initiating the userList List
        List<UserModel> userList;


        //Constructor
        public UserController()
        {
            this.userList = new List<UserModel>();

        }


        /*
         * This is the struct which is needed 
         */
        struct UserModel
        {
            String Name;
            String Vorname;
            int Age;
            public UserModel(String name, String vorname, int age)
            {
                this.Name = name;
                this.Vorname = vorname;
                this.Age = age;
            }

            /*
             * TODO: Remove after testing! 
             */

            public String getName()
            {
                return this.Name;
            }

            public String getVorname()
            {
                return this.Vorname;
            }

            public int getAge()
            {
                return this.Age;
            }
        }
        /*
         * TODO: Remove after testing! 
         */

        public void printAll()
        {
            foreach(UserModel i in userList)
            {
                Console.WriteLine("Name: {0}, Nachname: {1}, Alter: {2}", i.getName(), i.getVorname(), i.getAge());
            }
        }

        //Enum for the States of the Programm
        public enum State
        {
            Init, New, Edit
        }

        //Event UserEventArgs
        public class UserEventArgs : EventArgs
        {
            public int id;
        }

        //Event ErrorEventArgs
        public class ErrorEventArgs : EventArgs
        {
            public String Message;
        }

        //EventHandler for a UserEvent
        public event EventHandler<UserEventArgs> NewUserEvent;
        //EventHandler for a UserEvent
        public event EventHandler<UserEventArgs> UserEditedEvent;
        //EventHandler for a ErrorEvent
        public event EventHandler<ErrorEventArgs> ErrorEvent;

        /*
         * Method NewUser to Add a User to the List. Before Adding the New User the Method
         * will test if the input is correct
         */
        public void NewUser(String name)
        {
            String[] split = name.Split(',');
            int age = 0;
            //Console.WriteLine(split[2]);
            if (split.Length != 3 || !Int32.TryParse(split[2], out age))
            {
                //Generate new Error message
                ErrorEventArgs myArgs = new ErrorEventArgs() { Message = "Your input was wrong, it should have the format 'name, vorname, age" };
                Program.addErrorEvent();
                ErrorEvent?.Invoke(this, myArgs);
                
                return;
                //For testing
                //Console.WriteLine("Something went wrong, try again!");
            }
            else
            {

                userList.Add(new UserModel(split[0], split[1], age));
                //Genrate Event
                UserEventArgs myArgs1 = new UserEventArgs() { id = userList.Count - 1 };
                
                Program.addNewUserEvent();
                NewUserEvent?.Invoke(this, myArgs1);

            }
        }



        /*
         *Method EditUser to Edit a User in the List. Before Inserting a new User at specific
         * point the Method will check if the Input String is correct
         */
        public void EditUser(String name)
        {
            String[] split = name.Split(',');
            int age = 0;
            int id = 0;
            if (split.Length != 4 || !Int32.TryParse(split[0], out id) || !Int32.TryParse(split[3], out age))
            {
                //Generate new Error message
                ErrorEventArgs myArgs = new ErrorEventArgs() { Message = "Your input was wrong, it should have the format 'id, name, vorname, age" };
                Program.addErrorEvent();
                ErrorEvent?.Invoke(this, myArgs);
                

                return;
                //Console.WriteLine("Something went wrong, try again!");
            }
            else
            {
                //Remove the contact 
                userList.RemoveAt(id);
                //Add a new one at the same spot
                userList.Insert(id, new UserModel(split[1], split[2], age));

                //Generate Event
                UserEventArgs myArgs1 = new UserEventArgs() { id = id };
                Program.addNewUserEditedEvent();
                UserEditedEvent?.Invoke(this, myArgs1);
                
            }
        }


    }
}