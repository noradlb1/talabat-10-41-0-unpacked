package com.deliveryhero.perseus;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002¨\u0006\u0006"}, d2 = {"onRemoteFunction", "", "map", "", "", "", "perseus_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RemoteFunctionKt {
    /* access modifiers changed from: private */
    public static final void onRemoteFunction(Map<String, ? extends Object> map) {
        if (!map.isEmpty()) {
            synchronized (PerseusApp.class) {
                PerseusApp.execute(map);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
