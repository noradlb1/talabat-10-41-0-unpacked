package com.talabat.authentication.usecase;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.domain.model.Token;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Lcom/talabat/authentication/usecase/IsTokenExpiredUseCase;", "", "isTokenTimeDifferenceEnabledUseCase", "Lcom/talabat/authentication/usecase/IsTokenTimeDifferenceEnabledUseCase;", "deviceTimeProvider", "Lcom/talabat/authentication/usecase/DeviceTimeProvider;", "(Lcom/talabat/authentication/usecase/IsTokenTimeDifferenceEnabledUseCase;Lcom/talabat/authentication/usecase/DeviceTimeProvider;)V", "getCorrectedDeviceTime", "Lkotlin/time/Duration;", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "getCorrectedDeviceTime-5sfh64U", "(Lcom/talabat/authentication/token/domain/model/Token;)J", "invoke", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsTokenExpiredUseCase {
    @NotNull
    private final DeviceTimeProvider deviceTimeProvider;
    @NotNull
    private final IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase;

    @Inject
    public IsTokenExpiredUseCase(@NotNull IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase2, @NotNull DeviceTimeProvider deviceTimeProvider2) {
        Intrinsics.checkNotNullParameter(isTokenTimeDifferenceEnabledUseCase2, "isTokenTimeDifferenceEnabledUseCase");
        Intrinsics.checkNotNullParameter(deviceTimeProvider2, "deviceTimeProvider");
        this.isTokenTimeDifferenceEnabledUseCase = isTokenTimeDifferenceEnabledUseCase2;
        this.deviceTimeProvider = deviceTimeProvider2;
    }

    /* renamed from: getCorrectedDeviceTime-5sfh64U  reason: not valid java name */
    private final long m9532getCorrectedDeviceTime5sfh64U(Token token) {
        Duration.Companion companion = Duration.Companion;
        long duration = DurationKt.toDuration(this.deviceTimeProvider.invoke(), DurationUnit.MILLISECONDS);
        if (this.isTokenTimeDifferenceEnabledUseCase.invoke()) {
            return Duration.m7652minusLRDsOJo(duration, DurationKt.toDuration(token.getTimeDifference(), DurationUnit.SECONDS));
        }
        return duration;
    }

    public final boolean invoke(@NotNull Token token) {
        Intrinsics.checkNotNullParameter(token, LegacyTokenLocalDataSourceImpl.KEY);
        long r02 = m9532getCorrectedDeviceTime5sfh64U(token);
        Duration.Companion companion = Duration.Companion;
        if (Duration.m7616compareToLRDsOJo(r02, Duration.m7652minusLRDsOJo(DurationKt.toDuration(token.getExpiresIn(), DurationUnit.SECONDS), DurationKt.toDuration(3, DurationUnit.MINUTES))) > 0) {
            return true;
        }
        return false;
    }
}
