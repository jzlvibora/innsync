package com.innsync.booking.model;

public enum RoomType {
    STANDARD("Standard Room", "A comfortable and budget-friendly option for a relaxing stay. Features a Queen-size bed, private bathroom, basic toiletries, and free Wi-Fi."),
    DELUXE("Deluxe Room", "A step up in comfort and amenities, ideal for those seeking a bit more luxury. Features a King-size bed, a seating area, upgraded toiletries, and a flat-screen TV."),
    FAMILY("Family Room", "Designed for families, providing additional space and amenities for a pleasant stay. Features two double beds or a queen-size bed and a sofa bed, suitable for families with children."),
    BUSINESS_SUITE("Business Suite", "Tailored for business travelers, offering a comfortable work space. Features a work desk, ergonomic chair, high-speed internet, and complimentary business center access."),
    HONEYMOON_SUITE("Honeymoon Suite", "A romantic and intimate setting for couples celebrating a special occasion. Features a King-size bed, in-room jacuzzi, champagne on arrival, and personalized concierge service."),
    ACCESSIBLE("Accessible Room", "Designed for guests with mobility challenges, ensuring comfort and convenience. Features wheelchair-accessible entrances, roll-in shower, and other accessible facilities.");

  String name;
  String description;

    RoomType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
