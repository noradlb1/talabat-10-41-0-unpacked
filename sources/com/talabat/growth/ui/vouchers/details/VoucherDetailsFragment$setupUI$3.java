package com.talabat.growth.ui.vouchers.details;

import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailsFragment$setupUI$3 extends Lambda implements Function1<VoucherDetailDomainModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VoucherDetailsFragment f60697g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherDetailsFragment$setupUI$3(VoucherDetailsFragment voucherDetailsFragment) {
        super(1);
        this.f60697g = voucherDetailsFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VoucherDetailDomainModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VoucherDetailDomainModel voucherDetailDomainModel) {
        if (voucherDetailDomainModel != null) {
            this.f60697g.populateUi(voucherDetailDomainModel);
        }
    }
}
