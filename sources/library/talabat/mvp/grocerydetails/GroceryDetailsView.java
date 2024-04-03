package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.content.Context;
import android.widget.EditText;
import com.talabat.helpers.Talabat;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J(\u0010\u0010\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\rH&J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\rH&J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001d\u001a\u00020\rH&J\b\u0010\u001e\u001a\u00020\rH&J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH&J-\u0010!\u001a\u00020\r2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH&¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000bH&J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0016H&J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u000bH&J\u0018\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000bH&J\b\u00100\u001a\u00020\rH&J\u001a\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u00104\u001a\u00020\rH&J2\u00105\u001a\u00020\r2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u00010\u0007H&¨\u00069"}, d2 = {"Llibrary/talabat/mvp/grocerydetails/GroceryDetailsView;", "Lcom/talabat/helpers/Talabat;", "getContext", "Landroid/content/Context;", "getEditText", "Landroid/widget/EditText;", "getScreenName", "", "getSearchTerm", "getTagNamesString", "isRequired", "", "onChoiceReceived", "", "splitChoiceItemModel", "LJsonModels/Response/SplitRestaurantApiResponse/SplitChoiceItemModel;", "onDataLoaded", "items", "Ljava/util/ArrayList;", "Ldatamodels/MenuItem;", "Lkotlin/collections/ArrayList;", "pagingInfo", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionPagingInfo;", "onDataLoadingError", "onItemAdded", "cartMenuItem", "Ldatamodels/CartMenuItem;", "onMaxCartItemsReached", "onNavigateToItemDetails", "resetTagsRecyclerView", "sendGAForSearchApiCalled", "setAllItemsLoaded", "set", "setGroceryTags", "groceryTags", "", "LJsonModels/Response/GroceryResponse/GroceryTagsModel;", "fromFilterOrSearch", "allItemsTagSelected", "([LJsonModels/Response/GroceryResponse/GroceryTagsModel;ZZ)V", "setIsUpdateRequired", "required", "setItemsCount", "sortedItemsItemsPagingInfo", "showClearButton", "show", "showEmptyScreen", "isNetWorkError", "showLoading", "showRestaurantChangePopup", "restaurant", "Ldatamodels/Restaurant;", "stopLoading", "updateList", "menuItems", "searchPagingInfo", "query", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryDetailsView extends Talabat {
    @NotNull
    Context getContext();

    @NotNull
    EditText getEditText();

    @Nullable
    String getScreenName();

    @NotNull
    String getSearchTerm();

    @NotNull
    String getTagNamesString();

    boolean isRequired();

    void onChoiceReceived(@Nullable SplitChoiceItemModel splitChoiceItemModel);

    void onDataLoaded(@NotNull ArrayList<MenuItem> arrayList, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo);

    void onDataLoadingError();

    void onItemAdded(@Nullable CartMenuItem cartMenuItem);

    void onMaxCartItemsReached();

    void onNavigateToItemDetails(@Nullable CartMenuItem cartMenuItem);

    void resetTagsRecyclerView();

    void sendGAForSearchApiCalled();

    void setAllItemsLoaded(boolean z11);

    void setGroceryTags(@Nullable GroceryTagsModel[] groceryTagsModelArr, boolean z11, boolean z12);

    void setIsUpdateRequired(boolean z11);

    void setItemsCount(@NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo);

    void showClearButton(boolean z11);

    void showEmptyScreen(boolean z11, boolean z12);

    void showLoading();

    void showRestaurantChangePopup(@Nullable Restaurant restaurant, @NotNull CartMenuItem cartMenuItem);

    void stopLoading();

    void updateList(@NotNull ArrayList<MenuItem> arrayList, @NotNull GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo, @Nullable String str);
}
