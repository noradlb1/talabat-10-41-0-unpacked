package com.talabat.authentication.natives.di.fake;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import com.talabat.authentication.natives.JwtTokenRepositoryImpl;
import com.talabat.authentication.natives.fake.FakeJwtTokenManager;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/natives/di/fake/FakeJwtTokenCoreLibModule;", "", "()V", "manager", "Lcom/talabat/authentication/JwtTokenManager;", "repository", "Lcom/talabat/authentication/JwtTokenRepository;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FakeJwtTokenCoreLibModule {
    @NotNull
    public static final FakeJwtTokenCoreLibModule INSTANCE = new FakeJwtTokenCoreLibModule();

    private FakeJwtTokenCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final JwtTokenManager manager() {
        return new FakeJwtTokenManager();
    }

    @NotNull
    @Reusable
    @Provides
    public final JwtTokenRepository repository(@NotNull JwtTokenManager jwtTokenManager) {
        Intrinsics.checkNotNullParameter(jwtTokenManager, "manager");
        return new JwtTokenRepositoryImpl(jwtTokenManager);
    }
}
