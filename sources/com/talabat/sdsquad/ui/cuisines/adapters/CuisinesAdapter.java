package com.talabat.sdsquad.ui.cuisines.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.cuisines.adapters.viewholders.CuisineViewHolder;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0006J\u0014\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/adapters/CuisinesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "()V", "mCuisineClickListener", "Lcom/talabat/sdsquad/ui/cuisines/adapters/viewholders/CuisineViewHolder$OnCuisineClickListener;", "mCuisineList", "", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "mFilteredCuisineList", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCuisineClickListener", "listener", "setCuisineList", "cuisineList", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    @Nullable
    private CuisineViewHolder.OnCuisineClickListener mCuisineClickListener;
    /* access modifiers changed from: private */
    @NotNull
    public List<CuisineDisplayModel> mCuisineList = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    @NotNull
    public List<CuisineDisplayModel> mFilteredCuisineList = CollectionsKt__CollectionsKt.emptyList();

    @NotNull
    public Filter getFilter() {
        return new CuisinesAdapter$getFilter$1(this);
    }

    public int getItemCount() {
        return this.mFilteredCuisineList.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((CuisineViewHolder) viewHolder).bind(this.mFilteredCuisineList.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cuisine, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CuisineViewHolder(inflate, this.mCuisineClickListener);
    }

    public final void setCuisineClickListener(@NotNull CuisineViewHolder.OnCuisineClickListener onCuisineClickListener) {
        Intrinsics.checkNotNullParameter(onCuisineClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mCuisineClickListener = onCuisineClickListener;
    }

    public final void setCuisineList(@NotNull List<CuisineDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "cuisineList");
        this.mCuisineList = list;
        this.mFilteredCuisineList = list;
        notifyDataSetChanged();
    }
}
