package com.talabat.user.status.domain.repository;

import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository;", "", "isUserRegistered", "Lio/reactivex/Single;", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Status;", "providerId", "", "provider", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Provider;", "providerKey", "Provider", "Status", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IsUserRegisteredRepository {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Provider;", "", "(Ljava/lang/String;I)V", "GOOGLE", "FACEBOOK", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Provider {
        GOOGLE,
        FACEBOOK
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Status;", "", "(Ljava/lang/String;I)V", "REGISTERED", "NOT_FOUND", "INVALID_KEY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        REGISTERED,
        NOT_FOUND,
        INVALID_KEY
    }

    @NotNull
    Single<Status> isUserRegistered(@Nullable String str, @NotNull Provider provider, @NotNull String str2);
}
