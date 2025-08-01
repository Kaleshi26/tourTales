<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TourTales</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<!-- Navbar -->
	<header class="navbar">
		<div class="container">
			<h1 class="logo">TourTales</h1>
			<nav>
				<ul>
					<li><a href="home">Home</a></li>
					<li><a href="tour-packages">Packages</a></li>
					<li><a href="contactus">Contact</a></li>

					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<!-- Show Sign In link if user is not logged in -->
							<li><a href="login">Sign In</a></li>
						</c:when>
						<c:otherwise>
							<!-- Show Profile link if user is logged in -->
							<li><a href="profile">Profile</a></li>
						</c:otherwise>
					</c:choose>



				</ul>
			</nav>
		</div>
	</header>
	<main>