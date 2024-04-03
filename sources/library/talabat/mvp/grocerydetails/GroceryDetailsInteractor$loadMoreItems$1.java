package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse;
import JsonModels.Response.GroceryResponse.MenuItemsForSection;
import com.talabat.helpers.GlobalDataModel;
import datamodels.MenuItem;
import datamodels.MenuSection;
import io.reactivex.observers.DisposableObserver;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/grocerydetails/GroceryDetailsInteractor$loadMoreItems$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionResponse;", "onComplete", "", "onError", "e", "", "onNext", "groceryItemsForSectionResponse", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsInteractor$loadMoreItems$1 extends DisposableObserver<GroceryItemsForSectionResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsInteractor f26723b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f26724c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f26725d;

    public GroceryDetailsInteractor$loadMoreItems$1(GroceryDetailsInteractor groceryDetailsInteractor, String str, int i11) {
        this.f26723b = groceryDetailsInteractor;
        this.f26724c = str;
        this.f26725d = i11;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        GroceryDetailsListener access$getGroceryDetailsListener$p = this.f26723b.groceryDetailsListener;
        if (access$getGroceryDetailsListener$p != null) {
            access$getGroceryDetailsListener$p.onItemsDataError();
        }
    }

    public void onNext(@NotNull GroceryItemsForSectionResponse groceryItemsForSectionResponse) {
        Intrinsics.checkNotNullParameter(groceryItemsForSectionResponse, "groceryItemsForSectionResponse");
        if (!this.f26723b.getMenuItemsRealList().containsKey(Integer.valueOf(Integer.parseInt(this.f26724c)))) {
            HashMap<Integer, MenuItem[]> menuItemsRealList = this.f26723b.getMenuItemsRealList();
            Integer valueOf = Integer.valueOf(Integer.parseInt(this.f26724c));
            MenuItemsForSection result = groceryItemsForSectionResponse.getResult();
            Intrinsics.checkNotNull(result);
            MenuItem[] menuItemArr = result.getMenuSection().items;
            Intrinsics.checkNotNullExpressionValue(menuItemArr, "groceryItemsForSectionRe…esult!!.menuSection.items");
            menuItemsRealList.put(valueOf, menuItemArr);
        }
        int totalMenuPages = this.f26723b.getTotalMenuPages();
        String str = this.f26724c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(totalMenuPages);
        sb2.append(" and ");
        sb2.append(str);
        sb2.append(" ");
        if (String.valueOf(this.f26723b.getTotalMenuPages()).equals(this.f26724c)) {
            MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
            Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
            int length = menuSectionArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                MenuSection menuSection = menuSectionArr[i11];
                if (menuSection.f13863id == this.f26725d) {
                    menuSection.allItemsLoaded = true;
                    break;
                }
                i11++;
            }
        }
        GroceryDetailsInteractor groceryDetailsInteractor = this.f26723b;
        int parseInt = Integer.parseInt(this.f26724c);
        int i12 = this.f26725d;
        MenuItemsForSection result2 = groceryItemsForSectionResponse.getResult();
        Intrinsics.checkNotNull(result2);
        MenuItem[] menuItemArr2 = result2.getMenuSection().items;
        Intrinsics.checkNotNullExpressionValue(menuItemArr2, "groceryItemsForSectionRe…esult!!.menuSection.items");
        MenuItemsForSection result3 = groceryItemsForSectionResponse.getResult();
        Intrinsics.checkNotNull(result3);
        MenuItemsForSection result4 = groceryItemsForSectionResponse.getResult();
        Intrinsics.checkNotNull(result4);
        groceryDetailsInteractor.allocateMenuItemsInOrder(parseInt, i12, menuItemArr2, result3, result4.getMenuSection().groceryTags);
    }
}
