package datamodels;

public class OffersItem {
    public String description;
    public boolean isDiscount;
    public String itemName;
    public float price;
    public int promotionType;
    public String thumbnail;
    public String title;

    public static OffersItem createFromPromotionDisplay(PromotionDisplay promotionDisplay) {
        OffersItem offersItem = new OffersItem();
        offersItem.isDiscount = true;
        offersItem.description = promotionDisplay.description;
        offersItem.title = promotionDisplay.title;
        return offersItem;
    }
}
