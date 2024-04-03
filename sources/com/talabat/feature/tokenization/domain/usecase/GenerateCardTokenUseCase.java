package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HBø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "", "tokenizationRepository", "Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "getTokenizationPublicKeyUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GetTokenizationPublicKeyUseCase;", "observeFailedUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase;", "observeSuccessUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase;", "(Lcom/talabat/feature/tokenization/domain/TokenizationRepository;Lcom/talabat/feature/tokenization/domain/usecase/GetTokenizationPublicKeyUseCase;Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase;Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase;)V", "invoke", "", "card", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;", "useCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase$UseCase;", "vertical", "", "(Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase$UseCase;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "UseCase", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.WARNING, message = "Please use TokenizeCardUseCase instead", replaceWith = @ReplaceWith(expression = "TokenizeCardUseCase", imports = {}))
public final class GenerateCardTokenUseCase {
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase$Companion;", "", "()V", "BIN_NUMBER_SIZE", "", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase$UseCase;", "", "isBinNumberRequired", "", "(Ljava/lang/String;IZ)V", "()Z", "CHECKOUT", "WALLET", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public GenerateCardTokenUseCase(@NotNull TokenizationRepository tokenizationRepository2, @NotNull GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase2, @NotNull ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase, @NotNull ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase) {
        Intrinsics.checkNotNullParameter(tokenizationRepository2, "tokenizationRepository");
        Intrinsics.checkNotNullParameter(getTokenizationPublicKeyUseCase2, "getTokenizationPublicKeyUseCase");
        Intrinsics.checkNotNullParameter(observeTokenizationFailedUseCase, "observeFailedUseCase");
        Intrinsics.checkNotNullParameter(observeTokenizationSuccessUseCase, "observeSuccessUseCase");
        this.tokenizationRepository = tokenizationRepository2;
        this.getTokenizationPublicKeyUseCase = getTokenizationPublicKeyUseCase2;
        this.observeFailedUseCase = observeTokenizationFailedUseCase;
        this.observeSuccessUseCase = observeTokenizationSuccessUseCase;
    }

    public static /* synthetic */ Object invoke$default(GenerateCardTokenUseCase generateCardTokenUseCase, TokenizationCard tokenizationCard, UseCase useCase, Integer num, Continuation continuation, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        return generateCardTokenUseCase.invoke(tokenizationCard, useCase, num, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.tokenization.domain.entity.TokenizationCard r8, @org.jetbrains.annotations.NotNull com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase.UseCase r9, @org.jetbrains.annotations.Nullable java.lang.Integer r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$invoke$1 r0 = (com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$invoke$1) r0
            int r1 = r0.f59242m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59242m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$invoke$1 r0 = new com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$invoke$1
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f59240k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59242m
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r8 = r0.f59237h
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase r8 = (com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0031 }
            goto L_0x008b
        L_0x0031:
            r9 = move-exception
            goto L_0x0095
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.f59239j
            com.talabat.feature.tokenization.domain.entity.TokenizationCard r8 = (com.talabat.feature.tokenization.domain.entity.TokenizationCard) r8
            java.lang.Object r9 = r0.f59238i
            com.talabat.feature.tokenization.domain.TokenizationRepository r9 = (com.talabat.feature.tokenization.domain.TokenizationRepository) r9
            java.lang.Object r10 = r0.f59237h
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase r10 = (com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x004b }
            goto L_0x0079
        L_0x004b:
            r9 = move-exception
            r8 = r10
            goto L_0x0095
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r9 = r9.isBinNumberRequired()     // Catch:{ Exception -> 0x0093 }
            if (r9 == 0) goto L_0x0061
            java.lang.String r9 = r8.getCardNumber()     // Catch:{ Exception -> 0x0093 }
            r11 = 6
            java.lang.String r9 = kotlin.text.StringsKt___StringsKt.take((java.lang.String) r9, (int) r11)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0062
        L_0x0061:
            r9 = r5
        L_0x0062:
            com.talabat.feature.tokenization.domain.TokenizationRepository r11 = r7.tokenizationRepository     // Catch:{ Exception -> 0x0093 }
            com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase r2 = r7.getTokenizationPublicKeyUseCase     // Catch:{ Exception -> 0x0093 }
            r0.f59237h = r7     // Catch:{ Exception -> 0x0093 }
            r0.f59238i = r11     // Catch:{ Exception -> 0x0093 }
            r0.f59239j = r8     // Catch:{ Exception -> 0x0093 }
            r0.f59242m = r4     // Catch:{ Exception -> 0x0093 }
            java.lang.Object r9 = r2.invoke(r9, r10, r0)     // Catch:{ Exception -> 0x0093 }
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r10 = r7
            r6 = r11
            r11 = r9
            r9 = r6
        L_0x0079:
            com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey r11 = (com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey) r11     // Catch:{ Exception -> 0x004b }
            r0.f59237h = r10     // Catch:{ Exception -> 0x004b }
            r0.f59238i = r5     // Catch:{ Exception -> 0x004b }
            r0.f59239j = r5     // Catch:{ Exception -> 0x004b }
            r0.f59242m = r3     // Catch:{ Exception -> 0x004b }
            java.lang.Object r11 = r9.generateCardToken(r8, r11, r0)     // Catch:{ Exception -> 0x004b }
            if (r11 != r1) goto L_0x008a
            return r1
        L_0x008a:
            r8 = r10
        L_0x008b:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0031 }
            com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase r9 = r8.observeSuccessUseCase     // Catch:{ Exception -> 0x0031 }
            r9.invoke()     // Catch:{ Exception -> 0x0031 }
            return r11
        L_0x0093:
            r9 = move-exception
            r8 = r7
        L_0x0095:
            com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase r8 = r8.observeFailedUseCase
            r8.invoke(r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase.invoke(com.talabat.feature.tokenization.domain.entity.TokenizationCard, com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$UseCase, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
