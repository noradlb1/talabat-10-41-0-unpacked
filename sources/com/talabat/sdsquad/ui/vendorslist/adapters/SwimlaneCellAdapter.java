package com.talabat.sdsquad.ui.vendorslist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.SwimlanesCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/SwimlaneCellAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mVendorList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "clickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneCellAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    private final VendorViewHolder.VendorClickListener clickListener;
    @NotNull
    private final Context mContext;
    @NotNull
    private final List<VendorDisplayModel> mVendorList;

    public SwimlaneCellAdapter(@NotNull Context context, @NotNull List<VendorDisplayModel> list, @Nullable VendorViewHolder.VendorClickListener vendorClickListener) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(list, "mVendorList");
        this.mContext = context;
        this.mVendorList = list;
        this.clickListener = vendorClickListener;
    }

    public int getItemCount() {
        return this.mVendorList.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof SwimlanesCellViewHolder) {
            ((SwimlanesCellViewHolder) viewHolder).bind(this.mVendorList.get(i11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_swimlane_cell, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new SwimlanesCellViewHolder(inflate, this.clickListener);
    }
}
