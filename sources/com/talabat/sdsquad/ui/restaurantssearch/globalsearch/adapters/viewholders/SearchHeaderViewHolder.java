package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.viewholders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/viewholders/SearchHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "headerType", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchCellType;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "itemCount", "", "(Ljava/lang/Integer;)V", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchHeaderViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @NotNull
    private final GlobalSearchCellType headerType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchHeaderViewHolder(@NotNull View view, @NotNull GlobalSearchCellType globalSearchCellType) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(globalSearchCellType, "headerType");
        this.containerView = view;
        this.headerType = globalSearchCellType;
    }

    public final void bind(@Nullable Integer num) {
        if (this.headerType.getType() == GlobalSearchCellType.VendorHeader.getType()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d %s", Arrays.copyOf(new Object[]{num, "restaurants found"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) getContainerView().findViewById(R.id.searchResultCount)).setText(format);
            return;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%d %s", Arrays.copyOf(new Object[]{num, "dishes found"}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        ((TextView) getContainerView().findViewById(R.id.searchResultCount)).setText(format2);
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
