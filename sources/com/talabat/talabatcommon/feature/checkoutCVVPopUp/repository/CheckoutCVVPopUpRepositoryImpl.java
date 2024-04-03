package com.talabat.talabatcommon.feature.checkoutCVVPopUp.repository;

import com.talabat.talabatcommon.feature.checkoutCVVPopUp.dao.CheckoutCVVPopUpDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/repository/CheckoutCVVPopUpRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/repository/CheckoutCVVPopUpRepository;", "checkoutCVVPopUpDao", "Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/dao/CheckoutCVVPopUpDao;", "(Lcom/talabat/talabatcommon/feature/checkoutCVVPopUp/dao/CheckoutCVVPopUpDao;)V", "getCheckoutCVVPopUpStatus", "", "binNumber", "", "orderAmount", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutCVVPopUpRepositoryImpl implements CheckoutCVVPopUpRepository {
    @NotNull
    private final CheckoutCVVPopUpDao checkoutCVVPopUpDao;

    public CheckoutCVVPopUpRepositoryImpl(@NotNull CheckoutCVVPopUpDao checkoutCVVPopUpDao2) {
        Intrinsics.checkNotNullParameter(checkoutCVVPopUpDao2, "checkoutCVVPopUpDao");
        this.checkoutCVVPopUpDao = checkoutCVVPopUpDao2;
    }

    @Nullable
    public Object getCheckoutCVVPopUpStatus(@NotNull String str, float f11, @NotNull Continuation<? super Boolean> continuation) {
        return this.checkoutCVVPopUpDao.getCheckoutCVVPopUpStatus(str, f11, continuation);
    }
}
