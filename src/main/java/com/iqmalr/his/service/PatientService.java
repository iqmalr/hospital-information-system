package com.iqmalr.his.service;

import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.PatientRequest;
import com.iqmalr.his.model.request.SearchPatientRequest;
import com.iqmalr.his.model.response.CommonResponse;
import com.iqmalr.his.model.response.PatientResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    CommonResponse<Patient> createPatient(PatientRequest patientRequest);

    CommonResponse<List<PatientResponse>> getAllPatients(Pageable pageable);

    CommonResponse<Patient> getPatientById(String id);

    CommonResponse<List<Patient>> searchPatients(SearchPatientRequest request, Pageable pageable);
}
