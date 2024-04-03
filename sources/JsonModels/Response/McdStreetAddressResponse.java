package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;

public class McdStreetAddressResponse {
    @SerializedName("address")
    public Address McdAddress;
    @SerializedName("result")
    public McdStroesResult result;
}
