package buisnessmodels;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.GEMResponse.GemAdapterRestaurant;
import JsonModels.Response.GEMResponse.GemOfferResponse;
import JsonModels.Response.GEMResponse.GemRestaurant;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Coupon;
import datamodels.Gem;
import datamodels.GemOfferItemsModel;
import datamodels.Promotion;
import datamodels.PromotionDisplay;
import datamodels.Restaurant;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import library.talabat.gemengine.GemPresenter;
import library.talabat.gemengine.GemView;
import library.talabat.gemengine.IGemPresenter;
import library.talabat.gemengine.NotificationHandler;
import library.talabat.mvp.checkoutdotcom.CheckoutDotComView;
import library.talabat.mvp.paymenterror.PaymentErrorView;
import library.talabat.mvp.paymentwebview.PaymentWebView;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;

public class GEMEngine {
    private static final int NOTIFICATION_TIME = 300;
    private static GEMEngine gemEngine;
    private static ArrayList<Gem> gems;
    private static int[] restaurantBranchIDs;
    private static ArrayList<GemAdapterRestaurant> restaurants;

    /* renamed from: a  reason: collision with root package name */
    public Handler f39636a;
    private boolean acceptedAvailable = false;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f39637b;

    /* renamed from: c  reason: collision with root package name */
    public int f39638c;
    private Coupon[] cartCoupons;
    private Promotion[] cartPromotions;
    private int count = 0;
    public int currentGemIndex = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39639d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39640e = false;
    private float eligibleOfferAmount = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f39641f;

    /* renamed from: g  reason: collision with root package name */
    public StringBuilder f39642g;
    public int gemCount = -1;
    private IGemPresenter gemPresenter;
    private ArrayList<Restaurant> gemRestaurants;
    private boolean gemSelected = false;
    /* access modifiers changed from: private */
    public GemView gemView;
    private String gemsString = "";
    private double gracePeriod;

    /* renamed from: h  reason: collision with root package name */
    public GemOfferResponse f39643h;
    public boolean isGracePeriod = false;
    /* access modifiers changed from: private */
    public boolean isIdle = false;
    /* access modifiers changed from: private */
    public boolean isListening = false;
    public boolean isPaymentScreen = false;
    /* access modifiers changed from: private */
    public NotificationHandler mNotificationHandlerListener;
    private double max;
    private boolean requestSent = false;
    private int restaurantPosition = getNoRestaurantPosition();
    private int seconds = 0;
    public Gem selectedGem;
    private Restaurant selectedGemRestaurant;
    private boolean supressCouponsandPromotions = false;
    private PromotionDisplay[] tempPromotions;
    private String tierNumber = "";
    private String timeInSeconds = TarConstants.VERSION_POSIX;
    private String timeString = "00:00";
    /* access modifiers changed from: private */
    public boolean timedout = false;
    /* access modifiers changed from: private */
    public int timerCount = 0;

    /* access modifiers changed from: private */
    public void gemReminderToast(int i11) {
        GemView gemView2 = this.gemView;
        if (gemView2 != null && i11 > 0) {
            gemView2.showInAppReminder((i11 % 3600) / 60);
        }
    }

    public static float getEligibleOfferAmount() {
        GEMEngine instance = getInstance();
        if (instance == null) {
            return 0.0f;
        }
        return instance.eligibleOfferAmount;
    }

    public static ArrayList<GemAdapterRestaurant> getGemRestaurants() {
        return restaurants;
    }

    public static GEMEngine getInstance() {
        return gemEngine;
    }

    public static int getNoGemIndexSelected() {
        return 0;
    }

    public static int getNoRestaurantPosition() {
        return -1;
    }

    public static boolean hasGemDiscount() {
        return GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice > 0.0f;
    }

    /* access modifiers changed from: private */
    public boolean isApplicationBroughtToBackground(Activity activity) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
            if (!runningTasks.isEmpty()) {
                ComponentName a11 = runningTasks.get(0).topActivity;
                try {
                    for (ActivityInfo activityInfo : activity.getPackageManager().getPackageInfo(activity.getPackageName(), 1).activities) {
                        if (a11.getClassName().equals(activityInfo.name)) {
                            return false;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    return false;
                }
            }
        } catch (Exception unused2) {
        }
        return true;
    }

    private void sendJokerShopAbandonedAnalytics() {
        GemView gemView2 = this.gemView;
        if (gemView2 != null) {
            AppTracker.onJokerShopAbandonCompleted(gemView2.getGemContext(), getTimeInSeconds(), GlobalDataModel.SELECTED.restaurant, this.gemView.getGemScreenType());
        } else {
            LogManager.logException(new IllegalStateException("analytics not sent - gemView is null"));
        }
    }

    private void sendJokerTierReachedAnalytics() {
        GemView gemView2 = this.gemView;
        if (gemView2 != null) {
            AppTracker.onJokerTierReached(gemView2.getGemContext(), this.restaurantPosition + "", this.timeInSeconds, getCurrentGemIndex() + "", GlobalDataModel.SELECTED.restaurant);
            return;
        }
        LogManager.logException(new IllegalStateException("analytics not sent - gemView is null"));
    }

    public static void start(boolean z11, boolean z12, boolean z13, AppVersionProvider appVersionProvider) {
        if (gemEngine == null) {
            gemEngine = new GEMEngine();
            restaurants = new ArrayList<>();
            gemEngine.gemRestaurants = new ArrayList<>();
            gems = new ArrayList<>();
        }
        GlobalDataModel.GEMCONSTANTS.isGemStarted = true;
        gemEngine.gemPresenter = new GemPresenter(appVersionProvider);
        gemEngine.max = GlobalDataModel.GEMCONSTANTS.gemTimer * 60.0d;
        gemEngine.gracePeriod = GlobalDataModel.GEMCONSTANTS.gemGracePeriod * 60.0d;
        GEMEngine gEMEngine = gemEngine;
        int i11 = 0;
        gEMEngine.timedout = false;
        gEMEngine.isIdle = true;
        gEMEngine.isPaymentScreen = false;
        gEMEngine.isGracePeriod = false;
        gEMEngine.f39641f = new StringBuilder();
        gemEngine.f39642g = new StringBuilder();
        GEMEngine gEMEngine2 = gemEngine;
        gEMEngine2.requestSent = false;
        gEMEngine2.tierNumber = "";
        gEMEngine2.selectedGemRestaurant = null;
        ArrayList arrayList = new ArrayList();
        if (z11) {
            FilterEngine filterEngine = GlobalDataModel.filterEngine;
            if (filterEngine == null || !filterEngine.getIsCusinesSortApplied()) {
                if (GlobalDataModel.restaurants.length > 0) {
                    int i12 = 0;
                    while (true) {
                        Restaurant[] restaurantArr = GlobalDataModel.restaurants;
                        if (i12 >= restaurantArr.length) {
                            break;
                        }
                        Restaurant restaurant = restaurantArr[i12];
                        if (restaurant.statusType == 0) {
                            arrayList.add(restaurant);
                        }
                        i12++;
                    }
                }
            } else if (GlobalDataModel.restaurants.length > 0) {
                int i13 = 0;
                while (true) {
                    Restaurant[] restaurantArr2 = GlobalDataModel.restaurants;
                    if (i13 >= restaurantArr2.length) {
                        break;
                    }
                    Restaurant restaurant2 = restaurantArr2[i13];
                    if (restaurant2.statusType == 0 && restaurant2.getCuisineString().contains(GlobalDataModel.filterEngine.getSelectedCuisineNames())) {
                        arrayList.add(restaurant2);
                    }
                    i13++;
                }
            }
        } else if (GlobalDataModel.restaurants.length > 0) {
            int i14 = 0;
            while (true) {
                Restaurant[] restaurantArr3 = GlobalDataModel.restaurants;
                if (i14 >= restaurantArr3.length) {
                    break;
                }
                Restaurant restaurant3 = restaurantArr3[i14];
                if (restaurant3.statusType == 0) {
                    arrayList.add(restaurant3);
                }
                i14++;
            }
        }
        if (z13) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Restaurant restaurant4 = (Restaurant) it.next();
                if (((double) restaurant4.getRating()) >= 3.0d) {
                    arrayList2.add(restaurant4);
                }
            }
            arrayList = arrayList2;
        }
        if (!z12 || GlobalDataModel.GEMCONSTANTS.GemTiers == null) {
            restaurantBranchIDs = new int[arrayList.size()];
            while (i11 < arrayList.size()) {
                restaurantBranchIDs[i11] = ((Restaurant) arrayList.get(i11)).getBranchId();
                i11++;
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Restaurant restaurant5 = (Restaurant) it2.next();
            if (((double) restaurant5.getMinimumAmount()) <= GlobalDataModel.GEMCONSTANTS.GemTiers.getTierAmount() - GlobalDataModel.GEMCONSTANTS.GemTiers.getDiscount()) {
                arrayList3.add(restaurant5);
            }
        }
        restaurantBranchIDs = new int[arrayList3.size()];
        while (i11 < arrayList3.size()) {
            restaurantBranchIDs[i11] = ((Restaurant) arrayList3.get(i11)).getBranchId();
            i11++;
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        GlobalDataModel.GEMCONSTANTS.isGemFlow = false;
        GlobalDataModel.GEMCONSTANTS.isGemStarted = false;
        GlobalDataModel.GEMCONSTANTS.isAdDisableGem = false;
        if (Cart.getInstance() != null) {
            Cart.getInstance().setGemOfferAmount(0.0f);
        }
        this.cartCoupons = null;
        this.cartPromotions = null;
        this.timedout = false;
        gemEngine = null;
        this.gemSelected = false;
        this.f39640e = false;
        this.f39639d = false;
        this.timeString = "00:00";
        this.timeInSeconds = TarConstants.VERSION_POSIX;
        stopListening();
        stopTimer();
        this.currentGemIndex = -1;
        this.gemCount = -1;
        this.isIdle = false;
        this.isPaymentScreen = false;
        this.isGracePeriod = false;
        this.f39641f = null;
        this.f39642g = null;
        this.gemPresenter = null;
        this.requestSent = false;
        this.tierNumber = "";
        this.count = 0;
        this.gemRestaurants = null;
        this.selectedGemRestaurant = null;
        this.restaurantPosition = -1;
        this.acceptedAvailable = false;
    }

    public static void stopListening() {
        GEMEngine instance = getInstance();
        if (instance != null) {
            instance.stopListeners();
        }
    }

    public static void withGemEngine(Consumer<GEMEngine> consumer) {
        GEMEngine instance;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow() && (instance = getInstance()) != null) {
            try {
                consumer.accept(instance);
            } catch (Throwable th2) {
                LogManager.logException(th2);
            }
        }
    }

    public Restaurant acceptGem(Restaurant restaurant) {
        GemOfferResponse gemOfferResponse;
        GemOfferItemsModel[] gemOfferItemsModelArr;
        Restaurant restaurant2 = new Restaurant();
        this.gemSelected = true;
        if (!(this.gemPresenter == null || (gemOfferResponse = this.f39643h) == null || (gemOfferItemsModelArr = gemOfferResponse.gemOfferItems) == null || gemOfferItemsModelArr.length <= 0)) {
            String str = "";
            long j11 = 0;
            int i11 = 0;
            while (true) {
                GemOfferItemsModel[] gemOfferItemsModelArr2 = this.f39643h.gemOfferItems;
                if (i11 >= gemOfferItemsModelArr2.length) {
                    break;
                }
                if (gemOfferItemsModelArr2[i11].getBranchId() == restaurant.getBranchId()) {
                    GemOfferResponse gemOfferResponse2 = this.f39643h;
                    String str2 = gemOfferResponse2.offerId;
                    long j12 = gemOfferResponse2.gemOfferItems[i11].reservationCode;
                    str = str2;
                    j11 = j12;
                }
                i11++;
            }
            this.gemPresenter.acceptGemOffer(str, j11);
        }
        return restaurant2;
    }

    public Gem closestGem(float f11, boolean z11) {
        Gem gem;
        TreeSet treeSet = new TreeSet();
        Iterator<Gem> it = gems.iterator();
        while (it.hasNext()) {
            treeSet.add(Float.valueOf(it.next().getConditionAmount()));
        }
        if (treeSet.ceiling(Float.valueOf(f11)) == null) {
            if (!z11) {
                setGemSelected(getLargestGem());
            }
            gem = new Gem(0.0f, 0.0f);
            gem.setLastOffer(true);
        } else if (f11 < ((Float) treeSet.ceiling(Float.valueOf(f11))).floatValue()) {
            gem = searchGem((double) ((Float) treeSet.ceiling(Float.valueOf(f11))).floatValue());
            gem.setLastOffer(false);
        } else if (f11 != ((Float) treeSet.ceiling(Float.valueOf(f11))).floatValue() || searchGem((double) ((Float) treeSet.ceiling(Float.valueOf(f11))).floatValue()).getIndex() == gems.size()) {
            if (!z11) {
                setGemSelected(getLargestGem());
            }
            gem = new Gem(0.0f, 0.0f);
            gem.setLastOffer(true);
        } else if (treeSet.higher(Float.valueOf(f11)) != null) {
            gem = searchGem((double) ((Float) treeSet.higher(Float.valueOf(f11))).floatValue());
        } else {
            if (!z11) {
                setGemSelected(getLargestGem());
            }
            gem = new Gem(0.0f, 0.0f);
            gem.setLastOffer(true);
        }
        if (treeSet.floor(Float.valueOf(f11)) != null) {
            if (!z11) {
                setGemSelected(searchGem((double) ((Float) treeSet.floor(Float.valueOf(f11))).floatValue()));
            }
            gem.setFlooringGem(searchGem((double) ((Float) treeSet.floor(Float.valueOf(f11))).floatValue()));
        } else {
            if (!z11) {
                setGemSelected((Gem) null);
            }
            gem.setFlooringGem(new Gem(0.0f, 0.0f));
        }
        if (getCurrentGemIndex() != this.currentGemIndex && getCurrentGemIndex() > 0) {
            this.currentGemIndex = getCurrentGemIndex();
            sendJokerTierReachedAnalytics();
        }
        return gem;
    }

    public void deleteNotification() {
        NotificationHandler notificationHandler = this.mNotificationHandlerListener;
        if (notificationHandler != null) {
            notificationHandler.deleteNotification();
        }
    }

    public void gemItemCartUpdation(float f11) {
        Gem closestGem = closestGem(f11, false);
        if (closestGem != null) {
            GlobalDataModel.GEMCONSTANTS.isGemRedeemed = false;
            getInstance().setEligibleOfferAmount(closestGem.getFlooringGem().getDiscount());
        }
    }

    public int getCurrentGemIndex() {
        ArrayList<Gem> arrayList = gems;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Gem> it = gems.iterator();
            while (it.hasNext()) {
                Gem next = it.next();
                if (next.isSelected()) {
                    return next.getIndex();
                }
            }
        }
        return getNoGemIndexSelected();
    }

    public int getGemCount() {
        ArrayList<Gem> arrayList = gems;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public GemOfferResponse getGemOffer() {
        return this.f39643h;
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }

    public void getGemsAndRestaurants() {
        String str;
        int[] iArr = restaurantBranchIDs;
        if (iArr.length > 0) {
            for (int i11 : iArr) {
                if (this.f39641f.length() > 0 && i11 > 0) {
                    this.f39641f.append(",");
                }
                if (i11 > 0) {
                    this.f39641f.append(i11);
                }
            }
            if (this.f39641f.length() > 0) {
                str = this.f39641f.toString();
            } else {
                str = "";
            }
            IGemPresenter iGemPresenter = this.gemPresenter;
            if (iGemPresenter != null) {
                this.requestSent = true;
                iGemPresenter.getGemOffers(GlobalDataModel.SelectedAreaId, str, "" + GlobalDataModel.SelectedCountryId);
            }
        }
    }

    public Gem getLargestGem() {
        ArrayList<Gem> arrayList = gems;
        return arrayList.get(arrayList.size() - 1);
    }

    public Gem getLowestGem() {
        return gems.get(0);
    }

    public int getRestaurantPosition() {
        return this.restaurantPosition;
    }

    public String getTime() {
        return this.timeString;
    }

    public String getTimeInSeconds() {
        return this.timeInSeconds;
    }

    public Gem higherGemAvailble(float f11, boolean z11) {
        Gem closestGem = closestGem(f11, true);
        if (closestGem.getConditionAmount() >= f11) {
            return closestGem;
        }
        return null;
    }

    public void initialiseTimer() {
        Handler handler;
        Runnable runnable = this.f39637b;
        if (!(runnable == null || (handler = this.f39636a) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.f39636a = null;
        this.f39637b = null;
    }

    public boolean isAcceptedAvailable() {
        return this.acceptedAvailable;
    }

    public boolean isTimedout() {
        return this.timedout;
    }

    public void rejectGem(boolean z11) {
        if (this.f39639d) {
            this.f39639d = false;
            Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
            if (restaurant != null) {
                restaurant.isCouponAvailable = true;
                restaurant.isMealDealAvailable = true;
            }
            PromotionDisplay[] promotionDisplayArr = this.tempPromotions;
            if (promotionDisplayArr != null) {
                GlobalDataModel.JSON.menuItemsResponseModel.promotions = promotionDisplayArr;
                this.tempPromotions = null;
            }
            GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = true;
            GlobalDataModel.GEMCONSTANTS.reloadRequired = true;
        }
        if (this.f39640e && Cart.getInstance().getRestaurant() != null) {
            Cart.getInstance().getRestaurant().isCouponAvailable = true;
            Cart.getInstance().getRestaurant().isMealDealAvailable = true;
            Cart.getInstance().setCoupons(this.cartCoupons);
            Cart.getInstance().setPromotions(this.cartPromotions);
            this.cartCoupons = null;
            this.cartPromotions = null;
        }
        if (z11) {
            if (!(this.gemPresenter == null || getGemOffer() == null || TalabatUtils.isNullOrEmpty(getGemOffer().offerId))) {
                this.gemPresenter.rejectGemOffer(getGemOffer().offerId);
            }
            sendJokerShopAbandonedAnalytics();
        }
        deleteNotification();
        stop();
    }

    public Gem searchGem(double d11) {
        Iterator<Gem> it = gems.iterator();
        while (it.hasNext()) {
            Gem next = it.next();
            if (((double) next.getConditionAmount()) == d11) {
                return next;
            }
        }
        return null;
    }

    public void setEligibleOfferAmount(float f11) {
        this.eligibleOfferAmount = f11;
        GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice = f11;
        Cart.getInstance().setGemOfferAmount(f11);
    }

    public void setGemOffer(GemOfferResponse gemOfferResponse) {
        this.f39643h = gemOfferResponse;
    }

    public void setGemSelected(Gem gem) {
        ArrayList<Gem> arrayList = gems;
        if (arrayList != null && arrayList.size() > 0) {
            if (gem != null) {
                Iterator<Gem> it = gems.iterator();
                while (it.hasNext()) {
                    Gem next = it.next();
                    if (gem.getConditionAmount() == next.getConditionAmount()) {
                        next.setSelected(true);
                    } else {
                        next.setSelected(false);
                    }
                }
                return;
            }
            Iterator<Gem> it2 = gems.iterator();
            while (it2.hasNext()) {
                it2.next().setSelected(false);
            }
        }
    }

    public void setGems(Gem[] gemArr) {
        ArrayList<Gem> arrayList = new ArrayList<>();
        gems = arrayList;
        if (gemArr != null && gemArr.length > 0) {
            this.gemsString = "";
            arrayList.addAll(Arrays.asList(gemArr));
            Collections.sort(gems, new Comparator<Gem>() {
                public int compare(Gem gem, Gem gem2) {
                    return Double.compare((double) gem.getConditionAmount(), (double) gem2.getConditionAmount());
                }
            });
            int i11 = 0;
            while (i11 < gems.size()) {
                int i12 = i11 + 1;
                gems.get(i11).setIndex(i12);
                if (this.f39642g.length() > 0) {
                    this.f39642g.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                StringBuilder sb2 = this.f39642g;
                sb2.append("Order for : " + TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(i11).getConditionAmount(), true) + " and Save : " + TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(i11).getDiscount(), true));
                i11 = i12;
            }
            if (this.f39642g.length() > 0) {
                setGemsString(this.f39642g.toString());
            }
        }
    }

    public void setGemsString(String str) {
        this.gemsString = str;
    }

    public void setMaxTime(double d11) {
        this.max = d11;
    }

    public void setNotificationHandlerListener(NotificationHandler notificationHandler) {
        this.mNotificationHandlerListener = notificationHandler;
    }

    public void setRestaurants(ArrayList<GemRestaurant> arrayList) {
        this.requestSent = false;
        this.acceptedAvailable = false;
        restaurants = new ArrayList<>();
        if (arrayList.size() > 0) {
            Iterator<GemRestaurant> it = arrayList.iterator();
            while (it.hasNext()) {
                GemRestaurant next = it.next();
                if (next.status == 1) {
                    this.acceptedAvailable = true;
                }
                for (Restaurant restaurant : GlobalDataModel.restaurants) {
                    if (next.restaurantBranchId == restaurant.getBranchId()) {
                        restaurants.add(new GemAdapterRestaurant(next.status, restaurant, next.imagePath));
                    }
                }
            }
            if (this.acceptedAvailable && restaurants.size() > 0) {
                if (TalabatUtils.isArabic()) {
                    Collections.sort(restaurants, new Comparator<GemAdapterRestaurant>() {
                        public int compare(GemAdapterRestaurant gemAdapterRestaurant, GemAdapterRestaurant gemAdapterRestaurant2) {
                            return gemAdapterRestaurant.status - gemAdapterRestaurant2.status;
                        }
                    });
                } else {
                    Collections.sort(restaurants, new Comparator<GemAdapterRestaurant>() {
                        public int compare(GemAdapterRestaurant gemAdapterRestaurant, GemAdapterRestaurant gemAdapterRestaurant2) {
                            return gemAdapterRestaurant2.status - gemAdapterRestaurant.status;
                        }
                    });
                }
            }
            if (this.gemView == null) {
                return;
            }
            if (restaurants.size() > 0) {
                this.gemView.showGemDialog();
                return;
            }
            this.gemView.stopLoading();
            stop();
            return;
        }
        GemView gemView2 = this.gemView;
        if (gemView2 != null) {
            gemView2.stopLoading();
            stop();
        }
    }

    public void setTime(String str) {
        this.timeString = str;
    }

    public void setTimeinSeconds(String str) {
        this.timeInSeconds = str;
    }

    public boolean shouldClearCart() {
        if (Cart.getInstance().getRestaurant() == null) {
            return false;
        }
        Cart.getInstance().getRestaurant();
        if (Cart.getInstance().hasItems()) {
            return true;
        }
        return false;
    }

    public void startListening(GemView gemView2, boolean z11) {
        int i11;
        if (this.isIdle) {
            this.isPaymentScreen = z11;
            this.isListening = true;
            this.gemView = gemView2;
            if (!this.isGracePeriod || (gemView2 instanceof PaymentErrorView) || (gemView2 instanceof CheckoutDotComView) || (gemView2 instanceof PaymentWebView)) {
                boolean z12 = this.timedout;
                if (z12 && z11 && (i11 = this.count) == 0) {
                    this.count = i11 + 1;
                    this.timedout = false;
                    startTimer(true);
                } else if (z12 && !z11) {
                    deleteNotification();
                    this.gemView.showTimeOutDialog();
                }
            } else {
                deleteNotification();
                this.gemView.showTimeOutDialog();
            }
        }
    }

    public void startTimer(final boolean z11) {
        double d11;
        this.timedout = false;
        if (z11) {
            d11 = this.gracePeriod;
        } else {
            d11 = this.max;
        }
        this.f39638c = (int) d11;
        gemEngine.isGracePeriod = z11;
        initialiseTimer();
        this.f39636a = new Handler();
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                GEMEngine gEMEngine;
                int i11;
                GEMEngine gEMEngine2 = GEMEngine.this;
                if (gEMEngine2.f39638c <= 0) {
                    gEMEngine2.deleteNotification();
                    if (!GEMEngine.this.isListening || !GEMEngine.this.isIdle) {
                        GEMEngine.this.timedout = true;
                        boolean z11 = GEMEngine.this.gemView instanceof PaymentWebView;
                    } else {
                        GEMEngine gEMEngine3 = GEMEngine.this;
                        if (!gEMEngine3.isPaymentScreen || gEMEngine3.timerCount != 0 || GEMEngine.this.getCurrentGemIndex() <= 0) {
                            GEMEngine.this.timedout = true;
                            GEMEngine.this.gemView.showTimeOutDialog();
                        } else {
                            GEMEngine gEMEngine4 = GEMEngine.this;
                            gEMEngine4.timerCount = gEMEngine4.timerCount + 1;
                            GEMEngine.this.startTimer(true);
                            GEMEngine.this.isPaymentScreen = false;
                        }
                    }
                    GEMEngine.this.f39636a.removeCallbacks(this);
                } else if (!z11 || (gEMEngine2.gemView instanceof PaymentErrorView) || (GEMEngine.this.gemView instanceof CheckoutDotComView) || (GEMEngine.this.gemView instanceof PaymentWebView)) {
                    GEMEngine.this.f39638c--;
                    StringBuilder sb2 = new StringBuilder();
                    Locale locale = Locale.US;
                    sb2.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(GEMEngine.this.f39638c / 60)}));
                    sb2.append(CertificateUtil.DELIMITER);
                    sb2.append(String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(GEMEngine.this.f39638c % 60)}));
                    String sb3 = sb2.toString();
                    GEMEngine.this.setTime(sb3);
                    GEMEngine.this.setTimeinSeconds(GEMEngine.this.f39638c + "");
                    GEMEngine.this.timedout = false;
                    if (GEMEngine.this.isListening) {
                        GEMEngine gEMEngine5 = GEMEngine.this;
                        if (!gEMEngine5.isPaymentScreen) {
                            gEMEngine5.gemView.showTimerView(true, sb3);
                        }
                    }
                    if (GEMEngine.this.mNotificationHandlerListener != null && (GEMEngine.this.mNotificationHandlerListener instanceof Activity) && (i11 = gEMEngine.f39638c) > 0 && (i11 % 300 == 0 || (i11 <= 300 && i11 == 60))) {
                        if (!gEMEngine.isApplicationBroughtToBackground((Activity) (gEMEngine = GEMEngine.this).mNotificationHandlerListener) && GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                            GEMEngine gEMEngine6 = GEMEngine.this;
                            gEMEngine6.gemReminderToast(gEMEngine6.f39638c);
                        }
                        GEMEngine gEMEngine7 = GEMEngine.this;
                        if (!gEMEngine7.isApplicationBroughtToBackground((Activity) gEMEngine7.mNotificationHandlerListener)) {
                            GEMEngine.this.deleteNotification();
                        } else if (Cart.getInstance().hasItems() && GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                            GEMEngine.this.mNotificationHandlerListener.showNotification(GEMEngine.this.f39638c);
                        }
                    }
                    GEMEngine.this.f39636a.postDelayed(this, 1000);
                } else {
                    GEMEngine.this.deleteNotification();
                    GEMEngine.this.timedout = true;
                    GEMEngine.this.gemView.showTimeOutDialog();
                    GEMEngine.this.stop();
                    GEMEngine.this.f39636a.removeCallbacks(this);
                }
            }
        };
        this.f39637b = r02;
        r02.run();
    }

    public void stopListeners() {
        this.isListening = false;
        this.gemView = null;
    }

    public void stopTimer() {
        Handler handler;
        Runnable runnable = this.f39637b;
        if (!(runnable == null || (handler = this.f39636a) == null)) {
            handler.removeCallbacks(runnable);
        }
        NotificationHandler notificationHandler = this.mNotificationHandlerListener;
        if (notificationHandler != null) {
            notificationHandler.deleteNotification();
        }
    }

    public void supressCouponsAndPromotion(Restaurant restaurant) {
        new Restaurant();
        Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
        if (restaurant2 != null) {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            PromotionDisplay[] promotionDisplayArr = menuItemsResponseModel.promotions;
            if (promotionDisplayArr != null) {
                this.tempPromotions = promotionDisplayArr;
                menuItemsResponseModel.promotions = null;
            }
            restaurant2.isMealDealAvailable = false;
            restaurant2.isCouponAvailable = false;
            this.f39639d = true;
            GlobalDataModel.SELECTED.updateRestaurant(restaurant2);
            GlobalDataModel.GEMCONSTANTS.menuCouponSupressed = true;
        }
    }

    public void supressCouponsAndPromotionForCart() {
        if (Cart.getInstance().getRestaurant() != null) {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
            if (restaurant2 != null && restaurant.f13872id == restaurant2.f13872id && (Cart.getInstance().getRestaurant().isMealDealAvailable || Cart.getInstance().getRestaurant().isCouponAvailable)) {
                Cart.getInstance().getRestaurant().isMealDealAvailable = false;
                Cart.getInstance().getRestaurant().isCouponAvailable = false;
                this.cartCoupons = Cart.getInstance().getCoupons();
                this.cartPromotions = Cart.getInstance().getPromotions();
                Cart.getInstance().setCoupons((Coupon[]) null);
                Cart.getInstance().setPromotions((Promotion[]) null);
                GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = true;
                GlobalDataModel.GEMCONSTANTS.reloadRequired = true;
                this.f39640e = true;
            }
            Iterator<GemAdapterRestaurant> it = getGemRestaurants().iterator();
            while (it.hasNext()) {
                if (it.next().restaurant.f13872id == restaurant.f13872id && (Cart.getInstance().getRestaurant().isMealDealAvailable || Cart.getInstance().getRestaurant().isCouponAvailable)) {
                    Cart.getInstance().getRestaurant().isMealDealAvailable = false;
                    Cart.getInstance().getRestaurant().isCouponAvailable = false;
                    this.cartCoupons = Cart.getInstance().getCoupons();
                    this.cartPromotions = Cart.getInstance().getPromotions();
                    Cart.getInstance().setCoupons((Coupon[]) null);
                    Cart.getInstance().setPromotions((Promotion[]) null);
                    GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = true;
                    GlobalDataModel.GEMCONSTANTS.reloadRequired = true;
                    this.f39640e = true;
                    return;
                }
            }
        }
    }
}
