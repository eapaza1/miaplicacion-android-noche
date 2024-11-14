package com.apaza.mi_aplicacion.entidades;

public class EProducto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    private Rating rating;


    public static class Rating {
        private int count;
        private double rate;

        public double getRate() {
            return rate;
        }

        public int getCount() {
            return count;
        }
    }

    //getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public Rating getRating() {
        return rating;
    }


}
