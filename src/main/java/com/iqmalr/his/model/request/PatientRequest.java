package com.iqmalr.his.model.request;

import com.iqmalr.his.constant.Gender;
import com.iqmalr.his.constant.MaritalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    @NotNull(message = "Gender is required")
    private Gender gender;

    private String phone;

    @NotBlank(message = "Province is required")
    private String province;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "District is required")
    private String district;

    @NotBlank(message = "Sub-district is required")
    private String subDistrict;

    @NotBlank(message = "Address detail is required")
    private String addressDetail;

    @NotNull(message = "Marital status is required")
    private MaritalStatus maritalStatus;

    private String emergencyContact;
}
