package library.talabat.mvp.homemap.domain.impl;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.address.DistanceSortedAddress;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Llibrary/talabat/mvp/address/DistanceSortedAddress;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/talabat/domain/address/Address;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$4 extends Lambda implements Function1<Pair<? extends Address, ? extends Double>, DistanceSortedAddress> {
    public static final AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$4 INSTANCE = new AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$4();

    public AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$4() {
        super(1);
    }

    @NotNull
    public final DistanceSortedAddress invoke(@NotNull Pair<Address, Double> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return new DistanceSortedAddress(pair.component2().doubleValue(), pair.component1());
    }
}
