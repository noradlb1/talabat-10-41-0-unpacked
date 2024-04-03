package qi;

import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class l implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57214c;

    public /* synthetic */ l(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        this.f57213b = function2;
        this.f57214c = flutterConfigurationParams;
    }

    public final Object call() {
        return BuildCartNavigationActionUseCaseImpl.m9755invoke$lambda3$lambda1(this.f57213b, this.f57214c);
    }
}
