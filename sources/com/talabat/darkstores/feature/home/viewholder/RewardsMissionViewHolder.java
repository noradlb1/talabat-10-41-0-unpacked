package com.talabat.darkstores.feature.home.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.RewardsMissionItemData;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/home/viewholder/RewardsMissionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/talabat/darkstores/feature/home/RewardsMissionItemData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RewardsMissionViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public final void bind(@NotNull RewardsMissionItemData rewardsMissionItemData) {
        Intrinsics.checkNotNullParameter(rewardsMissionItemData, "item");
        ((RewardsMissionView) this.itemView.findViewById(R.id.rewardsMissionView)).setChainId(rewardsMissionItemData.getChainId());
    }
}
