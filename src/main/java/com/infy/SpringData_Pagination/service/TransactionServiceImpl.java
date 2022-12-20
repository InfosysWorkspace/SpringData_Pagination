package com.infy.SpringData_Pagination.service;

import com.infy.SpringData_Pagination.dto.TransactionDTO;
import com.infy.SpringData_Pagination.entity.Transaction;
import com.infy.SpringData_Pagination.exception.InfyBankException;
import com.infy.SpringData_Pagination.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws InfyBankException{
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Transaction> page = transactionRepository.findAll((pageable));
        if(page.isEmpty()){
            throw new InfyBankException("Service.NO_CUSTOMERS_IN_THIS_PAGE");
        }

        List<Transaction> entityList = page.getContent();
        List<TransactionDTO> transactionDTOS;
        transactionDTOS = entityList.stream().map(p -> new TransactionDTO(
                p.getTransactionId(),
                p.getTransactionDate(),
                p.getTransactionAmount()))
                .collect(Collectors.toList());

        return transactionDTOS;
    }

    @Override
    public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo, Integer pageSize)throws InfyBankException{
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        List<Transaction> transactions = transactionRepository.findByTransactionDateAfter(transactionDate, pageable);
        if(transactions.isEmpty()){
            throw new InfyBankException("Service.NO_CUSTOMERS_IN_THIS_PAGE");
        }

        List<TransactionDTO> transactionDTOS;
        transactionDTOS = transactions.stream().map(transaction -> new TransactionDTO(
                transaction.getTransactionId(),
                transaction.getTransactionDate(),
                transaction.getTransactionAmount()))
                .collect(Collectors.toList());

        return transactionDTOS;
    }

}
