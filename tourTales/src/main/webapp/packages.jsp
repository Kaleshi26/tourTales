<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import = "java.util.ArrayList" %>    
<%@ page import="models.Packages" %>
<%@include file="includes/header.jsp" %>

<%
			List<Packages> packagelist = new ArrayList<>();
			packagelist = null;
			packagelist = (List<Packages>)request.getAttribute("packagelist");
			System.out.println(packagelist);
			
			if (packagelist == null) {
				
				System.out.println("UnSucesss");
			}
			else{}
				
%>
    
        <h2 id="Packagespage-heading">Our Packages</h2>
        <div class="packagepage-container">
            <div class="package-box">
                
                <h3><%= packagelist.get(0).getPname() %></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(0).getPid()%>" class="Packagepage-btn"><b>Book now</b></a>
                
                <!-- passing the id as a query in the url -->
                
            </div>
             <div class="package-box">
                
                <h3><%= packagelist.get(1).getPname() %></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(1).getPid()%>" class="Packagepage-btn"><b>Book now</b></a>
            	</div>
            <div class="package-box">
                
                <h3><%= packagelist.get(2).getPname() %></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(2).getPid()%>" class="Packagepage-btn"><b>Book now</b></a>
            </div>
            <div class="package-box">
                
                <h3><%= packagelist.get(3).getPname()%></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(3).getPid()%>" class="Packagepage-btn"><b>Book now</b></a>
            </div>
            <div class="package-box">
                
                <h3><%= packagelist.get(4).getPname() %></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(4).getPid()%>"class="Packagepage-btn"><b>Book now</b></a>
            	</div>
            	<div class="package-box">
               
                <h3><%= packagelist.get(5).getPname() %></h3>
                
                <a href="Payment?packageId=<%= packagelist.get(5).getPid()%>" class="Packagepage-btn"><b>Book now</b></a>
            	</div>
           
        </div>
   
    

    <%@include file="includes/footer.jsp" %>

</body>
</html>