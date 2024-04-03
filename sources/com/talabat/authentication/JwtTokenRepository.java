package com.talabat.authentication;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/JwtTokenRepository;", "", "JWTFeatureEnable", "", "path", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJwt", "refreshJwt", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface JwtTokenRepository {
    @Nullable
    Object JWTFeatureEnable(@NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    Object getJwt(@NotNull String str, @NotNull Continuation<? super String> continuation);

    @Nullable
    Object refreshJwt(@NotNull String str, @NotNull Continuation<? super String> continuation);
}
