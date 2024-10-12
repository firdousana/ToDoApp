package com.example.ToDo.App.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDo.App.models.TodoItem;


@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long>{

}

