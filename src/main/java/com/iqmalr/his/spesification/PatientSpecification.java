package com.iqmalr.his.spesification;
import com.iqmalr.his.entity.Patient;
import com.iqmalr.his.model.request.SearchPatientRequest;
import org.springframework.data.jpa.domain.Specification;
public class PatientSpecification {
    public static Specification<Patient> getSpecification(SearchPatientRequest request) {
        return (root, query, criteriaBuilder) -> {
            Specification<Patient> spec = Specification.where(null);

            if (request.getFullName() != null && !request.getFullName().isEmpty()) {
                spec = spec.and((root1, query1, cb) -> cb.like(cb.lower(root1.get("fullName")), "%" + request.getFullName().toLowerCase() + "%"));
            }
            if (request.getPhone() != null && !request.getPhone().isEmpty()) {
                spec = spec.and((root1, query1, cb) -> cb.like(root1.get("phone"), "%" + request.getPhone() + "%"));
            }
            if (request.getGender() != null) {
                spec = spec.and((root1, query1, cb) -> cb.equal(root1.get("gender"), request.getGender()));
            }
            if (request.getProvince() != null && !request.getProvince().isEmpty()) {
                spec = spec.and((root1, query1, cb) -> cb.like(root1.get("province"), "%" + request.getProvince() + "%"));
            }
            if (request.getMaritalStatus() != null) {
                spec = spec.and((root1, query1, cb) -> cb.equal(root1.get("maritalStatus"), request.getMaritalStatus()));
            }
            if (request.getEmergencyContact() != null && !request.getEmergencyContact().isEmpty()) {
                spec = spec.and((root1, query1, cb) -> cb.like(root1.get("emergencyContact"), "%" + request.getEmergencyContact() + "%"));
            }

            return spec.toPredicate(root, query, criteriaBuilder);
        };
    }
}
