<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Todo-app</title>
    </head>
    <body>
        <p>Your Todo-items<br/></p>
        <table border="1">
            <tr>
                <th>Item</th>
            </tr>
            <c:forEach items="${todoList.getItems()}" var="item">
                <tr>
                <td>
                    <form action="todoapp" method="POST">
                        <c:out value="${test}"/>
                        <c:out value="${item.name}"/>
                        <input type="hidden" name="deleteItem" value=${item.name}/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
                </tr>
            </c:forEach>
        </table><br/>
        <form action="todoapp" method="POST">
            <fieldset>
              <legend>Add items</legend>
              <p>Item: <input type="text" name="item"/></p>
              <p><input type="submit" value="Add"/></p>
            </fieldset>
          </form>
        <!--form action="logout" method="GET">
            <fieldset>
                <p>
                    <input type="submit" value="Log out"/>
                </p>
            </fieldset>
        </form-->
    </body>
</html>