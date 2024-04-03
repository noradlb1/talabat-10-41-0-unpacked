package com.talabat.wallet.screens.walletManageCard.interactor;

import JsonModels.Request.WalletDeleteCreditCardRequest;
import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletCreditCardGetListResponse;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import androidx.webkit.ProxyConfig;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletManageCard.WalletManageCreditCardListener;
import dy.a;
import dy.b;
import dy.c;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J1\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/interactor/WalletManageCreditCardsScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletManageCard/interactor/IWalletDisplayAllCreditCardsScreenInteractor;", "walletManageCreditCardListener", "Lcom/talabat/wallet/screens/walletManageCard/WalletManageCreditCardListener;", "(Lcom/talabat/wallet/screens/walletManageCard/WalletManageCreditCardListener;)V", "deleteCards", "", "cardIds", "", "LJsonModels/Request/WalletDeleteCreditCardRequest;", "deleteEachCard", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "cardInfo", "getAllWalletCreditCards", "paymentProvider", "", "countryId", "primaryCardLabel", "", "otherCardLabel", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "mapDataResponseToAdapterDataItem", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "walletCreditCardGetListResponse", "LJsonModels/Response/WalletCreditCardGetListResponse;", "setDefaultCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletManageCreditCardsScreenInteractor implements IGlobalInteractor, IWalletDisplayAllCreditCardsScreenInteractor {
    /* access modifiers changed from: private */
    @Nullable
    public WalletManageCreditCardListener walletManageCreditCardListener;

    public WalletManageCreditCardsScreenInteractor(@NotNull WalletManageCreditCardListener walletManageCreditCardListener2) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardListener2, "walletManageCreditCardListener");
        this.walletManageCreditCardListener = walletManageCreditCardListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteCards$lambda-1  reason: not valid java name */
    public static final Iterable m5979deleteCards$lambda1(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "$cardIds");
        Intrinsics.checkNotNullParameter(list2, "it");
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteCards$lambda-2  reason: not valid java name */
    public static final ObservableSource m5980deleteCards$lambda2(WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor, WalletDeleteCreditCardRequest walletDeleteCreditCardRequest) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletDeleteCreditCardRequest, "t");
        return walletManageCreditCardsScreenInteractor.deleteEachCard(walletDeleteCreditCardRequest);
    }

    private final Observable<WalletDeleteCreditCardsResponse> deleteEachCard(WalletDeleteCreditCardRequest walletDeleteCreditCardRequest) {
        return ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchResponseOfDeleteRequest(WalletApiUrls.Companion.getWALLET_DELETE_CREDIT_CARD_URL(), walletDeleteCreditCardRequest);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllWalletCreditCards$lambda-0  reason: not valid java name */
    public static final WalletCreditCardGetListDataModel m5981getAllWalletCreditCards$lambda0(WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor, String str, String str2, WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreenInteractor, "this$0");
        Intrinsics.checkNotNullParameter(str, "$primaryCardLabel");
        Intrinsics.checkNotNullParameter(str2, "$otherCardLabel");
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponse, "t");
        return walletManageCreditCardsScreenInteractor.mapDataResponseToAdapterDataItem(walletCreditCardGetListResponse, str, str2);
    }

    public final void deleteCards(@NotNull List<WalletDeleteCreditCardRequest> list) {
        Intrinsics.checkNotNullParameter(list, "cardIds");
        Observable.fromArray(list).flatMapIterable(new b(list)).flatMap(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletManageCreditCardsScreenInteractor$deleteCards$3(this, ProxyConfig.MATCH_HTTP));
    }

    public void getAllWalletCreditCards(@Nullable Integer num, @Nullable Integer num2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "primaryCardLabel");
        Intrinsics.checkNotNullParameter(str2, "otherCardLabel");
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchAllWalletCreditCards(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_CREDIT_GET_ALL_CARDS_URL(), new String[]{"{countryCode}", String.valueOf(num2), "{paymentProvider}", String.valueOf(num)})).map(new a(this, str, str2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletManageCreditCardsScreenInteractor$getAllWalletCreditCards$2(this, ProxyConfig.MATCH_HTTP));
    }

    @NotNull
    public WalletCreditCardGetListDataModel mapDataResponseToAdapterDataItem(@Nullable WalletCreditCardGetListResponse walletCreditCardGetListResponse, @NotNull String str, @NotNull String str2) {
        List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> result;
        Intrinsics.checkNotNullParameter(str, "primaryCardLabel");
        Intrinsics.checkNotNullParameter(str2, "otherCardLabel");
        ArrayList arrayList = new ArrayList();
        if (!(walletCreditCardGetListResponse == null || (result = walletCreditCardGetListResponse.getResult()) == null)) {
            boolean z11 = false;
            for (WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult : result) {
                if (!z11 && walletCreditCardGetListResponseResult.isCardDefault() != null) {
                    Boolean isCardDefault = walletCreditCardGetListResponseResult.isCardDefault();
                    Intrinsics.checkNotNull(isCardDefault);
                    if (isCardDefault.booleanValue()) {
                        arrayList.add(0, new WalletCreditCardGetListDataItem.Header(str));
                        arrayList.add(1, walletCreditCardGetListResponseResult);
                        z11 = true;
                    }
                }
                if (walletCreditCardGetListResponseResult.isCardDefault() != null) {
                    arrayList.add(walletCreditCardGetListResponseResult);
                }
            }
            if (z11) {
                if (arrayList.size() > 2) {
                    arrayList.add(2, new WalletCreditCardGetListDataItem.Header(str2));
                }
            } else if (!result.isEmpty()) {
                arrayList.add(0, new WalletCreditCardGetListDataItem.Header(str));
                arrayList.add(1, new WalletCreditCardGetListDataItem.CardPlaceHolderView((String) null, 1, (DefaultConstructorMarker) null));
                arrayList.add(2, new WalletCreditCardGetListDataItem.Header(str2));
            }
        }
        return new WalletCreditCardGetListDataModel(arrayList);
    }

    public void setDefaultCard(@NotNull WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest) {
        Intrinsics.checkNotNullParameter(walletSetDefaultCreditCardRequest, "walletSetDefaultCreditCardRequest");
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchSetDefaultCreditCard(WalletApiUrls.Companion.getWALLET_SET_DEFAULT_CARD_URL(), walletSetDefaultCreditCardRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletManageCreditCardsScreenInteractor$setDefaultCard$1(this, ProxyConfig.MATCH_HTTP));
    }

    public void unregister() {
        this.walletManageCreditCardListener = null;
    }
}
