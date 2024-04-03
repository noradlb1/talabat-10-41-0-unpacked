package com.deliveryhero.perseus.utils;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\t"}, d2 = {"Lcom/deliveryhero/perseus/utils/EventVariablesJsonSerializer;", "", "()V", "fromJson", "", "", "json", "toJson", "eventVariables", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventVariablesJsonSerializer {
    @NotNull
    public static final EventVariablesJsonSerializer INSTANCE = new EventVariablesJsonSerializer();

    private EventVariablesJsonSerializer() {
    }

    @NotNull
    public final Map<String, String> fromJson(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        Object fromJson = GsonInstrumentation.fromJson(new Gson(), str, new EventVariablesJsonSerializer$fromJson$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(json, ob…ring, String>>() {}.type)");
        return (Map) fromJson;
    }

    @NotNull
    public final String toJson(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "eventVariables");
        String json = GsonInstrumentation.toJson(new Gson(), (Object) map);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(eventVariables)");
        return json;
    }
}
