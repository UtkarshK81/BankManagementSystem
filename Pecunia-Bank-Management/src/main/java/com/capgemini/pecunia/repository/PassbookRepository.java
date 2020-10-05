package com.capgemini.pecunia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Transaction;

@Repository 
public interface PassbookRepository extends JpaRepository<Account, Long> {
	
	
	@Query("select t from Transaction t where account_number=?1 and t.transDate>=?2 and t.transDate<=?3")
	List<Transaction> accountSummary(long accountId, Date startDate,Date endDate);
//	
//	@Query("select u from Account u where account_number=?1")
//	Account get(long accountId);
	
	@Query("select t from Transaction t where account_number=?1 and t.transDate>(select u.lastUpdated from Account u where account_number=?1) ")
	List<Transaction> updatePassbook(long accountId);

	@Modifying
	@Query("update Account set lastUpdated=?2 where  account_number=?1")
	void update(long accountId, Date date);

	

}
