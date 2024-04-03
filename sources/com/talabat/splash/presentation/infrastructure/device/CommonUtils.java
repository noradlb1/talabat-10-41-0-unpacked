package com.talabat.splash.presentation.infrastructure.device;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/CommonUtils;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "gsonFromJSON", "T", "jsonString", "", "classType", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonUtils {
    @NotNull
    private final Gson gson;

    @Inject
    public CommonUtils(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    public final <T> T gsonFromJSON(@Nullable String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "classType");
        Gson gson2 = this.gson;
        if (!(gson2 instanceof Gson)) {
            return gson2.fromJson(str, cls);
        }
        return GsonInstrumentation.fromJson(gson2, str, cls);
    }
}
