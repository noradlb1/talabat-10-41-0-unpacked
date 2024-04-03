package library.talabat.mvp.homemap.domain.impl;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.address.DistanceSortedAddress;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/talabat/domain/address/Address;", "kotlin.jvm.PlatformType", "sortedDistance", "Llibrary/talabat/mvp/address/DistanceSortedAddress;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$6 extends Lambda implements Function1<DistanceSortedAddress, Address> {
    public static final AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$6 INSTANCE = new AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$6();

    public AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$6() {
        super(1);
    }

    public final Address invoke(@NotNull DistanceSortedAddress distanceSortedAddress) {
        Intrinsics.checkNotNullParameter(distanceSortedAddress, "sortedDistance");
        return distanceSortedAddress.address;
    }
}
