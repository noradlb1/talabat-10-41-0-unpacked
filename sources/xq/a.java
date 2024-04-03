package xq;

import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        LogManager.logException((Throwable) obj);
    }
}
