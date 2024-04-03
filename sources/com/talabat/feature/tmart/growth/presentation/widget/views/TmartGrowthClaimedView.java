package com.talabat.feature.tmart.growth.presentation.widget.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.presentation.tmart.growth.R;
import com.talabat.presentation.tmart.growth.databinding.TmartGrowthClaimedViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ5\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2%\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0010j\u0002`\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/views/TmartGrowthClaimedView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/presentation/tmart/growth/databinding/TmartGrowthClaimedViewBinding;", "setup", "", "model", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Claimed;", "clickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deeplink", "Lcom/talabat/feature/tmart/growth/presentation/widget/DeeplinkClickListener;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TmartGrowthClaimedView extends ConstraintLayout {
    @NotNull
    private final TmartGrowthClaimedViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TmartGrowthClaimedView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TmartGrowthClaimedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TmartGrowthClaimedView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10350setup$lambda1$lambda0(Function1 function1, TMartGrowthClaimDisplayModel.Claimed claimed, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        Intrinsics.checkNotNullParameter(claimed, "$model");
        function1.invoke(claimed.getDeeplink());
    }

    public final void setup(@NotNull TMartGrowthClaimDisplayModel.Claimed claimed, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(claimed, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        TmartGrowthClaimedViewBinding tmartGrowthClaimedViewBinding = this.binding;
        tmartGrowthClaimedViewBinding.title.setText(claimed.getTitle());
        tmartGrowthClaimedViewBinding.subtitle.setText(claimed.getSubtitle());
        setOnClickListener(new c(function1, claimed));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TmartGrowthClaimedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TmartGrowthClaimedViewBinding inflate = TmartGrowthClaimedViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setForeground(ContextCompat.getDrawable(context, R.drawable.tmart_growth_rounded_ripple));
        setBackgroundResource(R.drawable.tmart_growth_claimed_background);
    }
}
