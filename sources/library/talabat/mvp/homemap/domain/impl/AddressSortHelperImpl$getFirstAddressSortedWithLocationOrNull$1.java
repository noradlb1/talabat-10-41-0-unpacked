package library.talabat.mvp.homemap.domain.impl;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "address", "Lcom/talabat/domain/address/Address;", "invoke", "(Lcom/talabat/domain/address/Address;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$1 extends Lambda implements Function1<Address, Boolean> {
    public static final AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$1 INSTANCE = new AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$1();

    public AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return Boolean.valueOf(address.latitude > 0.0d && address.longitude > 0.0d);
    }
}
