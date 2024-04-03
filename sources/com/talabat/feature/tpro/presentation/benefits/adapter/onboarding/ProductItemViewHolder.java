package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.feature.tpro.presentation.databinding.ItemTproProductBinding;
import com.talabat.feature.tpro.presentation.model.TProProductDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qo.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J.\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/ProductItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemTproProductBinding;", "onLearnMoreClick", "Lkotlin/Function0;", "", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemTproProductBinding;Lkotlin/jvm/functions/Function0;)V", "bind", "product", "Lcom/talabat/feature/tpro/presentation/model/TProProductDisplayModel;", "iconId", "", "index", "headerTitle", "", "learnMoreText", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemTproProductBinding binding;
    @NotNull
    private final Function0<Unit> onLearnMoreClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductItemViewHolder(@NotNull ItemTproProductBinding itemTproProductBinding, @NotNull Function0<Unit> function0) {
        super(itemTproProductBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemTproProductBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onLearnMoreClick");
        this.binding = itemTproProductBinding;
        this.onLearnMoreClick = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10362bind$lambda0(ProductItemViewHolder productItemViewHolder, View view) {
        Intrinsics.checkNotNullParameter(productItemViewHolder, "this$0");
        productItemViewHolder.onLearnMoreClick.invoke();
    }

    public final void bind(@NotNull TProProductDisplayModel tProProductDisplayModel, int i11, int i12, @NotNull String str, @NotNull String str2) {
        boolean z11;
        int i13;
        Intrinsics.checkNotNullParameter(tProProductDisplayModel, "product");
        Intrinsics.checkNotNullParameter(str, "headerTitle");
        Intrinsics.checkNotNullParameter(str2, "learnMoreText");
        TextView textView = this.binding.tvOnBoardingContentHeader;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvOnBoardingContentHeader");
        boolean z12 = true;
        if (i12 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        textView.setVisibility(i13);
        this.binding.tvOnBoardingContentHeader.setText(str);
        this.binding.tvBenefitHeader.setText(tProProductDisplayModel.getTitle());
        this.binding.tvBenefitContent.setText(tProProductDisplayModel.getDescription());
        if (str2.length() <= 0) {
            z12 = false;
        }
        if (z12) {
            TextView textView2 = this.binding.learnMoreText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.learnMoreText");
            textView2.setVisibility(0);
            this.binding.learnMoreText.setOnClickListener(new b(this));
        }
        ((RequestBuilder) Glide.with((View) this.binding.ivBenefitIcon).load(tProProductDisplayModel.getIconUri()).fitCenter()).into(this.binding.ivBenefitIcon);
    }
}
