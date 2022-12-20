package com.infy.SpringData_Pagination.repository;

import com.infy.SpringData_Pagination.entity.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {

    List<Transaction> findByTransactionDateAfter(LocalDate transactionDate, Pageable pageable);
}
