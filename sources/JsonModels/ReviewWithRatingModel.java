package JsonModels;

import datamodels.RatingSection;
import datamodels.RestaurantReviewPaging;
import java.util.ArrayList;

public class ReviewWithRatingModel {
    public RatingSection ratingSection;
    public ArrayList<RestaurantReviewPaging> rev;

    public ReviewWithRatingModel(ArrayList<RestaurantReviewPaging> arrayList, RatingSection ratingSection2) {
        ArrayList<RestaurantReviewPaging> arrayList2 = new ArrayList<>();
        this.rev = arrayList2;
        arrayList2.addAll(arrayList);
        this.ratingSection = ratingSection2;
    }
}
