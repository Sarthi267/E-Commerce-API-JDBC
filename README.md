## E-Commerce API
***
### Spring Data JDBC Demo  
This project is a demo for JDBC, it implements basic SQL such as tables, a function, and triggers. Apart from the basic entities with their repositories and controllers, there's also a custom JOIN segment of the code that allows the user to query for key details regarding the order and product information.
***
### Description of the Project  
This project is an e-commerce API that is modeled for sellers to post listings for products and users to purchase them and have their purchase recorded as part of the order entity. The SQL schema creates all the tables upon running the program, and fields that specify when they were last updated get changed accordingly from their respective triggers. As stated earlier this project includes a custom JOIN query that gathers important information regarding order and product details (accessible at GET /order-details), however there are many HTTP endpoints available for several methods of filtering data.
***
### Prerequisites   

- Java 21
- Maven
- PostgreSQL  
***
### How to Run

1. Install and start PostgreSQL  
2. Create a database named ecommerce
3. Clone the repository
4. Copy application.example.properties to application.properties and fill your password
5. mvn spring-boot:run  
***
### Notes 

- The schema creates itself so there's no manual setup there
