package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;
import com.talabat.domain.address.Address;

public final /* synthetic */ class z8 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57860c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Address f57861d;

    public /* synthetic */ z8(HomeScreenMap homeScreenMap, Address address, Address address2) {
        this.f57859b = homeScreenMap;
        this.f57860c = address;
        this.f57861d = address2;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9482updateAddressPopup$lambda25(this.f57859b, this.f57860c, this.f57861d, dialogInterface, i11);
    }
}
