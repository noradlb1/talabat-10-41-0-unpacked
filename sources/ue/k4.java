package ue;

import android.widget.CompoundButton;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class k4 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57606b;

    public /* synthetic */ k4(CheckOutScreen checkOutScreen) {
        this.f57606b = checkOutScreen;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f57606b.lambda$showContactlessFeatureIfAvailable$36(compoundButton, z11);
    }
}
