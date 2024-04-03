package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import datamodels.MenuItem;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/grocerydetails/GroceryDetailsPresenter$setUpSearchThreads$5", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "onComplete", "", "onError", "e", "", "onNext", "grocerySearchResponse", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsPresenter$setUpSearchThreads$5 extends DisposableObserver<GrocerySearchResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f26728b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26729c;

    public GroceryDetailsPresenter$setUpSearchThreads$5(GroceryDetailsPresenter groceryDetailsPresenter, int i11) {
        this.f26728b = groceryDetailsPresenter;
        this.f26729c = i11;
    }

    public void onComplete() {
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26728b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26728b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
        GroceryDetailsPresenter groceryDetailsPresenter = this.f26728b;
        GroceryDetailsView access$getGroceryDetailsView$p2 = groceryDetailsPresenter.groceryDetailsView;
        Intrinsics.checkNotNull(access$getGroceryDetailsView$p2);
        groceryDetailsPresenter.setUpSearchThreads(access$getGroceryDetailsView$p2.getEditText(), this.f26729c);
    }

    public void onNext(@NotNull GrocerySearchResponse grocerySearchResponse) {
        GroceryDetailsView access$getGroceryDetailsView$p;
        Intrinsics.checkNotNullParameter(grocerySearchResponse, "grocerySearchResponse");
        GroceryDetailsView access$getGroceryDetailsView$p2 = this.f26728b.groceryDetailsView;
        if (access$getGroceryDetailsView$p2 != null) {
            access$getGroceryDetailsView$p2.stopLoading();
        }
        if (grocerySearchResponse.getItems() != null) {
            GroceryDetailsView access$getGroceryDetailsView$p3 = this.f26728b.groceryDetailsView;
            Intrinsics.checkNotNull(access$getGroceryDetailsView$p3);
            String searchTerm = access$getGroceryDetailsView$p3.getSearchTerm();
            if (!(searchTerm == null || searchTerm.length() == 0)) {
                MenuItem[] items = grocerySearchResponse.getItems();
                Intrinsics.checkNotNull(items);
                if (!(items.length == 0)) {
                    MenuItem[] items2 = grocerySearchResponse.getItems();
                    Intrinsics.checkNotNull(items2);
                    int length = items2.length;
                }
                MenuItem[] items3 = grocerySearchResponse.getItems();
                Intrinsics.checkNotNull(items3);
                if (!(items3.length == 0)) {
                    GroceryDetailsView access$getGroceryDetailsView$p4 = this.f26728b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p4 != null) {
                        access$getGroceryDetailsView$p4.showEmptyScreen(false, false);
                    }
                    GroceryDetailsView access$getGroceryDetailsView$p5 = this.f26728b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p5 != null) {
                        MenuItem[] items4 = grocerySearchResponse.getItems();
                        Intrinsics.checkNotNull(items4);
                        access$getGroceryDetailsView$p5.updateList((ArrayList) ArraysKt___ArraysKt.toCollection((T[]) items4, new ArrayList()), grocerySearchResponse.getPagingSummary().getPagingInfo(), this.f26728b.query);
                    }
                    if (this.f26728b.incrementedPageNumber == 1 && (access$getGroceryDetailsView$p = this.f26728b.groceryDetailsView) != null) {
                        access$getGroceryDetailsView$p.setItemsCount(grocerySearchResponse.getPagingSummary().getPagingInfo());
                    }
                    GroceryDetailsView access$getGroceryDetailsView$p6 = this.f26728b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p6 != null) {
                        access$getGroceryDetailsView$p6.setIsUpdateRequired(true);
                    }
                    if (!Intrinsics.areEqual((Object) this.f26728b.previousQuery, (Object) this.f26728b.query)) {
                        GroceryDetailsPresenter groceryDetailsPresenter = this.f26728b;
                        groceryDetailsPresenter.previousQuery = groceryDetailsPresenter.query;
                        this.f26728b.searchResultTags = grocerySearchResponse.getPagingSummary().getGroceryTags();
                        GroceryDetailsView access$getGroceryDetailsView$p7 = this.f26728b.groceryDetailsView;
                        if (access$getGroceryDetailsView$p7 != null) {
                            access$getGroceryDetailsView$p7.setGroceryTags(this.f26728b.searchResultTags, true, this.f26728b.allItemsTagSelected);
                        }
                    }
                } else if (this.f26728b.incrementedPageNumber == 1) {
                    GroceryDetailsView access$getGroceryDetailsView$p8 = this.f26728b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p8 != null) {
                        access$getGroceryDetailsView$p8.showEmptyScreen(true, false);
                    }
                    GroceryDetailsView access$getGroceryDetailsView$p9 = this.f26728b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p9 != null) {
                        access$getGroceryDetailsView$p9.setGroceryTags((GroceryTagsModel[]) null, true, this.f26728b.allItemsTagSelected);
                    }
                }
            }
        }
    }
}
