package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class o implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Single f56803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1 f56804d;

    public /* synthetic */ o(DiscoveryRepo discoveryRepo, Single single, Function1 function1) {
        this.f56802b = discoveryRepo;
        this.f56803c = single;
        this.f56804d = function1;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9681applyCampaignTriggers$lambda42(this.f56802b, this.f56803c, this.f56804d, obj);
    }
}
