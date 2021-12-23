<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <body>
        <h1>List products</h1>

        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Cost</th>
            </tr>
            <c:forEach var="item" items="${products}">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.cost}</td>
            </tr>
            </c:forEach>
        </table>

    </body>
</html>