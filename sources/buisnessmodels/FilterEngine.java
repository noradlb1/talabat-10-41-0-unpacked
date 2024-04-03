package buisnessmodels;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import buisnessmodels.sponsors.SponsoredSorting;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class FilterEngine {
    public static final int ALL = -100;
    public static final int DELFEESFREE = 0;
    public static final int SORT_ALPHABETIC = 0;
    public static final int SORT_DEFAULT_SORT = 6;
    public static final int SORT_DELIVERY_CHARGES = 4;
    public static final int SORT_DELIVERY_TIME = 5;
    public static final int SORT_MINIMUM_ORDER_AMOUNT = 3;
    public static final int SORT_RATINGS = 1;
    public static final int TYPE_COLLECTION = 1;
    public static final int TYPE_LIST = 0;
    private int deepLinkSort = -100;
    private String deepLinkValue = "";
    private Cuisine deeplinkCuisine = null;
    private int deliveryFees = -100;
    private boolean isCusinesSortApplied = false;
    private boolean isFilterApplied = false;
    private int minDeliveryTime = -100;
    private float minOrderAmount = -100.0f;
    private int restRating = -100;
    public SparseArray<Cuisine> selectedCuisines;
    public SparseArrayCompat<Filter> selectedFilter;
    public int selectedSortBy = -100;
    private boolean showTalabatDeliveryRestaurants = false;

    public class CuisineAppliedFilterComparator implements Comparator<Restaurant> {
        private final SparseArray<Cuisine> selectedCuisines;

        public CuisineAppliedFilterComparator(SparseArray<Cuisine> sparseArray) {
            this.selectedCuisines = sparseArray;
        }

        private int howManySelectedCuisinesRestaurantHas(Restaurant restaurant) {
            Cuisine[] cuisineArr = restaurant.cuisines;
            if (cuisineArr == null || cuisineArr.length <= 0) {
                return -1;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.selectedCuisines.size(); i12++) {
                Cuisine[] cuisineArr2 = restaurant.cuisines;
                int length = cuisineArr2.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length) {
                        break;
                    } else if (cuisineArr2[i13].f13848id == this.selectedCuisines.valueAt(i12).f13848id) {
                        i11++;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            return i11;
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            SparseArray<Cuisine> sparseArray = this.selectedCuisines;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return 0;
            }
            return howManySelectedCuisinesRestaurantHas(restaurant2) - howManySelectedCuisinesRestaurantHas(restaurant);
        }
    }

    public interface DEEPLINKFILER {
        public static final String COCACOLA = "cocacola";
        public static final String CUISINE = "cuisine";
        public static final String NEWRESTAURANTS = "new";
        public static final String NINECOOKIESRESTAURANTS = "9c";
        public static final String OFFERS = "offers";
        public static final String OPENRESTAURANTS = "open";
        public static final String PAYMENT = "payment";
        public static final String RAMADAN = "ramadan";
        public static final String TALABATDELIVERY = "talgo";
    }

    public interface DEEPLINKSORT {
        public static final String ALPHABETIC = "az";
        public static final String DELIVERYTIME = "time";
        public static final String MINIMUMORDERAMOUNT = "mov";
        public static final String RATING = "rating";
    }

    public class DeliveryCharges implements Comparator<Restaurant> {
        public DeliveryCharges() {
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            try {
                if (restaurant2.getDeliveryCharges() > restaurant.getDeliveryCharges()) {
                    return -1;
                }
                if (restaurant2.getDeliveryCharges() == restaurant.getDeliveryCharges()) {
                    return 0;
                }
                return 1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public class DeliveryTimeComparator implements Comparator<Restaurant> {
        public DeliveryTimeComparator() {
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            try {
                if (restaurant2.getDeliveryTimeInteger() < restaurant.getDeliveryTimeInteger()) {
                    return 1;
                }
                if (restaurant2.getDeliveryTimeInteger() == restaurant.getDeliveryTimeInteger()) {
                    return 0;
                }
                return -1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public class MinimumOrderAmount implements Comparator<Restaurant> {
        public MinimumOrderAmount() {
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            try {
                if (restaurant2.getMinimumAmount() > restaurant.getMinimumAmount()) {
                    return -1;
                }
                if (restaurant2.getMinimumAmount() == restaurant.getMinimumAmount()) {
                    return 0;
                }
                return 1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public static class NameComparator implements Comparator<Cuisine> {
        public int compare(Cuisine cuisine, Cuisine cuisine2) {
            return cuisine.f13849name.compareToIgnoreCase(cuisine2.f13849name);
        }
    }

    public class RestauratNameComparator implements Comparator<Restaurant> {
        public RestauratNameComparator() {
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            return restaurant.f13873name.compareToIgnoreCase(restaurant2.f13873name);
        }
    }

    public class RestauratRating implements Comparator<Restaurant> {
        public RestauratRating() {
        }

        public int compare(Restaurant restaurant, Restaurant restaurant2) {
            try {
                float f11 = restaurant2.rating;
                float f12 = restaurant.rating;
                if (f11 < f12) {
                    return -1;
                }
                return f11 == f12 ? 0 : 1;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    public static ArrayList<Cuisine> getCuisineNames(Restaurant[] restaurantArr) {
        ArrayList<Cuisine> arrayList = new ArrayList<>();
        SparseArray sparseArray = new SparseArray();
        for (Restaurant restaurant : restaurantArr) {
            if (restaurant.getCuisines() != null) {
                for (Cuisine cuisine : Arrays.asList(restaurant.getCuisines())) {
                    if (sparseArray.get(cuisine.getId()) == null) {
                        sparseArray.put(cuisine.getId(), cuisine);
                    }
                }
            }
        }
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            arrayList.add((Cuisine) sparseArray.valueAt(i11));
        }
        Collections.sort(arrayList, new NameComparator());
        return arrayList;
    }

    public static FilterEngine getInstance(int i11) {
        if (i11 == 0) {
            if (GlobalDataModel.filterEngine == null) {
                GlobalDataModel.filterEngine = new FilterEngine();
            }
            return GlobalDataModel.filterEngine;
        } else if (i11 != 1) {
            return null;
        } else {
            if (GlobalDataModel.collectionFilterEngine == null) {
                GlobalDataModel.collectionFilterEngine = new FilterEngine();
            }
            return GlobalDataModel.collectionFilterEngine;
        }
    }

    private boolean isCuisineConditionPassed(Restaurant restaurant) {
        SparseArray<Cuisine> sparseArray = this.selectedCuisines;
        if (sparseArray == null || sparseArray.size() == 0 || (this.selectedCuisines.size() == 1 && (this.selectedCuisines.get(-1) != null || this.selectedCuisines.get(-100) != null))) {
            return true;
        }
        if (restaurant.getCuisines() == null) {
            return false;
        }
        for (Cuisine cuisine : restaurant.getCuisines()) {
            if (this.selectedCuisines.get(cuisine.f13848id) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean isDeliveryFeesPassed(Restaurant restaurant) {
        int i11 = this.deliveryFees;
        if (i11 == -100) {
            return true;
        }
        if (i11 == 0) {
            if (restaurant.getDeliveryCharges() == 0.0f) {
                return true;
            }
            return false;
        } else if (restaurant.getDeliveryCharges() <= ((float) this.deliveryFees)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isDeliveryTimePassed(Restaurant restaurant) {
        if (this.minDeliveryTime != -100 && restaurant.getDeliveryTimeInteger() > this.minDeliveryTime) {
            return false;
        }
        return true;
    }

    private boolean isFilterConditionPassed(Restaurant restaurant) {
        SparseArrayCompat<Filter> sparseArrayCompat = this.selectedFilter;
        boolean z11 = true;
        if (!(sparseArrayCompat == null || sparseArrayCompat.size() == 0 || (this.selectedFilter.size() == 1 && this.selectedFilter.get(-1) != null))) {
            if (restaurant.getFiltersId() == null) {
                return false;
            }
            for (int i11 = 0; i11 < this.selectedFilter.size(); i11++) {
                if (!restaurant.getFiltersId().contains(Integer.valueOf(this.selectedFilter.keyAt(i11)))) {
                    z11 = false;
                }
            }
        }
        return z11;
    }

    private boolean isMinimumAmountPassed(Restaurant restaurant) {
        if (this.minOrderAmount != -100.0f && restaurant.getMinimumAmount() > this.minOrderAmount) {
            return false;
        }
        return true;
    }

    private boolean isRatingPassed(Restaurant restaurant) {
        return restaurant.getRating() > ((float) (this.restRating - 1));
    }

    private boolean isRestaurantVisible(Restaurant restaurant) {
        if (!isMinimumAmountPassed(restaurant) || !isDeliveryTimePassed(restaurant) || !isRatingPassed(restaurant) || !isCuisineConditionPassed(restaurant) || !isFilterConditionPassed(restaurant) || !isDeliveryFeesPassed(restaurant) || !isTalabatDeliveryRestaurantPassed(restaurant)) {
            return false;
        }
        return true;
    }

    private boolean isTalabatDeliveryRestaurantPassed(Restaurant restaurant) {
        if (this.showTalabatDeliveryRestaurants) {
            return restaurant.isTalabatGo;
        }
        return true;
    }

    public static void resetFilter() {
        GlobalDataModel.filterEngine = null;
    }

    public static void resetFilter(FilterEngine filterEngine) {
    }

    public ArrayList<Restaurant> filterRestaurants(List<Restaurant> list) {
        ArrayList arrayList = new ArrayList();
        for (Restaurant next : list) {
            if (isRestaurantVisible(next)) {
                arrayList.add(next);
            }
        }
        return new ArrayList<>(SponsoredSorting.with(arrayList));
    }

    public String getCuisineForTracking() {
        SparseArray<Cuisine> sparseArray = this.selectedCuisines;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return "All";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.selectedCuisines.valueAt(0).getName());
        for (int i11 = 1; i11 < this.selectedCuisines.size(); i11++) {
            sb2.append(",");
            sb2.append(this.selectedCuisines.valueAt(i11).getName());
        }
        return sb2.toString();
    }

    public int getDeepLinkSort() {
        return this.deepLinkSort;
    }

    public Cuisine getDeeplinkCuisine() {
        return this.deeplinkCuisine;
    }

    public String getFilterByForTracking() {
        SparseArrayCompat<Filter> sparseArrayCompat;
        StringBuilder sb2 = new StringBuilder();
        if (getIsFilterApplied() && (sparseArrayCompat = this.selectedFilter) != null && sparseArrayCompat.size() > 0) {
            for (int i11 = 0; i11 < this.selectedFilter.size(); i11++) {
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                SparseArrayCompat<Filter> sparseArrayCompat2 = this.selectedFilter;
                sb2.append(sparseArrayCompat2.get(sparseArrayCompat2.keyAt(i11)).getSlugName());
            }
        }
        return sb2.toString();
    }

    public boolean getIsCusinesSortApplied() {
        return isCuisineApplied();
    }

    public boolean getIsFilterApplied() {
        String str = this.deepLinkValue;
        if (str != null && !TextUtils.isEmpty(str) && getSelectedFilter().size() == 0) {
            SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
            Iterator<Filter> it = GlobalDataModel.filters.iterator();
            while (it.hasNext()) {
                Filter next = it.next();
                if (next.getDeepLink().toLowerCase().equals(this.deepLinkValue.toLowerCase())) {
                    sparseArrayCompat.put(next.getId(), next);
                }
            }
            setSelectedFilter((SparseArrayCompat<Filter>) sparseArrayCompat);
        }
        return this.isFilterApplied;
    }

    public boolean getIsSortApplied() {
        return isAnySortApplied();
    }

    public String getSelectedCuisineNames() {
        StringBuilder sb2 = new StringBuilder();
        SparseArray<Cuisine> sparseArray = this.selectedCuisines;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i11 = 0; i11 < this.selectedCuisines.size(); i11++) {
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                SparseArray<Cuisine> sparseArray2 = this.selectedCuisines;
                sb2.append(sparseArray2.get(sparseArray2.keyAt(i11)).f13849name);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public SparseArray<Cuisine> getSelectedCuisines() {
        SparseArray<Cuisine> sparseArray = this.selectedCuisines;
        if (sparseArray == null) {
            this.selectedCuisines = new SparseArray<>();
            Cuisine cuisine = new Cuisine();
            cuisine.f13848id = -100;
            this.selectedCuisines.put(-100, cuisine);
        } else if (sparseArray.size() == 0) {
            Cuisine cuisine2 = new Cuisine();
            cuisine2.f13848id = -100;
            this.selectedCuisines.put(-100, cuisine2);
        }
        return this.selectedCuisines;
    }

    public SparseArrayCompat<Filter> getSelectedFilter() {
        if (this.selectedFilter == null) {
            this.selectedFilter = new SparseArrayCompat<>();
        }
        return this.selectedFilter;
    }

    public List<Filter> getSelectedFiltersList() {
        ArrayList arrayList = new ArrayList();
        if (this.selectedFilter == null) {
            return arrayList;
        }
        for (int i11 = 0; i11 < this.selectedFilter.size(); i11++) {
            arrayList.add(this.selectedFilter.valueAt(i11));
        }
        return arrayList;
    }

    public int getSelectedSortBy() {
        return this.selectedSortBy;
    }

    public String getSortByForTracking() {
        int i11 = this.selectedSortBy;
        return i11 == 0 ? "a_z" : i11 == 4 ? "del_charges" : i11 == 3 ? "min_order" : i11 == 5 ? "del_time" : i11 == 1 ? DEEPLINKSORT.RATING : "recommended";
    }

    public boolean isAnyFilterApplied() {
        return this.isFilterApplied || this.showTalabatDeliveryRestaurants || this.minDeliveryTime > -100 || this.minOrderAmount > -100.0f || this.restRating > -100;
    }

    public boolean isAnyKindOfCollectionFilterApplied() {
        String str = this.deepLinkValue;
        if (str != null && !TextUtils.isEmpty(str) && getSelectedFilter().size() == 0 && GlobalDataModel.collectionFilters != null) {
            SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
            Iterator<Filter> it = GlobalDataModel.collectionFilters.iterator();
            while (it.hasNext()) {
                Filter next = it.next();
                if (next.getDeepLink().toLowerCase().equals(this.deepLinkValue.toLowerCase())) {
                    sparseArrayCompat.put(next.getId(), next);
                }
            }
            setSelectedFilter((SparseArrayCompat<Filter>) sparseArrayCompat);
        }
        int i11 = this.deepLinkSort;
        if (i11 != -100) {
            setSelectedSortBy(i11);
        }
        if (isAnyFilterApplied() || !isAnySortDefault() || getIsCusinesSortApplied()) {
            return true;
        }
        return false;
    }

    public boolean isAnyKindOfFilterApplied() {
        String str = this.deepLinkValue;
        if (str != null && !TextUtils.isEmpty(str) && getSelectedFilter().size() == 0 && GlobalDataModel.filters != null) {
            SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
            Iterator<Filter> it = GlobalDataModel.filters.iterator();
            while (it.hasNext()) {
                Filter next = it.next();
                if (next.getDeepLink().toLowerCase().equals(this.deepLinkValue.toLowerCase())) {
                    sparseArrayCompat.put(next.getId(), next);
                }
            }
            setSelectedFilter((SparseArrayCompat<Filter>) sparseArrayCompat);
        }
        int i11 = this.deepLinkSort;
        if (i11 != -100) {
            setSelectedSortBy(i11);
        }
        if (isAnyFilterApplied() || !isAnySortDefault() || isCuisineApplied()) {
            return true;
        }
        return false;
    }

    public boolean isAnySortApplied() {
        return this.selectedSortBy > -100;
    }

    public boolean isAnySortDefault() {
        int i11 = this.selectedSortBy;
        return (i11 == 6 || i11 == -100) && this.deepLinkSort == -100;
    }

    public boolean isCuisineApplied() {
        if (this.deeplinkCuisine != null) {
            SparseArray sparseArray = new SparseArray();
            if (GlobalDataModel.cuisines == null) {
                ArrayList<Cuisine> cuisineNames = getCuisineNames(GlobalDataModel.restaurants);
                Cuisine[] cuisineArr = new Cuisine[cuisineNames.size()];
                GlobalDataModel.cuisines = cuisineArr;
                cuisineNames.toArray(cuisineArr);
            }
            Cuisine[] cuisineArr2 = GlobalDataModel.cuisines;
            if (cuisineArr2 != null && cuisineArr2.length > 0) {
                Cuisine cuisine = new Cuisine();
                cuisine.f13848id = this.deeplinkCuisine.getId();
                int i11 = 0;
                while (true) {
                    Cuisine[] cuisineArr3 = GlobalDataModel.cuisines;
                    if (i11 >= cuisineArr3.length) {
                        break;
                    }
                    if (cuisineArr3[i11].getId() == cuisine.getId()) {
                        cuisine.f13849name = GlobalDataModel.cuisines[i11].f13849name;
                    }
                    i11++;
                }
                if (cuisine.getName() != null) {
                    sparseArray.put(cuisine.f13848id, cuisine);
                    setSelectedCuisines(sparseArray);
                }
            }
        }
        SparseArray<Cuisine> sparseArray2 = this.selectedCuisines;
        if (sparseArray2 == null || sparseArray2.size() <= 0) {
            return false;
        }
        SparseArray<Cuisine> sparseArray3 = this.selectedCuisines;
        if (sparseArray3.get(sparseArray3.keyAt(0)) == null) {
            return false;
        }
        SparseArray<Cuisine> sparseArray4 = this.selectedCuisines;
        if (sparseArray4.get(sparseArray4.keyAt(0)).f13848id != -100) {
            return true;
        }
        return false;
    }

    public void resetAppliedFilter() {
        this.isFilterApplied = false;
        this.selectedFilter = new SparseArrayCompat<>();
    }

    public void setCuisineFromApplink(String str) {
        Cuisine cuisine = new Cuisine();
        this.deeplinkCuisine = cuisine;
        cuisine.f13848id = Integer.parseInt(str);
    }

    public void setFilterFromDeeplink(String str, String str2) {
        if (str.equals("cuisine")) {
            try {
                for (String parseInt : str2.split(",")) {
                    Cuisine cuisine = new Cuisine();
                    this.deeplinkCuisine = cuisine;
                    cuisine.f13848id = Integer.parseInt(parseInt);
                }
            } catch (Exception unused) {
            }
        } else {
            this.deepLinkValue = str;
        }
    }

    public void setSelectedCuisines(SparseArray<Cuisine> sparseArray) {
        boolean z11;
        this.selectedCuisines = sparseArray;
        this.deeplinkCuisine = null;
        if (sparseArray == null || sparseArray.size() <= 0 || sparseArray.get(-1) != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.isCusinesSortApplied = z11;
    }

    public void setSelectedFilter(@Nullable List<Filter> list) {
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        if (list != null) {
            for (Filter next : list) {
                sparseArrayCompat.put(next.getId(), next);
            }
        }
        setSelectedFilter((SparseArrayCompat<Filter>) sparseArrayCompat);
    }

    public void setSelectedSortBy(int i11) {
        this.deepLinkSort = -100;
        this.selectedSortBy = i11;
    }

    public void setSortFromDeepLink(String str) {
        if (str.equals(DEEPLINKSORT.ALPHABETIC)) {
            setSelectedSortBy(0);
            this.deepLinkSort = 0;
        } else if (str.equals(DEEPLINKSORT.MINIMUMORDERAMOUNT)) {
            setSelectedSortBy(3);
            this.deepLinkSort = 3;
        } else if (str.equals("time")) {
            setSelectedSortBy(5);
            this.deepLinkSort = 5;
        } else if (str.equals(DEEPLINKSORT.RATING)) {
            setSelectedSortBy(1);
            this.deepLinkSort = 1;
        }
    }

    public ArrayList<Restaurant> sortRestaurant(ArrayList<Restaurant> arrayList) {
        int i11 = this.selectedSortBy;
        if (i11 == 0) {
            Collections.sort(arrayList, new RestauratNameComparator());
        } else if (i11 == 1) {
            Collections.sort(arrayList, new RestauratRating());
        } else if (i11 == 4) {
            Collections.sort(arrayList, new DeliveryCharges());
        } else if (i11 == 5) {
            Collections.sort(arrayList, new DeliveryTimeComparator());
        } else if (i11 == 3) {
            Collections.sort(arrayList, new MinimumOrderAmount());
        } else if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_MULTIPLE_CUISINE_SORTING, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            Collections.sort(arrayList, new CuisineAppliedFilterComparator(this.selectedCuisines));
        }
        return arrayList;
    }

    public static void resetFilter(FilterEngine filterEngine, boolean z11) {
        if (z11) {
            resetFilter();
        } else if (filterEngine != null) {
            filterEngine.resetAppliedFilter();
            filterEngine.minOrderAmount = -100.0f;
            filterEngine.minDeliveryTime = -100;
            filterEngine.restRating = -100;
            filterEngine.deliveryFees = -100;
            filterEngine.selectedSortBy = -100;
            filterEngine.showTalabatDeliveryRestaurants = false;
        }
    }

    public void setSelectedFilter(@Nullable SparseArrayCompat<Filter> sparseArrayCompat) {
        this.deepLinkValue = "";
        this.selectedFilter = sparseArrayCompat;
        this.isFilterApplied = sparseArrayCompat != null && sparseArrayCompat.size() > 0 && sparseArrayCompat.get(-1) == null;
    }

    public static void resetFilter(boolean z11) {
        if (z11) {
            resetFilter();
            return;
        }
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine != null) {
            filterEngine.resetAppliedFilter();
            FilterEngine filterEngine2 = GlobalDataModel.filterEngine;
            filterEngine2.minOrderAmount = -100.0f;
            filterEngine2.minDeliveryTime = -100;
            filterEngine2.restRating = -100;
            filterEngine2.deliveryFees = -100;
            filterEngine2.selectedSortBy = -100;
            filterEngine2.showTalabatDeliveryRestaurants = false;
        }
    }
}
