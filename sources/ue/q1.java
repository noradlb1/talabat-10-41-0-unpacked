package ue;

import android.widget.CompoundButton;
import library.talabat.mvp.cart.CartAdapterListener;

public final /* synthetic */ class q1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartAdapterListener f57701b;

    public /* synthetic */ q1(CartAdapterListener cartAdapterListener) {
        this.f57701b = cartAdapterListener;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f57701b.setNoCutlerySelection(compoundButton.isChecked());
    }
}
