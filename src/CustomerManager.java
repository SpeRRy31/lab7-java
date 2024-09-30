public interface CustomerManager {
    public void printCustomers();

    public void printCustomersByName();
    public void printCustomersBetweenBalanceRange(double min, double max);
    public void printCustomersBetweenBalanceRange();
    public void printCustomersNullBalance();


    public void saveToTxt();
    public void loadFromTxt();

    public void saveToDat();
    public void loadFromDat();
}
