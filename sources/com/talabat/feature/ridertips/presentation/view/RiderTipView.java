package com.talabat.feature.ridertips.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.ViewModelLazy;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.marshmallow.R;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
import com.talabat.feature.ridertips.presentation.di.DaggerRiderTipViewComponent;
import com.talabat.feature.ridertips.presentation.view.terms.TermsFragment;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModelFactory;
import com.talabat.talabatlife.features.UrlConstantsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010 \u001a\u00020\u0012H\u0017¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0012J\b\u0010$\u001a\u00020\u0012H\u0002J\u0006\u0010%\u001a\u00020\u0012R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRK\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/view/RiderTipView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "factory", "Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModelFactory;", "getFactory", "()Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModelFactory;", "setFactory", "(Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModelFactory;)V", "<set-?>", "Lkotlin/Function1;", "", "", "onRiderTipValueChange", "getOnRiderTipValueChange", "()Lkotlin/jvm/functions/Function1;", "setOnRiderTipValueChange", "(Lkotlin/jvm/functions/Function1;)V", "onRiderTipValueChange$delegate", "Landroidx/compose/runtime/MutableState;", "viewModel", "Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModel;", "getViewModel", "()Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModelLazy;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "disableRiderTip", "enableRiderTip", "onInfoClicked", "onRiderTipClosed", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipView extends AbstractComposeView {
    public static final int $stable = 8;
    @Inject
    public RiderTipViewModelFactory factory;
    @NotNull
    private final MutableState onRiderTipValueChange$delegate;
    @NotNull
    private final ViewModelLazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RiderTipView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RiderTipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RiderTipView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final RiderTipViewModel getViewModel() {
        return (RiderTipViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void onInfoClicked() {
        Context context = getContext();
        if (context != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            TermsFragment termsFragment = new TermsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH, getViewModel().getTerms());
            termsFragment.setArguments(bundle);
            getViewModel().disclaimerClicked();
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            DSNavigationBar dSNavigationBar = new DSNavigationBar(appCompatActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new RiderTipView$onInfoClicked$1$1$1(dSBottomSheet)));
            dSBottomSheet.setNavigationBar(dSNavigationBar);
            dSBottomSheet.setBody(termsFragment);
            dSBottomSheet.show(appCompatActivity.getSupportFragmentManager(), "TermsFragment");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    @ExperimentalAnimationApi
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1468063480);
        RiderTipViewKt.RiderTipView(getViewModel(), new RiderTipView$Content$1(this), getOnRiderTipValueChange(), startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RiderTipView$Content$2(this, i11));
        }
    }

    public final void disableRiderTip() {
        getViewModel().onTipDisabled();
    }

    public final void enableRiderTip() {
        getViewModel().onTipEnabled();
    }

    @NotNull
    public final RiderTipViewModelFactory getFactory() {
        RiderTipViewModelFactory riderTipViewModelFactory = this.factory;
        if (riderTipViewModelFactory != null) {
            return riderTipViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @Nullable
    public final Function1<Double, Unit> getOnRiderTipValueChange() {
        return (Function1) this.onRiderTipValueChange$delegate.getValue();
    }

    public final void onRiderTipClosed() {
        getViewModel().updateSaveRiderTip();
    }

    public final void setFactory(@NotNull RiderTipViewModelFactory riderTipViewModelFactory) {
        Intrinsics.checkNotNullParameter(riderTipViewModelFactory, "<set-?>");
        this.factory = riderTipViewModelFactory;
    }

    public final void setOnRiderTipValueChange(@Nullable Function1<? super Double, Unit> function1) {
        this.onRiderTipValueChange$delegate.setValue(function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RiderTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        RiderTipView$viewModel$2 riderTipView$viewModel$2 = new RiderTipView$viewModel$2(this);
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RiderTipViewModel.class), new RiderTipView$special$$inlined$viewModels$1(this), riderTipView$viewModel$2);
        this.onRiderTipValueChange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        DaggerRiderTipViewComponent.factory().create(context, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationRemoteCoreLibApi.class), (RiderTipFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(RiderTipFeatureApi.class)).inject(this);
    }
}
