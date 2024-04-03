package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.adapters.SwimlaneCellAdapter;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.utils.HorizontalSpaceDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/SwimlanesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;)V", "getContainerView", "()Landroid/view/View;", "decoration", "Lcom/talabat/sdsquad/utils/HorizontalSpaceDecoration;", "bind", "", "swimlane", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final VendorViewHolder.VendorClickListener clickListener;
    @NotNull
    private final View containerView;
    @NotNull
    private final HorizontalSpaceDecoration decoration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwimlanesViewHolder(@NotNull View view, @Nullable VendorViewHolder.VendorClickListener vendorClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = vendorClickListener;
        Resources resources = getContainerView().getContext().getResources();
        int i11 = R.dimen.space_16dp;
        this.decoration = new HorizontalSpaceDecoration(resources.getDimensionPixelOffset(i11), getContainerView().getContext().getResources().getDimensionPixelOffset(i11));
    }

    public final void bind(@Nullable SwimlaneDisplayModel swimlaneDisplayModel) {
        if (swimlaneDisplayModel != null) {
            ((TextView) getContainerView().findViewById(R.id.swimlaneTitle)).setText(swimlaneDisplayModel.getTitle());
            View containerView2 = getContainerView();
            int i11 = R.id.swimlaneList;
            ((RecyclerView) containerView2.findViewById(i11)).setLayoutManager(new LinearLayoutManager(getContainerView().getContext(), 0, false));
            ((RecyclerView) getContainerView().findViewById(i11)).removeItemDecoration(this.decoration);
            ((RecyclerView) getContainerView().findViewById(i11)).addItemDecoration(this.decoration);
            RecyclerView recyclerView = (RecyclerView) getContainerView().findViewById(i11);
            Context context = getContainerView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
            List<VendorDisplayModel> restaurants = swimlaneDisplayModel.getRestaurants();
            if (restaurants == null) {
                restaurants = CollectionsKt__CollectionsKt.emptyList();
            }
            recyclerView.setAdapter(new SwimlaneCellAdapter(context, restaurants, this.clickListener));
        }
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
