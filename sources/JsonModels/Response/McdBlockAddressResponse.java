package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;
import datamodels.McdBlocks;

public class McdBlockAddressResponse {
    @SerializedName("address")
    public Address McdAddress;
    @SerializedName("isfrommap")
    private boolean isMcdFrommap;
    @SerializedName("blocks")
    public McdBlocks[] mcdBlocks;
    @SerializedName("result")
    public McdStroesResult result;
}
