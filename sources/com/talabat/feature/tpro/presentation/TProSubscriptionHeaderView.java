package com.talabat.feature.tpro.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/TProSubscriptionHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "isUserSubscribed", "", "(Landroid/content/Context;Landroid/view/LayoutInflater;Z)V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/TproSubscriptionHeaderBinding;", "dotTextView", "Landroid/widget/TextView;", "freeDeliveryTextView", "rewardPointsTextView", "subscribeButton", "Landroid/widget/Button;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProSubscriptionHeaderView extends ConstraintLayout {
    @NotNull
    private final TproSubscriptionHeaderBinding binding;
    @NotNull
    private TextView dotTextView;
    @NotNull
    private TextView freeDeliveryTextView;
    private final boolean isUserSubscribed;
    @NotNull
    private TextView rewardPointsTextView;
    @NotNull
    private Button subscribeButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProSubscriptionHeaderView(@NotNull Context context, @NotNull LayoutInflater layoutInflater, boolean z11) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.isUserSubscribed = z11;
        TproSubscriptionHeaderBinding inflate = TproSubscriptionHeaderBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        TextView textView = inflate.freeDeliveryText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.freeDeliveryText");
        this.freeDeliveryTextView = textView;
        TextView textView2 = inflate.dotTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.dotTextView");
        this.dotTextView = textView2;
        TextView textView3 = inflate.rewardPointsText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.rewardPointsText");
        this.rewardPointsTextView = textView3;
        Button button = inflate.subscribeButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.subscribeButton");
        this.subscribeButton = button;
    }
}
