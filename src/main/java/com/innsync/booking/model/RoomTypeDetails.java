package com.innsync.booking.model;

public class RoomTypeDetails {
    private String name;
    private String description;
    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RoomTypeDetails(RoomType roomType) {
        this.name = roomType.getName();
        this.description = roomType.getDescription();
        this.imageUrl = roomType.getImage();
    }
}
