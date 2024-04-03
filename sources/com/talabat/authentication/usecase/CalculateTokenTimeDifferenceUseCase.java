package com.talabat.authentication.usecase;

import com.talabat.authentication.token.data.model.JwtPayload;
import com.talabat.authentication.token.data.remote.impl.JwtPayloadDecoder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/authentication/usecase/CalculateTokenTimeDifferenceUseCase;", "", "isTokenTimeDifferenceEnabledUseCase", "Lcom/talabat/authentication/usecase/IsTokenTimeDifferenceEnabledUseCase;", "deviceTimeProvider", "Lcom/talabat/authentication/usecase/DeviceTimeProvider;", "jwtPayloadDecoder", "Lcom/talabat/authentication/token/data/remote/impl/JwtPayloadDecoder;", "(Lcom/talabat/authentication/usecase/IsTokenTimeDifferenceEnabledUseCase;Lcom/talabat/authentication/usecase/DeviceTimeProvider;Lcom/talabat/authentication/token/data/remote/impl/JwtPayloadDecoder;)V", "invoke", "", "accessToken", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CalculateTokenTimeDifferenceUseCase {
    @NotNull
    private final DeviceTimeProvider deviceTimeProvider;
    @NotNull
    private final IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase;
    @NotNull
    private final JwtPayloadDecoder jwtPayloadDecoder;

    @Inject
    public CalculateTokenTimeDifferenceUseCase(@NotNull IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase2, @NotNull DeviceTimeProvider deviceTimeProvider2, @NotNull JwtPayloadDecoder jwtPayloadDecoder2) {
        Intrinsics.checkNotNullParameter(isTokenTimeDifferenceEnabledUseCase2, "isTokenTimeDifferenceEnabledUseCase");
        Intrinsics.checkNotNullParameter(deviceTimeProvider2, "deviceTimeProvider");
        Intrinsics.checkNotNullParameter(jwtPayloadDecoder2, "jwtPayloadDecoder");
        this.isTokenTimeDifferenceEnabledUseCase = isTokenTimeDifferenceEnabledUseCase2;
        this.deviceTimeProvider = deviceTimeProvider2;
        this.jwtPayloadDecoder = jwtPayloadDecoder2;
    }

    public final long invoke(@NotNull String str) {
        JwtPayload invoke;
        Intrinsics.checkNotNullParameter(str, "accessToken");
        if (!this.isTokenTimeDifferenceEnabledUseCase.invoke() || (invoke = this.jwtPayloadDecoder.invoke(str)) == null) {
            return 0;
        }
        Duration.Companion companion = Duration.Companion;
        long r32 = Duration.m7638getInWholeSecondsimpl(DurationKt.toDuration(this.deviceTimeProvider.invoke(), DurationUnit.MILLISECONDS)) - invoke.getIat();
        boolean z11 = false;
        if (-60 <= r32 && r32 < 61) {
            z11 = true;
        }
        if (z11) {
            return 0;
        }
        return r32;
    }
}
