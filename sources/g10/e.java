package g10;

import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import io.reactivex.functions.Predicate;
import library.talabat.mvp.grocerydetails.GroceryDetailsPresenter;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f24328b;

    public /* synthetic */ e(GroceryDetailsPresenter groceryDetailsPresenter) {
        this.f24328b = groceryDetailsPresenter;
    }

    public final boolean test(Object obj) {
        return GroceryDetailsPresenter.m7882setUpSearchThreads$lambda3(this.f24328b, (TextViewTextChangeEvent) obj);
    }
}
