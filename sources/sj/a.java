package sj;

import android.content.DialogInterface;
import com.talabat.darkstores.view.DarkstoresBridgeActivity;
import com.talabat.domain.address.Address;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeActivity f57404b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57405c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f57406d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f57407e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f57408f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f57409g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f57410h;

    public /* synthetic */ a(DarkstoresBridgeActivity darkstoresBridgeActivity, Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f57404b = darkstoresBridgeActivity;
        this.f57405c = address;
        this.f57406d = z11;
        this.f57407e = z12;
        this.f57408f = z13;
        this.f57409g = z14;
        this.f57410h = z15;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DarkstoresBridgeActivity.m10106isMapCompulsory$lambda2(this.f57404b, this.f57405c, this.f57406d, this.f57407e, this.f57408f, this.f57409g, this.f57410h, dialogInterface, i11);
    }
}
