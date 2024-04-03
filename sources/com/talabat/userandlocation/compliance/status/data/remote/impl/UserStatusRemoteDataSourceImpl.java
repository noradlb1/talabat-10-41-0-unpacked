package com.talabat.userandlocation.compliance.status.data.remote.impl;

import com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource;
import com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusApi;
import com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusRequest;
import com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusResult;
import com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/impl/UserStatusRemoteDataSourceImpl;", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource;", "userStatusApi", "Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusApi;", "(Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusApi;)V", "getStatusOfUser", "Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto;", "parameters", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters;", "(Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toRequestType", "Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusRequest$FlowType;", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;", "toUserStatus", "Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto$UserStatus;", "Lcom/talabat/userandlocation/compliance/status/data/remote/api/UserStatusResult$Status;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserStatusRemoteDataSourceImpl implements UserStatusRemoteDataSource {
    @NotNull
    private final UserStatusApi userStatusApi;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[UserStatusResult.Status.values().length];
            iArr[UserStatusResult.Status.PASS.ordinal()] = 1;
            iArr[UserStatusResult.Status.PENDING.ordinal()] = 2;
            iArr[UserStatusResult.Status.FAIL.ordinal()] = 3;
            iArr[UserStatusResult.Status.ERROR.ordinal()] = 4;
            iArr[UserStatusResult.Status.UNINITIALIZED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[UserStatusRemoteDataSource.Parameters.Type.values().length];
            iArr2[UserStatusRemoteDataSource.Parameters.Type.CHECKOUT_PLACEMENT.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public UserStatusRemoteDataSourceImpl(@NotNull UserStatusApi userStatusApi2) {
        Intrinsics.checkNotNullParameter(userStatusApi2, "userStatusApi");
        this.userStatusApi = userStatusApi2;
    }

    private final UserStatusRequest.FlowType toRequestType(UserStatusRemoteDataSource.Parameters.Type type) {
        if (WhenMappings.$EnumSwitchMapping$1[type.ordinal()] == 1) {
            return UserStatusRequest.FlowType.CHECKOUT_PLACEMENT;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final UserStatusDto.UserStatus toUserStatus(UserStatusResult.Status status) {
        int i11;
        if (status == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        }
        if (i11 == -1) {
            throw new NullPointerException("Status from response is null!");
        } else if (i11 == 1) {
            return UserStatusDto.UserStatus.PASS;
        } else {
            if (i11 == 2) {
                return UserStatusDto.UserStatus.PENDING;
            }
            if (i11 == 3) {
                return UserStatusDto.UserStatus.FAIL;
            }
            if (i11 == 4) {
                return UserStatusDto.UserStatus.ERROR;
            }
            if (i11 == 5) {
                return UserStatusDto.UserStatus.UNINITIALIZED;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getStatusOfUser(@org.jetbrains.annotations.NotNull com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource.Parameters r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl$getStatusOfUser$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl$getStatusOfUser$1 r0 = (com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl$getStatusOfUser$1) r0
            int r1 = r0.f12279k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12279k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl$getStatusOfUser$1 r0 = new com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl$getStatusOfUser$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f12277i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12279k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r14 = r0.f12276h
            com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl r14 = (com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0070
        L_0x002d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r15)
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusApi r15 = r13.userStatusApi
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusRequest r2 = new com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusRequest
            int r5 = r14.getCountryId()
            int r6 = r14.getUserId()
            java.lang.String r7 = r14.getFirstName()
            java.lang.String r8 = r14.getLastName()
            java.lang.String r9 = r14.getDateOfBirth()
            com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource$Parameters$Type r4 = r14.getFlowType()
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusRequest$FlowType r10 = r13.toRequestType(r4)
            boolean r11 = r14.isAfterUpdatingUserInfo()
            java.lang.String r12 = r14.getDeviceId()
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r0.f12276h = r13
            r0.f12279k = r3
            java.lang.Object r15 = r15.getStatusOfUser(r2, r0)
            if (r15 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r14 = r13
        L_0x0070:
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusResponse r15 = (com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusResponse) r15
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusResult r15 = r15.component2()
            com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto r0 = new com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto
            r1 = 0
            if (r15 == 0) goto L_0x0080
            java.lang.String r2 = r15.getClientId()
            goto L_0x0081
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r2 != 0) goto L_0x0085
            java.lang.String r2 = ""
        L_0x0085:
            if (r15 == 0) goto L_0x0092
            java.lang.Integer r3 = r15.getUserId()
            if (r3 == 0) goto L_0x0092
            int r3 = r3.intValue()
            goto L_0x0093
        L_0x0092:
            r3 = 0
        L_0x0093:
            if (r15 == 0) goto L_0x0099
            com.talabat.userandlocation.compliance.status.data.remote.api.UserStatusResult$Status r1 = r15.getStatus()
        L_0x0099:
            com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto$UserStatus r14 = r14.toUserStatus(r1)
            r0.<init>(r2, r3, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl.getStatusOfUser(com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource$Parameters, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
