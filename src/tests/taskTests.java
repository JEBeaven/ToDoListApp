package tests;
import java.time.LocalDate;
import org.junit.Test;

import TaskCode.Task;
import org.junit.Assert;


public class taskTests {

    //Testing the isCompleted part of the task class
    @Test
    public void testTaskIsCompleted(){
        Task task = new Task("Test Task", "Test Desc", LocalDate.now(), 1);
        Assert.assertTrue(task.getCompleted() == false);
        task.setCompleted(true);
        Assert.assertTrue(task.getCompleted());
    }

    //Testing that tasks given a priority of 1< and >3 are given their correct values
    @Test
    public void testTaskPriority(){
        Task task1 = new Task("Test Task1", "Test Desc", LocalDate.now(), 0);
        Task task2 = new Task("Test Task2", "Test Desc", LocalDate.now(), 4);
        Assert.assertTrue(task1.getPriority() == 1 && task2.getPriority() == 3);
    }
}
