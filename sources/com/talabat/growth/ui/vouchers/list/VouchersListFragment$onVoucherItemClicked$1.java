package com.talabat.growth.ui.vouchers.list;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "voucherItemDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VouchersListFragment$onVoucherItemClicked$1 extends Lambda implements Function1<VoucherItemDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VouchersListFragment f60723g;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoucherOptionType.values().length];
            iArr[VoucherOptionType.NONE.ordinal()] = 1;
            iArr[VoucherOptionType.NFP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersListFragment$onVoucherItemClicked$1(VouchersListFragment vouchersListFragment) {
        super(1);
        this.f60723g = vouchersListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VoucherItemDisplayModel) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r7 = r6.f60723g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel r7) {
        /*
            r6 = this;
            java.lang.String r0 = "voucherItemDisplayModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r0 = r7.getVoucherOptionType()
            int[] r1 = com.talabat.growth.ui.vouchers.list.VouchersListFragment$onVoucherItemClicked$1.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0049
            r2 = 2
            if (r0 == r2) goto L_0x0040
            java.lang.String r7 = r7.getVoucherDeepLink()
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r7)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            r1 = r7
            if (r1 == 0) goto L_0x0049
            com.talabat.growth.ui.vouchers.list.VouchersListFragment r7 = r6.f60723g
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x0049
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager r3 = r7.getObservabilityManager()
            r4 = 4
            r5 = 0
            com.talabat.growth.ui.util.DeepLinkUtilKt.redirectToDeepLink$default(r0, r1, r2, r3, r4, r5)
            goto L_0x0049
        L_0x0040:
            com.talabat.growth.ui.vouchers.list.VouchersListFragment r0 = r6.f60723g
            java.lang.String r7 = r7.getCustomerVoucherId()
            r0.navigateToVoucherDetails(r7)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.vouchers.list.VouchersListFragment$onVoucherItemClicked$1.invoke(com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel):void");
    }
}
