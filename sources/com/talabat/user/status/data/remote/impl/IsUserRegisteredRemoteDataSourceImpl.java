package com.talabat.user.status.data.remote.impl;

import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.status.data.remote.IsUserRegisteredRemoteDataSource;
import com.talabat.user.status.data.remote.api.IsUserRegisteredRequest;
import com.talabat.user.status.data.remote.api.IsUserRegisteredResponse;
import com.talabat.user.status.data.remote.api.IsUserRegisteredResult;
import com.talabat.user.status.data.remote.api.UserRegistrationStatusApi;
import com.talabat.user.status.data.remote.dto.IsUserRegisteredDto;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yw.a;
import yw.b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/user/status/data/remote/impl/IsUserRegisteredRemoteDataSourceImpl;", "Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource;", "userRegistrationStatusApi", "Lcom/talabat/user/status/data/remote/api/UserRegistrationStatusApi;", "(Lcom/talabat/user/status/data/remote/api/UserRegistrationStatusApi;)V", "isUserRegistered", "Lio/reactivex/Single;", "Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto;", "providerId", "", "providerKey", "provider", "Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource$Provider;", "deviceId", "countryId", "", "toDataSourceStatus", "Lcom/talabat/user/status/data/remote/dto/IsUserRegisteredDto$Status;", "Lcom/talabat/user/status/data/remote/api/IsUserRegisteredResult$Status;", "toRequestProvider", "Lcom/talabat/user/status/data/remote/api/IsUserRegisteredRequest$Provider;", "NullStatusForIsUserRegisteredException", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRegisteredRemoteDataSourceImpl implements IsUserRegisteredRemoteDataSource {
    @NotNull
    private final UserRegistrationStatusApi userRegistrationStatusApi;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/user/status/data/remote/impl/IsUserRegisteredRemoteDataSourceImpl$NullStatusForIsUserRegisteredException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NullStatusForIsUserRegisteredException extends Exception {
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IsUserRegisteredResult.Status.values().length];
            iArr[IsUserRegisteredResult.Status.NOT_FOUND.ordinal()] = 1;
            iArr[IsUserRegisteredResult.Status.REGISTERED.ordinal()] = 2;
            iArr[IsUserRegisteredResult.Status.INVALID_KEY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IsUserRegisteredRemoteDataSource.Provider.values().length];
            iArr2[IsUserRegisteredRemoteDataSource.Provider.FACEBOOK.ordinal()] = 1;
            iArr2[IsUserRegisteredRemoteDataSource.Provider.GOOGLE.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public IsUserRegisteredRemoteDataSourceImpl(@NotNull UserRegistrationStatusApi userRegistrationStatusApi2) {
        Intrinsics.checkNotNullParameter(userRegistrationStatusApi2, "userRegistrationStatusApi");
        this.userRegistrationStatusApi = userRegistrationStatusApi2;
    }

    /* access modifiers changed from: private */
    /* renamed from: isUserRegistered$lambda-0  reason: not valid java name */
    public static final IsUserRegisteredResult m5881isUserRegistered$lambda0(IsUserRegisteredResponse isUserRegisteredResponse) {
        Intrinsics.checkNotNullParameter(isUserRegisteredResponse, "it");
        IsUserRegisteredResult result = isUserRegisteredResponse.getResult();
        if (result != null) {
            return result;
        }
        throw new NullPointerException("Api result was null!");
    }

    /* access modifiers changed from: private */
    /* renamed from: isUserRegistered$lambda-1  reason: not valid java name */
    public static final IsUserRegisteredDto m5882isUserRegistered$lambda1(IsUserRegisteredRemoteDataSourceImpl isUserRegisteredRemoteDataSourceImpl, IsUserRegisteredResult isUserRegisteredResult) {
        Intrinsics.checkNotNullParameter(isUserRegisteredRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(isUserRegisteredResult, "it");
        return new IsUserRegisteredDto(isUserRegisteredRemoteDataSourceImpl.toDataSourceStatus(isUserRegisteredResult.getStatus()));
    }

    private final IsUserRegisteredDto.Status toDataSourceStatus(IsUserRegisteredResult.Status status) {
        int i11;
        if (status == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        }
        if (i11 == -1) {
            IsUserRegisteredDto.Status status2 = IsUserRegisteredDto.Status.NOT_FOUND;
            LogManager.logException(new NullStatusForIsUserRegisteredException());
            return status2;
        } else if (i11 == 1) {
            return IsUserRegisteredDto.Status.NOT_FOUND;
        } else {
            if (i11 == 2) {
                return IsUserRegisteredDto.Status.REGISTERED;
            }
            if (i11 == 3) {
                return IsUserRegisteredDto.Status.INVALID_KEY;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final IsUserRegisteredRequest.Provider toRequestProvider(IsUserRegisteredRemoteDataSource.Provider provider) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[provider.ordinal()];
        if (i11 == 1) {
            return IsUserRegisteredRequest.Provider.FACEBOOK;
        }
        if (i11 == 2) {
            return IsUserRegisteredRequest.Provider.GOOGLE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Single<IsUserRegisteredDto> isUserRegistered(@Nullable String str, @NotNull String str2, @NotNull IsUserRegisteredRemoteDataSource.Provider provider, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str2, "providerKey");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(str3, "deviceId");
        Single<R> map = this.userRegistrationStatusApi.isUserRegistered(new IsUserRegisteredRequest(str, toRequestProvider(provider), str2, str3, i11)).map(new a()).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "userRegistrationStatusAp…s.toDataSourceStatus()) }");
        return map;
    }
}
