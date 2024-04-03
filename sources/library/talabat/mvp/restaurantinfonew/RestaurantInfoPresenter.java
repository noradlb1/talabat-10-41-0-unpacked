package library.talabat.mvp.restaurantinfonew;

import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;

public class RestaurantInfoPresenter implements IRestaurantInfoPresenter {
    private Restaurant restaurant;
    private RestaurantInfoView restaurantInfoView;

    public RestaurantInfoPresenter(RestaurantInfoView restaurantInfoView2) {
        this.restaurantInfoView = restaurantInfoView2;
        Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
        this.restaurant = restaurant2;
        if (restaurant2 == null) {
            restaurantInfoView2.onNoRestaurantFound();
        }
    }

    public String getAlternateDeliveryChargeText() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return "";
        } else if (restaurant2.talabatCharges > 0.0f) {
            if (!TalabatUtils.isNullOrEmpty(restaurant2.altTalabatText)) {
                return this.restaurant.altTalabatText;
            }
            return "t";
        } else if (!TalabatUtils.isNullOrEmpty(restaurant2.altDelChargetxt)) {
            return this.restaurant.altDelChargetxt;
        } else {
            if (this.restaurant.isTalabatGo) {
                return "s";
            }
            return "d";
        }
    }

    public String getAlternateMunicipalityTaxText() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.altMunicipalityText;
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public String getAlternateTouristTaxText() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return "";
        } else if (!TalabatUtils.isNullOrEmpty(restaurant2.altTouristTaxText)) {
            return this.restaurant.altTouristTaxText;
        } else {
            return null;
        }
    }

    public String getAreaName() {
        return GlobalDataModel.SelectedAreaName;
    }

    public String getCuisines() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getCuisineString();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public float getDeliveryChargeCompare() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return 0.0f;
        }
        float deliveryCharges = restaurant2.getDeliveryCharges();
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3.talabatCharges > 0.0f) {
            return restaurant3.getTalabatCharges();
        }
        return deliveryCharges;
    }

    public String getDeliveryCharges() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return "";
        }
        String displayDeliveryCharges = restaurant2.getDisplayDeliveryCharges();
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3.talabatCharges > 0.0f) {
            return restaurant3.getDisplayTalabatCharge();
        }
        return displayDeliveryCharges;
    }

    public String getDeliveryTime() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getDeliveryTime();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public String getMinimumOrder() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getDisplayMinimumAmount();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public String getMunicipalityTax() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getDisplayMunicipalityTax();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public boolean getMunicipalityTaxVisibility() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return false;
        } else if (restaurant2.municipalityTax > 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    public float getRate() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getRating();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return 0.0f;
    }

    public String getRateCount() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getTotalRating();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public Restaurant getRestaurant() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2;
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return new Restaurant();
    }

    public String getRestaurantLogo() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getLogo();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public String getRestaurantName() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getName();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public int getStatus() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.statusType;
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return 0;
    }

    public String getTouristTax() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getDisplayTouristTax();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public boolean getTouristTaxVisibility() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            this.restaurantInfoView.onNoRestaurantFound();
            return false;
        } else if (restaurant2.touristTax > 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    public String getWorkinghrs() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getDeliverySchedule();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return "";
    }

    public boolean isAcceptCash() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.acceptsCash;
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return false;
    }

    public boolean isAcceptCreditCard() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.isAcceptsCredit();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return false;
    }

    public boolean isAcceptDebitCard() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.isAcceptsDebit();
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return false;
    }

    public boolean isPostDatedDelivery() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.hasPreOrderOnClosed;
        }
        this.restaurantInfoView.onNoRestaurantFound();
        return false;
    }

    public void onDestroy() {
        this.restaurantInfoView = null;
    }
}
