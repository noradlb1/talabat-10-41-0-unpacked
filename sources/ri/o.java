package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartFragment;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragment f57332b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeeDescription f57333c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57334d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57335e;

    public /* synthetic */ o(CartFragment cartFragment, FeeDescription feeDescription, int i11, String str) {
        this.f57332b = cartFragment;
        this.f57333c = feeDescription;
        this.f57334d = i11;
        this.f57335e = str;
    }

    public final void onClick(View view) {
        CartFragment.m9781setupFeeInfoButton$lambda14(this.f57332b, this.f57333c, this.f57334d, this.f57335e, view);
    }
}
