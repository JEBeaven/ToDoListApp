package tests;
import java.time.LocalDate;
import org.junit.Test;

import TaskCode.Task;
import TaskCode.ToDoList;

import org.junit.Assert;


public class ToDoListTests {
    Task task1 = new Task("Test Task1", "Test Desc", LocalDate.now(), 1);
    Task task2 = new Task("Test Task2", "Test Desc", LocalDate.now(), 2);
    Task task3 = new Task("Test Task3", "Test Desc", LocalDate.now(), 3);
    Task task4 = new Task("Test Task4", "Test Desc", LocalDate.now(), 2);
    ToDoList toDoList = new ToDoList();

    //ToDoListTests constructor test
    @Test
    public void addTaskTest(){
        toDoList.addTask(task1);
        Assert.assertTrue(toDoList.size() == 1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        Assert.assertTrue(toDoList.size() == 4);
    }

    @Test
    public void removeTaskTest(){
        toDoList.addTask(task1);
        Assert.assertTrue(toDoList.size() == 1);
        toDoList.removeTask(task1);
        Assert.assertTrue(toDoList.size() == 0);
    }
}
