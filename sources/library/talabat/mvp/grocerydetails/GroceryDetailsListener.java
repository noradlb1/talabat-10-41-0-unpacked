package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import datamodels.MenuItem;
import java.util.Map;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J_\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H&¨\u0006\u001a"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/GroceryDetailsListener;", "Llibrary/talabat/mvp/IGlobalListener;", "onChoiceReceived", "", "splitChoiceItemModel", "LJsonModels/Response/SplitRestaurantApiResponse/SplitChoiceItemModel;", "onDataLoaded", "pageNumber", "", "menuSectionId", "items", "", "Ldatamodels/MenuItem;", "menuItemsRealListSorted", "", "pagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "groceryTags", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "(II[Ldatamodels/MenuItem;Ljava/util/Map;LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;[LJsonModels/Response/GroceryResponse/GroceryTagsModel;)V", "onItemsDataError", "onNoChoiceAvailable", "searchApiCalled", "tagIdsString", "", "query", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryDetailsListener extends IGlobalListener {
    void onChoiceReceived(@Nullable SplitChoiceItemModel splitChoiceItemModel);

    void onDataLoaded(int i11, int i12, @NotNull MenuItem[] menuItemArr, @NotNull Map<Integer, ? extends MenuItem[]> map, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, @Nullable GroceryTagsModel[] groceryTagsModelArr);

    void onItemsDataError();

    void onNoChoiceAvailable();

    void searchApiCalled(@Nullable String str, @NotNull String str2);
}
