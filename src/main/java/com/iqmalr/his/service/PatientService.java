package com.iqmalr.his.service;

import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.PatientRequest;
import com.iqmalr.his.model.response.CommonResponse;

public interface PatientService {
    CommonResponse<Patient> createPatient(PatientRequest patientRequest);
}
