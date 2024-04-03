package com.talabat.sdsquad.ui.vendorslist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/CollectionCellAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mCollectionDisplayModel", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "(Landroid/content/Context;Ljava/util/List;)V", "mCollectionClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCollectionClickListener", "collectionClickListener", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionCellAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    private CollectionCellViewHolder.OnCollectionClicked mCollectionClickListener;
    @NotNull
    private final List<CollectionDisplayModel> mCollectionDisplayModel;
    @NotNull
    private final Context mContext;

    public CollectionCellAdapter(@NotNull Context context, @NotNull List<CollectionDisplayModel> list) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(list, "mCollectionDisplayModel");
        this.mContext = context;
        this.mCollectionDisplayModel = list;
    }

    public int getItemCount() {
        return this.mCollectionDisplayModel.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((CollectionCellViewHolder) viewHolder).bind(this.mCollectionDisplayModel.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.item_collection, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CollectionCellViewHolder(inflate, this.mCollectionClickListener);
    }

    public final void setCollectionClickListener(@Nullable CollectionCellViewHolder.OnCollectionClicked onCollectionClicked) {
        this.mCollectionClickListener = onCollectionClicked;
    }
}
