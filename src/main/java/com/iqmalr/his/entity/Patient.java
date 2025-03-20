package com.iqmalr.his.entity;

import com.iqmalr.his.constant.Gender;
import com.iqmalr.his.constant.MaritalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="m_patients")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    private String phone;

    @Column(nullable = false, length = 255)
    private String province;

    @Column(nullable = false, length = 255)
    private String city;

    @Column(nullable = false, length = 255)
    private String district;

    @Column(nullable = false, length = 255)
    private String subDistrict;

    @Column(nullable = false, length = 255)
    private String addressDetail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaritalStatus maritalStatus;

    private String emergencyContact;
}
