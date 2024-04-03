package com.talabat.feature.tokenization.data;

import com.talabat.feature.tokenization.data.datasource.CheckoutTokenizationDataSource;
import com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource;
import com.talabat.feature.tokenization.data.datasource.request.RemoteTokenizationRequest;
import com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tokenization/data/TokenizationRepositoryImpl;", "Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "remoteDataSource", "Lcom/talabat/feature/tokenization/data/datasource/RemoteTokenizationDataSource;", "checkoutDataSource", "Lcom/talabat/feature/tokenization/data/datasource/CheckoutTokenizationDataSource;", "publicKeyMapper", "Lcom/talabat/feature/tokenization/data/mapper/TokenizationPublicKeyMapper;", "(Lcom/talabat/feature/tokenization/data/datasource/RemoteTokenizationDataSource;Lcom/talabat/feature/tokenization/data/datasource/CheckoutTokenizationDataSource;Lcom/talabat/feature/tokenization/data/mapper/TokenizationPublicKeyMapper;)V", "generateCardToken", "", "card", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;", "publicKey", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;", "(Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCheckoutPublicKey", "countryId", "", "binNumber", "verticalId", "(ILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizationRepositoryImpl implements TokenizationRepository {
    @NotNull
    private final CheckoutTokenizationDataSource checkoutDataSource;
    @NotNull
    private final TokenizationPublicKeyMapper publicKeyMapper;
    @NotNull
    private final RemoteTokenizationDataSource remoteDataSource;

    @Inject
    public TokenizationRepositoryImpl(@NotNull RemoteTokenizationDataSource remoteTokenizationDataSource, @NotNull CheckoutTokenizationDataSource checkoutTokenizationDataSource, @NotNull TokenizationPublicKeyMapper tokenizationPublicKeyMapper) {
        Intrinsics.checkNotNullParameter(remoteTokenizationDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(checkoutTokenizationDataSource, "checkoutDataSource");
        Intrinsics.checkNotNullParameter(tokenizationPublicKeyMapper, "publicKeyMapper");
        this.remoteDataSource = remoteTokenizationDataSource;
        this.checkoutDataSource = checkoutTokenizationDataSource;
        this.publicKeyMapper = tokenizationPublicKeyMapper;
    }

    @Nullable
    public Object generateCardToken(@NotNull TokenizationCard tokenizationCard, @NotNull TokenizationPublicKey tokenizationPublicKey, @NotNull Continuation<? super String> continuation) {
        return this.checkoutDataSource.generateToken(new RemoteTokenizationRequest(tokenizationCard.getCardNumber(), tokenizationCard.getCardHolderName(), tokenizationCard.getCardExpiryMonth(), tokenizationCard.getCardExpiryYear(), tokenizationCard.getCardCvv(), tokenizationPublicKey.getPublicKey(), "release"), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCheckoutPublicKey(int r6, @org.jetbrains.annotations.Nullable java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.Integer r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.talabat.feature.tokenization.data.TokenizationRepositoryImpl$getCheckoutPublicKey$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.feature.tokenization.data.TokenizationRepositoryImpl$getCheckoutPublicKey$1 r0 = (com.talabat.feature.tokenization.data.TokenizationRepositoryImpl$getCheckoutPublicKey$1) r0
            int r1 = r0.f59234k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59234k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tokenization.data.TokenizationRepositoryImpl$getCheckoutPublicKey$1 r0 = new com.talabat.feature.tokenization.data.TokenizationRepositoryImpl$getCheckoutPublicKey$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f59232i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59234k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.f59231h
            com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper r6 = (com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.feature.tokenization.data.mapper.TokenizationPublicKeyMapper r9 = r5.publicKeyMapper
            com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource r2 = r5.remoteDataSource
            r0.f59231h = r9
            r0.f59234k = r3
            java.lang.Object r6 = r2.getPublicKey(r6, r7, r8, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4 = r9
            r9 = r6
            r6 = r4
        L_0x004a:
            com.talabat.feature.tokenization.data.datasource.response.RemoteTokenizationPublicKey r9 = (com.talabat.feature.tokenization.data.datasource.response.RemoteTokenizationPublicKey) r9
            com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey r6 = r6.map(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tokenization.data.TokenizationRepositoryImpl.getCheckoutPublicKey(int, java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
