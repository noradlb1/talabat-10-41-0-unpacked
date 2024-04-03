package com.talabat.wallet.screens.walletTopUp.presenter;

import JsonModels.Request.WalletCalculateCashBackRequest;
import JsonModels.Request.WalletTopUpRequest;
import JsonModels.Response.WalletCalculateCashBackResponse;
import JsonModels.Response.WalletCalculateCashBackResult;
import JsonModels.Response.WalletTopUpAmountSuggestion;
import JsonModels.Response.WalletTopUpAmountSuggestionResponse;
import JsonModels.Response.WalletTopUpAmountSuggestionResultModel;
import JsonModels.Response.WalletTopUpResponse;
import JsonModels.Response.WalletTopUpResponseResult;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.screens.walletTopUp.WalletTopUpListener;
import com.talabat.wallet.screens.walletTopUp.interactor.WalletTopUpScreenInteractor;
import com.talabat.wallet.screens.walletTopUp.view.WalletTopUpView;
import datamodels.Country;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ+\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010#\u001a\u00020\rH\u0016J7\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010*R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/presenter/WalletTopUpPresenter;", "Lcom/talabat/wallet/screens/walletTopUp/WalletTopUpListener;", "Lcom/talabat/wallet/screens/walletTopUp/presenter/IWalletTopUpPresenter;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletTopUpView", "Lcom/talabat/wallet/screens/walletTopUp/view/WalletTopUpView;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletTopUp/view/WalletTopUpView;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "walletTopUpScreenInteractor", "Lcom/talabat/wallet/screens/walletTopUp/interactor/WalletTopUpScreenInteractor;", "getWalletCalculatedCashBack", "", "editTextValue", "", "eventType", "", "binNumber", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onDestroy", "onGetAllWalletTopUpAmountSuggestionError", "onNetworkError", "onServerError", "onTopUpServerError", "onWalletAllCreditCardsReceived", "walletTopUpAmountSuggestionResponse", "LJsonModels/Response/WalletTopUpAmountSuggestionResponse;", "onWalletCalculateCashBackReceived", "walletCalculateCashBackResponse", "LJsonModels/Response/WalletCalculateCashBackResponse;", "onWalletTopUpReceived", "walletTopUpResponse", "LJsonModels/Response/WalletTopUpResponse;", "sendErrorMessage", "setWalletAmountTopUp", "submitWalletTopUpRequest", "tokenId", "card4Digits", "cardType", "amount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpPresenter implements WalletTopUpListener, IWalletTopUpPresenter {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTopUpScreenInteractor walletTopUpScreenInteractor;
    @Nullable
    private WalletTopUpView walletTopUpView;

    public WalletTopUpPresenter(@NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletTopUpView walletTopUpView2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletTopUpView2, "walletTopUpView");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.walletTopUpScreenInteractor = new WalletTopUpScreenInteractor(configurationLocalRepository2, this);
        this.walletTopUpView = walletTopUpView2;
    }

    private final void sendErrorMessage(WalletTopUpResponse walletTopUpResponse) {
        String str;
        WalletTopUpResponseResult result = walletTopUpResponse.getResult();
        String str2 = null;
        if (result != null) {
            str = result.getMessage();
        } else {
            str = null;
        }
        if (str != null) {
            WalletTopUpView walletTopUpView2 = this.walletTopUpView;
            if (walletTopUpView2 != null) {
                WalletTopUpResponseResult result2 = walletTopUpResponse.getResult();
                if (result2 != null) {
                    str2 = result2.getMessage();
                }
                Intrinsics.checkNotNull(str2);
                walletTopUpView2.onTopUpFailure(str2);
            }
        } else if (walletTopUpResponse.getResponseMessages() != null) {
            WalletTopUpView walletTopUpView3 = this.walletTopUpView;
            if (walletTopUpView3 != null) {
                String responseMessages = walletTopUpResponse.getResponseMessages();
                Intrinsics.checkNotNull(responseMessages);
                walletTopUpView3.onTopUpFailure(responseMessages);
            }
        } else {
            WalletTopUpView walletTopUpView4 = this.walletTopUpView;
            if (walletTopUpView4 != null) {
                walletTopUpView4.onTopUpFailure("");
            }
        }
    }

    public void getWalletCalculatedCashBack(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
        boolean z11;
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && num2 != null && selectedCountry != null) {
                WalletCalculateCashBackRequest walletCalculateCashBackRequest = new WalletCalculateCashBackRequest(Float.valueOf(0.0f), num, Integer.valueOf(selectedCountry.f13845id), num2);
                WalletTopUpView walletTopUpView2 = this.walletTopUpView;
                if (walletTopUpView2 != null) {
                    walletTopUpView2.setUpTopupLoader();
                }
                WalletTopUpScreenInteractor walletTopUpScreenInteractor2 = this.walletTopUpScreenInteractor;
                if (walletTopUpScreenInteractor2 != null) {
                    walletTopUpScreenInteractor2.getCalculatedCashBack(walletCalculateCashBackRequest);
                }
            } else if (selectedCountry != null && num2 != null && str != null) {
                WalletTopUpView walletTopUpView3 = this.walletTopUpView;
                if (walletTopUpView3 != null) {
                    walletTopUpView3.setUpTopupLoader();
                }
                WalletCalculateCashBackRequest walletCalculateCashBackRequest2 = new WalletCalculateCashBackRequest(Float.valueOf(Float.parseFloat(str)), num, Integer.valueOf(selectedCountry.f13845id), num2);
                WalletTopUpScreenInteractor walletTopUpScreenInteractor3 = this.walletTopUpScreenInteractor;
                if (walletTopUpScreenInteractor3 != null) {
                    walletTopUpScreenInteractor3.getCalculatedCashBack(walletCalculateCashBackRequest2);
                }
            }
        }
    }

    public void onDestroy() {
        this.walletTopUpScreenInteractor = null;
        this.walletTopUpView = null;
    }

    public void onGetAllWalletTopUpAmountSuggestionError() {
        WalletTopUpView walletTopUpView2 = this.walletTopUpView;
        if (walletTopUpView2 != null) {
            walletTopUpView2.onTopUpSuggestionError();
        }
    }

    public void onNetworkError() {
        WalletTopUpView walletTopUpView2 = this.walletTopUpView;
        if (walletTopUpView2 != null) {
            walletTopUpView2.onNetworkError();
        }
    }

    public void onServerError() {
        WalletTopUpView walletTopUpView2 = this.walletTopUpView;
        if (walletTopUpView2 != null) {
            walletTopUpView2.onServerError();
        }
    }

    public void onTopUpServerError() {
        WalletTopUpView walletTopUpView2 = this.walletTopUpView;
        if (walletTopUpView2 != null) {
            walletTopUpView2.onTopUpServerError();
        }
    }

    public void onWalletAllCreditCardsReceived(@Nullable WalletTopUpAmountSuggestionResponse walletTopUpAmountSuggestionResponse) {
        List<WalletTopUpAmountSuggestion> list;
        List<WalletTopUpAmountSuggestion> list2;
        WalletTopUpAmountSuggestionResultModel result;
        WalletTopUpAmountSuggestionResultModel result2;
        WalletTopUpAmountSuggestionResultModel result3;
        List<WalletTopUpAmountSuggestion> list3 = null;
        if (walletTopUpAmountSuggestionResponse == null || (result3 = walletTopUpAmountSuggestionResponse.getResult()) == null) {
            list = null;
        } else {
            list = result3.getTopUpAmountSuggestions();
        }
        if (list != null) {
            if (walletTopUpAmountSuggestionResponse == null || (result2 = walletTopUpAmountSuggestionResponse.getResult()) == null) {
                list2 = null;
            } else {
                list2 = result2.getTopUpAmountSuggestions();
            }
            Intrinsics.checkNotNull(list2);
            if (!list2.isEmpty()) {
                WalletTopUpView walletTopUpView2 = this.walletTopUpView;
                if (walletTopUpView2 != null) {
                    if (!(walletTopUpAmountSuggestionResponse == null || (result = walletTopUpAmountSuggestionResponse.getResult()) == null)) {
                        list3 = result.getTopUpAmountSuggestions();
                    }
                    Intrinsics.checkNotNull(list3);
                    walletTopUpView2.setWalletTopUpAmountSuggestion(list3);
                    return;
                }
                return;
            }
        }
        WalletTopUpView walletTopUpView3 = this.walletTopUpView;
        if (walletTopUpView3 != null) {
            walletTopUpView3.setEmptyWalletTopUpSuggestion();
        }
    }

    public void onWalletCalculateCashBackReceived(@Nullable WalletCalculateCashBackResponse walletCalculateCashBackResponse) {
        Float f11;
        WalletTopUpView walletTopUpView2;
        WalletCalculateCashBackResult result;
        WalletCalculateCashBackResult walletCalculateCashBackResult = null;
        if (walletCalculateCashBackResponse == null || (result = walletCalculateCashBackResponse.getResult()) == null) {
            f11 = null;
        } else {
            f11 = result.getAmount();
        }
        if (f11 != null && (walletTopUpView2 = this.walletTopUpView) != null) {
            if (walletCalculateCashBackResponse != null) {
                walletCalculateCashBackResult = walletCalculateCashBackResponse.getResult();
            }
            walletTopUpView2.setWalletCalculatedCashBack(walletCalculateCashBackResult);
        }
    }

    public void onWalletTopUpReceived(@NotNull WalletTopUpResponse walletTopUpResponse) {
        Integer num;
        boolean z11;
        Integer walletTransactionStatus;
        Integer walletTransactionStatus2;
        Intrinsics.checkNotNullParameter(walletTopUpResponse, "walletTopUpResponse");
        WalletTopUpResponseResult result = walletTopUpResponse.getResult();
        if (result != null) {
            num = result.getWalletTransactionStatus();
        } else {
            num = null;
        }
        if (num != null) {
            WalletTopUpResponseResult result2 = walletTopUpResponse.getResult();
            boolean z12 = true;
            if (result2 == null || (walletTransactionStatus2 = result2.getWalletTransactionStatus()) == null || walletTransactionStatus2.intValue() != 1) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                WalletTopUpView walletTopUpView2 = this.walletTopUpView;
                if (walletTopUpView2 != null) {
                    walletTopUpView2.onTopUpSuccess();
                    return;
                }
                return;
            }
            WalletTopUpResponseResult result3 = walletTopUpResponse.getResult();
            if (result3 == null || (walletTransactionStatus = result3.getWalletTransactionStatus()) == null || walletTransactionStatus.intValue() != 2) {
                z12 = false;
            }
            if (z12) {
                sendErrorMessage(walletTopUpResponse);
                return;
            }
            return;
        }
        sendErrorMessage(walletTopUpResponse);
    }

    public void setWalletAmountTopUp() {
        Integer num;
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTopUpView walletTopUpView2 = this.walletTopUpView;
            if (walletTopUpView2 != null) {
                walletTopUpView2.setupViewsBeforeServiceRequest();
            }
            WalletTopUpScreenInteractor walletTopUpScreenInteractor2 = this.walletTopUpScreenInteractor;
            if (walletTopUpScreenInteractor2 != null) {
                if (selectedCountry != null) {
                    num = Integer.valueOf(selectedCountry.f13845id);
                } else {
                    num = null;
                }
                walletTopUpScreenInteractor2.getAllWalletTopUpAmountSuggestion(String.valueOf(num));
            }
        }
    }

    public void submitWalletTopUpRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, float f11, @Nullable Integer num) {
        Country selectedCountry;
        Intrinsics.checkNotNullParameter(str, WalletNavigatorActions.EXTRA_TOKEN_ID);
        Intrinsics.checkNotNullParameter(str2, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        Intrinsics.checkNotNullParameter(str3, "cardType");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn() && (selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository)) != null && num != null) {
            WalletTopUpRequest walletTopUpRequest = new WalletTopUpRequest(Float.valueOf(f11), Integer.valueOf(selectedCountry.f13845id), str, str2, str3, num);
            WalletTopUpScreenInteractor walletTopUpScreenInteractor2 = this.walletTopUpScreenInteractor;
            if (walletTopUpScreenInteractor2 != null) {
                walletTopUpScreenInteractor2.getWalletTopUp(walletTopUpRequest);
            }
        }
    }
}
