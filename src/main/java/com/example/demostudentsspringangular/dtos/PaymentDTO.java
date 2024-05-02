package com.example.demostudentsspringangular.dtos;

import com.example.demostudentsspringangular.entities.PaymentStatus;
import com.example.demostudentsspringangular.entities.PaymentType;
import com.example.demostudentsspringangular.entities.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}
