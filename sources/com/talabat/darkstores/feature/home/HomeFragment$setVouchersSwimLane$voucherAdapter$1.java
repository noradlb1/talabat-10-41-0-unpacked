package com.talabat.darkstores.feature.home;

import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.homescreen.network.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "voucher", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "pos", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$setVouchersSwimLane$voucherAdapter$1 extends Lambda implements Function2<CustomerVoucher, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56402g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$setVouchersSwimLane$voucherAdapter$1(HomeFragment homeFragment) {
        super(2);
        this.f56402g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CustomerVoucher) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CustomerVoucher customerVoucher, int i11) {
        Intrinsics.checkNotNullParameter(customerVoucher, UrlConstantsKt.HEADER_VOUCHER);
        this.f56402g.getViewModel().trackVoucherSwimLaneClicked(this.f56402g.getScreenName(), i11, customerVoucher.getCampaignTitle());
        this.f56402g.loadVoucherDetails((String) CollectionsKt___CollectionsKt.firstOrNull(customerVoucher.getSkuIds()), customerVoucher.getId(), customerVoucher.getVoucherType());
    }
}
