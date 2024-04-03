package com.talabat.helpers;

import com.talabat.authentication.JwtTokenRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupAuthenticationTokenIntegrator$2$3 extends Lambda implements Function1<String, String> {
    final /* synthetic */ Function0<JwtTokenRepository> $jwtTokenRepository;
    final /* synthetic */ CoroutineDispatcher $singleThread;
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupAuthenticationTokenIntegrator$2$3(TalabatApplication talabatApplication, CoroutineDispatcher coroutineDispatcher, Function0<? extends JwtTokenRepository> function0) {
        super(1);
        this.this$0 = talabatApplication;
        this.$singleThread = coroutineDispatcher;
        this.$jwtTokenRepository = function0;
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return this.this$0.getRefreshJwt(this.$singleThread, this.$jwtTokenRepository, str);
    }
}
