package com.talabat.feature.helpcenter.presentation;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyAdapter extends ListAdapter<CancellationPolicyItemDisplayModel, CancellationPolicyViewHolder> {
    public CancellationPolicyAdapter() {
        super(DiffCallback.INSTANCE);
    }

    public void onBindViewHolder(@NotNull CancellationPolicyViewHolder cancellationPolicyViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(cancellationPolicyViewHolder, "holder");
        CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel = (CancellationPolicyItemDisplayModel) getItem(cancellationPolicyViewHolder.getAdapterPosition());
        Intrinsics.checkNotNullExpressionValue(cancellationPolicyItemDisplayModel, "cancellationPolicyItemDisplayModel");
        cancellationPolicyViewHolder.populate(cancellationPolicyItemDisplayModel);
    }

    @NotNull
    public CancellationPolicyViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new CancellationPolicyViewHolder(viewGroup);
    }
}
