package com.instabug.library.diagnostics.customtraces.network;

import com.instabug.library.diagnostics.customtraces.utils.a;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class b implements a {
    @NotNull
    public JSONObject a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "traces");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dv", (Object) InstabugDeviceProperties.getDeviceType());
        jSONObject.put("os", InstabugDeviceProperties.getCurrentOSLevel());
        jSONObject.put("tl", (Object) a.a(list));
        return jSONObject;
    }
}
