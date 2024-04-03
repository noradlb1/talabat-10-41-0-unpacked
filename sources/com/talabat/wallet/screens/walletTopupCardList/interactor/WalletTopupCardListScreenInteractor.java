package com.talabat.wallet.screens.walletTopupCardList.interactor;

import JsonModels.Response.WalletCashbackCampaignOfferMessageResponse;
import JsonModels.Response.WalletCashbackCampaignOfferMessageResponseResult;
import JsonModels.Response.WalletCashbackCampaignResponse;
import JsonModels.Response.WalletCashbackCampaignResponseResult;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import JsonModels.Response.WalletCreditCardGetListResponse;
import JsonModels.Response.WalletErrorMessageModel;
import androidx.webkit.ProxyConfig;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletTopupCardList.WalletTopupCardListListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import jy.a;
import jy.b;
import jy.c;
import jy.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\rH\u0002J+\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001cJ/\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r0\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u0017H\u0016J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u001e\u0010'\u001a\u0004\u0018\u00010\u00122\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010*\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/interactor/WalletTopupCardListScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletTopupCardList/interactor/IWalletTopupCardListScreenInteractor;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "walletTopupCardListListener", "Lcom/talabat/wallet/screens/walletTopupCardList/WalletTopupCardListListener;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/wallet/screens/walletTopupCardList/WalletTopupCardListListener;)V", "serverErrorSubstring", "", "getServerErrorSubstring", "()Ljava/lang/String;", "combineCampaignResults", "", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "campaignResponse", "LJsonModels/Response/WalletCashbackCampaignResponse;", "list", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "getAllApiDataForBankPartnership", "", "countryId", "paymentProvider", "", "eventId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAllCashBackCampaigns", "Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "getAllWalletCredit", "(Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "getAllWalletCreditCards", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCashBackCampaignPerCard", "card", "position", "orderCreditCards", "walletCreditCardGetListResponse", "LJsonModels/Response/WalletCreditCardGetListResponse;", "setCampaignObject", "campaignObject", "LJsonModels/Response/WalletCashbackCampaignOfferMessageResponse;", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreenInteractor implements IGlobalInteractor, IWalletTopupCardListScreenInteractor {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final String serverErrorSubstring = ProxyConfig.MATCH_HTTP;
    /* access modifiers changed from: private */
    @Nullable
    public WalletTopupCardListListener walletTopupCardListListener;

    public WalletTopupCardListScreenInteractor(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull WalletTopupCardListListener walletTopupCardListListener2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(walletTopupCardListListener2, "walletTopupCardListListener");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.walletTopupCardListListener = walletTopupCardListListener2;
    }

    private final List<WalletCreditCardGetListDataItem> combineCampaignResults(WalletCashbackCampaignResponse walletCashbackCampaignResponse, List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list) {
        WalletCashbackCampaignResponseResult result;
        List<WalletCreditCardGetListDataItem.WalletCashbackCampaign> result2;
        ArrayList arrayList = new ArrayList();
        if (!(walletCashbackCampaignResponse == null || (result = walletCashbackCampaignResponse.getResult()) == null || (result2 = result.getResult()) == null)) {
            for (WalletCreditCardGetListDataItem.WalletCashbackCampaign add : result2) {
                arrayList.add(add);
            }
        }
        for (WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult : list) {
            if (walletCreditCardGetListResponseResult != null) {
                arrayList.add(walletCreditCardGetListResponseResult);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllApiDataForBankPartnership$lambda-2  reason: not valid java name */
    public static final List m6002getAllApiDataForBankPartnership$lambda2(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, WalletCashbackCampaignResponse walletCashbackCampaignResponse, List list) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletCashbackCampaignResponse, "t1");
        Intrinsics.checkNotNullParameter(list, "t2");
        return walletTopupCardListScreenInteractor.combineCampaignResults(walletCashbackCampaignResponse, list);
    }

    private final Observable<List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult>> getAllWalletCredit(Integer num, String str) {
        Observable<R> map = ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchAllWalletCreditCards(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_CREDIT_GET_ALL_CARDS_URL(), new String[]{"{countryCode}", str, "{paymentProvider}", String.valueOf(num)})).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "service.fetchAllWalletCr…taModel\n                }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllWalletCredit$lambda-1  reason: not valid java name */
    public static final List m6003getAllWalletCredit$lambda1(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponse, "t");
        return walletTopupCardListScreenInteractor.orderCreditCards(walletCreditCardGetListResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllWalletCreditCards$lambda-0  reason: not valid java name */
    public static final List m6004getAllWalletCreditCards$lambda0(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponse, "t");
        return walletTopupCardListScreenInteractor.orderCreditCards(walletCreditCardGetListResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCashBackCampaignPerCard$lambda-6  reason: not valid java name */
    public static final WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult m6005getCashBackCampaignPerCard$lambda6(WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor, WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse) {
        Intrinsics.checkNotNullParameter(walletTopupCardListScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletCashbackCampaignOfferMessageResponse, "t");
        return walletTopupCardListScreenInteractor.setCampaignObject(walletCashbackCampaignOfferMessageResponse, walletCreditCardGetListResponseResult);
    }

    private final List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> orderCreditCards(WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
        List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> result;
        ArrayList arrayList = new ArrayList();
        if (!(walletCreditCardGetListResponse == null || (result = walletCreditCardGetListResponse.getResult()) == null)) {
            for (WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult : result) {
                if (walletCreditCardGetListResponseResult.isCardDefault() != null) {
                    Boolean isCardDefault = walletCreditCardGetListResponseResult.isCardDefault();
                    Intrinsics.checkNotNull(isCardDefault);
                    if (isCardDefault.booleanValue()) {
                        arrayList.add(0, walletCreditCardGetListResponseResult);
                    }
                }
                if (walletCreditCardGetListResponseResult.isCardDefault() != null) {
                    arrayList.add(walletCreditCardGetListResponseResult);
                }
            }
        }
        return arrayList;
    }

    private final WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult setCampaignObject(WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse, WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
        String str;
        WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse2;
        WalletCashbackCampaignOfferMessageResponseResult result;
        WalletCashbackCampaignOfferMessageResponseResult walletCashbackCampaignOfferMessageResponseResult = null;
        if (walletCashbackCampaignOfferMessageResponse == null || (result = walletCashbackCampaignOfferMessageResponse.getResult()) == null) {
            str = null;
        } else {
            str = result.getAdTextMessage();
        }
        if (str == null) {
            if (!(walletCreditCardGetListResponseResult == null || (walletCashbackCampaignOfferMessageResponse2 = walletCreditCardGetListResponseResult.getWalletCashbackCampaignOfferMessageResponse()) == null)) {
                walletCashbackCampaignOfferMessageResponseResult = walletCashbackCampaignOfferMessageResponse2.getResult();
            }
            if (walletCashbackCampaignOfferMessageResponseResult != null) {
                walletCashbackCampaignOfferMessageResponseResult.setAdTextMessage("");
            }
        } else if (walletCreditCardGetListResponseResult != null) {
            walletCreditCardGetListResponseResult.setWalletCashbackCampaignOfferMessageResponse(walletCashbackCampaignOfferMessageResponse);
        }
        return walletCreditCardGetListResponseResult;
    }

    public void getAllApiDataForBankPartnership(@Nullable String str, @Nullable Integer num, @Nullable Integer num2) {
        Observable.zip(getAllCashBackCampaigns(str, num2), getAllWalletCredit(num, str), new a(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopupCardListScreenInteractor$getAllApiDataForBankPartnership$2(this));
    }

    @Nullable
    public Observable<WalletCashbackCampaignResponse> getAllCashBackCampaigns(@Nullable String str, @Nullable Integer num) {
        return Observable.just(new WalletCashbackCampaignResponse((WalletCashbackCampaignResponseResult) null, (List<WalletErrorMessageModel>) null));
    }

    public void getAllWalletCreditCards(@Nullable Integer num, @Nullable Integer num2) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchAllWalletCreditCards(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_CREDIT_GET_ALL_CARDS_URL(), new String[]{"{countryCode}", String.valueOf(num2), "{paymentProvider}", String.valueOf(num)})).map(new d(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopupCardListScreenInteractor$getAllWalletCreditCards$2(this));
    }

    public void getCashBackCampaignPerCard(@Nullable String str, @Nullable WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11) {
        String str2;
        WalletApiService walletApiService = (WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class);
        String wallet_cashback_campaign_offer_per_card = WalletApiUrls.Companion.getWALLET_CASHBACK_CAMPAIGN_OFFER_PER_CARD();
        String[] strArr = new String[4];
        strArr[0] = "{countryId}";
        strArr[1] = String.valueOf(str);
        strArr[2] = "{binNumber}";
        if (walletCreditCardGetListResponseResult != null) {
            str2 = walletCreditCardGetListResponseResult.getBinNumber();
        } else {
            str2 = null;
        }
        strArr[3] = String.valueOf(str2);
        walletApiService.getCashBackCampaignsForCard(CreateApiUrl.createWithParameters(wallet_cashback_campaign_offer_per_card, strArr), this.configurationLocalRepository.selectedCountry().getCountryId()).map(new c(this, walletCreditCardGetListResponseResult)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopupCardListScreenInteractor$getCashBackCampaignPerCard$2(this, i11));
    }

    @NotNull
    public final String getServerErrorSubstring() {
        return this.serverErrorSubstring;
    }

    public void unregister() {
        this.walletTopupCardListListener = null;
    }
}
