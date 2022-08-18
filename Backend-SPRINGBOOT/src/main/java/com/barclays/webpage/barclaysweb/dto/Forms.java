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

        public String getLogInfo() {
            return String.format("%s %s %s", this.firstName, this.lastName , this.email);
        }
    }
}
