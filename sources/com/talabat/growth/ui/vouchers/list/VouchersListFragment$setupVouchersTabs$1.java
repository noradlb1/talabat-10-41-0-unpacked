package com.talabat.growth.ui.vouchers.list;

import com.designsystem.ds_tabs.DSTabItemModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dsTabItemModel", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VouchersListFragment$setupVouchersTabs$1 extends Lambda implements Function1<DSTabItemModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VouchersListFragment f60725g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersListFragment$setupVouchersTabs$1(VouchersListFragment vouchersListFragment) {
        super(1);
        this.f60725g = vouchersListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSTabItemModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSTabItemModel dSTabItemModel) {
        Intrinsics.checkNotNullParameter(dSTabItemModel, "dsTabItemModel");
        int id2 = dSTabItemModel.getId();
        if (id2 == 1) {
            this.f60725g.callApiForFilter(VouchersStatusFilter.ACTIVE);
        } else if (id2 == 2) {
            this.f60725g.callApiForFilter(VouchersStatusFilter.USED);
        } else if (id2 != 3) {
            this.f60725g.callApiForFilter(VouchersStatusFilter.ACTIVE);
        } else {
            this.f60725g.callApiForFilter(VouchersStatusFilter.EXPIRED);
        }
    }
}
