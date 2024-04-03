package datamodels;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantListModel {
    private int allRestCount = 0;
    private ArrayList<Restaurant> allRestaurants;
    private ArrayList<Restaurant> busyRestaurants;
    private String closedResString = "";
    private ArrayList<Restaurant> closedRestaurants;
    private ArrayList<RestaurantListItemModel> listItems = new ArrayList<>();
    private boolean mIsCollection = false;
    private ArrayList<Restaurant> openRestaurants;
    private String openresString = "";
    private int tGoRestCount = 0;
    private int tabIndex = 0;

    public static RestaurantListModel create(List<Restaurant> list) {
        RestaurantListModel restaurantListModel = new RestaurantListModel();
        restaurantListModel.createNewRestautantList(list);
        return restaurantListModel;
    }

    public void createNewRestautantList(List<Restaurant> list) {
        String str;
        this.allRestaurants = new ArrayList<>(list);
        this.openRestaurants = new ArrayList<>();
        this.busyRestaurants = new ArrayList<>();
        this.closedRestaurants = new ArrayList<>();
        this.listItems = new ArrayList<>();
        if (list != null) {
            for (Restaurant next : list) {
                int i11 = next.statusType;
                if (i11 == 2 || i11 == 4) {
                    this.busyRestaurants.add(next);
                } else if (i11 == 1) {
                    this.closedRestaurants.add(next);
                } else {
                    this.openRestaurants.add(next);
                }
            }
        } else {
            for (Restaurant restaurant : GlobalDataModel.restaurants) {
                int i12 = restaurant.statusType;
                if (i12 == 2 || i12 == 4) {
                    this.busyRestaurants.add(restaurant);
                } else if (i12 == 1) {
                    this.closedRestaurants.add(restaurant);
                } else {
                    this.openRestaurants.add(restaurant);
                }
            }
        }
        this.busyRestaurants.addAll(this.closedRestaurants);
        int size = this.openRestaurants.size();
        if (size > 0) {
            if (TalabatUtils.isArabic()) {
                this.openresString = "مطعم متاح للطلب";
            } else {
                if (size == 1) {
                    str = "OPEN RESTAURANT";
                } else {
                    str = "OPEN RESTAURANTS";
                }
                this.openresString = str;
            }
            String str2 = size + " " + this.openresString;
            if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_FLUTTER_VL_COLLECTION, false, TalabatExperimentDataSourceStrategy.APPTIMIZE) && !this.mIsCollection) {
                this.listItems.add(new RestaurantListItemModel(15, str2));
            }
            if (!this.mIsCollection) {
                this.listItems.add(new RestaurantListItemModel(1, str2));
            }
            Iterator<Restaurant> it = this.openRestaurants.iterator();
            while (it.hasNext()) {
                this.listItems.add(new RestaurantListItemModel(2, it.next()));
            }
        }
        int size2 = this.busyRestaurants.size();
        if (size2 > 0) {
            if (TalabatUtils.isArabic()) {
                this.closedResString = "مطاعم لا تقبل الطلب";
            } else {
                this.closedResString = "RESTAURANTS NOT ACCEPTING ORDER";
            }
            String str3 = size2 + " " + this.closedResString;
            if (!this.mIsCollection) {
                this.listItems.add(new RestaurantListItemModel(1, str3));
            }
            Iterator<Restaurant> it2 = this.busyRestaurants.iterator();
            while (it2.hasNext()) {
                this.listItems.add(new RestaurantListItemModel(2, it2.next()));
            }
        }
        this.allRestCount = this.openRestaurants.size() + this.openRestaurants.size();
    }

    public ArrayList<Restaurant> getAllRestaurants() {
        return this.allRestaurants;
    }

    public ArrayList<Restaurant> getOpenNowRestaurants() {
        return this.openRestaurants;
    }

    public int getRestaurantListCount() {
        return this.listItems.size();
    }

    public RestaurantListItemModel getRestaurantListItemAtIndex(int i11) {
        return this.listItems.get(i11);
    }

    public int getSize() {
        if (this.tabIndex == 0) {
            this.tabIndex = this.allRestCount;
        } else {
            this.tabIndex = this.tGoRestCount;
        }
        return this.tabIndex;
    }

    public void setIsCollection(boolean z11) {
        this.mIsCollection = z11;
    }
}
