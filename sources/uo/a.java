package uo;

import android.widget.CompoundButton;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62946b;

    public /* synthetic */ a(Function1 function1) {
        this.f62946b = function1;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        SubscriptionAtCheckoutBannerView.m10372setOnCheckedChangeListenerForCheckout$lambda4(this.f62946b, compoundButton, z11);
    }
}
