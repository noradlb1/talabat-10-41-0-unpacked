package com.talabat.wallet.ui.subscriptionManagement.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionDefaultCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionVertical;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewsVisibilityModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementAdapter;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementBottomSheet;
import com.talabat.wallet.ui.subscriptionManagement.view.di.DaggerSubscriptionComponent;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import py.b;
import py.c;
import py.d;
import py.e;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0012\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0016J\u0012\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020*H\u0002J\u0006\u0010<\u001a\u00020*J\b\u0010=\u001a\u00020*H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0016J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020*H\u0016J\u001a\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u00020*2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u00020*H\u0002J\u0018\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0002J\u0012\u0010U\u001a\u00020*2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020*H\u0002J\u0010\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020,H\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020S0\\2\u0006\u0010]\u001a\u00020SH\u0002J\u0010\u0010^\u001a\u00020*2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010_\u001a\u00020*2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020bH\u0016J\u0017\u0010c\u001a\u00020*2\b\u0010d\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020*H\u0002J\b\u0010g\u001a\u00020\u0002H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006h"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementBottomSheet$SubscriptionManagementBottomSheetInterface;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter$SubscriptionManagementAdapterInterface;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getGetSavingsInfoUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "setGetSavingsInfoUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;)V", "isCardJustSuccessfullyAdded", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "subscriptionManagementAdapter", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlag", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlag", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "addCardInformation", "", "subscriptionDefaultCardDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionDefaultCardDisplayModel;", "addCardViewListener", "addChangeDefaultCardListener", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "getWalletAddedCard", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "initFeatureFlags", "initializeRecyclerView", "layoutId", "", "loadScreenData", "navigateToAddCard", "navigateToHomeScreen", "navigateToPlanOnBoarding", "subscriptionItemDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "navigateToSubscriptionDetail", "navigateToTDineOnBoardingScreen", "observatory", "onAttach", "context", "Landroid/content/Context;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateAdapter", "subscriptionViewDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;", "setBackButtonListener", "setExpiryInformation", "expiryMonth", "", "expiryYear", "showCardListBottomSheet", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "showNoCardView", "showSubscriptionDefaultCard", "defaultCard", "splitDate", "", "date", "subscriptionItemClicked", "updateCardList", "updateSubscriptionDefaultCard", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "updateSubscriptionDefaultCardSet", "isSubscriptionDefaultCardSet", "(Ljava/lang/Boolean;)V", "viewAllPlansListener", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SubscriptionManagementFragment extends BaseFragment implements CreditCardHelperInterface, SubscriptionManagementBottomSheet.SubscriptionManagementBottomSheetInterface, SubscriptionManagementAdapter.SubscriptionManagementAdapterInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GetSavingsInfoUseCase getSavingsInfoUseCase;
    private boolean isCardJustSuccessfullyAdded;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    private SubscriptionManagementAdapter subscriptionManagementAdapter;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;

    public static final /* synthetic */ SubscriptionManagementViewModel access$getViewModel(SubscriptionManagementFragment subscriptionManagementFragment) {
        return (SubscriptionManagementViewModel) subscriptionManagementFragment.getViewModel();
    }

    private final void addCardInformation(SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel) {
        ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCardAvailable(true);
        _$_findCachedViewById(R.id.card_view).setVisibility(0);
        _$_findCachedViewById(R.id.no_card_info_view).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.change_card)).setVisibility(0);
        String cardType = subscriptionDefaultCardDisplayModel.getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_icon);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_icon");
        setCardTypeIcon(cardType, imageView);
        ((TextView) _$_findCachedViewById(R.id.card_name)).setText(getResources().getString(com.talabat.localization.R.string.card_name, new Object[]{subscriptionDefaultCardDisplayModel.getCardType(), subscriptionDefaultCardDisplayModel.getCard4Digits()}));
        List<String> splitDate = splitDate(subscriptionDefaultCardDisplayModel.getCardExpiryDate());
        setExpiryInformation(splitDate.get(0), StringsKt___StringsKt.takeLast(splitDate.get(1), 2));
    }

    private final void addCardViewListener() {
        _$_findCachedViewById(R.id.add_card_view).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardViewListener$lambda-5  reason: not valid java name */
    public static final void m6019addCardViewListener$lambda5(SubscriptionManagementFragment subscriptionManagementFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(subscriptionManagementFragment, "this$0");
        Collection cardList = ((SubscriptionManagementViewModel) subscriptionManagementFragment.getViewModel()).getWalletCardList().getCardList();
        if (cardList == null || cardList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            subscriptionManagementFragment.navigateToAddCard();
        } else {
            subscriptionManagementFragment.showCardListBottomSheet(subscriptionManagementFragment.getFragmentManager());
        }
    }

    private final void addChangeDefaultCardListener() {
        ((TextView) _$_findCachedViewById(R.id.change_card)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addChangeDefaultCardListener$lambda-4  reason: not valid java name */
    public static final void m6020addChangeDefaultCardListener$lambda4(SubscriptionManagementFragment subscriptionManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionManagementFragment, "this$0");
        subscriptionManagementFragment.showCardListBottomSheet(subscriptionManagementFragment.getFragmentManager());
    }

    /* access modifiers changed from: private */
    public final void getWalletAddedCard(WalletCardListDisplayModel walletCardListDisplayModel) {
        if (walletCardListDisplayModel != null && (!walletCardListDisplayModel.getCardList().isEmpty()) && this.isCardJustSuccessfullyAdded) {
            this.isCardJustSuccessfullyAdded = false;
            WalletCardDisplayModel walletCardDisplayModel = walletCardListDisplayModel.getCardList().get(0);
            ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCard(new SubscriptionDefaultCardRequestModel(walletCardDisplayModel.getTokenId(), StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4), walletCardDisplayModel.getCardType(), WalletCardListMapper.Companion.formatCardExpiryDate(walletCardDisplayModel.getExpiryMonth(), walletCardDisplayModel.getExpiryYear())));
        }
    }

    private final void initFeatureFlags() {
        ((SubscriptionManagementViewModel) getViewModel()).initFeatureFlags();
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.subscriptionManagementAdapter = new SubscriptionManagementAdapter(context, this, getConfigurationLocalRepository(), getLocationConfigurationRepository());
            int i11 = R.id.subscription_list;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
            recyclerView.setLayoutManager(linearLayoutManager);
            SubscriptionManagementAdapter subscriptionManagementAdapter2 = this.subscriptionManagementAdapter;
            if (subscriptionManagementAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionManagementAdapter");
                subscriptionManagementAdapter2 = null;
            }
            recyclerView.setAdapter(subscriptionManagementAdapter2);
            ((RecyclerView) _$_findCachedViewById(i11)).setNestedScrollingEnabled(false);
        }
    }

    private final void loadScreenData() {
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionPlans(getConfigurationLocalRepository().selectedCountry().threeLetterCodeUpperCase());
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptions(getConfigurationLocalRepository().selectedCountry().threeLetterCodeUpperCase(), true);
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDefaultCard();
        ((SubscriptionManagementViewModel) getViewModel()).getWalletCards(getConfigurationLocalRepository().selectedCountry().getCountryId());
    }

    private final void navigateToHomeScreen() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToHomeScreen());
        }
    }

    private final void navigateToTDineOnBoardingScreen() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.talabat.life.on.boarding", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void populateAdapter(SubscriptionViewDisplayModel subscriptionViewDisplayModel) {
        if (subscriptionViewDisplayModel != null && subscriptionViewDisplayModel.isAllServiceLoaded()) {
            SubscriptionViewsVisibilityModel subscriptionViewsVisibilityModel = subscriptionViewDisplayModel.getSubscriptionViewsVisibilityModel();
            if (subscriptionViewsVisibilityModel.isNoSubscriptionViewVisible()) {
                _$_findCachedViewById(R.id.no_plan_view).setVisibility(0);
            }
            if (!subscriptionViewsVisibilityModel.isNoSubscriptionViewVisible() && subscriptionViewsVisibilityModel.isAddCardViewVisible()) {
                _$_findCachedViewById(R.id.add_card_view).setVisibility(0);
            }
            SubscriptionManagementAdapter subscriptionManagementAdapter2 = this.subscriptionManagementAdapter;
            if (subscriptionManagementAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionManagementAdapter");
                subscriptionManagementAdapter2 = null;
            }
            subscriptionManagementAdapter2.addItems(subscriptionViewDisplayModel.getSubscriptions());
            if (subscriptionViewsVisibilityModel.isPartSubscriptionViewVisible()) {
                _$_findCachedViewById(R.id.view_all_plans_notification).setVisibility(0);
                _$_findCachedViewById(R.id.no_plan_view).setVisibility(8);
            }
            if (subscriptionViewsVisibilityModel.isChangeCardWidgetVisible()) {
                showSubscriptionDefaultCard(subscriptionViewDisplayModel.getDefaultCard());
            }
            hideProgress();
        }
    }

    private final void setBackButtonListener() {
        ((ImageButton) _$_findCachedViewById(R.id.back_button)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setBackButtonListener$lambda-13  reason: not valid java name */
    public static final void m6021setBackButtonListener$lambda13(SubscriptionManagementFragment subscriptionManagementFragment, View view) {
        boolean z11;
        Intrinsics.checkNotNullParameter(subscriptionManagementFragment, "this$0");
        Bundle arguments = subscriptionManagementFragment.getArguments();
        if (arguments != null) {
            z11 = arguments.getBoolean(WalletNavigatorActions.EXTRA_DISABLE_OPENING_HOME_ON_BACK_PRESS);
        } else {
            z11 = false;
        }
        if (z11) {
            subscriptionManagementFragment.requireActivity().finish();
        } else {
            subscriptionManagementFragment.navigateToHomeScreen();
        }
    }

    private final void showCardListBottomSheet(FragmentManager fragmentManager) {
        SubscriptionManagementBottomSheet subscriptionManagementBottomSheet = new SubscriptionManagementBottomSheet(((SubscriptionManagementViewModel) getViewModel()).getWalletCardListData().getValue(), ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionDefaultCardData().getValue(), this, true);
        if (fragmentManager != null) {
            fragmentManager.beginTransaction();
            subscriptionManagementBottomSheet.show(fragmentManager, "");
        }
    }

    private final void showNoCardView() {
        ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCardAvailable(false);
        _$_findCachedViewById(R.id.no_card_info_view).setVisibility(0);
        _$_findCachedViewById(R.id.card_view).setVisibility(8);
    }

    private final void showSubscriptionDefaultCard(SubscriptionDefaultCardDisplayModel subscriptionDefaultCardDisplayModel) {
        boolean z11 = false;
        _$_findCachedViewById(R.id.default_card_view).setVisibility(0);
        if (subscriptionDefaultCardDisplayModel.getCardTokenId().length() == 0) {
            z11 = true;
        }
        if (z11) {
            showNoCardView();
        } else {
            addCardInformation(subscriptionDefaultCardDisplayModel);
        }
    }

    private final List<String> splitDate(String str) {
        return StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
    }

    private final void subscriptionItemClicked(SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.Wallet.SubscriptionDetailActivity", (Bundle) null, new SubscriptionManagementFragment$subscriptionItemClicked$1$1(subscriptionItemDisplayModel, this), 2, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void updateSubscriptionDefaultCardSet(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            loadScreenData();
        }
    }

    private final void viewAllPlansListener() {
        _$_findCachedViewById(R.id.view_all_plans_notification).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: viewAllPlansListener$lambda-8  reason: not valid java name */
    public static final void m6022viewAllPlansListener$lambda8(SubscriptionManagementFragment subscriptionManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionManagementFragment, "this$0");
        Context context = subscriptionManagementFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_SUBSCRIPTION_PLAN_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
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

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
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
        return R.layout.fragment_wallet_subscription_management;
    }

    public final void navigateToAddCard() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToAddCardFromSource(WalletNavigatorActions.OPEN_SUBSCRIPTION_MANAGEMENT_SCREEN, ((SubscriptionManagementViewModel) getViewModel()).isWalletAddCardFlutterScreenEnabled()));
        }
    }

    public void navigateToPlanOnBoarding(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionItemDisplayModel, "subscriptionItemDisplayModel");
        if (Intrinsics.areEqual((Object) SubscriptionVertical.T_DINE.getValue(), (Object) subscriptionItemDisplayModel.getSubscriptionPlanItem().getOnBoardingLink())) {
            navigateToTDineOnBoardingScreen();
        }
    }

    public void navigateToSubscriptionDetail(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionItemDisplayModel, "subscriptionItemDisplayModel");
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(TproNavigatorActionsKt.OPEN_TPRO_SUBSCRIPTION_DETAILS_ACTIVITY, (Bundle) null, new SubscriptionManagementFragment$navigateToSubscriptionDetail$1$1(subscriptionItemDisplayModel, this), 2, (DefaultConstructorMarker) null));
        }
    }

    public void observatory() {
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionViewsData(), new SubscriptionManagementFragment$observatory$1(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getWalletCardListData(), new SubscriptionManagementFragment$observatory$2(this));
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getSetSubscriptionDefaultCardStatusData(), new SubscriptionManagementFragment$observatory$3(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerSubscriptionComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        Boolean bool;
        Intent intent;
        Bundle extras;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(extras.getBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED));
        }
        boolean orFalse = BooleanKt.orFalse(bool);
        this.isCardJustSuccessfullyAdded = orFalse;
        if (orFalse) {
            ((SubscriptionManagementViewModel) getViewModel()).getWalletCards(getConfigurationLocalRepository().selectedCountry().getCountryId());
        } else {
            loadScreenData();
        }
        showProgress();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeRecyclerView();
        viewAllPlansListener();
        addCardViewListener();
        addChangeDefaultCardListener();
        setBackButtonListener();
        initFeatureFlags();
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
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
        ((SubscriptionManagementViewModel) getViewModel()).getWalletCardListData().setValue(walletCardListDisplayModel);
    }

    public void updateSubscriptionDefaultCard(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        showProgress();
        ((SubscriptionManagementViewModel) getViewModel()).setSubscriptionDefaultCard(new SubscriptionDefaultCardRequestModel(walletCardDisplayModel.getTokenId(), StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4), walletCardDisplayModel.getCardType(), WalletCardListMapper.Companion.formatCardExpiryDate(walletCardDisplayModel.getExpiryMonth(), walletCardDisplayModel.getExpiryYear())));
    }

    private final void setExpiryInformation(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (WalletCardListMapper.Companion.hasCardExpired(str, str2)) {
            int i11 = R.id.expiry_date;
            ((TextView) _$_findCachedViewById(i11)).setText(getResources().getString(com.talabat.localization.R.string.card_expired));
            ((TextView) _$_findCachedViewById(i11)).setTextColor(ContextCompat.getColor(context, com.talabat.talabatcommon.R.color.talabat_red));
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.expiry_date)).setText(context.getResources().getString(com.talabat.localization.R.string.credit_card_expiry_date, new Object[]{str, str2}));
    }

    @NotNull
    public SubscriptionManagementViewModel viewModelBuilder() {
        SubscriptionManagementViewModelBuilder.Companion companion = SubscriptionManagementViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getSubscriptionManagementViewModel(requireContext, getCoroutineScope(), getFeatureFlagRepo(), getGetSavingsInfoUseCase(), getSubscriptionsFeatureFlag());
    }
}
