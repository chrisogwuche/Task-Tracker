package com.decagon.taskTracker.dto;

import com.decagon.taskTracker.enums.Status;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTaskDto {
    private String id;
    private String title;
    private String description;
    private Status status;
    private LocalDate createdAT;


}
