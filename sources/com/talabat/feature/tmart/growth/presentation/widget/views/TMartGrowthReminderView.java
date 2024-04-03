package com.talabat.feature.tmart.growth.presentation.widget.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.presentation.tmart.growth.databinding.TmartGrowthReminderViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ5\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2%\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0010j\u0002`\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/views/TMartGrowthReminderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/presentation/tmart/growth/databinding/TmartGrowthReminderViewBinding;", "setup", "", "model", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Reminder;", "clickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deeplink", "Lcom/talabat/feature/tmart/growth/presentation/widget/DeeplinkClickListener;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthReminderView extends ConstraintLayout {
    @NotNull
    private final TmartGrowthReminderViewBinding binding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthReminderView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthReminderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TMartGrowthReminderView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10349setup$lambda2$lambda1(Function1 function1, TMartGrowthClaimDisplayModel.Reminder reminder, View view) {
        Intrinsics.checkNotNullParameter(function1, "$clickListener");
        Intrinsics.checkNotNullParameter(reminder, "$model");
        function1.invoke(reminder.getDeeplink());
    }

    public final void setup(@NotNull TMartGrowthClaimDisplayModel.Reminder reminder, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(reminder, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        TmartGrowthReminderViewBinding tmartGrowthReminderViewBinding = this.binding;
        RequestManager with = Glide.with((View) this);
        ((RequestBuilder) with.load(reminder.m10311getBackgroundImagePathUYv4Z4()).fitCenter()).into(new BackgroundDrawableTarget(this));
        with.load(reminder.getLogoUrl()).into(tmartGrowthReminderViewBinding.tMartLogo);
        with.load(reminder.m10312getImageFilePathUYv4Z4()).into(tmartGrowthReminderViewBinding.image);
        tmartGrowthReminderViewBinding.title.setText(reminder.getTitle());
        tmartGrowthReminderViewBinding.subtitle.setText(reminder.getSubtitle());
        tmartGrowthReminderViewBinding.enterTMartButtonText.setText(reminder.getButtonText());
        setOnClickListener(new b(function1, reminder));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthReminderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TmartGrowthReminderViewBinding inflate = TmartGrowthReminderViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
    }
}
