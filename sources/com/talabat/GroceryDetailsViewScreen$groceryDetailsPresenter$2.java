package com.talabat;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.grocerydetails.GroceryDetailsPresenter;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Llibrary/talabat/mvp/grocerydetails/GroceryDetailsPresenter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$groceryDetailsPresenter$2 extends Lambda implements Function0<GroceryDetailsPresenter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsViewScreen f54107g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroceryDetailsViewScreen$groceryDetailsPresenter$2(GroceryDetailsViewScreen groceryDetailsViewScreen) {
        super(0);
        this.f54107g = groceryDetailsViewScreen;
    }

    @NotNull
    public final GroceryDetailsPresenter invoke() {
        return new GroceryDetailsPresenter(this.f54107g.getAppVersionProvider(), this.f54107g);
    }
}
