package g10;

import io.reactivex.functions.Function;
import library.talabat.mvp.grocerydetails.GroceryDetailsPresenter;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f24326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24327c;

    public /* synthetic */ d(GroceryDetailsPresenter groceryDetailsPresenter, int i11) {
        this.f24326b = groceryDetailsPresenter;
        this.f24327c = i11;
    }

    public final Object apply(Object obj) {
        return GroceryDetailsPresenter.m7881setUpSearchThreads$lambda2(this.f24326b, this.f24327c, (String) obj);
    }
}
