package JsonModels.Request;

public class FranchiseRestRequest {
    int countryId;
    int groupId;
    double latitude;
    double longitude;

    public FranchiseRestRequest(int i11, double d11, double d12, int i12) {
        this.countryId = i11;
        this.longitude = d11;
        this.latitude = d12;
        this.groupId = i12;
    }
}
