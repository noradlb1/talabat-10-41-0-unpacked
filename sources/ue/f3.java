package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ForceCVVBottomSheetDisplayModel;

public final /* synthetic */ class f3 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57522a;

    public /* synthetic */ f3(CheckOutScreen checkOutScreen) {
        this.f57522a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57522a.openForceCVVUpdate((ForceCVVBottomSheetDisplayModel) obj);
    }
}
