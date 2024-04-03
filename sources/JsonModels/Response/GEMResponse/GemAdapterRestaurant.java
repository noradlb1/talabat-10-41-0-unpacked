package JsonModels.Response.GEMResponse;

import datamodels.Restaurant;

public class GemAdapterRestaurant {
    public String imagePath;
    public Restaurant restaurant;
    public int status;

    public GemAdapterRestaurant(int i11, Restaurant restaurant2, String str) {
        this.status = i11;
        this.restaurant = restaurant2;
        this.imagePath = str;
    }
}
