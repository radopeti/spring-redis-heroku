package com.radopeti.springredisheroku.web.controller;

import com.radopeti.springredisheroku.web.service.ParkingService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ParkingService parkingService;
    private final CacheManager cacheManager;

    public TestController(ParkingService parkingService, CacheManager cacheManager) {
        this.parkingService = parkingService;
        this.cacheManager = cacheManager;
    }

    @GetMapping("/")
    public ResponseEntity<String> getHiOnIndexPage() {
        return ResponseEntity.ok("Hi on the index page!");
    }

    @GetMapping("/information")
    public ResponseEntity<String> getHi(@RequestParam("id") String id) {
        String information;
        if (cacheManager.getCache("itemCache").get(id) == null) {
            information = parkingService.getInformation("PlateNumber", "ABC123");
            cacheManager.getCache("itemCache").put(id, information);
        } else {
            information = (String) cacheManager.getCache("itemCache").get(id).get();
        }
        return ResponseEntity.ok(information);
    }

    @PostMapping("/evict")
    public ResponseEntity<Void> removeCacheId(@RequestParam("id") String id) {
        cacheManager.getCache("itemCache").evict(id);
        return ResponseEntity.ok().build();
    }

}
