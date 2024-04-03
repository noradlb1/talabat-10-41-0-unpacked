package a20;

import datamodels.GroceryInfoAndMenuResponseZipped;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.restaurantlistrefactor.MenuApiInteractor;
import library.talabat.mvp.restaurantlistrefactor.MenuApiListener;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuApiInteractor f24279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuApiListener f24280c;

    public /* synthetic */ c(MenuApiInteractor menuApiInteractor, MenuApiListener menuApiListener) {
        this.f24279b = menuApiInteractor;
        this.f24280c = menuApiListener;
    }

    public final void accept(Object obj) {
        this.f24279b.lambda$getGroceryMenu$0(this.f24280c, (GroceryInfoAndMenuResponseZipped) obj);
    }
}
