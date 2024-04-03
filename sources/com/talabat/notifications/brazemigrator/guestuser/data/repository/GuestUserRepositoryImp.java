package com.talabat.notifications.brazemigrator.guestuser.data.repository;

import com.talabat.notifications.brazemigrator.guestuser.data.service.GuestUserHashService;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserResponseBody;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/data/repository/GuestUserRepositoryImp;", "Lcom/talabat/notifications/brazemigrator/guestuser/data/repository/GuestUserRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "guestUserHashService", "Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/notifications/brazemigrator/guestuser/data/service/GuestUserHashService;)V", "getGuestUserHash", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserResponseBody;", "requestBody", "Lcom/talabat/notifications/brazemigrator/guestuser/model/GuestUserRequestBody;", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserRepositoryImp implements GuestUserRepository {
    @NotNull
    private final GuestUserHashService guestUserHashService;
    @NotNull
    private final NetworkHandler networkHandler;

    public GuestUserRepositoryImp(@NotNull NetworkHandler networkHandler2, @NotNull GuestUserHashService guestUserHashService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(guestUserHashService2, "guestUserHashService");
        this.networkHandler = networkHandler2;
        this.guestUserHashService = guestUserHashService2;
    }

    @NotNull
    public Either<Failure, GuestUserResponseBody> getGuestUserHash(@NotNull GuestUserRequestBody guestUserRequestBody) {
        Intrinsics.checkNotNullParameter(guestUserRequestBody, "requestBody");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.guestUserHashService.fitchUserHashValue(guestUserRequestBody), GuestUserRepositoryImp$getGuestUserHash$1.INSTANCE, new GuestUserResponseBody(""));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
