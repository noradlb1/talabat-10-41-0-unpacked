package com.instabug.commons.threading;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

final class n extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final n f46364a = new n();

    public n() {
        super(1);
    }

    /* renamed from: a */
    public final JSONObject invoke(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "threadData");
        return new JSONObject().put("thread", (Object) jSONObject);
    }
}
