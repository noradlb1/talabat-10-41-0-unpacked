package com.talabat.feature.tokenization.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tokenization/domain/FakeTokenizationFeatureApi;", "Lcom/talabat/feature/tokenization/domain/TokenizationFeatureApi;", "repository", "Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "(Lcom/talabat/feature/tokenization/domain/TokenizationRepository;)V", "getRepository", "()Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeTokenizationFeatureApi implements TokenizationFeatureApi {
    @NotNull
    private final TokenizationRepository repository;

    public FakeTokenizationFeatureApi(@NotNull TokenizationRepository tokenizationRepository) {
        Intrinsics.checkNotNullParameter(tokenizationRepository, "repository");
        this.repository = tokenizationRepository;
    }

    @NotNull
    public TokenizationRepository getRepository() {
        return this.repository;
    }
}
