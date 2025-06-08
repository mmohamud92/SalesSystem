# Basic Sales System

A simple Java-based sales application with a graphical user interface (GUI), designed to run within Eclipse. The application lets you:

- **Add** products or services, specifying:
  - Name
  - Price
  - Weight (if applicable)
  - Quantity
- **Process refunds** for previous transactions
- **Start a new customer session** (resets the interface)

---

## Prerequisites

- **Java Development Kit** (JDK) 8 or higher  
- **Eclipse IDE for Java Developers** (any recent version)

---

## Getting Started

1. **Clone or download** this repository to your local machine.  
2. **Launch Eclipse**, then **Import** the project:
   1. File ► Import…  
   2. Select **General ► Existing Projects into Workspace**  
   3. Browse to the folder containing this project  
   4. Finish

3. **Run the application**:
   1. In the **Package Explorer**, right-click the project  
   2. Choose **Run As ► Java Application**  
   3. The GUI window will appear

---

## Using the GUI

1. **Add Item**  
   - Enter a **product/service name**  
   - Specify the **price**  
   - (Optional) Enter a **weight** for weighed items  
   - Enter a **quantity**  
   - Click **Add** to include the item in the current sale

2. **Process Refund**  
   - Select or enter the item you wish to refund  
   - Click **Refund** to subtract it from the sale

3. **New Customer**  
   - Click **New Customer** to clear the current sale and start fresh

All totals and line-items update in real time as you add or refund items.

---

## Project Structure

- **src/**  
  Java source packages and classes  
- **lib/**  
  Third-party libraries (if any)  
- **.classpath**, **.project**  
  Eclipse project metadata

---

## Troubleshooting

- **GUI does not appear**  
  - Ensure you ran **Run As ► Java Application**  
  - Confirm your JDK is properly installed and configured in Eclipse

- **Compilation errors**  
  - Check that your Eclipse project’s **Java Build Path** is set to a compatible JDK  
  - Refresh the project (F5) and rebuild

---

## License

This project is released under the MIT License. Feel free to adapt and extend for your own learning!

---

**Enjoy managing your sales flows!**  
