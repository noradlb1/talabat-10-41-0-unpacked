package library.talabat.mvp.addressV2;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Llibrary/talabat/mvp/addressV2/SaveAddressEventsOrigin;", "", "trackerStringValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackerStringValue", "()Ljava/lang/String;", "FROM_CHECKOUT", "FROM_CART", "FROM_FLUTTER_CART", "FROM_ACCOUNT_MENU", "FROM_ORDER_FLOW", "FROM_MCD_ADDRESS_FLOW", "FROM_GRL_FLOW", "UNKNOWN", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SaveAddressEventsOrigin {
    FROM_CHECKOUT("checkout"),
    FROM_CART("cart"),
    FROM_FLUTTER_CART("flutter_cart"),
    FROM_ACCOUNT_MENU("account_menu"),
    FROM_ORDER_FLOW("order_flow"),
    FROM_MCD_ADDRESS_FLOW("mcd_address_flow"),
    FROM_GRL_FLOW("grl_flow"),
    UNKNOWN("unknown");
    
    @NotNull
    private final String trackerStringValue;

    private SaveAddressEventsOrigin(String str) {
        this.trackerStringValue = str;
    }

    @NotNull
    public final String getTrackerStringValue() {
        return this.trackerStringValue;
    }
}
