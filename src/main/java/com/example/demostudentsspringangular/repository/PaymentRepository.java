package com.example.demostudentsspringangular.repository;

import com.example.demostudentsspringangular.entities.Payment;
import com.example.demostudentsspringangular.entities.PaymentStatus;
import com.example.demostudentsspringangular.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus paymentStatus);
    List<Payment> findByType(PaymentType paymentType);

}
