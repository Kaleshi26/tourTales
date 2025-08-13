# 🏕 CampEase – Online Camping Gear Rental Management System

**CampEase** is a full-stack MERN (MongoDB, Express.js, React.js, Node.js) web application designed to modernize and streamline the camping gear rental process.
It provides real-time inventory management, secure booking, integrated payments, and role-based access for customers, staff, and admins.

## ✨ Features

### 🔹 Core Functionalities

### 👤 User Management
- Secure registration & login with **email verification**
- Role-based access (Admin, Staff, Customer)
- Profile management & rental history
- Activity logs and account controls

### 📦 Inventory & Maintenance
- Real-time gear availability tracking
- Gear categories (tents, sleeping bags, stoves, etc.)
- Low-stock & damage alerts
- Maintenance scheduling and history

### 📅 Rental & Reservation
- Instant availability checks
- Booking with flexible dates
- Modify or cancel reservations
- Damage/late return fee handling

### 💳 Finance Management
- Integrated secure payment gateway
- Automated invoices & receipts
- Refund processing
- Revenue & expense reports

### 📢 Marketing Management
- Create & schedule promotions
- Email/SMS notifications
- Social media integration
- Loyalty points & customer feedback


## 🛠️ Tech Stack

**Frontend:**

* React.js – Dynamic, responsive UI
* HTML5, CSS3, JavaScript (ES6+)

**Backend:**

* Node.js – Server-side runtime
* Express.js – API routing & middleware

**Database:**

* MongoDB – NoSQL database with flexible schema

**Other Tools & Services:**

* GitHub – Version control & collaboration
* Visual Studio Code – Development environment
* Payment Gateway Integration – Secure transactions
* Email/SMS API – Automated communication


## 📐 System Architecture

* **High-Level Design:** MERN stack architecture with modular backend and role-based dashboards.
* **Role-Based Dashboards:**

  * Admin Dashboard – Full control over users, inventory, and reports
  * Finance Manager Dashboard – Payment tracking & reporting
  * Inventory Manager Dashboard – Stock management
  * Reservation Manager Dashboard – Booking management
  * Marketing Manager Dashboard – Campaign control

---

## 📊 Modules Overview

| Module                      | Key Features                                                 |
| --------------------------- | ------------------------------------------------------------ |
| **User Management**         | Registration, login, profile updates, role assignments       |
| **Inventory & Maintenance** | Add/update/remove gear, track conditions, maintenance alerts |
| **Rental & Reservation**    | Real-time booking, availability checks, cancellations        |
| **Finance Management**      | Payment handling, refunds, revenue reports                   |
| **Marketing Management**    | Promotions, campaigns, notifications, loyalty programs       |



## 🔄 Workflows

1. **Customer**

   * Register → Browse Gear → Reserve → Pay → Pickup → Return → Give Feedback
2. **Staff**

   * Manage Inventory → Approve Rentals → Monitor Payments → Handle Returns
3. **Admin**

   * Oversee all modules → Generate Reports → Manage Users & Roles



## 🧪 Testing

* **Unit Testing** – Verified core functionalities (login, booking, payment, etc.)
* **Integration Testing** – Checked module interactions
* **UAT (User Acceptance Testing)** – Approved by stakeholders after real-world trials
* ✅ All critical workflows tested and passed



## 📂 Project Structure

/client         # React frontend
/server         # Node.js + Express backend
/models         # Mongoose schemas
/routes         # API endpoints
/controllers    # Business logic
/config         # Database & environment configs



