package kr.co.fastcampus.eatgo.domain;

public class Restaurant {
    private final String name;
    private final String address;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
//        return ""; //RED
//        return "Bob zip";//GREEN
        return name; //REFACTORING
    }

    public String getAddress() {
//        return "";
        return address;

    }

    public String getInformaiton() {
//        return "";
//        return name + " in Seoul";
        return name + " in " + address;
    }
}
