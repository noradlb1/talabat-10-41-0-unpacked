package com.talabat.sdsquad.ui.vendorslist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionsViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.InlineAdViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.SwimlanesViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.ToggleHeaderViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorCardViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000bJ\u0014\u0010 \u001a\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/VendorsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "mCollectionClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "mIsListView", "", "mToggleClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "mVendorClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "mVendorDisplayModelList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCollectionListener", "collectionClickListener", "setToggleListener", "toggleClickListener", "setVednorClickListener", "clickLisneter", "setVendorList", "vendorDisplayModelList", "setViewUiType", "isListView", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    private CollectionCellViewHolder.OnCollectionClicked mCollectionClickListener;
    private boolean mIsListView = true;
    @Nullable
    private ToggleHeaderViewHolder.OnHeaderToggleClickListener mToggleClickListener;
    @Nullable
    private VendorViewHolder.VendorClickListener mVendorClickListener;
    @NotNull
    private List<VendorDisplayWrapper> mVendorDisplayModelList = CollectionsKt__CollectionsKt.emptyList();

    public int getItemCount() {
        return this.mVendorDisplayModelList.size();
    }

    public int getItemViewType(int i11) {
        int ordinal = this.mVendorDisplayModelList.get(i11).getType().ordinal();
        if (ordinal != VendorCellType.Vendor.ordinal() || this.mIsListView) {
            return ordinal;
        }
        return VendorCellType.VendorCard.ordinal();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        VendorDisplayWrapper vendorDisplayWrapper = this.mVendorDisplayModelList.get(i11);
        if (viewHolder instanceof VendorViewHolder) {
            VendorDisplayModel vendorDisplayModel = vendorDisplayWrapper.getVendorDisplayModel();
            if (vendorDisplayModel != null) {
                ((VendorViewHolder) viewHolder).bind(vendorDisplayModel);
            }
        } else if (viewHolder instanceof VendorCardViewHolder) {
            VendorDisplayModel vendorDisplayModel2 = vendorDisplayWrapper.getVendorDisplayModel();
            if (vendorDisplayModel2 != null) {
                ((VendorCardViewHolder) viewHolder).bind(vendorDisplayModel2);
            }
        } else if (viewHolder instanceof ToggleHeaderViewHolder) {
            ((ToggleHeaderViewHolder) viewHolder).bind(this.mIsListView);
        } else if (viewHolder instanceof CollectionsViewHolder) {
            ((CollectionsViewHolder) viewHolder).bind(vendorDisplayWrapper.getCollections());
        } else if (viewHolder instanceof SwimlanesViewHolder) {
            ((SwimlanesViewHolder) viewHolder).bind(vendorDisplayWrapper.getSwimlane());
        } else if (viewHolder instanceof InlineAdViewHolder) {
            ((InlineAdViewHolder) viewHolder).bind(vendorDisplayWrapper.getInlineAd());
        } else {
            throw new RuntimeException("No View holder assigned to this type");
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == VendorCellType.ToggleHeader.ordinal()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_header_toggle, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new ToggleHeaderViewHolder(inflate, this.mToggleClickListener);
        } else if (i11 == VendorCellType.Vendor.ordinal()) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_clean, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "view");
            return new VendorViewHolder(inflate2, this.mVendorClickListener);
        } else if (i11 == VendorCellType.VendorCard.ordinal()) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_card, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "view");
            return new VendorCardViewHolder(inflate3, this.mVendorClickListener);
        } else if (i11 == VendorCellType.Collections.ordinal()) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_collections_recycler, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "view");
            return new CollectionsViewHolder(inflate4, this.mCollectionClickListener);
        } else if (i11 == VendorCellType.Swimlane.ordinal()) {
            View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_swimlane, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate5, "view");
            return new SwimlanesViewHolder(inflate5, this.mVendorClickListener);
        } else if (i11 == VendorCellType.InlineAd.ordinal()) {
            View inflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_inlinead, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate6, "view");
            return new InlineAdViewHolder(inflate6);
        } else {
            throw new RuntimeException("No View holder assigned to this type " + i11);
        }
    }

    public final void setCollectionListener(@NotNull CollectionCellViewHolder.OnCollectionClicked onCollectionClicked) {
        Intrinsics.checkNotNullParameter(onCollectionClicked, "collectionClickListener");
        this.mCollectionClickListener = onCollectionClicked;
    }

    public final void setToggleListener(@NotNull ToggleHeaderViewHolder.OnHeaderToggleClickListener onHeaderToggleClickListener) {
        Intrinsics.checkNotNullParameter(onHeaderToggleClickListener, "toggleClickListener");
        this.mToggleClickListener = onHeaderToggleClickListener;
    }

    public final void setVednorClickListener(@NotNull VendorViewHolder.VendorClickListener vendorClickListener) {
        Intrinsics.checkNotNullParameter(vendorClickListener, "clickLisneter");
        this.mVendorClickListener = vendorClickListener;
    }

    public final void setVendorList(@NotNull List<VendorDisplayWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "vendorDisplayModelList");
        this.mVendorDisplayModelList = list;
        notifyDataSetChanged();
    }

    public final void setViewUiType(boolean z11) {
        this.mIsListView = z11;
        notifyDataSetChanged();
    }
}
