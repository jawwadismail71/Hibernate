import com.lti.SavingsAccount;
import com.lti.daopattern.SavingsAccountDAO;
import com.lti.daopattern.SavingsAccountDAOImpl;
import com.lti.designpatter.basedao.BaseDAOImpl;
import com.lti.designpatter.basedao.SavingsAccountDAOImpl2;

import java.util.List;

import org.junit.jupiter.api.Test;

//

public class SavingsAccountCrudTest {
	
	SavingsAccountDAO savAccDAO = new SavingsAccountDAOImpl(); 
	SavingsAccountDAOImpl2 savAccDAO2 = new SavingsAccountDAOImpl2();
	
	BaseDAOImpl baseDAO = new BaseDAOImpl();
	
	@Test
	public void selectSavingsAccountViaBaseDAOTest() {
		
		SavingsAccount savObj = (SavingsAccount) baseDAO.find(SavingsAccount.class, 555); //transaction + persist
		System.out.println("Account Number  : "+savObj.getAccountNumber());
		System.out.println("Account Name    : "+savObj.getAccountHolderName());
		System.out.println("Account Balance : "+savObj.getAccountBalance());	

	}
	
	@Test
	public void insertSavingsAccountViaBaseDAOTest() {
		
		SavingsAccount savObj= new SavingsAccount();
		savObj.setAccountNumber(555); savObj.setAccountHolderName("JONES"); savObj.setAccountBalance(5555);
		baseDAO.persist(savObj); //transaction + persist
	}
	
	@Test
	public void insertSavingsAccount2Test() {
		
		SavingsAccount savObj= new SavingsAccount();
		savObj.setAccountNumber(666); savObj.setAccountHolderName("JONES666"); savObj.setAccountBalance(6666);
		savAccDAO2.insertSavingsAccount(savObj);//super.persist(); of the baseDAO
	}
	
	@Test
	public void insertSavingsAccountTest() {
		
		SavingsAccount savObj= new SavingsAccount();
		savObj.setAccountNumber(112); savObj.setAccountHolderName("JACKY"); savObj.setAccountBalance(9000);
		savAccDAO.insertSavingsAccount(savObj); //transaction + persist
	}
	
	@Test
	public void findSavingsAccountTest() { //THIS PROGRAM IS IN SRC/TEST/JAVA FOLDER	
		
		SavingsAccount savObj = savAccDAO.selectSavingsAccountByAccountNumber(111);
		System.out.println("Account Number  : "+savObj.getAccountNumber());
		System.out.println("Account Name    : "+savObj.getAccountHolderName());
		System.out.println("Account Balance : "+savObj.getAccountBalance());	
	}
	
	@Test
	public void findAllSavingsAccountTest() { //THIS PROGRAM IS IN SRC/TEST/JAVA FOLDER	
		List<SavingsAccount> mySavingsList = savAccDAO.selectAllSavingsAccounts();
		for(SavingsAccount theAccount : mySavingsList ) { //
			System.out.println("Account Number  : "+theAccount.getAccountNumber());
			System.out.println("Account Name    : "+theAccount.getAccountHolderName());
			System.out.println("Account Balance : "+theAccount.getAccountBalance());
			System.out.println("--------------------");
		}	}
	
	
	
	@Test
	public void updateSavingsAccountTest() { //THIS PROGRAM IS IN SRC/TEST/JAVA FOLDER	
		SavingsAccount savObj = new SavingsAccount();
		savObj.setAccountNumber(111);
		savObj.setAccountHolderName("JUL"); 
		savObj.setAccountBalance(7777);
		savAccDAO.updateSavingsAccount(savObj);
	}
	
	@Test
	public void deleteSavingsAccountTest() { //THIS PROGRAM IS IN SRC/TEST/JAVA FOLDER	
		SavingsAccount savObj = new SavingsAccount();
		savObj.setAccountNumber(111);
		savAccDAO.deleteSavingsAccount(savObj);
	}
	
}
