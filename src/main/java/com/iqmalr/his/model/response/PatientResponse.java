package com.iqmalr.his.model.response;

import com.iqmalr.his.constant.Gender;
import com.iqmalr.his.constant.MaritalStatus;
import com.iqmalr.his.entity.Patient;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private String id;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String subDistrict;
    private String addressDetail;
    private MaritalStatus maritalStatus;
    private String emergencyContact;

    public static PatientResponse fromEntity(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .fullName(patient.getFullName())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .phone(patient.getPhone())
                .province(patient.getProvince())
                .city(patient.getCity())
                .district(patient.getDistrict())
                .subDistrict(patient.getSubDistrict())
                .addressDetail(patient.getAddressDetail())
                .maritalStatus(patient.getMaritalStatus())
                .emergencyContact(patient.getEmergencyContact())
                .build();
    }
}