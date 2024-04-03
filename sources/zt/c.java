package zt;

import com.talabat.sdsquad.domain.cuisines.GetCuisinesUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCuisinesUseCase.RequestValues f63129b;

    public /* synthetic */ c(GetCuisinesUseCase.RequestValues requestValues) {
        this.f63129b = requestValues;
    }

    public final Object apply(Object obj) {
        return GetCuisinesUseCase.m10783executeUseCase$lambda3(this.f63129b, (List) obj);
    }
}
