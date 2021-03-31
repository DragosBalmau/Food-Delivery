public class Location {

    private String street;
    private int streetNumber;
    private String city;
    private String zipCode;

    public Location(String street, int streetNumber, String city, String zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", city=" + city +
                ", zipCode=" + zipCode +
                '}';
    }

}
