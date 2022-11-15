import java.util.List;
import java.util.Scanner;

import dto.User;
import service.UserService;
import service.UserServiceIm;

public class App {
    public static void main(String[] args) throws Exception {
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserServiceIm();

        String userChoice = "";

        do {
            System.out.println("==================================");
            System.out.println("1. Create a New Student");
            System.out.println("2. Get All Students");
            System.out.println("3: Get Student By Id");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            System.out.println("==================================");

            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Enter Your ID : ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter Your name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Your Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your Student ID : ");
                    String Student_ID = scanner.nextLine();
                    System.out.print("Enter your Student Roll Number : ");
                    String Student_Rool_Number = scanner.nextLine();

                    if (email != null) {
                        System.out.println("Create a" + getName() + "was succssfuly ");
                    } else {
                        System.out.print("This Email or ID is already used ");
                    }
                    break;
                    // User user = new User( ID, name, email, Student_ID, Student_Rool_Number);
                    // userService.insert(user);
                    // break;

                case "2":
                    System.out.println("==================================");
                    displayUsers(userService.getAll());
                    System.out.println("==================================");

                case "3":
                System.out.println("==================================");
                // Its only for telling the users that this is the list, choose a user from the
                // given list
                displayUsers(userService.getAll());
                System.out.println("==================================");

                System.out.print("Enter Student ID : ");
                // Scanner retursn a string so we have to convert it to an integer in order to
                // query DB
                int id = Integer.parseInt(scanner.nextLine());
                User user3 = userService.getUserById(id);

                if (user3 != null) {
                    System.out.println("ID\tNAME\tLAST\tPASSWORD\tEMAIL");
                    System.out.println(user3);
                } else {
                    System.out.println("Student was not found!");
                }

                break;
                
                case "4":
                System.out.println("==================================");
                displayUsers(userService.getAll());
                System.out.println("==================================");

                System.out.println("Enter Student ID : ");
                id = Integer.parseInt(scanner.nextLine());
                User user4 = userService.getUserById(id);

                if (user4 != null) {
                    System.out.print("Enter new Student ID : ");
                    int newID = scanner.nextInt();
                    System.out.println("Enter new Student Name : ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new  Email : ");
                    String newEmail = scanner.nextLine();
                    System.out.println("Enter new Student ID number : ");
                    int newStudent_id = scanner.nextInt();
                    System.out.print("Enter new Student Roll Number : ");
                    int newStudent_Roll_number = scanner.nextInt();

                    user4.setID(newID);
                    user4.setName(newName);
                    user4.setEmail(newEmail);
                    user4.setStudent_ID(newStudent_id);
                    user4.setStudent_Roll_Number(newStudent_Roll_number);

                    userService.update(user4);
                } else {
                    System.out.println("Student not found!");
                }
                break;

            default:
                System.out.println("Invalid choice");


                case "5":
                    System.out.println("==================================");
                    displayUsers(userService.getAll());
                    System.out.println("==================================");
                    System.out.println("Enter Student ID : ");
                    // Scanner retursn a string so we have to convert it to an integer in order to
                    // query DB
                    id = Integer.parseInt(scanner.nextLine());
                    userService.delete(id);
                    break;

            }
        } while (!userChoice.equals("6"));
        scanner.close();
    }

    private static String getEmail() {
        return null;
    }

    private static String getName() {
        return null;
    }

    public static void displayUsers(List<User> users) {
        System.out.println("ID\tNAME\tEMAIL\tSTUDENT_ID\tSTUDENT_ROLL_NUMBER");
        for (User user : users) {
            System.out.print(user.getID() + "\t");
            System.out.print(user.getName() + "\t");
            System.out.print(user.getEmail() + "\t");
            System.out.print(user.getStudent_ID() + "\t");
            System.out.print(user.getStudent_Roll_Number() + "\t");
            System.out.println("\n");
        }
    }
}