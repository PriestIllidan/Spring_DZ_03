package ru.chichkov.web;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskId(UUID id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public Task updateTask(UUID id, Task task) {
        Task taskUpdate = getTaskId(id);
        if (taskUpdate != null) {
            taskUpdate.setDescription(task.getDescription());
            taskUpdate.setName(task.getName());
            taskUpdate.setStatus(task.getStatus());
            taskUpdate.setCompletionTime(task.getCompletionTime());
        }
        return taskUpdate;
    }
}