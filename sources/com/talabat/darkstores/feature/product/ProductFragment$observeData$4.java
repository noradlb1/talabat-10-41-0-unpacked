package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.product.models.CampaignAddedQuantity;
import com.talabat.darkstores.feature.product.models.CampaignFreeQuantity;
import com.talabat.darkstores.feature.product.views.CampaignProgressView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeData$4 extends Lambda implements Function1<Pair<? extends CampaignAddedQuantity, ? extends CampaignFreeQuantity>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56479g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeData$4(ProductFragment productFragment) {
        super(1);
        this.f56479g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<CampaignAddedQuantity, CampaignFreeQuantity>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Pair<CampaignAddedQuantity, CampaignFreeQuantity> pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        ((CampaignProgressView) this.f56479g._$_findCachedViewById(R.id.campaignProgressView)).onQuantityChanged(pair);
    }
}
