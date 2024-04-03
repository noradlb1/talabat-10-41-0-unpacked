package ui;

import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.feature.cart.multibasket.Cart;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplyDiscountsAndCampaignsUseCase f57885b;

    public /* synthetic */ b(ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        this.f57885b = applyDiscountsAndCampaignsUseCase;
    }

    public final Object apply(Object obj) {
        return this.f57885b.invoke((Cart) obj);
    }
}
