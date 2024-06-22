package com.snhu.sslserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class HashController {

    @GetMapping("/hash")
    public String getHash(@RequestParam String input, @RequestParam String algorithm) throws NoSuchAlgorithmException {
        return HashUtil.generateHash(input, algorithm);
    }

    // New route for static data checksum
    @GetMapping("/checksum")
    public String getChecksum() throws NoSuchAlgorithmException {
        String data = "Hello World Check Sum!";
        return HashUtil.generateHash(data, "SHA-256");
    }
}
