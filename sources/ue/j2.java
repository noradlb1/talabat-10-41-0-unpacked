package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;

public final /* synthetic */ class j2 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57589a;

    public /* synthetic */ j2(CheckOutScreen checkOutScreen) {
        this.f57589a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57589a.setFeesDescriptions((FeesDescriptionsDisplayModel) obj);
    }
}
