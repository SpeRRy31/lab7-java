import java.io.Serializable;
public class Customer implements Serializable{
    private int id;
    private String surname;
    private String name;
    private String fathername;
    private String address;
    private String phoneNumber;
    private String cardNumber;
    private double bonusBalance;

    public Customer(int id, String surname, String name, String fathername, String address, String phoneNumber, String cardNumber, double bonusBalance){
        this.id=id;
        this.surname=surname;
        this.name=name;
        this.fathername=fathername;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.cardNumber=cardNumber;
        this.bonusBalance=bonusBalance;
    }
    public Customer(int id, String surname, String name, String fathername, String address, String phoneNumber, String cardNumber){
        this.id=id;
        this.surname=surname;
        this.name=name;
        this.fathername=fathername;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.cardNumber=cardNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setBonusBalance(double bonusBalance) {
        this.bonusBalance = bonusBalance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFathername() {
        return fathername;
    }

    public String getAddress() {
        return address;
    }


    public double getBonusBalance() {
        return bonusBalance;
    }

    public String toString(){
        return "Customer{id: " + id
                + "; surname: " + surname
                + "; name: " + name
                + "; fathername: " + fathername
                + "; address: " + address
                + "; phone: " + phoneNumber
                + "; card: " + cardNumber
                + "; bonusbalance: " + bonusBalance
                +  "}";
    }
    public String toCSVString(){
        return id + "," + surname
                + "," + name
                + "," + fathername
                + "," + address
                + "," + phoneNumber
                + "," + cardNumber
                + "," + bonusBalance;
    }

    public static Customer fromString(String str) {
        System.out.println(str);
        String[] parts = str.split(",");
        for (int i=0; i < parts.length; i++){
            System.out.println(i + ":" + parts[i]);
        }
        return new Customer(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], Double.parseDouble(parts[7]));
    }
}