package UserCode;
import javax.swing.*;

import TaskCode.Task;
import TaskCode.ToDoList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * The ToDoListAppUI class is the class to show the ui to the user
 * It is how and what they interact with
 */
public class ToDoListAppUI extends JFrame{

    private ToDoList todoList;
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;

    //Initalise the todolist, defaultmodel and the jlist for the tasks
    public ToDoListAppUI(){
        todoList = new ToDoList();
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        //We add our "Add Task" button, allowing users to add their tasks
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            //Whenever the "Add Task" button is clicked we jump to the open dialog
            public void actionPerformed(ActionEvent e) {
                openAddTaskDialog();
            }
        });

        //We create a "Remove Completed Tasks" button, that allows users to clear all the completed tasks from the screen
        JButton removeButton = new JButton("Remove Completed Tasks");
        removeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCompletedTasks();
            }
        });

        //Here we create the main panel and add the JList to it with a scroll pane
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        //Here we create a panel to add and hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        //Here we add the button panel to the main panel, the south indicates we do this it at the bottom.
        panel.add(buttonPanel, BorderLayout.SOUTH);

        //Regular JFrame set up
        setTitle("ToDoList App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        add(panel);
        setVisible(true);

        //Setting up the context menu for marking the tasks as complete when the user right clicks on a task
        JPopupMenu contextMenu = new JPopupMenu();
        JMenuItem markAsCompletedItem = new JMenuItem("Mark as Completed");
        markAsCompletedItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskIsCompleted();
            }
        });
        contextMenu.add(markAsCompletedItem);
        taskList.setComponentPopupMenu(contextMenu);

        //Load tasks from the file on startup
        TaskFileManager.loadTasksFromFile("tasks.json", todoList);
        updateTaskListModel();
    }

    /**
     * Method to set the task as complete
     */
    private void taskIsCompleted(){
        Task currentTask = taskList.getSelectedValue();
        if(currentTask != null){
            currentTask.setCompleted(true);
            TaskFileManager.saveTasksToFile("tasks.json", todoList);
            updateTaskListModel();
        }
    }

    /**
     * This method pops up a window giving us the values for a new task
     * If one of the inputs of the task does not match the correct format
     * then we through an exception
     */
    private void openAddTaskDialog(){
        String name = JOptionPane.showInputDialog(this, "Enter task name:");
        String description = JOptionPane.showInputDialog(this, "Enter task description:");
        String dueDateStr = JOptionPane.showInputDialog(this, "Enter due date (yyyy-MM-dd):");
        String priorityStr = JOptionPane.showInputDialog(this, "Enter task priority (1-3):");

        try{
            LocalDate dueDate = LocalDate.parse(dueDateStr);
            int priority = Integer.parseInt(priorityStr);

            Task task = new Task(name, description, dueDate, priority);
            todoList.addTask(task);
            updateTaskListModel();
            TaskFileManager.saveTasksToFile("tasks.json", todoList);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Invalid input. The task was not added.");
        }
    }

    /**
     * Method to remove all completed tasks from the json file
     */
    private void removeCompletedTasks() {
        todoList.removeCompletedTasks();
        TaskFileManager.saveTasksToFile("tasks.json", todoList);
        updateTaskListModel();
    }

    /**
     * Method to update the tasklist whenever a task is added
     */
    private void updateTaskListModel(){
        taskListModel.clear();
        for (Task task : todoList.getTasks()){
            taskListModel.addElement(task);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ToDoListAppUI();
            }
        });
    }
}
