package com.talabat.wallet.screens.walletAddCard.interactor;

import JsonModels.Request.WalletCardTokenRequest;
import JsonModels.Response.WalletSaveCreditCardResponse;
import androidx.webkit.ProxyConfig;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutCard;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletAddCard.WalletAddCardListener;
import datamodels.WalletCreditCard;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;
import vx.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/interactor/WalletAddCreditCardInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletAddCard/interactor/IWalletAddCreditCardInteractor;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "subscribeOn", "Lio/reactivex/Scheduler;", "observeOn", "walletAddCardListener", "Lcom/talabat/wallet/screens/walletAddCard/WalletAddCardListener;", "(Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/wallet/screens/walletAddCard/WalletAddCardListener;)V", "postCard", "", "walletCreditCard", "Ldatamodels/WalletCreditCard;", "token", "", "countryId", "language", "postCreditCardToCheckout", "saveCreditCard", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletSaveCreditCardResponse;", "walletCardTokenRequest", "LJsonModels/Request/WalletCardTokenRequest;", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardInteractor implements IGlobalInteractor, IWalletAddCreditCardInteractor {
    /* access modifiers changed from: private */
    @NotNull
    public final GenerateCardTokenUseCase generateCardTokenUseCase;
    @NotNull
    private final Scheduler observeOn;
    @NotNull
    private final Scheduler subscribeOn;
    /* access modifiers changed from: private */
    @Nullable
    public WalletAddCardListener walletAddCardListener;

    public WalletAddCreditCardInteractor(@NotNull GenerateCardTokenUseCase generateCardTokenUseCase2, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull WalletAddCardListener walletAddCardListener2) {
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "generateCardTokenUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "subscribeOn");
        Intrinsics.checkNotNullParameter(scheduler2, "observeOn");
        Intrinsics.checkNotNullParameter(walletAddCardListener2, "walletAddCardListener");
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
        this.subscribeOn = scheduler;
        this.observeOn = scheduler2;
        this.walletAddCardListener = walletAddCardListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: postCreditCardToCheckout$lambda-1  reason: not valid java name */
    public static final void m5957postCreditCardToCheckout$lambda1(WalletAddCreditCardInteractor walletAddCreditCardInteractor, WalletCreditCard walletCreditCard, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardInteractor, "this$0");
        Intrinsics.checkNotNullParameter(walletCreditCard, "$walletCreditCard");
        Intrinsics.checkNotNullParameter(observableEmitter, "it");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1(walletAddCreditCardInteractor, walletCreditCard, observableEmitter, (Continuation<? super WalletAddCreditCardInteractor$postCreditCardToCheckout$1$1>) null), 1, (Object) null);
    }

    private final Observable<WalletSaveCreditCardResponse> saveCreditCard(WalletCardTokenRequest walletCardTokenRequest) {
        return ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).saveCreditCard(WalletApiUrls.Companion.getWALLET_ADD_CARD_URL(), walletCardTokenRequest);
    }

    public void postCard(@NotNull WalletCreditCard walletCreditCard, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(walletCreditCard, "walletCreditCard");
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.ADJUST_LANGUAGE);
        saveCreditCard(new WalletCardTokenRequest(str, str2, str3, walletCreditCard.getBinNumber())).subscribeOn(this.subscribeOn).observeOn(this.observeOn).subscribe(new WalletAddCreditCardInteractor$postCard$1(this, walletCreditCard, ProxyConfig.MATCH_HTTP));
    }

    public void postCreditCardToCheckout(@NotNull WalletCreditCard walletCreditCard, @NotNull String str, @NotNull String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(walletCreditCard, "walletCreditCard");
        Intrinsics.checkNotNullParameter(str, "countryId");
        Intrinsics.checkNotNullParameter(str2, ConstantsKt.ADJUST_LANGUAGE);
        String cardNumber = walletCreditCard.getCardNumber();
        if (cardNumber == null) {
            str3 = "";
        } else {
            str3 = cardNumber;
        }
        String holderName = walletCreditCard.getHolderName();
        if (holderName == null) {
            str4 = "";
        } else {
            str4 = holderName;
        }
        String month = walletCreditCard.getMonth();
        if (month == null) {
            str5 = "";
        } else {
            str5 = month;
        }
        String year = walletCreditCard.getYear();
        if (year == null) {
            str6 = "";
        } else {
            str6 = year;
        }
        String code = walletCreditCard.getCode();
        if (code == null) {
            str7 = "";
        } else {
            str7 = code;
        }
        new CheckoutCard(str3, str4, str5, str6, str7);
        Observable.create(new a(this, walletCreditCard)).subscribeOn(this.subscribeOn).observeOn(this.observeOn).subscribe(new WalletAddCreditCardInteractor$postCreditCardToCheckout$2(this, walletCreditCard, ProxyConfig.MATCH_HTTP));
    }

    public void unregister() {
        this.walletAddCardListener = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletAddCreditCardInteractor(com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase r1, io.reactivex.Scheduler r2, io.reactivex.Scheduler r3, com.talabat.wallet.screens.walletAddCard.WalletAddCardListener r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000d
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r6 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
        L_0x000d:
            r5 = r5 & 4
            if (r5 == 0) goto L_0x001a
            io.reactivex.Scheduler r3 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r5 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
        L_0x001a:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletAddCard.interactor.WalletAddCreditCardInteractor.<init>(com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.wallet.screens.walletAddCard.WalletAddCardListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
