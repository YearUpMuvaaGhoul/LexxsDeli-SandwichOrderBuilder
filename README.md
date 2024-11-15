# Sandwich Order Builder- DELI-cIOUS APP

This is my second capstone project IN Pluralsights LearnToCodeAcademy 
This is a part of LC4- Code Blooded in YearUpUnited application development track- Java

## Project Description
This project is a console-based application that allows users to build custom sandwiches (or bonus: choose from a selection of Signature Sandwiches.)

Users can customize their orders with various toppings, drinks, and chips, and generate a detailed receipt.

## Features
- Build custom sandwiches with a variety of toppings. inlcuding premium and regular, as well as the option for extra cheeses and meats with an upcharge 
- Choose from pre-defined Signature Sandwiches (BLT and Philly Cheese Steak). -- This is an incomplete bonus
- Add drinks and chips to your order from a few different options
- Generate a detailed receipt with all items listed.

## Images of Application Screens
![Welcome Screen]![image](https://github.com/user-attachments/assets/c56f05f9-5b08-41c2-bff6-af59e84b532d)



![Order Screen]![image](https://github.com/user-attachments/assets/2af01713-0052-470b-9205-45b4ab7845ff)


![Receipt formatting at the end after confirming order and closing console]![image](https://github.com/user-attachments/assets/7f640793-7c1d-48e2-9826-f22093b45038)


## Interesting Code Snippet
```java
public void addTopping(Topping topping) {
    toppings.add(topping);
}
```
## !
This method allows you to add various toppings to your sandwich, showcasing the customizable nature of the application.

How to Run the Application

Clone the repository to your local machine.

Open the project in your preferred Java IDE.

Run the UserInterface class to start the application.

Follow the on-screen prompts to place your order.



Dependencies
Java Development Kit (JDK) 11 or higher
Intellij Idea 2024, 17.
Gitbash
Github repo


Concepts Used:
- Object Oriented Programming

- Hashmaps

- Inheritence

- Polymorphism
  
- Interface

- FileWriting 

- String Builder

- Date/Time Format


License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Contact
For any questions or feedback, please contact [Lexx Matula] at [amatula@appdev.yearup.com].

Thank you to Matthew Christenson and the Pluralsight instructor team as well as the entire YearUp United Staff and Cohort.

-------------------------------------------------------------------------------------------------------------------

Here is my diagram showing the flow of inheritence and classes ;

![image](https://github.com/user-attachments/assets/a75d454b-2a9e-4287-91a9-b257806c30a4)


Explanation

Item: Base class with attributes name and price.

Sandwich: Inherits from Item, includes attributes for size, bread type, toasted status, toppings, extra cheese, extra meat, and au jus sauce.

Drink: Inherits from Item, represents a drink with size.

Chips: Inherits from Item, represents chips with type.

Bread: Represents the type of bread for a sandwich.

Topping: Represents a sandwich topping with a name.

UserInterface: Manages user interactions, including taking orders, adding items, and customizing sandwiches.

Order: Manages a list of items (Item) and calculates the total cost of the order.


---------------------------------------------------------------------------------------------------------------------------

Ways to Improve or Future Enhancements

Combo Discount:
Add a 10% discount when a user chooses a combo (a drink, sandwich, and chips) in an order, with the ability to implement multiple combos available.

Error Handling:
Implement more error handling and exception throwing to make the application more robust.

Additional Sauces:
Provide more options for sauces beyond Au Jus, such as Consume, gravy, marinara, etc.

Adding Signature Sandwiches:
Simplify the process of adding new signature sandwiches without the need for special classes.

Special Offers:
Implement options for Sunday-only specials or seasonal/week-specific special offers. Discounts, or BOGO options, etc.

Returning customers:
The ability to re-order or have previous data from a returning customer for ease of ordering or quick-order options.

----------------------------------------------------------------------------------------------------

In this README file, I've included:
- A project description
- Application features
- Images of application screens
- An interesting piece of code from my project (`addTopping` method)
- Instructions on how to run the application
- Dependencies required
- License information
- Contact information
