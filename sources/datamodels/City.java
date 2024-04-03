package datamodels;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

@Deprecated
public class City {
    @SerializedName("cid")
    @Json(name = "cid")
    public int countryId;
    @SerializedName("id")
    @Json(name = "id")

    /* renamed from: id  reason: collision with root package name */
    public int f13843id;
    @SerializedName("na")
    @Json(name = "na")

    /* renamed from: name  reason: collision with root package name */
    public String f13844name;
}
