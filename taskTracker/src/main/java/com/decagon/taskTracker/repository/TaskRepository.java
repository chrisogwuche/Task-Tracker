package com.decagon.taskTracker.repository;

import com.decagon.taskTracker.entity.UserTask;
import com.decagon.taskTracker.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<UserTask, Long> {
    UserTask save(UserTask userTask);
    List<UserTask> findByStatus(Status status);
    List<UserTask> findAll();

    Optional<UserTask> findById(Long id);

    void deleteById(Long id);
}
