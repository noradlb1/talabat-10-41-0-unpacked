package com.talabat.growth.ui.loyalty.howItWorks;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/HowItWorksListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/growth/ui/loyalty/howItWorks/HowItWorksItemViewHolder;", "pointsItems", "", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksItemDisplayModel;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksListAdaptor extends RecyclerView.Adapter<HowItWorksItemViewHolder> {
    @NotNull
    private List<HowItWorksItemDisplayModel> pointsItems;

    public HowItWorksListAdaptor() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HowItWorksListAdaptor(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public int getItemCount() {
        return this.pointsItems.size();
    }

    public void onBindViewHolder(@NotNull HowItWorksItemViewHolder howItWorksItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(howItWorksItemViewHolder, "viewHolder");
        howItWorksItemViewHolder.populate(this.pointsItems.get(i11));
    }

    @NotNull
    public HowItWorksItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new HowItWorksItemViewHolder(viewGroup);
    }

    public HowItWorksListAdaptor(@NotNull List<HowItWorksItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "pointsItems");
        this.pointsItems = list;
    }
}
