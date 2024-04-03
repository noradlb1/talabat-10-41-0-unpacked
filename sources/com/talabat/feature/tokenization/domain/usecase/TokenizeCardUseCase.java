package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HBø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/TokenizeCardUseCase;", "", "tokenizationRepository", "Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "getTokenizationPublicKeyUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GetTokenizationPublicKeyUseCase;", "observeFailedUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase;", "observeSuccessUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase;", "(Lcom/talabat/feature/tokenization/domain/TokenizationRepository;Lcom/talabat/feature/tokenization/domain/usecase/GetTokenizationPublicKeyUseCase;Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase;Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase;)V", "invoke", "Lcom/talabat/feature/tokenization/domain/entity/TokenizedCard;", "card", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;", "useCase", "Lcom/talabat/feature/tokenization/domain/usecase/TokenizeCardUseCase$UseCase;", "vertical", "", "(Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;Lcom/talabat/feature/tokenization/domain/usecase/TokenizeCardUseCase$UseCase;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UseCase", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizeCardUseCase {
    @Deprecated
    private static final int BIN_NUMBER_SIZE = 6;
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase;
    @NotNull
    private final ObserveTokenizationFailedUseCase observeFailedUseCase;
    @NotNull
    private final ObserveTokenizationSuccessUseCase observeSuccessUseCase;
    @NotNull
    private final TokenizationRepository tokenizationRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/TokenizeCardUseCase$Companion;", "", "()V", "BIN_NUMBER_SIZE", "", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/TokenizeCardUseCase$UseCase;", "", "isBinNumberRequired", "", "(Ljava/lang/String;IZ)V", "()Z", "CHECKOUT", "WALLET", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum UseCase {
        CHECKOUT(true),
        WALLET(false);
        
        private final boolean isBinNumberRequired;

        private UseCase(boolean z11) {
            this.isBinNumberRequired = z11;
        }

        public final boolean isBinNumberRequired() {
            return this.isBinNumberRequired;
        }
    }

    @Inject
    public TokenizeCardUseCase(@NotNull TokenizationRepository tokenizationRepository2, @NotNull GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase2, @NotNull ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase, @NotNull ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase) {
        Intrinsics.checkNotNullParameter(tokenizationRepository2, "tokenizationRepository");
        Intrinsics.checkNotNullParameter(getTokenizationPublicKeyUseCase2, "getTokenizationPublicKeyUseCase");
        Intrinsics.checkNotNullParameter(observeTokenizationFailedUseCase, "observeFailedUseCase");
        Intrinsics.checkNotNullParameter(observeTokenizationSuccessUseCase, "observeSuccessUseCase");
        this.tokenizationRepository = tokenizationRepository2;
        this.getTokenizationPublicKeyUseCase = getTokenizationPublicKeyUseCase2;
        this.observeFailedUseCase = observeTokenizationFailedUseCase;
        this.observeSuccessUseCase = observeTokenizationSuccessUseCase;
    }

    public static /* synthetic */ Object invoke$default(TokenizeCardUseCase tokenizeCardUseCase, TokenizationCard tokenizationCard, UseCase useCase, Integer num, Continuation continuation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        return tokenizeCardUseCase.invoke(tokenizationCard, useCase, num, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f A[Catch:{ Exception -> 0x0048 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0080 A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.tokenization.domain.entity.TokenizationCard r6, @org.jetbrains.annotations.NotNull com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase.UseCase r7, @org.jetbrains.annotations.Nullable java.lang.Integer r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.tokenization.domain.entity.TokenizedCard> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$invoke$1 r0 = (com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$invoke$1) r0
            int r1 = r0.f59247l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59247l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$invoke$1 r0 = new com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$invoke$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f59245j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59247l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r6 = r0.f59244i
            com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey r6 = (com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey) r6
            java.lang.Object r7 = r0.f59243h
            com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase r7 = (com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0081
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            java.lang.Object r6 = r0.f59244i
            com.talabat.feature.tokenization.domain.entity.TokenizationCard r6 = (com.talabat.feature.tokenization.domain.entity.TokenizationCard) r6
            java.lang.Object r7 = r0.f59243h
            com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase r7 = (com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0048 }
            goto L_0x006e
        L_0x0048:
            r6 = move-exception
            goto L_0x0094
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r7 = r7.isBinNumberRequired()     // Catch:{ Exception -> 0x0092 }
            if (r7 == 0) goto L_0x005d
            java.lang.String r7 = r6.getCardNumber()     // Catch:{ Exception -> 0x0092 }
            r9 = 6
            java.lang.String r7 = kotlin.text.StringsKt___StringsKt.take((java.lang.String) r7, (int) r9)     // Catch:{ Exception -> 0x0092 }
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase r9 = r5.getTokenizationPublicKeyUseCase     // Catch:{ Exception -> 0x0092 }
            r0.f59243h = r5     // Catch:{ Exception -> 0x0092 }
            r0.f59244i = r6     // Catch:{ Exception -> 0x0092 }
            r0.f59247l = r4     // Catch:{ Exception -> 0x0092 }
            java.lang.Object r9 = r9.invoke(r7, r8, r0)     // Catch:{ Exception -> 0x0092 }
            if (r9 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r7 = r5
        L_0x006e:
            r8 = r9
            com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey r8 = (com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey) r8     // Catch:{ Exception -> 0x0048 }
            com.talabat.feature.tokenization.domain.TokenizationRepository r9 = r7.tokenizationRepository     // Catch:{ Exception -> 0x0048 }
            r0.f59243h = r7     // Catch:{ Exception -> 0x0048 }
            r0.f59244i = r8     // Catch:{ Exception -> 0x0048 }
            r0.f59247l = r3     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r9 = r9.generateCardToken(r6, r8, r0)     // Catch:{ Exception -> 0x0048 }
            if (r9 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r6 = r8
        L_0x0081:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0048 }
            com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase r8 = r7.observeSuccessUseCase     // Catch:{ Exception -> 0x0048 }
            r8.invoke()     // Catch:{ Exception -> 0x0048 }
            com.talabat.feature.tokenization.domain.entity.TokenizedCard r8 = new com.talabat.feature.tokenization.domain.entity.TokenizedCard     // Catch:{ Exception -> 0x0048 }
            java.lang.String r6 = r6.getPublicKey()     // Catch:{ Exception -> 0x0048 }
            r8.<init>(r9, r6)     // Catch:{ Exception -> 0x0048 }
            return r8
        L_0x0092:
            r6 = move-exception
            r7 = r5
        L_0x0094:
            com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase r7 = r7.observeFailedUseCase
            r7.invoke(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase.invoke(com.talabat.feature.tokenization.domain.entity.TokenizationCard, com.talabat.feature.tokenization.domain.usecase.TokenizeCardUseCase$UseCase, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
