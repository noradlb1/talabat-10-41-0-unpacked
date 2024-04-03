package df;

import com.talabat.AddressList;
import com.talabat.address.list.AddressListComponent;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        AddressListComponent.Companion companion = AddressListComponent.Companion;
    }

    @JvmStatic
    public static void a(@NotNull AddressList addressList) {
        AddressListComponent.Companion.injectToScreen(addressList);
    }
}
