package com.talabat.feature.tmart.growth.presentation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelLazy;
import com.designsystem.marshmallow.R;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.presentation.di.DaggerTMartGrowthViewComponent;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel;
import com.talabat.feature.tmart.growth.presentation.widget.WidgetState;
import com.talabat.feature.tmart.growth.presentation.widget.views.TMartGrowthNotClaimedView;
import com.talabat.feature.tmart.growth.presentation.widget.views.TMartGrowthReminderView;
import com.talabat.feature.tmart.growth.presentation.widget.views.TmartGrowthClaimedView;
import com.talabat.presentation.tmart.growth.databinding.TmartGrowthWidgetBinding;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.views.ShimmerLayout;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJY\u0010$\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fj\u0002`%2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0014J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u0010.\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\r2\u0006\u0010.\u001a\u000203H\u0002J\b\u00104\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u0010.\u001a\u000206H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u001d8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/presentation/tmart/growth/databinding/TmartGrowthWidgetBinding;", "openBottomSheetListener", "Lkotlin/Function0;", "", "openTMartListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deeplink", "screenType", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthScreen;", "viewModel", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel;", "getViewModel", "()Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "viewModelFactory", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel$Factory;", "getViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation", "()Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel$Factory;", "setViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation", "(Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel$Factory;)V", "voucherId", "widgetErrorFallback", "bind", "Lcom/talabat/feature/tmart/growth/presentation/widget/DeeplinkClickListener;", "handleState", "state", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "initDagger", "onAttachedToWindow", "onTMartOpened", "onWidgetClaimed", "setupClaimedView", "model", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Claimed;", "setupNotClaimedView", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Unclaimed;", "setupReminderView", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel$Reminder;", "setupShimmerLayout", "setupViews", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "Companion", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthWidgetView extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float PLACEHOLDER_HEIGHT_RATIO = 0.19f;
    @NotNull
    private final TmartGrowthWidgetBinding binding;
    @NotNull
    private Function0<Unit> openBottomSheetListener;
    @NotNull
    private Function1<? super String, Unit> openTMartListener;
    /* access modifiers changed from: private */
    @NotNull
    public TMartGrowthScreen screenType;
    @NotNull
    private final ViewModelLazy viewModel$delegate;
    @Inject
    public TMartGrowthWidgetViewModel.Factory viewModelFactory;
    /* access modifiers changed from: private */
    @NotNull
    public String voucherId;
    @NotNull
    private Function0<Unit> widgetErrorFallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetView$Companion;", "", "()V", "PLACEHOLDER_HEIGHT_RATIO", "", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthWidgetView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TMartGrowthWidgetView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    public final TMartGrowthWidgetViewModel getViewModel() {
        return (TMartGrowthWidgetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleState(WidgetState widgetState) {
        int i11;
        TmartGrowthWidgetBinding tmartGrowthWidgetBinding = this.binding;
        if (Intrinsics.areEqual((Object) widgetState, (Object) WidgetState.Hidden.INSTANCE)) {
            this.widgetErrorFallback.invoke();
        }
        boolean z11 = true;
        int i12 = 8;
        if (!(widgetState instanceof WidgetState.Hidden)) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        if (!Intrinsics.areEqual((Object) widgetState, (Object) WidgetState.Loading.INSTANCE) || this.screenType == TMartGrowthScreen.ORDER_CONFIRMATION) {
            z11 = false;
        }
        ShimmerLayout shimmerLayout = tmartGrowthWidgetBinding.shimmerLayout;
        Intrinsics.checkNotNullExpressionValue(shimmerLayout, "shimmerLayout");
        if (z11) {
            i12 = 0;
        }
        shimmerLayout.setVisibility(i12);
        if (z11) {
            tmartGrowthWidgetBinding.shimmerLayout.startShimmerAnimation();
        } else {
            tmartGrowthWidgetBinding.shimmerLayout.stopShimmerAnimation();
        }
        if (widgetState instanceof WidgetState.Success) {
            setupViews(((WidgetState.Success) widgetState).getModel());
        }
    }

    private final void initDagger() {
        DaggerTMartGrowthViewComponent.factory().create((TMartGrowthFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(TMartGrowthFeatureApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public final void onTMartOpened(String str) {
        getViewModel().onTMartOpened();
        this.openTMartListener.invoke(str);
    }

    /* access modifiers changed from: private */
    public final void onWidgetClaimed() {
        getViewModel().onWidgetClaimed();
        this.openBottomSheetListener.invoke();
    }

    private final void setupClaimedView(TMartGrowthClaimDisplayModel.Claimed claimed) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TmartGrowthClaimedView tmartGrowthClaimedView = new TmartGrowthClaimedView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        tmartGrowthClaimedView.setup(claimed, new TMartGrowthWidgetView$setupClaimedView$1$1(this));
        addView(tmartGrowthClaimedView);
    }

    private final void setupNotClaimedView(TMartGrowthClaimDisplayModel.Unclaimed unclaimed) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TMartGrowthNotClaimedView tMartGrowthNotClaimedView = new TMartGrowthNotClaimedView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        tMartGrowthNotClaimedView.setup(unclaimed, new TMartGrowthWidgetView$setupNotClaimedView$1$1(this));
        addView(tMartGrowthNotClaimedView);
    }

    private final void setupReminderView(TMartGrowthClaimDisplayModel.Reminder reminder) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TMartGrowthReminderView tMartGrowthReminderView = new TMartGrowthReminderView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        tMartGrowthReminderView.setup(reminder, new TMartGrowthWidgetView$setupReminderView$1$1(this));
        addView(tMartGrowthReminderView);
    }

    private final void setupShimmerLayout() {
        int dimensionPixelSize = getResources().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(R.dimen.ds_s) * 2);
        this.binding.shimmerLayout.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, (int) (((float) dimensionPixelSize) * PLACEHOLDER_HEIGHT_RATIO)));
    }

    private final void setupViews(TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel) {
        removeAllViews();
        if (tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Claimed) {
            setupClaimedView((TMartGrowthClaimDisplayModel.Claimed) tMartGrowthClaimDisplayModel);
        } else if (tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Unclaimed) {
            setupNotClaimedView((TMartGrowthClaimDisplayModel.Unclaimed) tMartGrowthClaimDisplayModel);
        } else if (tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Reminder) {
            setupReminderView((TMartGrowthClaimDisplayModel.Reminder) tMartGrowthClaimDisplayModel);
        } else {
            Intrinsics.areEqual((Object) tMartGrowthClaimDisplayModel, (Object) TMartGrowthClaimDisplayModel.None.INSTANCE);
        }
    }

    public final void bind(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function02, @NotNull TMartGrowthScreen tMartGrowthScreen) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(function0, "openBottomSheetListener");
        Intrinsics.checkNotNullParameter(function1, "openTMartListener");
        Intrinsics.checkNotNullParameter(function02, "widgetErrorFallback");
        Intrinsics.checkNotNullParameter(tMartGrowthScreen, "screenType");
        this.voucherId = str;
        this.openBottomSheetListener = function0;
        this.openTMartListener = function1;
        this.widgetErrorFallback = function02;
        this.screenType = tMartGrowthScreen;
    }

    @NotNull
    public final TMartGrowthWidgetViewModel.Factory getViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation() {
        TMartGrowthWidgetViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttachedToWindow() {
        LifecycleCoroutineScope lifecycleScope;
        super.onAttachedToWindow();
        LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this);
        if (findViewTreeLifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(findViewTreeLifecycleOwner)) != null) {
            lifecycleScope.launchWhenStarted(new TMartGrowthWidgetView$onAttachedToWindow$1$1(this, (Continuation<? super TMartGrowthWidgetView$onAttachedToWindow$1$1>) null));
        }
    }

    public final void setViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation(@NotNull TMartGrowthWidgetViewModel.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TMartGrowthWidgetView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        TmartGrowthWidgetBinding inflate = TmartGrowthWidgetBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        this.voucherId = "";
        this.openBottomSheetListener = TMartGrowthWidgetView$openBottomSheetListener$1.INSTANCE;
        this.openTMartListener = TMartGrowthWidgetView$openTMartListener$1.INSTANCE;
        this.widgetErrorFallback = TMartGrowthWidgetView$widgetErrorFallback$1.INSTANCE;
        this.screenType = TMartGrowthScreen.HOME;
        TMartGrowthWidgetView$viewModel$2 tMartGrowthWidgetView$viewModel$2 = new TMartGrowthWidgetView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TMartGrowthWidgetViewModel.class), new TMartGrowthWidgetView$special$$inlined$viewModels$1(this), tMartGrowthWidgetView$viewModel$2);
        initDagger();
        setupShimmerLayout();
    }
}
