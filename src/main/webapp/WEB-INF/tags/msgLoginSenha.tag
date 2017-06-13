<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${msg!=null }">
		${ msg}
	</c:when>
</c:choose>