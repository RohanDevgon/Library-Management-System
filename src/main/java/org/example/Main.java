package org.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int enter;
        HashMap<Integer, book> books = new HashMap<>();
        HashMap<Integer, member> bhailog = new HashMap<>();
        int iterate = 1;
        int memberid = 1;

        System.out.println("Library Portal Initialized….");
        while (true) {
            System.out.println("------------------");
            System.out.println("1.   Enter as a librarian");
            System.out.println("2.   Enter as a member");
            System.out.println("3.   Exit");
            System.out.println("------------------");

            enter = scan.nextInt();
            scan.nextLine();

            if (enter == 1) {
                System.out.println("You chose to enter as a librarian.");

                while (true) {
                    System.out.println("1. Register a member");
                    System.out.println("2. Remove a member");
                    System.out.println("3. Add a book");
                    System.out.println("4. Remove a book");
                    System.out.println("5. View all members along with their books and fines to be paid");
                    System.out.println("6. View all books");
                    System.out.println("7. Back");
                    int lenter = scan.nextInt();
                    scan.nextLine();

                    if (lenter == 1) {
                        System.out.print("Name: ");
                        String namee = scan.nextLine();
                        System.out.print("Age: ");
                        int age = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Phone: ");
                        long phone = scan.nextLong();
                        scan.nextLine();
                        ArrayList<book> mybook = new ArrayList<book>();

                        member m = new member(phone, age, namee, memberid, mybook);

                        bhailog.put(memberid, m);

                        System.out.println("Member successfully added with " + memberid + "!");
                        memberid++;
                    } else if (lenter == 7) {
                        break;

                    } else if (lenter == 2) {
                        System.out.print("Member ID: ");
                        int iddd = scan.nextInt();
                        scan.nextLine();
                        bhailog.remove(iddd);
                        System.out.println("Member removed successfully!");
                    } else if (lenter == 3) {
                        System.out.print("1. Book title: ");
                        String bkname = scan.nextLine();
                        System.out.print("2. Author: ");
                        String author = scan.nextLine();
                        System.out.print("3. Copies: ");
                        int copy = scan.nextInt();
                        scan.nextLine();

                        for (int i = 0; i < copy; i++) {

                            book booktoadd = new book(iterate, bkname, author, 0, 1);

                            books.put(iterate, booktoadd);
                            iterate++;
                            booktoadd.avail=1;

                            System.out.println("Book added successfully!");
                        }
                    } else if (lenter == 4) {
                        System.out.print("Enter Book Id: ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        books.remove(id);
                        System.out.println("Book removed successfully!");

                    } else if (lenter == 5) {
                        for (int memberId : bhailog.keySet()) {
                            System.out.println("Member ID - " + memberId);
                            member member = bhailog.get(memberId);
                            System.out.println("Name - " + member.name);
                            ArrayList<book> memberBooks = member.myBooks;

                            if (!memberBooks.isEmpty()) {
                                System.out.println("Books issued:");
                                for (book book : memberBooks) {
                                    System.out.println("  - " + book.name);
                                }
                            } else {
                                System.out.println("No books issued.");
                            }

                            System.out.println();
                        }
                    } else if (lenter == 6) {
                        System.out.println("All books: ");

                        for (int idd : books.keySet()) {
                            System.out.println("book id - " + idd);
                            book b = books.get(idd);
                            System.out.println("Name - " + b.name);
                            System.out.println("author - " + b.author);
                            System.out.println();
                        }

                    } else {
                        System.out.println("Choose the correct option.");
                    }
                }
            } else if (enter == 3) {
                System.out.println("Exiting the Library Portal.");
                break;
            } else if (enter == 2) {
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Phone no: ");
                Long phone = scan.nextLong();
                scan.nextLine();
                boolean membercheck = false;
                int mi = -1;

                for (int mem : bhailog.keySet()) {
                    member m = bhailog.get(mem);

                    if (m.name.equals(name) && m.phone == phone) {
                        mi = mem;
                        break;
                    }
                }

                if (mi != -1) {
                    while (true) {
                        System.out.println("You chose to enter as a member.");
                        System.out.println("1. List Available Books");
                        System.out.println("2. List My Books");
                        System.out.println("3. Issue Book");
                        System.out.println("4. Return Book");
                        System.out.println("5. Pay Fine");
                        System.out.println("6. Back");
                        System.out.println("------------------");
                        int action = scan.nextInt();
                        scan.nextLine();
                        System.out.println("------------------");


                        if (action == 1) {
                            ArrayList<Integer> borrowedBookIds = new ArrayList<>();

                            for (member member : bhailog.values()) {
                                for (book book : member.myBooks) {
                                    borrowedBookIds.add(book.id);
                                }
                            }

                            System.out.println("All available books:");

                            for (book book : books.values()) {
                                if (!borrowedBookIds.contains(book.id)) {
                                    System.out.println("Book ID - " + book.id);
                                    System.out.println("Name - " + book.name);
                                    System.out.println("Author - " + book.author);
                                    System.out.println();
                                }
                            }
                        } else if (action == 7) {
                            break;

                        } else if (action == 3) {
                            System.out.print("Enter the Book ID you want to issue: ");
                            int bookIdToIssue = scan.nextInt();
                            scan.nextLine();

                            if (books.containsKey(bookIdToIssue)) {
                                book bookToIssue = books.get(bookIdToIssue);

                                // Check if the book is available
                                if (bookToIssue.avail > 0) {
                                    member me = bhailog.get(mi);

                                    // Check if the member hasn't already borrowed the book
                                    boolean alreadyBorrowed = false;
                                    for (book memberBook : me.myBooks) {
                                        if (memberBook.id == bookIdToIssue) {
                                            alreadyBorrowed = true;
                                            break;
                                        }
                                    }

                                    if (!alreadyBorrowed) {
                                        // Check if the member hasn't exceeded the maximum limit
                                        if (me.myBooks.size() < 2) {
                                            me.myBooks.add(bookToIssue);
                                            bookToIssue.avail--;
                                            System.out.println("Book issued successfully!");
                                        } else {
                                            System.out.println("You have already borrowed the maximum number of books (2).");
                                        }
                                    } else {
                                        System.out.println("You have already borrowed this book.");
                                    }
                                } else {
                                    System.out.println("Sorry, this book is not available for borrowing.");
                                }
                            } else {
                                System.out.println("Invalid Book ID.");
                            }

                            // Add a break statement here to exit the loop
                            break;
                        }

                        else if (action == 4) {
                            System.out.print("Enter the Book ID you want to return: ");
                            int bookIdToReturn = scan.nextInt();
                            scan.nextLine();

                            if (books.containsKey(bookIdToReturn)) {
                                book bookToReturn = books.get(bookIdToReturn);
                                member m = bhailog.get(mi);

                                boolean hasBorrowed = false;
                                for (book memberBook : m.myBooks) {
                                    if (memberBook.id == bookIdToReturn) {
                                        hasBorrowed = true;
                                        break;
                                    }
                                }

                                if (hasBorrowed) {
                                    m.myBooks.removeIf(memberBook -> memberBook.id == bookIdToReturn);
                                    bookToReturn.avail++; // Increase availability
                                    System.out.println("Book returned successfully!");
                                } else {
                                    System.out.println("You haven't borrowed this book.");
                                }
                            } else {
                                System.out.println("Invalid Book ID.");
                            }
                        }
                        else if (action == 5) {
                            // Implement the logic for paying a fine
                        } else if (action == 6) {
                            break;
                        } else {
                            System.out.println("Choose the correct option.");
                        }

                    }
                } else {
                    System.out.printf("Member with name: %s and phone no: %d doesn't exist\n", name, phone);
                }
            }
        }
        scan.close();
    }
}

