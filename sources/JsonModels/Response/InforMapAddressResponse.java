package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;

public class InforMapAddressResponse {
    @SerializedName("mcdBranchId")
    public String McdBranchId;
    @SerializedName("address")
    public Address infoAddress;
    @SerializedName("result")
    public InforMapResult result;
    @SerializedName("tlbBranchId")
    public int talabatResBranchId;
}
