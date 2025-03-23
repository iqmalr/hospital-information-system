package com.iqmalr.his.model.request;

import com.iqmalr.his.constant.Gender;
import com.iqmalr.his.constant.MaritalStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchPatientRequest {
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

    private Integer page = 1;
    private Integer size = 10;
    private String sortBy = "fullName";
    private String direction = "ASC";
}
