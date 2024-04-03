package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.databinding.DefaultCardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/DefaultItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/DefaultCardBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/DefaultCardBinding;)V", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final DefaultCardBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultItemViewHolder(@NotNull DefaultCardBinding defaultCardBinding) {
        super(defaultCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(defaultCardBinding, "binding");
        this.binding = defaultCardBinding;
    }
}
