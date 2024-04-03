package com.talabat.sdsquad.ui.filters.adapters.viewholders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import iu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/FilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/FilterViewHolder$OnFilterClicked;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/FilterViewHolder$OnFilterClicked;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "filter", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "OnFilterClicked", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @Nullable
    private final OnFilterClicked clickListener;
    @NotNull
    private final View containerView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/FilterViewHolder$OnFilterClicked;", "", "filterClicked", "", "filter", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterClicked {
        void filterClicked(@NotNull FilterDisplayModel filterDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterViewHolder(@NotNull View view, @Nullable OnFilterClicked onFilterClicked) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.clickListener = onFilterClicked;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10826bind$lambda0(FilterDisplayModel filterDisplayModel, FilterViewHolder filterViewHolder, View view) {
        Intrinsics.checkNotNullParameter(filterDisplayModel, "$filter");
        Intrinsics.checkNotNullParameter(filterViewHolder, "this$0");
        filterDisplayModel.setOn(!filterDisplayModel.isOn());
        OnFilterClicked onFilterClicked = filterViewHolder.clickListener;
        if (onFilterClicked != null) {
            onFilterClicked.filterClicked(filterDisplayModel);
        }
    }

    public final void bind(@NotNull FilterDisplayModel filterDisplayModel) {
        Intrinsics.checkNotNullParameter(filterDisplayModel, "filter");
        ((TextView) getContainerView().findViewById(R.id.textView_filterName)).setText(filterDisplayModel.getName());
        ((CheckBox) getContainerView().findViewById(R.id.switch_filter)).setChecked(filterDisplayModel.isOn());
        getContainerView().setOnClickListener(new a(filterDisplayModel, this));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
