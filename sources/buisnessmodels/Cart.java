package buisnessmodels;

import JsonModels.CartSerialiser;
import JsonModels.GrlCartAddressSerialiser;
import JsonModels.McdBlockCartAddressSerialiser;
import JsonModels.McdLatLngCartAddressSerialiser;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import JsonModels.Response.SplitRestaurantApiResponse.TgoDiscountTierModel;
import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import JsonModels.Response.VoucherUnAppliedResponse;
import JsonModels.VoucherResponse;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.domain.address.Address;
import com.talabat.feature.fees.domain.model.FeeDescription;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.RxProcessor;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.AppliedVoucher;
import datamodels.BenefitItem;
import datamodels.CampaignVoucher;
import datamodels.CartMenuItem;
import datamodels.Coupon;
import datamodels.DeliveryTiming;
import datamodels.InvalidItem;
import datamodels.MenuItem;
import datamodels.Promotion;
import datamodels.RedeemedVoucher;
import datamodels.ReorderItemMissingModel;
import datamodels.Restaurant;
import datamodels.TransactionCart;
import datamodels.TransactionItem;
import datamodels.TransactionRestaurant;
import datamodels.TransactionVoucher;
import datamodels.UserOrderPreference;
import datamodels.mappers.AutoApplyDiscountCoupon;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.inject.Inject;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.loyaltyvouchers.UnApplyAllVouchers;
import org.jetbrains.annotations.Nullable;

@Instrumented
public class Cart {
    private static final long CART_VALID_TIME = 10800000;
    private static final String LOYALTY_VOUCHER_TYPE = "LOYALTY_VOUCHER";
    public static final String SAVED_CART_VENDOR_CLICK_ORIGIN = "saved_cart_vendor_source";
    public static final int TALABAT_DELIVERY_VOUCHER = 2;
    private static Cart cart = new Cart();
    private AppliedVoucher appliedVoucher;
    private int areaId;
    private String areaName;
    public float binMinimumOrderAmountForTracking;
    private String binNumber = "";
    private String binValidate = "";
    private float binVoucherDiscount = 0.0f;
    private boolean canShowLoyallyVoucherInCheckOut = false;
    private boolean canShowVoucherInCart = false;
    private ArrayList<CartMenuItem> cartItems = null;
    private String cartSelectedGrlID;
    ArrayList<MenuItem> cartUpSellingList;
    @Inject
    public CartUtility cartUtility;
    private int cityId;
    private String cityName;
    public float couponDiscount = 0.0f;
    private Coupon[] coupons;
    private double darkStoreCartDiscount;
    private String darkStoreCartId;
    private float darkStoreDeliveryFee;
    private double darkStoreDeliveryFeeDiscount;
    private float darkStoreDeliveryTotal;
    private float darkStoreDiscount;
    private List<FeeDescription> darkStoreFeeDescriptions;
    private Float darkStoreScheduledDeliveryDiscount;
    private float darkStoreServiceFee;
    private float darkStoreTotalDiscountToDisplay;
    private String darkstoredijiniVendorId;
    String darkstoresAgeLimit = "";
    public ArrayList<String> deliveryAreas;
    private float deliveryFee = 0.0f;
    private String deliveryMode = "rider";
    private float deliveryTier = -1.0f;
    public ArrayList<DeliveryTiming> deliveryTimings;
    private List<String> eligibleBinsForAppliedVoucher = new ArrayList();
    private float freeDeliveryDiscount;
    private final MutableLiveData<Boolean> freeDeliveryVoucherStackingError = new MutableLiveData<>(null);
    private float gemOfferAmount = 0.0f;
    private Address inforMapAddress;
    private boolean isDarkstoreScheduledDeliveryDiscountEnabled;
    private boolean isDarkstoreScheduledDeliveryOptionSelected;
    private boolean isFreeDelivery = false;
    private boolean isRemoteDeliveryFee = false;
    private boolean isTalabatDeliveryVoucher = false;
    private boolean isZeroVoucherApplied = false;
    private String last4Digits = "";
    private ArrayList<CartMenuItem> loyaltyApplicableCartItems = null;
    private float loyaltyDiscount;
    private LoyaltyVoucherRM loyaltyVoucher;
    private Address mcdBlockMapAddress;
    private Address mcdLatLngMapAddress;
    String migratedPartialFulfillmentPreference = "";
    private float newDeliveryCharge = -1.0f;
    private boolean onlySupportsOnlinePayment = false;
    private String pickupDistanceKm = "0.0";
    private String pickupTime = "";
    private Promotion[] promotions;
    private RedeemedVoucher redeemedVoucher;
    @Nullable
    private ReorderItemMissingModel reorderItemMissingModel = new ReorderItemMissingModel();
    private Restaurant restaurant;
    private CampaignVoucher restaurantCampaignVoucher;
    double riderTip = 0.0d;
    @Nullable
    public Coupon selectedCoupon;
    private Promotion selectedPromotion;
    private float serviceFee = 0.0f;
    private boolean shouldEmptyDarkstroresCart = false;
    private float smallOrderFee = 0.0f;
    private BehaviorSubject<Float> subtotalSubject = BehaviorSubject.createDefault(Float.valueOf(0.0f));
    private final List<Integer> suppressedForRestaurantIds = new ArrayList();
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    private String temporaryVoucherCode = "";
    private TgoFreeDeliveryResponse tgoFreeDeliveryResponse;
    private int tgoUserType;
    private float total = 0.0f;
    private float totalBeforeDiscount = 0.0f;
    private UnApplyAllVouchers unApplyAllVoucher = new UnApplyAllVouchers();
    private MutableLiveData<Boolean> unApplyLoyaltyVoucherTrigger = new MutableLiveData<>(null);
    private UserOrderPreference userOrderPreference;
    private String voucherCode = "";
    public float voucherDiscount = 0.0f;
    private boolean voucherRedeemedInCheckout = false;

    private void calculateFreeDeliveryVoucherTypeDiscount() {
        if (!this.talabatFeatureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagsEnableFreeDeliveryTypeVoucher, false)) {
            unApplyFreeDeliveryTypeVoucher();
        } else if (this.isFreeDelivery || getDeliveryCharges() == 0.0f) {
            unApplyFreeDeliveryTypeVoucher();
            this.freeDeliveryVoucherStackingError.setValue(Boolean.TRUE);
        } else {
            LoyaltyVoucherResult loyaltyVoucherResult = this.loyaltyVoucher.result;
            this.freeDeliveryDiscount = getDiscountedPriceFreeDelivery(getUpdatedDeliveryCharges(), loyaltyVoucherResult.isDeliveryPercentage(), loyaltyVoucherResult.discountValue);
        }
    }

    private void calculateLoyaltyDiscountAmount(LoyaltyVoucherResult loyaltyVoucherResult, ArrayList<CartMenuItem> arrayList) {
        setLoyaltyDiscount(getDiscountedPrice(getTotalPriceOfDiscountableItems(arrayList), loyaltyVoucherResult.discountValue, loyaltyVoucherResult.isPercentage(), loyaltyVoucherResult.maxDiscountCap, loyaltyVoucherResult.loyaltyVoucherBounds));
    }

    private void clearAppliedVoucher() {
        this.appliedVoucher = null;
    }

    private void clearCartInPrefs(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putString("cart", "");
        edit.putLong(GlobalConstants.PrefsConstants.CART_SAVED_TIME, 0);
        edit.apply();
    }

    private void clearLoyaltyVoucher() {
        this.loyaltyVoucher = null;
        this.loyaltyDiscount = 0.0f;
        this.freeDeliveryDiscount = 0.0f;
    }

    private void clearUserPreferenceForThisOrder() {
        this.userOrderPreference = null;
    }

    private ArrayList<TransactionVoucher> collectCartAppliedVouchers() {
        LoyaltyVoucherRM loyaltyVoucherRM;
        LoyaltyVoucherResult loyaltyVoucherResult;
        float f11;
        ArrayList<TransactionVoucher> arrayList = new ArrayList<>();
        if (!((this.loyaltyDiscount <= 0.0f && this.freeDeliveryDiscount <= 0.0f) || (loyaltyVoucherRM = this.loyaltyVoucher) == null || (loyaltyVoucherResult = loyaltyVoucherRM.result) == null)) {
            String str = loyaltyVoucherResult.f476id;
            if (isFreeDeliveryTypeVoucherApplied()) {
                f11 = this.freeDeliveryDiscount;
            } else {
                f11 = this.loyaltyDiscount;
            }
            arrayList.add(new TransactionVoucher(LOYALTY_VOUCHER_TYPE, str, f11, getLoyaltyApplicableCartItemIds()));
        }
        Coupon coupon = this.selectedCoupon;
        if (coupon != null && (coupon instanceof AutoApplyDiscountCoupon)) {
            AutoApplyDiscountCoupon autoApplyDiscountCoupon = (AutoApplyDiscountCoupon) coupon;
            arrayList.add(new TransactionVoucher(autoApplyDiscountCoupon.aadDiscriminator, autoApplyDiscountCoupon.aadCampaignId, autoApplyDiscountCoupon.discount, new ArrayList()));
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return null;
    }

    private float getAllDiscountsForTaxCalculation() {
        return this.couponDiscount + this.gemOfferAmount + this.darkStoreDiscount + this.loyaltyDiscount;
    }

    private ArrayList<CartMenuItem> getApplicableFoodProducts(List<String> list) {
        ArrayList<CartMenuItem> arrayList = new ArrayList<>();
        for (String numberFromString : list) {
            int numberFromString2 = TalabatUtils.getNumberFromString(numberFromString);
            if (numberFromString2 > 0) {
                Iterator<CartMenuItem> it = this.cartItems.iterator();
                while (it.hasNext()) {
                    CartMenuItem next = it.next();
                    if (next.f13861id == numberFromString2) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<CartMenuItem> getApplicableGroceryProducts(List<String> list) {
        ArrayList<CartMenuItem> arrayList = new ArrayList<>();
        for (String next : list) {
            Iterator<CartMenuItem> it = this.cartItems.iterator();
            while (it.hasNext()) {
                CartMenuItem next2 = it.next();
                String str = next2.sku;
                if (str != null && str.equals(next)) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<CartMenuItem> getApplicableGroceryProductsByCategory(List<String> list, boolean z11) {
        boolean z12;
        boolean z13;
        ArrayList<CartMenuItem> arrayList = new ArrayList<>();
        Iterator<CartMenuItem> it = this.cartItems.iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            Iterator<String> it2 = list.iterator();
            while (true) {
                z12 = true;
                if (!it2.hasNext()) {
                    z13 = false;
                    break;
                }
                String next2 = it2.next();
                List<String> list2 = next.qcCategoryIds;
                if (list2 != null && list2.contains(next2)) {
                    z13 = true;
                    break;
                }
            }
            if (!z11) {
                z12 = z13;
            } else if (z13) {
                z12 = false;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    private float getDiscountedPrice(float f11, float f12, boolean z11, float f13, LoyaltyVoucherBounds loyaltyVoucherBounds) {
        float f14;
        boolean z12 = false;
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagsEnableCompoundingStackedIncentives, false);
        if (loyaltyVoucherBounds.hasSkuIds() || loyaltyVoucherBounds.hasCategoryIds()) {
            z12 = true;
        }
        if (z11 && z12) {
            float priceForPercentageDiscount = TalabatUtils.getPriceForPercentageDiscount(f11, f12);
            if (f13 > 0.0f) {
                return Math.min(priceForPercentageDiscount, f13);
            }
            return priceForPercentageDiscount;
        } else if (!z11 || f12 == 100.0f) {
            if (z11 && f12 == 100.0f) {
                if (featureFlag && ((this.couponDiscount > 0.0f || this.binVoucherDiscount > 0.0f) && !loyaltyVoucherBounds.hasBounds())) {
                    f11 = (f11 - this.couponDiscount) - this.binVoucherDiscount;
                }
                if (f13 > 0.0f) {
                    f14 = Math.min(TalabatUtils.getPriceForPercentageDiscount(f11, f12), f13);
                } else {
                    f14 = TalabatUtils.getPriceForPercentageDiscount(f11, f12);
                }
                return f14;
            } else if (f13 > 0.0f) {
                return Math.min(f13, f12);
            } else {
                return f12;
            }
        } else if (f13 > 0.0f) {
            return Math.min(TalabatUtils.getPriceForPercentageDiscount(getCartSubTotal(true, featureFlag), f12), f13);
        } else {
            return TalabatUtils.getPriceForPercentageDiscount(getCartSubTotal(true, featureFlag), f12);
        }
    }

    private float getDiscountedPriceFreeDelivery(float f11, boolean z11, float f12) {
        return z11 ? (f11 * f12) / 100.0f : Math.min(f11, f12);
    }

    public static Cart getInstance() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    private float getPercentValue(float f11, float f12) {
        return (f11 * f12) / 100.0f;
    }

    public static Cart getSavedCart(Context context) {
        Object obj;
        if (!cart.isCartInValid()) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        String string = sharedPreferences.getString("cart", "");
        if (string.equals("")) {
            return null;
        }
        if (isCartRetrivable(sharedPreferences)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            Class cls = CartSerialiser.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            CartSerialiser cartSerialiser = (CartSerialiser) obj;
            cart.cartItems = cartSerialiser.getCartMenuItems();
            cart.restaurant = cartSerialiser.getRestaurant();
            cart.setPickupDetails(cartSerialiser.getRestaurant());
            cart.cityId = cartSerialiser.getCityId();
            cart.areaId = cartSerialiser.getAreaId();
            cart.cityName = cartSerialiser.getCityName();
            cart.areaName = cartSerialiser.getAreaName();
            cart.userOrderPreference = cartSerialiser.getUserOrderPreference();
            cart.setAppliedVoucher(cartSerialiser.getAppliedVoucher());
            cart.loyaltyVoucher = cartSerialiser.getLoyaltyVoucher();
            cart.recalcualteTotal();
            return cart;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("cart", "");
        edit.putLong(GlobalConstants.PrefsConstants.CART_SAVED_TIME, 0);
        edit.apply();
        cart.cartUtility.clearCart();
        return null;
    }

    public static void getSavedMcdCartAddress(Context context) {
        Object obj;
        Object obj2;
        Object obj3;
        if (cart.hasItems()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
            String string = sharedPreferences.getString(GlobalConstants.PrefsConstants.GRL_CART, "");
            String string2 = sharedPreferences.getString(GlobalConstants.PrefsConstants.MCD_BLOCK_CART, "");
            String string3 = sharedPreferences.getString(GlobalConstants.PrefsConstants.MCD_LAT_LANG_CART, "");
            if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (TalabatUtils.isNullOrEmpty(string)) {
                    return;
                }
                if (isCartRetrivable(sharedPreferences)) {
                    Gson gson = UniversalGson.INSTANCE.gson;
                    Class cls = GrlCartAddressSerialiser.class;
                    if (!(gson instanceof Gson)) {
                        obj3 = gson.fromJson(string, cls);
                    } else {
                        obj3 = GsonInstrumentation.fromJson(gson, string, cls);
                    }
                    GrlCartAddressSerialiser grlCartAddressSerialiser = (GrlCartAddressSerialiser) obj3;
                    if (grlCartAddressSerialiser.getInforMapAddress() != null) {
                        McdMapTempAddress.getInstance().setSelectedTempGrlAddress(grlCartAddressSerialiser.getInforMapAddress());
                        cart.inforMapAddress = grlCartAddressSerialiser.getInforMapAddress();
                    } else if (TalabatUtils.isNullOrEmpty(grlCartAddressSerialiser.getcartSelectedGrlID())) {
                        cart.cartSelectedGrlID = grlCartAddressSerialiser.getcartSelectedGrlID();
                    }
                } else {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(GlobalConstants.PrefsConstants.GRL_CART, "");
                    edit.putLong(GlobalConstants.PrefsConstants.GRL_ADDRESS_CART_SAVED_TIME, 0);
                    edit.apply();
                }
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (TalabatUtils.isNullOrEmpty(string2)) {
                    return;
                }
                if (isCartRetrivable(sharedPreferences)) {
                    Gson gson2 = UniversalGson.INSTANCE.gson;
                    Class cls2 = McdBlockCartAddressSerialiser.class;
                    if (!(gson2 instanceof Gson)) {
                        obj2 = gson2.fromJson(string2, cls2);
                    } else {
                        obj2 = GsonInstrumentation.fromJson(gson2, string2, cls2);
                    }
                    McdBlockCartAddressSerialiser mcdBlockCartAddressSerialiser = (McdBlockCartAddressSerialiser) obj2;
                    if (mcdBlockCartAddressSerialiser.getMcdBlockMapAddress() != null) {
                        McdMapTempAddress.getInstance().setSelectedTempBlockAddress(mcdBlockCartAddressSerialiser.getMcdBlockMapAddress());
                        cart.mcdBlockMapAddress = mcdBlockCartAddressSerialiser.getMcdBlockMapAddress();
                        return;
                    }
                    return;
                }
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(GlobalConstants.PrefsConstants.MCD_BLOCK_CART, "");
                edit2.putLong(GlobalConstants.PrefsConstants.MCD_BLOCK_ADDRESS_CART_SAVED_TIME, 0);
                edit2.apply();
            } else if (TalabatUtils.isMcdLatLngEnabledCountry() && !TalabatUtils.isNullOrEmpty(string3)) {
                if (isCartRetrivable(sharedPreferences)) {
                    Gson gson3 = UniversalGson.INSTANCE.gson;
                    Class cls3 = McdLatLngCartAddressSerialiser.class;
                    if (!(gson3 instanceof Gson)) {
                        obj = gson3.fromJson(string3, cls3);
                    } else {
                        obj = GsonInstrumentation.fromJson(gson3, string3, cls3);
                    }
                    McdLatLngCartAddressSerialiser mcdLatLngCartAddressSerialiser = (McdLatLngCartAddressSerialiser) obj;
                    if (mcdLatLngCartAddressSerialiser.getMcdMapAddress() != null) {
                        McdMapTempAddress.getInstance().setSelectedTempLatLangAddress(mcdLatLngCartAddressSerialiser.getMcdMapAddress());
                        cart.mcdLatLngMapAddress = mcdLatLngCartAddressSerialiser.getMcdMapAddress();
                        return;
                    }
                    return;
                }
                SharedPreferences.Editor edit3 = sharedPreferences.edit();
                edit3.putString(GlobalConstants.PrefsConstants.MCD_LAT_LANG_CART, "");
                edit3.putLong(GlobalConstants.PrefsConstants.MCD_LAT_LANG_CART_SAVED_TIME, 0);
                edit3.apply();
            }
        }
    }

    private float getTotalPriceOfDiscountableItems(ArrayList<CartMenuItem> arrayList) {
        float f11;
        float f12 = 0.0f;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CartMenuItem> it = arrayList.iterator();
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (next.isGroceryItem()) {
                    f11 = next.getTotalPrice();
                } else if (!next.isDiscounted() || !Integration.isGemActive()) {
                    f11 = next.getItemPrice();
                } else {
                    f11 = next.getCartOldPrice();
                }
                f12 += f11;
            }
        }
        return f12;
    }

    private boolean hasDarkStoreDeliveryFeeDiscount() {
        return isDarkstore() && this.darkStoreDeliveryFeeDiscount > 0.0d;
    }

    private boolean hasDiscountedDelivery() {
        boolean z11;
        TgoDiscountTierModel[] tgoDiscountTierModelArr;
        try {
            if (this.tgoUserType != 2 || Customer.getInstance().isLoggedIn()) {
                z11 = true;
            } else {
                z11 = false;
            }
            TgoFreeDeliveryResponse tgoFreeDeliveryResponse2 = this.tgoFreeDeliveryResponse;
            if (tgoFreeDeliveryResponse2 == null || (tgoDiscountTierModelArr = tgoFreeDeliveryResponse2.discountTierArray) == null || tgoDiscountTierModelArr.length <= 0 || !z11) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static boolean isCartRetrivable(SharedPreferences sharedPreferences) {
        if (System.currentTimeMillis() - sharedPreferences.getLong(GlobalConstants.PrefsConstants.CART_SAVED_TIME, 0) > CART_VALID_TIME) {
            return false;
        }
        return true;
    }

    private boolean isDarkstore() {
        Restaurant restaurant2 = this.restaurant;
        return restaurant2 != null && (restaurant2.isDarkStore || restaurant2.isMigrated);
    }

    private boolean isMinimumOrderValueSatisfied(float f11) {
        return this.total >= f11;
    }

    private boolean isSuppressed() {
        Restaurant restaurant2 = this.restaurant;
        return restaurant2 != null && this.suppressedForRestaurantIds.contains(Integer.valueOf(restaurant2.f13872id));
    }

    public static void resign(Context context) {
        cart.clearCart(context);
    }

    private boolean sameRestaurant(Restaurant restaurant2) {
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3 == null || restaurant2 == null || restaurant3.getBranchId() != restaurant2.getBranchId()) {
            return false;
        }
        return true;
    }

    private void saveCartToPrefs(Context context) {
        String str;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
            Gson gson = UniversalGson.INSTANCE.gson;
            CartSerialiser cartSerialiser = new CartSerialiser(this.cartItems, this.restaurant, this.cityId, this.cityName, this.areaId, this.areaName, this.userOrderPreference, this.appliedVoucher, this.loyaltyVoucher);
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) cartSerialiser);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) cartSerialiser);
            }
            edit.putString("cart", str);
            edit.putLong(GlobalConstants.PrefsConstants.CART_SAVED_TIME, System.currentTimeMillis());
            edit.putString(SAVED_CART_VENDOR_CLICK_ORIGIN, GlobalDataModel.ShopClickOrigin);
            edit.apply();
            if (TalabatUtils.isMcdInforMapEnabledCountry() || TalabatUtils.isMcdBlockMenuEnabledCountry() || TalabatUtils.isMcdLatLngEnabledCountry()) {
                saveMcdAddressCartToPrefs(context);
            }
        }
    }

    private void unApplyFreeDeliveryTypeVoucher() {
        clearLoyaltyVoucher();
        this.unApplyLoyaltyVoucherTrigger.setValue(Boolean.TRUE);
        unApplyAllVouchers();
    }

    private void upSellingItemAddedToCart(Context context, boolean z11) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putBoolean(GlobalConstants.PrefsConstants.CART_SAVED_UP_SELLING, z11);
        edit.apply();
    }

    private void updateQuantity(CartMenuItem cartMenuItem, Context context) {
        CartMenuItem cartMenuItem2;
        ArrayList<MenuItem> arrayList;
        MenuItemsResponseModel menuItemsResponseModel;
        ArrayList<MenuItem> arrayList2;
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }
        if (this.restaurant == null) {
            cartMenuItem2 = returnItemPresentInCart(cartMenuItem);
        } else if (isDarkstore()) {
            cartMenuItem2 = returnDarkstoreItemPresentInCart(cartMenuItem);
        } else {
            cartMenuItem2 = returnItemPresentInCart(cartMenuItem);
        }
        if (cartMenuItem2 != null) {
            cartMenuItem2.setQuantity(cartMenuItem.getQuantity());
        }
        recalcualteTotal();
        if (getRestaurant().isUpSelling && !(((arrayList = this.cartUpSellingList) != null && arrayList.size() != 0) || (menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel) == null || (arrayList2 = menuItemsResponseModel.upsellingItems) == null)) {
            setUpsellingItem(arrayList2);
        }
        saveCartToPrefs(context);
    }

    public void addItem(CartMenuItem cartMenuItem, Context context) {
        ArrayList<MenuItem> arrayList;
        MenuItemsResponseModel menuItemsResponseModel;
        ArrayList<MenuItem> arrayList2;
        int i11;
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }
        CartMenuItem returnItemPresentInCart = returnItemPresentInCart(cartMenuItem);
        if (returnItemPresentInCart == null) {
            this.cartItems.add(cartMenuItem);
        } else {
            int quantity = returnItemPresentInCart.getQuantity();
            if (cartMenuItem.getQuantity() > 0) {
                i11 = cartMenuItem.getQuantity();
            } else {
                i11 = 1;
            }
            returnItemPresentInCart.setQuantity(quantity + i11);
        }
        recalcualteTotal();
        if (getRestaurant().isUpSelling && !(((arrayList = this.cartUpSellingList) != null && arrayList.size() != 0) || (menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel) == null || (arrayList2 = menuItemsResponseModel.upsellingItems) == null)) {
            setUpsellingItem(arrayList2);
        }
        saveCartToPrefs(context);
    }

    public void addItemForDarkstores(CartMenuItem cartMenuItem, Context context) {
        int i11;
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }
        CartMenuItem returnDarkstoreItemPresentInCart = returnDarkstoreItemPresentInCart(cartMenuItem);
        if (returnDarkstoreItemPresentInCart == null) {
            this.cartItems.add(cartMenuItem);
        } else {
            int quantity = returnDarkstoreItemPresentInCart.getQuantity();
            if (cartMenuItem.getQuantity() > 0) {
                i11 = cartMenuItem.getQuantity();
            } else {
                i11 = 1;
            }
            returnDarkstoreItemPresentInCart.setQuantity(quantity + i11);
        }
        recalcualteTotal();
        saveCartToPrefs(context);
    }

    public void addSuppressedForRestaurantId(@Nullable Integer num) {
        if (num != null) {
            this.suppressedForRestaurantIds.add(num);
        }
    }

    public CartMenuItem addUpsellingItem(MenuItem menuItem, Context context) {
        menuItem.hasThumbnail = true;
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(menuItem);
        if (createWithMenuItem.isAllMantatoryChoiceSelected()) {
            createWithMenuItem.setQuantity(1);
            createWithMenuItem.isUpsellingItem = true;
            addItem(createWithMenuItem, context);
            upSellingItemAddedToCart(context, true);
            clearReorderStatus();
        }
        return createWithMenuItem;
    }

    public void applyVoucher(VoucherResponse voucherResponse) {
        boolean z11;
        this.voucherCode = this.temporaryVoucherCode;
        this.voucherDiscount = voucherResponse.discount;
        this.isZeroVoucherApplied = voucherResponse.isZeroVoucher;
        if (voucherResponse.vouchertype == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isTalabatDeliveryVoucher = z11;
        this.onlySupportsOnlinePayment = voucherResponse.onlinePayment;
    }

    public float calculateDeliveryCharges() {
        if (this.isRemoteDeliveryFee) {
            return this.newDeliveryCharge;
        }
        float f11 = -1.0f;
        setNewDeliveryCharge(-1.0f);
        this.deliveryTier = -1.0f;
        if (hasDiscountedDelivery()) {
            TgoDiscountTierModel[] tgoDiscountTierModelArr = this.tgoFreeDeliveryResponse.discountTierArray;
            Arrays.sort(tgoDiscountTierModelArr);
            for (int i11 = 0; i11 < tgoDiscountTierModelArr.length; i11++) {
                if (getCartSubTotal() >= tgoDiscountTierModelArr[i11].minimumOrderAmount) {
                    if (getDeliveryCharges() > 0.0f && tgoDiscountTierModelArr[i11].discountPercentage > 0.0f) {
                        f11 = getDeliveryCharges() - (getDeliveryCharges() * (tgoDiscountTierModelArr[i11].discountPercentage / 100.0f));
                    }
                    this.newDeliveryCharge = f11;
                    this.deliveryTier = tgoDiscountTierModelArr[i11].minimumOrderAmount;
                    return f11;
                }
            }
            return -1.0f;
        } else if (hasDarkStoreDeliveryFeeDiscount()) {
            float f12 = this.darkStoreDeliveryTotal;
            this.newDeliveryCharge = f12;
            return f12;
        } else if (!isDarkstoreScheduledDeliveryDiscountApplied()) {
            return -1.0f;
        } else {
            float max = Math.max(getDeliveryCharges() - this.darkStoreScheduledDeliveryDiscount.floatValue(), 0.0f);
            this.newDeliveryCharge = max;
            return max;
        }
    }

    public void calculateLoyaltyDiscount(Context context) {
        LoyaltyVoucherRM loyaltyVoucherRM;
        LoyaltyVoucherResult loyaltyVoucherResult;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.loyaltyApplicableCartItems = new ArrayList<>();
        this.loyaltyDiscount = 0.0f;
        this.freeDeliveryDiscount = 0.0f;
        if (isFreeDeliveryTypeVoucherApplied()) {
            calculateFreeDeliveryVoucherTypeDiscount();
            return;
        }
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList != null && arrayList.size() > 0 && (loyaltyVoucherRM = this.loyaltyVoucher) != null && (loyaltyVoucherResult = loyaltyVoucherRM.result) != null && loyaltyVoucherResult.isDiscountAvailable()) {
            if (isMinimumOrderValueSatisfied(loyaltyVoucherResult.minOrderValue)) {
                if (loyaltyVoucherResult.loyaltyVoucherBounds.hasBounds()) {
                    if (loyaltyVoucherResult.loyaltyVoucherBounds.hasProductIds()) {
                        linkedHashSet.addAll(getApplicableFoodProducts(loyaltyVoucherResult.loyaltyVoucherBounds.getProductIds()));
                    } else if (loyaltyVoucherResult.loyaltyVoucherBounds.hasSkuIds()) {
                        linkedHashSet.addAll(getApplicableGroceryProducts(loyaltyVoucherResult.loyaltyVoucherBounds.getSkuIds()));
                    } else if (loyaltyVoucherResult.loyaltyVoucherBounds.hasCategoryIds()) {
                        linkedHashSet.addAll(getApplicableGroceryProductsByCategory(loyaltyVoucherResult.loyaltyVoucherBounds.getCategoryIds(), Boolean.TRUE.equals(loyaltyVoucherResult.loyaltyVoucherBounds.getExcludeCategories())));
                    }
                    if (!linkedHashSet.isEmpty()) {
                        setLoyaltyApplicableCartItems(linkedHashSet);
                    }
                } else {
                    setLoyaltyApplicableCartItems(this.cartItems);
                }
                ArrayList<CartMenuItem> arrayList2 = this.loyaltyApplicableCartItems;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    removeLoyaltyVoucherIfAvailable();
                    this.unApplyLoyaltyVoucherTrigger.setValue(Boolean.TRUE);
                    saveCart(context);
                    return;
                }
                calculateLoyaltyDiscountAmount(loyaltyVoucherResult, this.loyaltyApplicableCartItems);
                recalcualteTotal();
                return;
            }
            removeLoyaltyVoucherIfAvailable();
            this.unApplyLoyaltyVoucherTrigger.setValue(Boolean.TRUE);
            saveCart(context);
        }
    }

    public boolean canAddCoupon(Coupon coupon) {
        return coupon.isAvailable;
    }

    public boolean canAddPromotion(Promotion promotion) {
        return promotion.isAvailable;
    }

    public boolean canShowLoyallyVoucherInCheckOut() {
        return this.canShowLoyallyVoucherInCheckOut;
    }

    public boolean canShowVoucherInCart() {
        return this.canShowVoucherInCart;
    }

    public void celarUpSellingItemAddedToCart(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putBoolean(GlobalConstants.PrefsConstants.CART_SAVED_UP_SELLING, false);
        edit.apply();
    }

    public void clearCart(Context context) {
        this.cartUtility.clearCart();
        this.restaurant = null;
        this.cartItems = null;
        this.loyaltyApplicableCartItems = null;
        setTotal(0.0f);
        this.deliveryAreas = null;
        this.deliveryTimings = null;
        this.voucherDiscount = 0.0f;
        this.loyaltyDiscount = 0.0f;
        this.freeDeliveryDiscount = 0.0f;
        this.voucherCode = "";
        this.temporaryVoucherCode = "";
        this.isZeroVoucherApplied = false;
        this.isTalabatDeliveryVoucher = false;
        this.canShowVoucherInCart = false;
        this.onlySupportsOnlinePayment = false;
        this.voucherRedeemedInCheckout = false;
        this.isFreeDelivery = false;
        this.couponDiscount = 0.0f;
        this.gemOfferAmount = 0.0f;
        this.coupons = null;
        this.promotions = null;
        this.selectedCoupon = null;
        this.selectedPromotion = null;
        this.deliveryMode = "";
        clearUpsellingItem();
        clearCartInPrefs(context);
        celarUpSellingItemAddedToCart(context);
        clearinfoMapAddress();
        removeBinDiscountIfApplied();
        GlobalDataModel.BIN.handled = false;
        this.tgoFreeDeliveryResponse = null;
        this.tgoUserType = -1;
        this.isRemoteDeliveryFee = false;
        setNewDeliveryCharge(-1.0f);
        this.deliveryTier = -1.0f;
        this.darkStoreCartDiscount = 0.0d;
        this.darkStoreDeliveryFeeDiscount = 0.0d;
        this.darkStoreDeliveryTotal = 0.0f;
        this.darkStoreServiceFee = 0.0f;
        this.darkStoreCartId = "";
        this.darkstoredijiniVendorId = "";
        this.shouldEmptyDarkstroresCart = true;
        this.darkStoreDiscount = 0.0f;
        this.migratedPartialFulfillmentPreference = "";
        setServiceFee(0.0f);
        setSmallOrderFee(0.0f);
        clearUserPreferenceForThisOrder();
        clearAppliedVoucher();
        clearLoyaltyVoucher();
        unApplyAllVouchers();
        this.temporaryVoucherCode = "";
        GlobalDataModel.CHECKOUT.currentLatLong = null;
        clearSuppressedForRestaurantIds();
        setCanShowLoyallyVoucherInCheckOut(false);
        clearReorderStatus();
        this.redeemedVoucher = null;
    }

    public void clearCartFromDarkstores(Context context) {
        this.restaurant = null;
        this.cartItems = null;
        this.loyaltyApplicableCartItems = null;
        setTotal(0.0f);
        this.deliveryAreas = null;
        this.deliveryTimings = null;
        this.voucherDiscount = 0.0f;
        this.loyaltyDiscount = 0.0f;
        this.freeDeliveryDiscount = 0.0f;
        this.voucherCode = "";
        this.temporaryVoucherCode = "";
        this.isZeroVoucherApplied = false;
        this.isTalabatDeliveryVoucher = false;
        this.canShowVoucherInCart = false;
        this.onlySupportsOnlinePayment = false;
        this.voucherRedeemedInCheckout = false;
        this.isFreeDelivery = false;
        this.couponDiscount = 0.0f;
        this.gemOfferAmount = 0.0f;
        this.coupons = null;
        this.promotions = null;
        this.selectedCoupon = null;
        this.selectedPromotion = null;
        this.deliveryMode = "";
        clearUpsellingItem();
        clearCartInPrefs(context);
        celarUpSellingItemAddedToCart(context);
        clearinfoMapAddress();
        removeBinDiscountIfApplied();
        GlobalDataModel.BIN.handled = false;
        this.tgoFreeDeliveryResponse = null;
        this.tgoUserType = -1;
        this.isRemoteDeliveryFee = false;
        setNewDeliveryCharge(-1.0f);
        this.deliveryTier = -1.0f;
        this.darkStoreCartDiscount = 0.0d;
        this.darkStoreDeliveryFeeDiscount = 0.0d;
        this.darkStoreDeliveryTotal = 0.0f;
        this.darkStoreServiceFee = 0.0f;
        this.darkStoreCartId = "";
        this.darkstoredijiniVendorId = "";
        this.darkStoreDiscount = 0.0f;
        this.darkStoreTotalDiscountToDisplay = 0.0f;
        clearUserPreferenceForThisOrder();
        clearAppliedVoucher();
        clearLoyaltyVoucher();
        unApplyAllVouchers();
        this.temporaryVoucherCode = "";
        GlobalDataModel.CHECKOUT.currentLatLong = null;
        clearReorderStatus();
    }

    public void clearCartWhenChangedDeliveryMode(Restaurant restaurant2, Context context) {
        if (sameRestaurant(restaurant2) && !this.deliveryMode.equals(restaurant2.deliveryMode())) {
            clearCart(context);
        }
    }

    public void clearReorderStatus() {
        this.reorderItemMissingModel = null;
    }

    public void clearSuppressedForRestaurantIds() {
        this.suppressedForRestaurantIds.clear();
    }

    public void clearUpsellingItem() {
        ArrayList<MenuItem> arrayList = this.cartUpSellingList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void clearinfoMapAddress() {
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = null;
    }

    public void clearinfoMapAddressReorder() {
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId() && McdMapTempAddress.getInstance() != null && McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
            McdMapTempAddress.getInstance().clearTempinfoAddress();
        }
    }

    public void deSelectCoupon() {
        this.selectedCoupon = null;
        this.couponDiscount = 0.0f;
        Coupon[] couponArr = this.coupons;
        if (couponArr != null) {
            for (Coupon coupon : couponArr) {
                coupon.isSelected = false;
            }
        }
    }

    public void deSelectPromotion() {
        this.selectedPromotion = null;
        Promotion[] promotionArr = this.promotions;
        if (promotionArr != null) {
            for (Promotion promotion : promotionArr) {
                promotion.isSelected = false;
            }
        }
    }

    public void decreaseItemQuantity(CartMenuItem cartMenuItem, Context context) {
        updateQuantity(cartMenuItem, context);
    }

    public boolean deleteItemAtPostion(int i11, Context context) {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList != null && arrayList.size() >= i11) {
            this.cartItems.remove(i11);
            calculateLoyaltyDiscount(context);
            recalcualteTotal();
        }
        saveCartToPrefs(context);
        ArrayList<CartMenuItem> arrayList2 = this.cartItems;
        if (arrayList2 == null || !arrayList2.isEmpty()) {
            return false;
        }
        return true;
    }

    public float getAllDiscounts() {
        return this.couponDiscount + this.voucherDiscount + this.gemOfferAmount + this.binVoucherDiscount + this.darkStoreDiscount + this.loyaltyDiscount;
    }

    public float getAllRestaurantFees() {
        float f11;
        float f12 = 0.0f;
        if (getNewDeliveryCharge() >= 0.0f) {
            f11 = getNewDeliveryCharge();
        } else {
            f11 = getDeliveryCharges();
        }
        if (!this.isFreeDelivery) {
            f12 = f11;
        }
        return ((((f12 + getMuncipalityTax()) + getTouristTax()) + getTalabatCharges()) - this.freeDeliveryDiscount) + getServiceFee() + getSmallOrderFee();
    }

    public Coupon getBestCoupon() {
        Coupon[] couponArr = this.coupons;
        Coupon coupon = null;
        if (couponArr != null) {
            float f11 = 0.0f;
            for (Coupon coupon2 : couponArr) {
                if (coupon2.isAvailable) {
                    float f12 = coupon2.discount;
                    if (f12 > f11) {
                        coupon = coupon2;
                        f11 = f12;
                    }
                }
            }
        }
        return coupon;
    }

    public String getBinNumber() {
        return this.binNumber;
    }

    public String getBinValidate() {
        return this.binValidate;
    }

    public float getBinVoucherDiscount() {
        return this.binVoucherDiscount;
    }

    public int getCartAreaId() {
        return this.areaId;
    }

    public String getCartAreaName() {
        return this.areaName;
    }

    public int getCartCityId() {
        return this.cityId;
    }

    public String getCartCityName() {
        return this.cityName;
    }

    public int getCartCount() {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        int i11 = 0;
        if (arrayList != null) {
            Iterator<CartMenuItem> it = arrayList.iterator();
            while (it.hasNext()) {
                i11 += it.next().getQuantity();
            }
        }
        return i11;
    }

    public int getCartItemQuantity(CartMenuItem cartMenuItem) {
        ArrayList<CartMenuItem> cartItems2 = getInstance().getCartItems();
        if (!(cartItems2 == null || cartItems2.size() == 0)) {
            Iterator<CartMenuItem> it = cartItems2.iterator();
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (next.equals(cartMenuItem)) {
                    return next.getQuantity();
                }
            }
        }
        return 0;
    }

    public ArrayList<CartMenuItem> getCartItems() {
        return this.cartItems;
    }

    public String getCartSelectedGrlID() {
        return this.cartSelectedGrlID;
    }

    public float getCartSubTotal() {
        return this.total;
    }

    public float getCartSubTotalBeforeDiscounts() {
        return this.totalBeforeDiscount;
    }

    public String getCartSubTotalDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.total);
    }

    public String getCartSubTotalDisplayPriceForDarkStore() {
        return TalabatFormatter.getInstance().getFormattedCurrency((this.total + this.darkStoreTotalDiscountToDisplay) - this.darkStoreDiscount);
    }

    public Flowable<Float> getCartSubTotalObservable() {
        return this.subtotalSubject.toFlowable(BackpressureStrategy.LATEST);
    }

    public String getCartTotalDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(getCartTotalPrice());
    }

    public String getCartTotalPaymentDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(getCartTotalPaymentPrice());
    }

    public float getCartTotalPaymentPrice() {
        return ((this.total + getAllRestaurantFees()) + ((float) this.riderTip)) - getAllDiscounts();
    }

    public float getCartTotalPrice() {
        return (this.total + getAllRestaurantFees()) - getAllDiscounts();
    }

    public float getCouponDiscount() {
        return this.couponDiscount;
    }

    public String getCouponDiscountDisplayAmount() {
        return "- " + TalabatFormatter.getInstance().getFormattedCurrency(this.couponDiscount);
    }

    public Coupon[] getCoupons() {
        if (isSuppressed()) {
            return null;
        }
        return this.coupons;
    }

    public int getCouponsAndPromotionsCount() {
        int i11;
        int i12 = 0;
        if (getCoupons() != null) {
            i11 = getCoupons().length;
        } else {
            i11 = 0;
        }
        if (getPromotions() != null) {
            i12 = getPromotions().length;
        }
        return i11 + i12;
    }

    public Float getDarkStoreScheduledDeliveryDiscount() {
        return this.darkStoreScheduledDeliveryDiscount;
    }

    public float getDarkStoreTotalDiscountToDisplay() {
        return this.darkStoreTotalDiscountToDisplay;
    }

    public String getDarkstoresAgeLimit() {
        return this.darkstoresAgeLimit;
    }

    public String getDarkstoresCartId() {
        return this.darkStoreCartId;
    }

    public String getDarkstoresDjiniVendorId() {
        return this.darkstoredijiniVendorId;
    }

    public float getDeliveryChargeForVoucher() {
        if (getTalabatCharges() > 0.0f) {
            return getTalabatCharges();
        }
        return getDeliveryCharges();
    }

    public float getDeliveryCharges() {
        if (isRemoteDeliveryFee()) {
            return getNewDeliveryCharge();
        }
        if (this.restaurant == null || isPickup()) {
            return 0.0f;
        }
        if (isDarkstore()) {
            return this.darkStoreDeliveryFee;
        }
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2.DeliveryChargestype == 1) {
            return getPercentValue(this.total, restaurant2.getDeliveryCharges());
        }
        return restaurant2.getDeliveryCharges();
    }

    public String getDeliveryChargesDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(getDeliveryCharges());
    }

    public float getDeliveryChargesForDiscountedTier() {
        float f11;
        if ((hasDiscountedDelivery() || hasDarkStoreDeliveryFeeDiscount()) && getNewDeliveryCharge() >= 0.0f) {
            f11 = getNewDeliveryCharge();
        } else {
            f11 = getDeliveryCharges();
        }
        if (this.isFreeDelivery) {
            return 0.0f;
        }
        return f11;
    }

    public float getDeliveryFee() {
        return this.deliveryFee;
    }

    public String getDeliveryMode() {
        return this.deliveryMode;
    }

    public float getDeliveryTier() {
        return this.deliveryTier;
    }

    public String getDispalyTouristTax() {
        if (getTouristTax() == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(getTouristTax());
    }

    public String getDisplayLoyaltyDiscount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.loyaltyDiscount + this.binVoucherDiscount);
    }

    public String getDisplayMuncipalityTax() {
        if (getMuncipalityTax() == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(getMuncipalityTax());
    }

    public String getDisplayVoucherDiscount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.voucherDiscount + this.binVoucherDiscount);
    }

    public List<String> getEligibleBins() {
        return this.eligibleBinsForAppliedVoucher;
    }

    public List<FeeDescription> getFeeDescriptions() {
        return this.darkStoreFeeDescriptions;
    }

    public float getFreeDeliveryDiscountAmount() {
        return this.freeDeliveryDiscount;
    }

    public MutableLiveData<Boolean> getFreeDeliveryVoucherStackingError() {
        return this.freeDeliveryVoucherStackingError;
    }

    public float getGemOfferAmount() {
        return this.gemOfferAmount;
    }

    public String getGemOfferDisplayAmount() {
        return "- " + TalabatFormatter.getInstance().getFormattedCurrency(this.gemOfferAmount);
    }

    public String getGeneralRequest() {
        UserOrderPreference userOrderPreference2 = this.userOrderPreference;
        if (userOrderPreference2 != null) {
            return userOrderPreference2.additionalRequest;
        }
        return "";
    }

    public boolean getGoGreenSelection() {
        UserOrderPreference userOrderPreference2 = this.userOrderPreference;
        if (userOrderPreference2 != null) {
            return userOrderPreference2.isGoGreen;
        }
        return false;
    }

    public float getGrandCheckoutTotal() {
        return (this.total + getAllRestaurantFees()) - getAllDiscounts();
    }

    public Address getInforMapAddress() {
        return this.inforMapAddress;
    }

    public String getLast4Digits() {
        return this.last4Digits;
    }

    public ArrayList<Integer> getLoyaltyApplicableCartItemIds() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (this.loyaltyVoucher.result.loyaltyVoucherBounds.getProductIds() != null) {
            for (String valueOf : this.loyaltyVoucher.result.loyaltyVoucherBounds.getProductIds()) {
                try {
                    arrayList.add(Integer.valueOf(valueOf));
                } catch (Exception e11) {
                    LogManager.logException(e11);
                }
            }
        }
        return arrayList;
    }

    public float getLoyaltyDiscount() {
        return this.loyaltyDiscount;
    }

    public LoyaltyVoucherRM getLoyaltyVoucher() {
        return this.loyaltyVoucher;
    }

    public Address getMcdBhBlockAddress() {
        return this.mcdBlockMapAddress;
    }

    public Address getMcdLatLangAddress() {
        return this.mcdLatLngMapAddress;
    }

    public String getMigratedPartialFulfillmentPreference() {
        return this.migratedPartialFulfillmentPreference;
    }

    public float getMuncipalityTax() {
        float f11;
        float f12 = this.total;
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            return 0.0f;
        }
        if (restaurant2.excludeDiscountCouponforTax) {
            f12 -= getAllDiscountsForTaxCalculation();
        }
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3.MuncipalityChargestype != 1) {
            return restaurant3.getMunicipalityTax();
        }
        if (!restaurant3.includeDeliveryChargeInTax) {
            return getPercentValue(f12, restaurant3.getMunicipalityTax());
        }
        if (getNewDeliveryCharge() >= 0.0f) {
            f11 = getNewDeliveryCharge();
        } else {
            f11 = getDeliveryCharges();
        }
        return getPercentValue(f12 + f11, this.restaurant.getMunicipalityTax());
    }

    public float getNewDeliveryCharge() {
        if (this.restaurant == null || isPickup()) {
            return 0.0f;
        }
        return this.newDeliveryCharge;
    }

    public int getOrderDeliveryMode() {
        return isPickup() ? 1 : 0;
    }

    public String getPickupDistanceKm() {
        return this.pickupDistanceKm;
    }

    public String getPickupTime() {
        String str = this.pickupTime;
        return str != null ? str : "";
    }

    public BenefitItem getPromotionItem() {
        Promotion promotion = this.selectedPromotion;
        if (promotion != null) {
            return promotion.selectedBenefitItem;
        }
        return null;
    }

    public Promotion[] getPromotions() {
        if (isSuppressed()) {
            return null;
        }
        return this.promotions;
    }

    public String getQualifyAmount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.restaurant.getMinimumAmount() - this.total);
    }

    public RedeemedVoucher getRedeemedVoucher() {
        return this.redeemedVoucher;
    }

    public ReorderItemMissingModel getReorderItemMissingModel() {
        return this.reorderItemMissingModel;
    }

    public String getReorderStatusContent() {
        if (hasReorderItemsStatus()) {
            return this.reorderItemMissingModel.getReorderStatusContent();
        }
        return "";
    }

    public String getReorderStatusTitle() {
        if (hasReorderItemsStatus()) {
            return this.reorderItemMissingModel.getReorderStatusTitle();
        }
        return "";
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public CampaignVoucher getRestaurantCampaignVoucher() {
        return this.restaurantCampaignVoucher;
    }

    public ArrayList<MenuItem> getRestaurantUpsellingsItmes() {
        return this.cartUpSellingList;
    }

    public double getRiderTip() {
        return this.riderTip;
    }

    public AppliedVoucher getSavedVoucher() {
        return this.appliedVoucher;
    }

    @VisibleForTesting
    public Promotion getSelectedPromotion() {
        return this.selectedPromotion;
    }

    public float getServiceFee() {
        if (this.restaurant == null || !isDarkstore()) {
            return this.serviceFee;
        }
        return this.darkStoreServiceFee;
    }

    public float getSmallOrderFee() {
        return this.smallOrderFee;
    }

    public float getSubtotalForVoucher() {
        return getCartSubTotal() - this.couponDiscount;
    }

    public float getTalabatCharges() {
        if (this.restaurant == null || isPickup()) {
            return 0.0f;
        }
        return this.restaurant.talabatCharges;
    }

    public String getTemporaryVoucherCode() {
        if (!TalabatUtils.isNullOrEmpty(this.temporaryVoucherCode)) {
            return this.temporaryVoucherCode;
        }
        AppliedVoucher appliedVoucher2 = this.appliedVoucher;
        if (appliedVoucher2 != null && !TalabatUtils.isNullOrEmpty(appliedVoucher2.getVoucherCode())) {
            this.temporaryVoucherCode = this.appliedVoucher.getVoucherCode();
        }
        return this.temporaryVoucherCode;
    }

    public float getTgoDeliveryDiscount() {
        if (getNewDeliveryCharge() >= 0.0f) {
            return getDeliveryCharges() - getNewDeliveryCharge();
        }
        return -1.0f;
    }

    public float getTouristTax() {
        float f11;
        float f12 = this.total;
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null) {
            return 0.0f;
        }
        if (restaurant2.excludeDiscountCouponforTax) {
            f12 -= getAllDiscountsForTaxCalculation();
        }
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3.TouristChargetype != 1) {
            return restaurant3.getTouristTax();
        }
        if (!restaurant3.includeDeliveryChargeInTax) {
            return getPercentValue(f12, restaurant3.getTouristTax());
        }
        if (getNewDeliveryCharge() >= 0.0f) {
            f11 = getNewDeliveryCharge();
        } else {
            f11 = getDeliveryCharges();
        }
        return getPercentValue(f12 + f11, this.restaurant.getTouristTax());
    }

    public TransactionCart getTransactionCart() {
        BenefitItem benefitItem;
        TransactionRestaurant transactionRestaurant = r1;
        TransactionRestaurant transactionRestaurant2 = new TransactionRestaurant(this.restaurant, this.voucherCode, this.voucherDiscount, this.selectedCoupon, this.selectedPromotion, getMuncipalityTax(), getTouristTax(), getDeliveryChargesForDiscountedTier(), getTalabatCharges(), getTgoDeliveryDiscount(), getDeliveryTier(), this.darkStoreDiscount, getServiceFee(), getSmallOrderFee(), getDeliveryFee());
        Iterator<CartMenuItem> it = this.cartItems.iterator();
        while (it.hasNext()) {
            transactionRestaurant.addItems(TransactionItem.createTransactionItem(it.next(), isDarkstore()));
        }
        TransactionRestaurant transactionRestaurant3 = transactionRestaurant;
        Promotion promotion = this.selectedPromotion;
        if (!(promotion == null || (benefitItem = promotion.selectedBenefitItem) == null)) {
            transactionRestaurant3.addItems(TransactionItem.createTransactionItem(benefitItem));
        }
        int i11 = 0;
        try {
            if (!TalabatUtils.isNullOrEmpty(getBinNumber())) {
                i11 = Integer.parseInt(getBinNumber());
            }
        } catch (NumberFormatException unused) {
        }
        if (this.restaurant != null && isDarkstore()) {
            transactionRestaurant3.setDarkStoreCartDiscount(this.darkStoreCartDiscount);
            transactionRestaurant3.setDarkStoreCartId(this.darkStoreCartId);
            transactionRestaurant3.setDarkStoreDeliveryFeeDiscount(this.darkStoreDeliveryFeeDiscount);
            transactionRestaurant3.setDijiniVendorId(this.darkstoredijiniVendorId);
        }
        transactionRestaurant3.setGeneralRequest(getGeneralRequest());
        return new TransactionCart.Builder().setAreaId(this.areaId).setTransactionRestaurant(transactionRestaurant3).setTotal(this.total).setGrandTotal(getGrandCheckoutTotal()).setBinNumber(i11).setBinDiscount(getBinVoucherDiscount()).setBinValidate(getBinValidate()).setLast4Digits(getLast4Digits()).setVouchers(collectCartAppliedVouchers()).setGemDiscount(this.gemOfferAmount).setGemAccepted(Integration.isGemActive()).setDeliveryMode(getDeliveryMode()).build();
    }

    public MutableLiveData<Boolean> getUnApplyLoyaltyVoucherTriggerLiveData() {
        return this.unApplyLoyaltyVoucherTrigger;
    }

    public float getUpdatedDeliveryCharges() {
        if (isRemoteDeliveryFee()) {
            return getNewDeliveryCharge();
        }
        if (this.restaurant == null || isPickup()) {
            return 0.0f;
        }
        if (isDarkstore()) {
            return Math.min(this.darkStoreDeliveryTotal, this.darkStoreDeliveryFee);
        }
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2.DeliveryChargestype == 1) {
            return getPercentValue(this.total, restaurant2.getDeliveryCharges());
        }
        return restaurant2.getDeliveryCharges();
    }

    public int getUpsellingItemCount() {
        ArrayList<MenuItem> arrayList = this.cartUpSellingList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public UserOrderPreference getUserPreferenceForThisOrder() {
        if (this.userOrderPreference == null) {
            this.userOrderPreference = new UserOrderPreference();
        }
        return this.userOrderPreference;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public float getVoucherDiscount() {
        return this.voucherDiscount;
    }

    public boolean hasBinVoucher() {
        return this.binVoucherDiscount > 0.0f;
    }

    public boolean hasItems() {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean hasReorderItemsStatus() {
        ReorderItemMissingModel reorderItemMissingModel2 = this.reorderItemMissingModel;
        return reorderItemMissingModel2 != null && reorderItemMissingModel2.hasReorderStatus();
    }

    public boolean hasVoucherApplied() {
        return !isSuppressed() && this.voucherDiscount + this.binVoucherDiscount > 0.0f;
    }

    public void increaseItemQuantity(CartMenuItem cartMenuItem, Context context) {
        CartMenuItem cartMenuItem2;
        ArrayList<MenuItem> arrayList;
        MenuItemsResponseModel menuItemsResponseModel;
        ArrayList<MenuItem> arrayList2;
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }
        if (this.restaurant == null) {
            cartMenuItem2 = returnItemPresentInCart(cartMenuItem);
        } else if (isDarkstore()) {
            cartMenuItem2 = returnDarkstoreItemPresentInCart(cartMenuItem);
        } else {
            cartMenuItem2 = returnItemPresentInCart(cartMenuItem);
        }
        if (cartMenuItem2 == null) {
            this.cartItems.add(cartMenuItem);
        } else {
            cartMenuItem2.setQuantity(cartMenuItem.getQuantity());
        }
        recalcualteTotal();
        if (getRestaurant().isUpSelling && !(((arrayList = this.cartUpSellingList) != null && arrayList.size() != 0) || (menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel) == null || (arrayList2 = menuItemsResponseModel.upsellingItems) == null)) {
            setUpsellingItem(arrayList2);
        }
        saveCartToPrefs(context);
    }

    public boolean isBestCouponAvailable() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 == null || restaurant2.ismixoffer || this.coupons == null || isPromotionSelected() || this.selectedCoupon != null || isNonCombinationalPromotionalItemPresent() || getBestCoupon() == null) {
            return false;
        }
        return true;
    }

    public boolean isCartForCity(int i11) {
        return this.cityId == i11;
    }

    public boolean isCartInValid() {
        return this.restaurant == null;
    }

    public boolean isCouponApplied() {
        return !isSuppressed() && this.couponDiscount > 0.0f;
    }

    public boolean isDarkstoreScheduledDeliveryDiscountApplied() {
        Float f11;
        if (!this.isDarkstoreScheduledDeliveryDiscountEnabled || !this.isDarkstoreScheduledDeliveryOptionSelected || (f11 = this.darkStoreScheduledDeliveryDiscount) == null || f11.floatValue() <= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = getLoyaltyVoucher();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isFreeDeliveryDiscountFull() {
        /*
            r3 = this;
            boolean r0 = r3.isFreeDeliveryTypeVoucherApplied()
            r1 = 0
            if (r0 == 0) goto L_0x0020
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM r0 = r3.getLoyaltyVoucher()
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult r2 = r0.result
            if (r2 == 0) goto L_0x0020
            boolean r2 = r2.isDeliveryPercentage()
            if (r2 == 0) goto L_0x0020
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult r0 = r0.result
            float r0 = r0.discountValue
            r2 = 1120403456(0x42c80000, float:100.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0020
            r1 = 1
        L_0x0020:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: buisnessmodels.Cart.isFreeDeliveryDiscountFull():boolean");
    }

    public boolean isFreeDeliveryTypeVoucherApplied() {
        if (getLoyaltyVoucher() == null || getLoyaltyVoucher().result == null || !getLoyaltyVoucher().result.isDeliveryDiscountType()) {
            return false;
        }
        return true;
    }

    public boolean isFreeItemAdded() {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList == null) {
            return false;
        }
        Iterator<CartMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().isFreeItem) {
                return true;
            }
        }
        return false;
    }

    public boolean isItemExistInCart(int i11) {
        if (getCartItems() == null) {
            return false;
        }
        for (int i12 = 0; i12 < getCartItems().size(); i12++) {
            if (getCartItems().get(i12).f13861id == i11) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.result;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoyaltyAvailable() {
        /*
            r2 = this;
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM r0 = r2.loyaltyVoucher
            if (r0 == 0) goto L_0x0011
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult r0 = r0.result
            if (r0 == 0) goto L_0x0011
            float r0 = r0.discountValue
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: buisnessmodels.Cart.isLoyaltyAvailable():boolean");
    }

    public boolean isLoyaltyVoucherApplied() {
        return !isSuppressed() && this.loyaltyDiscount > 0.0f;
    }

    public boolean isMinimumOrderAmountPassed() {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList == null || arrayList.size() <= 0 || this.restaurant.getMinimumAmount() > TalabatFormatter.getInstance().getRoundedAmount(getCartTotalPrice(false))) {
            return false;
        }
        return true;
    }

    public boolean isNonCombinationalPromotionalItemPresent() {
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList == null || this.restaurant.ismixoffer) {
            return false;
        }
        Iterator<CartMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().isPromotional) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnlySupportsOnlinePayment() {
        return this.onlySupportsOnlinePayment;
    }

    public boolean isPickup() {
        return this.deliveryMode.equals("pickup");
    }

    public boolean isPromotionApplied() {
        return !isSuppressed() && this.selectedPromotion != null;
    }

    public boolean isPromotionSelected() {
        Promotion promotion = this.selectedPromotion;
        return (promotion == null || promotion.selectedBenefitItem == null) ? false : true;
    }

    public boolean isRemoteDeliveryFee() {
        return this.isRemoteDeliveryFee;
    }

    public boolean isRestaurantCart(Restaurant restaurant2) {
        return restaurant2 != null && this.restaurant.getBranchId() == restaurant2.getBranchId();
    }

    public boolean isShouldEmptyDarkstroresCart() {
        return this.shouldEmptyDarkstroresCart;
    }

    public boolean isTProApplied() {
        return this.isFreeDelivery;
    }

    public boolean isTalabatDeliveryVoucher() {
        return !isSuppressed() && this.isTalabatDeliveryVoucher;
    }

    public boolean isTgo() {
        Restaurant restaurant2 = getInstance().getRestaurant();
        if (restaurant2 != null) {
            return restaurant2.isTalabatGo;
        }
        return false;
    }

    public boolean isUpsellingAvailable() {
        return getRestaurant() != null && getRestaurant().isUpSelling;
    }

    public boolean isVoucherApplied() {
        AppliedVoucher appliedVoucher2;
        if (!isSuppressed() && (appliedVoucher2 = this.appliedVoucher) != null && appliedVoucher2.getVoucherDiscount() > 0.0f) {
            return true;
        }
        return false;
    }

    public boolean isVoucherRedeemedInCheckout() {
        return this.voucherRedeemedInCheckout;
    }

    public boolean isZeroVoucherApplied() {
        return !isSuppressed() && this.isZeroVoucherApplied;
    }

    public boolean mergeItemExistsInCart(CartMenuItem cartMenuItem) {
        String str = cartMenuItem.getRefId() + cartMenuItem.specialRequest;
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList == null) {
            return false;
        }
        Iterator<CartMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(next.getRefId());
            String str2 = next.specialRequest;
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            if (str.equals(sb2.toString())) {
                next.setQuantity(next.getQuantity() + cartMenuItem.getQuantity());
                return true;
            }
        }
        return false;
    }

    public void recalcualteTotal() {
        BenefitItem benefitItem;
        float f11;
        float f12;
        ArrayList<CartMenuItem> arrayList = this.cartItems;
        if (arrayList != null) {
            Iterator<CartMenuItem> it = arrayList.iterator();
            float f13 = 0.0f;
            float f14 = 0.0f;
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (next.getQuantity() < 1) {
                    it.remove();
                } else {
                    if (!next.isDiscounted() || !Integration.isGemActive()) {
                        f11 = next.getTotalPrice();
                    } else {
                        f11 = next.getCartOldTotalPrice();
                    }
                    if (next.isDiscounted()) {
                        f12 = next.getCartOldTotalPrice();
                    } else {
                        f12 = next.getTotalPrice();
                    }
                    f13 += f11;
                    f14 += f12;
                }
            }
            setTotal(f13);
            setTotalBeforeDiscounts(f14);
            Promotion promotion = this.selectedPromotion;
            if (!(promotion == null || (benefitItem = promotion.selectedBenefitItem) == null)) {
                setTotal(this.total + benefitItem.totalPrice);
            }
        }
        calculateDeliveryCharges();
    }

    public void refreshRestaurant(Restaurant restaurant2, Context context, int i11) {
        int[] iArr;
        if (this.restaurant.getBranchId() != restaurant2.getBranchId()) {
            clearCart(context);
            iArr = null;
        } else {
            iArr = this.restaurant.delAreas;
        }
        this.restaurant = restaurant2;
        restaurant2.delAreas = iArr;
        this.areaId = i11;
    }

    public void removeBinDiscountIfApplied() {
        this.binVoucherDiscount = 0.0f;
        this.binNumber = "";
    }

    public void removeInvalidItems(InvalidItem[] invalidItemArr) {
        if (invalidItemArr != null) {
            for (InvalidItem invalidItem : invalidItemArr) {
                removeItem(invalidItem.f13858id);
            }
        }
    }

    public void removeInvalidSelectedCoupon(boolean z11) {
        int i11 = this.selectedCoupon.f13847id;
        deSelectCoupon();
        recalcualteTotal();
        if (z11) {
            int length = this.coupons.length - 1;
            int i12 = 0;
            Coupon[] couponArr = new Coupon[0];
            if (length > 0) {
                couponArr = new Coupon[length];
                int i13 = 0;
                while (true) {
                    Coupon[] couponArr2 = this.coupons;
                    if (i12 >= couponArr2.length) {
                        break;
                    }
                    Coupon coupon = couponArr2[i12];
                    if (i11 != coupon.f13847id) {
                        couponArr[i13] = coupon;
                        i13++;
                    }
                    i12++;
                }
            }
            this.coupons = couponArr;
        }
    }

    public void removeInvalidSelectedPromotion(boolean z11) {
        int i11 = this.selectedPromotion.f13866id;
        deSelectPromotion();
        recalcualteTotal();
        if (z11) {
            int length = this.promotions.length - 1;
            Promotion[] promotionArr = new Promotion[0];
            if (length > 0) {
                promotionArr = new Promotion[length];
                int i12 = 0;
                while (true) {
                    Promotion[] promotionArr2 = this.promotions;
                    if (i12 >= promotionArr2.length) {
                        break;
                    }
                    Promotion promotion = promotionArr2[i12];
                    if (i11 != promotion.f13866id) {
                        promotionArr[0] = promotion;
                    }
                    i12++;
                }
            }
            this.promotions = promotionArr;
        }
    }

    public void removeItem(int i11) {
        if (this.cartItems != null) {
            for (int i12 = 0; i12 < this.cartItems.size(); i12++) {
                if (this.cartItems.get(i12).f13861id == i11) {
                    this.cartItems.remove(i12);
                    return;
                }
            }
        }
    }

    public void removeLoyaltyVoucherIfAvailable() {
        clearLoyaltyVoucher();
    }

    public void removeTgoFreeDeliveryTiers() {
        setNewDeliveryCharge(-1.0f);
        this.tgoFreeDeliveryResponse = new TgoFreeDeliveryResponse();
        GlobalDataModel.JSON.tgoFreeDeliveryResponse = new TgoFreeDeliveryResponse();
        this.tgoUserType = -1;
        this.deliveryTier = -1.0f;
    }

    public void removeVoucherIfApplied() {
        this.voucherCode = "";
        this.voucherDiscount = 0.0f;
        this.temporaryVoucherCode = "";
        this.isZeroVoucherApplied = false;
        this.isTalabatDeliveryVoucher = false;
        this.onlySupportsOnlinePayment = false;
        this.voucherRedeemedInCheckout = false;
        clearAppliedVoucher();
    }

    public CartMenuItem returnDarkstoreItemPresentInCart(CartMenuItem cartMenuItem) {
        Iterator<CartMenuItem> it = this.cartItems.iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if (next != null && cartMenuItem != null && next.getStringId().matches(cartMenuItem.getStringId())) {
                return next;
            }
        }
        return null;
    }

    public CartMenuItem returnItemPresentInCart(CartMenuItem cartMenuItem) {
        Iterator<CartMenuItem> it = this.cartItems.iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if ((next.getRefId() + next.specialRequest).equals(cartMenuItem.getRefId() + cartMenuItem.specialRequest)) {
                return next;
            }
        }
        return null;
    }

    public void saveCart(Context context) {
        if (new SoftReference(context).get() != null) {
            saveCartToPrefs(context);
        }
    }

    public void saveLoyaltyVoucher(Context context, LoyaltyVoucherRM loyaltyVoucherRM) {
        removeVoucherIfApplied();
        this.loyaltyVoucher = loyaltyVoucherRM;
        saveCart(context);
    }

    public void saveMcdAddressCartToPrefs(Context context) {
        String str;
        String str2;
        String str3;
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        String str4 = "";
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            Address selectedGrlTempAddress = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                str4 = Customer.getInstance().getSelectedCustomerAddress().grl;
            }
            GrlCartAddressSerialiser grlCartAddressSerialiser = new GrlCartAddressSerialiser(selectedGrlTempAddress, str4);
            if (!(gson instanceof Gson)) {
                str3 = gson.toJson((Object) grlCartAddressSerialiser);
            } else {
                str3 = GsonInstrumentation.toJson(gson, (Object) grlCartAddressSerialiser);
            }
            edit.putString(GlobalConstants.PrefsConstants.GRL_CART, str3);
            edit.putLong(GlobalConstants.PrefsConstants.GRL_ADDRESS_CART_SAVED_TIME, System.currentTimeMillis());
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            Address selectedMcdBlockTempAddress = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                str4 = Customer.getInstance().getSelectedCustomerAddress().block;
            }
            McdBlockCartAddressSerialiser mcdBlockCartAddressSerialiser = new McdBlockCartAddressSerialiser(selectedMcdBlockTempAddress, str4, McdMapTempAddress.getInstance().getMcdBranchTempId());
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) mcdBlockCartAddressSerialiser);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) mcdBlockCartAddressSerialiser);
            }
            edit.putString(GlobalConstants.PrefsConstants.MCD_BLOCK_CART, str2);
            edit.putLong(GlobalConstants.PrefsConstants.MCD_BLOCK_ADDRESS_CART_SAVED_TIME, System.currentTimeMillis());
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            McdLatLngCartAddressSerialiser mcdLatLngCartAddressSerialiser = new McdLatLngCartAddressSerialiser(McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress(), McdMapTempAddress.getInstance().getMcdKSBranchTempId());
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) mcdLatLngCartAddressSerialiser);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) mcdLatLngCartAddressSerialiser);
            }
            edit.putString(GlobalConstants.PrefsConstants.MCD_LAT_LANG_CART, str);
            edit.putLong(GlobalConstants.PrefsConstants.MCD_LAT_LANG_CART_SAVED_TIME, System.currentTimeMillis());
        }
        edit.apply();
    }

    public void saveVoucher(Context context, String str) {
        removeLoyaltyVoucherIfAvailable();
        this.appliedVoucher = new AppliedVoucher(this.voucherCode, this.voucherDiscount, this.isTalabatDeliveryVoucher, this.isZeroVoucherApplied, this.onlySupportsOnlinePayment, str);
        saveCart(context);
    }

    public void setAppliedVoucher(AppliedVoucher appliedVoucher2) {
        if (appliedVoucher2 != null) {
            this.appliedVoucher = appliedVoucher2;
            this.voucherCode = appliedVoucher2.getVoucherCode();
            this.voucherDiscount = appliedVoucher2.getVoucherDiscount();
            this.isZeroVoucherApplied = appliedVoucher2.isZeroVoucherApplied;
            this.isTalabatDeliveryVoucher = appliedVoucher2.isTalabatDeliveryVoucher;
            this.onlySupportsOnlinePayment = appliedVoucher2.onlySupportsOnlinePayment;
        }
    }

    public void setBenefitItemDeleted() {
        Promotion promotion = this.selectedPromotion;
        if (promotion != null) {
            promotion.isSelected = false;
            promotion.selectedBenefitItem = null;
        }
        this.selectedPromotion = null;
    }

    public void setBinAndLatDigitForValidate(String str, String str2) {
        if (!TalabatUtils.isNullOrEmpty(str) && !TalabatUtils.isNullOrEmpty(str2)) {
            this.binValidate = str;
        }
        this.last4Digits = str2;
    }

    public void setBinVoucherDiscount(float f11, String str, float f12) {
        this.binVoucherDiscount = f11;
        this.binNumber = str;
        this.binMinimumOrderAmountForTracking = f12;
        recalcualteTotal();
    }

    public void setCanShowLoyallyVoucherInCheckOut(boolean z11) {
        this.canShowLoyallyVoucherInCheckOut = z11;
    }

    public void setCartItemsForTest(CartMenuItem cartMenuItem) {
        if (this.cartItems == null) {
            this.cartItems = new ArrayList<>();
        }
        this.cartItems.add(cartMenuItem);
    }

    public void setCoupons(Coupon[] couponArr) {
        boolean z11;
        if (!isSuppressed()) {
            this.coupons = couponArr;
            int i11 = 0;
            if (isNonCombinationalPromotionalItemPresent() || isPromotionApplied()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (couponArr != null) {
                int length = couponArr.length;
                int i12 = 0;
                while (i11 < length) {
                    Coupon coupon = couponArr[i11];
                    if (coupon.isSelected && (!z11 || coupon.allowHotDeals)) {
                        setSelectedCoupon(coupon);
                        i12 = 1;
                    }
                    i11++;
                }
                i11 = i12;
            } else {
                deSelectCoupon();
            }
            if (i11 == 0) {
                deSelectCoupon();
            }
        }
    }

    public void setDarkstoreScheduledDeliveryDiscountEnabled(boolean z11) {
        this.isDarkstoreScheduledDeliveryDiscountEnabled = z11;
    }

    public void setDarkstoreScheduledDeliveryOptionSelected(boolean z11) {
        this.isDarkstoreScheduledDeliveryOptionSelected = z11;
        recalcualteTotal();
    }

    public void setDarkstoresDeliveryTotal(float f11) {
        this.darkStoreDeliveryTotal = f11;
    }

    public void setDeliveryFee(float f11) {
        this.deliveryFee = f11;
    }

    public void setDeliveryMode(String str) {
        this.deliveryMode = str;
    }

    public void setEligibleBins(List<String> list) {
        this.eligibleBinsForAppliedVoucher = list;
    }

    public void setFeeDescriptions(List<FeeDescription> list) {
        this.darkStoreFeeDescriptions = list;
    }

    public void setFreeDelivery(boolean z11) {
        this.isFreeDelivery = z11;
        if (z11 && isFreeDeliveryTypeVoucherApplied()) {
            unApplyFreeDeliveryTypeVoucher();
        }
    }

    public void setGemOfferAmount(float f11) {
        this.gemOfferAmount = f11;
    }

    public void setGeneralRequest(String str) {
        UserOrderPreference userOrderPreference2 = this.userOrderPreference;
        if (userOrderPreference2 != null) {
            userOrderPreference2.additionalRequest = str;
        }
    }

    public void setGoGreenSelection(boolean z11) {
        UserOrderPreference userOrderPreference2 = this.userOrderPreference;
        if (userOrderPreference2 != null) {
            userOrderPreference2.isGoGreen = z11;
        }
    }

    public void setInforMapAddress(Address address) {
        if (address != null) {
            this.inforMapAddress = address;
        }
    }

    public void setLoyaltyApplicableCartItems(Collection<CartMenuItem> collection) {
        if (this.loyaltyApplicableCartItems == null) {
            this.loyaltyApplicableCartItems = new ArrayList<>();
        }
        this.loyaltyApplicableCartItems.addAll(collection);
    }

    public void setLoyaltyDiscount(float f11) {
        this.loyaltyDiscount = f11;
    }

    @VisibleForTesting
    public void setLoyaltyVoucher(LoyaltyVoucherResult loyaltyVoucherResult) {
        LoyaltyVoucherRM loyaltyVoucherRM = new LoyaltyVoucherRM();
        this.loyaltyVoucher = loyaltyVoucherRM;
        loyaltyVoucherRM.result = loyaltyVoucherResult;
    }

    public void setMcdBhBlockAddress(Address address) {
        if (address != null) {
            this.mcdBlockMapAddress = address;
        }
    }

    public void setMcdKsLatLngAddress(Address address) {
        if (address != null) {
            this.mcdLatLngMapAddress = address;
        }
    }

    public void setNewDeliveryCharge(float f11) {
        this.newDeliveryCharge = f11;
    }

    public void setNoBenefitItemSelected() {
        Promotion promotion = this.selectedPromotion;
        if (promotion != null) {
            promotion.isSelected = false;
        }
        this.selectedPromotion = null;
    }

    public void setPickupDetails(Restaurant restaurant2) {
        if (restaurant2 != null) {
            setDeliveryMode(restaurant2.deliveryMode());
            setPickupTime(restaurant2.deliveryTime);
            setPickupDistanceKm(restaurant2.getPickupDistanceKm());
        }
    }

    public void setPickupDistanceKm(String str) {
        this.pickupDistanceKm = str;
    }

    public void setPickupTime(String str) {
        this.pickupTime = str;
    }

    public void setPromotions(Promotion[] promotionArr) {
        int i11;
        if (!isSuppressed()) {
            this.promotions = promotionArr;
            if (promotionArr != null) {
                Promotion promotion = this.selectedPromotion;
                if (promotion != null && promotion.selectedBenefitItem != null) {
                    int length = promotionArr.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        Promotion promotion2 = promotionArr[i12];
                        i11 = this.selectedPromotion.f13866id;
                        if (i11 == promotion2.f13866id && promotion2.isAvailable) {
                            break;
                        }
                        i12++;
                    }
                }
                i11 = -1;
                boolean z11 = false;
                for (Promotion promotion3 : promotionArr) {
                    if (i11 > 0) {
                        if (i11 == promotion3.f13866id) {
                            z11 = true;
                            promotion3.isSelected = true;
                            promotion3.selectedBenefitItem = this.selectedPromotion.selectedBenefitItem;
                            this.selectedPromotion = promotion3;
                        } else {
                            promotion3.isSelected = false;
                        }
                    } else if (promotion3.isSelected) {
                        setSelectedPromotion(promotion3);
                    }
                }
                if (!z11) {
                    deSelectPromotion();
                }
            }
        }
    }

    public void setQuantity(CartMenuItem cartMenuItem, int i11) {
        CartMenuItem cartMenuItem2;
        if (isDarkstore()) {
            cartMenuItem2 = returnDarkstoreItemPresentInCart(cartMenuItem);
        } else {
            cartMenuItem2 = returnItemPresentInCart(cartMenuItem);
        }
        if (cartMenuItem2 != null) {
            cartMenuItem2.setQuantity(i11);
            recalcualteTotal();
        }
    }

    public void setRedeemedVoucher(RedeemedVoucher redeemedVoucher2) {
        this.redeemedVoucher = redeemedVoucher2;
    }

    public void setRemoteDeliveryFee(float f11) {
        setNewDeliveryCharge(f11);
        this.isRemoteDeliveryFee = true;
        if (isFreeDeliveryTypeVoucherApplied()) {
            calculateFreeDeliveryVoucherTypeDiscount();
        }
    }

    public void setReorderItemMissingModel(@Nullable ReorderItemMissingModel reorderItemMissingModel2) {
        this.reorderItemMissingModel = reorderItemMissingModel2;
    }

    public Cart setRestaurant(Restaurant restaurant2, Context context) {
        Restaurant restaurant3 = this.restaurant;
        if (!(restaurant3 == null || restaurant3.getBranchId() == restaurant2.getBranchId())) {
            clearCart(context);
        }
        new Restaurant();
        this.restaurant = restaurant2;
        this.cityId = GlobalDataModel.SelectedCityId;
        this.areaId = GlobalDataModel.SelectedAreaId;
        this.areaName = GlobalDataModel.SelectedAreaName;
        this.cityName = GlobalDataModel.SelectedCityName;
        setNewDeliveryCharge(-1.0f);
        this.deliveryTier = -1.0f;
        setTgoFreeDeliveryTiers();
        if (restaurant2 != null) {
            this.userOrderPreference = new UserOrderPreference(restaurant2.branchId, restaurant2.branchName);
            this.appliedVoucher = new AppliedVoucher();
            this.temporaryVoucherCode = "";
            this.loyaltyVoucher = new LoyaltyVoucherRM();
            GlobalDataModel.CHECKOUT.currentLatLong = null;
        }
        setPickupDetails(restaurant2);
        this.reorderItemMissingModel = new ReorderItemMissingModel();
        return cart;
    }

    public void setRestaurantCampaignVoucher(CampaignVoucher campaignVoucher) {
        this.restaurantCampaignVoucher = campaignVoucher;
    }

    public void setRiderTip(double d11) {
        this.riderTip = d11;
    }

    public void setSelectedBenefitItem(BenefitItem benefitItem) {
        Promotion promotion = this.selectedPromotion;
        if (promotion != null) {
            promotion.isSelected = true;
            promotion.selectedBenefitItem = benefitItem;
            recalcualteTotal();
        }
    }

    public void setSelectedCoupon(Coupon coupon) {
        Promotion promotion;
        if (!this.restaurant.ismixoffer && (promotion = this.selectedPromotion) != null) {
            promotion.isSelected = false;
            promotion.selectedBenefitItem = null;
            this.selectedPromotion = null;
        }
        Coupon coupon2 = this.selectedCoupon;
        if (coupon2 != null) {
            coupon2.isSelected = false;
            this.couponDiscount = 0.0f;
        }
        this.selectedCoupon = coupon;
        coupon.isSelected = true;
        this.couponDiscount = coupon.discount;
        recalcualteTotal();
    }

    public void setSelectedPromotion(Promotion promotion) {
        Coupon coupon;
        Promotion promotion2 = this.selectedPromotion;
        if (promotion2 != null) {
            promotion2.isSelected = false;
            promotion2.selectedBenefitItem = null;
        }
        if (!this.restaurant.ismixoffer && (coupon = this.selectedCoupon) != null) {
            coupon.isSelected = false;
            this.couponDiscount = 0.0f;
            this.selectedCoupon = null;
        }
        this.selectedPromotion = promotion;
        promotion.isSelected = true;
        if (!promotion.isBenefitListOfItems) {
            BenefitItem[] benefitItemArr = promotion.benefitItems;
            if (benefitItemArr.length != 0) {
                BenefitItem benefitItem = benefitItemArr[0];
                if (!benefitItem.containsChoices) {
                    promotion.selectedBenefitItem = benefitItem;
                }
            }
        }
        recalcualteTotal();
    }

    public void setServiceFee(float f11) {
        this.serviceFee = f11;
    }

    public void setShouldEmptyDarkstroresCart(boolean z11) {
        this.shouldEmptyDarkstroresCart = z11;
    }

    public void setSmallOrderFee(float f11) {
        this.smallOrderFee = f11;
    }

    public void setTemporaryVoucherCode(String str) {
        this.temporaryVoucherCode = str;
    }

    public void setTgoFreeDeliveryTiers() {
        TgoDiscountTierModel[] tgoDiscountTierModelArr;
        this.tgoFreeDeliveryResponse = new TgoFreeDeliveryResponse();
        TgoFreeDeliveryResponse tgoFreeDeliveryResponse2 = GlobalDataModel.JSON.tgoFreeDeliveryResponse;
        if (tgoFreeDeliveryResponse2 != null && (tgoDiscountTierModelArr = tgoFreeDeliveryResponse2.discountTierArray) != null && tgoDiscountTierModelArr.length > 0) {
            this.tgoFreeDeliveryResponse = tgoFreeDeliveryResponse2;
            this.tgoUserType = tgoFreeDeliveryResponse2.tgoUserType;
        }
    }

    @VisibleForTesting
    public void setTotal(float f11) {
        this.total = f11;
    }

    @VisibleForTesting
    public void setTotalBeforeDiscounts(float f11) {
        this.totalBeforeDiscount = f11;
        this.subtotalSubject.onNext(Float.valueOf(f11));
    }

    public void setUpsellingItem(ArrayList<MenuItem> arrayList) {
        this.cartUpSellingList = arrayList;
    }

    public void setVoucherCode(String str) {
        this.voucherCode = str;
    }

    public void setVoucherRedeemedinCheckout(boolean z11) {
        this.voucherRedeemedInCheckout = z11;
    }

    public void unApplyAllVouchers() {
        new RxProcessor().process(this.unApplyAllVoucher.unApplyAllVouchers(), new DisposableObserver<VoucherUnAppliedResponse>() {
            public void onComplete() {
            }

            public void onError(Throwable th2) {
            }

            public void onNext(VoucherUnAppliedResponse voucherUnAppliedResponse) {
            }
        });
    }

    public void updateCartAreaInfo(int i11, String str) {
        this.areaId = GlobalDataModel.SelectedAreaId;
        this.areaName = GlobalDataModel.SelectedAreaName;
    }

    public void updateCartDarkstoreInfo(float f11, float f12, String str, String str2, float f13, float f14, float f15, @NonNull String str3, String str4, List<FeeDescription> list, float f16, Float f17) {
        this.darkStoreCartDiscount = (double) f11;
        this.darkStoreDeliveryFeeDiscount = (double) f12;
        this.darkStoreCartId = str;
        this.darkstoredijiniVendorId = str2;
        this.migratedPartialFulfillmentPreference = str3;
        this.darkstoresAgeLimit = str4;
        this.darkStoreDeliveryTotal = f14;
        this.darkStoreServiceFee = f15;
        this.darkStoreFeeDescriptions = list;
        this.darkStoreDeliveryFee = f16;
        this.darkStoreDiscount = f11;
        this.darkStoreDiscount = BigDecimal.valueOf((double) f11).setScale(3, 4).floatValue();
        this.darkStoreTotalDiscountToDisplay = f13;
        this.darkStoreTotalDiscountToDisplay = BigDecimal.valueOf((double) f13).setScale(3, 4).floatValue();
        this.darkStoreScheduledDeliveryDiscount = f17;
    }

    public void updateItemQuantity(CartMenuItem cartMenuItem, Context context) {
        updateQuantity(cartMenuItem, context);
    }

    public float getCartSubTotal(boolean z11, boolean z12) {
        float f11;
        float f12;
        Promotion promotion;
        BenefitItem benefitItem;
        if (!(!z11 || (promotion = this.selectedPromotion) == null || (benefitItem = promotion.selectedBenefitItem) == null)) {
            f12 = benefitItem.totalPrice;
            if (f12 > 0.0f) {
                f11 = this.total;
                return f11 - f12;
            }
        }
        if (z12) {
            float f13 = this.couponDiscount;
            if (f13 > 0.0f || this.binVoucherDiscount > 0.0f) {
                f11 = this.total - f13;
                f12 = this.binVoucherDiscount;
                return f11 - f12;
            }
        }
        return this.total;
    }

    public float getCartTotalPrice(boolean z11) {
        return this.total - getAllDiscounts();
    }

    public Cart setRestaurant(Restaurant restaurant2) {
        new Restaurant();
        this.restaurant = restaurant2;
        this.reorderItemMissingModel = new ReorderItemMissingModel();
        setPickupDetails(restaurant2);
        return cart;
    }
}
