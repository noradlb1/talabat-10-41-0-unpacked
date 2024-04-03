package af;

import JsonModels.Response.PreviousOrderList.PreviousOrder;
import android.view.View;
import com.talabat.adapters.previousorders.PreviousOrderAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreviousOrderAdapter f50818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PreviousOrder f50819c;

    public /* synthetic */ a(PreviousOrderAdapter previousOrderAdapter, PreviousOrder previousOrder) {
        this.f50818b = previousOrderAdapter;
        this.f50819c = previousOrder;
    }

    public final void onClick(View view) {
        PreviousOrderAdapter.PreviousOrderViewHolder.m9505setUIActions$lambda2$lambda1(this.f50818b, this.f50819c, view);
    }
}
