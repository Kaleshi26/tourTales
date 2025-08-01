<!--importing java.util pack inside an html code-->
<%@ page import="java.util.List" %> 
<%@ page import = "java.util.ArrayList" %>
<%@ page import="models.Vehiclemodel" %>
<%@ page import="models.Packages" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"


    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
<link rel="stylesheet" href="css/payment.css">
<script type="text/javascript">
	
	function Paymentmethod(){
		
		const cardpay = document.getElementById("card");
		const details = document.getElementsByClassName("carddetails");
		
		if(cardpay.checked)
			{
				for(let i = 0; i<details.length;i++)
					{
					   details[i].style.display = "block";
					}
				
			}
		else
		{
			for(let i = 0; i<details.length;i++)
			{
				 details[i].style.display = "none";
			}
		
		}
	}
	
	function caltotal(){
		
		const vehicleSelect = document.getElementById("vehicle");
		const numberOfParticipants = document.getElementById("number").value;
		const amountInput = document.getElementById("amount");

		// Get the selected vehicle's price (from the data attribute)
		const selectedVehiclePrice = parseFloat(vehicleSelect.options[vehicleSelect.selectedIndex].getAttribute("dayprice"));

		// Calculate the total amount
		const totalAmount = selectedVehiclePrice + (5000 * numberOfParticipants);

		// Set the total amount in the input field
		amountInput.value = totalAmount.toFixed(2); 
		
	}
	

</script>

</head>
<body>


<%
		List<Packages> packageslist = new ArrayList<>();
		packageslist=(List<Packages>)request.getAttribute("packagelist");
		
		String packageId = (String) request.getAttribute("packageId");

%>
	
	<h2 class="Paymentpage-heading">Payment</h2><br>
	    
<form class="Paymentpage-form" action="Payment" method="post">

	<label class="Paymentpage-label" for="pid">Package ID</label>
    <input class="Paymentpage-input" type="number" id="pid" name="pid" value="<%= packageId%>" readonly><br><br>
    
    <label class="Paymentpage-label" for="date">Pickup Date</label>
    <input class="Paymentpage-input" type="text" id="date" name="date" required><br><br>

    <label class="Paymentpage-label" for="location">Pickup Location</label>
    <input class="Paymentpage-input" type="text" id="location" name="location" required><br><br>

    <label  class="Paymentpage-label" for="number">Number of Participants</label>
    <input class="Paymentpage-input" type="number" id="number" name="number" oninput="caltotal()" required><br><br>

    <label class="Paymentpage-label" for="vehicle">Select a Vehicle:</label>
    <select class="Paymentpage-select" name="vehicle" id="vehicle" onchange="caltotal()">
    
        <%
            
        	List<Vehiclemodel> vehiclelist = new ArrayList<>();
            vehiclelist = null;
            System.out.println(request.getAttribute("vehicles")+"hello");
            vehiclelist = (List<Vehiclemodel>)request.getAttribute("vehicles");
            System.out.println(request.getAttribute("vehicles")+"hello2");
            
            
            if (vehiclelist != null) {
            	
            	System.out.println("Successs");
                for (Vehiclemodel vehicle : vehiclelist) {
        %>
            <option value="<%= vehicle.getName() %>" dayprice="<%= vehicle.getprice() %>">
                <%= vehicle.getName() %> | Seats: <%= vehicle.getseats() %> | Price: <%= vehicle.getprice() %>
            </option>
        <%
                }
            } 
            else {
        %>
            <option value="">No vehicles available</option>
             
        <%
        System.out.println("unSuccesss");
            }
        %>
    </select><br><br>

    <label  class="Paymentpage-label" for="amount">Amount</label>
    <input class="Paymentpage-input" type="number" id="amount" name="amount" placeholder="Total Amount" readonly><br><br>

    <input type="radio" id="card" name="method" value="CardPayment" onclick="Paymentmethod()">
    <label  class="Paymentpage-label" for="card">Card Payment</label>
    <input type="radio" id="bank" name="method" value="BankTransfer" onclick="Paymentmethod()">
    <label class="Paymentpage-label" for="bank">Bank Transfer</label>

    <div id="cardDetails" class="carddetails" style="display:none;">
        <h3>Card Details</h3>
        <label class="Paymentpage-label" for="cardNumber">Card Number:</label>
        <input class="Paymentpage-input" type="number" id="cardNumber" name="cardNumber" >
        <br><br>
        <label class="Paymentpage-label" for="cvv">CVV:</label>
        <input class="Paymentpage-input" type="text" id="cvv" name="cvv" >
    </div><br><br>

    <input class="Paymentpage-submit" type="submit" value="BOOK NOW">
</form>

</body>
</html>

