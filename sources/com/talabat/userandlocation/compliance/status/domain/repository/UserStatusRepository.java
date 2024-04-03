package com.talabat.userandlocation.compliance.status.domain.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0018\u0019JQ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "", "getStatusOfUser", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Status;", "countryId", "", "userId", "firstName", "", "lastName", "dateOfBirth", "flowType", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Type;", "isAfterUpdatingUserInfo", "", "deviceId", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Type;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAllowedToCheckStatusOfUser", "durationAllowedInMillis", "", "resetUserStatusAllowedCheck", "", "setStatusIsNotAllowedToCheckFor", "durationMillis", "Status", "Type", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserStatusRepository {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Status;", "", "(Ljava/lang/String;I)V", "PASS", "PENDING", "FAIL", "ERROR", "UNINITIALIZED", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Status {
        PASS,
        PENDING,
        FAIL,
        ERROR,
        UNINITIALIZED
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository$Type;", "", "(Ljava/lang/String;I)V", "CHECKOUT_PLACEMENT", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        CHECKOUT_PLACEMENT
    }

    @Nullable
    Object getStatusOfUser(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Type type, boolean z11, @NotNull String str4, @NotNull Continuation<? super Status> continuation);

    boolean isAllowedToCheckStatusOfUser(long j11);

    void resetUserStatusAllowedCheck();

    void setStatusIsNotAllowedToCheckFor(long j11);
}
