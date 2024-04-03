package datamodels;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import java.io.Serializable;

public class Filter implements Serializable {
    @SerializedName("deepLink")
    String deepLink;
    @SerializedName("thumbnail")
    String icon;

    /* renamed from: id  reason: collision with root package name */
    int f13853id;
    @SerializedName("name")

    /* renamed from: name  reason: collision with root package name */
    String f13854name;
    @SerializedName("slug")
    String slugName;

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getIcon() {
        String str = this.icon;
        if (str == null || TextUtils.isEmpty(str)) {
            return "";
        }
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.icon;
    }

    public int getId() {
        return this.f13853id;
    }

    public String getName() {
        return this.f13854name;
    }

    public String getSlugName() {
        return this.slugName;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i11) {
        this.f13853id = i11;
    }

    public void setName(String str) {
        this.f13854name = str;
    }

    public void setSlugName(String str) {
        this.slugName = str;
    }
}
