package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void taskClassTests() {
        Task task = new Task(1);
        Task task2 = new Task(1);
        Task task3 = null;

        Assertions.assertEquals(1, task.getId());
        Assertions.assertTrue(task.equals(task));
        Assertions.assertFalse(task.equals(task3));
        Assertions.assertTrue(task.equals(task2));

        int taskHash = task.hashCode();
        Assertions.assertEquals(taskHash, task2.hashCode());

        Assertions.assertFalse(task.matches(""));
    }

    @Test
    public void simpleTaskClassTests() {
        SimpleTask task1 = new SimpleTask(4, "Купить книгу");
        SimpleTask task2 = new SimpleTask(7, "Купить книгу");
        Assertions.assertTrue(task1.matches("Купить книгу"));
        Assertions.assertFalse(task1.matches("Купить сок"));

        Assertions.assertEquals("Купить книгу", task1.getTitle());
    }

    @Test
    public void epicClassTests() {
        String[] subtasks = {"Сходить в магазин",
                "Погладить котика," +
                        "Испечь блины"};
        Epic epic = new Epic(8, subtasks);
        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
        Assertions.assertTrue(epic.matches("Испечь блины"));
        Assertions.assertFalse(epic.matches("Купить мороженное"));
    }

    @Test
    public void meetingClassTest() {
        Meeting meeting = new Meeting(10, "Покупка шелкографа", "Открытие отдела шелкографии",
                "В понедельник после двух");
        Assertions.assertEquals("Покупка шелкографа", meeting.getTopic());
        Assertions.assertEquals("Открытие отдела шелкографии", meeting.getProject());
        Assertions.assertEquals("В понедельник после двух", meeting.getStart());
        Assertions.assertTrue(meeting.matches("Покупка шелкографа"));
        Assertions.assertTrue(meeting.matches("Открытие отдела шелкографии"));
        Assertions.assertFalse(meeting.matches("В понедельник после двух"));
    }
}
