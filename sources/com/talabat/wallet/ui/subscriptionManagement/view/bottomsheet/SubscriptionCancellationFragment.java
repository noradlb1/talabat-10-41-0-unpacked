package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonsDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModelBuilder;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.adapter.SubscriptionCancellationReasonAdapter;
import com.talabat.wallet.ui.subscriptionManagement.view.di.DaggerSubscriptionComponent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ry.a;
import ry.b;
import ry.c;
import ry.d;
import ry.e;
import ry.f;
import ry.g;

@Instrumented
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\b\u00101\u001a\u00020*H\u0003J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020<H\u0016J&\u0010=\u001a\u0004\u0018\u0001082\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010D\u001a\u00020*2\u0006\u00107\u001a\u0002082\b\u0010B\u001a\u0004\u0018\u00010CH\u0017J\b\u0010E\u001a\u00020*H\u0016J\b\u0010F\u001a\u00020*H\u0002J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\bH\u0002J\u0006\u0010I\u001a\u00020*J!\u0010J\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010\u001f2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002¢\u0006\u0002\u0010NJ\u0017\u0010O\u001a\u00020*2\b\u0010P\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010QJ\u0017\u0010R\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010QJ\u0017\u0010T\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010QJ\u0010\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020WH\u0016J\u0012\u0010X\u001a\u00020*2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\u0017\u0010[\u001a\u00020*2\b\u0010\\\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010QJ\u0012\u0010]\u001a\u00020*2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010^\u001a\u00020\u0011H\u0002R\u0010\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter$SubscriptionCancellationReasonAdapterInterface;", "subscriptionMemberId", "", "nextBillingDate", "subscriptionCancellationType", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;", "mSubscriptionCancellationFragmentInterface", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$SubscriptionCancellationFragmentInterface;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationType;Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$SubscriptionCancellationFragmentInterface;)V", "coroutineScope", "com/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$coroutineScope$1", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$coroutineScope$1;", "factory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getGetSavingsInfoUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "setGetSavingsInfoUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;)V", "lastItemChosen", "", "subscriptionCancellationReasonAdapter", "Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlag", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlag", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "viewModel", "addCancelIconClickListener", "", "addCancelSubscriptionCancellationListener", "addCancellationEditText", "addCancellationFeedbackListener", "addConfirmSubscriptionCancellationListener", "addDismissOnFailureScreenListener", "addDismissOnSuccessScreenListener", "addEditTextOnTouchListener", "addObservers", "cancelSubscription", "cancellationReasonFailureAndSubscriptionRenewalCheck", "collapseKeyBoard", "hideKeyBoard", "view", "Landroid/view/View;", "initializeRecyclerView", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "openKeyBoard", "setCancellationOrderReason", "setUpViews", "cancellationType", "showKeyboard", "showReasonSelectionView", "isSubscriptionRenewalStatusChanged", "subscriptionCancellationReasonsDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;", "(Ljava/lang/Boolean;Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;)V", "updateCancellationFeedbackFailure", "isCancellationFeedbackFailure", "(Ljava/lang/Boolean;)V", "updateCancellationReasonFailure", "isError", "updateRenewalStatus", "updateSelectedReason", "model", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonDisplayModel;", "updateSubscriptionCancellationFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "updateSubscriptionCancellationFeedback", "isFeedbackSubmitted", "updateSubscriptionCancellationReasons", "viewModelBuilder", "SubscriptionCancellationFragmentInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationFragment extends Fragment implements AnimationHelper, SubscriptionCancellationReasonAdapter.SubscriptionCancellationReasonAdapterInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private SubscriptionCancellationFragment$coroutineScope$1 coroutineScope;
    @NotNull
    private BaseViewModelFactory<SubscriptionManagementViewModel> factory;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GetSavingsInfoUseCase getSavingsInfoUseCase;
    private boolean lastItemChosen;
    /* access modifiers changed from: private */
    @Nullable
    public final SubscriptionCancellationFragmentInterface mSubscriptionCancellationFragmentInterface;
    @NotNull
    private final String nextBillingDate;
    /* access modifiers changed from: private */
    @Nullable
    public SubscriptionCancellationReasonAdapter subscriptionCancellationReasonAdapter;
    @NotNull
    private final SubscriptionCancellationType subscriptionCancellationType;
    /* access modifiers changed from: private */
    @NotNull
    public final String subscriptionMemberId;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;
    private SubscriptionManagementViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationFragment$SubscriptionCancellationFragmentInterface;", "", "onBottomSheetClosed", "", "onRefreshSubscriptionDetailScreen", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionCancellationFragmentInterface {
        void onBottomSheetClosed();

        void onRefreshSubscriptionDetailScreen();
    }

    public SubscriptionCancellationFragment(@NotNull String str, @NotNull String str2, @NotNull SubscriptionCancellationType subscriptionCancellationType2, @Nullable SubscriptionCancellationFragmentInterface subscriptionCancellationFragmentInterface) {
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(str2, "nextBillingDate");
        Intrinsics.checkNotNullParameter(subscriptionCancellationType2, "subscriptionCancellationType");
        this.subscriptionMemberId = str;
        this.nextBillingDate = str2;
        this.subscriptionCancellationType = subscriptionCancellationType2;
        this.mSubscriptionCancellationFragmentInterface = subscriptionCancellationFragmentInterface;
        this.coroutineScope = new SubscriptionCancellationFragment$coroutineScope$1();
        this.factory = new BaseViewModelFactory<>(new SubscriptionCancellationFragment$factory$1(this));
    }

    private final void addCancelIconClickListener() {
        ((ImageView) _$_findCachedViewById(R.id.cancel_button)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancelIconClickListener$lambda-0  reason: not valid java name */
    public static final void m6026addCancelIconClickListener$lambda0(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        SubscriptionCancellationFragmentInterface subscriptionCancellationFragmentInterface = subscriptionCancellationFragment.mSubscriptionCancellationFragmentInterface;
        if (subscriptionCancellationFragmentInterface != null) {
            subscriptionCancellationFragmentInterface.onBottomSheetClosed();
        }
    }

    private final void addCancelSubscriptionCancellationListener() {
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.cancel)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancelSubscriptionCancellationListener$lambda-1  reason: not valid java name */
    public static final void m6027addCancelSubscriptionCancellationListener$lambda1(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        SubscriptionCancellationFragmentInterface subscriptionCancellationFragmentInterface = subscriptionCancellationFragment.mSubscriptionCancellationFragmentInterface;
        if (subscriptionCancellationFragmentInterface != null) {
            subscriptionCancellationFragmentInterface.onBottomSheetClosed();
        }
    }

    private final void addCancellationEditText() {
        ((MaterialEditText) _$_findCachedViewById(R.id.cancellation_reason_further_explanation)).addTextChangedListener(new SubscriptionCancellationFragment$addCancellationEditText$1(this));
    }

    private final void addCancellationFeedbackListener() {
        ((TalabatFillButton) _$_findCachedViewById(R.id.submit_cancellation_feedback)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancellationFeedbackListener$lambda-7  reason: not valid java name */
    public static final void m6028addCancellationFeedbackListener$lambda7(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        MaterialEditText materialEditText = (MaterialEditText) subscriptionCancellationFragment._$_findCachedViewById(R.id.cancellation_reason_further_explanation);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "cancellation_reason_further_explanation");
        subscriptionCancellationFragment.hideKeyBoard(materialEditText);
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        ProgressBar progressBar = (ProgressBar) subscriptionCancellationFragment._$_findCachedViewById(R.id.feedback_progress_bar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "feedback_progress_bar");
        progressBarLoading.showProgress(progressBar);
        subscriptionCancellationFragment.setCancellationOrderReason();
        SubscriptionManagementViewModel subscriptionManagementViewModel = subscriptionCancellationFragment.viewModel;
        SubscriptionManagementViewModel subscriptionManagementViewModel2 = null;
        if (subscriptionManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel = null;
        }
        String str = subscriptionCancellationFragment.subscriptionMemberId;
        SubscriptionManagementViewModel subscriptionManagementViewModel3 = subscriptionCancellationFragment.viewModel;
        if (subscriptionManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel3 = null;
        }
        String cancellationReasonId = subscriptionManagementViewModel3.getCancellationReasonId();
        SubscriptionManagementViewModel subscriptionManagementViewModel4 = subscriptionCancellationFragment.viewModel;
        if (subscriptionManagementViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            subscriptionManagementViewModel2 = subscriptionManagementViewModel4;
        }
        subscriptionManagementViewModel.postSubscriptionCancellationFeedback(new SubscriptionCancellationFeedbackRequest(cancellationReasonId, str, subscriptionManagementViewModel2.getCancellationOtherReason()));
        ((TalabatFillButton) subscriptionCancellationFragment._$_findCachedViewById(R.id.submit_cancellation_feedback)).setEnabled(false);
    }

    private final void addConfirmSubscriptionCancellationListener() {
        ((TalabatFillButton) _$_findCachedViewById(R.id.confirm)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addConfirmSubscriptionCancellationListener$lambda-11  reason: not valid java name */
    public static final void m6029addConfirmSubscriptionCancellationListener$lambda11(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        subscriptionCancellationFragment.cancelSubscription();
        ((TalabatFillButton) subscriptionCancellationFragment._$_findCachedViewById(R.id.confirm)).setEnabled(false);
    }

    private final void addDismissOnFailureScreenListener() {
        ((TextView) _$_findCachedViewById(R.id.failure_dismiss)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addDismissOnFailureScreenListener$lambda-3  reason: not valid java name */
    public static final void m6030addDismissOnFailureScreenListener$lambda3(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        SubscriptionCancellationFragmentInterface subscriptionCancellationFragmentInterface = subscriptionCancellationFragment.mSubscriptionCancellationFragmentInterface;
        if (subscriptionCancellationFragmentInterface != null) {
            subscriptionCancellationFragmentInterface.onBottomSheetClosed();
        }
    }

    private final void addDismissOnSuccessScreenListener() {
        ((TextView) _$_findCachedViewById(R.id.success_dismiss)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addDismissOnSuccessScreenListener$lambda-4  reason: not valid java name */
    public static final void m6031addDismissOnSuccessScreenListener$lambda4(SubscriptionCancellationFragment subscriptionCancellationFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFragment, "this$0");
        SubscriptionCancellationFragmentInterface subscriptionCancellationFragmentInterface = subscriptionCancellationFragment.mSubscriptionCancellationFragmentInterface;
        if (subscriptionCancellationFragmentInterface != null) {
            subscriptionCancellationFragmentInterface.onBottomSheetClosed();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void addEditTextOnTouchListener() {
        ((MaterialEditText) _$_findCachedViewById(R.id.cancellation_reason_further_explanation)).setOnTouchListener(new c());
    }

    /* access modifiers changed from: private */
    /* renamed from: addEditTextOnTouchListener$lambda-2  reason: not valid java name */
    public static final boolean m6032addEditTextOnTouchListener$lambda2(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.cancellation_reason_further_explanation) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if ((motionEvent.getAction() & 255) == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    private final void addObservers() {
        SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
        SubscriptionManagementViewModel subscriptionManagementViewModel2 = null;
        if (subscriptionManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel = null;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel.getSubscriptionCancellationReasonsData(), new SubscriptionCancellationFragment$addObservers$1(this));
        SubscriptionManagementViewModel subscriptionManagementViewModel3 = this.viewModel;
        if (subscriptionManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel3 = null;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel3.getSubscriptionPostCancellationFeedbackData(), new SubscriptionCancellationFragment$addObservers$2(this));
        SubscriptionManagementViewModel subscriptionManagementViewModel4 = this.viewModel;
        if (subscriptionManagementViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel4 = null;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel4.getSubscriptionAutoRenewData(), new SubscriptionCancellationFragment$addObservers$3(this));
        SubscriptionManagementViewModel subscriptionManagementViewModel5 = this.viewModel;
        if (subscriptionManagementViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel5 = null;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel5.getSubscriptionCancellationReasonsFailureData(), new SubscriptionCancellationFragment$addObservers$4(this));
        SubscriptionManagementViewModel subscriptionManagementViewModel6 = this.viewModel;
        if (subscriptionManagementViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel6 = null;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel6.getFailureData(), new SubscriptionCancellationFragment$addObservers$5(this));
        SubscriptionManagementViewModel subscriptionManagementViewModel7 = this.viewModel;
        if (subscriptionManagementViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            subscriptionManagementViewModel2 = subscriptionManagementViewModel7;
        }
        LifecycleKt.observe(this, subscriptionManagementViewModel2.getCancellationFeedbackFailureData(), new SubscriptionCancellationFragment$addObservers$6(this));
    }

    private final void cancelSubscription() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
        SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
        if (subscriptionManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel = null;
        }
        subscriptionManagementViewModel.getSubscriptionCancellationReasons();
        SubscriptionManagementViewModel subscriptionManagementViewModel2 = this.viewModel;
        if (subscriptionManagementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel2 = null;
        }
        subscriptionManagementViewModel2.updateSubscriptionAutoRenewStatus(this.subscriptionMemberId, new SubscriptionAutoRenewRequestModel(Boolean.FALSE, (Boolean) null, 2, (DefaultConstructorMarker) null));
    }

    private final void cancellationReasonFailureAndSubscriptionRenewalCheck() {
        SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
        SubscriptionManagementViewModel subscriptionManagementViewModel2 = null;
        if (subscriptionManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel = null;
        }
        Boolean value = subscriptionManagementViewModel.getSubscriptionCancellationReasonsFailureData().getValue();
        SubscriptionManagementViewModel subscriptionManagementViewModel3 = this.viewModel;
        if (subscriptionManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            subscriptionManagementViewModel2 = subscriptionManagementViewModel3;
        }
        SafeLetKt.safeLet(value, subscriptionManagementViewModel2.getSubscriptionAutoRenewData().getValue(), new SubscriptionCancellationFragment$cancellationReasonFailureAndSubscriptionRenewalCheck$1(this));
    }

    private final void hideKeyBoard(View view) {
        Object obj;
        Context context = getContext();
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        if (obj != null) {
            ((InputMethodManager) obj).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.subscriptionCancellationReasonAdapter = new SubscriptionCancellationReasonAdapter(this);
            int i11 = R.id.cancellation_reasons_list;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.subscriptionCancellationReasonAdapter);
            ((RecyclerView) _$_findCachedViewById(i11)).setNestedScrollingEnabled(false);
        }
    }

    private final void setCancellationOrderReason() {
        Editable text;
        String str = null;
        if (this.lastItemChosen) {
            SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
            if (subscriptionManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                subscriptionManagementViewModel = null;
            }
            MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(R.id.cancellation_reason_further_explanation);
            if (!(materialEditText == null || (text = materialEditText.getText()) == null)) {
                str = text.toString();
            }
            if (str == null) {
                str = "";
            }
            subscriptionManagementViewModel.setCancellationOtherReason(str);
            return;
        }
        SubscriptionManagementViewModel subscriptionManagementViewModel2 = this.viewModel;
        if (subscriptionManagementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel2 = null;
        }
        subscriptionManagementViewModel2.setCancellationOtherReason((String) null);
    }

    private final void setUpViews(SubscriptionCancellationType subscriptionCancellationType2) {
        if (subscriptionCancellationType2 == SubscriptionCancellationType.ImmediateCancel) {
            String string = getString(com.talabat.localization.R.string.immediate_cancel_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…immediate_cancel_message)");
            ((TextView) _$_findCachedViewById(R.id.cancel_subscription_message)).setText(string);
            TextView textView = (TextView) _$_findCachedViewById(R.id.success_message);
            Intrinsics.checkNotNullExpressionValue(textView, "success_message");
            textView.setVisibility(8);
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.cancel_subscription_message)).setText(HtmlCompat.fromHtml(getString(com.talabat.localization.R.string.next_billing_date_with_cancel_message) + "<b> " + this.nextBillingDate + "</b>", 0));
        String str = getString(com.talabat.localization.R.string.cancellation_success_message) + "<b> " + this.nextBillingDate + "</b>";
        int i11 = R.id.success_message;
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(textView2, "success_message");
        textView2.setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setText(HtmlCompat.fromHtml(str, 0));
    }

    private final void showReasonSelectionView(Boolean bool, SubscriptionCancellationReasonsDisplayModel subscriptionCancellationReasonsDisplayModel) {
        SafeLetKt.safeLet(bool, subscriptionCancellationReasonsDisplayModel, new SubscriptionCancellationFragment$showReasonSelectionView$1(this));
    }

    /* access modifiers changed from: private */
    public final void updateCancellationFeedbackFailure(Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
            String string = getString(com.talabat.localization.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.something_went_wrong)");
            Status.Companion.notify$default(Status.Companion, getActivity(), (LinearLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout), string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
            ((TalabatFillButton) _$_findCachedViewById(R.id.submit_cancellation_feedback)).setEnabled(true);
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.feedback_progress_bar);
            Intrinsics.checkNotNullExpressionValue(progressBar, "feedback_progress_bar");
            progressBarLoading.hideProgress(progressBar);
        }
    }

    /* access modifiers changed from: private */
    public final void updateCancellationReasonFailure(Boolean bool) {
        cancellationReasonFailureAndSubscriptionRenewalCheck();
    }

    /* access modifiers changed from: private */
    public final void updateRenewalStatus(Boolean bool) {
        if (bool != null) {
            Boolean valueOf = Boolean.valueOf(bool.booleanValue());
            SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
            if (subscriptionManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                subscriptionManagementViewModel = null;
            }
            showReasonSelectionView(valueOf, subscriptionManagementViewModel.getSubscriptionCancellationReasonsData().getValue());
        }
        cancellationReasonFailureAndSubscriptionRenewalCheck();
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionCancellationFailure(Failure failure) {
        if (failure != null) {
            _$_findCachedViewById(R.id.cancel_subscription_failure_container).setVisibility(0);
            _$_findCachedViewById(R.id.initialize_subscription_cancellation).setVisibility(8);
            delay(5000, new SubscriptionCancellationFragment$updateSubscriptionCancellationFailure$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionCancellationFeedback(Boolean bool) {
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.feedback_progress_bar);
            Intrinsics.checkNotNullExpressionValue(progressBar, "feedback_progress_bar");
            progressBarLoading.hideProgress(progressBar);
            if (booleanValue) {
                _$_findCachedViewById(R.id.cancel_subscription_success_container).setVisibility(0);
            } else {
                _$_findCachedViewById(R.id.cancel_subscription_failure_container).setVisibility(0);
            }
            _$_findCachedViewById(R.id.cancellation_feedback).setVisibility(8);
            delay(5000, new SubscriptionCancellationFragment$updateSubscriptionCancellationFeedback$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionCancellationReasons(SubscriptionCancellationReasonsDisplayModel subscriptionCancellationReasonsDisplayModel) {
        if (subscriptionCancellationReasonsDisplayModel != null) {
            SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
            if (subscriptionManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                subscriptionManagementViewModel = null;
            }
            showReasonSelectionView(subscriptionManagementViewModel.getSubscriptionAutoRenewData().getValue(), subscriptionCancellationReasonsDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final SubscriptionManagementViewModel viewModelBuilder() {
        SubscriptionManagementViewModelBuilder.Companion companion = SubscriptionManagementViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getSubscriptionManagementViewModel(requireContext, this.coroutineScope, getFeatureFlagRepo(), getGetSavingsInfoUseCase(), getSubscriptionsFeatureFlag());
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void collapseKeyBoard() {
        this.lastItemChosen = false;
        int i11 = R.id.cancellation_reason_further_explanation;
        ((MaterialEditText) _$_findCachedViewById(i11)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.edit_text_counter)).setVisibility(8);
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "cancellation_reason_further_explanation");
        hideKeyBoard(materialEditText);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public final GetSavingsInfoUseCase getGetSavingsInfoUseCase() {
        GetSavingsInfoUseCase getSavingsInfoUseCase2 = this.getSavingsInfoUseCase;
        if (getSavingsInfoUseCase2 != null) {
            return getSavingsInfoUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getSavingsInfoUseCase");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlag() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlag;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureFlag");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerSubscriptionComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SubscriptionCancellationFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SubscriptionCancellationFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_subscription_cancellation_feedback, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeRecyclerView();
        this.viewModel = (SubscriptionManagementViewModel) ViewModelInjectorKt.injectViewModel((Fragment) this, SubscriptionManagementViewModel.class, (ViewModelProvider.Factory) this.factory);
        setUpViews(this.subscriptionCancellationType);
        addConfirmSubscriptionCancellationListener();
        addCancelSubscriptionCancellationListener();
        addCancelIconClickListener();
        addCancellationFeedbackListener();
        addDismissOnSuccessScreenListener();
        addDismissOnFailureScreenListener();
        addEditTextOnTouchListener();
        addCancellationEditText();
        addObservers();
    }

    public void openKeyBoard() {
        this.lastItemChosen = true;
        int i11 = R.id.cancellation_reason_further_explanation;
        ((MaterialEditText) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.edit_text_counter)).setVisibility(0);
        ((MaterialEditText) _$_findCachedViewById(i11)).requestFocus();
        showKeyboard();
        delay(350, new SubscriptionCancellationFragment$openKeyBoard$1(this));
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGetSavingsInfoUseCase(@NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2) {
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "<set-?>");
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
    }

    public final void setSubscriptionsFeatureFlag(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public final void showKeyboard() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public void updateSelectedReason(@NotNull SubscriptionCancellationReasonDisplayModel subscriptionCancellationReasonDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonDisplayModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        SubscriptionManagementViewModel subscriptionManagementViewModel = this.viewModel;
        if (subscriptionManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subscriptionManagementViewModel = null;
        }
        subscriptionManagementViewModel.setCancellationReasonId(subscriptionCancellationReasonDisplayModel.getId());
        ((TalabatFillButton) _$_findCachedViewById(R.id.submit_cancellation_feedback)).setEnabled(true);
    }
}
