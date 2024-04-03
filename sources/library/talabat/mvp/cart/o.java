package library.talabat.mvp.cart;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;

public final /* synthetic */ class o implements Response.ErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AutoApplyDiscount[] f26654c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f26655d;

    public /* synthetic */ o(CartInteractor cartInteractor, AutoApplyDiscount[] autoApplyDiscountArr, float f11) {
        this.f26653b = cartInteractor;
        this.f26654c = autoApplyDiscountArr;
        this.f26655d = f11;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.f26653b.lambda$onCouponsAndPromotionsError$2(this.f26654c, this.f26655d, volleyError);
    }
}
