package vl;

import com.talabat.feature.darkstores.swimlanes.data.RealSwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlanesData f62961b;

    public /* synthetic */ b(SwimlanesData swimlanesData) {
        this.f62961b = swimlanesData;
    }

    public final Object apply(Object obj) {
        return RealSwimlanesRepository.m10149getSwimlanes$lambda1(this.f62961b, (Throwable) obj);
    }
}
