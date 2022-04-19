package com.example.services;

import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.ResourceExceptionHandler;
import com.example.exception.ResourceExceptionHandler;
import com.example.model.Store;
import com.example.repository.StoreRepository;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class DataService {
   @Autowired
   private StoreRepository storeRepository;
   public Store addStore(Store store) throws ResourceExceptionHandler {
        return storeRepository.save(store);
    }

    public List<Store> getAllStores() throws ResourceExceptionHandler {
        return storeRepository.findAll();
    }

    public Store findStoreById(Integer storeId) throws ResourceExceptionHandler{
        Store store = storeRepository.findById(storeId).orElseThrow(ResourceExceptionHandler::new);
       return store;
    }

     public Store updateStore(Integer storeId, Store storeDetails) throws ResourceExceptionHandler {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceExceptionHandler("Store not found for this id :: " + storeId));
        store.setName(storeDetails.getName());
        final Store updatedStore = storeRepository.save(store);
        return updatedStore;

    }


    public void deleteStore(Integer storeId) throws ResourceExceptionHandler {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new ResourceExceptionHandler("Store not found" + storeId));
        storeRepository.delete(store);
     }

}
