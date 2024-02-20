package org.deploy.deploytest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class LoopyController {

    @Value("${server.env}")
    private String env;

    @Value("${serverName}")
    private String serverName;

    @GetMapping("/hoo")
    public ResponseEntity<?> loopy() {

        Map<String, String> responseData = new TreeMap<>();
        responseData.put("serverName", serverName);
        responseData.put("env", env);

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getEnv() {

        return ResponseEntity.ok(env);
    }
}
