package qi;

import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class h implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57207c;

    public /* synthetic */ h(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        this.f57206b = function2;
        this.f57207c = flutterConfigurationParams;
    }

    public final Object call() {
        return BuildBasketUpsellActionUseCaseImpl.m9751invoke$lambda0(this.f57206b, this.f57207c);
    }
}
