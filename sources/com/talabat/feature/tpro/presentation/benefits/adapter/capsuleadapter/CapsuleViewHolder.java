package com.talabat.feature.tpro.presentation.benefits.adapter.capsuleadapter;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardCapsulesContentModel;
import com.talabat.feature.tpro.presentation.databinding.ItemCapsuleViewBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/capsuleadapter/CapsuleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemCapsuleViewBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemCapsuleViewBinding;)V", "bind", "", "tProOnBoardingCardCapsulesContentModel", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardCapsulesContentModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CapsuleViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemCapsuleViewBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CapsuleViewHolder(@NotNull ItemCapsuleViewBinding itemCapsuleViewBinding) {
        super(itemCapsuleViewBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemCapsuleViewBinding, "binding");
        this.binding = itemCapsuleViewBinding;
    }

    public final void bind(@NotNull TProOnBoardingCardCapsulesContentModel tProOnBoardingCardCapsulesContentModel) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardCapsulesContentModel, "tProOnBoardingCardCapsulesContentModel");
        this.binding.tvTitle.setText(tProOnBoardingCardCapsulesContentModel.getTitle());
        ImageView imageView = this.binding.ivCapsule;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivCapsule");
        ImageViewExtensionsKt.loadImageUrl$default(imageView, tProOnBoardingCardCapsulesContentModel.getImage(), (Function0) null, 2, (Object) null);
        CardView cardView = this.binding.cvParentView;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.cvParentView");
        ExtensionsKt.applyCardBgColor(cardView, tProOnBoardingCardCapsulesContentModel.getBackground());
        TextView textView = this.binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTitle");
        ExtensionsKt.applyTextColor(textView, tProOnBoardingCardCapsulesContentModel.getTitleColor());
    }
}
