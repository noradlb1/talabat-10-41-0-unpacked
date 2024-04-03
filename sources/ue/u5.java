package ue;

import android.content.DialogInterface;
import com.talabat.ChooseSavedAddressScreen;
import com.talabat.domain.address.Address;

public final /* synthetic */ class u5 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f57771b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Address f57772c;

    public /* synthetic */ u5(ChooseSavedAddressScreen chooseSavedAddressScreen, Address address) {
        this.f57771b = chooseSavedAddressScreen;
        this.f57772c = address;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        ChooseSavedAddressScreen.m9412clearCart$lambda3(this.f57771b, this.f57772c, dialogInterface, i11);
    }
}
