package com.talabat.userandlocation.compliance.status.data.impl;

import android.content.SharedPreferences;
import com.talabat.talabatcore.cache.Cache;
import com.talabat.talabatcore.cache.CurrentNanoTimeProvider;
import com.talabat.talabatcore.cache.ExpiringCacheDecorator;
import com.talabat.talabatcore.cache.impl.DiskCache;
import com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource;
import com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JQ\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0011H\u0002J\f\u0010\u001f\u001a\u00020\b*\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/impl/UserStatusRepositoryImpl;", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "userStatusRemoteDataSource", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource;", "cache", "Lcom/talabat/talabatcore/cache/Cache;", "(Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource;Lcom/talabat/talabatcore/cache/Cache;)V", "getStatusOfUser", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Status;", "countryId", "", "userId", "firstName", "", "lastName", "dateOfBirth", "flowType", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Type;", "isAfterUpdatingUserInfo", "", "deviceId", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Type;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAllowedToCheckStatusOfUser", "durationAllowedInMillis", "", "resetUserStatusAllowedCheck", "", "setStatusIsNotAllowedToCheckFor", "durationMillis", "toDataSourceType", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;", "toRepositoryResult", "Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;", "withExpiry", "flushIntervalMillis", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusRepositoryImpl implements UserStatusRepository {
    @NotNull
    private final Cache cache;
    @NotNull
    private final UserStatusRemoteDataSource userStatusRemoteDataSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UserStatusRepository.Type.values().length];
            iArr[UserStatusRepository.Type.CHECKOUT_PLACEMENT.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[UserStatusDto.UserStatus.values().length];
            iArr2[UserStatusDto.UserStatus.PASS.ordinal()] = 1;
            iArr2[UserStatusDto.UserStatus.PENDING.ordinal()] = 2;
            iArr2[UserStatusDto.UserStatus.FAIL.ordinal()] = 3;
            iArr2[UserStatusDto.UserStatus.ERROR.ordinal()] = 4;
            iArr2[UserStatusDto.UserStatus.UNINITIALIZED.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public UserStatusRepositoryImpl(@NotNull UserStatusRemoteDataSource userStatusRemoteDataSource2, @NotNull Cache cache2) {
        Intrinsics.checkNotNullParameter(userStatusRemoteDataSource2, "userStatusRemoteDataSource");
        Intrinsics.checkNotNullParameter(cache2, "cache");
        this.userStatusRemoteDataSource = userStatusRemoteDataSource2;
        this.cache = cache2;
    }

    private final UserStatusRemoteDataSource.Parameters.Type toDataSourceType(UserStatusRepository.Type type) {
        if (WhenMappings.$EnumSwitchMapping$0[type.ordinal()] == 1) {
            return UserStatusRemoteDataSource.Parameters.Type.CHECKOUT_PLACEMENT;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final UserStatusRepository.Status toRepositoryResult(UserStatusDto.UserStatus userStatus) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[userStatus.ordinal()];
        if (i11 == 1) {
            return UserStatusRepository.Status.PASS;
        }
        if (i11 == 2) {
            return UserStatusRepository.Status.PENDING;
        }
        if (i11 == 3) {
            return UserStatusRepository.Status.FAIL;
        }
        if (i11 == 4) {
            return UserStatusRepository.Status.ERROR;
        }
        if (i11 == 5) {
            return UserStatusRepository.Status.UNINITIALIZED;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Cache withExpiry(Cache cache2, long j11) {
        return new ExpiringCacheDecorator(cache2, j11, (CurrentNanoTimeProvider) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getStatusOfUser(int r16, int r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Type r21, boolean r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository.Status> r24) {
        /*
            r15 = this;
            r0 = r15
            r1 = r24
            boolean r2 = r1 instanceof com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl$getStatusOfUser$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl$getStatusOfUser$1 r2 = (com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl$getStatusOfUser$1) r2
            int r3 = r2.f12275k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f12275k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl$getStatusOfUser$1 r2 = new com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl$getStatusOfUser$1
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.f12273i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f12275k
            r5 = 1
            if (r4 == 0) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            java.lang.Object r2 = r2.f12272h
            com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl r2 = (com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0063
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource r1 = r0.userStatusRemoteDataSource
            com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource$Parameters r4 = new com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource$Parameters
            r6 = r21
            com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource$Parameters$Type r12 = r15.toDataSourceType(r6)
            r6 = r4
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r11 = r20
            r13 = r22
            r14 = r23
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            r2.f12272h = r0
            r2.f12275k = r5
            java.lang.Object r1 = r1.getStatusOfUser(r4, r2)
            if (r1 != r3) goto L_0x0062
            return r3
        L_0x0062:
            r2 = r0
        L_0x0063:
            com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto r1 = (com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto) r1
            com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto$UserStatus r1 = r1.getUserStatus()
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Status r1 = r2.toRepositoryResult(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl.getStatusOfUser(int, int, java.lang.String, java.lang.String, java.lang.String, com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository$Type, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isAllowedToCheckStatusOfUser(long j11) {
        return !withExpiry(this.cache, j11).getBoolean(UserStatusRepositoryImplKt.KEY_CALL_INVOKED, false);
    }

    public void resetUserStatusAllowedCheck() {
        this.cache.clear();
    }

    public void setStatusIsNotAllowedToCheckFor(long j11) {
        withExpiry(this.cache, j11).putBoolean(UserStatusRepositoryImplKt.KEY_CALL_INVOKED, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserStatusRepositoryImpl(UserStatusRemoteDataSource userStatusRemoteDataSource2, Cache cache2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(userStatusRemoteDataSource2, (i11 & 2) != 0 ? new DiskCache("fn4skc7mp3l15tywe4564r", (SharedPreferences) null, 2, (DefaultConstructorMarker) null) : cache2);
    }
}
