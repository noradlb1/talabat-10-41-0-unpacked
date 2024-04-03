package library.talabat.mvp.cart;

import JsonModels.Response.CouponsAndPromotionsRM;
import com.android.volley.Response;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;

public final /* synthetic */ class k implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26647b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AutoApplyDiscount[] f26648c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f26649d;

    public /* synthetic */ k(CartInteractor cartInteractor, AutoApplyDiscount[] autoApplyDiscountArr, float f11) {
        this.f26647b = cartInteractor;
        this.f26648c = autoApplyDiscountArr;
        this.f26649d = f11;
    }

    public final void onResponse(Object obj) {
        this.f26647b.lambda$onCouponsAndPromotionsReceived$3(this.f26648c, this.f26649d, (CouponsAndPromotionsRM) obj);
    }
}
