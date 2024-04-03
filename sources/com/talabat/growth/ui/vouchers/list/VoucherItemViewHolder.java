package com.talabat.growth.ui.vouchers.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.designsystem.ds_icon_button.DSIconButton;
import com.designsystem.ds_icon_button.DSIconButtonSize;
import com.designsystem.ds_list_item_v2.DSListItem;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.R;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import com.talabat.talabatcore.BaseViewHolder;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0002J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VoucherItemViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "parentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "showTheVoucherCellArrow", "itemView", "Landroid/view/View;", "getVoucherIcon", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemViewHolder extends BaseViewHolder<VoucherItemDisplayModel> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VouchersStatusFilter.values().length];
            iArr[VouchersStatusFilter.ACTIVE.ordinal()] = 1;
            iArr[VouchersStatusFilter.EXPIRED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VoucherOptionType.values().length];
            iArr2[VoucherOptionType.LOYALTY.ordinal()] = 1;
            iArr2[VoucherOptionType.VOUCHER_CODE.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherItemViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_voucher_item);
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    private final int getVoucherIcon(VoucherOptionType voucherOptionType) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[voucherOptionType.ordinal()];
        if (i11 == 1) {
            return com.designsystem.marshmallow.R.drawable.ds_reward;
        }
        if (i11 != 2) {
            return com.designsystem.marshmallow.R.drawable.ds_voucher;
        }
        return com.designsystem.marshmallow.R.drawable.ds_voucher;
    }

    private final void showTheVoucherCellArrow(VoucherItemDisplayModel voucherItemDisplayModel, View view) {
        if (voucherItemDisplayModel.getVoucherOptionType() == VoucherOptionType.NFP || (!StringsKt__StringsJVMKt.isBlank(voucherItemDisplayModel.getVoucherDeepLink()))) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            DSIconButton dSIconButton = new DSIconButton(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSIconButton.setIcon(Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_chevron_forward));
            dSIconButton.setSize(DSIconButtonSize.NORMAL);
            ((DSListItem) view.findViewById(R.id.voucherListItem)).setTrailingView(dSIconButton);
            return;
        }
        ((DSListItem) view.findViewById(R.id.voucherListItem)).setTrailingView((View) null);
    }

    public void populate(@NotNull VoucherItemDisplayModel voucherItemDisplayModel) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(voucherItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        LogManager.debug("populate() >> " + voucherItemDisplayModel);
        DSListItem dSListItem = (DSListItem) this.itemView.findViewById(R.id.voucherListItem);
        dSListItem.setLabel(voucherItemDisplayModel.getTitle());
        dSListItem.setDescriptor(voucherItemDisplayModel.getSubtitle());
        dSListItem.setLeadingIcon(Integer.valueOf(getVoucherIcon(voucherItemDisplayModel.getVoucherOptionType())));
        int i11 = WhenMappings.$EnumSwitchMapping$0[voucherItemDisplayModel.getStatus().ordinal()];
        if (i11 == 1) {
            bool = Boolean.TRUE;
        } else if (i11 != 2) {
            bool = Boolean.FALSE;
        } else {
            bool = Boolean.FALSE;
        }
        dSListItem.setEnabled(bool);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        showTheVoucherCellArrow(voucherItemDisplayModel, view);
    }
}
