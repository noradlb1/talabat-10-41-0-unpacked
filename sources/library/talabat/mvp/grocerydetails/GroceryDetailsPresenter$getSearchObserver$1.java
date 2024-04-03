package library.talabat.mvp.grocerydetails;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import datamodels.MenuItem;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/grocerydetails/GroceryDetailsPresenter$getSearchObserver$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/GroceryResponse/GrocerySearchResponse;", "onComplete", "", "onError", "e", "", "onNext", "grocerySearchResponse", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsPresenter$getSearchObserver$1 extends DisposableObserver<GrocerySearchResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f26726b;

    public GroceryDetailsPresenter$getSearchObserver$1(GroceryDetailsPresenter groceryDetailsPresenter) {
        this.f26726b = groceryDetailsPresenter;
    }

    public void onComplete() {
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26726b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26726b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
        GroceryDetailsPresenter groceryDetailsPresenter = this.f26726b;
        GroceryDetailsView access$getGroceryDetailsView$p2 = groceryDetailsPresenter.groceryDetailsView;
        Intrinsics.checkNotNull(access$getGroceryDetailsView$p2);
        groceryDetailsPresenter.setUpSearchThreads(access$getGroceryDetailsView$p2.getEditText(), this.f26726b.incrementedPageNumber);
    }

    public void onNext(@NotNull GrocerySearchResponse grocerySearchResponse) {
        Intrinsics.checkNotNullParameter(grocerySearchResponse, "grocerySearchResponse");
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26726b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
        GroceryDetailsView access$getGroceryDetailsView$p2 = this.f26726b.groceryDetailsView;
        Intrinsics.checkNotNull(access$getGroceryDetailsView$p2);
        String searchTerm = access$getGroceryDetailsView$p2.getSearchTerm();
        if (!(searchTerm == null || searchTerm.length() == 0)) {
            Boolean bool = null;
            if (grocerySearchResponse.getItems() != null) {
                MenuItem[] items = grocerySearchResponse.getItems();
                if (items != null) {
                    bool = Boolean.valueOf(items.length == 0);
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    GroceryDetailsView access$getGroceryDetailsView$p3 = this.f26726b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p3 != null) {
                        access$getGroceryDetailsView$p3.showEmptyScreen(true, false);
                        return;
                    }
                    return;
                }
                GroceryDetailsView access$getGroceryDetailsView$p4 = this.f26726b.groceryDetailsView;
                if (access$getGroceryDetailsView$p4 != null) {
                    access$getGroceryDetailsView$p4.showEmptyScreen(false, false);
                }
                GroceryDetailsView access$getGroceryDetailsView$p5 = this.f26726b.groceryDetailsView;
                if (access$getGroceryDetailsView$p5 != null) {
                    MenuItem[] items2 = grocerySearchResponse.getItems();
                    Intrinsics.checkNotNull(items2);
                    access$getGroceryDetailsView$p5.updateList((ArrayList) ArraysKt___ArraysKt.toCollection((T[]) items2, new ArrayList()), grocerySearchResponse.getPagingSummary().getPagingInfo(), this.f26726b.query);
                }
                GroceryDetailsView access$getGroceryDetailsView$p6 = this.f26726b.groceryDetailsView;
                if (access$getGroceryDetailsView$p6 != null) {
                    access$getGroceryDetailsView$p6.setItemsCount(grocerySearchResponse.getPagingSummary().getPagingInfo());
                }
                GroceryDetailsView access$getGroceryDetailsView$p7 = this.f26726b.groceryDetailsView;
                if (access$getGroceryDetailsView$p7 != null) {
                    access$getGroceryDetailsView$p7.setIsUpdateRequired(true);
                }
                if (!Intrinsics.areEqual((Object) this.f26726b.previousQuery, (Object) this.f26726b.query)) {
                    GroceryDetailsPresenter groceryDetailsPresenter = this.f26726b;
                    groceryDetailsPresenter.previousQuery = groceryDetailsPresenter.query;
                    this.f26726b.searchResultTags = grocerySearchResponse.getPagingSummary().getGroceryTags();
                    GroceryDetailsView access$getGroceryDetailsView$p8 = this.f26726b.groceryDetailsView;
                    if (access$getGroceryDetailsView$p8 != null) {
                        access$getGroceryDetailsView$p8.setGroceryTags(this.f26726b.searchResultTags, true, this.f26726b.allItemsTagSelected);
                        return;
                    }
                    return;
                }
                return;
            }
            GroceryDetailsView access$getGroceryDetailsView$p9 = this.f26726b.groceryDetailsView;
            if (access$getGroceryDetailsView$p9 != null) {
                access$getGroceryDetailsView$p9.showEmptyScreen(true, false);
            }
            GroceryDetailsView access$getGroceryDetailsView$p10 = this.f26726b.groceryDetailsView;
            if (access$getGroceryDetailsView$p10 != null) {
                access$getGroceryDetailsView$p10.setGroceryTags((GroceryTagsModel[]) null, true, this.f26726b.allItemsTagSelected);
            }
        }
    }
}
