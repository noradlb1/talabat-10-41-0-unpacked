package i9;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ClosingFuture;

public final /* synthetic */ class h implements Function {
    public final Object apply(Object obj) {
        return ((ClosingFuture) obj).future;
    }
}
