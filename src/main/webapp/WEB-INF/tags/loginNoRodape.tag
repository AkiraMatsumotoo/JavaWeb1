<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${usuValido!=null }">
		${usuValido}
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>