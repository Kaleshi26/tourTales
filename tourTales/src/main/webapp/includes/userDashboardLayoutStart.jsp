
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="user-dashboard">
        <div class="user-sidebar">
            <ul class="user-menu-list">
            	<c:forEach var="entry" items="${tabs.entrySet()}">
  					<li><a href="${ entry.value }"><span> ${ entry.key }</span></a></li>
				</c:forEach>
            </ul>
            <div class="user-logout">
                <a href="logout"> <span>Logout</span></a>
            </div>
        </div>
        <div class="user-content">
            
