package com.wira.EmployeeManagement.custom;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EventCustom {

    private String title;
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date eventDate;

}
