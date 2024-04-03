package com.talabat.feature.rewards.presentation.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.feature.rewards.domain.model.MissionWidget;
import com.talabat.feature.rewards.presentation.databinding.MissionWidgetSuccessBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/SuccessMissionWidgetView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/rewards/presentation/databinding/MissionWidgetSuccessBinding;", "setup", "", "missionWidget", "Lcom/talabat/feature/rewards/domain/model/MissionWidget;", "setupLoadingIndicatorClaimReward", "isLoading", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuccessMissionWidgetView extends LinearLayout {
    @NotNull
    private final MissionWidgetSuccessBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuccessMissionWidgetView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuccessMissionWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuccessMissionWidgetView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void setup(@NotNull MissionWidget missionWidget) {
        Intrinsics.checkNotNullParameter(missionWidget, "missionWidget");
        MissionWidgetSuccessBinding missionWidgetSuccessBinding = this.binding;
        TextView textView = missionWidgetSuccessBinding.tvMissionTitle;
        String title = missionWidget.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        textView.setText(title);
        TextView textView2 = missionWidgetSuccessBinding.tvMissionDescription;
        String subtitle = missionWidget.getSubtitle();
        if (subtitle != null) {
            str = subtitle;
        }
        textView2.setText(str);
        String image = missionWidget.getImage();
        if (image != null) {
            missionWidgetSuccessBinding.ivMission.setImageUrl(image);
        }
    }

    public final void setupLoadingIndicatorClaimReward(boolean z11) {
        int i11;
        TextView textView = this.binding.tvClaimRewards;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvClaimRewards");
        int i12 = 4;
        if (z11) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        textView.setVisibility(i11);
        LottieAnimationView lottieAnimationView = this.binding.dsSpinner;
        if (z11) {
            lottieAnimationView.setProgress(0.0f);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        } else {
            lottieAnimationView.pauseAnimation();
        }
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        if (!(!z11)) {
            i12 = 0;
        }
        lottieAnimationView.setVisibility(i12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuccessMissionWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        MissionWidgetSuccessBinding inflate = MissionWidgetSuccessBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
    }
}
