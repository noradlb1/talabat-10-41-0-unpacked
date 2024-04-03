package com.talabat.growth.ui.loyalty.burn.list.views;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/views/FeaturedListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/growth/ui/loyalty/burn/list/views/FeatureListViewHolder;", "burnItems", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "itemClickListener", "Lcom/talabat/growth/ui/loyalty/burn/list/views/FeaturedListAdapter$FeaturedListItemClickListener;", "(Ljava/util/List;Lcom/talabat/growth/ui/loyalty/burn/list/views/FeaturedListAdapter$FeaturedListItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FeaturedListItemClickListener", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListAdapter extends RecyclerView.Adapter<FeatureListViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final List<BurnItemDisplayModel> burnItems;
    /* access modifiers changed from: private */
    @Nullable
    public final FeaturedListItemClickListener itemClickListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/views/FeaturedListAdapter$FeaturedListItemClickListener;", "", "onItemClicked", "", "voucherPosition", "", "model", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FeaturedListItemClickListener {
        void onItemClicked(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeaturedListAdapter(List list, FeaturedListItemClickListener featuredListItemClickListener, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? null : featuredListItemClickListener);
    }

    public int getItemCount() {
        return this.burnItems.size();
    }

    public FeaturedListAdapter(@NotNull List<BurnItemDisplayModel> list, @Nullable FeaturedListItemClickListener featuredListItemClickListener) {
        Intrinsics.checkNotNullParameter(list, "burnItems");
        this.burnItems = list;
        this.itemClickListener = featuredListItemClickListener;
    }

    public void onBindViewHolder(@NotNull FeatureListViewHolder featureListViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(featureListViewHolder, "holder");
        featureListViewHolder.populate(this.burnItems.get(i11));
        featureListViewHolder.setOnClickListener(new FeaturedListAdapter$onBindViewHolder$1$1(this, i11));
    }

    @NotNull
    public FeatureListViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new FeatureListViewHolder(viewGroup);
    }
}
