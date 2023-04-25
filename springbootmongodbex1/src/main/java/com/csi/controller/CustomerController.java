package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")

    public ResponseEntity<String> saveData(@RequestBody Customer customer){
        customerServiceImpl.saveData(customer);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("/getdatabyid/{custId}")

    public ResponseEntity <Optional<Customer>> getDataById(@PathVariable int custId){
       return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getalldata")

    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{custId}")

    public ResponseEntity<Customer> updateDataById(@PathVariable int custId,@RequestBody Customer customer){

        Customer customer1=customerServiceImpl.getDataById(custId).orElseThrow(()->new RecordNotFoundException("employee id does not exist "));

        customer1.setEmpName(customer.getEmpName());
        customer1.setEmpAddress(customer.getEmpAddress());
        customer1.setEmpSalary(customer.getEmpSalary());
        customer1.setEmpContactNumber(customer.getEmpContactNumber());

        return  ResponseEntity.ok(customerServiceImpl.updateDatabyId(customer1));
    }

    @DeleteMapping("/deletebyid/{custId}")

    public ResponseEntity<String>deleteDataById(@PathVariable int custId){
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data deleted successfully");
    }

    @DeleteMapping("/deletealldata")

    public ResponseEntity<String>deleteAllData(){
        customerServiceImpl.deleteAllData();
        return ResponseEntity.ok("ALl Data deleted successfully");
    }
}
