package com.example.controller;

import com.example.exception.ResourceExceptionHandler;
import com.example.model.Store;
import com.example.services.DataService;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class StoreController {
    @Autowired
    private DataService dataService;
    @PostMapping("/store")
    public Store addStore(@RequestBody Store store) throws ResourceExceptionHandler {
        return dataService.addStore(store);
    }
    //@GetMapping("/store")
    @RequestMapping(value = "/store", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Store>> getAllStores() throws ResourceExceptionHandler{
        return ResponseEntity.ok(dataService.getAllStores());
    }
    @GetMapping("store/{id}")
    public ResponseEntity<Store> findStoreById(@PathVariable(value = "id") Integer storeId) throws ResourceExceptionHandler{
        Store store = dataService.findStoreById(storeId);
        return ResponseEntity.ok().body(store);
    }
    @PutMapping("store/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable(value = "id") Integer storeId,
             @RequestBody Store storeDetails) throws ResourceExceptionHandler {
        Store store = dataService.updateStore(storeId, storeDetails);
        return ResponseEntity.ok(store);

    }

    @DeleteMapping("store/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable(value = "id") Integer storeId) throws ResourceExceptionHandler {
        dataService.deleteStore(storeId);
        return ResponseEntity.ok().build();
    }
}
