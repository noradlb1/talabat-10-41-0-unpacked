package vi;

import android.view.View;
import com.talabat.darkstores.data.partialFulfillment.model.Control;
import com.talabat.darkstores.feature.cart.partialFulfillment.PartialFulfillmentAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PartialFulfillmentAdapter f57906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Control f57907c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57908d;

    public /* synthetic */ a(PartialFulfillmentAdapter partialFulfillmentAdapter, Control control, int i11) {
        this.f57906b = partialFulfillmentAdapter;
        this.f57907c = control;
        this.f57908d = i11;
    }

    public final void onClick(View view) {
        PartialFulfillmentAdapter.m9846onBindViewHolder$lambda0(this.f57906b, this.f57907c, this.f57908d, view);
    }
}
