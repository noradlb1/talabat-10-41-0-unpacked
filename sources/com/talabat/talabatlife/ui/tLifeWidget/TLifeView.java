package com.talabat.talabatlife.ui.tLifeWidget;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import com.talabat.talabatlife.ui.tLifeWidget.viewModel.TLifeWidgetViewModel;
import com.talabat.talabatlife.ui.tLifeWidget.viewModel.TLifeWidgetViewModelBuilder;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kw.a;
import kw.b;
import kw.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0012\u0010#\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0006\u0010,\u001a\u00020\u001dJ\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0010H\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u0016\u00101\u001a\u00020\u001d2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u0012\u00103\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\b\u00106\u001a\u00020\u0002H\u0016R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/TLifeView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatlife/ui/tLifeWidget/viewModel/TLifeWidgetViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "broadcast", "com/talabat/talabatlife/ui/tLifeWidget/TLifeView$broadcast$1", "Lcom/talabat/talabatlife/ui/tLifeWidget/TLifeView$broadcast$1;", "isCoffeeMode", "", "nonSubscribedOnClickListener", "Landroid/view/View$OnClickListener;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionStatusRepository$delegate", "Lkotlin/Lazy;", "tLifeBarOnClickListener", "tLifeScanButtonOnClickListener", "tLifeWidgetAppearedCallback", "Lkotlin/Function0;", "", "checkSubscriptionStatus", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fireTrackingEvent", "getLayoutId", "getViewModelClass", "Ljava/lang/Class;", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onLifecycleOwnerAttached", "onPause", "onResume", "setFreeCoffeeMode", "setupView", "isSubscribes", "startShimmer", "stopShimmer", "tlifeWidgetAppeared", "callback", "updateUserTLifeSubscription", "displayModel", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeView extends MvvmLinearLayout<TLifeWidgetViewModel> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final TLifeView$broadcast$1 broadcast;
    private boolean isCoffeeMode;
    @NotNull
    private final View.OnClickListener nonSubscribedOnClickListener;
    @NotNull
    private final Lazy subscriptionStatusRepository$delegate;
    @NotNull
    private final View.OnClickListener tLifeBarOnClickListener;
    @NotNull
    private final View.OnClickListener tLifeScanButtonOnClickListener;
    @Nullable
    private Function0<Unit> tLifeWidgetAppearedCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeView(@NotNull Context context) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subscriptionStatusRepository$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TLifeView$subscriptionStatusRepository$2(this));
        this.broadcast = new TLifeView$broadcast$1(this);
        this.tLifeBarOnClickListener = new a(this);
        this.tLifeScanButtonOnClickListener = new b(this);
        this.nonSubscribedOnClickListener = new c(this);
    }

    private final void checkSubscriptionStatus() {
        startShimmer();
        ((ImageView) _$_findCachedViewById(R.id.tLifeWidgetImageView)).setClickable(false);
        ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetRestaurantsRelativeLayout)).setClickable(false);
        TLifeWidgetViewModel.getTLifeSubscriptionStatus$default((TLifeWidgetViewModel) getViewModel(), 0, 1, (Object) null);
    }

    private final void fireTrackingEvent() {
        if (getContext() != null) {
            IntegrationAppTrackerTLife.Companion.onTLifeScanQRClickedFromHome();
        }
    }

    private final ISubscriptionStatusRepository getSubscriptionStatusRepository() {
        return (ISubscriptionStatusRepository) this.subscriptionStatusRepository$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: nonSubscribedOnClickListener$lambda-9  reason: not valid java name */
    public static final void m5842nonSubscribedOnClickListener$lambda9(TLifeView tLifeView, View view) {
        Intrinsics.checkNotNullParameter(tLifeView, "this$0");
        Context context = tLifeView.getContext();
        if (context == null) {
            return;
        }
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_SHOW_TDINE_ONBOARD_SCREEN_REVAMP, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            Navigator.Companion.navigate(context, new NavigatorModel(TLifeNavigationActions.FLUTTER_ONBOARDING_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        } else {
            Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.talabat.life.on.boarding", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    private final void setupView(boolean z11) {
        int i11;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.tProWidgetIconImageView);
        Intrinsics.checkNotNullExpressionValue(imageView, "tProWidgetIconImageView");
        int i12 = 0;
        if (this.isCoffeeMode) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        int i13 = R.id.tLifeWidgetIconImageView;
        ImageView imageView2 = (ImageView) _$_findCachedViewById(i13);
        Intrinsics.checkNotNullExpressionValue(imageView2, "tLifeWidgetIconImageView");
        if (!(!this.isCoffeeMode)) {
            i12 = 8;
        }
        imageView2.setVisibility(i12);
        if (this.isCoffeeMode) {
            ((TextView) _$_findCachedViewById(R.id.tLifeWidgetTextAction)).setText(com.talabat.localization.R.string.tLifeWidgetGetFreeCoffee);
        } else {
            Context context = getContext();
            if (context != null) {
                ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
                String logoUrl = ((TLifeWidgetViewModel) getViewModel()).getLogoUrl();
                ImageView imageView3 = (ImageView) _$_findCachedViewById(i13);
                Intrinsics.checkNotNullExpressionValue(imageView3, "tLifeWidgetIconImageView");
                ImageDownloadHelper.Companion.downloadImage$default(companion, context, logoUrl, imageView3, 0, 0, false, 56, (Object) null);
            }
        }
        if (z11) {
            ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetRestaurantsRelativeLayout)).setOnClickListener(this.tLifeBarOnClickListener);
            ((ImageView) _$_findCachedViewById(R.id.tLifeWidgetImageView)).setOnClickListener(this.tLifeScanButtonOnClickListener);
        } else {
            ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetRestaurantsRelativeLayout)).setOnClickListener(this.nonSubscribedOnClickListener);
            ((ImageView) _$_findCachedViewById(R.id.tLifeWidgetImageView)).setOnClickListener(this.nonSubscribedOnClickListener);
        }
        Function0<Unit> function0 = this.tLifeWidgetAppearedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void startShimmer() {
        int i11 = R.id.tLifeWidgetShimmerLayout;
        ((ShimmerLayout) _$_findCachedViewById(i11)).startShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(i11)).setVisibility(0);
        ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetContent)).setVisibility(4);
    }

    private final void stopShimmer() {
        int i11 = R.id.tLifeWidgetShimmerLayout;
        ((ShimmerLayout) _$_findCachedViewById(i11)).stopShimmerAnimation();
        ((ShimmerLayout) _$_findCachedViewById(i11)).setVisibility(4);
        ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetContent)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: tLifeBarOnClickListener$lambda-5  reason: not valid java name */
    public static final void m5843tLifeBarOnClickListener$lambda5(TLifeView tLifeView, View view) {
        Intrinsics.checkNotNullParameter(tLifeView, "this$0");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isCoffeeMode", true);
        Context context = tLifeView.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDORS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tLifeScanButtonOnClickListener$lambda-7  reason: not valid java name */
    public static final void m5844tLifeScanButtonOnClickListener$lambda7(TLifeView tLifeView, View view) {
        Intrinsics.checkNotNullParameter(tLifeView, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("argScreenName", "home");
        Context context = tLifeView.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_QR_CODE_SCANNER_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
        tLifeView.fireTrackingEvent();
    }

    /* access modifiers changed from: private */
    public final void updateUserTLifeSubscription(SubscriptionStatusDisplayModel subscriptionStatusDisplayModel) {
        boolean z11;
        stopShimmer();
        ((ImageView) _$_findCachedViewById(R.id.tLifeWidgetImageView)).setClickable(true);
        ((RelativeLayout) _$_findCachedViewById(R.id.tLifeWidgetRestaurantsRelativeLayout)).setClickable(true);
        if (subscriptionStatusDisplayModel != null) {
            if (this.isCoffeeMode) {
                z11 = ((TLifeWidgetViewModel) getViewModel()).isTProUser();
            } else {
                z11 = subscriptionStatusDisplayModel.isUserSubscribed();
            }
            setupView(z11);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return R.layout.view_t_life_widget;
    }

    @NotNull
    public Class<TLifeWidgetViewModel> getViewModelClass() {
        return TLifeWidgetViewModel.class;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleKt.observe(lifecycleOwner, ((TLifeWidgetViewModel) getViewModel()).getSubscriptionData(), new TLifeView$observatory$1$1(this));
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
    }

    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(this.broadcast);
    }

    public void onResume() {
        super.onResume();
        checkSubscriptionStatus();
        getContext().registerReceiver(this.broadcast, new IntentFilter("tdine"));
    }

    public final void setFreeCoffeeMode() {
        CardView cardView = (CardView) _$_findCachedViewById(R.id.tLifeWidgetCircle);
        Intrinsics.checkNotNullExpressionValue(cardView, "tLifeWidgetCircle");
        cardView.setVisibility(8);
        this.isCoffeeMode = true;
    }

    public final void tlifeWidgetAppeared(@Nullable Function0<Unit> function0) {
        this.tLifeWidgetAppearedCallback = function0;
    }

    @NotNull
    public TLifeWidgetViewModel viewModelBuilder() {
        TLifeWidgetViewModelBuilder.Companion companion = TLifeWidgetViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getTLifeHomeWidgetViewModel(context, getCoroutineScope(), getSubscriptionStatusRepository());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subscriptionStatusRepository$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TLifeView$subscriptionStatusRepository$2(this));
        this.broadcast = new TLifeView$broadcast$1(this);
        this.tLifeBarOnClickListener = new a(this);
        this.tLifeScanButtonOnClickListener = new b(this);
        this.nonSubscribedOnClickListener = new c(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TLifeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subscriptionStatusRepository$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TLifeView$subscriptionStatusRepository$2(this));
        this.broadcast = new TLifeView$broadcast$1(this);
        this.tLifeBarOnClickListener = new a(this);
        this.tLifeScanButtonOnClickListener = new b(this);
        this.nonSubscribedOnClickListener = new c(this);
    }
}
