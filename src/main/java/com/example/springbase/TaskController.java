package com.example.springbase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TaskController {

    private Integer taskId = 0;
    private final List<Task> taskList;

    public TaskController() {
        this.taskList = new ArrayList<>();
        taskId++;
        taskList.add(new Task(1, "task1", "This is the task 1",new Date()));
        taskId++;
        taskList.add(new Task(2, "task2", "This is the task 2",new Date()));
        taskId++;
        taskList.add(new Task(3, "task3", "This is the task 3",new Date()));
    }

    @GetMapping("/Tasks")
    public List<Task> getTasks()
    {
        return taskList;
    }

    @PostMapping("/Tasks")
    Task createTask(@RequestBody Task task)
    {
        taskId++;
        var newTask = new Task(taskId, task.getTile(), task.getDescription(),task.getDueDate());
        taskList.add(newTask);
        return newTask;
    }

    @GetMapping("/Tasks/{id}")
    ResponseEntity<Task> getTask(@PathVariable("id") Integer id)
    {
        for(Task task : taskList)
        {
            if(task.id==id)
            {
                return new ResponseEntity<Task>(task, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/Tasks/{id}")
    ResponseEntity<Task> DeleteTask(@PathVariable("id") Integer id)
    {
        for(Task task : taskList)
        {
            if(task.id==id)
            {
                taskList.remove(task);
                return new ResponseEntity<Task>(task, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/Tasks/{id}")
    ResponseEntity<Task> UpdateTask(@PathVariable("id") Integer id,@RequestBody Task newTask)
    {
        for(Task currentTask : taskList)
        {
            if(currentTask.id==id)
            {
                currentTask.setDescription(newTask.getDescription());
                currentTask.setTile(newTask.getTile());
                currentTask.setDueDate(newTask.getDueDate());
                return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
    }


}
