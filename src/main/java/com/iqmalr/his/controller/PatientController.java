package com.iqmalr.his.controller;

import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.PatientRequest;
import com.iqmalr.his.model.request.SearchPatientRequest;
import com.iqmalr.his.model.response.CommonResponse;
import com.iqmalr.his.model.response.PatientResponse;
import com.iqmalr.his.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
@Tag(name = "Patient API", description = "API untuk mengelola data pasien")
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    @Operation(
            summary = "Membuat pasien baru",
            description = "Membuat data pasien baru dalam sistem",
            responses = {
                    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
            }
    )
    public ResponseEntity<CommonResponse<Patient>> createPatient(@Valid @RequestBody PatientRequest patientRequest) {
        CommonResponse<Patient> response = patientService.createPatient(patientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(
            summary = "Mendapatkan daftar pasien",
            description = "Mengambil semua data pasien dengan pagination",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
            }
    )
    public ResponseEntity<CommonResponse<List<PatientResponse>>> getAllPatients(Pageable pageable) {
        CommonResponse<List<PatientResponse>> response = patientService.getAllPatients(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Mendapatkan pasien berdasarkan ID",
            description = "Mengambil data pasien berdasarkan ID yang diberikan",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
                    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
            }
    )
    public ResponseEntity<CommonResponse<Patient>> getPatientById(@PathVariable String id) {
        CommonResponse<Patient> response = patientService.getPatientById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/search")
    @Operation(
            summary = "Mencari pasien berdasarkan filter",
            description = "Mencari pasien berdasarkan kriteria pencarian tertentu",
            responses = {
                    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonResponse.class)))
            }
    )
    public ResponseEntity<CommonResponse<List<Patient>>> searchPatients(
            @RequestBody SearchPatientRequest request,
            Pageable pageable
    ) {
        CommonResponse<List<Patient>> response = patientService.searchPatients(request, pageable);
        return ResponseEntity.ok(response);
    }
}
