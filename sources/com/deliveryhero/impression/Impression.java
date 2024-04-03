package com.deliveryhero.impression;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/deliveryhero/impression/Impression;", "", "payload", "", "", "getPayload", "()Ljava/util/Map;", "getId", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Impression {
    @NotNull
    String getId();

    @NotNull
    Map<String, String> getPayload();
}
