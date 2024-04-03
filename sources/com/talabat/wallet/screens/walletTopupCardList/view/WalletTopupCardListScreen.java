package com.talabat.wallet.screens.walletTopupCardList.view;

import JsonModels.Response.WalletCashbackCampaignOfferMessageResponse;
import JsonModels.Response.WalletCashbackCampaignOfferMessageResponseResult;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen;
import com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen;
import com.talabat.wallet.screens.walletTopupCardList.presenter.WalletTopupCardListScreenPresenter;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletCreditCardAdapter;
import com.talabat.wallet.screens.walletTopupCardList.view.di.DaggerWalletTopupCardListScreenComponent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ky.c;
import ky.d;
import ky.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0016J\n\u0010,\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\u0018\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u0006\u00102\u001a\u00020(J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0016J\b\u00105\u001a\u00020(H\u0016J\u0012\u00106\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020(H\u0016J\u0018\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u00100\u001a\u000201H\u0016J\u0016\u0010=\u001a\u00020(2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020<0?H\u0016J\b\u0010@\u001a\u00020(H\u0016J\u0018\u0010A\u001a\u00020(2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010?H\u0016J\b\u0010B\u001a\u00020(H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletTopupCardListScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletTopupCardListView;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$WalletCreditCardAdapterInterface;", "()V", "SOURCE", "", "STATUS", "SUCCESS", "TOP_UP_SCREEN", "adapter", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter;", "getAdapter", "()Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter;", "setAdapter", "(Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "isCampaignAvailable", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletTopupCardListScreenPresenter", "Lcom/talabat/wallet/screens/walletTopupCardList/presenter/WalletTopupCardListScreenPresenter;", "creditCardItemClicked", "", "creditCardItem", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "destroyPresenter", "getPresenter", "getScreenName", "getWalletBankPartnerCardMessage", "card", "position", "", "goToParentScreen", "initializeRecyclerView", "onAuthError", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onReceivedBankPartnerCardAdvertMessage", "walletCreditCardGetListDataItem", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "onReceivedBankPartnerData", "walletCreditCardList", "", "onServerError", "onWalletCardReceived", "setupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreen extends TalabatBase implements WalletTopupCardListView, ResponseStatusInterface, WalletCreditCardAdapter.WalletCreditCardAdapterInterface {
    @NotNull
    private final String SOURCE = "source";
    @NotNull
    private final String STATUS = "status";
    @NotNull
    private final String SUCCESS = "success";
    @NotNull
    private final String TOP_UP_SCREEN = "top up screen";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public WalletCreditCardAdapter adapter;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private boolean isCampaignAvailable;
    public LinearLayoutManager layoutManager;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTopupCardListScreenPresenter mWalletTopupCardListScreenPresenter;

    /* access modifiers changed from: private */
    public final void creditCardItemClicked(WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
        String str;
        Intent intent = new Intent(this, WalletTopUpScreen.class);
        intent.putExtra(WalletNavigatorActions.EXTRA_TOKEN_ID, walletCreditCardGetListResponseResult.getTokenId());
        String cardNumber = walletCreditCardGetListResponseResult.getCardNumber();
        if (cardNumber != null) {
            str = StringsKt___StringsKt.takeLast(cardNumber, 4);
        } else {
            str = null;
        }
        intent.putExtra(WalletNavigatorActions.EXTRA_CARD_4_DIGITS, str);
        intent.putExtra("cardType", walletCreditCardGetListResponseResult.getCardType());
        intent.putExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, this.isCampaignAvailable);
        intent.putExtra("binNumber", walletCreditCardGetListResponseResult.getBinNumber());
        startActivity(intent);
    }

    private final void initializeRecyclerView() {
        setLayoutManager(new LinearLayoutManager(this));
        int i11 = R.id.credit_card_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(getLayoutManager());
        setAdapter(new WalletCreditCardAdapter(this, this, new WalletTopupCardListScreen$initializeRecyclerView$1(this)));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getAdapter());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m6008onCreate$lambda0(WalletTopupCardListScreen walletTopupCardListScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreen, "this$0");
        walletTopupCardListScreen.goToParentScreen();
        walletTopupCardListScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m6009onCreate$lambda1(WalletTopupCardListScreen walletTopupCardListScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreen, "this$0");
        Intent intent = new Intent(walletTopupCardListScreen, WalletAddCreditCardScreen.class);
        intent.putExtra(walletTopupCardListScreen.SOURCE, walletTopupCardListScreen.TOP_UP_SCREEN);
        walletTopupCardListScreen.startActivity(intent);
        walletTopupCardListScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m6010onCreate$lambda2(WalletTopupCardListScreen walletTopupCardListScreen) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreen, "this$0");
        ConstraintLayout constraintLayout = (ConstraintLayout) walletTopupCardListScreen._$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root_view");
        String string = walletTopupCardListScreen.getResources().getString(R.string.wallet_card_successfully_added);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…_card_successfully_added)");
        walletTopupCardListScreen.makeSnackBar(constraintLayout, walletTopupCardListScreen, string, ResponseStatus.SUCCESS);
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

    public void destroyPresenter() {
        this.mWalletTopupCardListScreenPresenter = null;
    }

    @NotNull
    public final WalletCreditCardAdapter getAdapter() {
        WalletCreditCardAdapter walletCreditCardAdapter = this.adapter;
        if (walletCreditCardAdapter != null) {
            return walletCreditCardAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
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
    public String getScreenName() {
        return "wallet top up card list";
    }

    public void getWalletBankPartnerCardMessage(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponseResult, "card");
        WalletTopupCardListScreenPresenter walletTopupCardListScreenPresenter = this.mWalletTopupCardListScreenPresenter;
        if (walletTopupCardListScreenPresenter != null) {
            walletTopupCardListScreenPresenter.setWalletBankPartnerCardMessage(walletCreditCardGetListResponseResult, i11);
        }
    }

    public final void goToParentScreen() {
        Intent intent = new Intent(this, WalletTransactionDashboardScreen.class);
        intent.addFlags(335544320);
        intent.addFlags(1073741824);
        startActivity(intent);
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        goToParentScreen();
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletTopupCardListScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wallet_topup_card_list_screen);
        this.mWalletTopupCardListScreenPresenter = new WalletTopupCardListScreenPresenter(getLocationConfigurationRepository(), this, getConfigurationLocalRepository());
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new c(this));
        initializeRecyclerView();
        WalletTopupCardListScreenPresenter walletTopupCardListScreenPresenter = this.mWalletTopupCardListScreenPresenter;
        if (walletTopupCardListScreenPresenter != null) {
            walletTopupCardListScreenPresenter.setAllWalletCreditCards();
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.wallet_empty_view).findViewById(R.id.add_new_card_button)).setOnClickListener(new d(this));
        if (getIntent().hasExtra(this.STATUS) && Intrinsics.areEqual((Object) getIntent().getStringExtra(this.STATUS), (Object) this.SUCCESS)) {
            new Handler().postDelayed(new e(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    public void onError() {
    }

    public void onReceivedBankPartnerCardAdvertMessage(@NotNull WalletCreditCardGetListDataItem walletCreditCardGetListDataItem, int i11) {
        String str;
        boolean z11;
        WalletCashbackCampaignOfferMessageResponseResult result;
        Intrinsics.checkNotNullParameter(walletCreditCardGetListDataItem, "walletCreditCardGetListDataItem");
        WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult = (WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) walletCreditCardGetListDataItem;
        WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse = walletCreditCardGetListResponseResult.getWalletCashbackCampaignOfferMessageResponse();
        if (walletCashbackCampaignOfferMessageResponse == null || (result = walletCashbackCampaignOfferMessageResponse.getResult()) == null) {
            str = null;
        } else {
            str = result.getAdTextMessage();
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            getAdapter().setData(i11, walletCreditCardGetListResponseResult);
        }
    }

    public void onReceivedBankPartnerData(@NotNull List<? extends WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "walletCreditCardList");
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        getAdapter().clearItems();
        if (list.isEmpty()) {
            ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(8);
            _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(0);
            return;
        }
        ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(0);
        _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(8);
        getAdapter().addItems(list);
        if (list.get(0) instanceof WalletCreditCardGetListDataItem.WalletCashbackCampaign) {
            this.isCampaignAvailable = true;
        }
    }

    public void onServerError() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root_view");
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        makeSnackBar(constraintLayout, this, string, ResponseStatus.ERROR);
    }

    public void onWalletCardReceived(@Nullable List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list) {
        if (list != null) {
            ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
            getAdapter().clearItems();
            if (list.isEmpty()) {
                ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(8);
                _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(0);
                return;
            }
            ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(0);
            _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(8);
            getAdapter().addItems(list);
            getAdapter().addActionView();
        }
    }

    public final void setAdapter(@NotNull WalletCreditCardAdapter walletCreditCardAdapter) {
        Intrinsics.checkNotNullParameter(walletCreditCardAdapter, "<set-?>");
        this.adapter = walletCreditCardAdapter;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setLayoutManager(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void setupViewsBeforeServiceRequest() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(0);
    }

    @Nullable
    public WalletTopupCardListScreenPresenter getPresenter() {
        return this.mWalletTopupCardListScreenPresenter;
    }
}
