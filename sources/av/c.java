package av;

import com.talabat.talabatcommon.extentions.KotlinResultKt;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f44473c;

    public /* synthetic */ c(Function1 function1, Function1 function12) {
        this.f44472b = function1;
        this.f44473c = function12;
    }

    public final Object call() {
        return KotlinResultKt.m9351toObservable$lambda1(this.f44472b, this.f44473c);
    }
}
