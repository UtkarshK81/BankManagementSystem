package com.capgemini.pecunia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.capgemini.pecunia.entity.Transaction;
import com.capgemini.pecunia.exception.TransactionDoesNotExist;
import com.capgemini.pecunia.service.IPassbookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassbookControllerTest {
   
                                                 
    @Autowired                   
    private IPassbookService passbookService;
                                               
    private List<Transaction> transactionList;       
                                            
 
    
    @Test
   public void testShouldGetAllTransactions() throws Exception{	
    	Date date1=new Date(9062020);
    	Date date2=new Date(9102020);
        this.transactionList = new ArrayList<Transaction>();                    
        this.transactionList.add(new Transaction(001, "Credit", 4000.0,date1, null, ""));
        this.transactionList.add(new Transaction(002, "Credit", 4000.0,date2, null, ""));
    	//when(passbookService.accountSummary(10000001,"2020-09-06","2020-09-11")).thenReturn(transactionList);
    	assertEquals(2,passbookService.accountSummary(1000210,"2020-09-05","2020-09-11").size());
    }
    
    @Test
    public void testAccountValidation() throws Exception{
    	//when(passbookService.accountValidation(10000001)).thenReturn(true);
    	assertEquals(true, passbookService.accountValidation(1000210));
    }
    
 
}
