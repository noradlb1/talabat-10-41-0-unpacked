package com.talabat.feature.walletaddcard.data;

import androidx.annotation.VisibleForTesting;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/walletaddcard/data/WalletAddCardRepositoryImpl;", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardRepository;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;)V", "generateCardToken", "", "bankCard", "Lcom/talabat/feature/walletaddcard/domain/model/BankCard;", "(Lcom/talabat/feature/walletaddcard/domain/model/BankCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCardHolderName", "isBenefitDeflectionEnabled", "", "isQPayDeflectionEnabled", "com_talabat_feature_wallet-add-card_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardRepositoryImpl implements WalletAddCardRepository {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final GenerateCardTokenUseCase generateCardTokenUseCase;

    @Inject
    public WalletAddCardRepositoryImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull GenerateCardTokenUseCase generateCardTokenUseCase2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "generateCardTokenUseCase");
        this.featureFlag = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object generateCardToken(@org.jetbrains.annotations.NotNull com.talabat.feature.walletaddcard.domain.model.BankCard r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            java.lang.String r2 = "/"
            boolean r3 = r0 instanceof com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl$generateCardToken$1
            if (r3 == 0) goto L_0x0019
            r3 = r0
            com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl$generateCardToken$1 r3 = (com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl$generateCardToken$1) r3
            int r4 = r3.f59429j
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f59429j = r4
            goto L_0x001e
        L_0x0019:
            com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl$generateCardToken$1 r3 = new com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl$generateCardToken$1
            r3.<init>(r1, r0)
        L_0x001e:
            r8 = r3
            java.lang.Object r0 = r8.f59427h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r8.f59429j
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x00a0
        L_0x0030:
            r0 = move-exception
            goto L_0x00a3
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r9 = r21.getExpiryDate()     // Catch:{ all -> 0x0030 }
            java.lang.String[] r10 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0030 }
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ all -> 0x0030 }
            r4 = 0
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0030 }
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0030 }
            java.lang.String r13 = r21.getExpiryDate()     // Catch:{ all -> 0x0030 }
            java.lang.String[] r14 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0030 }
            r15 = 0
            r16 = 0
            r17 = 6
            r18 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0030 }
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0030 }
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase r4 = r1.generateCardTokenUseCase     // Catch:{ all -> 0x0030 }
            com.talabat.feature.tokenization.domain.entity.TokenizationCard r0 = new com.talabat.feature.tokenization.domain.entity.TokenizationCard     // Catch:{ all -> 0x0030 }
            java.lang.String r14 = r21.getCardNumber()     // Catch:{ all -> 0x0030 }
            java.lang.String r15 = " "
            java.lang.String r16 = ""
            r17 = 0
            r18 = 4
            r19 = 0
            java.lang.String r10 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (boolean) r17, (int) r18, (java.lang.Object) r19)     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r20.getCardHolderName()     // Catch:{ all -> 0x0030 }
            java.lang.String r14 = r21.getCvv()     // Catch:{ all -> 0x0030 }
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0030 }
            com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase$UseCase r6 = com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase.UseCase.WALLET     // Catch:{ all -> 0x0030 }
            r7 = 0
            r9 = 4
            r10 = 0
            r8.f59429j = r5     // Catch:{ all -> 0x0030 }
            r5 = r0
            java.lang.Object r0 = com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase.invoke$default(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0030 }
            if (r0 != r3) goto L_0x00a0
            return r3
        L_0x00a0:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0030 }
            return r0
        L_0x00a3:
            com.talabat.feature.walletaddcard.data.exception.InvalidCardInfoException r2 = new com.talabat.feature.walletaddcard.data.exception.InvalidCardInfoException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl.generateCardToken(com.talabat.feature.walletaddcard.domain.model.BankCard, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @VisibleForTesting
    public final String getCardHolderName() {
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(Integer.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()), PayFeatureFlagConstants.CARD_HOLDER_NAME), false, 2, (Object) null)) {
            return "Talabat";
        }
        return "";
    }

    public boolean isBenefitDeflectionEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.WALLET_BENEFIT_BIN_DETAIL, false, 2, (Object) null);
    }

    public boolean isQPayDeflectionEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_WALLET_DEFLECTION_ENABLED, false, 2, (Object) null);
    }
}
