package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f56774c;

    public /* synthetic */ c(DiscoveryRepo discoveryRepo, Function1 function1) {
        this.f56773b = discoveryRepo;
        this.f56774c = function1;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9683applyDiscounts$lambda40(this.f56773b, this.f56774c, obj);
    }
}
