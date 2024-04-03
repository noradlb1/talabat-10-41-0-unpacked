package com.deliveryhero.perseus;

import androidx.annotation.Keep;
import com.huawei.hms.dtm.ICustomTag;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0017¨\u0006\t"}, d2 = {"Lcom/deliveryhero/perseus/DtmPerseusFunctionCall;", "Lcom/huawei/hms/dtm/ICustomTag;", "()V", "call", "", "map", "", "", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class DtmPerseusFunctionCall implements ICustomTag {
    @Keep
    public void call(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        RemoteFunctionKt.onRemoteFunction(map);
    }
}
