package com.talabat.card_tokenization.datasource;

import android.content.Context;
import com.checkout.api.CheckoutApiService;
import com.checkout.base.model.Environment;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Card;
import com.checkout.tokenization.model.CardTokenRequest;
import com.checkout.tokenization.model.ExpiryDate;
import com.checkout.tokenization.model.Phone;
import com.talabat.card_tokenization.mapper.NonEnglishNumbersMapper;
import com.talabat.card_tokenization.provider.CheckoutApiClientProvider;
import com.talabat.card_tokenization.request.RemoteTokenizationRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/card_tokenization/datasource/CheckoutTokenizationDataSource;", "", "context", "Landroid/content/Context;", "checkoutApiClientProvider", "Lcom/talabat/card_tokenization/provider/CheckoutApiClientProvider;", "nonEnglishNumbersMapper", "Lcom/talabat/card_tokenization/mapper/NonEnglishNumbersMapper;", "(Landroid/content/Context;Lcom/talabat/card_tokenization/provider/CheckoutApiClientProvider;Lcom/talabat/card_tokenization/mapper/NonEnglishNumbersMapper;)V", "createCard", "Lcom/checkout/tokenization/model/Card;", "tokenizationRequest", "Lcom/talabat/card_tokenization/request/RemoteTokenizationRequest;", "createCheckoutService", "Lcom/checkout/api/CheckoutApiService;", "generateToken", "", "(Lcom/talabat/card_tokenization/request/RemoteTokenizationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnvironment", "Lcom/checkout/base/model/Environment;", "env", "card_tokenization_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckoutTokenizationDataSource {
    @NotNull
    private final CheckoutApiClientProvider checkoutApiClientProvider;
    @NotNull
    private final Context context;
    @NotNull
    private final NonEnglishNumbersMapper nonEnglishNumbersMapper;

    public CheckoutTokenizationDataSource(@NotNull Context context2, @NotNull CheckoutApiClientProvider checkoutApiClientProvider2, @NotNull NonEnglishNumbersMapper nonEnglishNumbersMapper2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(checkoutApiClientProvider2, "checkoutApiClientProvider");
        Intrinsics.checkNotNullParameter(nonEnglishNumbersMapper2, "nonEnglishNumbersMapper");
        this.context = context2;
        this.checkoutApiClientProvider = checkoutApiClientProvider2;
        this.nonEnglishNumbersMapper = nonEnglishNumbersMapper2;
    }

    /* access modifiers changed from: private */
    public final Card createCard(RemoteTokenizationRequest remoteTokenizationRequest) {
        String map = this.nonEnglishNumbersMapper.map(remoteTokenizationRequest.getCardNumber());
        String map2 = this.nonEnglishNumbersMapper.map(remoteTokenizationRequest.getCardCvv());
        return new Card(new ExpiryDate(Integer.parseInt(this.nonEnglishNumbersMapper.map(remoteTokenizationRequest.getCardExpiryMonth())), Integer.parseInt(this.nonEnglishNumbersMapper.map(remoteTokenizationRequest.getCardExpiryYear()))), remoteTokenizationRequest.getCardHolderName(), map, map2, (Address) null, (Phone) null, 48, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final CheckoutApiService createCheckoutService(RemoteTokenizationRequest remoteTokenizationRequest) {
        return this.checkoutApiClientProvider.provide(remoteTokenizationRequest.getPublicKey(), getEnvironment(remoteTokenizationRequest.getEnv()), this.context);
    }

    private final Environment getEnvironment(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "prod")) {
            return Environment.PRODUCTION;
        }
        return Environment.SANDBOX;
    }

    @Nullable
    public final Object generateToken(@NotNull RemoteTokenizationRequest remoteTokenizationRequest, @NotNull Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        createCheckoutService(remoteTokenizationRequest).createToken(new CardTokenRequest(createCard(remoteTokenizationRequest), new CheckoutTokenizationDataSource$generateToken$2$request$1(cancellableContinuationImpl), new CheckoutTokenizationDataSource$generateToken$2$request$2(cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
