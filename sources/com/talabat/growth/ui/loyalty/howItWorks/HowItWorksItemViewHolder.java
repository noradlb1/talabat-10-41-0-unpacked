package com.talabat.growth.ui.loyalty.howItWorks;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksItemDisplayModel;
import com.talabat.talabatcore.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/HowItWorksItemViewHolder;", "Lcom/talabat/talabatcore/BaseViewHolder;", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksItemDisplayModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "populate", "", "model", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksItemViewHolder extends BaseViewHolder<HowItWorksItemDisplayModel> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HowItWorksItemViewHolder(@NotNull ViewGroup viewGroup) {
        super(viewGroup, R.layout.view_holder_how_it_works);
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    public void populate(@NotNull HowItWorksItemDisplayModel howItWorksItemDisplayModel) {
        Intrinsics.checkNotNullParameter(howItWorksItemDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        View view = this.itemView;
        ((TextView) view.findViewById(R.id.loyaltyHowItWorksTextView)).setText(howItWorksItemDisplayModel.getTip());
        ((ImageView) view.findViewById(R.id.loyaltyHowItWorksImageView)).setImageResource(howItWorksItemDisplayModel.getIcon());
    }
}
