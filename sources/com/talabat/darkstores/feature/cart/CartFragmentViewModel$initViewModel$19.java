package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.CartResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel$initViewModel$19 extends Lambda implements Function1<CartResponse, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f56264g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartFragmentViewModel$initViewModel$19(CartFragmentViewModel cartFragmentViewModel) {
        super(1);
        this.f56264g = cartFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CartResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CartResponse cartResponse) {
        this.f56264g.campaignProgressUseCase.updateCampaignProgress(cartResponse.getTotal(), cartResponse.getAbsoluteDiscount(), cartResponse.getDeliveryAbsoluteDiscount(), cartResponse.getSubtotal(), cartResponse.getSubtotalAfterDiscount(), cartResponse.getCampaignProgress());
    }
}
