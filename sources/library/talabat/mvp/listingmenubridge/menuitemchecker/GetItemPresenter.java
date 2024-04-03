package library.talabat.mvp.listingmenubridge.menuitemchecker;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import datamodels.MenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.menu_search.IMenuSearchInteractor;
import o10.a;
import o10.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/GetItemPresenter;", "Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/IGetItemPresenter;", "menuItemInteractor", "Llibrary/talabat/mvp/menu_search/IMenuSearchInteractor;", "searchItemListener", "Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/SearchItemListener;", "(Llibrary/talabat/mvp/menu_search/IMenuSearchInteractor;Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/SearchItemListener;)V", "getMenuItemInteractor", "()Llibrary/talabat/mvp/menu_search/IMenuSearchInteractor;", "getSearchItemListener", "()Llibrary/talabat/mvp/listingmenubridge/menuitemchecker/SearchItemListener;", "getItemFromResponse", "Ldatamodels/MenuItem;", "response", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "getSearchItem", "", "itemName", "", "branchId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetItemPresenter implements IGetItemPresenter {
    @NotNull
    private final IMenuSearchInteractor menuItemInteractor;
    @NotNull
    private final SearchItemListener searchItemListener;

    public GetItemPresenter(@NotNull IMenuSearchInteractor iMenuSearchInteractor, @NotNull SearchItemListener searchItemListener2) {
        Intrinsics.checkNotNullParameter(iMenuSearchInteractor, "menuItemInteractor");
        Intrinsics.checkNotNullParameter(searchItemListener2, "searchItemListener");
        this.menuItemInteractor = iMenuSearchInteractor;
        this.searchItemListener = searchItemListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSearchItem$lambda-1  reason: not valid java name */
    public static final void m7899getSearchItem$lambda1(GetItemPresenter getItemPresenter, GrocerySearchResponse grocerySearchResponse) {
        Intrinsics.checkNotNullParameter(getItemPresenter, "this$0");
        Intrinsics.checkNotNullExpressionValue(grocerySearchResponse, "value");
        MenuItem itemFromResponse = getItemPresenter.getItemFromResponse(grocerySearchResponse);
        if (itemFromResponse != null) {
            getItemPresenter.searchItemListener.onItemInfoLoaded(itemFromResponse);
        } else {
            getItemPresenter.searchItemListener.onItemNotAvailable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getSearchItem$lambda-2  reason: not valid java name */
    public static final void m7900getSearchItem$lambda2(Throwable th2) {
        System.out.println("Error: " + th2);
    }

    @Nullable
    public final MenuItem getItemFromResponse(@NotNull GrocerySearchResponse grocerySearchResponse) {
        Intrinsics.checkNotNullParameter(grocerySearchResponse, "response");
        MenuItem[] items = grocerySearchResponse.getItems();
        if (items != null) {
            return (MenuItem) ArraysKt___ArraysKt.firstOrNull((T[]) items);
        }
        return null;
    }

    @NotNull
    public final IMenuSearchInteractor getMenuItemInteractor() {
        return this.menuItemInteractor;
    }

    public void getSearchItem(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "itemName");
        Intrinsics.checkNotNullParameter(str2, "branchId");
        this.menuItemInteractor.getDataFromApi(str, str2, 1, "", "", "", "").subscribe(new a(this), new b());
    }

    @NotNull
    public final SearchItemListener getSearchItemListener() {
        return this.searchItemListener;
    }
}
