package av;

import com.talabat.talabatcommon.extentions.KotlinResultKt;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44470b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f44471c;

    public /* synthetic */ b(Function1 function1, Function1 function12) {
        this.f44470b = function1;
        this.f44471c = function12;
    }

    public final Object call() {
        return KotlinResultKt.m9352toSingle$lambda3(this.f44470b, this.f44471c);
    }
}
