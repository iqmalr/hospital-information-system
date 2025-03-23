package com.iqmalr.his.service.impl;

import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.PatientRequest;
import com.iqmalr.his.model.response.CommonResponse;
import com.iqmalr.his.model.response.PagingResponse;
import com.iqmalr.his.repository.PatientRepository;
import com.iqmalr.his.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public CommonResponse<List<Patient>> getAllPatients(Pageable pageable) {
        Page<Patient> patientPage = patientRepository.findAll(pageable);
        List<Patient> patients = patientPage.getContent();

        PagingResponse pagingResponse = PagingResponse.builder()
                .totalPages(patientPage.getTotalPages())
                .totalElement(patientPage.getTotalElements())
                .page(patientPage.getNumber())
                .size(patientPage.getSize())
                .hasNext(patientPage.hasNext())
                .hasPrevious(patientPage.hasPrevious())
                .build();

        return CommonResponse.<List<Patient>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("")
                .data(patients)
                .build();
    }
    @Override
    public CommonResponse<Patient> getPatientById(String id) {
        Optional<Patient> patient = patientRepository.findById(id);

        return patient.map(value -> CommonResponse.<Patient>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Patient retrieved successfully")
                .data(value)
                .build()
        ).orElseGet(() -> CommonResponse.<Patient>builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message("Patient not found")
                .build());
    }
}
