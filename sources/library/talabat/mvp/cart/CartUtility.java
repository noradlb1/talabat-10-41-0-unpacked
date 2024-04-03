package library.talabat.mvp.cart;

import datamodels.CartMenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH&J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H&¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/cart/CartUtility;", "", "addItem", "", "item", "Ldatamodels/CartMenuItem;", "branchId", "", "deliveryMode", "", "clearCart", "setCurrentCartId", "cartId", "callback", "Lkotlin/Function1;", "", "updateQuantity", "menuItemId", "specialRequest", "updatedQuantity", "choices", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CartUtility {
    void addItem(@NotNull CartMenuItem cartMenuItem, int i11, @NotNull String str);

    void clearCart();

    void setCurrentCartId(int i11, @NotNull Function1<? super Boolean, Unit> function1);

    void updateQuantity(int i11, @NotNull String str, int i12, @NotNull List<Integer> list);
}
