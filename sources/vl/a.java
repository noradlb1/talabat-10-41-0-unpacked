package vl;

import com.talabat.feature.darkstores.swimlanes.data.RealSwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RealSwimlanesRepository f62958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwimlanesRequest f62959c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwimlanesData f62960d;

    public /* synthetic */ a(RealSwimlanesRepository realSwimlanesRepository, SwimlanesRequest swimlanesRequest, SwimlanesData swimlanesData) {
        this.f62958b = realSwimlanesRepository;
        this.f62959c = swimlanesRequest;
        this.f62960d = swimlanesData;
    }

    public final Object apply(Object obj) {
        return RealSwimlanesRepository.m10148getSwimlanes$lambda0(this.f62958b, this.f62959c, this.f62960d, (SwimlanesResponse) obj);
    }
}
