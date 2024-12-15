# Automated Coffee Shop Management System

The **Automated Coffee Shop Management System** is a Java-based console application designed to streamline the management of a coffee shop. This system caters to two main users: the **Admin (Shop Owner)** and **Customers**, offering functionalities to automate routine operations while ensuring data persistence through file handling.  

## Features

### **1. Admin Features**
- **Login Authentication**  
  Admins must enter a valid password to access the system.
  
- **Menu Management**  
  - Add, update, or delete menu items.  
  - Update item prices and stock.  
  - View the current menu.  

- **Sales Report Management**  
  - View and review sales reports generated from customer orders.  
  - Clear sales reports.  
  - Access and analyze customer information.  

- **Stock Management**  
  Automatically updates stock levels based on customer orders.  

---

### **2. Customer Features**
- **View Menu**  
  Customers can browse available menu items and their prices.  

- **Place Orders**  
  Customers can select items, specify quantities, and place their orders.  

- **Payment Options**  
  - Supports both card and cash payments.  
  - Calculates change for cash transactions.  

- **Order History**  
  - Order details are saved for future reporting.  
  - Customer information is stored for analysis and reporting.  

---

### **3. Data Persistence**
This system utilizes file handling for data storage and retrieval, ensuring reliability across sessions:
- **`menu.txt`**: Stores menu details (item name, price, and stock levels).  
- **`order.txt`**: Records customer orders for sales reports and tracking.  
- **`customer.txt`**: Stores customer information.  

---

## Class Structure

### **1. Main Class**
Manages the navigation between admin and customer functionalities.

### **2. Person Class**
A superclass for both `Admin` and `Customer`, storing common attributes like name.

### **3. Admin Class**
Inherits from `Person` and includes methods for:  
- Managing the menu.  
- Reviewing customer orders and information.  
- Analyzing sales reports.  

### **4. Customer Class**
Inherits from `Person` and includes methods for:  
- Viewing the menu.  
- Placing orders.

### **5. Menu Class**
Handles menu operations:
- Displays, adds, updates, and deletes menu items.  
- Updates prices and stock.  
- Saves and retrieves menu details from `menu.txt`.  

### **6. MenuItem Class**
Stores details about individual items, such as:  
- Name  
- Price  
- Stock level  

### **7. TakeOrder Class**
Processes customer orders:  
- Handles order creation.  
- Updates stock levels.  
- Calculates payment totals and processes payments.  

### **8. ShopDetails Class**
Stores and displays shop information like name, address, and contact details.  

---

## Key Functionalities
### **Admin**
- Menu management (add/update/delete items, adjust stock, and prices).  
- View and clear sales reports.  
- Analyze customer orders and information.  

### **Customer**
- View the menu and place orders.  
- Make payments via cash or card.  
- Save order history and customer information for future reference.  

---

## How to Run
1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/automated-coffee-shop.git
   ```
2. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse).  
3. Compile and run the `Main` class to start the system.  
4. Follow the console prompts to navigate as an admin or customer.

---

## Future Enhancements
- Introduce a graphical user interface (GUI) for better usability.  
- Add support for discount codes and loyalty programs.  
- Integrate with a database for scalable data management.  

---

## Contributing
Contributions are welcome! To contribute:
1. Fork this repository.  
2. Create a feature branch:  
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:  
   ```bash
   git commit -m "Add feature"
   ```
4. Push to your branch and submit a pull request.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.  

---

Developed with ❤️ to automate coffee shop operations and ensure efficiency.
