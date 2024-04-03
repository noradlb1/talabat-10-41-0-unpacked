package gx;

import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import io.reactivex.Single;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        VerifyLoginPasswordUseCase.Companion companion = VerifyLoginPasswordUseCase.Companion;
    }

    @JvmStatic
    @NotNull
    public static Single<VerifyLoginPasswordUseCase.Result> a(@NotNull VerifyLoginPasswordUseCase verifyLoginPasswordUseCase, @NotNull String str, @NotNull String str2) {
        return VerifyLoginPasswordUseCase.Companion.verifyLoginPasswordSingle(verifyLoginPasswordUseCase, str, str2);
    }
}
