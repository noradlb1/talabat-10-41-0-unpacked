package ue;

import android.view.View;
import com.talabat.CartScreen;
import com.talabat.domain.address.Address;

public final /* synthetic */ class l1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57618b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57619c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57620d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57621e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f57622f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f57623g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f57624h;

    public /* synthetic */ l1(CartScreen cartScreen, Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f57618b = cartScreen;
        this.f57619c = address;
        this.f57620d = z11;
        this.f57621e = z12;
        this.f57622f = z13;
        this.f57623g = z14;
        this.f57624h = z15;
    }

    public final void onClick(View view) {
        this.f57618b.lambda$isGrlRestaurantRedirect$15(this.f57619c, this.f57620d, this.f57621e, this.f57622f, this.f57623g, this.f57624h, view);
    }
}
