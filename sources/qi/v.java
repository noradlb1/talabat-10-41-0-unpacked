package qi;

import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class v implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57247b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57248c;

    public /* synthetic */ v(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        this.f57247b = function2;
        this.f57248c = flutterConfigurationParams;
    }

    public final Object call() {
        return BuildTalabatAiNavigationActionUseCaseImpl.m9765invoke$lambda0(this.f57247b, this.f57248c);
    }
}
