package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class y implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f56818c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f56819d;

    public /* synthetic */ y(DiscoveryRepo discoveryRepo, Function1 function1, Object obj) {
        this.f56817b = discoveryRepo;
        this.f56818c = function1;
        this.f56819d = obj;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9684applyDiscounts$lambda40$lambda39(this.f56817b, this.f56818c, this.f56819d, (List) obj);
    }
}
