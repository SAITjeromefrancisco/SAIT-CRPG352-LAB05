<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="">
            <label>Username:</label>
            <input type="text" name="userinput" value="${uservalue}">
            <br>
            <label>Password:</label>
            <input type="password" name="passinput" value="${passvalue}">
            <br>
            <input type="Submit" value="Login">
        </form>
        <p>${message}</p>
    </body>
</html>
