package com.talabat.feature.tpro.presentation.benefits.adapter.carousel.viewholder;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.databinding.ItemCarouselViewBinding;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/viewholder/CarouselImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemCarouselViewBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemCarouselViewBinding;)V", "bind", "", "uri", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CarouselImageViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemCarouselViewBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselImageViewHolder(@NotNull ItemCarouselViewBinding itemCarouselViewBinding) {
        super(itemCarouselViewBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemCarouselViewBinding, "binding");
        this.binding = itemCarouselViewBinding;
    }

    public final void bind(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        ImageView imageView = this.binding.carouselItem;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.carouselItem");
        ImageViewExtensionsKt.loadImage$default(imageView, str, (Function1) null, 2, (Object) null);
    }
}
