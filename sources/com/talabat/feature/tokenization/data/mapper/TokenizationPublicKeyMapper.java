package com.talabat.feature.tokenization.data.mapper;

import com.talabat.feature.tokenization.data.datasource.response.RemoteTokenizationPublicKey;
import com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/tokenization/data/mapper/TokenizationPublicKeyMapper;", "", "()V", "map", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;", "source", "Lcom/talabat/feature/tokenization/data/datasource/response/RemoteTokenizationPublicKey;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizationPublicKeyMapper {
    @NotNull
    public final TokenizationPublicKey map(@NotNull RemoteTokenizationPublicKey remoteTokenizationPublicKey) {
        Intrinsics.checkNotNullParameter(remoteTokenizationPublicKey, "source");
        return new TokenizationPublicKey(remoteTokenizationPublicKey.getPublicKey());
    }
}
