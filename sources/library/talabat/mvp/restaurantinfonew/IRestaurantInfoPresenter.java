package library.talabat.mvp.restaurantinfonew;

import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IRestaurantInfoPresenter extends IGlobalPresenter {
    String getAlternateDeliveryChargeText();

    String getAlternateMunicipalityTaxText();

    String getAlternateTouristTaxText();

    String getAreaName();

    String getCuisines();

    float getDeliveryChargeCompare();

    String getDeliveryCharges();

    String getDeliveryTime();

    String getMinimumOrder();

    String getMunicipalityTax();

    boolean getMunicipalityTaxVisibility();

    float getRate();

    String getRateCount();

    Restaurant getRestaurant();

    String getRestaurantLogo();

    String getRestaurantName();

    int getStatus();

    String getTouristTax();

    boolean getTouristTaxVisibility();

    String getWorkinghrs();

    boolean isAcceptCash();

    boolean isAcceptCreditCard();

    boolean isAcceptDebitCard();

    boolean isPostDatedDelivery();
}
