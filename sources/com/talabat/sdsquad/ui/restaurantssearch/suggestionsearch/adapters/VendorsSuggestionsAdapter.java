package com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.viewholders.VendorSuggestionViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/VendorsSuggestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "mSuggestionsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "mVendorClickListener", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder$VendorClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSuggestionsList", "suggestionsList", "setVendorClickListener", "clickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsSuggestionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<VendorDisplayModel> mSuggestionsList = CollectionsKt__CollectionsKt.emptyList();
    @Nullable
    private VendorSuggestionViewHolder.VendorClickListener mVendorClickListener;

    public int getItemCount() {
        return this.mSuggestionsList.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((VendorSuggestionViewHolder) viewHolder).bind(this.mSuggestionsList.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_suggestion, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new VendorSuggestionViewHolder(inflate, this.mVendorClickListener);
    }

    public final void setSuggestionsList(@NotNull List<VendorDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "suggestionsList");
        this.mSuggestionsList = list;
        notifyDataSetChanged();
    }

    public final void setVendorClickListener(@NotNull VendorSuggestionViewHolder.VendorClickListener vendorClickListener) {
        Intrinsics.checkNotNullParameter(vendorClickListener, "clickListener");
        this.mVendorClickListener = vendorClickListener;
    }
}
