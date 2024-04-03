package qi;

import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class s implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57236c;

    public /* synthetic */ s(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        this.f57235b = function2;
        this.f57236c = flutterConfigurationParams;
    }

    public final Object call() {
        return BuildSearchNavigationActionUseCaseImpl.m9762invoke$lambda0(this.f57235b, this.f57236c);
    }
}
