package com.innsync.booking.model;

public enum RoomType {
    STANDARD("Standard Room", "A comfortable and budget-friendly option for a relaxing stay. Features a Queen-size bed, private bathroom, basic toiletries, and free Wi-Fi.","https://www.leelonglands.co.uk/live/Items/166693aA.jpg"),
    DELUXE("Deluxe Room", "A step up in comfort and amenities, ideal for those seeking a bit more luxury. Features a King-size bed, a seating area, upgraded toiletries, and a flat-screen TV.", "https://i5.walmartimages.com/seo/3-Pieces-Bedroom-Furniture-Set-Full-Upholstered-Platform-Bed-Frame-2-Nightstands-Velvet-Tufted-Wingback-Headboard-Wood-Slats-Support-Bedroom-No-Box-S_3062c2ef-fb40-4523-bbdc-1b55c40e3e9e.3dbd5a8a945389911009ce9eb436742d.jpeg?odnHeight=640&odnWidth=640&odnBg=FFFFFF"),
    FAMILY("Family Room", "Designed for families, providing additional space and amenities for a pleasant stay. Features two double beds or a queen-size bed and a sofa bed, suitable for families with children.", "https://blue-harbor-resort.hotelsofwisconsin.com/data/Pictures/OriginalPhoto/6295/629511/629511840/picture-sheboygan-blue-harbor-resort-14.JPEG"),
    BUSINESS_SUITE("Business Suite", "Tailored for business travelers, offering a comfortable work space. Features a work desk, ergonomic chair, high-speed internet, and complimentary business center access.", "https://www.tealrockmykonos.com/wp-content/uploads/2022/02/1bedroom-tealrockmykonos-22.jpg"),
    HONEYMOON_SUITE("Honeymoon Suite", "A romantic and intimate setting for couples celebrating a special occasion. Features a King-size bed, in-room jacuzzi, champagne on arrival, and personalized concierge service.", "https://media.cnn.com/api/v1/images/stellar/prod/underscored-beach-villa-at-the-conrad-maldives.jpg?q=w_1110,c_fill/f_webp"),
    ACCESSIBLE("Accessible Room", "Designed for guests with mobility challenges, ensuring comfort and convenience. Features wheelchair-accessible entrances, roll-in shower, and other accessible facilities.", "https://www.tokyuhotelsjapan.com/cerulean-h/facility/img/facility_images_pic_room01.jpg");

  String name;
  String description;
  String image;

    RoomType(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
