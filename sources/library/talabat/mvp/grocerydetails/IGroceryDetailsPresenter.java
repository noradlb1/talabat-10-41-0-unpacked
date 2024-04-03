package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import android.content.Context;
import android.widget.EditText;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017H&J\u0017\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u0019H&¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0015\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019H&¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH&J\b\u0010%\u001a\u00020&H&J\n\u0010'\u001a\u0004\u0018\u00010\tH&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H&J\u0017\u0010)\u001a\f\u0012\u0006\b\u0001\u0012\u00020 \u0018\u00010\u0019H&¢\u0006\u0002\u0010!J\b\u0010*\u001a\u00020\u0013H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u001eH&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013H&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u001eH&J\u0016\u00103\u001a\u00020\u00032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H&J(\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH&J\b\u0010:\u001a\u00020\u0003H&J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001eH&¨\u0006?"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/IGroceryDetailsPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "addItem", "", "restaurant", "Ldatamodels/Restaurant;", "cartMenuItem", "Ldatamodels/CartMenuItem;", "eventOrigin", "", "changeRestaurantAndAddItem", "context", "Landroid/content/Context;", "clearEditText", "clearLocalCache", "clearSearchTags", "clearSelectedBrands", "disableAutoSearch", "disable", "", "getAllItemsToDisplay", "Ljava/util/ArrayList;", "Ldatamodels/MenuItem;", "Lkotlin/collections/ArrayList;", "getBrands", "", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "()[LJsonModels/Response/GroceryResponse/GroceryItemsForSectionBrandModel;", "getChoiceSection", "id", "", "getGroceryTags", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "()[LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "getMenuSection", "Ldatamodels/MenuSection;", "menuSectionId", "getPagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "getPreviousTagString", "getSelectedBrandIds", "getTags", "isAllItemsLoaded", "loadMoreItems", "pageNumber", "requestForSearch", "value", "resetSortAndFilter", "setAllItemsLoaded", "setNewPageNumber", "searchPageNumber", "setSelectedBrandIdsList", "selectedBrands", "setSortAndFilterCriteria", "filterCriteriaString", "sortByCriteriaSting", "sortOrderCriteriaString", "tagIdsString", "setTotalPages", "setUpSearchThreads", "search_field", "Landroid/widget/EditText;", "newPageNumber", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IGroceryDetailsPresenter extends IGlobalPresenter {
    void addItem(@Nullable Restaurant restaurant, @Nullable CartMenuItem cartMenuItem, @NotNull String str);

    void changeRestaurantAndAddItem(@NotNull Context context, @Nullable Restaurant restaurant, @NotNull CartMenuItem cartMenuItem);

    void clearEditText();

    void clearLocalCache();

    void clearSearchTags();

    void clearSelectedBrands();

    void disableAutoSearch(boolean z11);

    @NotNull
    ArrayList<MenuItem> getAllItemsToDisplay();

    @Nullable
    GroceryItemsForSectionBrandModel[] getBrands();

    void getChoiceSection(int i11);

    @Nullable
    GroceryTagsModel[] getGroceryTags();

    @NotNull
    MenuSection getMenuSection(int i11);

    @NotNull
    GroceryItemsForSectionPagingInfo getPagingInfo();

    @Nullable
    String getPreviousTagString();

    @NotNull
    ArrayList<String> getSelectedBrandIds();

    @Nullable
    GroceryTagsModel[] getTags();

    boolean isAllItemsLoaded();

    void loadMoreItems(int i11);

    void requestForSearch(boolean z11);

    void resetSortAndFilter();

    void setAllItemsLoaded();

    void setNewPageNumber(int i11);

    void setSelectedBrandIdsList(@NotNull ArrayList<String> arrayList);

    void setSortAndFilterCriteria(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void setTotalPages();

    void setUpSearchThreads(@NotNull EditText editText, int i11);
}
