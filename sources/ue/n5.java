package ue;

import android.content.DialogInterface;
import com.talabat.ChooseSavedAddressScreen;

public final /* synthetic */ class n5 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressScreen f57661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57662c;

    public /* synthetic */ n5(ChooseSavedAddressScreen chooseSavedAddressScreen, int i11) {
        this.f57661b = chooseSavedAddressScreen;
        this.f57662c = i11;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        ChooseSavedAddressScreen.m9411changeCountryAlert$lambda9(this.f57661b, this.f57662c, dialogInterface, i11);
    }
}
