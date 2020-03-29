package com.ps.producerservice;

import com.ps.producerservice.controller.LicenceCheckApi;
import com.ps.producerservice.model.LicenceCheckResponse;
import com.ps.producerservice.model.LicenceCheckRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenceCheckController {

    private final LicenceCheckService licenceCheckService;

    public LicenceCheckController(LicenceCheckService licenceCheckService) {
        this.licenceCheckService = licenceCheckService;
    }

    @GetMapping("/licence-check")
    public ResponseEntity<LicenceCheckResponse> getLicences(@RequestBody LicenceCheckRequest request){
        return licenceCheckService.licenceCheckPost(request);
    }

    @PostMapping("/licence-check")
    public ResponseEntity<LicenceCheckResponse> licenceCheckPost(@RequestBody LicenceCheckRequest request){
        return licenceCheckService.licenceCheckPost(request);
    }
}
