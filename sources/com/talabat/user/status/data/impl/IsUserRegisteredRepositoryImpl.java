package com.talabat.user.status.data.impl;

import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.user.status.data.remote.IsUserRegisteredRemoteDataSource;
import com.talabat.user.status.data.remote.dto.IsUserRegisteredDto;
import com.talabat.user.status.domain.repository.IsUserRegisteredRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xw.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/user/status/data/impl/IsUserRegisteredRepositoryImpl;", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository;", "isUserRegisteredRemoteDataSource", "Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "selectedCountryIdProvider", "Lkotlin/Function0;", "", "(Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource;Lcom/talabat/application/device/id/domain/DeviceIdProvider;Lkotlin/jvm/functions/Function0;)V", "isUserRegistered", "Lio/reactivex/Single;", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Status;", "providerId", "", "provider", "Lcom/talabat/user/status/domain/repository/IsUserRegisteredRepository$Provider;", "providerKey", "toRemoteDataSourceProvider", "Lcom/talabat/user/status/data/remote/IsUserRegisteredRemoteDataSource$Provider;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRegisteredRepositoryImpl implements IsUserRegisteredRepository {
    @NotNull
    private final DeviceIdProvider deviceIdProvider;
    @NotNull
    private final IsUserRegisteredRemoteDataSource isUserRegisteredRemoteDataSource;
    @NotNull
    private final Function0<Integer> selectedCountryIdProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IsUserRegisteredDto.Status.values().length];
            iArr[IsUserRegisteredDto.Status.REGISTERED.ordinal()] = 1;
            iArr[IsUserRegisteredDto.Status.NOT_FOUND.ordinal()] = 2;
            iArr[IsUserRegisteredDto.Status.INVALID_KEY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IsUserRegisteredRepository.Provider.values().length];
            iArr2[IsUserRegisteredRepository.Provider.GOOGLE.ordinal()] = 1;
            iArr2[IsUserRegisteredRepository.Provider.FACEBOOK.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public IsUserRegisteredRepositoryImpl(@NotNull IsUserRegisteredRemoteDataSource isUserRegisteredRemoteDataSource2, @NotNull DeviceIdProvider deviceIdProvider2, @NotNull Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(isUserRegisteredRemoteDataSource2, "isUserRegisteredRemoteDataSource");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(function0, "selectedCountryIdProvider");
        this.isUserRegisteredRemoteDataSource = isUserRegisteredRemoteDataSource2;
        this.deviceIdProvider = deviceIdProvider2;
        this.selectedCountryIdProvider = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: isUserRegistered$lambda-0  reason: not valid java name */
    public static final IsUserRegisteredRepository.Status m5880isUserRegistered$lambda0(IsUserRegisteredDto isUserRegisteredDto) {
        Intrinsics.checkNotNullParameter(isUserRegisteredDto, "it");
        int i11 = WhenMappings.$EnumSwitchMapping$0[isUserRegisteredDto.getStatus().ordinal()];
        if (i11 == 1) {
            return IsUserRegisteredRepository.Status.REGISTERED;
        }
        if (i11 == 2) {
            return IsUserRegisteredRepository.Status.NOT_FOUND;
        }
        if (i11 == 3) {
            return IsUserRegisteredRepository.Status.INVALID_KEY;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final IsUserRegisteredRemoteDataSource.Provider toRemoteDataSourceProvider(IsUserRegisteredRepository.Provider provider) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[provider.ordinal()];
        if (i11 == 1) {
            return IsUserRegisteredRemoteDataSource.Provider.GOOGLE;
        }
        if (i11 == 2) {
            return IsUserRegisteredRemoteDataSource.Provider.FACEBOOK;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Single<IsUserRegisteredRepository.Status> isUserRegistered(@Nullable String str, @NotNull IsUserRegisteredRepository.Provider provider, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(str2, "providerKey");
        Single<R> map = this.isUserRegisteredRemoteDataSource.isUserRegistered(str, str2, toRemoteDataSourceProvider(provider), this.deviceIdProvider.getId(), this.selectedCountryIdProvider.invoke().intValue()).map(new a());
        Intrinsics.checkNotNullExpressionValue(map, "isUserRegisteredRemoteDa…Y\n            }\n        }");
        return map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IsUserRegisteredRepositoryImpl(IsUserRegisteredRemoteDataSource isUserRegisteredRemoteDataSource2, DeviceIdProvider deviceIdProvider2, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(isUserRegisteredRemoteDataSource2, deviceIdProvider2, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
