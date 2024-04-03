package com.talabat.growth.ui.loyalty.views;

import android.view.ViewGroup;
import android.widget.TextView;
import com.designsystem.ds_list_item_v2.DSListItem;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/loyalty/views/LoyaltyPointsHistoryItemViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsHistoryItemViewHolder extends BaseViewHolder<LoyaltyPointsDisplayModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyPointsHistoryItemViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_loyalty_points_history_item);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public void populate(@NotNull LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        Intrinsics.checkNotNullParameter(loyaltyPointsDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        DSListItem dSListItem = (DSListItem) this.itemView.findViewById(R.id.historyPointListItem);
        dSListItem.setLabel(loyaltyPointsDisplayModel.getTitle());
        dSListItem.setDescriptor(loyaltyPointsDisplayModel.getDate());
        dSListItem.setLeadingIcon(Integer.valueOf(loyaltyPointsDisplayModel.getIcon()));
        TextView textView = new TextView(dSListItem.getContext());
        textView.setText(loyaltyPointsDisplayModel.getPoints());
        textView.setTextAppearance(com.designsystem.marshmallow.R.style.DSTextAppearance_Subheading1);
        dSListItem.setTrailingView(textView);
    }
}
