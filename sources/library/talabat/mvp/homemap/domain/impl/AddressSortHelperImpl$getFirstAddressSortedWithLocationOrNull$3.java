package library.talabat.mvp.homemap.domain.impl;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/talabat/domain/address/Address;", "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$3 extends Lambda implements Function1<Pair<? extends Address, ? extends Double>, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f26737g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressSortHelperImpl$getFirstAddressSortedWithLocationOrNull$3(int i11) {
        super(1);
        this.f26737g = i11;
    }

    @NotNull
    public final Boolean invoke(@NotNull Pair<Address, Double> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return Boolean.valueOf(pair.component2().doubleValue() < ((double) this.f26737g));
    }
}
