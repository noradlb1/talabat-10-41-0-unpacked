package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class t2 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57749a;

    public /* synthetic */ t2(CheckOutScreen checkOutScreen) {
        this.f57749a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57749a.updateOpenForceCVVBottomSheetStatus(((Boolean) obj).booleanValue());
    }
}
