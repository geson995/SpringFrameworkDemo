package com.springmvc.dao;

import com.springmvc.dao.common.IOperations;
import com.springmvc.entity.Customer;

public interface CustomerDao extends IOperations<Customer, String> {
    Customer findByUsername(String username) throws Exception;
}
