package com.example.demostudentsspringangular.services;

import com.example.demostudentsspringangular.entities.Payment;
import com.example.demostudentsspringangular.entities.PaymentStatus;
import com.example.demostudentsspringangular.entities.PaymentType;
import com.example.demostudentsspringangular.entities.Student;
import com.example.demostudentsspringangular.repository.PaymentRepository;
import com.example.demostudentsspringangular.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PaymentService {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    public Payment savePayment(MultipartFile file, LocalDate date , double amount, PaymentType type, String studentCode) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"att-data","payments");
        if(!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"att-data","payments",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath)  ;
        Student student = studentRepository.findByCode(studentCode);
        Payment payment = Payment.builder()
                .student(student)
                .date(date)
                .type(type)
                .amount(amount)
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED)
                .build();
        return paymentRepository.save(payment);
    }
    public Payment updatePaymentStatus(PaymentStatus status,Long id){
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
    public byte[] getPaymentFile(Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
