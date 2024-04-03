package library.talabat.mvp.grocerydetails;

import JsonModels.Request.GroceryRequest.GrocerySearchRequest;
import JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest;
import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.GroceryResponse.MenuItemsForSection;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import datamodels.MenuItem;
import datamodels.Restaurant;
import g10.a;
import g10.b;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJC\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\fH\u0016JV\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010'2\b\u0010/\u001a\u0004\u0018\u00010'2\b\u00100\u001a\u0004\u0018\u00010'2\b\u00101\u001a\u0004\u0018\u00010'H\u0016J \u00102\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020'H\u0016J\u0010\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J\n\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000RF\u0010\n\u001a.\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000bj\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006;"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/GroceryDetailsInteractor;", "Llibrary/talabat/mvp/grocerydetails/IGroceryDetailsInteractor;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "_groceryDetailsListener", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsListener;", "context", "Landroid/content/Context;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Llibrary/talabat/mvp/grocerydetails/GroceryDetailsListener;Landroid/content/Context;)V", "groceryDetailsListener", "menuItemsRealList", "Ljava/util/HashMap;", "", "", "Ldatamodels/MenuItem;", "Lkotlin/collections/HashMap;", "getMenuItemsRealList", "()Ljava/util/HashMap;", "setMenuItemsRealList", "(Ljava/util/HashMap;)V", "totalMenuPages", "getTotalMenuPages", "()I", "setTotalMenuPages", "(I)V", "allocateMenuItemsInOrder", "", "pageNumber", "menuSectionId", "items", "result", "LJsonModels/Response/GroceryResponse/MenuItemsForSection;", "groceryTags", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "(II[Ldatamodels/MenuItem;LJsonModels/Response/GroceryResponse/MenuItemsForSection;[LJsonModels/Response/GroceryResponse/GroceryTagsModel;)V", "applyFilterAndSorting", "grocerySortAndFilterRequest", "LJsonModels/Request/GroceryRequest/GrocerySortAndFilterRequest;", "branchId", "", "getChoiceSection", "id", "getDataFromApi", "Lio/reactivex/Single;", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "query", "sortBy", "sortOrder", "filterBrands", "tagIdsString", "loadMoreItems", "onChoiceReceived", "Lcom/android/volley/Response$Listener;", "LJsonModels/Response/SplitRestaurantApiResponse/SplitChoiceRM;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "setTotalPages", "totalPages", "unregister", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsInteractor implements IGroceryDetailsInteractor {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    @Nullable
    public GroceryDetailsListener groceryDetailsListener;
    @NotNull
    private HashMap<Integer, MenuItem[]> menuItemsRealList = new HashMap<>();
    private int totalMenuPages;

    public GroceryDetailsInteractor(@NotNull AppVersionProvider appVersionProvider2, @NotNull GroceryDetailsListener groceryDetailsListener2, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(groceryDetailsListener2, "_groceryDetailsListener");
        Intrinsics.checkNotNullParameter(context, "context");
        this.appVersionProvider = appVersionProvider2;
        this.groceryDetailsListener = groceryDetailsListener2;
    }

    /* access modifiers changed from: private */
    public final void allocateMenuItemsInOrder(int i11, int i12, MenuItem[] menuItemArr, MenuItemsForSection menuItemsForSection, GroceryTagsModel[] groceryTagsModelArr) {
        Map map = MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.sortedWith(MapsKt___MapsKt.toList(this.menuItemsRealList), new GroceryDetailsInteractor$allocateMenuItemsInOrder$$inlined$sortedBy$1()));
        GroceryDetailsListener groceryDetailsListener2 = this.groceryDetailsListener;
        if (groceryDetailsListener2 != null) {
            groceryDetailsListener2.onDataLoaded(i11, i12, menuItemArr, map, menuItemsForSection.getPagingInfo(), groceryTagsModelArr);
        }
    }

    private final Response.Listener<SplitChoiceRM> onChoiceReceived() {
        return new a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onChoiceReceived$lambda-2  reason: not valid java name */
    public static final void m7878onChoiceReceived$lambda2(GroceryDetailsInteractor groceryDetailsInteractor, SplitChoiceRM splitChoiceRM) {
        boolean z11;
        Intrinsics.checkNotNullParameter(groceryDetailsInteractor, "this$0");
        SplitChoiceItemModel[] splitChoiceItemModelArr = splitChoiceRM.result.items;
        Intrinsics.checkNotNullExpressionValue(splitChoiceItemModelArr, "response.result.items");
        if (splitChoiceItemModelArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            GroceryDetailsListener groceryDetailsListener2 = groceryDetailsInteractor.groceryDetailsListener;
            if (groceryDetailsListener2 != null) {
                groceryDetailsListener2.onChoiceReceived(splitChoiceRM.result.items[0]);
                return;
            }
            return;
        }
        GroceryDetailsListener groceryDetailsListener3 = groceryDetailsInteractor.groceryDetailsListener;
        if (groceryDetailsListener3 != null) {
            groceryDetailsListener3.onNoChoiceAvailable();
        }
    }

    private final Response.ErrorListener onRequestError() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-0  reason: not valid java name */
    public static final void m7879onRequestError$lambda0(GroceryDetailsInteractor groceryDetailsInteractor, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(groceryDetailsInteractor, "this$0");
        if (volleyError instanceof ServerError) {
            GroceryDetailsListener groceryDetailsListener2 = groceryDetailsInteractor.groceryDetailsListener;
            if (groceryDetailsListener2 != null) {
                groceryDetailsListener2.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            GroceryDetailsListener groceryDetailsListener3 = groceryDetailsInteractor.groceryDetailsListener;
            if (groceryDetailsListener3 != null) {
                groceryDetailsListener3.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            GroceryDetailsListener groceryDetailsListener4 = groceryDetailsInteractor.groceryDetailsListener;
            if (groceryDetailsListener4 != null) {
                groceryDetailsListener4.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    public void applyFilterAndSorting(int i11, @NotNull GrocerySortAndFilterRequest grocerySortAndFilterRequest, int i12, @NotNull String str) {
        GrocerySortAndFilterRequest grocerySortAndFilterRequest2 = grocerySortAndFilterRequest;
        int i13 = i12;
        String str2 = str;
        Intrinsics.checkNotNullParameter(grocerySortAndFilterRequest2, "grocerySortAndFilterRequest");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str3 = AppUrls.GROCERY_SORT_FILTER;
        Intrinsics.checkNotNullExpressionValue(str3, "GROCERY_SORT_FILTER");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str3, "{branchId}", str2, false, 4, (Object) null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i13);
        callApi.getGroceryItemsForSectionAfterSortingAndFilter(StringsKt__StringsJVMKt.replace$default(replace$default, "{sectionId}", sb2.toString(), false, 4, (Object) null), grocerySortAndFilterRequest2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new GroceryDetailsInteractor$applyFilterAndSorting$1(i11, this, i13, grocerySortAndFilterRequest2));
    }

    public void getChoiceSection(int i11) {
        Integer num = null;
        if (GlobalDataModel.SELECTED.getRestaurant() != null) {
            GsonRequest.Builder builder = new GsonRequest.Builder();
            String str = AppUrls.SPLIT_RESTAURANT_CHOICE;
            String[] strArr = new String[4];
            strArr[0] = "{branchId}";
            Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
            if (restaurant != null) {
                num = Integer.valueOf(restaurant.getBranchId());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(num);
            strArr[1] = sb2.toString();
            strArr[2] = "{sectionId}";
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i11);
            strArr[3] = sb3.toString();
            GsonRequest.Builder<SplitChoiceRM> errorListener = builder.setUrl(CreateApiUrl.createWithParameters(str, strArr)).setClazz(SplitChoiceRM.class).setListener(onChoiceReceived()).setErrorListener(onRequestError());
            String appVersion = this.appVersionProvider.appVersion();
            if (appVersion == null) {
                appVersion = "";
            }
            TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
            return;
        }
        ObservabilityManager.trackUnExpectedScenario$default("shop null when attempting to load category in interactor", (Map) null, 2, (Object) null);
    }

    @NotNull
    public Single<GrocerySearchResponse> getDataFromApi(@NotNull String str, int i11, @NotNull String str2, int i12, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        GroceryDetailsListener groceryDetailsListener2 = this.groceryDetailsListener;
        String str8 = str6;
        if (groceryDetailsListener2 != null) {
            groceryDetailsListener2.searchApiCalled(str8, str);
        }
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str9 = AppUrls.GROCERY_SEARCH_ALL;
        Intrinsics.checkNotNullExpressionValue(str9, "GROCERY_SEARCH_ALL");
        Single<GrocerySearchResponse> observeOn = callApi.getGroceryItemsForSearch(StringsKt__StringsJVMKt.replace$default(str9, "{branchId}", str2, false, 4, (Object) null), new GrocerySearchRequest(str, String.valueOf(i12), String.valueOf(i11), "10", str3, str4, str5, str6)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "callApi().getGroceryItem…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final HashMap<Integer, MenuItem[]> getMenuItemsRealList() {
        return this.menuItemsRealList;
    }

    public final int getTotalMenuPages() {
        return this.totalMenuPages;
    }

    public void loadMoreItems(int i11, @NotNull String str, @NotNull String str2) {
        int i12 = i11;
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "branchId");
        Intrinsics.checkNotNullParameter(str4, "pageNumber");
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str5 = AppUrls.SPLIT_GROCERY_ITEMS_FOR_SECTION;
        Intrinsics.checkNotNullExpressionValue(str5, "SPLIT_GROCERY_ITEMS_FOR_SECTION");
        String replace$default = StringsKt__StringsJVMKt.replace$default(str5, "{branchId}", str3, false, 4, (Object) null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        callApi.getGroceryItemsForSection(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(replace$default, "{sectionId}", sb2.toString(), false, 4, (Object) null), "{pageNumber}", str2, false, 4, (Object) null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new GroceryDetailsInteractor$loadMoreItems$1(this, str4, i12));
    }

    public final void setMenuItemsRealList(@NotNull HashMap<Integer, MenuItem[]> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.menuItemsRealList = hashMap;
    }

    public final void setTotalMenuPages(int i11) {
        this.totalMenuPages = i11;
    }

    public void setTotalPages(int i11) {
        this.totalMenuPages = i11;
        this.menuItemsRealList = new HashMap<>(i11);
    }

    public void unregister() {
        this.groceryDetailsListener = null;
    }
}
