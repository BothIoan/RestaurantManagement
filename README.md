# RestaurantManagement

## Users 
There are 3 types of users

__Admin__
Can do CRUD on menu items

__Waiter__
Can create an order that includes the table and the desired menu items. He also can compute the bill for an order.

__Chef__
He is notified when recieving an order. He can see orders in a table.

## Implementation

* The Three Layered architecture is used.
* The project aims to be an exercice for :
  * The Observer design pattern (The chef is notified at orders)
  * The composite design pattern (Menu items are composed of other menu items)
  * Serialization (Data is stored in .ser files)
