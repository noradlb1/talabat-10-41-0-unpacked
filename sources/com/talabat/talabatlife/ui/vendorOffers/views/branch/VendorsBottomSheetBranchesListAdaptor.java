package com.talabat.talabatlife.ui.vendorOffers.views.branch;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorsBottomSheetBranchesListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/talabatlife/ui/vendorOffers/views/branch/VendorBottomSheetBranchViewHolder;", "branches", "", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "(Ljava/util/List;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemCount", "", "onAttachedToRecyclerView", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsBottomSheetBranchesListAdaptor extends RecyclerView.Adapter<VendorBottomSheetBranchViewHolder> {
    @NotNull
    private List<VendorBranchDisplayModel> branches;
    @Nullable
    private RecyclerView recyclerView;

    public VendorsBottomSheetBranchesListAdaptor() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorsBottomSheetBranchesListAdaptor(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public int getItemCount() {
        return this.branches.size();
    }

    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public void onBindViewHolder(@NotNull VendorBottomSheetBranchViewHolder vendorBottomSheetBranchViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(vendorBottomSheetBranchViewHolder, "holder");
        vendorBottomSheetBranchViewHolder.populate(this.branches.get(i11));
    }

    @NotNull
    public VendorBottomSheetBranchViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new VendorBottomSheetBranchViewHolder(viewGroup);
    }

    public VendorsBottomSheetBranchesListAdaptor(@NotNull List<VendorBranchDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "branches");
        this.branches = list;
    }
}
