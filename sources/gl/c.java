package gl;

import com.talabat.feature.activecarts.domain.usecase.GetActiveCartInfoUseCaseImpl;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetActiveCartInfoUseCaseImpl f62088b;

    public /* synthetic */ c(GetActiveCartInfoUseCaseImpl getActiveCartInfoUseCaseImpl) {
        this.f62088b = getActiveCartInfoUseCaseImpl;
    }

    public final void accept(Object obj) {
        GetActiveCartInfoUseCaseImpl.m10127invoke$lambda5(this.f62088b, (List) obj);
    }
}
