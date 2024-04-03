package ue;

import com.talabat.CheckOutScreen;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a5 implements Function1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57427b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f57428c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57429d;

    public /* synthetic */ a5(CheckOutScreen checkOutScreen, Restaurant restaurant, String str) {
        this.f57427b = checkOutScreen;
        this.f57428c = restaurant;
        this.f57429d = str;
    }

    public final Object invoke(Object obj) {
        return this.f57427b.lambda$proceedWithPickupPlaceOrder$34(this.f57428c, this.f57429d, (Boolean) obj);
    }
}
