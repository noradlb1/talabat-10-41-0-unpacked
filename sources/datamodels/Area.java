package datamodels;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.talabat.globaldatamodel.Utils;

@Deprecated
public class Area {
    @SerializedName("polc")
    @Json(name = "polc")
    public String areCenterPoint;
    @SerializedName("an")
    @Json(name = "an")
    public String areaName;
    @SerializedName("cid")
    @Json(name = "cid")
    public int cityId;
    @SerializedName("id")
    @Json(name = "id")

    /* renamed from: id  reason: collision with root package name */
    public int f13835id;
    @SerializedName("ipse")
    @Json(name = "ipse")
    public boolean isPolygonServiseEnabled;

    public LatLng getAreCenterPoint() {
        if (Utils.isNullOrEmpty(this.areCenterPoint)) {
            return null;
        }
        String[] split = this.areCenterPoint.split(",");
        return new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getId() {
        return this.f13835id;
    }

    public String getName() {
        return this.areaName;
    }

    public String toString() {
        return this.areaName;
    }
}
