package library.talabat.mvp.grocerydetails;

import JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.android.volley.VolleyError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import com.talabat.lib.Integration;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import g10.c;
import g10.d;
import g10.e;
import g10.f;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010Q\u001a\u00020L2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\"\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020V2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010W\u001a\u00020LH\u0016J\b\u0010X\u001a\u00020LH\u0016J\b\u0010Y\u001a\u00020LH\u0016J\b\u0010Z\u001a\u00020LH\u0016J\u0010\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020\tH\u0016J\u0018\u0010]\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0016J\u0017\u0010^\u001a\f\u0012\u0006\b\u0001\u0012\u00020_\u0018\u00010@H\u0016¢\u0006\u0002\u0010`J\u0010\u0010a\u001a\u00020L2\u0006\u0010b\u001a\u00020\u001cH\u0016J\u0016\u0010c\u001a\u00020\u000e2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u001fH\u0002J\u0015\u0010f\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0016¢\u0006\u0002\u0010gJ\u0010\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u001cH\u0002J\u0010\u0010j\u001a\u00020,2\u0006\u0010&\u001a\u00020\u001cH\u0016J\b\u0010k\u001a\u00020\u0018H\u0016J\n\u0010l\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002J\u000e\u0010p\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fH\u0016J\n\u0010q\u001a\u0004\u0018\u00010\u000eH\u0002J\u0017\u0010r\u001a\f\u0012\u0006\b\u0001\u0012\u00020A\u0018\u00010@H\u0016¢\u0006\u0002\u0010gJ\b\u0010s\u001a\u00020\tH\u0016J\u0010\u0010t\u001a\u00020L2\u0006\u0010i\u001a\u00020\u001cH\u0016J\u0012\u0010u\u001a\u00020L2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\b\u0010x\u001a\u00020LH\u0016J_\u0010y\u001a\u00020L2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020 0@2\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020 0@0|2\u0006\u0010}\u001a\u00020\u00182\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@H\u0016¢\u0006\u0002\u0010J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0015\u0010\u0001\u001a\u00020L2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u001b\u0010\u0001\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010\u000e2\u0006\u00106\u001a\u00020\u000eH\u0016J\u0012\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010nH\u0002J\t\u0010\u0001\u001a\u00020LH\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010:\u001a\u00020\u001cH\u0016J\t\u0010\u0001\u001a\u00020LH\u0002J\u0018\u0010\u0001\u001a\u00020L2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fH\u0016J,\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u001b\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\u001cH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010\u000e0\u000e04X\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000R(\u0010:\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010\u001c0\u001c04X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@X\u000e¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u0015R\u001a\u0010G\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0013\"\u0004\bI\u0010\u0015R\u000e\u0010J\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/GroceryDetailsPresenter;", "Llibrary/talabat/mvp/grocerydetails/IGroceryDetailsPresenter;", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsListener;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "_groceryDetailsView", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsView;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabat/mvp/grocerydetails/GroceryDetailsView;)V", "allItemsTagSelected", "", "disableAutomaticSearch", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "eventOrigin", "", "executor", "Ljava/util/concurrent/Executor;", "filterBrands", "getFilterBrands", "()Ljava/lang/String;", "setFilterBrands", "(Ljava/lang/String;)V", "groceryDetailsView", "groceryItemsForSectionPagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "iGroceryDetailsInteractor", "Llibrary/talabat/mvp/grocerydetails/IGroceryDetailsInteractor;", "incrementedPageNumber", "", "loadMorePageNumber", "menuItems", "Ljava/util/ArrayList;", "Ldatamodels/MenuItem;", "Lkotlin/collections/ArrayList;", "getMenuItems", "()Ljava/util/ArrayList;", "setMenuItems", "(Ljava/util/ArrayList;)V", "menuSectionId", "getMenuSectionId", "()I", "setMenuSectionId", "(I)V", "menuSectionRequired", "Ldatamodels/MenuSection;", "getMenuSectionRequired", "()Ldatamodels/MenuSection;", "setMenuSectionRequired", "(Ldatamodels/MenuSection;)V", "previousQuery", "previousTagString", "publishSubject", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "query", "requestedForSearch", "searchEditText", "Landroid/widget/EditText;", "searchPageNumber", "getSearchPageNumber$com_talabat_talabatlib_talabatlib", "()Lio/reactivex/subjects/PublishSubject;", "setSearchPageNumber$com_talabat_talabatlib_talabatlib", "(Lio/reactivex/subjects/PublishSubject;)V", "searchResultTags", "", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "[LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "sharedPreferenceKey", "sortBy", "getSortBy", "setSortBy", "sortOrder", "getSortOrder", "setSortOrder", "tagIdsString", "addItem", "", "restaurant", "Ldatamodels/Restaurant;", "cartMenuItem", "Ldatamodels/CartMenuItem;", "addItemToCart", "cart", "Lbuisnessmodels/Cart;", "changeRestaurantAndAddItem", "context", "Landroid/content/Context;", "clearEditText", "clearLocalCache", "clearSearchTags", "clearSelectedBrands", "disableAutoSearch", "disable", "getAllItemsToDisplay", "getBrands", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "()[LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "getChoiceSection", "id", "getChoicesString", "lstItemsChoice", "Ldatamodels/ChoiceSection;", "getGroceryTags", "()[LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "getInitialCondition", "pageNumber", "getMenuSection", "getPagingInfo", "getPreviousTagString", "getSearchObserver", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "getSelectedBrandIds", "getTagNamesString", "getTags", "isAllItemsLoaded", "loadMoreItems", "onChoiceReceived", "splitChoiceItemModel", "LJsonModels/Response/SplitRestaurantApiResponse/SplitChoiceItemModel;", "onDataError", "onDataLoaded", "items", "menuItemsRealListSorted", "", "pagingInfo", "groceryTags", "(II[Ldatamodels/MenuItem;Ljava/util/Map;LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;[LJsonModels/Response/GroceryResponse/GroceryTagsModel;)V", "onDestroy", "onItemsDataError", "onNetworkError", "onNoChoiceAvailable", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "requestForSearch", "value", "resetSortAndFilter", "searchApiCalled", "searchMenuitemTextWatcher", "Lcom/jakewharton/rxbinding3/widget/TextViewTextChangeEvent;", "setAllItemsLoaded", "setNewPageNumber", "setPagingInfo", "setSelectedBrandIdsList", "selectedBrands", "setSortAndFilterCriteria", "filterCriteriaString", "sortByCriteriaSting", "sortOrderCriteriaString", "setTotalPages", "setUpSearchThreads", "search_field", "newPageNumber", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsPresenter implements IGroceryDetailsPresenter, GroceryDetailsListener {
    /* access modifiers changed from: private */
    public boolean allItemsTagSelected;
    /* access modifiers changed from: private */
    public boolean disableAutomaticSearch;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private String eventOrigin = "";
    @Nullable
    private Executor executor;
    @NotNull
    private String filterBrands;
    /* access modifiers changed from: private */
    @Nullable
    public GroceryDetailsView groceryDetailsView;
    private GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo;
    @Nullable
    private IGroceryDetailsInteractor iGroceryDetailsInteractor;
    /* access modifiers changed from: private */
    public int incrementedPageNumber;
    private int loadMorePageNumber;
    public ArrayList<MenuItem> menuItems;
    private int menuSectionId;
    @NotNull
    private MenuSection menuSectionRequired;
    /* access modifiers changed from: private */
    @Nullable
    public String previousQuery;
    @Nullable
    private String previousTagString;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<String> publishSubject;
    /* access modifiers changed from: private */
    @Nullable
    public String query;
    private boolean requestedForSearch;
    private EditText searchEditText;
    @NotNull
    private PublishSubject<Integer> searchPageNumber;
    /* access modifiers changed from: private */
    @Nullable
    public GroceryTagsModel[] searchResultTags;
    @NotNull
    private String sharedPreferenceKey;
    @NotNull
    private String sortBy;
    @NotNull
    private String sortOrder;
    @NotNull
    private String tagIdsString;

    public GroceryDetailsPresenter(@NotNull AppVersionProvider appVersionProvider, @NotNull GroceryDetailsView groceryDetailsView2) {
        Context context;
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(groceryDetailsView2, "_groceryDetailsView");
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<String>()");
        this.publishSubject = create;
        PublishSubject<Integer> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Int>()");
        this.searchPageNumber = create2;
        this.groceryDetailsView = groceryDetailsView2;
        this.menuSectionId = -1;
        this.menuSectionRequired = new MenuSection();
        this.sortBy = "original";
        this.sortOrder = "";
        this.filterBrands = "";
        this.tagIdsString = "";
        this.query = "";
        this.previousQuery = "";
        this.previousTagString = "";
        this.requestedForSearch = true;
        this.sharedPreferenceKey = "grocery_recent_history_key";
        GroceryDetailsView groceryDetailsView3 = this.groceryDetailsView;
        if (groceryDetailsView3 != null) {
            context = groceryDetailsView3.getContext();
        } else {
            context = null;
        }
        Intrinsics.checkNotNull(context);
        this.iGroceryDetailsInteractor = new GroceryDetailsInteractor(appVersionProvider, this, context);
    }

    private final void addItemToCart(Cart cart, CartMenuItem cartMenuItem) {
        Integer num;
        Context context;
        ArrayList<ChoiceSection> arrayList;
        String str;
        Context context2;
        String str2;
        ArrayList<ChoiceSection> arrayList2;
        String str3 = null;
        if (cart != null) {
            num = Integer.valueOf(cart.getCartItemQuantity(cartMenuItem));
        } else {
            num = null;
        }
        if (num == null) {
            return;
        }
        if (num.intValue() < 100) {
            GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
            if (groceryDetailsView2 != null) {
                context = groceryDetailsView2.getContext();
            } else {
                context = null;
            }
            cart.addItem(cartMenuItem, context);
            if (cartMenuItem != null) {
                arrayList = cartMenuItem.selectedChoices;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (cartMenuItem != null) {
                    arrayList2 = cartMenuItem.selectedChoices;
                } else {
                    arrayList2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(arrayList2, "cartMenuItem?.selectedChoices");
                str = getChoicesString(arrayList2);
            } else {
                str = "";
            }
            String str4 = str;
            GroceryDetailsView groceryDetailsView3 = this.groceryDetailsView;
            if (groceryDetailsView3 != null) {
                context2 = groceryDetailsView3.getContext();
            } else {
                context2 = null;
            }
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            int restaurantId = AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant);
            String restaurantName = AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant);
            String str5 = this.eventOrigin;
            Intrinsics.checkNotNull(cartMenuItem);
            int i11 = cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0];
            int i12 = cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1];
            GroceryDetailsView groceryDetailsView4 = this.groceryDetailsView;
            if (groceryDetailsView4 != null) {
                str2 = groceryDetailsView4.getScreenName();
            } else {
                str2 = null;
            }
            String screenType = ScreenNames.getScreenType(str2);
            GroceryDetailsView groceryDetailsView5 = this.groceryDetailsView;
            if (groceryDetailsView5 != null) {
                str3 = groceryDetailsView5.getScreenName();
            }
            AppTracker.onItemAddedToCart(context2, restaurant, cartMenuItem, restaurantId, restaurantName, str5, str4, i11, i12, screenType, str3);
            GlobalDataModel.ANIMATIONHELPER.addItemClicked = true;
            GroceryDetailsView groceryDetailsView6 = this.groceryDetailsView;
            if (groceryDetailsView6 != null) {
                groceryDetailsView6.onItemAdded(cartMenuItem);
                return;
            }
            return;
        }
        GroceryDetailsView groceryDetailsView7 = this.groceryDetailsView;
        if (groceryDetailsView7 != null) {
            groceryDetailsView7.onMaxCartItemsReached();
        }
    }

    private final String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(next.f13842name);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
        return sb3;
    }

    private final boolean getInitialCondition(int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        this.allItemsTagSelected = Intrinsics.areEqual((Object) this.tagIdsString, (Object) "-1");
        if (this.filterBrands.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !this.sortBy.equals("original")) {
            return false;
        }
        if (this.sortOrder.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (this.tagIdsString.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if ((!z13 && !Intrinsics.areEqual((Object) this.tagIdsString, (Object) "-1")) || i11 != 1) {
            return false;
        }
        EditText editText = this.searchEditText;
        if (editText != null) {
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            if (!TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) editText.getText().toString()).toString())) {
                return false;
            }
        }
        return true;
    }

    private final DisposableObserver<GrocerySearchResponse> getSearchObserver() {
        return new GroceryDetailsPresenter$getSearchObserver$1(this);
    }

    private final String getTagNamesString() {
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            return groceryDetailsView2.getTagNamesString();
        }
        return null;
    }

    private final DisposableObserver<TextViewTextChangeEvent> searchMenuitemTextWatcher() {
        return new GroceryDetailsPresenter$searchMenuitemTextWatcher$1(this);
    }

    private final void setPagingInfo() {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        for (MenuSection menuSection : menuSectionArr) {
            if (menuSection.f13863id == this.menuSectionId) {
                Intrinsics.checkNotNullExpressionValue(menuSection, "menuSection");
                this.menuSectionRequired = menuSection;
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpSearchThreads$lambda-1  reason: not valid java name */
    public static final boolean m7880setUpSearchThreads$lambda1(String str) {
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "s");
        int length = str.length() - 1;
        boolean z12 = false;
        int i12 = 0;
        boolean z13 = false;
        while (i12 <= length) {
            if (!z13) {
                i11 = i12;
            } else {
                i11 = length;
            }
            if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z13) {
                if (!z11) {
                    z13 = true;
                } else {
                    i12++;
                }
            } else if (!z11) {
                break;
            } else {
                length--;
            }
        }
        if (str.subSequence(i12, length + 1).toString().length() == 0) {
            z12 = true;
        }
        return !z12;
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpSearchThreads$lambda-2  reason: not valid java name */
    public static final SingleSource m7881setUpSearchThreads$lambda2(GroceryDetailsPresenter groceryDetailsPresenter, int i11, String str) {
        Intrinsics.checkNotNullParameter(groceryDetailsPresenter, "this$0");
        Intrinsics.checkNotNullParameter(str, "query");
        IGroceryDetailsInteractor iGroceryDetailsInteractor2 = groceryDetailsPresenter.iGroceryDetailsInteractor;
        Integer num = null;
        if (iGroceryDetailsInteractor2 == null) {
            return null;
        }
        int i12 = groceryDetailsPresenter.menuSectionId;
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant != null) {
            num = Integer.valueOf(restaurant.getBranchId());
        }
        return iGroceryDetailsInteractor2.getDataFromApi(str, i12, String.valueOf(num), i11, groceryDetailsPresenter.sortBy, groceryDetailsPresenter.sortOrder, groceryDetailsPresenter.filterBrands, groceryDetailsPresenter.getTagNamesString());
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpSearchThreads$lambda-3  reason: not valid java name */
    public static final boolean m7882setUpSearchThreads$lambda3(GroceryDetailsPresenter groceryDetailsPresenter, TextViewTextChangeEvent textViewTextChangeEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(groceryDetailsPresenter, "this$0");
        Intrinsics.checkNotNullParameter(textViewTextChangeEvent, "textViewTextChangeEvent");
        if (!groceryDetailsPresenter.disableAutomaticSearch) {
            EditText editText = groceryDetailsPresenter.searchEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            if (editText.getText().toString().length() < 3) {
                z11 = true;
                if (!TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) textViewTextChangeEvent.getText().toString()).toString()) && z11) {
                    groceryDetailsPresenter.incrementedPageNumber = 0;
                    MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
                    Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
                    int length = menuSectionArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        MenuSection menuSection = menuSectionArr[i11];
                        if (menuSection.f13863id == groceryDetailsPresenter.menuSectionId) {
                            String str = menuSection.sortCriteria;
                            Intrinsics.checkNotNullExpressionValue(str, "menuSection.sortCriteria");
                            groceryDetailsPresenter.sortBy = str;
                            String str2 = menuSection.sortOrder;
                            Intrinsics.checkNotNullExpressionValue(str2, "menuSection.sortOrder");
                            groceryDetailsPresenter.sortOrder = str2;
                            String str3 = menuSection.filterBrands;
                            Intrinsics.checkNotNullExpressionValue(str3, "menuSection.filterBrands");
                            groceryDetailsPresenter.filterBrands = str3;
                            menuSection.searchBrandIds = new ArrayList<>();
                            break;
                        }
                        i11++;
                    }
                    GroceryDetailsView groceryDetailsView2 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView2 != null) {
                        groceryDetailsView2.stopLoading();
                    }
                    GroceryDetailsView groceryDetailsView3 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView3 != null) {
                        groceryDetailsView3.showClearButton(false);
                    }
                    GroceryDetailsView groceryDetailsView4 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView4 != null) {
                        groceryDetailsView4.showEmptyScreen(false, false);
                    }
                    GroceryDetailsView groceryDetailsView5 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView5 != null) {
                        groceryDetailsView5.updateList(groceryDetailsPresenter.getAllItemsToDisplay(), groceryDetailsPresenter.getPagingInfo(), groceryDetailsPresenter.query);
                    }
                    GroceryDetailsView groceryDetailsView6 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView6 != null) {
                        groceryDetailsView6.setItemsCount(groceryDetailsPresenter.getPagingInfo());
                    }
                    GroceryDetailsView groceryDetailsView7 = groceryDetailsPresenter.groceryDetailsView;
                    if (groceryDetailsView7 != null) {
                        groceryDetailsView7.setIsUpdateRequired(false);
                    }
                    return false;
                }
            }
        }
        z11 = false;
        return !TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) textViewTextChangeEvent.getText().toString()).toString()) ? true : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpSearchThreads$lambda-4  reason: not valid java name */
    public static final SingleSource m7883setUpSearchThreads$lambda4(GroceryDetailsPresenter groceryDetailsPresenter, Integer num) {
        Single<GrocerySearchResponse> single;
        Intrinsics.checkNotNullParameter(groceryDetailsPresenter, "this$0");
        Intrinsics.checkNotNullParameter(num, "newPageNumber");
        IGroceryDetailsInteractor iGroceryDetailsInteractor2 = groceryDetailsPresenter.iGroceryDetailsInteractor;
        if (iGroceryDetailsInteractor2 != null) {
            String str = groceryDetailsPresenter.query;
            Intrinsics.checkNotNull(str);
            single = iGroceryDetailsInteractor2.getDataFromApi(str, groceryDetailsPresenter.menuSectionId, String.valueOf(GlobalDataModel.SELECTED.restaurant.getBranchId()), num.intValue(), groceryDetailsPresenter.sortBy, groceryDetailsPresenter.sortOrder, groceryDetailsPresenter.filterBrands, groceryDetailsPresenter.getTagNamesString());
        } else {
            single = null;
        }
        Intrinsics.checkNotNull(single);
        return single;
    }

    public void addItem(@Nullable Restaurant restaurant, @Nullable CartMenuItem cartMenuItem, @NotNull String str) {
        Context context;
        GEMEngine instance;
        GEMEngine instance2;
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        if (cartMenuItem != null) {
            this.eventOrigin = str;
            if (cartMenuItem.hasChoices()) {
                GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
                if (groceryDetailsView2 != null) {
                    groceryDetailsView2.onNavigateToItemDetails(cartMenuItem);
                    return;
                }
                return;
            }
            Cart instance3 = Cart.getInstance();
            cartMenuItem.setQuantity(1);
            if (!instance3.hasItems()) {
                GroceryDetailsView groceryDetailsView3 = this.groceryDetailsView;
                if (groceryDetailsView3 != null) {
                    context = groceryDetailsView3.getContext();
                } else {
                    context = null;
                }
                instance3.setRestaurant(restaurant, context);
                GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
                if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || (instance = GEMEngine.getInstance()) == null)) {
                    instance.supressCouponsAndPromotionForCart();
                }
                addItemToCart(instance3, cartMenuItem);
            } else if (instance3.isRestaurantCart(restaurant)) {
                if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || (instance2 = GEMEngine.getInstance()) == null)) {
                    instance2.supressCouponsAndPromotionForCart();
                }
                addItemToCart(instance3, cartMenuItem);
            } else {
                GroceryDetailsView groceryDetailsView4 = this.groceryDetailsView;
                if (groceryDetailsView4 != null) {
                    groceryDetailsView4.showRestaurantChangePopup(GlobalDataModel.SELECTED.restaurant, cartMenuItem);
                }
            }
        }
    }

    public void changeRestaurantAndAddItem(@NotNull Context context, @Nullable Restaurant restaurant, @NotNull CartMenuItem cartMenuItem) {
        GEMEngine instance;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
        Cart instance2 = Cart.getInstance();
        instance2.setRestaurant(restaurant, context);
        GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
        if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || (instance = GEMEngine.getInstance()) == null)) {
            instance.supressCouponsAndPromotionForCart();
        }
        addItemToCart(instance2, cartMenuItem);
    }

    public void clearEditText() {
        if (this.searchEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        }
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        editText.setText("");
        this.searchResultTags = null;
        this.previousQuery = "";
        if (this.disableAutomaticSearch) {
            this.requestedForSearch = false;
        }
    }

    public void clearLocalCache() {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        for (MenuSection menuSection : menuSectionArr) {
            if (menuSection.f13863id == this.menuSectionId) {
                menuSection.resetLocalCache();
                return;
            }
        }
    }

    public void clearSearchTags() {
        this.searchResultTags = null;
        this.previousQuery = "";
    }

    public void clearSelectedBrands() {
        boolean z11;
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "searchEditText.text");
        if (StringsKt__StringsKt.trim((CharSequence) text).length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
            Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
            for (MenuSection menuSection : menuSectionArr) {
                if (menuSection.f13863id == this.menuSectionId) {
                    ArrayList<String> arrayList = menuSection.brandIds;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "menuSection.brandIds");
                    if (!arrayList.isEmpty()) {
                        menuSection.brandIds.clear();
                    }
                    ArrayList<String> arrayList2 = menuSection.searchBrandIds;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "menuSection.searchBrandIds");
                    if (!arrayList2.isEmpty()) {
                        menuSection.searchBrandIds.clear();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void disableAutoSearch(boolean z11) {
        this.disableAutomaticSearch = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r0 != false) goto L_0x0066;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<datamodels.MenuItem> getAllItemsToDisplay() {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.setMenuItems(r0)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = com.talabat.helpers.GlobalDataModel.JSON.groceryMenuItemsLoadedForSection
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x010b
            r7.setPagingInfo()
            JsonModels.MenuItemsResponseModel r0 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel
            JsonModels.MenuItemRM r0 = r0.menu
            datamodels.MenuSection[] r0 = r0.menuSection
            java.lang.String r1 = "menuItemsResponseModel.menu.menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0027:
            if (r3 >= r1) goto L_0x010b
            r4 = r0[r3]
            int r5 = r4.f13863id
            int r6 = r7.menuSectionId
            if (r5 != r6) goto L_0x0107
            java.lang.String r0 = "menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r7.menuSectionRequired = r4
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r0 = r4.groceryItemsForSectionPagingInfo
            r1 = 1
            if (r0 == 0) goto L_0x0048
            int r0 = r0.getTotalItems()
            datamodels.MenuItem[] r3 = r4.items
            int r3 = r3.length
            if (r0 != r3) goto L_0x0048
            r0 = r1
            goto L_0x0049
        L_0x0048:
            r0 = r2
        L_0x0049:
            r4.allItemsLoaded = r0
            datamodels.MenuItem[] r0 = r4.items
            r4.defaultItemsList = r0
            java.lang.String r0 = r7.sortBy
            java.lang.String r3 = "original"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0066
            java.lang.String r0 = r7.sortBy
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0063
            r0 = r1
            goto L_0x0064
        L_0x0063:
            r0 = r2
        L_0x0064:
            if (r0 == 0) goto L_0x00c2
        L_0x0066:
            java.lang.String r0 = r7.filterBrands
            int r0 = r0.length()
            if (r0 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r1 = r2
        L_0x0070:
            if (r1 == 0) goto L_0x00c2
            datamodels.MenuItem[] r0 = r4.defaultItemsList
            java.lang.String r1 = "menuSection.defaultItemsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.length
            r3 = r2
        L_0x007b:
            if (r3 >= r1) goto L_0x00a9
            r4 = r0[r3]
            java.util.ArrayList r5 = r7.getMenuItems()
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x00a6
            boolean r5 = com.talabat.lib.Integration.isGemActive()
            if (r5 == 0) goto L_0x009f
            boolean r5 = r4.isPromotional
            if (r5 != 0) goto L_0x00a6
            boolean r5 = r4.excludedFromGem
            if (r5 != 0) goto L_0x00a6
            java.util.ArrayList r5 = r7.getMenuItems()
            r5.add(r4)
            goto L_0x00a6
        L_0x009f:
            java.util.ArrayList r5 = r7.getMenuItems()
            r5.add(r4)
        L_0x00a6:
            int r3 = r3 + 1
            goto L_0x007b
        L_0x00a9:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r7.groceryDetailsView
            if (r0 == 0) goto L_0x00b4
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r1 = r7.getPagingInfo()
            r0.setItemsCount(r1)
        L_0x00b4:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r7.groceryDetailsView
            if (r0 == 0) goto L_0x010b
            JsonModels.Response.GroceryResponse.GroceryTagsModel[] r1 = r7.getGroceryTags()
            boolean r3 = r7.allItemsTagSelected
            r0.setGroceryTags(r1, r2, r3)
            goto L_0x010b
        L_0x00c2:
            datamodels.MenuItem[] r0 = r4.sortedItemsList
            java.lang.String r1 = "menuSection.sortedItemsList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.length
        L_0x00ca:
            if (r2 >= r1) goto L_0x00f8
            r3 = r0[r2]
            java.util.ArrayList r5 = r7.getMenuItems()
            boolean r5 = r5.contains(r3)
            if (r5 != 0) goto L_0x00f5
            boolean r5 = com.talabat.lib.Integration.isGemActive()
            if (r5 == 0) goto L_0x00ee
            boolean r5 = r3.isPromotional
            if (r5 != 0) goto L_0x00f5
            boolean r5 = r3.excludedFromGem
            if (r5 != 0) goto L_0x00f5
            java.util.ArrayList r5 = r7.getMenuItems()
            r5.add(r3)
            goto L_0x00f5
        L_0x00ee:
            java.util.ArrayList r5 = r7.getMenuItems()
            r5.add(r3)
        L_0x00f5:
            int r2 = r2 + 1
            goto L_0x00ca
        L_0x00f8:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r7.groceryDetailsView
            if (r0 == 0) goto L_0x010b
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r1 = r4.sortedItemsItemsPagingInfo
            java.lang.String r2 = "menuSection.sortedItemsItemsPagingInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setItemsCount(r1)
            goto L_0x010b
        L_0x0107:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x010b:
            java.util.ArrayList r0 = r7.getMenuItems()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.grocerydetails.GroceryDetailsPresenter.getAllItemsToDisplay():java.util.ArrayList");
    }

    @Nullable
    public GroceryItemsForSectionBrandModel[] getBrands() {
        return this.menuSectionRequired.brands;
    }

    public void getChoiceSection(int i11) {
        IGroceryDetailsInteractor iGroceryDetailsInteractor2 = this.iGroceryDetailsInteractor;
        Intrinsics.checkNotNull(iGroceryDetailsInteractor2);
        iGroceryDetailsInteractor2.getChoiceSection(i11);
    }

    @NotNull
    public final String getFilterBrands() {
        return this.filterBrands;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != false) goto L_0x0014;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JsonModels.Response.GroceryResponse.GroceryTagsModel[] getGroceryTags() {
        /*
            r6 = this;
            datamodels.MenuSection r0 = r6.menuSectionRequired
            JsonModels.Response.GroceryResponse.GroceryTagsModel[] r0 = r0.groceryTags
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "menuSectionRequired.groceryTags"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r0 = r0.length
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            if (r0 == 0) goto L_0x0035
        L_0x0014:
            JsonModels.MenuItemsResponseModel r0 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel
            JsonModels.MenuItemRM r0 = r0.menu
            datamodels.MenuSection[] r0 = r0.menuSection
            java.lang.String r2 = "menuItemsResponseModel.menu.menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r0.length
        L_0x0020:
            if (r1 >= r2) goto L_0x0035
            r3 = r0[r1]
            int r4 = r3.f13863id
            int r5 = r6.menuSectionId
            if (r4 != r5) goto L_0x0032
            java.lang.String r0 = "menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r6.menuSectionRequired = r3
            goto L_0x0035
        L_0x0032:
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0035:
            datamodels.MenuSection r0 = r6.menuSectionRequired
            JsonModels.Response.GroceryResponse.GroceryTagsModel[] r0 = r0.groceryTags
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.grocerydetails.GroceryDetailsPresenter.getGroceryTags():JsonModels.Response.GroceryResponse.GroceryTagsModel[]");
    }

    @NotNull
    public final ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> arrayList = this.menuItems;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("menuItems");
        return null;
    }

    @NotNull
    public MenuSection getMenuSection(int i11) {
        this.menuSectionId = i11;
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        int length = menuSectionArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                break;
            }
            MenuSection menuSection = menuSectionArr[i12];
            if (menuSection.f13863id == i11) {
                Intrinsics.checkNotNullExpressionValue(menuSection, "menuSection");
                this.menuSectionRequired = menuSection;
                break;
            }
            i12++;
        }
        return this.menuSectionRequired;
    }

    public final int getMenuSectionId() {
        return this.menuSectionId;
    }

    @NotNull
    public final MenuSection getMenuSectionRequired() {
        return this.menuSectionRequired;
    }

    @NotNull
    public GroceryItemsForSectionPagingInfo getPagingInfo() {
        if (this.menuSectionRequired.groceryItemsForSectionPagingInfo == null) {
            MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
            Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
            int length = menuSectionArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                MenuSection menuSection = menuSectionArr[i11];
                if (menuSection.f13863id == this.menuSectionId) {
                    Intrinsics.checkNotNullExpressionValue(menuSection, "menuSection");
                    this.menuSectionRequired = menuSection;
                    menuSection.groceryItemsForSectionPagingInfo = menuSection.groceryItemsForSectionPagingInfo;
                    break;
                }
                i11++;
            }
        }
        GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo2 = this.menuSectionRequired.groceryItemsForSectionPagingInfo;
        Intrinsics.checkNotNullExpressionValue(groceryItemsForSectionPagingInfo2, "menuSectionRequired.groc…ItemsForSectionPagingInfo");
        return groceryItemsForSectionPagingInfo2;
    }

    @Nullable
    public String getPreviousTagString() {
        return this.previousTagString;
    }

    @NotNull
    public final PublishSubject<Integer> getSearchPageNumber$com_talabat_talabatlib_talabatlib() {
        return this.searchPageNumber;
    }

    @NotNull
    public ArrayList<String> getSelectedBrandIds() {
        boolean z11;
        EditText editText = this.searchEditText;
        int i11 = 0;
        if (editText != null) {
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "searchEditText.text");
            if (StringsKt__StringsKt.trim((CharSequence) text).length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
                Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
                int length = menuSectionArr.length;
                while (i11 < length) {
                    MenuSection menuSection = menuSectionArr[i11];
                    if (menuSection.f13863id == this.menuSectionId) {
                        ArrayList<String> arrayList = menuSection.brandIds;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "menuSection.brandIds");
                        return arrayList;
                    }
                    i11++;
                }
                return new ArrayList<>();
            }
        }
        MenuSection[] menuSectionArr2 = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr2, "menuItemsResponseModel.menu.menuSection");
        int length2 = menuSectionArr2.length;
        while (i11 < length2) {
            MenuSection menuSection2 = menuSectionArr2[i11];
            if (menuSection2.f13863id == this.menuSectionId) {
                ArrayList<String> arrayList2 = menuSection2.searchBrandIds;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "menuSection.searchBrandIds");
                return arrayList2;
            }
            i11++;
        }
        return new ArrayList<>();
    }

    @NotNull
    public final String getSortBy() {
        return this.sortBy;
    }

    @NotNull
    public final String getSortOrder() {
        return this.sortOrder;
    }

    @Nullable
    public GroceryTagsModel[] getTags() {
        return this.menuSectionRequired.groceryTags;
    }

    public boolean isAllItemsLoaded() {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        for (MenuSection menuSection : menuSectionArr) {
            if (menuSection.f13863id == this.menuSectionId) {
                return menuSection.allItemsLoaded;
            }
        }
        return false;
    }

    public void loadMoreItems(int i11) {
        this.loadMorePageNumber = i11;
        if (getInitialCondition(i11)) {
            GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
            if (groceryDetailsView2 != null) {
                groceryDetailsView2.stopLoading();
            }
            GroceryDetailsView groceryDetailsView3 = this.groceryDetailsView;
            if (groceryDetailsView3 != null) {
                groceryDetailsView3.showClearButton(false);
            }
            GroceryDetailsView groceryDetailsView4 = this.groceryDetailsView;
            if (groceryDetailsView4 != null) {
                groceryDetailsView4.showEmptyScreen(false, false);
            }
            GroceryDetailsView groceryDetailsView5 = this.groceryDetailsView;
            if (groceryDetailsView5 != null) {
                groceryDetailsView5.updateList(getAllItemsToDisplay(), getPagingInfo(), this.query);
            }
            GroceryDetailsView groceryDetailsView6 = this.groceryDetailsView;
            if (groceryDetailsView6 != null) {
                groceryDetailsView6.setItemsCount(getPagingInfo());
            }
            GroceryDetailsView groceryDetailsView7 = this.groceryDetailsView;
            if (groceryDetailsView7 != null) {
                groceryDetailsView7.setIsUpdateRequired(false);
                return;
            }
            return;
        }
        EditText editText = this.searchEditText;
        if (editText != null) {
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            if (TextUtils.isEmpty(StringsKt__StringsKt.trim((CharSequence) editText.getText().toString()).toString())) {
                IGroceryDetailsInteractor iGroceryDetailsInteractor2 = this.iGroceryDetailsInteractor;
                if (iGroceryDetailsInteractor2 != null) {
                    iGroceryDetailsInteractor2.applyFilterAndSorting(i11, new GrocerySortAndFilterRequest(String.valueOf(i11), "10", this.sortBy, this.sortOrder, this.filterBrands, this.tagIdsString), this.menuSectionId, String.valueOf(GlobalDataModel.SELECTED.restaurant.getBranchId()));
                    return;
                }
                return;
            }
            setNewPageNumber(1);
            return;
        }
        GroceryDetailsView groceryDetailsView8 = this.groceryDetailsView;
        if (groceryDetailsView8 != null) {
            groceryDetailsView8.stopLoading();
        }
    }

    public void onChoiceReceived(@Nullable SplitChoiceItemModel splitChoiceItemModel) {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        int length = menuSectionArr.length;
        int i11 = 0;
        loop0:
        while (true) {
            if (i11 >= length) {
                break;
            }
            MenuSection menuSection = menuSectionArr[i11];
            if (splitChoiceItemModel != null) {
                MenuItem[] menuItemArr = menuSection.items;
                Intrinsics.checkNotNullExpressionValue(menuItemArr, "menuSection.items");
                for (MenuItem menuItem : menuItemArr) {
                    if (menuItem.f13861id == splitChoiceItemModel.f480id) {
                        menuItem.choiceSections = splitChoiceItemModel.choiceSections;
                        menuItem.choicesLoaded = true;
                        menuItem.willHaveChoices = false;
                        break loop0;
                    }
                }
                continue;
            }
            i11++;
        }
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.onChoiceReceived(splitChoiceItemModel);
        }
    }

    public void onDataError() {
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.onDataError();
        }
    }

    public void onDataLoaded(int i11, int i12, @NotNull MenuItem[] menuItemArr, @NotNull Map<Integer, ? extends MenuItem[]> map, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo2, @Nullable GroceryTagsModel[] groceryTagsModelArr) {
        boolean z11;
        GroceryDetailsView groceryDetailsView2;
        boolean z12;
        boolean z13;
        GroceryDetailsView groceryDetailsView3;
        Intrinsics.checkNotNullParameter(menuItemArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(map, "menuItemsRealListSorted");
        Intrinsics.checkNotNullParameter(groceryItemsForSectionPagingInfo2, "pagingInfo");
        ArrayList arrayList = new ArrayList();
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        int length = menuSectionArr.length;
        int i13 = 0;
        while (true) {
            if (i13 >= length) {
                break;
            }
            MenuSection menuSection = menuSectionArr[i13];
            if (menuSection.f13863id == i12) {
                if (this.sortBy.equals("original")) {
                    if (this.filterBrands.length() == 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if (this.tagIdsString.length() == 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13 || this.tagIdsString.equals("-1")) {
                            MenuItem[] menuItemArr2 = menuSection.items;
                            Intrinsics.checkNotNullExpressionValue(menuItemArr2, "menuSection.items");
                            MenuItem[] menuItemArr3 = (MenuItem[]) ArraysKt___ArraysJvmKt.plus((T[]) menuItemArr2, (T[]) menuItemArr);
                            menuSection.items = menuItemArr3;
                            menuSection.defaultItemsList = menuItemArr3;
                            if (groceryTagsModelArr != null) {
                                menuSection.groceryTags = groceryTagsModelArr;
                            }
                            if (this.loadMorePageNumber == 1 && (groceryDetailsView3 = this.groceryDetailsView) != null) {
                                groceryDetailsView3.setGroceryTags(groceryTagsModelArr, false, this.allItemsTagSelected);
                            }
                            if (Integration.isGemActive()) {
                                MenuItem[] menuItemArr4 = menuSection.items;
                                Intrinsics.checkNotNullExpressionValue(menuItemArr4, "menuSection.items");
                                for (MenuItem menuItem : menuItemArr4) {
                                    if (!menuItem.isPromotional && !menuItem.excludedFromGem) {
                                        arrayList.add(menuItem);
                                    }
                                }
                            } else {
                                MenuItem[] menuItemArr5 = menuSection.items;
                                Intrinsics.checkNotNullExpressionValue(menuItemArr5, "menuSection.items");
                                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) menuItemArr5);
                            }
                        }
                    }
                }
                menuSection.sortCriteria = this.sortBy;
                menuSection.sortOrder = this.sortOrder;
                menuSection.filterBrands = this.filterBrands;
                if (menuSection.sortedItemsList == null) {
                    menuSection.sortedItemsList = new MenuItem[0];
                }
                MenuItem[] menuItemArr6 = menuSection.sortedItemsList;
                Intrinsics.checkNotNullExpressionValue(menuItemArr6, "menuSection.sortedItemsList");
                menuSection.sortedItemsList = (MenuItem[]) ArraysKt___ArraysJvmKt.plus((T[]) menuItemArr6, (T[]) menuItemArr);
                menuSection.sortedItemsItemsPagingInfo = groceryItemsForSectionPagingInfo2;
                if (groceryTagsModelArr != null) {
                    menuSection.filteredGroceryTags = groceryTagsModelArr;
                }
                if (this.loadMorePageNumber == 1) {
                    if (this.filterBrands.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11 && (groceryDetailsView2 = this.groceryDetailsView) != null) {
                        groceryDetailsView2.setGroceryTags(groceryTagsModelArr, true, this.allItemsTagSelected);
                    }
                }
                if (Integration.isGemActive()) {
                    MenuItem[] menuItemArr7 = menuSection.sortedItemsList;
                    Intrinsics.checkNotNullExpressionValue(menuItemArr7, "menuSection.sortedItemsList");
                    for (MenuItem menuItem2 : menuItemArr7) {
                        if (!menuItem2.isPromotional && !menuItem2.excludedFromGem) {
                            arrayList.add(menuItem2);
                        }
                    }
                } else {
                    MenuItem[] menuItemArr8 = menuSection.sortedItemsList;
                    Intrinsics.checkNotNullExpressionValue(menuItemArr8, "menuSection.sortedItemsList");
                    boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (T[]) menuItemArr8);
                }
            } else {
                i13++;
            }
        }
        if (i11 == 1) {
            this.menuSectionRequired = new MenuSection();
        }
        GroceryDetailsView groceryDetailsView4 = this.groceryDetailsView;
        if (groceryDetailsView4 != null) {
            groceryDetailsView4.onDataLoaded(arrayList, groceryItemsForSectionPagingInfo2);
        }
        if (arrayList.isEmpty()) {
            GroceryDetailsView groceryDetailsView5 = this.groceryDetailsView;
            if (groceryDetailsView5 != null) {
                groceryDetailsView5.showEmptyScreen(true, false);
            }
            GroceryDetailsView groceryDetailsView6 = this.groceryDetailsView;
            if (groceryDetailsView6 != null) {
                groceryDetailsView6.setIsUpdateRequired(true);
            }
        }
    }

    public void onDestroy() {
        this.disposable.clear();
        this.groceryDetailsView = null;
        IGroceryDetailsInteractor iGroceryDetailsInteractor2 = this.iGroceryDetailsInteractor;
        if (iGroceryDetailsInteractor2 != null) {
            iGroceryDetailsInteractor2.unregister();
        }
        this.iGroceryDetailsInteractor = null;
    }

    public void onItemsDataError() {
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.onDataLoadingError();
        }
    }

    public void onNetworkError() {
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.onNetworkError();
        }
    }

    public void onNoChoiceAvailable() {
        if (GlobalDataModel.MENU.AddToCartClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
        if (GlobalDataModel.MENU.ChoiceClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.onServerError(volleyError);
        }
    }

    public void requestForSearch(boolean z11) {
        this.requestedForSearch = z11;
    }

    public void resetSortAndFilter() {
        boolean z11;
        clearLocalCache();
        this.sortBy = "";
        this.sortOrder = "";
        this.filterBrands = "";
        this.previousQuery = "";
        String str = this.query;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
            if (groceryDetailsView2 != null) {
                groceryDetailsView2.updateList(getAllItemsToDisplay(), getPagingInfo(), this.query);
            }
            GroceryDetailsView groceryDetailsView3 = this.groceryDetailsView;
            if (groceryDetailsView3 != null) {
                groceryDetailsView3.setIsUpdateRequired(false);
            }
            GroceryDetailsView groceryDetailsView4 = this.groceryDetailsView;
            if (groceryDetailsView4 != null) {
                groceryDetailsView4.setItemsCount(getPagingInfo());
                return;
            }
            return;
        }
        setNewPageNumber(1);
    }

    public void searchApiCalled(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "query");
        this.previousTagString = str;
        GroceryDetailsView groceryDetailsView2 = this.groceryDetailsView;
        if (groceryDetailsView2 != null) {
            groceryDetailsView2.sendGAForSearchApiCalled();
        }
    }

    public void setAllItemsLoaded() {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
        for (MenuSection menuSection : menuSectionArr) {
            if (menuSection.f13863id == this.menuSectionId) {
                menuSection.allItemsLoaded = true;
                return;
            }
        }
    }

    public final void setFilterBrands(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filterBrands = str;
    }

    public final void setMenuItems(@NotNull ArrayList<MenuItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.menuItems = arrayList;
    }

    public final void setMenuSectionId(int i11) {
        this.menuSectionId = i11;
    }

    public final void setMenuSectionRequired(@NotNull MenuSection menuSection) {
        Intrinsics.checkNotNullParameter(menuSection, "<set-?>");
        this.menuSectionRequired = menuSection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r0.getText().toString().length() >= 3) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e A[EDGE_INSN: B:55:0x009e->B:33:0x009e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNewPageNumber(int r7) {
        /*
            r6 = this;
            boolean r0 = r6.disableAutomaticSearch
            r1 = 0
            if (r0 != 0) goto L_0x0023
            android.widget.EditText r0 = r6.searchEditText
            if (r0 == 0) goto L_0x0021
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = "searchEditText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x0011:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r2 = 3
            if (r0 < r2) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r0 = 1
        L_0x0024:
            if (r7 <= 0) goto L_0x0061
            if (r0 == 0) goto L_0x0061
            boolean r0 = r6.disableAutomaticSearch
            if (r0 == 0) goto L_0x004d
            boolean r0 = r6.requestedForSearch
            if (r0 == 0) goto L_0x00dd
            r6.requestedForSearch = r1
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r6.groceryDetailsView
            if (r0 == 0) goto L_0x0039
            r0.showLoading()
        L_0x0039:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r6.groceryDetailsView
            if (r0 == 0) goto L_0x0040
            r0.setAllItemsLoaded(r1)
        L_0x0040:
            r6.incrementedPageNumber = r7
            io.reactivex.subjects.PublishSubject<java.lang.Integer> r0 = r6.searchPageNumber
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.onNext(r7)
            goto L_0x00dd
        L_0x004d:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r0 = r6.groceryDetailsView
            if (r0 == 0) goto L_0x0054
            r0.setAllItemsLoaded(r1)
        L_0x0054:
            r6.incrementedPageNumber = r7
            io.reactivex.subjects.PublishSubject<java.lang.Integer> r0 = r6.searchPageNumber
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.onNext(r7)
            goto L_0x00dd
        L_0x0061:
            JsonModels.MenuItemsResponseModel r7 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel
            JsonModels.MenuItemRM r7 = r7.menu
            datamodels.MenuSection[] r7 = r7.menuSection
            java.lang.String r0 = "menuItemsResponseModel.menu.menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            int r0 = r7.length
            r2 = r1
        L_0x006e:
            if (r2 >= r0) goto L_0x009e
            r3 = r7[r2]
            int r4 = r3.f13863id
            int r5 = r6.menuSectionId
            if (r4 != r5) goto L_0x009b
            java.lang.String r7 = r3.sortCriteria
            java.lang.String r0 = "menuSection.sortCriteria"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.sortBy = r7
            java.lang.String r7 = r3.sortOrder
            java.lang.String r0 = "menuSection.sortOrder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.sortOrder = r7
            java.lang.String r7 = r3.filterBrands
            java.lang.String r0 = "menuSection.filterBrands"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.filterBrands = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r3.searchBrandIds = r7
            goto L_0x009e
        L_0x009b:
            int r2 = r2 + 1
            goto L_0x006e
        L_0x009e:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00a5
            r7.stopLoading()
        L_0x00a5:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00ac
            r7.showClearButton(r1)
        L_0x00ac:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00b3
            r7.showEmptyScreen(r1, r1)
        L_0x00b3:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00ba
            r7.isRequired()
        L_0x00ba:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00cb
            java.util.ArrayList r0 = r6.getAllItemsToDisplay()
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r2 = r6.getPagingInfo()
            java.lang.String r3 = r6.query
            r7.updateList(r0, r2, r3)
        L_0x00cb:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00d6
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r0 = r6.getPagingInfo()
            r7.setItemsCount(r0)
        L_0x00d6:
            library.talabat.mvp.grocerydetails.GroceryDetailsView r7 = r6.groceryDetailsView
            if (r7 == 0) goto L_0x00dd
            r7.setIsUpdateRequired(r1)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.grocerydetails.GroceryDetailsPresenter.setNewPageNumber(int):void");
    }

    public final void setSearchPageNumber$com_talabat_talabatlib_talabatlib(@NotNull PublishSubject<Integer> publishSubject2) {
        Intrinsics.checkNotNullParameter(publishSubject2, "<set-?>");
        this.searchPageNumber = publishSubject2;
    }

    public void setSelectedBrandIdsList(@NotNull ArrayList<String> arrayList) {
        boolean z11;
        Intrinsics.checkNotNullParameter(arrayList, "selectedBrands");
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "searchEditText.text");
        int i11 = 0;
        if (StringsKt__StringsKt.trim((CharSequence) text).length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
            Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
            int length = menuSectionArr.length;
            while (i11 < length) {
                MenuSection menuSection = menuSectionArr[i11];
                if (menuSection.f13863id == this.menuSectionId) {
                    ArrayList<String> arrayList2 = menuSection.brandIds;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "menuSection.brandIds");
                    if (!arrayList2.isEmpty()) {
                        menuSection.brandIds.clear();
                    }
                    menuSection.brandIds.addAll(arrayList);
                    return;
                }
                i11++;
            }
            return;
        }
        MenuSection[] menuSectionArr2 = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr2, "menuItemsResponseModel.menu.menuSection");
        int length2 = menuSectionArr2.length;
        while (i11 < length2) {
            MenuSection menuSection2 = menuSectionArr2[i11];
            if (menuSection2.f13863id == this.menuSectionId) {
                ArrayList<String> arrayList3 = menuSection2.searchBrandIds;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "menuSection.searchBrandIds");
                if (!arrayList3.isEmpty()) {
                    menuSection2.searchBrandIds.clear();
                }
                menuSection2.searchBrandIds.addAll(arrayList);
                return;
            }
            i11++;
        }
    }

    public void setSortAndFilterCriteria(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        GroceryDetailsView groceryDetailsView2;
        Intrinsics.checkNotNullParameter(str, "filterCriteriaString");
        Intrinsics.checkNotNullParameter(str2, "sortByCriteriaSting");
        Intrinsics.checkNotNullParameter(str3, "sortOrderCriteriaString");
        Intrinsics.checkNotNullParameter(str4, "tagIdsString");
        if (!Intrinsics.areEqual((Object) this.filterBrands, (Object) str) && (groceryDetailsView2 = this.groceryDetailsView) != null) {
            groceryDetailsView2.resetTagsRecyclerView();
        }
        this.filterBrands = str;
        this.sortBy = str2;
        this.sortOrder = str3;
        this.previousQuery = "";
        if (Intrinsics.areEqual((Object) str4, (Object) "-1")) {
            str4 = "";
        }
        this.tagIdsString = str4;
    }

    public final void setSortBy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sortBy = str;
    }

    public final void setSortOrder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sortOrder = str;
    }

    public void setTotalPages() {
        IGroceryDetailsInteractor iGroceryDetailsInteractor2 = this.iGroceryDetailsInteractor;
        if (iGroceryDetailsInteractor2 != null) {
            iGroceryDetailsInteractor2.setTotalPages(this.menuSectionRequired.groceryItemsForSectionPagingInfo.getTotalPages());
        }
    }

    public void setUpSearchThreads(@NotNull EditText editText, int i11) {
        Intrinsics.checkNotNullParameter(editText, "search_field");
        this.searchEditText = editText;
        this.disposable.clear();
        DisposableObserver<GrocerySearchResponse> searchObserver = getSearchObserver();
        CompositeDisposable compositeDisposable = this.disposable;
        PublishSubject<String> publishSubject2 = this.publishSubject;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        compositeDisposable.add((Disposable) publishSubject2.debounce(0, timeUnit).filter(new c()).switchMapSingle(new d(this, i11)).subscribeWith(searchObserver));
        CompositeDisposable compositeDisposable2 = this.disposable;
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText2 = null;
        }
        compositeDisposable2.add((Disposable) RxTextView.textChangeEvents(editText2).skipInitialValue().distinctUntilChanged().filter(new e(this)).debounce(600, timeUnit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(searchMenuitemTextWatcher()));
        this.disposable.add((Disposable) this.searchPageNumber.debounce(600, timeUnit).switchMapSingle(new f(this)).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new GroceryDetailsPresenter$setUpSearchThreads$5(this, i11)));
        this.disposable.add(searchObserver);
    }
}
