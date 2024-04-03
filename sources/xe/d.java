package xe;

import JsonModels.Response.rateOrders.RateReason;
import android.widget.CompoundButton;
import com.talabat.adapters.RateReasonsAdapter;

public final /* synthetic */ class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RateReasonsAdapter f57982b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RateReason f57983c;

    public /* synthetic */ d(RateReasonsAdapter rateReasonsAdapter, RateReason rateReason) {
        this.f57982b = rateReasonsAdapter;
        this.f57983c = rateReason;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f57982b.lambda$onBindViewHolder$1(this.f57983c, compoundButton, z11);
    }
}
