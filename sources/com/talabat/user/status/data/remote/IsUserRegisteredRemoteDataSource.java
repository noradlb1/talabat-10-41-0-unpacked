package com.talabat.user.status.data.remote;

import com.talabat.user.status.data.remote.dto.IsUserRegisteredDto;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ8\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource;", "", "isUserRegistered", "Lio/reactivex/Single;", "Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto;", "providerId", "", "providerKey", "provider", "Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource$Provider;", "deviceId", "countryId", "", "Provider", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IsUserRegisteredRemoteDataSource {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource$Provider;", "", "(Ljava/lang/String;I)V", "FACEBOOK", "GOOGLE", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Provider {
        FACEBOOK,
        GOOGLE
    }

    @NotNull
    Single<IsUserRegisteredDto> isUserRegistered(@Nullable String str, @NotNull String str2, @NotNull Provider provider, @NotNull String str3, int i11);
}
