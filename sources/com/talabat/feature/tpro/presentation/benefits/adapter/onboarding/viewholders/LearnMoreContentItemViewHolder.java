package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import colorprovider.DSColorProvider;
import com.designsystem.marshmallow.R;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentItemModel;
import com.talabat.feature.tpro.presentation.databinding.LearnMoreContentItemBinding;
import com.talabat.feature.tpro.presentation.util.ExtensionsKt;
import com.talabat.feature.tpro.presentation.util.FadeAnimationKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/viewholders/LearnMoreContentItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/LearnMoreContentItemBinding;", "(Lcom/talabat/feature/tpro/presentation/databinding/LearnMoreContentItemBinding;)V", "applyBackgroundColor", "", "view", "Landroid/view/View;", "color", "", "applyColor", "textView", "Landroid/widget/TextView;", "bind", "onBoardingMoreContentItemList", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentItemModel;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LearnMoreContentItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final LearnMoreContentItemBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LearnMoreContentItemViewHolder(@NotNull LearnMoreContentItemBinding learnMoreContentItemBinding) {
        super(learnMoreContentItemBinding.getRoot());
        Intrinsics.checkNotNullParameter(learnMoreContentItemBinding, "binding");
        this.binding = learnMoreContentItemBinding;
    }

    private final void applyBackgroundColor(View view, String str) {
        int i11;
        float dimensionPixelOffset = (float) view.getResources().getDimensionPixelOffset(R.dimen.ds_xxs);
        GradientDrawable gradientDrawable = new GradientDrawable();
        Context context = view.getContext();
        Integer num = DSColorProvider.INSTANCE.getMarshmallowColorMap().get(str);
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = R.color.ds_neutral_4;
        }
        gradientDrawable.setColor(ContextCompat.getColor(context, i11));
        gradientDrawable.setCornerRadius(dimensionPixelOffset);
        view.setBackground(gradientDrawable);
    }

    private final void applyColor(TextView textView, String str) {
        ExtensionsKt.setTextDsMarshMallowColor(textView, str);
    }

    public final void bind(@Nullable TProOnBoardingMoreContentItemModel tProOnBoardingMoreContentItemModel) {
        if (tProOnBoardingMoreContentItemModel != null) {
            ConstraintLayout constraintLayout = this.binding.learnMoreItemContainer;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.learnMoreItemContainer");
            applyBackgroundColor(constraintLayout, tProOnBoardingMoreContentItemModel.getBackgroundColor());
            this.binding.tvTrailing.setText(tProOnBoardingMoreContentItemModel.getTrailingText());
            TextView textView = this.binding.tvTrailing;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTrailing");
            applyColor(textView, tProOnBoardingMoreContentItemModel.getTrailingTextColor());
            String type = tProOnBoardingMoreContentItemModel.getType();
            int hashCode = type.hashCode();
            if (hashCode != 3387192) {
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && type.equals("image")) {
                        RelativeLayout relativeLayout = this.binding.rlLeadingContainer;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlLeadingContainer");
                        FadeAnimationKt.changeVisibility(relativeLayout, true);
                        ImageView imageView = this.binding.ivLeading;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivLeading");
                        FadeAnimationKt.changeVisibility(imageView, true);
                        TextView textView2 = this.binding.tvLeading;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvLeading");
                        FadeAnimationKt.changeVisibility(textView2, false);
                        ImageView imageView2 = this.binding.ivLeading;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivLeading");
                        ExtensionsKt.loadImage$default(imageView2, tProOnBoardingMoreContentItemModel.getLeadingImage(), (Function1) null, 2, (Object) null);
                        return;
                    }
                } else if (type.equals("text")) {
                    RelativeLayout relativeLayout2 = this.binding.rlLeadingContainer;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.rlLeadingContainer");
                    FadeAnimationKt.changeVisibility(relativeLayout2, true);
                    ImageView imageView3 = this.binding.ivLeading;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivLeading");
                    FadeAnimationKt.changeVisibility(imageView3, false);
                    TextView textView3 = this.binding.tvLeading;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvLeading");
                    FadeAnimationKt.changeVisibility(textView3, true);
                    this.binding.tvLeading.setText(tProOnBoardingMoreContentItemModel.getLeadingText());
                    TextView textView4 = this.binding.tvLeading;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvLeading");
                    applyColor(textView4, tProOnBoardingMoreContentItemModel.getLeadingTextColor());
                    return;
                }
            } else if (type.equals("none")) {
                RelativeLayout relativeLayout3 = this.binding.rlLeadingContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.rlLeadingContainer");
                FadeAnimationKt.changeVisibility(relativeLayout3, false);
                return;
            }
            RelativeLayout relativeLayout4 = this.binding.rlLeadingContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.rlLeadingContainer");
            FadeAnimationKt.changeVisibility(relativeLayout4, false);
        }
    }
}
