package model;

public class PackageData {

    public String ownerLogin;
    public String receiverName;
    public String city;
    public String address;
    public String senderPhone;
    public String receiverPhone;
    public String size;
    public String packageCode;
    public String status;

    public PackageData(String ownerLogin,
                       String receiverName,
                       String city,
                       String address,
                       String senderPhone,
                       String receiverPhone,
                       String size,
                       String packageCode,
                       String status
    ) {

        this.ownerLogin = ownerLogin;
        this.receiverName = receiverName;
        this.city = city;
        this.address = address;
        this.senderPhone = senderPhone;
        this.receiverPhone = receiverPhone;
        this.size = size;
        this.packageCode = packageCode;
        this.status= status;
    }
}