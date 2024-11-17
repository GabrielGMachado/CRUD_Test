import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreatDataBase.createTable();

        String[] choose = {"View the table", "Add a person", "Edit a person", "Delete a person", "Logout"};
        System.out.println("Hello everyone, this is a CRUD (create, read, update and delete) project .");

        while (true) {
            System.out.println("Choose one of the options:");
            for (int i = 0; i < choose.length; i++) {
                System.out.println((i + 1) + ". " + choose[i]);
            }

            int is = ReadInt("Choose: ");

            switch (is) {
                case 1:
                    ViewTheTable.View();
                    break;
                case 2:
                    AddAPerson.creatAPerson();
                    break;
                case 3:
                    EditAPerson.editPerson();
                    break;
                case 4:
                    DeleteAPerson.delete();
                    break;
                case 5:
                    return;
            }


        }
    }

    public static int ReadInt (String prompt) {
        Scanner scanner = new Scanner(System.in);
        int result;

        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();

                if (result > 0 && result < 6) {
                    return result;
                } else {
                    System.out.print("Invalid input. Please enter a number between 1 and 4.");
                }
            }
        }

    }
}