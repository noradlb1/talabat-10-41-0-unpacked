package com.talabat.feature.tpro.presentation.savings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproSavingsCancellationBottomSheetBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kp.a;
import kp.b;
import kp.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/TProSavingsCancellationBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "nextBillingDate", "", "onLeaveProClick", "Lkotlin/Function0;", "", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproSavingsCancellationBottomSheetBinding;", "addButtonsListeners", "addDismissListener", "dismiss", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setContent", "setDescriptionText", "setHeaderText", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProSavingsCancellationBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    public boolean isAbortCancellation = true;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final String nextBillingDate;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Boolean, Unit> onDismissed;
    @NotNull
    private final Function0<Unit> onLeaveProClick;
    @NotNull
    private final SubscriptionSavingsInfo savingsInfo;
    private FragmentTproSavingsCancellationBottomSheetBinding viewBinding;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0002JO\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000f¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/tpro/presentation/savings/TProSavingsCancellationBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/savings/TProSavingsCancellationBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "savingsInfo", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "nextBillingDate", "", "onLeaveProClick", "Lkotlin/Function0;", "", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TProSavingsCancellationBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, SubscriptionSavingsInfo subscriptionSavingsInfo, String str, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
            return new TProSavingsCancellationBottomSheetFragment(dSBottomSheet, subscriptionSavingsInfo, str, function0, function1);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull SubscriptionSavingsInfo subscriptionSavingsInfo, @NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscriptionSavingsInfo, "savingsInfo");
            Intrinsics.checkNotNullParameter(str, "nextBillingDate");
            Intrinsics.checkNotNullParameter(function0, "onLeaveProClick");
            Intrinsics.checkNotNullParameter(function1, "onDismissed");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TProSavingsCancellationBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscriptionSavingsInfo, str, function0, function1));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public TProSavingsCancellationBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull SubscriptionSavingsInfo subscriptionSavingsInfo, @NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscriptionSavingsInfo, "savingsInfo");
        Intrinsics.checkNotNullParameter(str, "nextBillingDate");
        Intrinsics.checkNotNullParameter(function0, "onLeaveProClick");
        Intrinsics.checkNotNullParameter(function1, "onDismissed");
        this.dsBottomSheet = dSBottomSheet;
        this.savingsInfo = subscriptionSavingsInfo;
        this.nextBillingDate = str;
        this.onLeaveProClick = function0;
        this.onDismissed = function1;
    }

    private final void addButtonsListeners() {
        FragmentTproSavingsCancellationBottomSheetBinding fragmentTproSavingsCancellationBottomSheetBinding = this.viewBinding;
        if (fragmentTproSavingsCancellationBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproSavingsCancellationBottomSheetBinding = null;
        }
        fragmentTproSavingsCancellationBottomSheetBinding.cancelButton.setOnClickListener(new a(this));
        fragmentTproSavingsCancellationBottomSheetBinding.keepProLayout.setOnClickListener(new b(this));
        fragmentTproSavingsCancellationBottomSheetBinding.confirmCancelProLayout.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10420addButtonsListeners$lambda3$lambda0(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProSavingsCancellationBottomSheetFragment, "this$0");
        tProSavingsCancellationBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10421addButtonsListeners$lambda3$lambda1(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProSavingsCancellationBottomSheetFragment, "this$0");
        tProSavingsCancellationBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10422addButtonsListeners$lambda3$lambda2(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProSavingsCancellationBottomSheetFragment, "this$0");
        tProSavingsCancellationBottomSheetFragment.isAbortCancellation = false;
        tProSavingsCancellationBottomSheetFragment.dismiss();
        tProSavingsCancellationBottomSheetFragment.onLeaveProClick.invoke();
    }

    private final void addDismissListener() {
        this.dsBottomSheet.setOnDismiss(new TProSavingsCancellationBottomSheetFragment$addDismissListener$1(this));
    }

    private final void dismiss() {
        this.dsBottomSheet.dismiss();
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setContent() {
        setHeaderText();
        setDescriptionText();
    }

    private final void setDescriptionText() {
        String string = getResources().getString(com.talabat.localization.R.string.tpro_savings_cancel_description, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(this.nextBillingDate, "dd LLLL yyyy")});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …R\n            )\n        )");
        FragmentTproSavingsCancellationBottomSheetBinding fragmentTproSavingsCancellationBottomSheetBinding = this.viewBinding;
        if (fragmentTproSavingsCancellationBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproSavingsCancellationBottomSheetBinding = null;
        }
        fragmentTproSavingsCancellationBottomSheetBinding.tvCancellationText.setText(string);
    }

    private final void setHeaderText() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.savingsInfo.getOverallSavings());
        String string = getResources().getString(com.talabat.localization.R.string.tpro_savings_cancel_header, new Object[]{Customer.getInstance().getCustomerInfo().getFistName(), formattedCurrency});
        Intrinsics.checkNotNullExpressionValue(string, "resources\n            .g…SavingsText\n            )");
        FragmentTproSavingsCancellationBottomSheetBinding fragmentTproSavingsCancellationBottomSheetBinding = this.viewBinding;
        if (fragmentTproSavingsCancellationBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproSavingsCancellationBottomSheetBinding = null;
        }
        fragmentTproSavingsCancellationBottomSheetBinding.tvCancellationHeader.setText(string);
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class);
        Context context2 = context;
        DaggerTproPresentationComponent.factory().create(context2, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), configurationRemoteCoreLibApi, (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproSavingsCancellationBottomSheetBinding fragmentTproSavingsCancellationBottomSheetBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProSavingsCancellationBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProSavingsCancellationBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproSavingsCancellationBottomSheetBinding inflate = FragmentTproSavingsCancellationBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproSavingsCancellationBottomSheetBinding = inflate;
        }
        ConstraintLayout root = fragmentTproSavingsCancellationBottomSheetBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        removePadding();
        setContent();
        addButtonsListeners();
        addDismissListener();
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }
}
