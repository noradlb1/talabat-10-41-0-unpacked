package datamodels;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.sponsors.Sponsored;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.flutter.channels.E2ETestChannel;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatParser;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public class Restaurant implements Parcelable, Serializable, Comparable<Restaurant>, Sponsored {
    public static final int BUSY = 2;
    public static final int CLOSED = 1;
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        public Restaurant createFromParcel(Parcel parcel) {
            return new Restaurant(parcel);
        }

        public Restaurant[] newArray(int i11) {
            return new Restaurant[i11];
        }
    };
    public static final int FIXED = 0;
    public static final long NOT_SPONSORED = 9999;
    public static final int OPEN = 0;
    public static final int OPEN_FOR_PREORDER = 5;
    public static final int PERCENT = 1;
    public static final int PRAYER = 4;
    @SerializedName("dct")
    public int DeliveryChargestype;
    @SerializedName("mtyp")
    public int MuncipalityChargestype;
    @SerializedName("ttyp")
    public int TouristChargetype;
    @SerializedName("acod")
    public boolean acceptsCCOnDel;
    @SerializedName("ac")
    public boolean acceptsCash;
    @SerializedName("acr")
    public boolean acceptsCredit;
    @SerializedName("adb")
    public boolean acceptsDebit;
    public Date activatedDate;
    @SerializedName("act")
    public String activatedon;
    public float adjustedDeliveryCharges;
    private String allOrderDiscountText = "";
    @SerializedName("adc")
    public String altDelChargetxt;
    @SerializedName("amt")
    public String altMunicipalityText;
    @SerializedName("atbt")
    public String altTalabatText;
    @SerializedName("att")
    public String altTouristTaxText;
    @SerializedName("aid")
    public int areaId;
    @SerializedName("an")
    public String areaName;
    @SerializedName("otxt")
    public String betterOfferText = "";
    @SerializedName("bid")
    public int branchId;
    @SerializedName("bna")
    public String branchName;
    @SerializedName("bsl")
    public String branchNameSlug;
    public int cuinseCount = 0;
    @SerializedName("cus")
    public Cuisine[] cuisines;
    private String cuisinesText = "";
    public int[] delAreas;
    @SerializedName("delay_text")
    @Nullable
    private String delayLabel;
    @SerializedName("dch")
    public float deliveryCharges;
    @SerializedName("delivery_text")
    @Nullable
    private String deliveryModeLabel;
    @SerializedName("dls")
    public String deliverySchedule;
    @SerializedName("avd")
    public String deliveryTime;
    @SerializedName("delivery_icon_type")
    @Nullable
    private String deliveryTimeIcon;
    @SerializedName("dtim")
    public String deliveryTimeInteger;
    @SerializedName("dcl")
    public String desclaimer;
    @SerializedName("dgr")
    public boolean disableGeneralRequest;
    @SerializedName("dsir")
    public boolean disableItemSpecialRequest;
    @SerializedName("dlnk")
    public String disclaimerLink = "";
    @SerializedName("mdis")
    public int discountCount;
    @SerializedName("dtxt")
    public String discountDiscription;
    @SerializedName("htc")
    public boolean excludeDiscountCouponforTax = false;
    @SerializedName("fids")
    public ArrayList<Integer> filtersId;
    @SerializedName("gid")
    public int groupId;
    @SerializedName("hsp")
    public boolean hasPreOrderOnClosed;
    @SerializedName("hrd")
    public boolean hasRamadanDeals;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13872id;
    @SerializedName("htd")
    public boolean includeDeliveryChargeInTax = false;
    @SerializedName("isVatInc")
    public boolean inclusiveVat;
    @SerializedName("iccm")
    public boolean isCokeMealEnabled;
    @SerializedName("icr")
    public boolean isCokeRestaurant;
    @SerializedName("cav")
    public boolean isCouponAvailable;
    @SerializedName("isds")
    public boolean isDarkStore = false;
    @SerializedName("ida")
    public boolean isDiscountAvaialble;
    @SerializedName("isfof")
    public boolean isFirstOrderFree;
    @SerializedName("fm")
    public boolean isForceMap;
    @SerializedName("rgrl")
    public boolean isGlrEnabled;
    @SerializedName("mav")
    public boolean isMealDealAvailable;
    @SerializedName("ismgrtd")
    public boolean isMigrated = false;
    @SerializedName("isn")
    public boolean isNewRestaurant;
    @SerializedName("inc")
    public boolean isNineCookiesEnabledRestaurant;
    private boolean isPickup = false;
    @SerializedName("isTalabatPro")
    public boolean isProRestaurant;
    @SerializedName("ipa")
    public boolean isPromotionAvailable;
    public boolean isRecommendation;
    @SerializedName("cld")
    public boolean isSafeDropOff;
    @SerializedName("iscod")
    public boolean isSoftPosSupported;
    @SerializedName("iss")
    public boolean isSponsered;
    @SerializedName("isub")
    public boolean isSubscriptionAvailable;
    @SerializedName("is_tstar")
    public boolean isTStar;
    @SerializedName("itg")
    public boolean isTalabatGo;
    @SerializedName("ius")
    public boolean isUpSelling;
    @SerializedName("hasv")
    public boolean isVoucherEnabled;
    @SerializedName("ism")
    public boolean ismixoffer;
    public int itemDisplayed = 0;
    public int itemPosition = 0;
    @SerializedName("lat")
    public double latitude;
    @SerializedName("lg")
    public String logo;
    public String logoUrl;
    @SerializedName("lon")
    public double longitude;
    @SerializedName("mentyp")
    @Nullable
    private Integer menuType;
    @SerializedName("mna")
    public float minimumAmount;
    @SerializedName("mofs")
    public int moreOffers = 0;
    @SerializedName("mcc")
    public float municipalityTax;
    @SerializedName("na")

    /* renamed from: name  reason: collision with root package name */
    public String f13873name;
    @SerializedName("sl")
    public String nameSlug;
    @SerializedName("pickup_voucher_code")
    private String pickupDiscountCode;
    @SerializedName("pickup_voucher_text")
    private String pickupDiscountDisplayText;
    private String pickupDiscountText = "";
    @SerializedName(alternate = {"sldk"}, value = "pickupDistanceInKm")
    private String pickupDistanceInKm = "0.0";
    @SerializedName("pmsg")
    public String preOderMessage;
    @SerializedName("spd")
    public PremiumType premiumType;
    @SerializedName("prtg")
    public int priceTag;
    @SerializedName("mpro")
    public int promotionCount;
    @SerializedName("ptxt")
    public String promotionDiscription;
    @SerializedName("ipos")
    public boolean provideOrderSatus;
    @SerializedName("ipt")
    public boolean providesTrackorder;
    @SerializedName("rat")
    public float rating;
    private String ratingText = "";
    @SerializedName("smr")
    public String restSummary;
    @SerializedName("verticalType")
    public int shopType;
    @SerializedName("iush")
    public boolean showUpsellHighLight;
    @SerializedName("sponsored_rank")
    public long sponsoredRank = 9999;
    private String statusText = "";
    @SerializedName("stt")
    public int statusType;
    public int swimlanePosition = 0;
    @SerializedName("tstar_desc")
    @Nullable
    public String tStarLabel;
    @SerializedName("ftgs")
    List<String> tags;
    @SerializedName("tch")
    public float talabatCharges;
    @SerializedName("gtl")
    public String talabatGoCoverImg;
    @SerializedName("trt")
    public String totalRating;
    @SerializedName("trts")
    public String totalRatingNonformatted;
    @SerializedName("trc")
    public float touristTax;
    @SerializedName("ust")
    public String upSellingText;
    @SerializedName("uscomid")
    public int upsellId;
    @SerializedName("uscom")
    public String upsellName;
    @SerializedName("usicon")
    public String upsellingIcon;
    @SerializedName("verticals")
    public List<Integer> verticals;

    public static class PremiumType implements Serializable {
        @SerializedName("cat")
        public String category;
        @SerializedName("token")
        @Nullable
        public String token;
        @SerializedName("type")
        public String type;
    }

    public Restaurant() {
    }

    public String GACuisineString() {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr.length <= 0) {
            return "";
        }
        if (cuisineArr.length >= 3) {
            i11 = 2;
        } else {
            i11 = cuisineArr.length - 1;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(this.cuisines[i12].f13849name);
        }
        return sb2.toString();
    }

    public String deliveryMode() {
        return this.isPickup ? "pickup" : "rider";
    }

    public int describeContents() {
        return 0;
    }

    public float getAdjustedDeliveryCharges() {
        return this.adjustedDeliveryCharges;
    }

    public String getAllOrderDiscountText() {
        return this.allOrderDiscountText;
    }

    public int getAvailabilityStatus() {
        int i11 = this.statusType;
        if (i11 == 1) {
            return 3;
        }
        int i12 = 2;
        if (i11 != 2) {
            i12 = 4;
            if (i11 != 4) {
                return i11 != 5 ? 0 : 1;
            }
        }
        return i12;
    }

    public int getBranchId() {
        return this.branchId;
    }

    public String getBranchNameSlug() {
        String str = this.branchNameSlug;
        return str != null ? str : "";
    }

    public Date getCreatedDate() {
        if (this.activatedDate == null) {
            try {
                this.activatedDate = new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT).parse(this.activatedon);
            } catch (ParseException unused) {
            }
        }
        return this.activatedDate;
    }

    public String getCuisine1() {
        if (getNumberOfCuisines() > 0) {
            return this.cuisines[0].getName();
        }
        return "";
    }

    public String getCuisine3() {
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr.length > 2) {
            return cuisineArr[2].getName();
        }
        return "";
    }

    public String getCuisineString() {
        StringBuilder sb2 = new StringBuilder();
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr != null) {
            for (Cuisine cuisine : cuisineArr) {
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(cuisine.getName());
            }
        }
        return sb2.toString();
    }

    public Cuisine[] getCuisines() {
        return this.cuisines;
    }

    public String getCuisinesJson() {
        JSONArray jSONArray = new JSONArray();
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr != null) {
            for (Cuisine name2 : cuisineArr) {
                jSONArray.put((Object) name2.getName());
            }
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    public String getCuisinesText() {
        return this.cuisinesText;
    }

    public String getCusine2() {
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr.length > 1) {
            return cuisineArr[1].getName();
        }
        return "";
    }

    public int[] getDelAreas() {
        return this.delAreas;
    }

    @Nullable
    public String getDelayLabel() {
        return this.delayLabel;
    }

    public float getDeliveryCharges() {
        return this.deliveryCharges;
    }

    public int getDeliveryChargestype() {
        return this.DeliveryChargestype;
    }

    @Nullable
    public String getDeliveryModeLabel() {
        return this.deliveryModeLabel;
    }

    public String getDeliverySchedule() {
        String[] split;
        String str = this.deliverySchedule;
        if (str == null || (split = str.replace("\\n", "#").split("#")) == null) {
            return "";
        }
        if (split.length <= 1) {
            return split[0];
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : split) {
            if (sb2.length() > 0) {
                sb2.append(10);
            }
            sb2.append(str2);
        }
        return new String(sb2);
    }

    public String getDeliveryTime() {
        return this.deliveryTime;
    }

    @Nullable
    public String getDeliveryTimeIcon() {
        return this.deliveryTimeIcon;
    }

    public int getDeliveryTimeInteger() {
        return TalabatParser.toInt(this.deliveryTimeInteger);
    }

    public int getDiscountCount() {
        return this.discountCount;
    }

    public String getDiscountDiscription() {
        return this.discountDiscription;
    }

    public String getDisplayDeliveryCharges() {
        if (this.DeliveryChargestype != 1) {
            return TalabatFormatter.getInstance().getFormattedCurrency(this.deliveryCharges);
        }
        return Math.round(this.deliveryCharges) + " %";
    }

    public String getDisplayDeliveryChargesForList() {
        if (this.DeliveryChargestype != 1) {
            return TalabatFormatter.getInstance().getFormattedCurrency(this.deliveryCharges, false);
        }
        return Math.round(this.deliveryCharges) + " %";
    }

    public String getDisplayDynamicMinimumAmount(float f11, boolean z11, float f12) {
        float minimumAmount2 = getMinimumAmount();
        if (z11) {
            minimumAmount2 += f12;
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(minimumAmount2 - f11);
    }

    public String getDisplayMinimumAmount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(getMinimumAmount());
    }

    public String getDisplayMinimumAmountWithoutCurrency(Customer customer) {
        return TalabatFormatter.getInstance().getFormattedCurrency(getMinimumAmount(), false);
    }

    public String getDisplayMunicipalityTax() {
        if (this.MuncipalityChargestype != 1) {
            return TalabatFormatter.getInstance().getFormattedCurrency(getMunicipalityTax());
        }
        return Math.round(getMunicipalityTax()) + " %";
    }

    public String getDisplayTalabatCharge() {
        return TalabatFormatter.getInstance().getFormattedCurrency(getTalabatCharges());
    }

    public String getDisplayTouristTax() {
        if (this.TouristChargetype != 1) {
            return TalabatFormatter.getInstance().getFormattedCurrency(getTouristTax());
        }
        return Math.round(getTouristTax()) + " %";
    }

    public ArrayList<Integer> getFiltersId() {
        return this.filtersId;
    }

    public String getHeroLogo() {
        this.logo = this.logo.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.logo;
    }

    public int getId() {
        return this.f13872id;
    }

    public String getLogo() {
        String str = this.logo;
        if (str == null || str.isEmpty()) {
            return "";
        }
        this.logo = this.logo.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.logo;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public int getMenuType() {
        Integer num = this.menuType;
        if (num != null) {
            return num.intValue();
        }
        return this.shopType;
    }

    public float getMinimumAmount() {
        return this.minimumAmount;
    }

    public float getMunicipalityTax() {
        return this.municipalityTax;
    }

    public String getName() {
        return this.f13873name;
    }

    public String getNameSlug() {
        String str = this.nameSlug;
        return str != null ? str : "";
    }

    public int getNumberOfCuisines() {
        Cuisine[] cuisineArr = this.cuisines;
        if (cuisineArr != null) {
            return cuisineArr.length;
        }
        return 0;
    }

    public String getPaymentMethods() {
        StringBuilder sb2 = new StringBuilder();
        if (this.acceptsCash) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append("cash");
        }
        if (this.acceptsDebit) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append("debit_card");
        }
        if (this.acceptsCredit) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD);
        }
        return sb2.toString();
    }

    public String getPickupDiscountCode() {
        return this.pickupDiscountCode;
    }

    public String getPickupDiscountDisplayText() {
        return this.pickupDiscountDisplayText;
    }

    public String getPickupDiscountText() {
        return this.pickupDiscountText;
    }

    public String getPickupDistanceKm() {
        return this.pickupDistanceInKm;
    }

    public PremiumType getPremiumType() {
        return this.premiumType;
    }

    public int getPromotionCount() {
        return this.promotionCount;
    }

    public String getPromotionDiscription() {
        return this.promotionDiscription;
    }

    public float getRating() {
        return this.rating;
    }

    public String getRatingText() {
        return this.ratingText;
    }

    public Location getRestaurantLocation() {
        Location location = new Location("");
        location.setLatitude(this.latitude);
        location.setLongitude(this.longitude);
        return location;
    }

    public String getRestaurantType() {
        if (this.isTalabatGo) {
            return "TGO";
        }
        if (this.providesTrackorder) {
            return "9C";
        }
        if (this.provideOrderSatus) {
            return "notifications";
        }
        return "shop_delivery";
    }

    public String getShopType() {
        switch (this.shopType) {
            case 0:
                return "Restaurant";
            case 1:
                return "Grocery";
            case 2:
                return E2ETestChannel.PHARMACY_TEST;
            case 3:
                return "Flowers";
            case 4:
                return "Electronics";
            case 5:
                return "PetShop";
            case 6:
                return "Cosmetic";
            default:
                return "Undefined";
        }
    }

    public long getSponsoredRank() {
        return this.sponsoredRank;
    }

    public String getStatusText() {
        return this.statusText;
    }

    @NonNull
    public List<String> getTags() {
        List<String> list = this.tags;
        return list != null ? list : new ArrayList();
    }

    public float getTalabatCharges() {
        return this.talabatCharges;
    }

    public String getTalabatCoverLogo() {
        this.talabatGoCoverImg = this.talabatGoCoverImg.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.talabatGoCoverImg;
    }

    public String getTotalRating() {
        return this.totalRating;
    }

    public String getTotalRatingNonformatted() {
        return this.totalRatingNonformatted;
    }

    public float getTouristTax() {
        return this.touristTax;
    }

    public String getType() {
        if (this.isTalabatGo) {
            return "talabat_go";
        }
        if (this.isNineCookiesEnabledRestaurant) {
            return FilterEngine.DEEPLINKFILER.NINECOOKIESRESTAURANTS;
        }
        return "normal";
    }

    public String getUpselingHeaderIcon() {
        if (TalabatUtils.isNullOrEmpty(this.upsellingIcon)) {
            return "";
        }
        this.upsellingIcon = this.upsellingIcon.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.upsellingIcon;
    }

    public int getUpsellId() {
        return this.upsellId;
    }

    public String getUpsellImage() {
        if (TextUtils.isEmpty(this.upsellingIcon)) {
            return "";
        }
        this.upsellingIcon = this.upsellingIcon.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.upsellingIcon;
    }

    public String getUpsellName() {
        return this.upsellName;
    }

    public List<Integer> getVerticals() {
        return this.verticals;
    }

    public boolean hasCuisine2() {
        return this.cuinseCount > 1;
    }

    public boolean hasCuisine3() {
        return this.cuinseCount > 2;
    }

    public boolean hasCusine() {
        int numberOfCuisines = getNumberOfCuisines();
        this.cuinseCount = numberOfCuisines;
        return numberOfCuisines != 0;
    }

    public boolean isAcceptsCCOnDel() {
        return this.acceptsCCOnDel;
    }

    public boolean isAcceptsCredit() {
        return this.acceptsCredit;
    }

    public boolean isAcceptsDebit() {
        return this.acceptsDebit;
    }

    public boolean isCokeMealEnabled() {
        return this.isCokeMealEnabled;
    }

    public boolean isCouponAvailable() {
        return this.isCouponAvailable;
    }

    public boolean isDiscountAvaialble() {
        return this.isDiscountAvaialble;
    }

    public boolean isHasRamadanDeals() {
        return this.hasRamadanDeals;
    }

    public boolean isMealDealAvailable() {
        return this.isMealDealAvailable;
    }

    public Boolean isPickup() {
        return Boolean.valueOf(this.isPickup);
    }

    public boolean isPromotionAvailable() {
        return this.isPromotionAvailable;
    }

    public boolean isRecommendation() {
        return this.isRecommendation;
    }

    public boolean isSafeDropOff() {
        return this.isSafeDropOff;
    }

    public boolean isSubscriptionAvailable() {
        return this.isSubscriptionAvailable;
    }

    public boolean isTMart() {
        return this.isDarkStore && !this.isMigrated;
    }

    public boolean isVoucherEnabled() {
        return this.isVoucherEnabled;
    }

    public void setAcceptsCCOnDel(boolean z11) {
        this.acceptsCCOnDel = z11;
    }

    public void setAcceptsCredit(boolean z11) {
        this.acceptsCredit = z11;
    }

    public void setAcceptsDebit(boolean z11) {
        this.acceptsDebit = z11;
    }

    public void setAdjustedDeliveryCharges(float f11) {
        this.adjustedDeliveryCharges = f11;
    }

    public void setAllOrderDiscountText(String str) {
        this.allOrderDiscountText = str;
    }

    public void setBranchNameSlug(String str) {
        this.branchNameSlug = str;
    }

    public void setCokeMealEnabled(boolean z11) {
        this.isCokeMealEnabled = z11;
    }

    public void setCuisines(Cuisine[] cuisineArr) {
        this.cuisines = cuisineArr;
        this.cuinseCount = getNumberOfCuisines();
    }

    public void setCuisinesText(String str) {
        this.cuisinesText = str;
    }

    public void setDelAreas(DeliveryArea[] deliveryAreaArr) {
        this.delAreas = new int[deliveryAreaArr.length];
        for (int i11 = 0; i11 < deliveryAreaArr.length; i11++) {
            this.delAreas[i11] = deliveryAreaArr[i11].f13835id;
        }
    }

    public void setDelayLabel(@Nullable String str) {
        this.delayLabel = str;
    }

    public void setDeliveryCharges(float f11) {
        this.deliveryCharges = f11;
    }

    public void setDeliveryModeLabel(@Nullable String str) {
        this.deliveryModeLabel = str;
    }

    public void setDeliveryTime(String str) {
        this.deliveryTime = str;
    }

    public void setDeliveryTimeInteger(String str) {
        this.deliveryTimeInteger = str;
    }

    public void setDiscountAvaialble(boolean z11) {
        this.isDiscountAvaialble = z11;
    }

    public void setDiscountCount(int i11) {
        this.discountCount = i11;
    }

    public void setDiscountDiscription(String str) {
        this.discountDiscription = str;
    }

    public void setHasRamadanDeals(boolean z11) {
        this.hasRamadanDeals = z11;
    }

    public void setId(int i11) {
        this.f13872id = i11;
    }

    public void setIsCouponAvailable(boolean z11) {
        this.isCouponAvailable = z11;
    }

    public void setIsMealDealAvailable(boolean z11) {
        this.isMealDealAvailable = z11;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setMenuType(int i11) {
        this.menuType = Integer.valueOf(i11);
    }

    public void setMinimumAmount(float f11) {
        this.minimumAmount = f11;
    }

    public void setMunicipalityTax(float f11) {
        this.municipalityTax = f11;
    }

    public void setName(String str) {
        this.f13873name = str;
    }

    public void setNameSlug(String str) {
        this.nameSlug = str;
    }

    public void setPickup(Boolean bool) {
        this.isPickup = bool.booleanValue();
    }

    public void setPickupDiscountCode(String str) {
        this.pickupDiscountCode = str;
    }

    public void setPickupDiscountDisplayText(String str) {
        this.pickupDiscountDisplayText = str;
    }

    public void setPickupDiscountText(String str) {
        this.pickupDiscountText = str;
    }

    public void setPickupDistanceInKm(String str) {
        this.pickupDistanceInKm = str;
    }

    public void setPromotionAvailable(boolean z11) {
        this.isPromotionAvailable = z11;
    }

    public void setPromotionCount(int i11) {
        this.promotionCount = i11;
    }

    public void setPromotionDiscription(String str) {
        this.promotionDiscription = str;
    }

    public void setRating(float f11) {
        this.rating = f11;
    }

    public void setRatingText(String str) {
        this.ratingText = str;
    }

    public void setRecommendation(boolean z11) {
        this.isRecommendation = z11;
    }

    public void setSafeDropOff(boolean z11) {
        this.isSafeDropOff = z11;
    }

    public void setStatusText(String str) {
        this.statusText = str;
    }

    public void setTags(@NonNull List<String> list) {
        this.tags = list;
    }

    public void setTouristTax(float f11) {
        this.touristTax = f11;
    }

    public void setVerticals(List<Integer> list) {
        this.verticals = list;
    }

    public boolean shouldDisableSpecialRequest() {
        return this.disableItemSpecialRequest;
    }

    @NonNull
    public String toString() {
        return "{ id: " + this.f13872id + ", name: " + this.f13873name + " }";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        long j11;
        parcel.writeInt(this.itemPosition);
        parcel.writeInt(this.f13872id);
        parcel.writeString(this.f13873name);
        parcel.writeString(this.branchName);
        parcel.writeInt(this.groupId);
        parcel.writeString(this.areaName);
        parcel.writeInt(this.areaId);
        parcel.writeFloat(this.rating);
        parcel.writeString(this.totalRating);
        parcel.writeString(this.totalRatingNonformatted);
        parcel.writeInt(this.branchId);
        parcel.writeString(this.deliveryTime);
        parcel.writeByte(this.acceptsCash ? (byte) 1 : 0);
        parcel.writeByte(this.acceptsDebit ? (byte) 1 : 0);
        parcel.writeByte(this.acceptsCredit ? (byte) 1 : 0);
        parcel.writeByte(this.acceptsCCOnDel ? (byte) 1 : 0);
        parcel.writeByte(this.isCouponAvailable ? (byte) 1 : 0);
        parcel.writeByte(this.isMealDealAvailable ? (byte) 1 : 0);
        parcel.writeFloat(this.municipalityTax);
        parcel.writeFloat(this.touristTax);
        parcel.writeFloat(this.talabatCharges);
        parcel.writeString(this.deliverySchedule);
        parcel.writeInt(this.cuinseCount);
        parcel.writeByte(this.hasPreOrderOnClosed ? (byte) 1 : 0);
        parcel.writeInt(this.statusType);
        parcel.writeByte(this.ismixoffer ? (byte) 1 : 0);
        parcel.writeString(this.preOderMessage);
        parcel.writeInt(this.DeliveryChargestype);
        parcel.writeInt(this.MuncipalityChargestype);
        parcel.writeInt(this.TouristChargetype);
        parcel.writeByte(this.isNewRestaurant ? (byte) 1 : 0);
        parcel.writeString(this.altDelChargetxt);
        parcel.writeString(this.altMunicipalityText);
        parcel.writeString(this.altTouristTaxText);
        parcel.writeString(this.altTalabatText);
        parcel.writeByte(this.isSponsered ? (byte) 1 : 0);
        parcel.writeString(this.restSummary);
        parcel.writeString(this.desclaimer);
        parcel.writeString(this.activatedon);
        parcel.writeByte(this.includeDeliveryChargeInTax ? (byte) 1 : 0);
        parcel.writeByte(this.excludeDiscountCouponforTax ? (byte) 1 : 0);
        Date date = this.activatedDate;
        if (date != null) {
            j11 = date.getTime();
        } else {
            j11 = -1;
        }
        parcel.writeLong(j11);
        parcel.writeByte(this.isForceMap ? (byte) 1 : 0);
        parcel.writeByte(this.isNineCookiesEnabledRestaurant ? (byte) 1 : 0);
        parcel.writeByte(this.isTalabatGo ? (byte) 1 : 0);
        parcel.writeIntArray(this.delAreas);
        parcel.writeString(this.logo);
        parcel.writeFloat(this.minimumAmount);
        parcel.writeString(this.deliveryTimeInteger);
        parcel.writeFloat(this.deliveryCharges);
        parcel.writeTypedArray(this.cuisines, i11);
        parcel.writeByte(this.inclusiveVat ? (byte) 1 : 0);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeByte(this.providesTrackorder ? (byte) 1 : 0);
        parcel.writeByte(this.provideOrderSatus ? (byte) 1 : 0);
        parcel.writeString(this.talabatGoCoverImg);
        parcel.writeByte(this.isUpSelling ? (byte) 1 : 0);
        parcel.writeByte(this.isCokeRestaurant ? (byte) 1 : 0);
        parcel.writeString(this.upSellingText);
        parcel.writeString(this.upsellingIcon);
        parcel.writeString(this.branchNameSlug);
        parcel.writeString(this.nameSlug);
        parcel.writeByte(this.showUpsellHighLight ? (byte) 1 : 0);
        parcel.writeByte(this.isGlrEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.isCokeMealEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.isDiscountAvaialble ? (byte) 1 : 0);
        parcel.writeString(this.discountDiscription);
        parcel.writeInt(this.discountCount);
        parcel.writeByte(this.isPromotionAvailable ? (byte) 1 : 0);
        parcel.writeString(this.promotionDiscription);
        parcel.writeInt(this.promotionCount);
        parcel.writeByte(this.hasRamadanDeals ? (byte) 1 : 0);
        parcel.writeString(this.upsellName);
        parcel.writeInt(this.upsellId);
        parcel.writeInt(this.priceTag);
        parcel.writeByte(this.isSubscriptionAvailable ? (byte) 1 : 0);
        parcel.writeByte(this.isSafeDropOff ? (byte) 1 : 0);
        parcel.writeByte(this.isSoftPosSupported ? (byte) 1 : 0);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.allOrderDiscountText);
        parcel.writeString(this.ratingText);
        parcel.writeString(this.statusText);
        parcel.writeString(this.pickupDiscountText);
        parcel.writeString(this.pickupDistanceInKm);
        parcel.writeByte(this.isPickup ? (byte) 1 : 0);
        parcel.writeByte(this.isProRestaurant ? (byte) 1 : 0);
        parcel.writeByte(this.isTStar ? (byte) 1 : 0);
        parcel.writeString(this.tStarLabel);
        parcel.writeString(this.delayLabel);
        parcel.writeString(this.deliveryTimeIcon);
        parcel.writeString(this.deliveryModeLabel);
    }

    public int compareTo(Restaurant restaurant) {
        List asList = Arrays.asList(new Integer[]{0, 5, 2, 1});
        return asList.indexOf(Integer.valueOf(this.statusType)) - asList.indexOf(Integer.valueOf(restaurant.statusType));
    }

    public String getTalabatCoverLogo(int i11, int i12) {
        this.talabatGoCoverImg = this.talabatGoCoverImg.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.talabatGoCoverImg + "?height=" + i11 + "&width=" + i12;
    }

    public Restaurant(Parcel parcel) {
        Date date;
        boolean z11 = false;
        this.itemPosition = parcel.readInt();
        this.f13872id = parcel.readInt();
        this.f13873name = parcel.readString();
        this.branchName = parcel.readString();
        this.groupId = parcel.readInt();
        this.areaName = parcel.readString();
        this.areaId = parcel.readInt();
        this.rating = parcel.readFloat();
        this.totalRating = parcel.readString();
        this.totalRatingNonformatted = parcel.readString();
        this.branchId = parcel.readInt();
        this.deliveryTime = parcel.readString();
        this.acceptsCash = parcel.readByte() != 0;
        this.acceptsDebit = parcel.readByte() != 0;
        this.acceptsCredit = parcel.readByte() != 0;
        this.acceptsCCOnDel = parcel.readByte() != 0;
        this.isCouponAvailable = parcel.readByte() != 0;
        this.isMealDealAvailable = parcel.readByte() != 0;
        this.municipalityTax = parcel.readFloat();
        this.touristTax = parcel.readFloat();
        this.talabatCharges = parcel.readFloat();
        this.deliverySchedule = parcel.readString();
        this.cuinseCount = parcel.readInt();
        this.hasPreOrderOnClosed = parcel.readByte() != 0;
        this.statusType = parcel.readInt();
        this.ismixoffer = parcel.readByte() != 0;
        this.preOderMessage = parcel.readString();
        this.DeliveryChargestype = parcel.readInt();
        this.MuncipalityChargestype = parcel.readInt();
        this.TouristChargetype = parcel.readInt();
        this.isNewRestaurant = parcel.readByte() != 0;
        this.altDelChargetxt = parcel.readString();
        this.altMunicipalityText = parcel.readString();
        this.altTouristTaxText = parcel.readString();
        this.altTalabatText = parcel.readString();
        this.isSponsered = parcel.readByte() != 0;
        this.restSummary = parcel.readString();
        this.desclaimer = parcel.readString();
        this.activatedon = parcel.readString();
        this.includeDeliveryChargeInTax = parcel.readByte() != 0;
        this.excludeDiscountCouponforTax = parcel.readByte() != 0;
        long readLong = parcel.readLong();
        if (readLong == -1) {
            date = null;
        } else {
            date = new Date(readLong);
        }
        this.activatedDate = date;
        this.isForceMap = parcel.readByte() != 0;
        this.isNineCookiesEnabledRestaurant = parcel.readByte() != 0;
        this.isTalabatGo = parcel.readByte() != 0;
        this.delAreas = parcel.createIntArray();
        this.logo = parcel.readString();
        this.minimumAmount = parcel.readFloat();
        this.deliveryTimeInteger = parcel.readString();
        this.deliveryCharges = parcel.readFloat();
        this.cuisines = (Cuisine[]) parcel.createTypedArray(Cuisine.CREATOR);
        this.inclusiveVat = parcel.readByte() != 0;
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.providesTrackorder = parcel.readByte() != 0;
        this.provideOrderSatus = parcel.readByte() != 0;
        this.talabatGoCoverImg = parcel.readString();
        this.isUpSelling = parcel.readByte() != 0;
        this.isCokeRestaurant = parcel.readByte() != 0;
        this.upSellingText = parcel.readString();
        this.upsellingIcon = parcel.readString();
        this.branchNameSlug = parcel.readString();
        this.nameSlug = parcel.readString();
        this.showUpsellHighLight = parcel.readByte() != 0;
        this.isGlrEnabled = parcel.readByte() != 0;
        this.isCokeMealEnabled = parcel.readByte() != 0;
        this.isDiscountAvaialble = parcel.readByte() != 0;
        this.discountDiscription = parcel.readString();
        this.discountCount = parcel.readInt();
        this.isPromotionAvailable = parcel.readByte() != 0;
        this.promotionDiscription = parcel.readString();
        this.promotionCount = parcel.readInt();
        this.hasRamadanDeals = parcel.readByte() != 0;
        this.upsellName = parcel.readString();
        this.upsellId = parcel.readInt();
        this.priceTag = parcel.readInt();
        this.isSubscriptionAvailable = parcel.readByte() != 0;
        this.isSafeDropOff = parcel.readByte() != 0;
        this.isSoftPosSupported = parcel.readByte() != 0;
        this.logoUrl = parcel.readString();
        this.allOrderDiscountText = parcel.readString();
        this.cuisinesText = parcel.readString();
        this.statusText = parcel.readString();
        this.ratingText = parcel.readString();
        this.pickupDiscountText = parcel.readString();
        this.pickupDistanceInKm = parcel.readString();
        this.isPickup = parcel.readByte() != 0;
        this.isProRestaurant = parcel.readByte() != 0;
        this.isTStar = parcel.readByte() != 0 ? true : z11;
        this.tStarLabel = parcel.readString();
        this.delayLabel = parcel.readString();
        this.deliveryTimeIcon = parcel.readString();
        this.deliveryModeLabel = parcel.readString();
    }
}
