package com.talabat.splash.domain.usecase;

import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.interactor.InternalUseCaseWithParamNoReturn;
import com.talabat.splash.domain.model.SplashDataUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetSplashErrorViewUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseWithParamNoReturn;", "Lcom/talabat/splash/core/exception/Failure;", "()V", "getErrorViewType", "", "params", "run", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSplashErrorViewUseCase extends InternalUseCaseWithParamNoReturn<Failure> {
    private final int getErrorViewType(Failure failure) {
        if (failure instanceof Failure.NetworkConnection) {
            return SplashDataUtils.INSTANCE.getNETWORK_ERROR_VEW();
        }
        if (failure instanceof Failure.ServerError) {
            return SplashDataUtils.INSTANCE.getSERVER_ERROR_VIEW();
        }
        if (failure instanceof Failure.BadRequest) {
            return SplashDataUtils.INSTANCE.getSERVER_ERROR_VIEW();
        }
        if (failure instanceof Failure.Unauthorized) {
            return SplashDataUtils.INSTANCE.getUNAUTHORIZED_ERROR_VIEW();
        }
        if (failure instanceof Failure.Forbidden) {
            return SplashDataUtils.INSTANCE.getFORBIDDEN_ERROR_VIEW();
        }
        if (failure instanceof Failure.NotFound) {
            return SplashDataUtils.INSTANCE.getSERVER_ERROR_VIEW();
        }
        if (failure instanceof Failure.InternalServerError) {
            return SplashDataUtils.INSTANCE.getSERVER_ERROR_VIEW();
        }
        if (failure instanceof Failure.UnKnownError) {
            return SplashDataUtils.INSTANCE.getSERVER_ERROR_VIEW();
        }
        if (failure instanceof Failure.TimeOutError) {
            return SplashDataUtils.INSTANCE.getTIMEOUT_ERROR_VIEW();
        }
        return 0;
    }

    @NotNull
    public Object run(@Nullable Failure failure) {
        return Integer.valueOf(getErrorViewType(failure));
    }
}
