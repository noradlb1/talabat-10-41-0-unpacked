package library.talabat.mvp.restaurantmenu;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.PreviousOrderList.PreviousOrder;
import JsonModels.Response.PreviousOrderList.PreviousOrderItem;
import JsonModels.Response.PreviousOrderList.PreviousOrderResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import a10.g;
import a10.i;
import android.content.Context;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import b20.c;
import b20.d;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.VolleyError;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.ObservabilityManagerIntegrator;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.OffersItem;
import datamodels.PromotionDisplay;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;

public class RestaurantMeuScreenPresenterR implements IRestaurantMenuScreenPresenterR, RestaurantMenuListener {
    public static final int POSSIBLE_QUANTITY_PER_ITEM = 100;

    /* renamed from: a  reason: collision with root package name */
    public MenuItemsResponseModel f26839a = new MenuItemsResponseModel();

    /* renamed from: b  reason: collision with root package name */
    public RestaurantMenuScreenView f26840b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashSet<String> f26841c = new LinkedHashSet<>();
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final CustomerRepository customerRepository;

    /* renamed from: d  reason: collision with root package name */
    public LinkedHashSet<String> f26842d = new LinkedHashSet<>();
    /* access modifiers changed from: private */
    public CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Pair<String, String>> errorData = new MutableLiveData<>();
    private String eventOrigin = "";
    private final LocationConfigurationRepository locationConfigurationRepository;
    public Restaurant mRestaurant;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    private MutableLiveData<ArrayList<PreviousOrder>> previousOrderList = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public PreviousOrderResponse previousOrderResponse;
    private IRestaurantMenuInteractor restaurantMenuInteractor;
    private MutableLiveData<Boolean> showBusyPopup = new MutableLiveData<>();
    private final ITalabatExperiment talabatExperiment;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public RestaurantMeuScreenPresenterR(AppVersionProvider appVersionProvider, RestaurantMenuScreenView restaurantMenuScreenView, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, CustomerRepository customerRepository2) {
        String screenName = restaurantMenuScreenView.getScreenName();
        MenuResponseMapper menuResponseMapper = MenuResponseMapper.INSTANCE;
        if (shouldUseNewMenuMapper(screenName, menuResponseMapper.getMenuModel().getRestaurant().shopType == 1 ? false : true, iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_MENU_MAPPER, false))) {
            this.mRestaurant = menuResponseMapper.getMenuModel().getRestaurant();
            this.f26839a = menuResponseMapper.getMenuModel().getMenuItemsResponseModel();
        } else {
            this.mRestaurant = GlobalDataModel.SELECTED.getRestaurant();
            this.f26839a = GlobalDataModel.JSON.menuItemsResponseModel;
        }
        this.restaurantMenuInteractor = new RestaurantMenuInteractor(appVersionProvider, configurationLocalRepository2, locationConfigurationRepository2, this);
        this.f26840b = restaurantMenuScreenView;
        this.previousOrderResponse = new PreviousOrderResponse();
        this.errorData.postValue(null);
        this.showBusyPopup.postValue(null);
        this.previousOrderList.postValue(null);
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.talabatExperiment = iTalabatExperiment;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.customerRepository = customerRepository2;
    }

    private void addItemToCart(Cart cart, CartMenuItem cartMenuItem, String str) {
        MenuItemRM menuItemRM;
        String str2;
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel != null && (menuItemRM = menuItemsResponseModel.menu) != null && menuItemRM.menuSection != null) {
            if (cart.getCartItemQuantity(cartMenuItem) < 99) {
                cart.addItem(cartMenuItem, this.f26840b.getContext());
                ArrayList<ChoiceSection> arrayList = cartMenuItem.selectedChoices;
                if (arrayList != null) {
                    str2 = getChoicesString(arrayList);
                } else {
                    str2 = "";
                }
                CartMenuItem cartMenuItem2 = cartMenuItem;
                String str3 = str;
                AppTracker.onItemAddedToCart(this.f26840b.getContext(), Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(this.mRestaurant), AppTracker.getRestaurantName(this.mRestaurant), str3, str2, cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(this.f26840b.getScreenName()), this.f26840b.getScreenName());
                GlobalDataModel.ANIMATIONHELPER.addItemClicked = true;
                this.f26840b.onItemAdded(cartMenuItem);
                return;
            }
            this.f26840b.onMaxCartItemsReached();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        if (r4.isEmpty() == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a9, code lost:
        r15.setSelectedChoicesForSection(r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addItemWithChoicesToCart(JsonModels.Response.PreviousOrderList.PreviousOrderItem r18, datamodels.MenuItem r19, buisnessmodels.Cart r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            JsonModels.MenuItemsResponseModel r3 = r0.f26839a
            if (r3 != 0) goto L_0x000b
            return
        L_0x000b:
            JsonModels.MenuItemRM r3 = r3.menu
            if (r3 != 0) goto L_0x0010
            return
        L_0x0010:
            datamodels.MenuSection[] r3 = r3.menuSection
            if (r3 != 0) goto L_0x0015
            return
        L_0x0015:
            boolean r3 = r18.hasChoices()
            if (r3 == 0) goto L_0x012e
            java.util.List<JsonModels.Response.PreviousOrderList.PreviousOrderItemChoice> r3 = r1.choices
            int r3 = r3.size()
            java.util.List<JsonModels.Response.PreviousOrderList.PreviousOrderItemChoice> r4 = r1.choices
            java.util.List r4 = JsonModels.Response.PreviousOrderList.PreviousOrderItem.copyList(r4)
            datamodels.CartMenuItem r15 = datamodels.CartMenuItem.createWithMenuItem(r19)
            int r5 = r2.getCartItemQuantity(r15)
            int r6 = r1.quantity
            int r7 = r5 + r6
            r8 = 100
            if (r7 > r8) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r5 = r5 + r6
            int r5 = r5 - r8
            int r6 = r6 - r5
        L_0x003b:
            if (r6 <= 0) goto L_0x012e
            r15.setQuantity(r6)
            com.talabat.helpers.GlobalDataModel.SELECTED.cartMenuItem = r15
            r5 = r19
            datamodels.ChoiceSection[] r5 = r5.choiceSections
            int r6 = r5.length
            r8 = 0
            r9 = 0
        L_0x0049:
            if (r8 >= r6) goto L_0x00ba
            r10 = r5[r8]
            datamodels.ChoiceSection r11 = datamodels.ChoiceSection.createSelectedChoiceSection(r10)
            java.util.ArrayList<datamodels.ChoiceItem> r10 = r10.itemChoices
            java.util.Iterator r10 = r10.iterator()
        L_0x0057:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x00b2
            java.lang.Object r12 = r10.next()
            datamodels.ChoiceItem r12 = (datamodels.ChoiceItem) r12
            java.util.Iterator r13 = r4.iterator()
        L_0x0067:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00ad
            java.lang.Object r14 = r13.next()
            JsonModels.Response.PreviousOrderList.PreviousOrderItemChoice r14 = (JsonModels.Response.PreviousOrderList.PreviousOrderItemChoice) r14
            boolean r16 = r14.hasChoices()
            if (r16 == 0) goto L_0x0081
            java.util.LinkedHashSet<java.lang.String> r4 = r0.f26842d
            java.lang.String r5 = r1.itemName
            r4.add(r5)
            goto L_0x00ba
        L_0x0081:
            int r7 = r12.f13839id
            r16 = r5
            int r5 = r14.f479id
            if (r7 == r5) goto L_0x0099
            java.lang.String r5 = r12.f13840name
            java.lang.String r7 = r14.getChoiceName()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0096
            goto L_0x0099
        L_0x0096:
            r5 = r16
            goto L_0x0067
        L_0x0099:
            java.util.ArrayList<datamodels.ChoiceItem> r5 = r11.itemChoices
            r5.add(r12)
            r4.remove(r14)
            int r9 = r9 + 1
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x00af
            r15.setSelectedChoicesForSection(r11)
            goto L_0x00ba
        L_0x00ad:
            r16 = r5
        L_0x00af:
            r5 = r16
            goto L_0x0057
        L_0x00b2:
            r16 = r5
            r15.setSelectedChoicesForSection(r11)
            int r8 = r8 + 1
            goto L_0x0049
        L_0x00ba:
            if (r9 != r3) goto L_0x0127
            boolean r3 = r15.isAllMantatoryChoiceSelected()
            if (r3 == 0) goto L_0x011f
            library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView r1 = r0.f26840b
            android.content.Context r1 = r1.getContext()
            r2.addItem(r15, r1)
            java.util.ArrayList<datamodels.ChoiceSection> r1 = r15.selectedChoices
            if (r1 == 0) goto L_0x00d4
            java.lang.String r1 = r0.getChoicesString(r1)
            goto L_0x00d6
        L_0x00d4:
            java.lang.String r1 = ""
        L_0x00d6:
            r11 = r1
            library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView r1 = r0.f26840b
            android.content.Context r5 = r1.getContext()
            buisnessmodels.Cart r1 = buisnessmodels.Cart.getInstance()
            datamodels.Restaurant r6 = r1.getRestaurant()
            datamodels.Restaurant r1 = r0.mRestaurant
            int r8 = tracking.AppTracker.getRestaurantId(r1)
            datamodels.Restaurant r1 = r0.mRestaurant
            java.lang.String r9 = tracking.AppTracker.getRestaurantName(r1)
            java.lang.String r10 = "reorder_swimlane"
            int[] r1 = r15.getSelectedQuantityOfMandatoryAndOptionalChoices()
            r2 = 0
            r12 = r1[r2]
            int[] r1 = r15.getSelectedQuantityOfMandatoryAndOptionalChoices()
            r2 = 1
            r13 = r1[r2]
            library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView r1 = r0.f26840b
            java.lang.String r1 = r1.getScreenName()
            java.lang.String r14 = tracking.ScreenNames.getScreenType(r1)
            library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView r1 = r0.f26840b
            java.lang.String r1 = r1.getScreenName()
            r7 = r15
            r3 = r15
            r15 = r1
            tracking.AppTracker.onItemAddedToCart(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.talabat.helpers.GlobalDataModel.ANIMATIONHELPER.addItemClicked = r2
            library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView r1 = r0.f26840b
            r1.onItemAdded(r3)
            goto L_0x012e
        L_0x011f:
            java.util.LinkedHashSet<java.lang.String> r2 = r0.f26842d
            java.lang.String r1 = r1.itemName
            r2.add(r1)
            goto L_0x012e
        L_0x0127:
            java.util.LinkedHashSet<java.lang.String> r2 = r0.f26842d
            java.lang.String r1 = r1.itemName
            r2.add(r1)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.restaurantmenu.RestaurantMeuScreenPresenterR.addItemWithChoicesToCart(JsonModels.Response.PreviousOrderList.PreviousOrderItem, datamodels.MenuItem, buisnessmodels.Cart):void");
    }

    private void addItemsWithoutChoicesToCart(Cart cart, PreviousOrderItem previousOrderItem, MenuItem menuItem) {
        String str;
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(menuItem);
        int cartItemQuantity = cart.getCartItemQuantity(createWithMenuItem);
        int i11 = previousOrderItem.quantity;
        if (cartItemQuantity + i11 > 100) {
            i11 -= (cartItemQuantity + i11) - 100;
        }
        if (i11 > 0) {
            createWithMenuItem.setQuantity(i11);
            cart.addItem(createWithMenuItem, this.f26840b.getContext());
            ArrayList<ChoiceSection> arrayList = createWithMenuItem.selectedChoices;
            if (arrayList != null) {
                str = getChoicesString(arrayList);
            } else {
                str = "";
            }
            String str2 = str;
            if (this.f26840b.getContext() != null) {
                AppTracker.onItemAddedToCart(this.f26840b.getContext(), Cart.getInstance().getRestaurant(), createWithMenuItem, AppTracker.getRestaurantId(this.mRestaurant), AppTracker.getRestaurantName(this.mRestaurant), "reorder_swimlane", str2, createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(this.f26840b.getScreenName()), this.f26840b.getScreenName());
            }
            GlobalDataModel.ANIMATIONHELPER.addItemClicked = true;
            this.f26840b.onItemAdded(createWithMenuItem);
        }
    }

    private boolean canAddItem(int i11) {
        return getRestaurantMenuItem(i11).f13861id == i11;
    }

    private void continueAddingItems(Cart cart, Restaurant restaurant, PreviousOrder previousOrder) {
        if (previousOrder != null && previousOrder.hasItems()) {
            for (PreviousOrderItem next : previousOrder.items) {
                int i11 = next.f478id;
                if (i11 > 0) {
                    MenuItem restaurantMenuItemForPreviousOrder = getRestaurantMenuItemForPreviousOrder(i11, next.itemName);
                    int i12 = restaurantMenuItemForPreviousOrder.f13861id;
                    if (i12 <= 0 || (i12 != next.f478id && !restaurantMenuItemForPreviousOrder.f13862name.equals(next.itemName))) {
                        this.f26841c.add(next.itemName);
                    } else if (!next.hasChoices()) {
                        addItemsWithoutChoicesToCart(cart, next, restaurantMenuItemForPreviousOrder);
                    } else if (restaurantMenuItemForPreviousOrder.willHaveChoices()) {
                        if (!restaurantMenuItemForPreviousOrder.isChoicesLoaded()) {
                            getChoiceForReorderItem(cart, restaurant, next, restaurantMenuItemForPreviousOrder);
                        } else {
                            addItemWithChoicesToCart(next, restaurantMenuItemForPreviousOrder, cart);
                        }
                    }
                }
            }
            createErrorForPreviousOrder(this.f26841c, this.f26842d);
        }
    }

    private void createErrorForPreviousOrder(LinkedHashSet<String> linkedHashSet, LinkedHashSet<String> linkedHashSet2) {
        this.errorData.postValue(new Pair(getNamesWithSeparator(linkedHashSet), getNamesWithSeparator(linkedHashSet2)));
    }

    private void getChoiceForReorderItem(final Cart cart, Restaurant restaurant, final PreviousOrderItem previousOrderItem, final MenuItem menuItem) {
        Single.fromObservable(this.restaurantMenuInteractor.getChoicesForMenuItem(restaurant.branchId + "", menuItem.f13861id + "")).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<SplitChoiceRM>() {
            public void onError(Throwable th2) {
                RestaurantMeuScreenPresenterR.this.f26840b.stopNonCancelableLoading();
            }

            public void onSubscribe(Disposable disposable) {
                RestaurantMeuScreenPresenterR.this.disposable.add(disposable);
            }

            public void onSuccess(SplitChoiceRM splitChoiceRM) {
                SplitChoiceItemModel[] splitChoiceItemModelArr = splitChoiceRM.result.items;
                if (splitChoiceItemModelArr.length > 0) {
                    RestaurantMeuScreenPresenterR.this.updateMenuWithReceivedChoices(splitChoiceItemModelArr[0]);
                    RestaurantMeuScreenPresenterR.this.addItemWithChoicesToCart(previousOrderItem, menuItem, cart);
                }
            }
        });
    }

    private String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                ChoiceItem next = it2.next();
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(next.f13840name);
            }
        }
        return sb2.toString();
    }

    private String getNamesWithSeparator(LinkedHashSet<String> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TalabatUtils.isNullOrEmpty(next)) {
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next);
            }
        }
        return getReplacedString(sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, " ### ");
    }

    /* access modifiers changed from: private */
    public void logError(Throwable th2) {
        String str;
        if (TalabatUtils.isNullOrEmpty(th2.getMessage())) {
            str = "Shop Status API error in menu screen";
        } else {
            str = "Shop Status API error in menu screen -> " + th2.getMessage();
        }
        ObservabilityManager.trackUnExpectedScenario(str, new HashMap());
    }

    private void prepareCartToAddItems(Context context, Cart cart, Restaurant restaurant) {
        cart.setRestaurant(restaurant, context);
        GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().supressCouponsAndPromotionForCart();
        }
    }

    private Observable<ShopStatusResponse> requestShopStatus() {
        boolean z11;
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null || !restaurant.isPickup().booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        IRestaurantMenuInteractor iRestaurantMenuInteractor = this.restaurantMenuInteractor;
        return iRestaurantMenuInteractor.getShopStatus(getBranchId() + "", GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), z11);
    }

    private Disposable requestShopStatusDisposable() {
        Single<R> doFinally = Single.fromObservable(requestShopStatus()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new c(this)).map(new g()).onErrorReturnItem(Boolean.FALSE).doFinally(new d(this));
        MutableLiveData<Boolean> mutableLiveData = this.showBusyPopup;
        Objects.requireNonNull(mutableLiveData);
        return doFinally.subscribe((Consumer<? super R>) new i(mutableLiveData));
    }

    /* access modifiers changed from: private */
    public void setPreviousOrderList(ArrayList<PreviousOrder> arrayList) {
        if (arrayList.isEmpty()) {
            this.f26840b.hidePreviousOrderList();
        } else {
            this.previousOrderList.postValue(arrayList);
        }
    }

    private boolean shouldCallPreviousOrderList() {
        boolean z11;
        PreviousOrderResponse previousOrderResponse2 = this.previousOrderResponse;
        if (previousOrderResponse2 == null || previousOrderResponse2.branchId != getBranchId()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !Customer.getInstance().isLoggedIn() || !TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_PREVIOUS_ORDER_SWIMLANE, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            return false;
        }
        return true;
    }

    private void startProgress() {
        RestaurantMenuScreenView restaurantMenuScreenView = this.f26840b;
        if (restaurantMenuScreenView != null) {
            restaurantMenuScreenView.showNonCancelableProgress();
        }
    }

    /* access modifiers changed from: private */
    public void stopProgress() {
        RestaurantMenuScreenView restaurantMenuScreenView = this.f26840b;
        if (restaurantMenuScreenView != null) {
            restaurantMenuScreenView.stopNonCancelableLoading();
        }
    }

    /* access modifiers changed from: private */
    public void updateMenuWithReceivedChoices(SplitChoiceItemModel splitChoiceItemModel) {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel != null && (menuItemRM = menuItemsResponseModel.menu) != null && (menuSectionArr = menuItemRM.menuSection) != null) {
            for (MenuSection menuSection : menuSectionArr) {
                for (MenuItem menuItem : menuSection.items) {
                    if (menuItem.f13861id == splitChoiceItemModel.f480id) {
                        menuItem.choiceSections = splitChoiceItemModel.choiceSections;
                        menuItem.choicesLoaded = true;
                        return;
                    }
                }
            }
        }
    }

    public void addItem(Restaurant restaurant, CartMenuItem cartMenuItem, String str) {
        this.eventOrigin = str;
        if (cartMenuItem.hasChoices()) {
            this.f26840b.onNavigateToItemDetails(cartMenuItem);
            return;
        }
        Cart instance = Cart.getInstance();
        if (!instance.hasItems()) {
            instance.setRestaurant(restaurant, this.f26840b.getContext());
            GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().supressCouponsAndPromotionForCart();
            }
            addItemToCart(instance, cartMenuItem, str);
        } else if (instance.isRestaurantCart(this.mRestaurant)) {
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().supressCouponsAndPromotionForCart();
            }
            addItemToCart(instance, cartMenuItem, str);
        } else {
            this.f26840b.showRestaurantChangePopup(this.mRestaurant, cartMenuItem);
        }
    }

    public void addPreviousOrderItemsToCart(Context context, Restaurant restaurant, PreviousOrder previousOrder) {
        if (this.mRestaurant != null) {
            Cart instance = Cart.getInstance();
            if (!instance.hasItems()) {
                prepareCartToAddItems(context, instance, this.mRestaurant);
                continueAddingItems(instance, this.mRestaurant, previousOrder);
            } else if (instance.isRestaurantCart(this.mRestaurant)) {
                GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
                if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
                    GEMEngine.getInstance().supressCouponsAndPromotionForCart();
                }
                continueAddingItems(instance, this.mRestaurant, previousOrder);
            } else {
                this.f26840b.showRestaurantChangePopup(this.mRestaurant, previousOrder);
            }
            this.f26840b.stopNonCancelableLoading();
        }
    }

    public boolean canCallApi() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant != null) {
            return restaurant.hasCusine();
        }
        return false;
    }

    public void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        instance.setRestaurant(restaurant, context);
        GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().supressCouponsAndPromotionForCart();
        }
        addItemToCart(instance, cartMenuItem, this.eventOrigin);
    }

    public void changeRestaurantAndAddPreviousOrder(Context context, Restaurant restaurant, PreviousOrder previousOrder) {
        Cart instance = Cart.getInstance();
        prepareCartToAddItems(context, instance, restaurant);
        continueAddingItems(instance, restaurant, previousOrder);
    }

    public void clearErrorData() {
        LinkedHashSet<String> linkedHashSet = this.f26842d;
        if (linkedHashSet != null) {
            linkedHashSet.clear();
        } else {
            this.f26842d = new LinkedHashSet<>();
        }
        LinkedHashSet<String> linkedHashSet2 = this.f26841c;
        if (linkedHashSet2 != null) {
            linkedHashSet2.clear();
        } else {
            this.f26841c = new LinkedHashSet<>();
        }
        this.errorData.postValue(null);
    }

    public void clearShowBusyPopup() {
        this.showBusyPopup.postValue(null);
    }

    public Map<String, String> getAttributes() {
        String str;
        HashMap hashMap = new HashMap();
        ObservabilityManagerIntegrator observabilityManagerIntegrator = ObservabilityManagerIntegrator.INSTANCE;
        String str2 = "";
        if (TalabatUtils.isNullOrEmpty(observabilityManagerIntegrator.getPerseusSessionId().invoke())) {
            str = str2;
        } else {
            str = observabilityManagerIntegrator.getPerseusSessionId().invoke();
        }
        hashMap.put("perseusSessionId", str);
        if (!TalabatUtils.isNullOrEmpty(observabilityManagerIntegrator.getPerseusClientId().invoke())) {
            str2 = observabilityManagerIntegrator.getPerseusClientId().invoke();
        }
        hashMap.put("perseusClientId", str2);
        return hashMap;
    }

    public boolean getBinCampaignStatus() {
        return this.f26840b.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("BinCampaignUserGuide", false);
    }

    public void getBinTokens() {
        if (!Integration.isGemActive() && this.paymentConfigurationRepository.config().isBinCampAvailable() && this.customerRepository.isLoggedIn() && this.customerRepository.hasSavedCards() && !getBinCampaignStatus()) {
            this.restaurantMenuInteractor.getCustomerTokensForBin();
        }
    }

    public int getBranchId() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant != null) {
            return restaurant.getBranchId();
        }
        return 0;
    }

    public void getChoiceSection(int i11) {
        this.restaurantMenuInteractor.getChoiceSection(i11);
    }

    public int getCountOfItemsWithImages(MenuItemsResponseModel menuItemsResponseModel) {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || (menuSectionArr = menuItemRM.menuSection) == null) {
            return 0;
        }
        int i11 = 0;
        for (MenuSection menuSection : menuSectionArr) {
            for (MenuItem menuItem : menuSection.items) {
                i11 += menuItem.hasThumbnail ? 1 : 0;
            }
        }
        return i11;
    }

    public int getCuisine() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant == null || !restaurant.hasCusine()) {
            return 0;
        }
        return this.mRestaurant.cuisines[0].f13848id;
    }

    public int getDeliveryTImeInteger() {
        return this.mRestaurant.getDeliveryTimeInteger();
    }

    public MutableLiveData<Pair<String, String>> getErrorData() {
        return this.errorData;
    }

    public void getGroceryItemsForSection(int i11) {
        this.restaurantMenuInteractor.getGroceryItemsForSection(i11, getBranchId());
    }

    public String getHeroImage() {
        MenuItemRM menuItemRM;
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || menuItemRM.menuSection == null) {
            return "";
        }
        return menuItemsResponseModel.getHeroLogo();
    }

    public MenuItemsResponseModel getMenuItemsResponseModel() {
        return this.f26839a;
    }

    public MenuSection getMenuSectionForItem(int i11) {
        MenuSection menuSection = new MenuSection();
        Iterator<MenuSection> it = getRestaurantMenuSections().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MenuSection next = it.next();
            if (next.f13863id == i11) {
                menuSection = next;
                break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(menuSection.f13864name);
        sb2.append(" ");
        sb2.append(i11);
        return menuSection;
    }

    public MenuSection getMenuSectionForPosition(int i11) {
        ArrayList<MenuSection> restaurantMenuSections = getRestaurantMenuSections();
        if (restaurantMenuSections.size() > 0) {
            return restaurantMenuSections.get(i11);
        }
        return new MenuSection();
    }

    public void getParallelBinData() {
        if (!Integration.isGemActive() && this.paymentConfigurationRepository.config().isBinCampAvailable()) {
            GlobalDataModel.PARALLELBIN.reset();
            this.restaurantMenuInteractor.getAllBinOffers();
        }
    }

    public boolean getParallelBinNotificationShown() {
        return this.f26840b.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("ParallelBinCampaignStatus", false);
    }

    public int getPositionForMenuSection(MenuSection menuSection) {
        ArrayList<MenuSection> restaurantMenuSections = getRestaurantMenuSections();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= restaurantMenuSections.size()) {
                break;
            } else if (restaurantMenuSections.get(i12).f13863id == menuSection.f13863id) {
                i11 = i12;
                break;
            } else {
                i12++;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(menuSection.f13864name);
        sb2.append(" ");
        sb2.append(i11);
        return i11;
    }

    public void getPreviousOrderList(int i11) {
        if (shouldCallPreviousOrderList()) {
            Single.fromObservable(this.restaurantMenuInteractor.getPreviousOrderList(i11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<PreviousOrderResponse>() {
                public void onError(Throwable th2) {
                    RestaurantMeuScreenPresenterR.this.f26840b.hidePreviousOrderList();
                }

                public void onSubscribe(Disposable disposable) {
                    RestaurantMeuScreenPresenterR.this.disposable.add(disposable);
                }

                public void onSuccess(PreviousOrderResponse previousOrderResponse) {
                    if (previousOrderResponse == null || !previousOrderResponse.hasPreviousOrders()) {
                        RestaurantMeuScreenPresenterR.this.f26840b.hidePreviousOrderList();
                        return;
                    }
                    previousOrderResponse.branchId = RestaurantMeuScreenPresenterR.this.getBranchId();
                    RestaurantMeuScreenPresenterR.this.previousOrderResponse = previousOrderResponse;
                    RestaurantMeuScreenPresenterR restaurantMeuScreenPresenterR = RestaurantMeuScreenPresenterR.this;
                    restaurantMeuScreenPresenterR.setPreviousOrderList(restaurantMeuScreenPresenterR.getPreviousOrders());
                }
            });
        }
    }

    public ArrayList<PreviousOrder> getPreviousOrders() {
        ArrayList<PreviousOrder> arrayList = new ArrayList<>();
        PreviousOrderResponse previousOrderResponse2 = this.previousOrderResponse;
        if (previousOrderResponse2 != null && previousOrderResponse2.hasPreviousOrders()) {
            for (PreviousOrder next : this.previousOrderResponse.orders) {
                if (next.hasItems()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public String getReplacedString(StringBuilder sb2, String str, String str2) {
        if (sb2 == null || sb2.length() <= 0) {
            return "";
        }
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || !sb2.toString().contains(str)) {
            return sb2.toString();
        }
        int lastIndexOf = sb2.lastIndexOf(str);
        sb2.replace(lastIndexOf, str.length() + lastIndexOf, str2);
        return sb2.toString().trim();
    }

    public String getRestaurantCuisines() {
        return this.mRestaurant.getCuisineString() != null ? this.mRestaurant.getCuisineString() : "";
    }

    public String getRestaurantDeliveryFee() {
        return this.mRestaurant.getDisplayDeliveryCharges();
    }

    public String getRestaurantDeliveryTime() {
        return this.mRestaurant.getDeliveryTime();
    }

    public MenuItem getRestaurantMenuItem(int i11) {
        MenuItem menuItem;
        MenuItem menuItem2 = new MenuItem();
        Iterator<MenuSection> it = getRestaurantMenuSections().iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            int i12 = 0;
            if (Integration.isGemActive()) {
                MenuItem[] menuItemArr = next.items;
                if (menuItemArr != null && menuItemArr.length >= 1) {
                    int length = menuItemArr.length;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        menuItem = menuItemArr[i12];
                        if (!menuItem.isPromotional && !menuItem.excludedFromGem && menuItem.f13861id == i11) {
                            break;
                        }
                        i12++;
                    }
                }
            } else {
                MenuItem[] menuItemArr2 = next.items;
                if (menuItemArr2 != null && menuItemArr2.length >= 1) {
                    int length2 = menuItemArr2.length;
                    while (true) {
                        if (i12 >= length2) {
                            break;
                        }
                        menuItem = menuItemArr2[i12];
                        if (menuItem.f13861id == i11) {
                            break;
                        }
                        i12++;
                    }
                }
            }
            menuItem2 = menuItem;
        }
        return menuItem2;
    }

    public MenuItem getRestaurantMenuItemForPreviousOrder(int i11, String str) {
        MenuItem menuItem;
        MenuItem menuItem2;
        MenuItem menuItem3 = new MenuItem();
        Iterator<MenuSection> it = getRestaurantMenuSections().iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            int i12 = 0;
            if (Integration.isGemActive()) {
                MenuItem[] menuItemArr = next.items;
                if (menuItemArr != null && menuItemArr.length >= 1) {
                    int length = menuItemArr.length;
                    int i13 = 0;
                    while (i13 < length) {
                        menuItem2 = menuItemArr[i13];
                        if (menuItem2.isPromotional || menuItem2.excludedFromGem || menuItem2.f13861id != i11) {
                            i13++;
                        }
                    }
                    if (menuItem3.f13861id == 0) {
                        MenuItem[] menuItemArr2 = next.items;
                        int length2 = menuItemArr2.length;
                        while (i12 < length2) {
                            menuItem = menuItemArr2[i12];
                            if (!menuItem.isPromotional && !menuItem.excludedFromGem && menuItem.f13862name.equals(str) && menuItem.f13861id == i11) {
                                return menuItem;
                            }
                            i12++;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } else {
                MenuItem[] menuItemArr3 = next.items;
                if (menuItemArr3 != null && menuItemArr3.length >= 1) {
                    int length3 = menuItemArr3.length;
                    int i14 = 0;
                    while (i14 < length3) {
                        menuItem2 = menuItemArr3[i14];
                        if (menuItem2.f13861id != i11) {
                            i14++;
                        }
                    }
                    if (menuItem3.f13861id == 0) {
                        MenuItem[] menuItemArr4 = next.items;
                        int length4 = menuItemArr4.length;
                        while (i12 < length4) {
                            menuItem = menuItemArr4[i12];
                            if (menuItem.f13862name.equals(str) && menuItem.f13861id == i11) {
                                return menuItem;
                            }
                            i12++;
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
            return menuItem2;
        }
        return menuItem3;
    }

    public ArrayList<MenuItem> getRestaurantMenuItems(ArrayList<MenuSection> arrayList) {
        if (arrayList == null) {
            arrayList = getRestaurantMenuSections();
        }
        ArrayList<MenuItem> arrayList2 = new ArrayList<>();
        Iterator<MenuSection> it = arrayList.iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            if (Integration.isGemActive()) {
                MenuItem[] menuItemArr = next.items;
                if (menuItemArr != null && menuItemArr.length >= 1) {
                    for (MenuItem menuItem : menuItemArr) {
                        if (!menuItem.isPromotional && !menuItem.excludedFromGem) {
                            arrayList2.add(menuItem);
                        }
                    }
                }
            } else {
                MenuItem[] menuItemArr2 = next.items;
                if (menuItemArr2 != null && menuItemArr2.length >= 1) {
                    arrayList2.addAll(Arrays.asList(menuItemArr2));
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<MenuSection> getRestaurantMenuSections() {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        ArrayList<MenuSection> arrayList = new ArrayList<>();
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || (menuSectionArr = menuItemRM.menuSection) == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(menuSectionArr));
        boolean z11 = false;
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            if (Integration.isGemActive()) {
                if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1) {
                    for (int i12 = 0; i12 < ((MenuSection) arrayList2.get(i11)).items.length; i12++) {
                        if (!((MenuSection) arrayList2.get(i11)).items[i12].isPromotional && !((MenuSection) arrayList2.get(i11)).items[i12].excludedFromGem) {
                            z11 = true;
                        }
                    }
                    if (z11) {
                        arrayList.add((MenuSection) arrayList2.get(i11));
                        z11 = false;
                    }
                }
            } else if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1) {
                arrayList.add((MenuSection) arrayList2.get(i11));
            }
        }
        return arrayList;
    }

    public ArrayList<Pair<String, Integer>> getRestaurantMenuSectionsAndItemCount() {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || (menuSectionArr = menuItemRM.menuSection) == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(menuSectionArr));
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            String str = ((MenuSection) arrayList2.get(i11)).f13864name;
            int length = ((MenuSection) arrayList2.get(i11)).items.length;
            if (Integration.isGemActive()) {
                if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1) {
                    int i12 = 0;
                    int i13 = 0;
                    for (int i14 = 0; i14 < ((MenuSection) arrayList2.get(i11)).items.length; i14++) {
                        if (((MenuSection) arrayList2.get(i11)).items[i14].isPromotional) {
                            i12++;
                        } else if (((MenuSection) arrayList2.get(i11)).items[i14].excludedFromGem) {
                            i13++;
                        }
                    }
                    int i15 = length - (i12 + i13);
                    if (i15 > 0) {
                        arrayList.add(new Pair(str, Integer.valueOf(i15)));
                    }
                }
            } else if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1 && length > 0) {
                arrayList.add(new Pair(str, Integer.valueOf(length)));
            }
        }
        return arrayList;
    }

    public String getRestaurantMinOrder() {
        return this.mRestaurant.getDisplayMinimumAmount();
    }

    public ArrayList<OffersItem> getRestaurantOffers() {
        ArrayList<OffersItem> arrayList = new ArrayList<>();
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (!(menuItemsResponseModel == null || menuItemsResponseModel.promotions == null || Integration.isGemActive())) {
            PromotionDisplay[] promotionDisplayArr = this.f26839a.promotions;
            if (promotionDisplayArr.length > 0) {
                for (PromotionDisplay createFromPromotionDisplay : promotionDisplayArr) {
                    arrayList.add(OffersItem.createFromPromotionDisplay(createFromPromotionDisplay));
                }
            }
        }
        return arrayList;
    }

    public String getRestaurantOpeningTime() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant == null || TalabatUtils.isNullOrEmpty(restaurant.getDeliverySchedule()) || !this.mRestaurant.getDeliverySchedule().contains(CertificateUtil.DELIMITER)) {
            return "";
        }
        try {
            String[] split = this.mRestaurant.getDeliverySchedule().split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            String trim = split[0].trim();
            if (split.length > 2 && split[1].contains("|")) {
                String[] split2 = split[1].split("\\|");
                if (split2.length > 0) {
                    return trim + " and " + split2[1].trim();
                }
            }
            return trim;
        } catch (IndexOutOfBoundsException unused) {
            return "";
        }
    }

    public float getRestaurantRating() {
        return this.mRestaurant.getRating();
    }

    public int getRestaurantStatus() {
        return this.mRestaurant.statusType;
    }

    public String getRestaurantTotalRating() {
        if (this.mRestaurant.getRating() <= 0.0f) {
            return "(0)";
        }
        return "(" + this.mRestaurant.getTotalRating() + ")";
    }

    public String getRestaurantWarning() {
        return this.mRestaurant.restSummary;
    }

    public String getRestaurantWarningURL() {
        return this.mRestaurant.disclaimerLink;
    }

    public String getRestuarantName() {
        return this.mRestaurant.getName() != null ? this.mRestaurant.getName() : "";
    }

    public void getShopStatus() {
        startProgress();
        this.disposable.add(requestShopStatusDisposable());
    }

    public MutableLiveData<Boolean> getShowBusyPopup() {
        return this.showBusyPopup;
    }

    public Restaurant getmRestaurant() {
        return this.mRestaurant;
    }

    public void handleMenuWithoutChoiceClick() {
        this.f26840b.navigateToMenuWithoutChoiceNativeScreen();
    }

    public void handleVendorInfoClick() {
        this.f26840b.navigateToVendorInfoNativeScreen();
    }

    public void handleVendorReviewsClick() {
        this.f26840b.navigateToVendorReviewsNativeScreen();
    }

    public void handleWithChoiceClick() {
        this.f26840b.navigateToMenuWithChoiceNativeScreen();
    }

    public boolean hasIconForAllItems() {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || (menuSectionArr = menuItemRM.menuSection) == null) {
            return false;
        }
        for (MenuSection menuSection : menuSectionArr) {
            for (MenuItem menuItem : menuSection.items) {
                if (!menuItem.hasThumbnail) {
                    return false;
                }
            }
        }
        return true;
    }

    public int isItemAddedToCart(MenuItem menuItem) {
        int i11 = 0;
        if (!Cart.getInstance().hasItems()) {
            return 0;
        }
        Iterator<CartMenuItem> it = Cart.getInstance().getCartItems().iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if (menuItem.f13862name.equals(next.f13862name) && menuItem.f13861id == next.f13861id) {
                i11 += next.getQuantity();
            }
        }
        return i11;
    }

    public boolean isRestaurantAcceptCash() {
        return this.mRestaurant.acceptsCash;
    }

    public boolean isRestaurantAcceptCreditCard() {
        return this.mRestaurant.isAcceptsCredit();
    }

    public boolean isRestaurantAcceptDebitCard() {
        return this.mRestaurant.isAcceptsDebit();
    }

    public boolean isRestaurantBusy() {
        return getRestaurantStatus() == 2;
    }

    public boolean isRestaurantClosed() {
        return getRestaurantStatus() == 1;
    }

    public boolean isRestaurantHasWarning() {
        return !TalabatUtils.isNullOrEmpty(this.mRestaurant.restSummary);
    }

    public boolean isRestaurantOpen() {
        return getRestaurantStatus() == 0;
    }

    public boolean isRestaurantOpenForPreorder() {
        return getRestaurantStatus() == 5;
    }

    public boolean isRestaurantTGO() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant != null) {
            return restaurant.isTalabatGo;
        }
        return false;
    }

    public boolean isRestaurantTPro() {
        Restaurant restaurant = this.mRestaurant;
        if (restaurant != null) {
            return restaurant.isProRestaurant;
        }
        return false;
    }

    public boolean isSelectedCountryBahrain() {
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return true;
        }
        return false;
    }

    public boolean isSelectedCountryKSA() {
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return true;
        }
        return false;
    }

    public boolean isSelectedCountryKuwait() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return true;
        }
        return false;
    }

    public void onBinResponseReceived(BinTokenRM binTokenRM, String str) {
        RestaurantMenuScreenView restaurantMenuScreenView = this.f26840b;
        if (restaurantMenuScreenView != null) {
            restaurantMenuScreenView.onBinResponseReceived(binTokenRM, str);
        }
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        MenuItemsResponseModel menuItemsResponseModel = this.f26839a;
        if (menuItemsResponseModel != null && (menuItemRM = menuItemsResponseModel.menu) != null && (menuSectionArr = menuItemRM.menuSection) != null) {
            int length = menuSectionArr.length;
            int i11 = 0;
            loop0:
            while (true) {
                if (i11 >= length) {
                    break;
                }
                for (MenuItem menuItem : menuSectionArr[i11].items) {
                    if (menuItem.f13861id == splitChoiceItemModel.f480id) {
                        menuItem.choiceSections = splitChoiceItemModel.choiceSections;
                        menuItem.choicesLoaded = true;
                        break loop0;
                    }
                }
                i11++;
            }
            this.f26840b.onChoiceReceived(splitChoiceItemModel);
        }
    }

    public void onDataError() {
        this.f26840b.onDataError();
    }

    public void onDestroy() {
        this.f26840b = null;
        IRestaurantMenuInteractor iRestaurantMenuInteractor = this.restaurantMenuInteractor;
        if (iRestaurantMenuInteractor != null) {
            iRestaurantMenuInteractor.unregister();
        }
        this.restaurantMenuInteractor = null;
        CompositeDisposable compositeDisposable = this.disposable;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            this.disposable.dispose();
        }
    }

    public void onNetworkError() {
        this.f26840b.onNetworkError();
    }

    public void onNoChoiceAvailable() {
        if (GlobalDataModel.MENU.AddToCartClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
        if (GlobalDataModel.MENU.ChoiceClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
        this.f26840b.onNoChoiceAvailable();
    }

    public void onParallelBinAvailable() {
        RestaurantMenuScreenView restaurantMenuScreenView = this.f26840b;
        if (restaurantMenuScreenView != null) {
            restaurantMenuScreenView.onParallelBinAvailable();
        }
    }

    public void onServerError(VolleyError volleyError) {
        this.f26840b.onServerError(volleyError);
    }

    public boolean resetRequired() {
        boolean z11;
        String screenName = this.f26840b.getScreenName();
        boolean z12 = false;
        if (MenuResponseMapper.INSTANCE.getMenuModel().getRestaurant().shopType != 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (shouldUseNewMenuMapper(screenName, z11, this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_MENU_MAPPER, false))) {
            return false;
        }
        if (!(getmRestaurant() == null || this.mRestaurant == GlobalDataModel.SELECTED.getRestaurant())) {
            GlobalDataModel.SELECTED.updateRestaurant(this.mRestaurant);
            z12 = true;
        }
        if (getMenuItemsResponseModel() == null || getMenuItemsResponseModel() == GlobalDataModel.JSON.menuItemsResponseModel) {
            return z12;
        }
        GlobalDataModel.JSON.menuItemsResponseModel = getMenuItemsResponseModel();
        return true;
    }

    public boolean shouldUseNewMenuMapper(String str, boolean z11, boolean z12) {
        if (TalabatUtils.isNullOrEmpty(str) || !str.equals(ScreenNames.RESTAURANTMENU) || !z11 || !z12) {
            return false;
        }
        return true;
    }

    public MutableLiveData<ArrayList<PreviousOrder>> getPreviousOrderList() {
        return this.previousOrderList;
    }
}
