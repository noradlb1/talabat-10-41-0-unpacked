package library.talabat.mvp.cart;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26632c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f26633d;

    public /* synthetic */ b(CartInteractor cartInteractor, int i11, float f11) {
        this.f26631b = cartInteractor;
        this.f26632c = i11;
        this.f26633d = f11;
    }

    public final void accept(Object obj) {
        this.f26631b.lambda$loadCouponsAndPromotions$0(this.f26632c, this.f26633d, (AutoApplyDiscount[]) obj);
    }
}
