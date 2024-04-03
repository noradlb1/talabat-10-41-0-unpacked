package datamodels;

import java.util.ArrayList;

public class MenuListModel {
    public ArrayList<MenuItem> menuItems;
    private int offerrsCount;
    public ArrayList<OffersItem> offersItems;
    public RestaurantReview restaurantReviews;
    public ArrayList<RestaurantReviewPaging> restreviewList;

    public int getReviewsCount() {
        return this.restreviewList.size();
    }

    public int getoffersCount() {
        return this.offerrsCount;
    }
}
