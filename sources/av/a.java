package av;

import com.talabat.talabatcommon.extentions.KotlinResultKt;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f44468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f44469c;

    public /* synthetic */ a(Function1 function1, Function1 function12) {
        this.f44468b = function1;
        this.f44469c = function12;
    }

    public final Object call() {
        return KotlinResultKt.m9350toMaybe$lambda5(this.f44468b, this.f44469c);
    }
}
