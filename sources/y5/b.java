package y5;

import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34838b;

    public /* synthetic */ b(Function1 function1) {
        this.f34838b = function1;
    }

    public final Object apply(Object obj) {
        return DatabaseInfoLogger.logBacklogInfo$lambda$1(this.f34838b, obj);
    }
}
