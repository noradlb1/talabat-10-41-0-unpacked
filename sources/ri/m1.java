package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartListAdapter;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;

public final /* synthetic */ class m1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter.DisclaimerViewHolder f57323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DisclaimerBannerView f57324c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f57325d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57326e;

    public /* synthetic */ m1(CartListAdapter.DisclaimerViewHolder disclaimerViewHolder, DisclaimerBannerView disclaimerBannerView, CartListAdapter cartListAdapter, String str) {
        this.f57323b = disclaimerViewHolder;
        this.f57324c = disclaimerBannerView;
        this.f57325d = cartListAdapter;
        this.f57326e = str;
    }

    public final void onClick(View view) {
        CartListAdapter.DisclaimerViewHolder.m9830bind$lambda2$lambda0(this.f57323b, this.f57324c, this.f57325d, this.f57326e, view);
    }
}
