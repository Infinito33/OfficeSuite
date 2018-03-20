<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${status == 'success'}">
    <script>
        <% String message = (String) request.getAttribute("message"); %>
        successMessage = '<%=message%>';
        successNotify();
    </script>
</c:if>
