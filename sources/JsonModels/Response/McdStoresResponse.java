package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;

public class McdStoresResponse {
    public Address address;
    public int mcdBranchId;
    @SerializedName("result")
    public McdStroesResult result;
    public int tlbBranchId;
}
