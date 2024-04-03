package ue;

import android.view.View;
import com.talabat.CartScreen;
import com.talabat.domain.address.Address;

public final /* synthetic */ class m1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57639b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57640c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57641d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57642e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f57643f;

    public /* synthetic */ m1(CartScreen cartScreen, Address address, boolean z11, boolean z12, boolean z13) {
        this.f57639b = cartScreen;
        this.f57640c = address;
        this.f57641d = z11;
        this.f57642e = z12;
        this.f57643f = z13;
    }

    public final void onClick(View view) {
        this.f57639b.lambda$isGrlRestaurantRedirect$16(this.f57640c, this.f57641d, this.f57642e, this.f57643f, view);
    }
}
