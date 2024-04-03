package com.talabat.talabatremoteconfiguration.datasource.fwf;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\r¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/datasource/fwf/FwfRemoteConfigurationParser;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "tag", "", "kotlin.jvm.PlatformType", "getTheVariationValue", "T", "updatedValue", "defaultValue", "classType", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "isNumberAs", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FwfRemoteConfigurationParser {
    @NotNull
    private final Gson gson;
    private final String tag;

    public FwfRemoteConfigurationParser() {
        this((Gson) null, 1, (DefaultConstructorMarker) null);
    }

    public FwfRemoteConfigurationParser(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
        this.tag = FwfRemoteConfigurationParser.class.getSimpleName();
    }

    private final <T> boolean isNumberAs(Object obj, T t11) {
        if (!(obj instanceof Number) || (!(t11 instanceof Integer) && !(t11 instanceof Double) && !(t11 instanceof Float))) {
            return false;
        }
        return true;
    }

    public final <T> T getTheVariationValue(@NotNull T t11, T t12, @NotNull Class<T> cls) {
        T t13;
        T t14;
        Intrinsics.checkNotNullParameter(t11, "updatedValue");
        Intrinsics.checkNotNullParameter(cls, "classType");
        try {
            Result.Companion companion = Result.Companion;
            Gson gson2 = this.gson;
            String str = (String) t11;
            if (!(gson2 instanceof Gson)) {
                t14 = gson2.fromJson(str, cls);
            } else {
                t14 = GsonInstrumentation.fromJson(gson2, str, cls);
            }
            t13 = Result.m6329constructorimpl(t14);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            t13 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(t13);
        if (r12 != null) {
            String str2 = this.tag;
            LogManager.error(r12, str2 + " fail to parse FWF variation");
        }
        if (Result.m6332exceptionOrNullimpl(t13) == null) {
            return t13;
        }
        if (!cls.isAssignableFrom(t11.getClass()) && !isNumberAs(t11, t12) && (!(t11 instanceof Boolean) || !(t12 instanceof Boolean))) {
            String str3 = this.tag;
            LogManager.error$default((Throwable) null, str3 + " fail to parse FWF variation", 1, (Object) null);
            t11 = t12;
        }
        return t11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FwfRemoteConfigurationParser(Gson gson2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new Gson() : gson2);
    }
}
