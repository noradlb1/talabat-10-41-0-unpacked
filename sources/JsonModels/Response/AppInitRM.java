package JsonModels.Response;

import JsonModels.AppInitResponse;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class AppInitRM {
    @SerializedName("baseUrl")
    @Json(name = "baseUrl")
    public String baseUrl;
    @SerializedName("result")
    @Json(name = "result")
    public AppInitResponse result;
}
