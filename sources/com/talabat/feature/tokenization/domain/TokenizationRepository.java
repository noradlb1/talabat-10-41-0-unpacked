package com.talabat.feature.tokenization.domain;

import com.talabat.feature.tokenization.domain.entity.TokenizationCard;
import com.talabat.feature.tokenization.domain.entity.TokenizationPublicKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ1\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tokenization/domain/TokenizationRepository;", "", "generateCardToken", "", "card", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;", "publicKey", "Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;", "(Lcom/talabat/feature/tokenization/domain/entity/TokenizationCard;Lcom/talabat/feature/tokenization/domain/entity/TokenizationPublicKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCheckoutPublicKey", "countryId", "", "binNumber", "verticalId", "(ILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenizationRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCheckoutPublicKey$default(TokenizationRepository tokenizationRepository, int i11, String str, Integer num, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    str = null;
                }
                if ((i12 & 4) != 0) {
                    num = null;
                }
                return tokenizationRepository.getCheckoutPublicKey(i11, str, num, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCheckoutPublicKey");
        }
    }

    @Nullable
    Object generateCardToken(@NotNull TokenizationCard tokenizationCard, @NotNull TokenizationPublicKey tokenizationPublicKey, @NotNull Continuation<? super String> continuation);

    @Nullable
    Object getCheckoutPublicKey(int i11, @Nullable String str, @Nullable Integer num, @NotNull Continuation<? super TokenizationPublicKey> continuation);
}
