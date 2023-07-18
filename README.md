## ChatterBox

ChatterBox is a web application that allows users to register, confirm their email addresses, and engage in conversations with other users.
## Technologies Used

    Java
    Spring Boot
    Spring Data JPA
    Spring Security
    PostgreSQL
    Hibernate
    Lombok
    HTML
    CSS
    JavaScript
## Features

User registration: Users can create an account by providing their username, email, and password. Upon registration, a confirmation email is sent to the provided email address.

Email confirmation: Users need to confirm their email addresses by clicking on the activation link sent to them via email. The link is valid for 15 minutes.

User authentication: Registered users can log in using their credentials.

User authorization: The application distinguishes between regular users and administrators.

Conversation functionality: Users can engage in conversations with other users, creating and responding to messages.

Database persistence: User and token information is stored in a MySQL database.

Security: Spring Security was used to handle authentication and authorization for the application. Passwords are encrypted using BCrypt.


## Installation

Install my-project with npm

```bash
    Clone the repository: git clone https://github.com/your-username/ChatterBox.git

    Set up the PostgreSQL database and configure the database connection in application.yml.
    
    Set up and configure MailDev https://github.com/maildev/maildev 
    with "npm install -g maildev"
    and then run it with "maildev" command
    
    Access the application in your web browser at http://localhost:8080
```
## Screenshots
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/login.png)
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/register.png)
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/emailconf.png)
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/email.png)
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/chatusername.png)
![Alt text](https://github.com/mich-wierzch/ChatterBox/blob/master/chat.png)
