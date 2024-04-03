package library.talabat.mvp.homemap.domain.impl;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/talabat/domain/address/Address;", "", "address", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$2 extends Lambda implements Function1<Address, Pair<? extends Address, ? extends Double>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AddressSortHelperImpl f26735g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Pair<Double, Double> f26736h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$2(AddressSortHelperImpl addressSortHelperImpl, Pair<Double, Double> pair) {
        super(1);
        this.f26735g = addressSortHelperImpl;
        this.f26736h = pair;
    }

    @NotNull
    public final Pair<Address, Double> invoke(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return TuplesKt.to(address, Double.valueOf(this.f26735g.homeMapUtils.distanceBetweenTwoCordinatesbet(this.f26736h.getFirst().doubleValue(), this.f26736h.getSecond().doubleValue(), address.latitude, address.longitude)));
    }
}
