package zt;

import com.talabat.sdsquad.domain.cuisines.GetCuisinesUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCuisinesUseCase f63128b;

    public /* synthetic */ a(GetCuisinesUseCase getCuisinesUseCase) {
        this.f63128b = getCuisinesUseCase;
    }

    public final Object apply(Object obj) {
        return GetCuisinesUseCase.m10781executeUseCase$lambda1(this.f63128b, (List) obj);
    }
}
