package com.talabat.authentication.authenticate.domain.usecase;

import com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication;
import com.talabat.authentication.authenticate.domain.repository.JwtExchangeCallback;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J-\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH¦Bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/usecase/ExchangeTokenUseCase;", "", "call", "", "flowName", "", "enableFeatureFlag", "Lcom/talabat/core/fwfprojectskeys/domain/projects/user/UserFeatureFlagsKeys;", "jwtExchangeCallback", "Lcom/talabat/authentication/authenticate/domain/repository/JwtExchangeCallback;", "invoke", "", "(Ljava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/projects/user/UserFeatureFlagsKeys;Lcom/talabat/authentication/authenticate/domain/repository/JwtExchangeCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrationExchangeToken", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "IsGdmOwinAvailable", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ExchangeTokenUseCase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(ExchangeTokenUseCase exchangeTokenUseCase, String str, UserFeatureFlagsKeys userFeatureFlagsKeys, JwtExchangeCallback jwtExchangeCallback, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    jwtExchangeCallback = null;
                }
                return exchangeTokenUseCase.invoke(str, userFeatureFlagsKeys, jwtExchangeCallback, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/usecase/ExchangeTokenUseCase$IsGdmOwinAvailable;", "", "isGdmOwinAvailable", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IsGdmOwinAvailable {
        boolean isGdmOwinAvailable();
    }

    void call(@NotNull String str, @NotNull UserFeatureFlagsKeys userFeatureFlagsKeys, @Nullable JwtExchangeCallback jwtExchangeCallback);

    @Nullable
    Object invoke(@NotNull String str, @NotNull UserFeatureFlagsKeys userFeatureFlagsKeys, @Nullable JwtExchangeCallback jwtExchangeCallback, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object migrationExchangeToken(@NotNull Continuation<? super MigrationExchangeTokenAuthentication> continuation);
}
