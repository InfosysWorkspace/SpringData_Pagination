package com.infy.SpringData_Pagination.service;

import com.infy.SpringData_Pagination.dto.TransactionDTO;
import com.infy.SpringData_Pagination.exception.InfyBankException;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws InfyBankException;
    List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo, Integer pageSize) throws InfyBankException;
}
