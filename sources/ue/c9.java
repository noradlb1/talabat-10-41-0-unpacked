package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;
import com.talabat.domain.address.Address;
import com.talabat.maps.domain.model.LatLng;
import datamodels.Area;

public final /* synthetic */ class c9 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Area f57469c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Address f57470d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ LatLng f57471e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Float f57472f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f57473g;

    public /* synthetic */ c9(HomeScreenMap homeScreenMap, Area area, Address address, LatLng latLng, Float f11, String str) {
        this.f57468b = homeScreenMap;
        this.f57469c = area;
        this.f57470d = address;
        this.f57471e = latLng;
        this.f57472f = f11;
        this.f57473g = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9463clearCart$lambda17(this.f57468b, this.f57469c, this.f57470d, this.f57471e, this.f57472f, this.f57473g, dialogInterface, i11);
    }
}
