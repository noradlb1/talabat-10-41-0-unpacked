package com.talabat.wallet.ui.walletDashboard.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.integration.wallet.WalletIntegrationAppTracker;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.listeners.EndlessScrollListener;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import com.talabat.wallet.ui.transactionslistheader.TransactionsListHeaderDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.NavigationType;
import com.talabat.wallet.ui.walletDashboard.model.OnboardingType;
import com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletDateFormatter;
import com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletShowNextScreenDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionDetailsDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionEmptyListDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel;
import com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter;
import com.talabat.wallet.ui.walletDashboard.view.di.DaggerWalletDashboardFragmentComponent;
import com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModel;
import com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xy.a;
import xy.b;
import xy.c;
import xy.d;
import xy.e;
import xy.f;
import xy.g;
import xy.h;
import xy.i;
import xy.j;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ³\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002³\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020DH\u0002J\b\u0010H\u001a\u00020DH\u0002J\b\u0010I\u001a\u00020DH\u0002J\b\u0010J\u001a\u00020DH\u0002J\b\u0010K\u001a\u00020DH\u0002J\u0012\u0010L\u001a\u00020D2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\b\u0010O\u001a\u00020DH\u0002J\b\u0010P\u001a\u00020DH\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002J\b\u0010S\u001a\u00020DH\u0002J\b\u0010T\u001a\u00020DH\u0002J\b\u0010U\u001a\u00020DH\u0002J\b\u0010V\u001a\u00020DH\u0002J\u0010\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u00020DH\u0002J\b\u0010[\u001a\u00020DH\u0002J\u0012\u0010\\\u001a\u00020D2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020`H\u0016J\b\u0010a\u001a\u00020DH\u0002J\b\u0010b\u001a\u00020DH\u0002J\b\u0010c\u001a\u00020DH\u0002J\b\u0010d\u001a\u00020DH\u0016J\b\u0010e\u001a\u00020DH\u0002J\b\u0010f\u001a\u00020DH\u0002J#\u0010g\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020+0hH\u0002J\b\u0010l\u001a\u00020\"H\u0016J\u000e\u0010m\u001a\u00020D2\u0006\u0010n\u001a\u00020oJ\b\u0010p\u001a\u00020DH\u0002J\b\u0010q\u001a\u00020DH\u0002J\b\u0010r\u001a\u00020DH\u0002J\b\u0010s\u001a\u00020DH\u0002J\u0012\u0010t\u001a\u00020D2\b\u0010u\u001a\u0004\u0018\u00010vH\u0002J\b\u0010w\u001a\u00020DH\u0016J\"\u0010x\u001a\u00020D2\u0006\u0010y\u001a\u00020\"2\u0006\u0010z\u001a\u00020\"2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020D2\u0006\u0010~\u001a\u00020H\u0016J\t\u0010\u0001\u001a\u00020DH\u0016J\t\u0010\u0001\u001a\u00020DH\u0016J\u001f\u0010\u0001\u001a\u00020D2\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0003J\u0012\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020+H\u0002J\u0013\u0010\u0001\u001a\u00020D2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001a\u0010\u0001\u001a\u00020D2\t\u0010\u0001\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020DH\u0002J\u0015\u0010\u0001\u001a\u00020D2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020D2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\u0015\u0010\u0001\u001a\u00020D2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u001a\u0010\u0001\u001a\u00020D2\t\u0010\u0001\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0003\u0010\u0001J\t\u0010 \u0001\u001a\u00020DH\u0016J\t\u0010¡\u0001\u001a\u00020DH\u0002J\t\u0010¢\u0001\u001a\u00020DH\u0002J\t\u0010£\u0001\u001a\u00020DH\u0002J\u0015\u0010¤\u0001\u001a\u00020D2\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0002J\u0011\u0010§\u0001\u001a\u00020D2\b\u0010¨\u0001\u001a\u00030©\u0001J\t\u0010ª\u0001\u001a\u00020DH\u0002J\u0015\u0010«\u0001\u001a\u00020D2\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001H\u0002J\u0015\u0010®\u0001\u001a\u00020D2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0002J\u0015\u0010±\u0001\u001a\u00020D2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010²\u0001\u001a\u00020\u0002H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"XD¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0002028\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006´\u0001"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletDashboardFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModel;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "endlessScrollListener", "Lcom/talabat/talabatcommon/listeners/EndlessScrollListener;", "headerDecorator", "Lcom/talabat/wallet/ui/walletDashboard/view/HeaderItemDecorator;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "numberOfItemsPerPage", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "pageNumber", "shouldDisableOpeningHome", "", "getShouldDisableOpeningHome", "()Z", "shouldDisableOpeningHome$delegate", "Lkotlin/Lazy;", "shouldRefreshOnResume", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "transactionListAdapter", "Lcom/talabat/wallet/ui/walletDashboard/view/adapter/WalletTransactionListAdapter;", "getTransactionListAdapter", "()Lcom/talabat/wallet/ui/walletDashboard/view/adapter/WalletTransactionListAdapter;", "setTransactionListAdapter", "(Lcom/talabat/wallet/ui/walletDashboard/view/adapter/WalletTransactionListAdapter;)V", "addAppBarInfo", "", "date", "", "addAppBarOffsetChangedListener", "addBackIconsListeners", "addCardManagementIconOnClickListener", "addCreditInformationClickListener", "addEndlessScrollListener", "addExpiringCardItem", "expiringCardDetailDisplayModel", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "addHeaderDecorator", "addLogInOnClickListener", "addMoreOptionsClickListener", "addOnClickListeners", "addScrollListener", "addSendGiftIconOnClickListener", "addTopUpIconOnClickListener", "addTransactionsListRecentTitle", "adjustAppBarChildrenViewsAlpha", "scrollPercentage", "", "disableDragging", "disableScroll", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "getWalletBannerConfiguration", "handleEmailLoginActivityResult", "handleExtraDestination", "hideProgress", "hideStickyBar", "initializeRecyclerView", "isHeader", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "itemPosition", "layoutId", "loadDynamicBannerForEmptyView", "walletBannerDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "loadOnBoardingInformation", "loadTransactionList", "moveToWalletTopupCardListScreen", "navigateToHomeScreen", "navigateToNextScreen", "walletShowNextScreenDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletShowNextScreenDisplayModel;", "observatory", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onRefresh", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshScreen", "resetPaginationParameters", "setCustomStatusBar", "setEmptyViewList", "shouldDisplayCobrandedCCBanner", "setToolbarFirstMonthData", "walletTransactionListDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "setUpLogInViews", "userNotLoggedIn", "(Ljava/lang/Boolean;)V", "showCardManagementIcon", "showEmptyView", "walletTransactionEmptyListDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionEmptyListDisplayModel;", "showEnabledIcons", "walletDashBoardIconsDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletDashBoardIconsDisplayModel;", "showLogInViews", "showMoreIcon", "showOnBoarding", "walletOnboardingDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletOnboardingDisplayModel;", "showOnBoardingInformation", "showIt", "showProgress", "showSendGiftIcon", "showStickyBar", "showTopUpIcon", "showTransactionDetails", "walletTransactionDetailsDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionDetailsDisplayModel;", "transactionItemClicked", "transactionItem", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "updateAppBarTitle", "updateTransactionsListHeader", "transactionsListHeaderDisplayModel", "Lcom/talabat/wallet/ui/transactionslistheader/TransactionsListHeaderDisplayModel;", "updateWalletBalance", "walletBalanceDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "updateWalletTransactionList", "viewModelBuilder", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletDashboardFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @NotNull
    public static final String ARGUMENT_DISABLE_OPENING_HOME_FOR_BACK_PRESSED = "extraDisableOpeningHome";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    private EndlessScrollListener endlessScrollListener;
    private HeaderItemDecorator headerDecorator;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public Navigator navigator;
    /* access modifiers changed from: private */
    public final int numberOfItemsPerPage = 10;
    @Inject
    public IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    public int pageNumber = -1;
    @NotNull
    private final Lazy shouldDisableOpeningHome$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletDashboardFragment$shouldDisableOpeningHome$2(this));
    private boolean shouldRefreshOnResume;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    @Inject
    public TalabatTracker talabatTracker;
    public WalletTransactionListAdapter transactionListAdapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletDashboardFragment$Companion;", "", "()V", "ARGUMENT_DISABLE_OPENING_HOME_FOR_BACK_PRESSED", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ WalletDashboardViewModel access$getViewModel(WalletDashboardFragment walletDashboardFragment) {
        return (WalletDashboardViewModel) walletDashboardFragment.getViewModel();
    }

    private final void addAppBarOffsetChangedListener() {
        ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new WalletDashboardFragment$addAppBarOffsetChangedListener$1(this));
    }

    private final void addBackIconsListeners() {
        WalletDashboardFragment$addBackIconsListeners$onBackButtonPressed$1 walletDashboardFragment$addBackIconsListeners$onBackButtonPressed$1 = new WalletDashboardFragment$addBackIconsListeners$onBackButtonPressed$1(this);
        ((ImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new a(walletDashboardFragment$addBackIconsListeners$onBackButtonPressed$1));
        ((ImageView) _$_findCachedViewById(R.id.toolbar_back_icon)).setOnClickListener(new b(walletDashboardFragment$addBackIconsListeners$onBackButtonPressed$1));
    }

    /* access modifiers changed from: private */
    /* renamed from: addBackIconsListeners$lambda-30  reason: not valid java name */
    public static final void m6050addBackIconsListeners$lambda30(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onBackButtonPressed");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: addBackIconsListeners$lambda-31  reason: not valid java name */
    public static final void m6051addBackIconsListeners$lambda31(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onBackButtonPressed");
        function0.invoke();
    }

    private final void addCardManagementIconOnClickListener() {
        ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardManagementIconOnClickListener$lambda-23  reason: not valid java name */
    public static final void m6052addCardManagementIconOnClickListener$lambda23(WalletDashboardFragment walletDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        if (((WalletDashboardViewModel) walletDashboardFragment.getViewModel()).shouldShowFlutterCardsManagementScreen()) {
            Navigator navigator2 = walletDashboardFragment.getNavigator();
            Context requireContext = walletDashboardFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Navigator.DefaultImpls.navigateTo$default(navigator2, requireContext, new FlutterScreen(new FlutterScreen.FlutterScreenData("cards_management/list")), (Function1) null, 4, (Object) null);
            return;
        }
        Context context = walletDashboardFragment.getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_MIGRATED_CARD_MANAGEMENT_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    private final void addCreditInformationClickListener() {
        ((ImageView) _$_findCachedViewById(R.id.information_button)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCreditInformationClickListener$lambda-19  reason: not valid java name */
    public static final void m6053addCreditInformationClickListener$lambda19(WalletDashboardFragment walletDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        ((WalletDashboardViewModel) walletDashboardFragment.getViewModel()).onShowCreditInformationButtonClicked();
    }

    private final void addEndlessScrollListener() {
        int i11 = R.id.wallet_transaction_list;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) _$_findCachedViewById(i11)).getLayoutManager();
        if (layoutManager != null) {
            this.endlessScrollListener = new WalletDashboardFragment$addEndlessScrollListener$1$1(layoutManager, this);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        EndlessScrollListener endlessScrollListener2 = this.endlessScrollListener;
        if (endlessScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endlessScrollListener");
            endlessScrollListener2 = null;
        }
        recyclerView.addOnScrollListener(endlessScrollListener2);
    }

    private final void addExpiringCardItem(ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
        if (expiringCardDetailDisplayModel != null && expiringCardDetailDisplayModel.getShouldDisplayView()) {
            WalletTransactionListAdapter transactionListAdapter2 = getTransactionListAdapter();
            WalletTransactionListDataItemDisplayModel.ExpiringCreditModel expiringCreditModel = new WalletTransactionListDataItemDisplayModel.ExpiringCreditModel();
            String formatAmount = CurrencyFormatter.Companion.formatAmount(getLocationConfigurationRepository(), expiringCardDetailDisplayModel.getAmount(), true);
            String string = getString(com.talabat.localization.R.string.credit_is_expiring, formatAmount);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …                        )");
            expiringCreditModel.setAmount(string);
            String string2 = getString(com.talabat.localization.R.string.expiring_card_date_message, DateUtils.Companion.getLocalizedFormattedDateString(expiringCardDetailDisplayModel.getExpiryDate(), "LLLL dd, yyyy"));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …                        )");
            expiringCreditModel.setExpiryDate(string2);
            transactionListAdapter2.addItem(expiringCreditModel);
        }
    }

    private final void addHeaderDecorator() {
        Context context = getContext();
        if (context != null) {
            int i11 = R.id.wallet_transaction_list;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "wallet_transaction_list");
            this.headerDecorator = new HeaderItemDecorator(recyclerView, isHeader(), context);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i11);
            HeaderItemDecorator headerItemDecorator = this.headerDecorator;
            if (headerItemDecorator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerDecorator");
                headerItemDecorator = null;
            }
            recyclerView2.addItemDecoration(headerItemDecorator);
        }
    }

    private final void addLogInOnClickListener() {
        ((TalabatFillButton) _$_findCachedViewById(R.id.log_in_button)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001c, code lost:
        if (r0.containsKey("destination") == true) goto L_0x0020;
     */
    /* renamed from: addLogInOnClickListener$lambda-18  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6054addLogInOnClickListener$lambda18(com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment r9, android.view.View r10) {
        /*
            java.lang.String r10 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.lang.String r0 = "Talabat Credit Options Screen"
            r10.element = r0
            android.os.Bundle r0 = r9.getArguments()
            java.lang.String r1 = "destination"
            r2 = 0
            if (r0 == 0) goto L_0x001f
            boolean r0 = r0.containsKey(r1)
            r3 = 1
            if (r0 != r3) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r3 = r2
        L_0x0020:
            if (r3 == 0) goto L_0x0033
            android.os.Bundle r0 = r9.getArguments()
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getString(r1)
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r10.element = r0
        L_0x0033:
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r0 = r9.getTalabatFeatureFlag()
            com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants r1 = com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA
            boolean r0 = r0.getFeatureFlag(r1, r2)
            if (r0 == 0) goto L_0x004c
            com.talabat.talabatnavigation.Navigator$Companion r10 = com.talabat.talabatnavigation.Navigator.Companion
            com.talabat.talabatnavigation.userandlocation.UserLoginActions r0 = com.talabat.talabatnavigation.userandlocation.UserLoginActions.INSTANCE
            r1 = 2
            com.talabat.talabatnavigation.base.NavigatorModelForResult r0 = r0.createOpenScreenModel(r1)
            r10.navigate((androidx.fragment.app.Fragment) r9, (com.talabat.talabatnavigation.base.NavigatorModelForResult) r0)
            goto L_0x0062
        L_0x004c:
            com.talabat.talabatnavigation.Navigator$Companion r0 = com.talabat.talabatnavigation.Navigator.Companion
            com.talabat.talabatnavigation.base.NavigatorModelForResult r8 = new com.talabat.talabatnavigation.base.NavigatorModelForResult
            java.lang.String r2 = "talabat.action.LoginScreen"
            r3 = 0
            com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment$addLogInOnClickListener$1$1 r4 = new com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment$addLogInOnClickListener$1$1
            r4.<init>(r10)
            r5 = 2
            r6 = 2
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.navigate((androidx.fragment.app.Fragment) r9, (com.talabat.talabatnavigation.base.NavigatorModelForResult) r8)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment.m6054addLogInOnClickListener$lambda18(com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment, android.view.View):void");
    }

    private final void addMoreOptionsClickListener() {
        ((TextView) _$_findCachedViewById(R.id.menu_more_textview)).setOnClickListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addMoreOptionsClickListener$lambda-20  reason: not valid java name */
    public static final void m6055addMoreOptionsClickListener$lambda20(WalletDashboardFragment walletDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        new WalletMoreOptionsBottomSheet(walletDashboardFragment.getActivity()).show();
    }

    private final void addOnClickListeners() {
        addCardManagementIconOnClickListener();
        addTopUpIconOnClickListener();
        addSendGiftIconOnClickListener();
        addCreditInformationClickListener();
        addMoreOptionsClickListener();
    }

    private final void addScrollListener() {
        ((RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list)).addOnScrollListener(new WalletDashboardFragment$addScrollListener$1(this));
    }

    private final void addSendGiftIconOnClickListener() {
        ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addSendGiftIconOnClickListener$lambda-29  reason: not valid java name */
    public static final void m6056addSendGiftIconOnClickListener$lambda29(WalletDashboardFragment walletDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        Context context = walletDashboardFragment.getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_SEND_GIFT_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    private final void addTopUpIconOnClickListener() {
        ((TextView) _$_findCachedViewById(R.id.top_button)).setOnClickListener(new j(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addTopUpIconOnClickListener$lambda-27  reason: not valid java name */
    public static final void m6057addTopUpIconOnClickListener$lambda27(WalletDashboardFragment walletDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        Context context = walletDashboardFragment.getContext();
        if (context != null) {
            WalletIntegrationAppTracker.Companion.onWalletTopUpClicked(context, "Wallet Dashboard screen", "wallet");
            walletDashboardFragment.shouldRefreshOnResume = true;
            if (((WalletDashboardViewModel) walletDashboardFragment.getViewModel()).shouldShowFlutterTopUpScreen()) {
                Navigator navigator2 = walletDashboardFragment.getNavigator();
                Context requireContext = walletDashboardFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                Navigator.DefaultImpls.navigateTo$default(navigator2, requireContext, new FlutterScreen(new FlutterScreen.FlutterScreenData("top_up")), (Function1) null, 4, (Object) null);
                return;
            }
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.Wallet.walletTopUpCardList", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    private final void addTransactionsListRecentTitle() {
        getTransactionListAdapter().addItem(new WalletTransactionListDataItemDisplayModel.TransactionListHeaderModel());
    }

    /* access modifiers changed from: private */
    public final void adjustAppBarChildrenViewsAlpha(float f11) {
        Boolean bool;
        Boolean bool2;
        WalletDashBoardIconsDisplayModel value = ((WalletDashboardViewModel) getViewModel()).getWalletDashboardIconsData().getValue();
        Boolean bool3 = null;
        if (value != null) {
            bool = Boolean.valueOf(value.getShouldShowTopUpIcon());
        } else {
            bool = null;
        }
        if (BooleanKt.orFalse(bool)) {
            ((TextView) _$_findCachedViewById(R.id.top_button)).setAlpha(((float) 1) - f11);
        }
        WalletDashBoardIconsDisplayModel value2 = ((WalletDashboardViewModel) getViewModel()).getWalletDashboardIconsData().getValue();
        if (value2 != null) {
            bool2 = Boolean.valueOf(value2.getShouldShowCardManagementIcon());
        } else {
            bool2 = null;
        }
        if (BooleanKt.orFalse(bool2)) {
            ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setAlpha(((float) 1) - f11);
        }
        WalletDashBoardIconsDisplayModel value3 = ((WalletDashboardViewModel) getViewModel()).getWalletDashboardIconsData().getValue();
        if (value3 != null) {
            bool3 = Boolean.valueOf(value3.getShouldShowSendGiftIcon());
        }
        if (BooleanKt.orFalse(bool3)) {
            ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setAlpha(((float) 1) - f11);
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setAlpha(f11);
        ((Toolbar) _$_findCachedViewById(R.id.wallet_sticky_toolbar)).setAlpha(f11);
    }

    private final void disableDragging() {
        ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) _$_findCachedViewById(R.id.toolbar_layout)).getLayoutParams();
        if (layoutParams != null) {
            ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(0);
            ViewGroup.LayoutParams layoutParams2 = ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).getLayoutParams();
            if (layoutParams2 != null) {
                AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior();
                if (behavior != null) {
                    behavior.setDragCallback(new WalletDashboardFragment$disableDragging$1());
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    private final void disableScroll() {
        int i11 = R.id.toolbar_layout;
        ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
            layoutParams2.setScrollFlags(0);
            ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    /* access modifiers changed from: private */
    public final boolean getShouldDisableOpeningHome() {
        return ((Boolean) this.shouldDisableOpeningHome$delegate.getValue()).booleanValue();
    }

    private final void getWalletBannerConfiguration() {
        ((WalletDashboardViewModel) getViewModel()).getWalletBannerDisplayModelData().observe(this, new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: getWalletBannerConfiguration$lambda-6  reason: not valid java name */
    public static final void m6058getWalletBannerConfiguration$lambda6(WalletDashboardFragment walletDashboardFragment, WalletBannerDisplayModel walletBannerDisplayModel) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        WalletTransactionListAdapter transactionListAdapter2 = walletDashboardFragment.getTransactionListAdapter();
        WalletTransactionListDataItemDisplayModel.CobrandedCCModel cobrandedCCModel = new WalletTransactionListDataItemDisplayModel.CobrandedCCModel();
        cobrandedCCModel.setShouldShowBanner(walletBannerDisplayModel.getShouldShowBanner());
        cobrandedCCModel.setBannerName(walletBannerDisplayModel.getBannerName());
        cobrandedCCModel.setBannerImageUrl(walletBannerDisplayModel.getBannerImageUrl());
        cobrandedCCModel.setDeepLink(walletBannerDisplayModel.getDeepLink());
        transactionListAdapter2.addItem(cobrandedCCModel);
        Intrinsics.checkNotNullExpressionValue(walletBannerDisplayModel, "it");
        walletDashboardFragment.loadDynamicBannerForEmptyView(walletBannerDisplayModel);
    }

    private final void handleEmailLoginActivityResult() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("destination");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (Intrinsics.areEqual((Object) str, (Object) "talabat.action.Wallet.walletTopUpCardList")) {
            moveToWalletTopupCardListScreen();
        } else {
            refreshScreen();
        }
    }

    private final void handleExtraDestination() {
        String str;
        if (IntegrationGlobalDataModel.Companion.isLoggedIn()) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString("destination");
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (Intrinsics.areEqual((Object) str, (Object) "talabat.action.Wallet.walletTopUpCardList")) {
                moveToWalletTopupCardListScreen();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void hideStickyBar() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setVisibility(8);
        int i11 = R.id.wallet_sticky_toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setAlpha(0.5f);
        ((Toolbar) _$_findCachedViewById(i11)).setVisibility(8);
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            setTransactionListAdapter(new WalletTransactionListAdapter(getLocationConfigurationRepository(), context, new WalletDashboardFragment$initializeRecyclerView$1$1(this), new WalletDashboardFragment$initializeRecyclerView$1$2(this)));
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(getTransactionListAdapter());
        }
    }

    private final Function1<Integer, Boolean> isHeader() {
        return new WalletDashboardFragment$isHeader$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadDynamicBannerForEmptyView$lambda-7  reason: not valid java name */
    public static final void m6059loadDynamicBannerForEmptyView$lambda7(WalletDashboardFragment walletDashboardFragment, WalletBannerDisplayModel walletBannerDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(walletDashboardFragment, "this$0");
        Intrinsics.checkNotNullParameter(walletBannerDisplayModel, "$walletBannerDisplayModel");
        ((WalletDashboardViewModel) walletDashboardFragment.getViewModel()).onCobrandedCCBannerClicked(walletBannerDisplayModel.getDeepLink());
    }

    private final void loadOnBoardingInformation() {
        ((WalletDashboardViewModel) getViewModel()).shouldShowCreditInformationButton();
    }

    private final void loadTransactionList() {
        showProgress();
        resetPaginationParameters();
        ((WalletDashboardViewModel) getViewModel()).showDashBoardIcons();
        String valueOf = String.valueOf(getConfigurationLocalRepository().selectedCountry().getCountryId());
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        ((WalletDashboardViewModel) getViewModel()).getWalletBalance(valueOf, companion.isLoggedIn());
        ((WalletDashboardViewModel) getViewModel()).getTransactionsListHeader(getConfigurationLocalRepository().selectedCountry().getCountryId(), companion.isLoggedIn());
        ((WalletDashboardViewModel) getViewModel()).getWalletBanner(getConfigurationLocalRepository().selectedCountry().getCountryId(), companion.isLoggedIn());
    }

    private final void moveToWalletTopupCardListScreen() {
        if (((WalletDashboardViewModel) getViewModel()).shouldShowFlutterTopUpScreen()) {
            Navigator navigator2 = getNavigator();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Navigator.DefaultImpls.navigateTo$default(navigator2, requireContext, new FlutterScreen(new FlutterScreen.FlutterScreenData("top_up")), (Function1) null, 4, (Object) null);
        } else {
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            companion.navigate(requireContext2, new NavigatorModel("talabat.action.Wallet.walletTopUpCardList", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.remove("destination");
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToHomeScreen() {
        Context context = getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToHomeScreen());
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToNextScreen(WalletShowNextScreenDisplayModel walletShowNextScreenDisplayModel) {
        Context context;
        if (walletShowNextScreenDisplayModel != null && (context = getContext()) != null) {
            if (walletShowNextScreenDisplayModel.getNextScreen().getNavigationType() == NavigationType.FLUTTER) {
                DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
                Intrinsics.checkNotNullExpressionValue(context, "nonNullContext");
                DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, context, walletShowNextScreenDisplayModel.getNextScreen().getScreen().getLink(), (Function0) null, 4, (Object) null);
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardFragment$navigateToNextScreen$1$1$1(this, walletShowNextScreenDisplayModel, (Continuation<? super WalletDashboardFragment$navigateToNextScreen$1$1$1>) null), 3, (Object) null);
                return;
            }
            com.talabat.core.navigation.domain.Navigator navigator2 = getNavigator();
            Intrinsics.checkNotNullExpressionValue(context, "nonNullContext");
            Navigator.DefaultImpls.navigateTo$default(navigator2, context, walletShowNextScreenDisplayModel.getNextScreen().getScreen(), (Function1) null, 4, (Object) null);
        }
    }

    private final void refreshScreen() {
        Context context = getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_DASHBOARD_ACTIVITY, (Bundle) null, WalletDashboardFragment$refreshScreen$1$1.INSTANCE, 2, (DefaultConstructorMarker) null));
        }
    }

    private final void resetPaginationParameters() {
        this.pageNumber = -1;
        ((WalletDashboardViewModel) getViewModel()).setLastDisplayModel(new WalletTransactionListDataItemDisplayModel.TransactionDisplayModel());
        ((WalletDashboardViewModel) getViewModel()).setFirstResponse(true);
        EndlessScrollListener endlessScrollListener2 = this.endlessScrollListener;
        if (endlessScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endlessScrollListener");
            endlessScrollListener2 = null;
        }
        endlessScrollListener2.reset();
    }

    @RequiresApi(21)
    private final void setCustomStatusBar() {
        FragmentActivity activity = getActivity();
        SafeLetKt.safeLet(activity != null ? activity.getWindow() : null, getContext(), WalletDashboardFragment$setCustomStatusBar$1.INSTANCE);
    }

    private final void setEmptyViewList(boolean z11) {
        ((RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.empty_list_view)).setVisibility(0);
        if (z11) {
            _$_findCachedViewById(R.id.cobranded_cc_banner).setVisibility(0);
        }
        if (((WalletDashboardViewModel) getViewModel()).getShouldShowTopUpMessage()) {
            ((TextView) _$_findCachedViewById(R.id.top_up_message)).setVisibility(0);
        }
        _$_findCachedViewById(R.id.progressBar).setVisibility(8);
        disableScroll();
    }

    private final void setToolbarFirstMonthData(WalletTransactionListDisplayModel walletTransactionListDisplayModel) {
        if (((WalletDashboardViewModel) getViewModel()).isFirstResponse() && (!walletTransactionListDisplayModel.getWalletTransactionList().isEmpty())) {
            String date = ((WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel) walletTransactionListDisplayModel.getWalletTransactionList().get(0)).getDate();
            ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_string_text_view)).setText(getResources().getString(com.talabat.localization.R.string.spent_in_month_string, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(date, WalletDashboardFragmentKt.APP_BAR_DATE_OUTPUT_FORMAT)}));
            ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_amount_text_view)).setText(CurrencyFormatter.Companion.formatAmount$default(CurrencyFormatter.Companion, getLocationConfigurationRepository(), FloatKt.orZero(((WalletDashboardViewModel) getViewModel()).getAmountSpentPerMonthMap().get(WalletDateFormatter.Companion.getMonthAndYearForTransactionListGrouping(date, "yyyy-MM"))), false, 4, (Object) null));
            ((WalletDashboardViewModel) getViewModel()).setFirstResponse(false);
        }
    }

    /* access modifiers changed from: private */
    public final void setUpLogInViews(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            showLogInViews();
        }
    }

    private final void showCardManagementIcon() {
        ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showEmptyView(WalletTransactionEmptyListDisplayModel walletTransactionEmptyListDisplayModel) {
        if (walletTransactionEmptyListDisplayModel != null && walletTransactionEmptyListDisplayModel.getShouldShowEmptyList()) {
            setEmptyViewList(walletTransactionEmptyListDisplayModel.getShouldDisplayCobrandedCCBanner());
        }
    }

    /* access modifiers changed from: private */
    public final void showEnabledIcons(WalletDashBoardIconsDisplayModel walletDashBoardIconsDisplayModel) {
        if (walletDashBoardIconsDisplayModel != null) {
            if (walletDashBoardIconsDisplayModel.getShouldShowTopUpIcon()) {
                showTopUpIcon();
            }
            if (walletDashBoardIconsDisplayModel.getShouldShowCardManagementIcon()) {
                showCardManagementIcon();
            }
            if (walletDashBoardIconsDisplayModel.getShouldShowSendGiftIcon()) {
                showSendGiftIcon();
            }
            if (walletDashBoardIconsDisplayModel.getShouldShowMoreIcon()) {
                showMoreIcon();
            }
        }
    }

    private final void showLogInViews() {
        hideProgress();
        ((RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.user_not_logged_container)).setVisibility(0);
        ((Toolbar) _$_findCachedViewById(R.id.wallet_sticky_toolbar)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_action_container)).setVisibility(4);
        Context context = getContext();
        if (context != null) {
            ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
        addLogInOnClickListener();
    }

    private final void showMoreIcon() {
        ((TextView) _$_findCachedViewById(R.id.menu_more_textview)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showOnBoarding(WalletOnboardingDisplayModel walletOnboardingDisplayModel) {
        if (walletOnboardingDisplayModel != null) {
            OnboardingType onboardingType = walletOnboardingDisplayModel.getOnboardingType();
            if (Intrinsics.areEqual((Object) onboardingType, (Object) OnboardingType.WithTopUp.INSTANCE)) {
                WalletOnboardingBottomSheetKt.showWalletOnboardingBottomSheet(this, true);
                ((WalletDashboardViewModel) getViewModel()).onOnBoardingShown();
            } else if (Intrinsics.areEqual((Object) onboardingType, (Object) OnboardingType.WithoutTopUp.INSTANCE)) {
                WalletOnboardingBottomSheetKt.showWalletOnboardingBottomSheet(this, false);
                ((WalletDashboardViewModel) getViewModel()).onOnBoardingShown();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showOnBoardingInformation(Boolean bool) {
        int i11;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.information_button);
            if (booleanValue) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            imageView.setVisibility(i11);
            ((WalletDashboardViewModel) getViewModel()).shouldShowOnboarding(IntegrationGlobalDataModel.Companion.isLoggedIn());
        }
    }

    private final void showSendGiftIcon() {
        ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showStickyBar() {
        int i11 = R.id.wallet_sticky_toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setVisibility(0);
        ((Toolbar) _$_findCachedViewById(i11)).setVisibility(0);
        ((Toolbar) _$_findCachedViewById(i11)).setAlpha(1.0f);
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setVisibility(0);
    }

    private final void showTopUpIcon() {
        ((TextView) _$_findCachedViewById(R.id.top_button)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showTransactionDetails(WalletTransactionDetailsDisplayModel walletTransactionDetailsDisplayModel) {
        Context context;
        if (walletTransactionDetailsDisplayModel != null && !walletTransactionDetailsDisplayModel.getShowFlutterTransactionDetails() && (context = getContext()) != null) {
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_MIGRATED_DETAIL_ACTIVITY, (Bundle) null, new WalletDashboardFragment$showTransactionDetails$1$1$1(walletTransactionDetailsDisplayModel), 2, (DefaultConstructorMarker) null));
        }
    }

    private final void updateAppBarTitle() {
        if (getConfigurationLocalRepository().selectedCountry() == Country.OMAN) {
            ((TextView) _$_findCachedViewById(R.id.wallet_dashboard_title)).setText(getString(com.talabat.localization.R.string.talabat_pay_oman));
        }
    }

    /* access modifiers changed from: private */
    public final void updateTransactionsListHeader(TransactionsListHeaderDisplayModel transactionsListHeaderDisplayModel) {
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
        getTransactionListAdapter().clearItems();
        if (transactionsListHeaderDisplayModel != null) {
            if (transactionsListHeaderDisplayModel.getShouldDisplayCobrandedCCBanner()) {
                getWalletBannerConfiguration();
            }
            if (transactionsListHeaderDisplayModel.getExpiringCardDetailDisplayModel().getShouldDisplayView()) {
                addExpiringCardItem(transactionsListHeaderDisplayModel.getExpiringCardDetailDisplayModel());
            }
        }
        addTransactionsListRecentTitle();
    }

    /* access modifiers changed from: private */
    public final void updateWalletBalance(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        if (walletBalanceDisplayModel != null) {
            CurrencyFormatter.Companion companion = CurrencyFormatter.Companion;
            ((TextView) _$_findCachedViewById(R.id.wallet_balance_text_view)).setText(companion.formatAmount(getLocationConfigurationRepository(), walletBalanceDisplayModel.getWalletBalance(), true));
            ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_currency_text_view)).setText(walletBalanceDisplayModel.getAmountCurrency());
            ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_available_credit_amount_text_view)).setText(CurrencyFormatter.Companion.formatAmount$default(companion, getLocationConfigurationRepository(), walletBalanceDisplayModel.getWalletBalance(), false, 4, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public final void updateWalletTransactionList(WalletTransactionListDisplayModel walletTransactionListDisplayModel) {
        hideProgress();
        if (walletTransactionListDisplayModel != null) {
            getTransactionListAdapter().addItems(walletTransactionListDisplayModel.getWalletTransactionList());
            setToolbarFirstMonthData(walletTransactionListDisplayModel);
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

    public final void addAppBarInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "date");
        ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_string_text_view)).setText(getResources().getString(com.talabat.localization.R.string.spent_in_month_string, new Object[]{DateUtils.Companion.getLocalizedFormattedDateString(str, WalletDashboardFragmentKt.APP_BAR_DATE_OUTPUT_FORMAT)}));
        ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_amount_text_view)).setText(CurrencyFormatter.Companion.formatAmount$default(CurrencyFormatter.Companion, getLocationConfigurationRepository(), FloatKt.orZero(((WalletDashboardViewModel) getViewModel()).getAmountSpentPerMonthMap().get(WalletDateFormatter.Companion.getMonthAndYearForTransactionListGrouping(str, "yyyy-MM"))), false, 4, (Object) null));
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        if (((WalletDashboardViewModel) getViewModel()).isFirstResponse()) {
            disableDragging();
        }
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
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
    public final com.talabat.core.navigation.domain.Navigator getNavigator() {
        com.talabat.core.navigation.domain.Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    @NotNull
    public final TalabatTracker getTalabatTracker() {
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            return talabatTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatTracker");
        return null;
    }

    @NotNull
    public final WalletTransactionListAdapter getTransactionListAdapter() {
        WalletTransactionListAdapter walletTransactionListAdapter = this.transactionListAdapter;
        if (walletTransactionListAdapter != null) {
            return walletTransactionListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transactionListAdapter");
        return null;
    }

    @NotNull
    public Class<WalletDashboardViewModel> getViewModelClass() {
        return WalletDashboardViewModel.class;
    }

    public void hideProgress() {
        super.hideProgress();
        _$_findCachedViewById(R.id.progressBar).setVisibility(8);
    }

    public int layoutId() {
        return R.layout.fragment_wallet_dashboard;
    }

    public final void loadDynamicBannerForEmptyView(@NotNull WalletBannerDisplayModel walletBannerDisplayModel) {
        Intrinsics.checkNotNullParameter(walletBannerDisplayModel, "walletBannerDisplayModel");
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context requireContext = requireContext();
        String bannerImageUrl = walletBannerDisplayModel.getBannerImageUrl();
        int i11 = R.id.cobranded_cc_banner;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(i11).findViewById(R.id.iv_cobranded_cc);
        TransformType transformType = TransformType.FIT_CENTER;
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "iv_cobranded_cc");
        ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, requireContext, bannerImageUrl, appCompatImageView, 0, 200, transformType, 8, (Object) null);
        _$_findCachedViewById(i11).setOnClickListener(new h(this, walletBannerDisplayModel));
    }

    public void observatory() {
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getWalletBalanceDisplayModelData(), new WalletDashboardFragment$observatory$1(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getTransactionsListHeaderDisplayModelData(), new WalletDashboardFragment$observatory$2(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getWalletTransactionListDisplayModelData(), new WalletDashboardFragment$observatory$3(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getWalletTransactionEmptyListDisplayModelData(), new WalletDashboardFragment$observatory$4(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getWalletDashboardIconsData(), new WalletDashboardFragment$observatory$5(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getUserNotLoggedInData(), new WalletDashboardFragment$observatory$6(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getShouldShowOnBoardingData(), new WalletDashboardFragment$observatory$7(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getShouldShowTransactionDetailsData(), new WalletDashboardFragment$observatory$8(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getWalletShowNextScreenData(), new WalletDashboardFragment$observatory$9(this));
        LifecycleKt.observe(this, ((WalletDashboardViewModel) getViewModel()).getShouldShowOnBoardingInfoData(), new WalletDashboardFragment$observatory$10(this));
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 0) {
            return;
        }
        if (i12 == -1) {
            if (i11 == 2) {
                try {
                    refreshScreen();
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                }
            }
        } else if (i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
            refreshScreen();
            handleEmailLoginActivityResult();
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletDashboardFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRefresh() {
        showProgress();
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(true);
        resetPaginationParameters();
        EndlessScrollListener endlessScrollListener2 = this.endlessScrollListener;
        if (endlessScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endlessScrollListener");
            endlessScrollListener2 = null;
        }
        endlessScrollListener2.reset();
        int countryId = getConfigurationLocalRepository().selectedCountry().getCountryId();
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        ((WalletDashboardViewModel) getViewModel()).getTransactionsListHeader(countryId, companion.isLoggedIn());
        ((WalletDashboardViewModel) getViewModel()).getWalletBalance(String.valueOf(getConfigurationLocalRepository().selectedCountry().getCountryId()), companion.isLoggedIn());
    }

    public void onResume() {
        super.onResume();
        if (this.shouldRefreshOnResume) {
            onRefresh();
            this.shouldRefreshOnResume = false;
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        updateAppBarTitle();
        initializeRecyclerView();
        addScrollListener();
        addHeaderDecorator();
        addAppBarOffsetChangedListener();
        addEndlessScrollListener();
        addOnClickListeners();
        addBackIconsListeners();
        setCustomStatusBar();
        int i11 = R.id.swipeRefresh;
        ((SwipeRefreshLayout) _$_findCachedViewById(i11)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) _$_findCachedViewById(i11)).setRefreshing(false);
        loadTransactionList();
        loadOnBoardingInformation();
        handleExtraDestination();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull com.talabat.core.navigation.domain.Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }

    public final void setTransactionListAdapter(@NotNull WalletTransactionListAdapter walletTransactionListAdapter) {
        Intrinsics.checkNotNullParameter(walletTransactionListAdapter, "<set-?>");
        this.transactionListAdapter = walletTransactionListAdapter;
    }

    public void showProgress() {
        super.showProgress();
        _$_findCachedViewById(R.id.progressBar).setVisibility(0);
    }

    public final void transactionItemClicked(@NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "transactionItem");
        ((WalletDashboardViewModel) getViewModel()).onTransactionDetailsClicked(transactionDisplayModel.getId(), transactionDisplayModel.getTransactionTypeId());
    }

    @NotNull
    public WalletDashboardViewModel viewModelBuilder() {
        WalletDashboardViewModelBuilder walletDashboardViewModelBuilder = WalletDashboardViewModelBuilder.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        CoroutineScope coroutineScope = getCoroutineScope();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return walletDashboardViewModelBuilder.getWalletDashboardViewModel(requireActivity, coroutineScope, WalletDashboardFragmentKt.getDataStore(requireContext), getTalabatTracker(), getObservabilityManager());
    }
}
