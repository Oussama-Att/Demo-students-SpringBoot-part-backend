package com.example.demostudentsspringangular;

import com.example.demostudentsspringangular.entities.Payment;
import com.example.demostudentsspringangular.entities.PaymentType;
import com.example.demostudentsspringangular.entities.Student;
import com.example.demostudentsspringangular.repository.PaymentRepository;
import com.example.demostudentsspringangular.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoStudentsSpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStudentsSpringAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("oussama")
                    .code("1010")
                    .lastName("attouch")
                    .programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("salah")
                    .code("1011")
                    .lastName("boukadi")
                    .programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("hamza")
                    .code("1111")
                    .lastName("yassine")
                    .programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("youssef")
                    .code("1000")
                    .lastName("attouch")
                    .programId("SDIA")
                    .build());

            PaymentType[] paymentType = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st->{
                for(int i = 0;i<10;i++){
                    int index = random.nextInt(paymentType.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()+2000))
                            .type(paymentType[index])
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };

    }

}
