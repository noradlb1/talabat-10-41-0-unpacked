package g10;

import io.reactivex.functions.Function;
import library.talabat.mvp.grocerydetails.GroceryDetailsPresenter;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f24329b;

    public /* synthetic */ f(GroceryDetailsPresenter groceryDetailsPresenter) {
        this.f24329b = groceryDetailsPresenter;
    }

    public final Object apply(Object obj) {
        return GroceryDetailsPresenter.m7883setUpSearchThreads$lambda4(this.f24329b, (Integer) obj);
    }
}
