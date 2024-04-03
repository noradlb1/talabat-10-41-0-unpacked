package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.benefits.adapter.favoritevendors.FavoriteVendorsAdapter;
import com.talabat.feature.tpro.presentation.databinding.ItemYourFavoritesSectionBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/YourFavoritesSectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemYourFavoritesSectionBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemYourFavoritesSectionBinding;)V", "bind", "", "adapter", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/favoritevendors/FavoriteVendorsAdapter;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class YourFavoritesSectionViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemYourFavoritesSectionBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YourFavoritesSectionViewHolder(@NotNull ItemYourFavoritesSectionBinding itemYourFavoritesSectionBinding) {
        super(itemYourFavoritesSectionBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemYourFavoritesSectionBinding, "binding");
        this.binding = itemYourFavoritesSectionBinding;
    }

    public final void bind(@NotNull FavoriteVendorsAdapter favoriteVendorsAdapter, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(favoriteVendorsAdapter, "adapter");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.binding.rvFavoriteVendors.setAdapter(favoriteVendorsAdapter);
        this.binding.rvFavoriteVendors.setLayoutManager(linearLayoutManager);
    }
}
