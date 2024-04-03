package ue;

import android.content.DialogInterface;
import com.talabat.HomeScreenMap;
import com.talabat.domain.address.Address;

public final /* synthetic */ class a9 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f57434b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57435c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Address f57436d;

    public /* synthetic */ a9(HomeScreenMap homeScreenMap, Address address, Address address2) {
        this.f57434b = homeScreenMap;
        this.f57435c = address;
        this.f57436d = address2;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        HomeScreenMap.m9483updateAddressPopup$lambda26(this.f57434b, this.f57435c, this.f57436d, dialogInterface, i11);
    }
}
