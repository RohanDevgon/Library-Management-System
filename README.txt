# Library Management System

This Java program is a simple library management system that allows librarians and members to interact with a library database. The system is designed to manage books, members, and book borrowing activities. Below is a brief overview of the program and its functionality.

## Features

### For Librarians

1. *Register a Member:* Librarians can register new members by providing their name, age, and phone number. Each member is assigned a unique ID.

2. *Remove a Member:* Librarians can remove a member from the system by specifying their member ID.

3. *Add a Book:* Librarians can add books to the library database. They need to provide the book title, author, and the number of copies to add. Each book is assigned a unique ID.

4. *Remove a Book:* Librarians can remove a book from the library database by specifying its ID.

5. *View Members and Their Books:* Librarians can view a list of all members along with the books they have borrowed and any fines they need to pay.

6. *View All Books:* Librarians can view a list of all books in the library database.

### For Members

1. *List Available Books:* Members can view a list of all available books in the library that they can borrow.

2. *List My Books:* Members can view the books they have currently borrowed.

3. *Issue Book:* Members can borrow a book by specifying the book ID. They can only borrow up to two books at a time, and the book must be available.

4. *Return Book:* Members can return a book they have borrowed by specifying the book ID.



## Getting Started

1. When you run the program, you will be prompted to enter as either a librarian (option 1) or a member (option 2).

2. Librarians can perform librarian-specific actions, and members can access member-specific actions.

3. Follow the on-screen prompts to perform actions such as adding members, adding books, borrowing books, and more.

## Code Structure

- `Main.java`: Contains the main program logic, including menu-driven interactions for librarians and members.

- `book.java`: Defines the `book` class, representing book objects with attributes like ID, title, author, availability, and total copies.

- `member.java`: Defines the `member` class, representing member objects with attributes like phone number, age, name, member ID, and a list of borrowed books.

## Additional Notes

- This program is designed as a console application and does not have a graphical user interface.



- Make sure to close the program properly when you are done to release any resources.






