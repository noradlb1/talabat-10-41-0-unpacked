package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/ICheckoutKit;", "", "createCardToken", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "checkoutCard", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutCard;", "verticalId", "", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutCard;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICheckoutKit {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object createCardToken$default(ICheckoutKit iCheckoutKit, CheckoutCard checkoutCard, Integer num, Continuation continuation, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    num = null;
                }
                return iCheckoutKit.createCardToken(checkoutCard, num, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCardToken");
        }
    }

    @Nullable
    Object createCardToken(@NotNull CheckoutCard checkoutCard, @Nullable Integer num, @NotNull Continuation<? super CheckoutResponse> continuation);
}
