package com.talabat.wallet.screens.walletDashboard.view;

import JsonModels.Response.WalletTransactionListDataItem;
import JsonModels.Response.WalletTransactionListDataModel;
import JsonModels.Response.WalletTransactionSpentPerMonthModel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import buisnessmodels.TalabatFormatter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.GiftVoucherList;
import com.talabat.LoginScreen;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.home.HomeScreenActivity;
import com.talabat.splash.core.extension.LifeCycleKt;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.wallet.common.walletBalance.presenter.WalletBalancePresenter;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.helpers.WalletFormatterInterface;
import com.talabat.wallet.screens.walletDashboard.presenter.WalletTransactionDashboardScreenPresenter;
import com.talabat.wallet.screens.walletDashboard.view.di.DaggerWalletTransactionDashboardScreenComponent;
import com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailScreen;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import com.talabat.wallet.ui.expiringCard.viewModel.ExpiringCardViewModel;
import com.talabat.wallet.ui.expiringCard.viewModel.ExpiringCardViewModelBuilder;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragmentKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;
import yx.b;
import yx.c;
import yx.d;
import yx.e;
import yx.f;
import yx.g;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010Y\u001a\u00020ZH\u0002J\b\u0010[\u001a\u00020ZH\u0002J\u0017\u0010\\\u001a\u00020Z2\b\u0010]\u001a\u0004\u0018\u00010JH\u0016¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020ZH\u0002J\u0012\u0010`\u001a\u00020Z2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\b\u0010c\u001a\u00020ZH\u0002J\b\u0010d\u001a\u00020ZH\u0002J\b\u0010e\u001a\u00020ZH\u0002J\u0012\u0010f\u001a\u00020Z2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010i\u001a\u00020Z2\u0006\u0010j\u001a\u00020JH\u0002J\b\u0010k\u001a\u00020ZH\u0016J\b\u0010l\u001a\u00020ZH\u0016J\u0006\u0010m\u001a\u00020ZJ\n\u0010n\u001a\u0004\u0018\u00010GH\u0016J\b\u0010o\u001a\u00020\bH\u0016J\b\u0010p\u001a\u00020ZH\u0002J\b\u0010q\u001a\u00020ZH\u0002J#\u0010r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020.0sH\u0002J\b\u0010w\u001a\u00020ZH\u0002J\b\u0010x\u001a\u00020ZH\u0002J\"\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\u000e2\b\u0010|\u001a\u0004\u0018\u00010}H\u0014J\b\u0010~\u001a\u00020ZH\u0016J\b\u0010\u001a\u00020ZH\u0016J\u0015\u0010\u0001\u001a\u00020Z2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0002J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0002J\t\u0010\u0001\u001a\u00020ZH\u0003J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0002J\t\u0010\u0001\u001a\u00020ZH\u0016J\u0011\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010\u0001\u001a\u00020Z2\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020Z2\u0007\u0010\u0001\u001a\u000207H\u0002J\u0013\u0010\u0001\u001a\u00020Z2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002J\u0015\u0010\u0001\u001a\u00020Z2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016J\t\u0010\u0001\u001a\u00020ZH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u000e\u00105\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000209X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R2\u0010H\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010J0Ij\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010J`KX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010Q\"\u0004\bX\u0010S¨\u0006\u0001"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreenView;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "()V", "DATE_INPUT_FORMAT", "", "DATE_OUTPUT_FORMAT", "EMPTY_STRING", "getEMPTY_STRING", "()Ljava/lang/String;", "HEADER_VIEW_TYPE", "", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "OUTPUT_DATE_FORMAT_FOR_EXPIRING_DATE", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "adapter", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter;", "getAdapter", "()Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter;", "setAdapter", "(Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter;)V", "amountTransactionsFetchedFromLastApiResponse", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "endlessScrollListener", "Lcom/talabat/wallet/screens/walletDashboard/view/EndlessScrollListener;", "expiringCardViewModel", "Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModel;", "headerDecorator", "Lcom/talabat/wallet/screens/walletDashboard/view/HeaderItemDecoration;", "isBalanceFinishedLoading", "", "isFirstResponse", "()Z", "setFirstResponse", "(Z)V", "isNetworkError", "setNetworkError", "isTransactionListFinishedLoading", "lastItem", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletBalancePresenter", "Lcom/talabat/wallet/common/walletBalance/presenter/WalletBalancePresenter;", "mWalletTransactionDashboardScreenPresenter", "Lcom/talabat/wallet/screens/walletDashboard/presenter/WalletTransactionDashboardScreenPresenter;", "monthAndAmountMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "numberOfItemsPerPage", "pageNumber", "setDefaultBackgroundColor", "totalItemCount", "getTotalItemCount", "()I", "setTotalItemCount", "(I)V", "transactionId", "transactionType", "visibleItemCount", "getVisibleItemCount", "setVisibleItemCount", "addAppBarOffsetChangedListener", "", "addBackIconsListeners", "addBalance", "balance", "(Ljava/lang/Float;)V", "addEndlessScollListener", "addExpiringCardItem", "expiringCardDetailDisplayModel", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "addOnClickListeners", "addRecentHeaderItem", "addScrollListener", "addWalletCreditTransactionListData", "walletTransactionListDataModel", "LJsonModels/Response/WalletTransactionListDataModel;", "adjustAppBarChildrenViewsAlpha", "scrollPercentage", "destroyPresenter", "displayServerErrorMessage", "displayWalletServerErrorMessage", "getPresenter", "getScreenName", "hideStickyBar", "initializeRecyclerView", "isHeader", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "itemPosition", "loadData", "navigateToHomeScreen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onRefresh", "redirectToEmptyListView", "redirectToLoginScreen", "redirectWalletToLoginScreen", "refreshSidemenu", "resetPaginationParameters", "setCustomStatusBar", "setupProgressBarBeforeServiceRequest", "showCardManagementIcon", "showSendGiftIcon", "showStickyBar", "showTopUpIcon", "slideDown", "view", "Landroid/view/View;", "slideUp", "transactionItemClicked", "transactionItem", "updateAdapter", "updateAdapterOnFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "walletBalanceDisplayServerErrorMessage", "walletBalanceRedirectToLoginScreen", "walletBalanceSetupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreen extends TalabatBase implements WalletTransactionDashboardScreenView, SwipeRefreshLayout.OnRefreshListener, WalletFormatterInterface, ResponseStatusInterface {
    /* access modifiers changed from: private */
    @NotNull
    public final String DATE_INPUT_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    /* access modifiers changed from: private */
    @NotNull
    public final String DATE_OUTPUT_FORMAT = WalletDashboardFragmentKt.APP_BAR_DATE_OUTPUT_FORMAT;
    @NotNull
    private final String EMPTY_STRING = "";
    /* access modifiers changed from: private */
    public final int HEADER_VIEW_TYPE = 2;
    @NotNull
    private final String INPUT_DATE_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    @NotNull
    private final String OUTPUT_DATE_FORMAT_FOR_EXPIRING_DATE = "LLLL dd, yyyy";
    @NotNull
    private final String OUT_DATE_FORMAT = "yyyy-MM";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public WalletCreditTransactionListAdapter adapter;
    private int amountTransactionsFetchedFromLastApiResponse;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private CoroutineScope coroutineScope = new WalletTransactionDashboardScreen$coroutineScope$1();
    private EndlessScrollListener endlessScrollListener;
    private ExpiringCardViewModel expiringCardViewModel;
    private HeaderItemDecoration headerDecorator;
    private boolean isBalanceFinishedLoading;
    private boolean isFirstResponse = true;
    private boolean isNetworkError;
    private boolean isTransactionListFinishedLoading;
    /* access modifiers changed from: private */
    @Nullable
    public WalletTransactionListDataItem.TransactionModel lastItem;
    public LinearLayoutManager layoutManager;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletBalancePresenter mWalletBalancePresenter;
    /* access modifiers changed from: private */
    @Nullable
    public WalletTransactionDashboardScreenPresenter mWalletTransactionDashboardScreenPresenter;
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, Float> monthAndAmountMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final int numberOfItemsPerPage = 10;
    /* access modifiers changed from: private */
    public int pageNumber = -1;
    private boolean setDefaultBackgroundColor = true;
    private int totalItemCount;
    @NotNull
    private final String transactionId = "transactionId";
    @NotNull
    private final String transactionType = "transactionType";
    private int visibleItemCount;

    private final void addAppBarOffsetChangedListener() {
        ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new WalletTransactionDashboardScreen$addAppBarOffsetChangedListener$1(this));
    }

    private final void addBackIconsListeners() {
        ((ImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new c(this));
        ((ImageView) _$_findCachedViewById(R.id.toolbar_back_icon)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addBackIconsListeners$lambda-3  reason: not valid java name */
    public static final void m5971addBackIconsListeners$lambda3(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        walletTransactionDashboardScreen.navigateToHomeScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: addBackIconsListeners$lambda-4  reason: not valid java name */
    public static final void m5972addBackIconsListeners$lambda4(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        walletTransactionDashboardScreen.navigateToHomeScreen();
    }

    private final void addEndlessScollListener() {
        int i11 = R.id.wallet_transaction_list;
        RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) _$_findCachedViewById(i11)).getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2);
        this.endlessScrollListener = new WalletTransactionDashboardScreen$addEndlessScollListener$1(this, layoutManager2);
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
            WalletCreditTransactionListAdapter adapter2 = getAdapter();
            String string = getString(R.string.credit_is_expiring, new Object[]{TalabatFormatter.getInstance().getFormattedCurrency(expiringCardDetailDisplayModel.getAmount(), true)});
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …                   true))");
            String string2 = getString(R.string.expiring_card_date_message, new Object[]{dateFormatter(expiringCardDetailDisplayModel.getExpiryDate(), this.DATE_INPUT_FORMAT, this.OUTPUT_DATE_FORMAT_FOR_EXPIRING_DATE)});
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …                        )");
            adapter2.addItem(new WalletTransactionListDataItem.ExpiringCardModel(string, string2));
        }
    }

    private final void addOnClickListeners() {
        ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setOnClickListener(new e(this));
        ((TextView) _$_findCachedViewById(R.id.top_button)).setOnClickListener(new f(this));
        ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setOnClickListener(new g(this));
        addBackIconsListeners();
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setOnRefreshListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-0  reason: not valid java name */
    public static final void m5973addOnClickListeners$lambda0(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        walletTransactionDashboardScreen.startActivity(new Intent(walletTransactionDashboardScreen, WalletManageCreditCardsScreen.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-1  reason: not valid java name */
    public static final void m5974addOnClickListeners$lambda1(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        AppTracker.onWalletTopupClicked(walletTransactionDashboardScreen.getContext(), walletTransactionDashboardScreen.getScreenName(), "wallet");
        walletTransactionDashboardScreen.startActivity(new Intent(walletTransactionDashboardScreen, WalletTopupCardListScreen.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnClickListeners$lambda-2  reason: not valid java name */
    public static final void m5975addOnClickListeners$lambda2(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        walletTransactionDashboardScreen.startActivity(new Intent(walletTransactionDashboardScreen, GiftVoucherList.class));
    }

    private final void addRecentHeaderItem() {
        getAdapter().addItem(new WalletTransactionListDataItem.ListHeader());
    }

    private final void addScrollListener() {
        int i11 = R.id.wallet_transaction_list;
        ((RecyclerView) _$_findCachedViewById(i11)).addOnScrollListener(new WalletTransactionDashboardScreen$addScrollListener$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "wallet_transaction_list");
        this.headerDecorator = new HeaderItemDecoration(recyclerView, true, isHeader(), this);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i11);
        HeaderItemDecoration headerItemDecoration = this.headerDecorator;
        if (headerItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerDecorator");
            headerItemDecoration = null;
        }
        recyclerView2.addItemDecoration(headerItemDecoration);
    }

    /* access modifiers changed from: private */
    public final void adjustAppBarChildrenViewsAlpha(float f11) {
        float f12 = ((float) 1) - f11;
        ((TextView) _$_findCachedViewById(R.id.top_button)).setAlpha(f12);
        ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setAlpha(f12);
        ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setAlpha(f12);
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setAlpha(f11);
        ((Toolbar) _$_findCachedViewById(R.id.wallet_sticky_toolbar)).setAlpha(f11);
    }

    /* access modifiers changed from: private */
    public final void hideStickyBar() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setVisibility(8);
        int i11 = R.id.wallet_sticky_toolbar;
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(toolbar, "wallet_sticky_toolbar");
        slideDown(toolbar);
        ((Toolbar) _$_findCachedViewById(i11)).setVisibility(8);
    }

    private final void initializeRecyclerView() {
        setLayoutManager(new LinearLayoutManager(this));
        int i11 = R.id.wallet_transaction_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(getLayoutManager());
        ((RecyclerView) _$_findCachedViewById(i11)).hasFixedSize();
        setAdapter(new WalletCreditTransactionListAdapter(this, new WalletTransactionDashboardScreen$initializeRecyclerView$1(this)));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getAdapter());
    }

    private final Function1<Integer, Boolean> isHeader() {
        return new WalletTransactionDashboardScreen$isHeader$1(this);
    }

    private final void loadData() {
        ExpiringCardViewModel expiringCardViewModel2 = null;
        this.lastItem = null;
        WalletBalancePresenter walletBalancePresenter = this.mWalletBalancePresenter;
        if (walletBalancePresenter != null) {
            walletBalancePresenter.setWalletCreditCardUserInfo();
        }
        ExpiringCardViewModel expiringCardViewModel3 = this.expiringCardViewModel;
        if (expiringCardViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expiringCardViewModel");
        } else {
            expiringCardViewModel2 = expiringCardViewModel3;
        }
        expiringCardViewModel2.getExpiringCardDetail(getConfigurationLocalRepository().selectedCountry().getCountryId());
    }

    private final void navigateToHomeScreen() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.addFlags(335544320);
        startActivity(intent);
    }

    private final void redirectWalletToLoginScreen() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.user_not_logged_container)).setVisibility(0);
        ((Toolbar) _$_findCachedViewById(R.id.wallet_sticky_toolbar)).setVisibility(8);
        ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_action_container)).setVisibility(4);
        ((TalabatFillButton) _$_findCachedViewById(R.id.log_in_button)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: redirectWalletToLoginScreen$lambda-5  reason: not valid java name */
    public static final void m5976redirectWalletToLoginScreen$lambda5(WalletTransactionDashboardScreen walletTransactionDashboardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreen, "this$0");
        Intent intent = new Intent(walletTransactionDashboardScreen, LoginScreen.class);
        if (!walletTransactionDashboardScreen.getIntent().hasExtra("destination") || !Intrinsics.areEqual((Object) walletTransactionDashboardScreen.getIntent().getStringExtra("destination"), (Object) "wallet top up card list")) {
            intent.putExtra("from", ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT);
            walletTransactionDashboardScreen.startActivityForResult(intent, 2);
            return;
        }
        intent.putExtra("from", "wallet top up card list");
        walletTransactionDashboardScreen.startActivityForResult(intent, 2);
        walletTransactionDashboardScreen.finish();
    }

    private final void resetPaginationParameters() {
        this.pageNumber = -1;
        this.lastItem = null;
        this.isFirstResponse = true;
    }

    @RequiresApi(21)
    private final void setCustomStatusBar() {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.sec_blue_10));
    }

    /* access modifiers changed from: private */
    public final void showStickyBar() {
        int i11 = R.id.wallet_sticky_toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setVisibility(0);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(toolbar, "wallet_sticky_toolbar");
        slideUp(toolbar);
        ((ConstraintLayout) _$_findCachedViewById(R.id.wallet_credit_balance_summary_container)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void transactionItemClicked(WalletTransactionListDataItem.TransactionModel transactionModel) {
        Intent intent = new Intent(this, WalletTransactionDetailScreen.class);
        intent.putExtra(this.transactionId, transactionModel.getId());
        intent.putExtra(this.transactionType, transactionModel.getTransactionTypeId());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void updateAdapter(ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
        getAdapter().clearItems();
        if (expiringCardDetailDisplayModel != null && expiringCardDetailDisplayModel.getShouldDisplayView()) {
            addExpiringCardItem(expiringCardDetailDisplayModel);
        }
        addRecentHeaderItem();
    }

    /* access modifiers changed from: private */
    public final void updateAdapterOnFailure(Failure failure) {
        getAdapter().clearItems();
        addRecentHeaderItem();
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

    public void addBalance(@Nullable Float f11) {
        String currencyLocale = getCurrencyLocale();
        String amountWithoutCurrency = getAmountWithoutCurrency(f11);
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
        this.isBalanceFinishedLoading = true;
        if (this.isTransactionListFinishedLoading) {
            ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        }
        ((TextView) _$_findCachedViewById(R.id.wallet_balance_text_view)).setText(currencyLocale + " " + amountWithoutCurrency);
        ((TalabatTextView) _$_findCachedViewById(R.id.sticky_toolbar_currency_text_view)).setText(currencyLocale);
        ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_available_credit_amount_text_view)).setText(amountWithoutCurrency);
    }

    public void addWalletCreditTransactionListData(@Nullable WalletTransactionListDataModel walletTransactionListDataModel) {
        boolean z11;
        List<WalletTransactionListDataItem> list;
        List<WalletTransactionSpentPerMonthModel> list2;
        List<WalletTransactionListDataItem> transactionListDataItem;
        this.isTransactionListFinishedLoading = true;
        if (this.isBalanceFinishedLoading) {
            ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        }
        if (walletTransactionListDataModel == null || (transactionListDataItem = walletTransactionListDataModel.getTransactionListDataItem()) == null || !(!transactionListDataItem.isEmpty())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            WalletCreditTransactionListAdapter adapter2 = getAdapter();
            WalletTransactionListDataItem walletTransactionListDataItem = null;
            if (walletTransactionListDataModel != null) {
                list = walletTransactionListDataModel.getTransactionListDataItem();
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list);
            adapter2.addItems(list);
            if (walletTransactionListDataModel != null) {
                list2 = walletTransactionListDataModel.getWalletTransactionWithMonthModel();
            } else {
                list2 = null;
            }
            Intrinsics.checkNotNull(list2);
            for (WalletTransactionSpentPerMonthModel next : list2) {
                this.monthAndAmountMap.put(next.getMonth(), next.getSpendAmount());
            }
            List<WalletTransactionListDataItem> transactionListDataItem2 = walletTransactionListDataModel.getTransactionListDataItem();
            Intrinsics.checkNotNull(transactionListDataItem2);
            int size = transactionListDataItem2.size();
            if (size > 0) {
                List<WalletTransactionListDataItem> transactionListDataItem3 = walletTransactionListDataModel.getTransactionListDataItem();
                Intrinsics.checkNotNull(transactionListDataItem3);
                this.lastItem = (WalletTransactionListDataItem.TransactionModel) transactionListDataItem3.get(size - 1);
                if (this.isFirstResponse) {
                    List<WalletTransactionListDataItem> transactionListDataItem4 = walletTransactionListDataModel.getTransactionListDataItem();
                    if (transactionListDataItem4 != null) {
                        walletTransactionListDataItem = transactionListDataItem4.get(0);
                    }
                    if (walletTransactionListDataItem != null) {
                        String date = ((WalletTransactionListDataItem.Header) walletTransactionListDataItem).getDate();
                        ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_string_text_view)).setText(getResources().getString(R.string.spent_in_month_string, new Object[]{dateFormatter(date, this.DATE_INPUT_FORMAT, this.DATE_OUTPUT_FORMAT)}));
                        ((TextView) _$_findCachedViewById(R.id.sticky_toolbar_spent_in_month_amount_text_view)).setText(getAmountWithoutCurrency(this.monthAndAmountMap.get(getMonthAndYearForMapingAndGrouping(date))));
                        this.isFirstResponse = false;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type JsonModels.Response.WalletTransactionListDataItem.Header");
                }
            }
        }
    }

    @NotNull
    public String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        return WalletFormatterInterface.DefaultImpls.dateFormatter(this, str, str2, str3);
    }

    public void destroyPresenter() {
        this.mWalletTransactionDashboardScreenPresenter = null;
    }

    public void displayServerErrorMessage() {
        displayWalletServerErrorMessage();
    }

    public final void displayWalletServerErrorMessage() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        this.isNetworkError = true;
        if (this.isFirstResponse) {
            ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) _$_findCachedViewById(R.id.toolbar_layout)).getLayoutParams();
            if (layoutParams != null) {
                ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(0);
                ViewGroup.LayoutParams layoutParams2 = ((AppBarLayout) _$_findCachedViewById(R.id.app_bar)).getLayoutParams();
                if (layoutParams2 != null) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams2).getBehavior();
                    if (behavior != null) {
                        ((AppBarLayout.Behavior) behavior).setDragCallback(new WalletTransactionDashboardScreen$displayWalletServerErrorMessage$1());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.Behavior");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
            }
        }
        Status.Companion companion = Status.Companion;
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        Status.Companion.notify$default(companion, this, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    @NotNull
    public String formatAmountWithSign(@Nullable Float f11, boolean z11, boolean z12) {
        return WalletFormatterInterface.DefaultImpls.formatAmountWithSign(this, f11, z11, z12);
    }

    @NotNull
    public final WalletCreditTransactionListAdapter getAdapter() {
        WalletCreditTransactionListAdapter walletCreditTransactionListAdapter = this.adapter;
        if (walletCreditTransactionListAdapter != null) {
            return walletCreditTransactionListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @NotNull
    public String getAmountSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountSign(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrency(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrency(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrencyWithSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrencyWithSign(this, f11);
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
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public String getCurrencyLocale() {
        return WalletFormatterInterface.DefaultImpls.getCurrencyLocale(this);
    }

    @NotNull
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @NotNull
    public String getINPUT_DATE_FORMAT() {
        return this.INPUT_DATE_FORMAT;
    }

    @NotNull
    public final LinearLayoutManager getLayoutManager() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
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
    public String getMonthAndYearForMapingAndGrouping(@Nullable String str) {
        return WalletFormatterInterface.DefaultImpls.getMonthAndYearForMapingAndGrouping(this, str);
    }

    @NotNull
    public String getOUT_DATE_FORMAT() {
        return this.OUT_DATE_FORMAT;
    }

    @NotNull
    public String getScreenName() {
        return "Wallet Dashboard screen";
    }

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    public final int getVisibleItemCount() {
        return this.visibleItemCount;
    }

    public final boolean isFirstResponse() {
        return this.isFirstResponse;
    }

    public final boolean isNetworkError() {
        return this.isNetworkError;
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 2) {
            try {
                startActivity(new Intent(this, WalletTransactionDashboardScreen.class));
                finish();
            } catch (NullPointerException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        navigateToHomeScreen();
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletTransactionDashboardScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wallet_dashboard_screen);
        initializeRecyclerView();
        addScrollListener();
        addAppBarOffsetChangedListener();
        addOnClickListeners();
        addEndlessScollListener();
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
        WalletTransactionDashboardScreenPresenter walletTransactionDashboardScreenPresenter = new WalletTransactionDashboardScreenPresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), this);
        this.mWalletTransactionDashboardScreenPresenter = walletTransactionDashboardScreenPresenter;
        walletTransactionDashboardScreenPresenter.showMenuButtonsBasedOnFlagStatus();
        this.mWalletBalancePresenter = new WalletBalancePresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), this);
        ExpiringCardViewModel expiringCardViewModel2 = ExpiringCardViewModelBuilder.Companion.getExpiringCardViewModel(this, this.coroutineScope);
        this.expiringCardViewModel = expiringCardViewModel2;
        ExpiringCardViewModel expiringCardViewModel3 = null;
        if (expiringCardViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expiringCardViewModel");
            expiringCardViewModel2 = null;
        }
        LifeCycleKt.observe(this, expiringCardViewModel2.getExpiringCardData(), new WalletTransactionDashboardScreen$onCreate$1(this));
        ExpiringCardViewModel expiringCardViewModel4 = this.expiringCardViewModel;
        if (expiringCardViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expiringCardViewModel");
        } else {
            expiringCardViewModel3 = expiringCardViewModel4;
        }
        LifeCycleKt.observe(this, expiringCardViewModel3.getFailureData(), new WalletTransactionDashboardScreen$onCreate$2(this));
        loadData();
        setCustomStatusBar();
    }

    public void onError() {
    }

    public void onRefresh() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(0);
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(true);
        resetPaginationParameters();
        this.isTransactionListFinishedLoading = false;
        this.isBalanceFinishedLoading = false;
        EndlessScrollListener endlessScrollListener2 = this.endlessScrollListener;
        if (endlessScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endlessScrollListener");
            endlessScrollListener2 = null;
        }
        endlessScrollListener2.reset();
        loadData();
    }

    public void redirectToEmptyListView() {
        ((RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.empty_transaction_textview)).setVisibility(0);
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
    }

    public void redirectToLoginScreen() {
        redirectWalletToLoginScreen();
    }

    public void refreshSidemenu() {
        setSideMenu();
    }

    public final void setAdapter(@NotNull WalletCreditTransactionListAdapter walletCreditTransactionListAdapter) {
        Intrinsics.checkNotNullParameter(walletCreditTransactionListAdapter, "<set-?>");
        this.adapter = walletCreditTransactionListAdapter;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public final void setFirstResponse(boolean z11) {
        this.isFirstResponse = z11;
    }

    public final void setLayoutManager(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNetworkError(boolean z11) {
        this.isNetworkError = z11;
    }

    public final void setTotalItemCount(int i11) {
        this.totalItemCount = i11;
    }

    public final void setVisibleItemCount(int i11) {
        this.visibleItemCount = i11;
    }

    public void setupProgressBarBeforeServiceRequest() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(0);
    }

    public void showCardManagementIcon() {
        ((TextView) _$_findCachedViewById(R.id.menu_manage_textview)).setVisibility(0);
    }

    public void showSendGiftIcon() {
        ((TextView) _$_findCachedViewById(R.id.send_gift_button)).setVisibility(0);
    }

    public void showTopUpIcon() {
        ((TextView) _$_findCachedViewById(R.id.top_button)).setVisibility(0);
    }

    public final void slideDown(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAlpha(0.5f);
    }

    public final void slideUp(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(0);
        view.setAlpha(1.0f);
    }

    public void walletBalanceDisplayServerErrorMessage() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(4);
        ((SwipeRefreshLayout) _$_findCachedViewById(R.id.swipeRefresh)).setRefreshing(false);
        this.isBalanceFinishedLoading = true;
        Status.Companion companion = Status.Companion;
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        Status.Companion.notify$default(companion, this, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    public void walletBalanceRedirectToLoginScreen() {
        redirectWalletToLoginScreen();
    }

    public void walletBalanceSetupViewsBeforeServiceRequest() {
        ((TextView) _$_findCachedViewById(R.id.empty_transaction_textview)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.user_not_logged_container)).setVisibility(8);
        ((CollapsingToolbarLayout) _$_findCachedViewById(R.id.toolbar_layout)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(R.id.wallet_transaction_list)).setVisibility(0);
    }

    @Nullable
    public WalletTransactionDashboardScreenPresenter getPresenter() {
        return this.mWalletTransactionDashboardScreenPresenter;
    }
}
