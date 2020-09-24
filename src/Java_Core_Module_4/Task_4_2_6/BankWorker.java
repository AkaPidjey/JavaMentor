package Java_Core_Module_4.Task_4_2_6;

public interface BankWorker {
    public boolean checkClientForCredit(BankClient bc) throws BadCreditHistoryException, ProblemWithLawException;
    ;
}
