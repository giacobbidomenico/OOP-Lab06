package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	
    	AccountHolder marioRossi = new AccountHolder("Mario","Rossi",0);
    	AccountHolder mariaVarani = new AccountHolder("Maria", "Varani", 1);
    	
    	StrictBankAccount acc1 = new StrictBankAccount(marioRossi.getUserID(), 1000, 10);
    	StrictBankAccount acc2 = new StrictBankAccount(mariaVarani.getUserID(), 1000, 10);
        
    	/* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	//test the insertion of a wrong id
    	try {
    		acc1.deposit(10, 300);
    		fail("Unexpected exception");
    	}catch(WrongAccountHolderException e) {
    		assertNotNull(e);
    	}
    	
    	try {
    		acc2.withdraw(10, 400);
    		fail("Unexpected exception");
    	} catch(WrongAccountHolderException e) {
    		assertNotNull(e);
    	}
    	
    	try {
    		acc2.computeManagementFees(10);
    		fail("Unexpected exception");
    	}catch(WrongAccountHolderException e) {
    		assertNotNull(e);
    	}
    	
    	//test if founds are not enough
    	try {
    		acc1.withdraw(marioRossi.getUserID(), 2000);
    		fail("Unexpected exception");
    	}catch (NotEnoughFoundsException e) {
			assertNotNull(e);
		}
    	
    	//test number of transactions over quota
    	for(int i = 0; i < 10;i++) {
    		try {
    			acc1.depositFromATM(marioRossi.getUserID(), 4);
    		}catch(TransactionsOverQuotaException | WrongAccountHolderException e) {
    			fail("Unexpected exception");
    		}
    	}
    	
    	for(int i = 0; i < 10;i++) {
    		try {
    			acc1.withdrawFromATM(marioRossi.getUserID(), 1);
    			fail("Unexpected exception");
    		}catch(TransactionsOverQuotaException | WrongAccountHolderException e) {
    			assertNotNull(e);
    		}
    	}
    }
}
