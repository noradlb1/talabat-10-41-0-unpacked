package qw;

import android.view.View;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.PaymentOfferViewHolder;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f24078b;

    public /* synthetic */ a(Function0 function0) {
        this.f24078b = function0;
    }

    public final void onClick(View view) {
        PaymentOfferViewHolder.m5868setItemEnabled$lambda1(this.f24078b, view);
    }
}
