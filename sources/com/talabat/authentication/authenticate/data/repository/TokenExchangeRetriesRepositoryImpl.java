package com.talabat.authentication.authenticate.data.repository;

import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/talabat/authentication/authenticate/data/repository/TokenExchangeRetriesRepositoryImpl;", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "()V", "currentSessionRetries", "", "getCurrentSessionRetries", "()I", "clear", "", "updateRetriesCount", "updateCount", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenExchangeRetriesRepositoryImpl implements TokenExchangeRetriesRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final AtomicInteger _currentSessionRetries = new AtomicInteger(0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/authenticate/data/repository/TokenExchangeRetriesRepositoryImpl$Companion;", "", "()V", "_currentSessionRetries", "Ljava/util/concurrent/atomic/AtomicInteger;", "get_currentSessionRetries$annotations", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void get_currentSessionRetries$annotations() {
        }
    }

    public void clear() {
        _currentSessionRetries.set(0);
    }

    public int getCurrentSessionRetries() {
        return _currentSessionRetries.get();
    }

    public void updateRetriesCount(int i11) {
        _currentSessionRetries.getAndAdd(i11);
    }
}
