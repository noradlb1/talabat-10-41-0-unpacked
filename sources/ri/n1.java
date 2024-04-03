package ri;

import android.view.View;
import com.talabat.darkstores.feature.cart.CartListAdapter;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;

public final /* synthetic */ class n1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter.DisclaimerViewHolder f57329b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DisclaimerBannerView f57330c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f57331d;

    public /* synthetic */ n1(CartListAdapter.DisclaimerViewHolder disclaimerViewHolder, DisclaimerBannerView disclaimerBannerView, CartListAdapter cartListAdapter) {
        this.f57329b = disclaimerViewHolder;
        this.f57330c = disclaimerBannerView;
        this.f57331d = cartListAdapter;
    }

    public final void onClick(View view) {
        CartListAdapter.DisclaimerViewHolder.m9831bind$lambda2$lambda1(this.f57329b, this.f57330c, this.f57331d, view);
    }
}
