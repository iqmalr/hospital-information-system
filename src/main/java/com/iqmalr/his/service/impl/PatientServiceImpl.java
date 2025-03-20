package com.iqmalr.his.service.impl;

import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.PatientRequest;
import com.iqmalr.his.model.response.CommonResponse;
import com.iqmalr.his.repository.PatientRepository;
import com.iqmalr.his.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public CommonResponse<Patient> createPatient(PatientRequest patientRequest) {
        Patient patient = Patient.builder()
                .fullName(patientRequest.getFullName())
                .birthDate(patientRequest.getBirthDate())
                .gender(patientRequest.getGender())
                .phone(patientRequest.getPhone())
                .province(patientRequest.getProvince())
                .city(patientRequest.getCity())
                .district(patientRequest.getDistrict())
                .subDistrict(patientRequest.getSubDistrict())
                .addressDetail(patientRequest.getAddressDetail())
                .maritalStatus(patientRequest.getMaritalStatus())
                .emergencyContact(patientRequest.getEmergencyContact())
                .build();

        patientRepository.save(patient);
        return CommonResponse.<Patient>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Patient created successfully")
                .data(patient)
                .build();
    }
}
