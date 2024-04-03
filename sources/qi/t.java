package qi;

import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class t implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57238c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57239d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57240e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f57241f;

    public /* synthetic */ t(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        this.f57237b = function2;
        this.f57238c = flutterConfigurationParams;
        this.f57239d = str;
        this.f57240e = str2;
        this.f57241f = str3;
    }

    public final Object call() {
        return BuildSwimlanesSearchResultNavigationActionUseCaseImpl.m9763invoke$lambda0(this.f57237b, this.f57238c, this.f57239d, this.f57240e, this.f57241f);
    }
}
