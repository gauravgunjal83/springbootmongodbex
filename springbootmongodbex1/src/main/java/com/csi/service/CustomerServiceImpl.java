package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer saveData(Customer customer){
        return customerDaoImpl.saveData(customer);
    }

    public Optional<Customer> getDataById(int custId){
        return  customerDaoImpl.getDataById(custId);
    }

    public List<Customer> getAllData(){
        return customerDaoImpl.getAllData();
    }

    public Customer updateDatabyId(Customer customer){
        return customerDaoImpl.updateDatabyId(customer);
    }
    public void deleteById(int custId){
        customerDaoImpl.deleteById(custId);
    }

    public void deleteAllData(){
        customerDaoImpl.deleteAllData();
    }
}
