<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${status == 'error'}">
    <script>
        <% String message = (String) request.getAttribute("message"); %>
        errorMessage = '<%=message%>';
        errorNotify();
    </script>
</c:if>
