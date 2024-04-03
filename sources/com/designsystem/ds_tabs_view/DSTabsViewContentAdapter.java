package com.designsystem.ds_tabs_view;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/designsystem/ds_tabs_view/DSTabsViewItemModel;", "()V", "DSTabsViewContentAdapterDiffCallback", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSTabsViewContentAdapter<T, VH extends RecyclerView.ViewHolder> extends ListAdapter<DSTabsViewItemModel<T>, VH> {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003H\u0016J$\u0010\t\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter$DSTabsViewContentAdapterDiffCallback;", "T", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/designsystem/ds_tabs_view/DSTabsViewItemModel;", "()V", "areContentsTheSame", "", "item1", "item2", "areItemsTheSame", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DSTabsViewContentAdapterDiffCallback<T> extends DiffUtil.ItemCallback<DSTabsViewItemModel<T>> {
        public boolean areContentsTheSame(@NotNull DSTabsViewItemModel<T> dSTabsViewItemModel, @NotNull DSTabsViewItemModel<T> dSTabsViewItemModel2) {
            Intrinsics.checkNotNullParameter(dSTabsViewItemModel, "item1");
            Intrinsics.checkNotNullParameter(dSTabsViewItemModel2, "item2");
            return Intrinsics.areEqual((Object) dSTabsViewItemModel, (Object) dSTabsViewItemModel2);
        }

        public boolean areItemsTheSame(@NotNull DSTabsViewItemModel<T> dSTabsViewItemModel, @NotNull DSTabsViewItemModel<T> dSTabsViewItemModel2) {
            Intrinsics.checkNotNullParameter(dSTabsViewItemModel, "item1");
            Intrinsics.checkNotNullParameter(dSTabsViewItemModel2, "item2");
            return dSTabsViewItemModel.getTabModel().getId() == dSTabsViewItemModel2.getTabModel().getId();
        }
    }

    public DSTabsViewContentAdapter() {
        super(new DSTabsViewContentAdapterDiffCallback());
    }
}
