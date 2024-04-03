package ht;

import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {
    public final Object apply(Object obj) {
        return LogManager.logException((Throwable) obj);
    }
}
