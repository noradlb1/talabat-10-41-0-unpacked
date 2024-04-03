package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/GetTokenizationPublicKeyUseCase;", "", "tokenizationRepository", "Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/feature/tokenization/domain/TokenizationRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "invoke", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;", "binNumber", "", "verticalId", "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetTokenizationPublicKeyUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final TokenizationRepository tokenizationRepository;

    @Inject
    public GetTokenizationPublicKeyUseCase(@NotNull TokenizationRepository tokenizationRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(tokenizationRepository2, "tokenizationRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.tokenizationRepository = tokenizationRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public static /* synthetic */ Object invoke$default(GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase, String str, Integer num, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        return getTokenizationPublicKeyUseCase.invoke(str, num, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable String str, @Nullable Integer num, @NotNull Continuation<? super TokenizationPublicKey> continuation) {
        return this.tokenizationRepository.getCheckoutPublicKey(this.configurationLocalRepository.selectedCountry().getCountryId(), str, num, continuation);
    }
}
