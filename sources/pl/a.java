package pl;

import com.talabat.feature.bnplcore.domain.model.Overdues;
import com.talabat.feature.bnplcore.domain.usecase.impl.GetOverdueUseCaseImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return GetOverdueUseCaseImpl.m10143getOverdues$lambda0((Overdues) obj);
    }
}
