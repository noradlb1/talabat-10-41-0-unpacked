package JsonModels.Response;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;

public class ItemSearchResponse {
    @SerializedName("mid")
    public int itemId;
    @SerializedName("img")
    public String itemImage;
    @SerializedName("min_ar")
    public String itemNameAr;
    @SerializedName("min_en")
    public String itemNameEn;
    @SerializedName("prc")
    public float itemPrice;

    public String getItemImage() {
        String str = this.itemImage;
        if (str == null || TextUtils.isEmpty(str)) {
            return "";
        }
        if (this.itemImage.contains("menuitems/")) {
            return this.itemImage;
        }
        String encode = Uri.encode(this.itemImage);
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + encode).replace(" ", "%20");
    }
}
