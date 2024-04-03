package qi;

import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class p implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57226c;

    public /* synthetic */ p(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        this.f57225b = function2;
        this.f57226c = flutterConfigurationParams;
    }

    public final Object call() {
        return BuildDeliveryFeeTierNavigationUseCaseImpl.m9759invoke$lambda0(this.f57225b, this.f57226c);
    }
}
