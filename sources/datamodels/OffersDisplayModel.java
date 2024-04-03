package datamodels;

import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;

public class OffersDisplayModel {
    public int branchId;
    public String branchName;
    public String description;
    public String offerImage;
    public String offerTitle;
    public float price;
    public int promotionType;
    public int restaurantId;
    public String restaurantImage;
    public String restaurantName;

    public String getPrice() {
        return this.price > 0.0f ? TalabatFormatter.getInstance().getFormattedCurrency(this.price) : "Price On Selection";
    }

    public String getThumbnail() {
        if (TalabatUtils.isNullOrEmpty(this.offerImage)) {
            return this.restaurantImage;
        }
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + this.offerImage).replace(" ", "%20");
    }

    public boolean isPriceOnSelection() {
        return this.price > 0.0f;
    }
}
