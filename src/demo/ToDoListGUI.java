package demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ToDoListGUI {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;
    private ArrayList<String> rawTasks; 

    public ToDoListGUI() {
        JFrame frame = new JFrame("To-Do-List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        rawTasks = new ArrayList<>();

        preloadTasks();

        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel inputPanel = new JPanel(new FlowLayout());
        taskField = new JTextField(20);
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 7, 10));
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton reviewButton = new JButton("Review Tasks");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(reviewButton);
        buttonPanel.add(exitButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add Task
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                rawTasks.add(task);
                updateTaskList();
                taskField.setText("");
                JOptionPane.showMessageDialog(frame, "Task added successfully!");
            }
        });

        // Remove Task
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                rawTasks.remove(selectedIndex);
                updateTaskList();
                JOptionPane.showMessageDialog(frame, "Task removed successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to remove.");
            }
        });

        // Review Tasks
        reviewButton.addActionListener(e -> {
            if (rawTasks.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No tasks to show.");
            } else {
                StringBuilder tasks = new StringBuilder(" Your Tasks:\n");
                for (int i = 0; i < rawTasks.size(); i++) {
                    tasks.append((i + 1)).append(". ").append(rawTasks.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(frame, tasks.toString());
            }
        });

        // Exit
        exitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Thanks for using our todo list App");
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private void preloadTasks() {
        rawTasks.add("Running");
        rawTasks.add("Jumping");
        rawTasks.add("Coding");
        rawTasks.add("Fighting");
        rawTasks.add("Loving");
        rawTasks.add("Gaming");
       
        updateTaskList();
    }

    // Rebuilds the visible list with numbering
    private void updateTaskList() {
        listModel.clear();
        for (int i = 0; i < rawTasks.size(); i++) {
            listModel.addElement((i + 1) + ". " + rawTasks.get(i));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListGUI::new);
    }
}
