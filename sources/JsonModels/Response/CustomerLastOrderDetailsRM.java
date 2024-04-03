package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import datamodels.LastOrdersDetails;

public class CustomerLastOrderDetailsRM {
    @SerializedName("result")
    public LastOrdersDetails[] lastOrdersDetails;
}
