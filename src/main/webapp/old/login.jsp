<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${requiresLoginRedirect == true || invalidPasswordRedirect == true}">
          <p style="color: red;">${error}</p>
      </c:when>
    </c:choose>
    <form action="login" method="post">
      <fieldset>
        <legend>Login</legend>
        <p>Password: <input type="text" name="password"/></p>
        <p><input type="submit" value="Log in"/></p>
      </fieldset>
    </form>
  </body>
</html>