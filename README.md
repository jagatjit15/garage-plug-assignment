# garage-plug-assignment
> This springboot project is just to register a new Customer and confirm order (It is
assumed that customer has already made the payment while creating the order).

## Entity classes
> ### Customer :- It is for storing user/customer data to the database.
> ### Order :- to store discountvalue and keeping track of orders of a customer.
> ### CustomerDAO :- To take the user data for registering user in the form of JSON.

### TechsUsed
- SpringBoot
- DATA JPA
- JAVA
- Validation
- Mysql

<br>

> # API / Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`

`http://localhost:8888/swagger-ui/garageplug/users`

`http://localhost:8888/swagger-ui/garageplug/users/register`

- (for registering a customer)
   -required emailId, phoneNumber, password, firstName, lastName.

`http://localhost:8888/swagger-ui/garageplug/users/cart`
- (for confirming an order)
   required EmailId

<br>

