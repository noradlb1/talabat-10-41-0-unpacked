package JsonModels;

import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.extensions.StringBuilderKt;
import datamodels.DeliveryArea;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.PromotionDisplay;
import datamodels.Restaurant;
import datamodels.Warning;
import java.util.ArrayList;

public class MenuItemsResponseModel {
    public DeliveryArea[] deliveryAreas;
    @SerializedName("hImg")
    public String heroImage;
    public MenuItemRM menu;
    public PromotionDisplay[] promotions;
    public Restaurant restaurant;
    @SerializedName("tgoDiscountData")
    public TgoFreeDeliveryResponse tgoFreeDeliveryResponse;
    @SerializedName("usil")
    public ArrayList<MenuItem> upsellingItems;
    public Warning[] warnings;

    public String getCampaignIdForAllPromotions() {
        StringBuilder sb2 = new StringBuilder();
        PromotionDisplay[] promotionDisplayArr = this.promotions;
        if (promotionDisplayArr != null && promotionDisplayArr.length > 0) {
            for (PromotionDisplay promotionDisplay : promotionDisplayArr) {
                StringBuilderKt.addStringWithComma(sb2, Integer.valueOf(promotionDisplay.couponId));
            }
        }
        return sb2.toString();
    }

    public String getHeroLogo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getHeroLogo: ");
        sb2.append(this.heroImage);
        this.heroImage = this.heroImage.replaceAll(" ", "%20");
        if (GlobalDataModel.imageBaseUrl.endsWith("/")) {
            return GlobalDataModel.imageBaseUrl + this.heroImage;
        }
        return GlobalDataModel.imageBaseUrl + "/" + this.heroImage;
    }

    public String getPromotionalMenuSectionId() {
        StringBuilder sb2 = new StringBuilder();
        MenuItemRM menuItemRM = this.menu;
        if (menuItemRM != null && !menuItemRM.isEmpty()) {
            for (MenuSection menuSection : this.menu.menuSection) {
                if (menuSection.isDiscounted) {
                    StringBuilderKt.addStringWithComma(sb2, Integer.valueOf(menuSection.f13863id));
                }
            }
        }
        return sb2.toString();
    }
}
