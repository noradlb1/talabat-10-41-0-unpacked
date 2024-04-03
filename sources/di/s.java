package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f56717b;

    public /* synthetic */ s(List list) {
        this.f56717b = list;
    }

    public final Object call() {
        return DarkstoresRepo.m9667getCampaignForProduct$lambda13$lambda12(this.f56717b);
    }
}
