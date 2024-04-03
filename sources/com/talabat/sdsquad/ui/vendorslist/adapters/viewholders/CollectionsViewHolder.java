package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.adapters.CollectionCellAdapter;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import com.talabat.sdsquad.utils.HorizontalSpaceDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "mCollectionClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;)V", "getContainerView", "()Landroid/view/View;", "decoration", "Lcom/talabat/sdsquad/utils/HorizontalSpaceDecoration;", "bind", "", "collectionDisplayModel", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @NotNull
    private final HorizontalSpaceDecoration decoration = new HorizontalSpaceDecoration(getContainerView().getContext().getResources().getDimensionPixelOffset(R.dimen.space_4dp), getContainerView().getContext().getResources().getDimensionPixelOffset(R.dimen.space_12dp));
    @Nullable
    private final CollectionCellViewHolder.OnCollectionClicked mCollectionClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsViewHolder(@NotNull View view, @Nullable CollectionCellViewHolder.OnCollectionClicked onCollectionClicked) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.mCollectionClickListener = onCollectionClicked;
    }

    public final void bind(@Nullable List<CollectionDisplayModel> list) {
        if (list != null) {
            View containerView2 = getContainerView();
            int i11 = R.id.collectionsRecyclerView;
            ((RecyclerView) containerView2.findViewById(i11)).setLayoutManager(new LinearLayoutManager(getContainerView().getContext(), 0, false));
            ((RecyclerView) getContainerView().findViewById(i11)).removeItemDecoration(this.decoration);
            ((RecyclerView) getContainerView().findViewById(i11)).addItemDecoration(this.decoration);
            Context context = getContainerView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
            CollectionCellAdapter collectionCellAdapter = new CollectionCellAdapter(context, list);
            collectionCellAdapter.setCollectionClickListener(this.mCollectionClickListener);
            ((RecyclerView) getContainerView().findViewById(i11)).setAdapter(collectionCellAdapter);
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
