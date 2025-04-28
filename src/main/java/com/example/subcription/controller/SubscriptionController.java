package com.example.subcription.controller;

import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/iap" )
public class SubscriptionController {

    private static final String API_URL = "https://devapi.samsungapps.com/iap/seller/v6/applications/com.example.bookspot/purchases/subscriptions/jkfjs0fudfjsdk";
    private static final String ACCESS_TOKEN = "0DjT9yzrYUKDoGbVUlOnCUgQ";
    private static final String SERVICE_ACCOUNT_ID = "85412253-21b2-4d84-8ff5-4b0b6d86ad6e";

    private final OkHttpClient client = new OkHttpClient();

    @PatchMapping("/subscription")
    public ResponseEntity<String> cancelSubscription() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "{\"action\" : \"cancel\"}");

        Request request = new Request.Builder()
                .url(API_URL)
                .patch(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("service-account-id", SERVICE_ACCOUNT_ID)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return ResponseEntity.status(response.code()).body("Request failed: " + response.message());
            }
            return ResponseEntity.ok(response.body() != null ? response.body().string() : "Success");
        }
    }
}
