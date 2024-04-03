package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.utils.DisplayUtils;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModelBuilder;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementBottomSheet;
import com.talabat.wallet.ui.subscriptionManagement.view.adapter.SubscriptionProductAdapter;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationBottomSheet;
import com.talabat.wallet.ui.subscriptionManagement.view.di.DaggerSubscriptionComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ty.a;
import ty.b;
import ty.c;
import ty.d;
import ty.e;
import ty.f;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020-H\u0002J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020:H\u0016J\u0012\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020-H\u0002J\b\u0010E\u001a\u00020-H\u0016J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020-H\u0016J\b\u0010J\u001a\u00020-H\u0016J\b\u0010K\u001a\u00020-H\u0016J\u001a\u0010L\u001a\u00020-2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020-H\u0002J\u0010\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020=H\u0002J&\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020-0YH\u0002J\u0010\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020-H\u0002J\b\u0010^\u001a\u00020-H\u0002J\b\u0010_\u001a\u00020-H\u0002J\b\u0010`\u001a\u00020-H\u0002J\u0012\u0010a\u001a\u00020-2\b\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0010\u0010d\u001a\u00020-2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010e\u001a\u00020-2\u0006\u0010[\u001a\u00020\\H\u0002J\b\u0010f\u001a\u00020-H\u0002J\u0018\u0010g\u001a\u00020-2\u0006\u0010h\u001a\u00020\b2\u0006\u0010i\u001a\u00020\bH\u0002J\u0010\u0010j\u001a\u00020-2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u00020VH\u0002J\u0010\u0010m\u001a\u00020-2\u0006\u00104\u001a\u00020\bH\u0002J\u0010\u0010n\u001a\u00020-2\u0006\u0010<\u001a\u00020=H\u0016J\u0017\u0010o\u001a\u00020-2\b\u0010p\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010qJ\u0010\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020tH\u0016J\u0017\u0010u\u001a\u00020-2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010qJ\u0012\u0010w\u001a\u00020-2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\b\u0010x\u001a\u00020\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006y"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/fragment/SubscriptionDetailFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet$SubscriptionManagementBottomSheetInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/bottomsheet/SubscriptionCancellationBottomSheet$SubscriptionCancellationBottomSheetInterface;", "()V", "cancelSubscriptionIsClicked", "", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getGetSavingsInfoUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "setGetSavingsInfoUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;)V", "isCardJustSuccessfullyAdded", "isSavingsFlowEnabled", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "subscriptionAutoRenewIsClicked", "subscriptionProductAdapter", "Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionProductAdapter;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlag", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlag", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "addBackButtonListener", "", "addCancelSubscriptionListener", "addDefaultSubscriptionCard", "addEnableAutoRenewListener", "addTermsAndConditionListeners", "cancelSubscription", "enableCancelSubscriptionButton", "isEnabled", "extractArgumentExtras", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "getWalletAddedCard", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "handleCancelSubscriptionSuccess", "initializeRecyclerView", "initializeSavingsFeatureFlag", "layoutId", "", "navigateToAddCard", "navigateToSubscriptionScreen", "observatory", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onBottomSheetClosed", "onRefreshSubscriptionDetailScreen", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openCancelBottomSheet", "openCardListBottomSheet", "walletCardList", "showAlertDialog", "title", "", "body", "yesAction", "Lkotlin/Function0;", "showAutoRenewDate", "subscriptionItemDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "showAutoRenewViews", "showAutoRenewalSuccessNotification", "showCancalationBottomSheet", "showCancelledAutoRenewView", "showCardListBottomSheet", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "showPlanAmount", "showPlanDuration", "showSavingsBottomSheet", "showSubscriptionButton", "isAutoRenewable", "isActive", "showSubscriptionDetailViews", "showSubscriptionImage", "imageUrl", "updateAutoRenew", "updateCardList", "updateRenewalStatus", "isSubscriptionRenewalStatusChanged", "(Ljava/lang/Boolean;)V", "updateSubscriptionDefaultCard", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "updateSubscriptionDefaultCardSet", "isSubscriptionDefaultCardSet", "updateSubscriptionDetail", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Replaced with com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment")
public class SubscriptionDetailFragment extends BaseFragment implements SubscriptionManagementBottomSheet.SubscriptionManagementBottomSheetInterface, AnimationHelper, SubscriptionCancellationBottomSheet.SubscriptionCancellationBottomSheetInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean cancelSubscriptionIsClicked;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GetSavingsInfoUseCase getSavingsInfoUseCase;
    private boolean isCardJustSuccessfullyAdded;
    private boolean isSavingsFlowEnabled;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    private boolean subscriptionAutoRenewIsClicked;
    @Nullable
    private SubscriptionProductAdapter subscriptionProductAdapter;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;

    private final void addBackButtonListener() {
        ((ImageButton) _$_findCachedViewById(R.id.back_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addBackButtonListener$lambda-17  reason: not valid java name */
    public static final void m6033addBackButtonListener$lambda17(SubscriptionDetailFragment subscriptionDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionDetailFragment, "this$0");
        subscriptionDetailFragment.navigateToSubscriptionScreen();
    }

    private final void addCancelSubscriptionListener() {
        ((LinearLayout) _$_findCachedViewById(R.id.cancel_auto_renew)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancelSubscriptionListener$lambda-2  reason: not valid java name */
    public static final void m6034addCancelSubscriptionListener$lambda2(SubscriptionDetailFragment subscriptionDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionDetailFragment, "this$0");
        subscriptionDetailFragment.openCancelBottomSheet();
    }

    /* access modifiers changed from: private */
    public final void addDefaultSubscriptionCard() {
        if (!((SubscriptionManagementViewModel) getViewModel()).getWalletCardList().getCardList().isEmpty()) {
            openCardListBottomSheet(((SubscriptionManagementViewModel) getViewModel()).getWalletCardList());
        } else {
            navigateToAddCard();
        }
    }

    private final void addEnableAutoRenewListener() {
        ((LinearLayout) _$_findCachedViewById(R.id.enable_auto_renew)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addEnableAutoRenewListener$lambda-5  reason: not valid java name */
    public static final void m6035addEnableAutoRenewListener$lambda5(SubscriptionDetailFragment subscriptionDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionDetailFragment, "this$0");
        subscriptionDetailFragment.subscriptionAutoRenewIsClicked = true;
        if (((SubscriptionManagementViewModel) subscriptionDetailFragment.getViewModel()).isSubscriptionDefaultCardAvailable()) {
            subscriptionDetailFragment.updateAutoRenew(true);
            return;
        }
        String string = subscriptionDetailFragment.getString(com.talabat.localization.R.string.add_a_card);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…tion.R.string.add_a_card)");
        String string2 = subscriptionDetailFragment.getString(com.talabat.localization.R.string.add_a_card_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…tring.add_a_card_message)");
        subscriptionDetailFragment.showAlertDialog(string, string2, new SubscriptionDetailFragment$addEnableAutoRenewListener$1$1(subscriptionDetailFragment));
    }

    private final void addTermsAndConditionListeners() {
        ((TableLayout) _$_findCachedViewById(R.id.terms_and_conditions_container)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addTermsAndConditionListeners$lambda-9  reason: not valid java name */
    public static final void m6036addTermsAndConditionListeners$lambda9(SubscriptionDetailFragment subscriptionDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionDetailFragment, "this$0");
        Context context = subscriptionDetailFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletWebView(((SubscriptionManagementViewModel) subscriptionDetailFragment.getViewModel()).getTermsAndConditionUrl()));
        }
    }

    /* access modifiers changed from: private */
    public final void cancelSubscription() {
        this.cancelSubscriptionIsClicked = true;
        updateAutoRenew(false);
    }

    /* access modifiers changed from: private */
    public final void enableCancelSubscriptionButton(boolean z11) {
        ((LinearLayout) _$_findCachedViewById(R.id.cancel_auto_renew)).setEnabled(z11);
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void extractArgumentExtras() {
        /*
            r9 = this;
            com.talabat.talabatcore.viewmodel.BaseViewModel r0 = r9.getViewModel()
            com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel r0 = (com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel) r0
            android.os.Bundle r1 = r9.getArguments()
            r2 = 0
            if (r1 == 0) goto L_0x0014
            java.lang.String r3 = "subscriptionMemberId"
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r1 != 0) goto L_0x0019
            java.lang.String r1 = ""
        L_0x0019:
            r0.setSubscriptionMemberId(r1)
            android.os.Bundle r1 = r9.getArguments()
            if (r1 == 0) goto L_0x002d
            java.lang.String r3 = "isSubscriptionDefaultCardAvailable"
            boolean r1 = r1.getBoolean(r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x002e
        L_0x002d:
            r1 = r2
        L_0x002e:
            boolean r1 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r1)
            r0.setSubscriptionDefaultCardAvailable(r1)
            android.os.Bundle r1 = r9.getArguments()
            if (r1 == 0) goto L_0x0044
            java.lang.String r2 = "walletCardList"
            android.os.Parcelable r1 = r1.getParcelable(r2)
            r2 = r1
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r2 = (com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel) r2
        L_0x0044:
            if (r2 != 0) goto L_0x0051
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r2 = new com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x0051:
            r0.setWalletCardList(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment.extractArgumentExtras():void");
    }

    /* access modifiers changed from: private */
    public final void getWalletAddedCard(WalletCardListDisplayModel walletCardListDisplayModel) {
        if (walletCardListDisplayModel != null) {
            if ((!walletCardListDisplayModel.getCardList().isEmpty()) && this.isCardJustSuccessfullyAdded) {
                this.isCardJustSuccessfullyAdded = false;
                WalletCardDisplayModel walletCardDisplayModel = walletCardListDisplayModel.getCardList().get(0);
                ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCard(new SubscriptionDefaultCardRequestModel(walletCardDisplayModel.getTokenId(), StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4), walletCardDisplayModel.getCardType(), WalletCardListMapper.Companion.formatCardExpiryDate(walletCardDisplayModel.getExpiryMonth(), walletCardDisplayModel.getExpiryYear())));
            }
            ((SubscriptionManagementViewModel) getViewModel()).setWalletCardList(walletCardListDisplayModel);
        }
    }

    private final void handleCancelSubscriptionSuccess() {
        this.cancelSubscriptionIsClicked = false;
        SubscriptionCancellationReasonBottomSheetFragment.Companion companion = SubscriptionCancellationReasonBottomSheetFragment.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.show(requireActivity, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId());
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.subscriptionProductAdapter = new SubscriptionProductAdapter();
            int i11 = R.id.plan_product_list;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.subscriptionProductAdapter);
            ((RecyclerView) _$_findCachedViewById(i11)).setNestedScrollingEnabled(false);
        }
    }

    private final void initializeSavingsFeatureFlag() {
        this.isSavingsFlowEnabled = getSubscriptionsFeatureFlag().isSavingsFlowEnabled();
    }

    private final void navigateToAddCard() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createSubscriptionDetailNavigation$default(WalletNavigatorActions.Companion, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId(), "talabat.action.Wallet.SubscriptionDetailActivity", "talabat.action.Wallet.addcard", false, 8, (Object) null));
        }
    }

    private final void navigateToSubscriptionScreen() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    private final void openCancelBottomSheet() {
        SubscriptionSavingsInfo value = ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionsSavingsData().getValue();
        if (!this.isSavingsFlowEnabled || value == null || value.getOverallSavings() <= 0.0f) {
            showCancalationBottomSheet();
        } else {
            showSavingsBottomSheet();
        }
    }

    private final void openCardListBottomSheet(WalletCardListDisplayModel walletCardListDisplayModel) {
        ((SubscriptionManagementViewModel) getViewModel()).getWalletCardListData().setValue(walletCardListDisplayModel);
        showCardListBottomSheet(getFragmentManager());
    }

    private final void showAlertDialog(String str, String str2, Function0<Unit> function0) {
        Context context = getContext();
        if (context != null) {
            new AlertDialog.Builder(context, com.talabat.talabatcommon.R.style.GreenAlertDialog).setTitle((CharSequence) str).setMessage((CharSequence) str2).setPositiveButton(com.talabat.localization.R.string.confirm, (DialogInterface.OnClickListener) new b(function0)).setNegativeButton(com.talabat.localization.R.string.not_now, (DialogInterface.OnClickListener) new c()).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-21$lambda-19  reason: not valid java name */
    public static final void m6037showAlertDialog$lambda21$lambda19(Function0 function0, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function0, "$yesAction");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-21$lambda-20  reason: not valid java name */
    public static final void m6038showAlertDialog$lambda21$lambda20(DialogInterface dialogInterface, int i11) {
    }

    private final void showAutoRenewDate(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        if (subscriptionItemDisplayModel.isAutoRenewable()) {
            ((TextView) _$_findCachedViewById(R.id.plan_expiry_date)).setText(getString(com.talabat.localization.R.string.subscription_renew_date, DateUtils.Companion.getLocalizedFormattedDateString(subscriptionItemDisplayModel.getNextBillingDate(), "dd LLLL yyyy")));
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.plan_expiry_date)).setText(getString(com.talabat.localization.R.string.subscription_expires_date, DateUtils.Companion.getLocalizedFormattedDateString(subscriptionItemDisplayModel.getNextBillingDate(), "dd LLLL yyyy")));
    }

    private final void showAutoRenewViews() {
        ((Button) _$_findCachedViewById(R.id.subscription_active_button)).setVisibility(0);
        ((Button) _$_findCachedViewById(R.id.subscription_cancel_button)).setVisibility(4);
        ((LinearLayout) _$_findCachedViewById(R.id.enable_auto_renew)).setVisibility(4);
        ((LinearLayout) _$_findCachedViewById(R.id.cancel_auto_renew)).setVisibility(0);
    }

    private final void showAutoRenewalSuccessNotification() {
        delay(AnimationSpeed.NORMAL.getValue(), new SubscriptionDetailFragment$showAutoRenewalSuccessNotification$1(this));
    }

    private final void showCancalationBottomSheet() {
        String str;
        DateUtils.Companion companion = DateUtils.Companion;
        SubscriptionItemDisplayModel value = ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetailData().getValue();
        if (value != null) {
            str = value.getNextBillingDate();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        SubscriptionCancellationBottomSheet subscriptionCancellationBottomSheet = new SubscriptionCancellationBottomSheet(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId(), companion.getFormattedDateString(str, "dd LLLL yyyy"), SubscriptionCancellationType.None, this);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.beginTransaction();
        }
        FragmentManager fragmentManager2 = getFragmentManager();
        if (fragmentManager2 != null) {
            subscriptionCancellationBottomSheet.show(fragmentManager2, "subscriptionCancellationBottomSheet");
        }
    }

    private final void showCancelledAutoRenewView() {
        ((Button) _$_findCachedViewById(R.id.subscription_cancel_button)).setVisibility(0);
        ((Button) _$_findCachedViewById(R.id.subscription_active_button)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.enable_auto_renew)).setVisibility(0);
        ((LinearLayout) _$_findCachedViewById(R.id.cancel_auto_renew)).setVisibility(8);
    }

    private final void showCardListBottomSheet(FragmentManager fragmentManager) {
        SubscriptionManagementBottomSheet subscriptionManagementBottomSheet = new SubscriptionManagementBottomSheet(((SubscriptionManagementViewModel) getViewModel()).getWalletCardList(), ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDefaultCardData().getValue(), this, false);
        if (fragmentManager != null) {
            fragmentManager.beginTransaction();
            subscriptionManagementBottomSheet.show(fragmentManager, "");
        }
    }

    private final void showPlanAmount(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        ((TextView) _$_findCachedViewById(R.id.plan_amount)).setText(getString(com.talabat.localization.R.string.plan_amount, subscriptionItemDisplayModel.getSubscriptionPlanItem().getCurrency(), String.valueOf((int) subscriptionItemDisplayModel.getSubscriptionPlanItem().getAmount())));
    }

    private final void showPlanDuration(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        WalletSubscriptionMapper.Companion companion = WalletSubscriptionMapper.Companion;
        int durationDays = subscriptionItemDisplayModel.getSubscriptionPlanItem().getDurationDays();
        String string = getString(com.talabat.localization.R.string.per_day);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ization.R.string.per_day)");
        String string2 = getString(com.talabat.localization.R.string.per_week);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…zation.R.string.per_week)");
        String string3 = getString(com.talabat.localization.R.string.per_month);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(com.talabat.lo…ation.R.string.per_month)");
        String string4 = getString(com.talabat.localization.R.string.per_year);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(com.talabat.lo…zation.R.string.per_year)");
        String string5 = getString(com.talabat.localization.R.string.months);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(com.talabat.lo…lization.R.string.months)");
        String string6 = getString(com.talabat.localization.R.string.per);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(com.talabat.localization.R.string.per)");
        ((TextView) _$_findCachedViewById(R.id.plan_duration)).setText(companion.subscriptionDurationStringMapper(durationDays, string, string2, string3, string4, string5, string6));
    }

    private final void showSavingsBottomSheet() {
        String str;
        SubscriptionSavingsInfo value = ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionsSavingsData().getValue();
        if (value != null) {
            TProSavingsCancellationBottomSheetFragment.Companion companion = TProSavingsCancellationBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SubscriptionItemDisplayModel value2 = ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetailData().getValue();
            if (value2 != null) {
                str = value2.getNextBillingDate();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            companion.show(requireActivity, value, str, new SubscriptionDetailFragment$showSavingsBottomSheet$1$1(this), SubscriptionDetailFragment$showSavingsBottomSheet$1$2.INSTANCE);
        }
    }

    private final void showSubscriptionButton(boolean z11, boolean z12) {
        if (z11 && z12) {
            showAutoRenewViews();
        } else if (!z11 && z12) {
            showCancelledAutoRenewView();
        }
    }

    private final void showSubscriptionDetailViews(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        SubscriptionProductAdapter subscriptionProductAdapter2;
        showSubscriptionImage(subscriptionItemDisplayModel.getSubscriptionPlanItem().getImageUrl());
        ((TextView) _$_findCachedViewById(R.id.plan_name)).setText(subscriptionItemDisplayModel.getSubscriptionPlanItem().getTitle());
        showSubscriptionButton(subscriptionItemDisplayModel.isAutoRenewable(), subscriptionItemDisplayModel.isActive());
        showAutoRenewDate(subscriptionItemDisplayModel);
        ((TextView) _$_findCachedViewById(R.id.plan_detail)).setText(StringsKt__StringsJVMKt.replace$default(subscriptionItemDisplayModel.getSubscriptionPlanItem().getDescription(), "|", " \n", false, 4, (Object) null));
        if (subscriptionItemDisplayModel.getSubscriptionPlanItem().getProducts().size() > 0 && (subscriptionProductAdapter2 = this.subscriptionProductAdapter) != null) {
            subscriptionProductAdapter2.addItems(subscriptionItemDisplayModel.getSubscriptionPlanItem().getProducts());
        }
        showPlanAmount(subscriptionItemDisplayModel);
        showPlanDuration(subscriptionItemDisplayModel);
        ((TableLayout) _$_findCachedViewById(R.id.terms_and_conditions_container)).setVisibility(0);
        hideProgress();
    }

    private final void showSubscriptionImage(String str) {
        Context context = getContext();
        if (context != null) {
            ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.toolbar_content);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "toolbar_content");
            companion.downloadImageAsBackground(context, str, relativeLayout);
        }
    }

    private final void updateAutoRenew(boolean z11) {
        showProgress();
        ((SubscriptionManagementViewModel) getViewModel()).updateSubscriptionAutoRenewStatus(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId(), new SubscriptionAutoRenewRequestModel(Boolean.valueOf(z11), (Boolean) null, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void updateRenewalStatus(Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
            ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetail(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId());
        }
        if (this.cancelSubscriptionIsClicked && Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            handleCancelSubscriptionSuccess();
        }
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionDefaultCardSet(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCardAvailable(true);
            updateAutoRenew(true);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionDetail(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        if (subscriptionItemDisplayModel != null) {
            if (this.subscriptionAutoRenewIsClicked) {
                showAutoRenewalSuccessNotification();
            }
            hideProgress();
            ((NestedScrollView) _$_findCachedViewById(R.id.scroll_container)).setVisibility(0);
            ((TableLayout) _$_findCachedViewById(R.id.terms_and_conditions_container)).setVisibility(0);
            _$_findCachedViewById(R.id.divider).setVisibility(0);
            showSubscriptionDetailViews(subscriptionItemDisplayModel);
            ((SubscriptionManagementViewModel) getViewModel()).setTermsAndConditionUrl(subscriptionItemDisplayModel.getSubscriptionPlanItem().getTermsUrl());
            this.subscriptionAutoRenewIsClicked = false;
        }
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

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
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
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
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

    @NotNull
    public Class<SubscriptionManagementViewModel> getViewModelClass() {
        return SubscriptionManagementViewModel.class;
    }

    public int layoutId() {
        return R.layout.fragment_subscription_detail;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetailData(), new SubscriptionDetailFragment$observatory$1(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionAutoRenewData(), new SubscriptionDetailFragment$observatory$2(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSetSubscriptionDefaultCardStatusData(), new SubscriptionDetailFragment$observatory$3(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getWalletCardListData(), new SubscriptionDetailFragment$observatory$4(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionsSavingsData(), new SubscriptionDetailFragment$observatory$5(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerSubscriptionComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onBackPressed() {
        super.onBackPressed();
        navigateToSubscriptionScreen();
    }

    public void onBottomSheetClosed() {
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetail(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId());
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRefreshSubscriptionDetailScreen() {
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetail(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId());
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Boolean bool;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DisplayUtils.Companion.transparentStatus(activity);
        }
        showProgress();
        initializeRecyclerView();
        extractArgumentExtras();
        initializeSavingsFeatureFlag();
        addEnableAutoRenewListener();
        addCancelSubscriptionListener();
        addTermsAndConditionListeners();
        addBackButtonListener();
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent = activity2.getIntent()) == null || (extras = intent.getExtras()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(extras.getBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED));
        }
        boolean orFalse = BooleanKt.orFalse(bool);
        this.isCardJustSuccessfullyAdded = orFalse;
        if (orFalse) {
            this.subscriptionAutoRenewIsClicked = true;
            ((SubscriptionManagementViewModel) getViewModel()).getWalletCards(TalabatUtils.getSelectedCountry(getConfigurationLocalRepository(), getLocationConfigurationRepository()).f13845id);
        } else {
            ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDetail(((SubscriptionManagementViewModel) getViewModel()).getSubscriptionMemberId());
        }
        if (this.isSavingsFlowEnabled) {
            enableCancelSubscriptionButton(false);
            ((SubscriptionManagementViewModel) getViewModel()).getSavingsInfo(getConfigurationLocalRepository().selectedCountry().getCountryId());
            return;
        }
        enableCancelSubscriptionButton(true);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGetSavingsInfoUseCase(@NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2) {
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "<set-?>");
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setSubscriptionsFeatureFlag(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public void updateCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        ((SubscriptionManagementViewModel) getViewModel()).setWalletCardList(walletCardListDisplayModel);
    }

    public void updateSubscriptionDefaultCard(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        showProgress();
        ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCard(new SubscriptionDefaultCardRequestModel(walletCardDisplayModel.getTokenId(), StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4), walletCardDisplayModel.getCardType(), WalletCardListMapper.Companion.formatCardExpiryDate(walletCardDisplayModel.getExpiryMonth(), walletCardDisplayModel.getExpiryYear())));
    }

    @NotNull
    public SubscriptionManagementViewModel viewModelBuilder() {
        SubscriptionManagementViewModelBuilder.Companion companion = SubscriptionManagementViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getSubscriptionManagementViewModel(requireContext, getCoroutineScope(), getFeatureFlagRepo(), getGetSavingsInfoUseCase(), getSubscriptionsFeatureFlag());
    }
}
