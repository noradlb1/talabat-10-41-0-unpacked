package JsonModels;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;

public class RestGeoAddressResult {
    @SerializedName("branchInfo")
    public RestGeoAddressBranchInfo branchInfo;
    @SerializedName("lstBranchInfo")
    public FranchiseBranchList[] franchiseBranchList;
    @SerializedName("isGroupRest")
    public boolean iSGroupRestaurant;
    @SerializedName("address")
    public Address reverseAddress;
}
