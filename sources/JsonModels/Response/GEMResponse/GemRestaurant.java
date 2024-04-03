package JsonModels.Response.GEMResponse;

public class GemRestaurant {
    public String imagePath;
    public int restaurantBranchId;
    public int status;

    public GemRestaurant(int i11, int i12, String str) {
        this.status = i11;
        this.restaurantBranchId = i12;
        this.imagePath = str;
    }
}
