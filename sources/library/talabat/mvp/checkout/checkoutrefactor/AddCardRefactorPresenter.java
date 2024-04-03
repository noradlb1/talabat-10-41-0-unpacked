package library.talabat.mvp.checkout.checkoutrefactor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/checkout/checkoutrefactor/AddCardRefactorPresenter;", "Llibrary/talabat/mvp/checkout/checkoutrefactor/IAddCardRefactorPresenter;", "()V", "getScreenName", "", "isNavigationFromKNetFallback", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddCardRefactorPresenter implements IAddCardRefactorPresenter {
    @NotNull
    public String getScreenName(boolean z11) {
        return z11 ? ScreenNames.CHECKOUT_DOT_COM_SCREEN_DEBIT : ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT;
    }
}
