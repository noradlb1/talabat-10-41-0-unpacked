package com.talabat.feature.tpro.presentation.benefits.adapter.favoritevendors;

import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.talabat.feature.tpro.presentation.databinding.ItemFavoriteVendorBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/favoritevendors/FavoriteVendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemFavoriteVendorBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemFavoriteVendorBinding;)V", "bind", "", "uri", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavoriteVendorViewHolder extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    @NotNull
    public final ItemFavoriteVendorBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoriteVendorViewHolder(@NotNull ItemFavoriteVendorBinding itemFavoriteVendorBinding) {
        super(itemFavoriteVendorBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemFavoriteVendorBinding, "binding");
        this.binding = itemFavoriteVendorBinding;
    }

    public final void bind(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Glide.with(this.binding.vendorImage.getContext()).load(Uri.parse(str)).listener(new FavoriteVendorViewHolder$bind$1(this, str)).into(this.binding.vendorImage);
    }
}
