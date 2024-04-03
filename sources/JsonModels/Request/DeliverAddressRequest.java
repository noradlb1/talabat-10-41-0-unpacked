package JsonModels.Request;

public class DeliverAddressRequest {
    int branchId;
    int countryId;
    double latitude;
    double longitude;
    int restaurantId;

    public DeliverAddressRequest(int i11, int i12, double d11, double d12, int i13) {
        this.restaurantId = i11;
        this.countryId = i12;
        this.longitude = d11;
        this.latitude = d12;
        this.branchId = i13;
    }
}
