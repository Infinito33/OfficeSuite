<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${status == 'warning'}">
    <script>
        <% String message = (String) request.getAttribute("message"); %>
        warningMessage = '<%=message%>';
        warningNotify();
    </script>
</c:if>
