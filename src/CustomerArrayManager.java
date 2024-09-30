import java.io.*;
import java.util.Scanner;

public class CustomerArrayManager implements CustomerManager{
    private Customer customerArray[] = new Customer[100];
    private String pathtxt= "src/customersArray.txt";
    private String pathDat= "src/customersArray.dat";
    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void createCustomers(){
        String nameArray [] = {"Kate",
                "Colt",
                "Eren",
                "Edgar",
                "Jasie",
                "Finn",
                "Daniel",
                "Obama",
                "Lewis",
                "John",
                "Mike",
                "Lion",
                "Jinger",
                "Igger",
                "Nick",
                "Alex",
                "Piere",
                "Esteban",
                "Kevin",
                "Marci"};
        String surnameArray [] = {"Lawson",
                "Tsunoda",
                "Hamilton",
                "Franchesko",
                "Shumacher",
                "Prost",
                "Verstappen",
                "Ricciardo",
                "Levchenko",
                "Grosjean",
                "Sati",
                "Mudryk",
                "Pillow",
                "Fix",
                "Bringshtorm",
                "Hulkenderg",
                "Ocon",
                "Gasly",
                "Magnusen",
                "Gay",
                "Monkey",
                "Nigger",
                "Brain",
                "Calopinto",
                "Bearman",
                "Singapure",
                "Albon",
                "Savchenko"};
        String addressArray [] = {"Linkoln str. ",
                "Shevchenko Square ",
                "Wolf str. ",
                "Crimson str. "};
        for (int i = 0; i < customerArray.length; i ++){
            String surname = surnameArray[(int)(Math.random()*surnameArray.length)];
            String name = nameArray[(int)(Math.random()*nameArray.length)];
            String fathername = nameArray[(int)(Math.random()*nameArray.length)];
            String address = addressArray[(int)(Math.random()*addressArray.length)] + (int)(Math.random()*40);

            customerArray[i] = new Customer(i, surname, name, fathername, address, "1000" + i, "444" + i, Math.random()*1200);
        }
    }


    public void printCustomers(){
        for (int i = 0; i <customerArray.length; i ++) {
            System.out.println(customerArray[i].toString());
        }
    }

    public void printCustomersByName(){
        System.out.println("input find name: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        for (int i = 0; i <customerArray.length; i ++) {
            if (customerArray[i].getName().equals(name)){
                System.out.println(customerArray[i].toString());
            }
        }
    }
    public void printCustomersBetweenBalanceRange(double min, double max){
        for (int i = 0; i <customerArray.length; i ++) {
            if (customerArray[i].getBonusBalance() >= min && customerArray[i].getBonusBalance() <= max){
                System.out.println(customerArray[i].toString());
            }
        }
    }
    public void printCustomersBetweenBalanceRange(){
        Scanner s = new Scanner(System.in);
        System.out.println("Input range min and max");
        this.printCustomersBetweenBalanceRange(s.nextDouble(), s.nextDouble());
    }
    public void printCustomersNullBalance(){
        int count = 0;
        for (int i = 0; i <customerArray.length; i ++){
            if (customerArray[i].getBonusBalance() == 0){
                count++;
                System.out.println(customerArray[i].toString());
            }
        }
    }

    public void saveToTxt(){
        try(FileWriter writer = new FileWriter(pathtxt, false))
        {
            for (int i = 0; i <customerArray.length; i ++) {
                writer.write(customerArray[i].toCSVString());
                writer.append("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void loadFromTxt(){
        try(BufferedReader reader = new BufferedReader(new FileReader(pathtxt)))
        {
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
                customerArray[i]=Customer.fromString(line);
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveToDat(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathDat)))
        {
            oos.writeObject(customerArray);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void loadFromDat(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathDat)))
        {
            customerArray=((Customer[])ois.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Customer inputCustomer(int id){
        Scanner s = new Scanner(System.in);
        System.out.println("input surname");
        String surname = s.nextLine();
        System.out.println("input name");
        String name = s.nextLine();
        System.out.println("input fathername");
        String fname = s.nextLine();
        System.out.println("input address");
        String address = s.nextLine();
        System.out.println("input phone number");
        String phone = s.nextLine();
        System.out.println("input card number");
        String card = s.nextLine();
        System.out.println("input balance");
        Double bal = s.nextDouble();
        return new Customer(id, surname, name, fname, address, phone, card, bal);
    }

    public void deleteCustomerByID(){
        System.out.println("input Customer ID");
        Scanner s = new Scanner(System.in);
        int id = s.nextInt();
        customerArray[id] = new Customer(id, "none", "none", "none", "none", "none", "none");
    }

    public void changeCustomerByID(){
        System.out.println("input Customer ID");
        Scanner s = new Scanner(System.in);
        int id = s.nextInt();
        customerArray[id]=inputCustomer(id);
    }


}