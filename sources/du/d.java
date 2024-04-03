package du;

import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCollectionUseCase f61959b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GetCollectionUseCase.RequestValues f61960c;

    public /* synthetic */ d(GetCollectionUseCase getCollectionUseCase, GetCollectionUseCase.RequestValues requestValues) {
        this.f61959b = getCollectionUseCase;
        this.f61960c = requestValues;
    }

    public final Object apply(Object obj) {
        return GetCollectionUseCase.m10792executeUseCase$lambda8$lambda7(this.f61959b, this.f61960c, (List) obj);
    }
}
