package com.talabat.userandlocation.login.domain.usecase.business;

import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isSuccess", "", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RefreshCustomerInformationUseCaseKt {
    public static final boolean isSuccess(@NotNull RefreshCustomerInformationUseCase.Result result) {
        Intrinsics.checkNotNullParameter(result, "<this>");
        return Intrinsics.areEqual((Object) result, (Object) RefreshCustomerInformationUseCase.Result.Success.INSTANCE);
    }
}
