package com.ps.producerservice;

import com.ps.producerservice.controller.LicenceCheckApi;
import com.ps.producerservice.model.LicenceCheckResponse;
import com.ps.producerservice.model.LicenceCheckRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LicenceCheckService {

    public ResponseEntity<LicenceCheckResponse> licenceCheckPost(LicenceCheckRequest request) {

        LicenceCheckResponse response = new LicenceCheckResponse();
        if((request.getLicenceNumber().doubleValue() - request.getLicenceNumber().intValue() ) > 0){
            response.setLicenceCheckStatus("ACTIVE");
        }else {
            response.setLicenceCheckStatus("INACTIVE");
            response.setRejectionReason("Licence is invalid");
        }
        response.setClientId(request.getClientId());
        response.setLicenceNumber(request.getLicenceNumber());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
