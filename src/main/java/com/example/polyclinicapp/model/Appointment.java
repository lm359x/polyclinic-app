package com.example.polyclinicapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "date_of_appointment")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Дата не должна быть пустой.")
    @Future(message = "Дата не должна быть в прошлом")
    private Date date;


    @DateTimeFormat(pattern = "hh:mm")
    private String time;

    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
