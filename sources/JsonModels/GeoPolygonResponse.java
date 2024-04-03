package JsonModels;

import com.google.gson.annotations.SerializedName;

public class GeoPolygonResponse {
    @SerializedName("id")
    public int areaId;
    @SerializedName("polc")
    public String geoCenterPoint;
    @SerializedName("pol")
    public Double[][] polygonCoordinates;
    @SerializedName("validateWithPolygon")
    public boolean validateWithPolygon;
}
