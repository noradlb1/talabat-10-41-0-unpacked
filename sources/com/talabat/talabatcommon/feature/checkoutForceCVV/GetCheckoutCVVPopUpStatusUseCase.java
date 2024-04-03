package com.talabat.talabatcommon.feature.checkoutForceCVV;

import com.talabat.talabatcommon.feature.checkoutForceCVV.repository.CheckoutForceCVVRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutForceCVV/GetCheckoutCVVPopUpStatusUseCase;", "", "checkoutForceCVVRepository", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/repository/CheckoutForceCVVRepository;", "(Lcom/talabat/talabatcommon/feature/checkoutForceCVV/repository/CheckoutForceCVVRepository;)V", "invoke", "", "binNumber", "", "orderAmount", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCheckoutCVVPopUpStatusUseCase {
    @NotNull
    private final CheckoutForceCVVRepository checkoutForceCVVRepository;

    public GetCheckoutCVVPopUpStatusUseCase(@NotNull CheckoutForceCVVRepository checkoutForceCVVRepository2) {
        Intrinsics.checkNotNullParameter(checkoutForceCVVRepository2, "checkoutForceCVVRepository");
        this.checkoutForceCVVRepository = checkoutForceCVVRepository2;
    }

    @Nullable
    public final Object invoke(@Nullable String str, float f11, @NotNull Continuation<? super Boolean> continuation) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Boxing.boxBoolean(false);
        }
        return this.checkoutForceCVVRepository.getCheckoutCVVPopUpStatus(str, f11, continuation);
    }
}
