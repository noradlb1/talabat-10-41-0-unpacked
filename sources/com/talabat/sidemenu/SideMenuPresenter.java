package com.talabat.sidemenu;

import JsonModels.Response.CustomerLastOrderDetailsRM;
import JsonModels.Response.TalabatCreditBalanceResponse;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.UrlConstantsKt;
import datamodels.JMenuSection;
import datamodels.LastOrdersDetails;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.home.VoucherNotificationStyle;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Instrumented
public class SideMenuPresenter implements ISideMenuPresenter, SideMenuListener {
    public static final String EXPERIMENT_ALERT_PAY_LATER_DASHBOARD = "experiment alert pay later dashboard";
    private IsideMenuInteractor isideMenuInteractor;
    private SideMenuView sideMenuView;

    public SideMenuPresenter(SideMenuView sideMenuView2, ConfigurationLocalRepository configurationLocalRepository) {
        this.sideMenuView = sideMenuView2;
        this.isideMenuInteractor = new SideMenuInteractor(this, new VoucherRepositoryImpl(new NetworkHandler(Integration.getAppContext()), new VouchersService(new TalabatAPIBuilder())), Schedulers.io(), AndroidSchedulers.mainThread(), configurationLocalRepository, (GetOverdueUseCase) null, (IObservabilityManager) null, (SendNavigationOptionLoadedEventUseCase) null, (IsUserBNPLEligibleUseCase) null, (CoroutineScope) null);
        if (GlobalDataModel.JSON.sideMenuSection == null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String loadJSONFromAsset = loadJSONFromAsset(sideMenuView2.getContext());
            Class cls = JMenuSection[].class;
            GlobalDataModel.JSON.sideMenuSection = (JMenuSection[]) (!(gson instanceof Gson) ? gson.fromJson(loadJSONFromAsset, cls) : GsonInstrumentation.fromJson(gson, loadJSONFromAsset, cls));
        }
    }

    private String loadJSONFromAsset(Context context) {
        InputStream open;
        try {
            open = context.getAssets().open("sidemenu.json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            String str = new String(bArr, "UTF-8");
            open.close();
            return str;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void checkUserBNPLEligible() {
        this.isideMenuInteractor.checkUserEligibleForBNPL();
    }

    public void loadBnplOverdues() {
        this.isideMenuInteractor.loadBnplOverdues();
    }

    public void onBnplOverdueLoaded(@NonNull GetOverdueUseCase.OverdueResult overdueResult) {
        if (overdueResult instanceof GetOverdueUseCase.OverdueResult.Overdue) {
            this.sideMenuView.showBnplOverdueNotification(((GetOverdueUseCase.OverdueResult.Overdue) overdueResult).getTotalAmount());
            return;
        }
        this.sideMenuView.hideBnplOverdueNotification();
    }

    public void onCreditBalanceDetailsReceived(@Nullable TalabatCreditBalanceResponse talabatCreditBalanceResponse) {
        if (talabatCreditBalanceResponse != null && Customer.getInstance() != null && Customer.getInstance().getCustomerInfo() != null) {
            Customer.getInstance().getCustomerInfo().talabatCredit = talabatCreditBalanceResponse.getTotBalance();
            this.sideMenuView.onCreditBalanceRefresh();
        }
    }

    public void onDataError() {
    }

    public void onLoadRafSenderVoucherLabel() {
        this.isideMenuInteractor.loadRafSenderVoucherLabel();
    }

    public void onLoadTalabatCreditBalance() {
        this.isideMenuInteractor.loadTalabatCreditBalance();
    }

    public void onLoadUserActiveVouchersCount() {
        this.isideMenuInteractor.loadUserActiveVoucherCount();
    }

    public void onNetworkError() {
    }

    public void onRedirectToLiveChat() {
        this.sideMenuView.stopLodingPopup();
        this.sideMenuView.onSideMenuNavigation(ScreenNames.LIVE_SUPPORT);
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onSidemenuItemClicked(String str) {
        String str2 = ScreenNames.VOUCHERS_LIST;
        if (!str.equals(str2)) {
            str2 = "rewards";
            if (!str.equals(str2)) {
                if (!str.equals("home")) {
                    if (str.equals("livesupport")) {
                        str2 = ScreenNames.LIVE_SUPPORT;
                    } else if (str.equals(FilterEngine.DEEPLINKFILER.OFFERS)) {
                        str2 = ScreenNames.PROMOTIONS;
                    } else if (str.equals("cart")) {
                        str2 = "Cart Screen";
                    } else if (!str.equals("birthday")) {
                        if (str.equals("notifications")) {
                            str2 = ScreenNames.NOTIFICATIONS;
                        } else if (!str.equals("campaign")) {
                            if (str.equals(AppUrls.PLACEORDER_SEGMENT) || str.equals("rateorder")) {
                                str2 = ScreenNames.ORDERS_LIST;
                            } else if (str.equals("settings")) {
                                str2 = ScreenNames.SETTINGS_SCREEN;
                            } else if (str.equals("myaddress")) {
                                str2 = ScreenNames.ADDRESS_LIST;
                            } else if (str.equals("logout")) {
                                str2 = ScreenNames.LOGOUT;
                            } else if (str.equals("talabatcredit")) {
                                str2 = ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT;
                            } else if (str.equals("Subscriptions")) {
                                str2 = ScreenNames.WALLET_SUBSCRIPTION_SETTINGS;
                            } else if (!str.equals("purchasecredit") && !str.equals("creditstatement") && !str.equals("purchasevoucher") && !str.equals(AccessToken.DEFAULT_GRAPH_DOMAIN) && !str.equals("twitter") && !str.equals(FacebookSdk.INSTAGRAM)) {
                                str2 = "share";
                                if (!str.equals(str2)) {
                                    if (!str.equals(UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH) && !str.equals("coupon") && !str.equals("redemption") && !str.equals(NotificationCompat.CATEGORY_SOCIAL)) {
                                        if (str.equals("quickfind")) {
                                            str2 = ScreenNames.QUICKFINDRESTAURANTS;
                                        } else if (str.equals("accountinfo")) {
                                            str2 = ScreenNames.ACCOUNT_INFO;
                                        } else if (str.equals("about")) {
                                            str2 = ScreenNames.ABOUT_SCREEN;
                                        } else if (str.equals("link")) {
                                            str2 = ScreenNames.TALABATWEBVIEW;
                                        } else if (str.equals("paylater")) {
                                            str2 = ScreenNames.PAY_LATER_DASHBOARD;
                                        } else if (str.equals(SideMenuResource.REF_REFER_A_FRIEND)) {
                                            str2 = ScreenNames.REFER_A_FRIEND_SENDER_SCREEN;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                str2 = "Home Screen";
            }
        }
        this.sideMenuView.onSideMenuNavigation(str2);
    }

    public void onSidemenuLinkClicked(String str, String str2) {
        this.sideMenuView.onSideMenuLinkNavigation(str, str2);
    }

    public void onTalabatCreditBalError() {
        this.sideMenuView.onCreditBalanceRefresh();
    }

    public void onUserActiveVouchersCountFail() {
        this.sideMenuView.updateVoucherCounter(new VoucherStateDomainModel(0, "", VoucherNotificationStyle.NONE));
    }

    public void onUserActiveVouchersCountReceived(@NotNull VoucherStateDomainModel voucherStateDomainModel) {
        this.sideMenuView.updateVoucherCounter(voucherStateDomainModel);
    }

    public void onUserRafSenderVoucherLabelReceived(@NonNull String str) {
        if (!str.isEmpty()) {
            this.sideMenuView.updateRafVoucherLabel(str);
        }
    }

    public void reloadBnplOverdue() {
        loadBnplOverdues();
    }

    public void setSideMenu() {
        this.sideMenuView.setSideMenu();
    }

    public void showBNPLOption() {
        this.sideMenuView.showBNPLOption();
    }

    public void updateLastOrderDetails(CustomerLastOrderDetailsRM customerLastOrderDetailsRM) {
        LastOrdersDetails[] lastOrdersDetailsArr;
        this.sideMenuView.startLodingPopup();
        if (customerLastOrderDetailsRM != null && (lastOrdersDetailsArr = customerLastOrderDetailsRM.lastOrdersDetails) != null && lastOrdersDetailsArr.length > 0) {
            Customer.getInstance().setLastOrdersDetails(customerLastOrderDetailsRM.lastOrdersDetails);
        }
    }

    public SideMenuPresenter(SideMenuView sideMenuView2, ConfigurationLocalRepository configurationLocalRepository, GetOverdueUseCase getOverdueUseCase, IObservabilityManager iObservabilityManager, Scheduler scheduler, Scheduler scheduler2, SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase, IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase, CoroutineScope coroutineScope) {
        this.sideMenuView = sideMenuView2;
        this.isideMenuInteractor = new SideMenuInteractor(this, new VoucherRepositoryImpl(new NetworkHandler(Integration.getAppContext()), new VouchersService(new TalabatAPIBuilder())), scheduler, scheduler2, configurationLocalRepository, getOverdueUseCase, iObservabilityManager, sendNavigationOptionLoadedEventUseCase, isUserBNPLEligibleUseCase, coroutineScope);
        if (GlobalDataModel.JSON.sideMenuSection == null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String loadJSONFromAsset = loadJSONFromAsset(sideMenuView2.getContext());
            Class cls = JMenuSection[].class;
            GlobalDataModel.JSON.sideMenuSection = (JMenuSection[]) (!(gson instanceof Gson) ? gson.fromJson(loadJSONFromAsset, cls) : GsonInstrumentation.fromJson(gson, loadJSONFromAsset, cls));
        }
    }
}
