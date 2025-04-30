import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // preload tasks
        tasks.add("Running");
        tasks.add("Jumping");
        tasks.add("Coding");
        tasks.add("Fighting");
        tasks.add("Loving");
        tasks.add("Gaming");
      

        String option;
        int choice;
        int count;

        System.out.println("\n\n\t\t\t✨ Bingooh To-Do List ✨\n");

        while (true) {
            // Main Menu
            System.out.println("\n1. Add Task\n2. Remove Task\n3. Review Tasks\n4. Exit");
            System.out.print("Your input here: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("\nType out the task you want to add: ");
                        String addTask = input.nextLine();
                        tasks.add(addTask);
                        System.out.println("✅ Task added successfully!");

                        System.out.print("Do you want to add another task? (y/n): ");
                        option = input.nextLine().toLowerCase();

                        if (!option.equals("y")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        //When there is no task
                        if (tasks.isEmpty()) {
                            System.out.println("⚠️ No tasks to remove.");
                            break;
                        }

                        // show tasks
                        System.out.println("\n\t=========================");
                        System.out.println("\t\tYour Tasks");
                        System.out.println("\t=========================\n");
                        count = 1;
                        for (String task : tasks) {
                            System.out.println(count++ + ". " + task);
                        }

                        // remove task by number
                        System.out.print("\nEnter the task number to remove: ");
                        int taskNumber = input.nextInt();
                        input.nextLine(); // consume newline

                        if (taskNumber > 0 && taskNumber <= tasks.size()) {
                            tasks.remove(taskNumber - 1);
                            System.out.println("✅ Task removed successfully!");
                        } else {
                            System.out.println("❌ Invalid task number.");
                        }

                        System.out.print("Do you want to remove another task? (y/n): ");
                        option = input.nextLine().toLowerCase();
                        if (!option.equals("y")) break;
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("\n📭 No tasks found.");
                    } else {
                        System.out.println("\n\t=========================");
                        System.out.println("\t\tYour Tasks");
                        System.out.println("\t=========================\n");
                        count = 1;
                        for (String task : tasks) {
                            System.out.println(count++ + ". " + task);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n🙏 Thanks for using Bingooh! Stay productive, Gimbo 👑");
                    input.close();
                    return;

                default:
                    System.out.println("❌ Invalid input.");
                    break;
            }
        }
    }
}
