package UserCode;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import TaskCode.Task;
import TaskCode.ToDoList;

/**
 * The TaskFileManager class is used to save and load the todoLists to a json file
 */
public class TaskFileManager {
/**
 * Given a specific file name and a todoList, save the todoList to said file in json
 * @param fileName
 * @param todoList
 */
    public static void saveTasksToFile(String fileName, ToDoList todoList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task task : todoList.getTasks()) {
                writer.write(task.getName() + "," + task.getDescription() + "," + task.getDueDate() + "," + task.getPriority());
                writer.newLine();
            }
            System.out.println("The tasks where saved to the file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * Given a specific fle name and the todoList name, load the todoList into the app
 * @param fileName
 * @param todoList
 */
    public static void loadTasksFromFile(String fileName, ToDoList todoList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                String name = taskData[0];
                String description = taskData[1];
                LocalDate dueDate = LocalDate.parse(taskData[2]);
                int priority = Integer.parseInt(taskData[3]);

                Task task = new Task(name, description, dueDate, priority);
                todoList.addTask(task);
            }
            System.out.println("Loaded tasks from the file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
