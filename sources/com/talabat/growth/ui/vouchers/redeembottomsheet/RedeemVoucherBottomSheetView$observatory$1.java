package com.talabat.growth.ui.vouchers.redeembottomsheet;

import com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherBottomSheetView$observatory$1 extends Lambda implements Function1<Pair<? extends Boolean, ? extends RedeemVoucherBottomSheetDisplayModel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetView f60731g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemVoucherBottomSheetView$observatory$1(RedeemVoucherBottomSheetView redeemVoucherBottomSheetView) {
        super(1);
        this.f60731g = redeemVoucherBottomSheetView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, RedeemVoucherBottomSheetDisplayModel>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<Boolean, RedeemVoucherBottomSheetDisplayModel> pair) {
        RedeemVoucherBottomSheetView redeemVoucherBottomSheetView = this.f60731g;
        RedeemVoucherBottomSheetDisplayModel redeemVoucherBottomSheetDisplayModel = null;
        Boolean first = pair != null ? pair.getFirst() : null;
        if (pair != null) {
            redeemVoucherBottomSheetDisplayModel = pair.getSecond();
        }
        redeemVoucherBottomSheetView.showResult(first, redeemVoucherBottomSheetDisplayModel);
    }
}
