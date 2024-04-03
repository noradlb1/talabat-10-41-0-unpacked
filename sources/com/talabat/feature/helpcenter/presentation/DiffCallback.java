package com.talabat.feature.helpcenter.presentation;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiffCallback extends DiffUtil.ItemCallback<CancellationPolicyItemDisplayModel> {
    @NotNull
    public static final DiffCallback INSTANCE = new DiffCallback();

    private DiffCallback() {
    }

    public boolean areContentsTheSame(@NotNull CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel, @NotNull CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel2) {
        Intrinsics.checkNotNullParameter(cancellationPolicyItemDisplayModel, "oldItem");
        Intrinsics.checkNotNullParameter(cancellationPolicyItemDisplayModel2, "newItem");
        return Intrinsics.areEqual((Object) cancellationPolicyItemDisplayModel, (Object) cancellationPolicyItemDisplayModel2);
    }

    public boolean areItemsTheSame(@NotNull CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel, @NotNull CancellationPolicyItemDisplayModel cancellationPolicyItemDisplayModel2) {
        Intrinsics.checkNotNullParameter(cancellationPolicyItemDisplayModel, "oldItem");
        Intrinsics.checkNotNullParameter(cancellationPolicyItemDisplayModel2, "newItem");
        return Intrinsics.areEqual((Object) cancellationPolicyItemDisplayModel, (Object) cancellationPolicyItemDisplayModel2);
    }
}
