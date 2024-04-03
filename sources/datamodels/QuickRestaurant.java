package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;

public class QuickRestaurant {

    /* renamed from: id  reason: collision with root package name */
    public int f13869id;
    @SerializedName("th")
    public String logo;
    @SerializedName("nm")

    /* renamed from: name  reason: collision with root package name */
    public String f13870name;
    @SerializedName("rt")
    public float rating;

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.logo;
    }

    public String getName() {
        return this.f13870name;
    }
}
