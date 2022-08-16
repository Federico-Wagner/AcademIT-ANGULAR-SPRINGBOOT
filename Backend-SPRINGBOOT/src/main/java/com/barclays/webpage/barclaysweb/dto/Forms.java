package com.barclays.webpage.barclaysweb.dto;

public class Forms {
    public static class LoginForm {
        String email;
        String password;
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "LoginForm{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static class RegisterForm {
        String email;
        String password;
        String firstName;
        String lastName;
        String passwordRepeat;

        public RegisterForm(String email, String password, String firstName, String lastName) {
            this.email = email;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public String getPasswordRepeat() {return passwordRepeat;}
        public boolean check() {
            return (email != null && password != null && firstName != null && lastName != null && password.equals(passwordRepeat));
        }

        @Override
        public String toString() {
            return "RegisterForm{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", passwordRepeat='" + passwordRepeat + '\'' +
                    '}';
        }
    }

//    public static class User{
//        public static int nextID = 1;
//        public int id;
//        public String firstName,lastName, email, password;
//        public String cbu, alias;
//        public Double ctu_$, ctu_U$$;
//
//         public User(String firstName, String lastName, String email, String password) {
//            this.id = nextID;
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.email = email;
//            this.password = password;
//            this.cbu = "123456789";
//            this.alias = "123456789";
//            this.ctu_$ = 0.0;
//            this.ctu_U$$ = 0.0;
//
//            //class atribute (static)
//            nextID ++;  //add 1 for next user
//        }
//        public User(RegisterForm registerForm) {
//            this.id = nextID;
//            this.firstName = registerForm.getFirstName();
//            this.lastName = registerForm.getLastName();
//            this.email = registerForm.getEmail();
//            this.password = registerForm.getPassword();
//            this.cbu = "123456789";
//            this.alias = "123456789";
//            this.ctu_$ = 0.0;
//            this.ctu_U$$ = 0.0;
//
//            //class atribute (static)
//            nextID ++;  //add 1 for next user
//        }
//
//        public int getId() {
//            return this.id;
//        }
//        public String getEmail() {
//            return email;
//        }
//        public boolean credentialsCheck(LoginForm loginForm){
//            return (this.password.equals(loginForm.getPassword()) && this.email.equals(loginForm.getEmail()));
//        }
//    }
}
