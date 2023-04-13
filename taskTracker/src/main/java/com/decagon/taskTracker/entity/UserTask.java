package com.decagon.taskTracker.entity;


import com.decagon.taskTracker.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="userTask")
public class UserTask {
    @Id
    @GeneratedValue
    private  Long id;
    @Column(name="Title")
    private String title;
    @Column(name="Description")
    private String description;
    @Column(name="Status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name="Created_AT")
    private LocalDate createdAT;

    public UserTask(String title, String description){
        this.title = title;
        this.description = description;
        this.createdAT = LocalDate.now();
        this.status = Status.PENDING;
    }

}
