package com.talabat.growth.ui.vouchers.list;

import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VouchersListAdapterKt$onItemClick$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<VoucherItemDisplayModel, Unit> f60715g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VoucherItemDisplayModel f60716h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersListAdapterKt$onItemClick$1(Function1<? super VoucherItemDisplayModel, Unit> function1, VoucherItemDisplayModel voucherItemDisplayModel) {
        super(0);
        this.f60715g = function1;
        this.f60716h = voucherItemDisplayModel;
    }

    public final void invoke() {
        Function1<VoucherItemDisplayModel, Unit> function1 = this.f60715g;
        if (function1 != null) {
            function1.invoke(this.f60716h);
        }
    }
}
