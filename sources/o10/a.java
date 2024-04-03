package o10;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.listingmenubridge.menuitemchecker.GetItemPresenter;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetItemPresenter f27516b;

    public /* synthetic */ a(GetItemPresenter getItemPresenter) {
        this.f27516b = getItemPresenter;
    }

    public final void accept(Object obj) {
        GetItemPresenter.m7899getSearchItem$lambda1(this.f27516b, (GrocerySearchResponse) obj);
    }
}
