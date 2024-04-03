package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class v implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56812b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f56813c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f56814d;

    public /* synthetic */ v(DiscoveryRepo discoveryRepo, Function1 function1, Object obj) {
        this.f56812b = discoveryRepo;
        this.f56813c = function1;
        this.f56814d = obj;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9682applyCampaignTriggers$lambda42$lambda41(this.f56812b, this.f56813c, this.f56814d, (List) obj);
    }
}
