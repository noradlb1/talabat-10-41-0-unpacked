package com.talabat.talabatcommon.extentions;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001H\b\u001a$\u0010\u000b\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\f\u001a\u001f\u0010\r\u001a\u00020\t\"\u0004\b\u0000\u0010\b*\u0002H\b2\b\b\u0002\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000e\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000f"}, d2 = {"Gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Gson$delegate", "Lkotlin/Lazy;", "toEntitiesList", "", "T", "", "gson", "toEntity", "(Ljava/lang/String;Lcom/google/gson/Gson;)Ljava/lang/Object;", "toJson", "(Ljava/lang/Object;Lcom/google/gson/Gson;)Ljava/lang/String;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GsonKt {
    @NotNull
    private static final Lazy Gson$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, GsonKt$Gson$2.INSTANCE);

    @NotNull
    public static final Gson getGson() {
        return (Gson) Gson$delegate.getValue();
    }

    public static final /* synthetic */ <T> List<T> toEntitiesList(String str, Gson gson) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        Type type = new GsonKt$toEntitiesList$1().getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(str, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, type);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "gson.fromJson<ArrayList<…<ArrayList<T>>() {}.type)");
        return (List) obj;
    }

    public static /* synthetic */ List toEntitiesList$default(String str, Gson gson, int i11, Object obj) {
        Object obj2;
        if ((i11 & 1) != 0) {
            gson = getGson();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        Type type = new GsonKt$toEntitiesList$1().getType();
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(str, type);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, str, type);
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "gson.fromJson<ArrayList<…<ArrayList<T>>() {}.type)");
        return (List) obj2;
    }

    public static final /* synthetic */ <T> T toEntity(String str, Gson gson) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        if (!(gson instanceof Gson)) {
            return gson.fromJson(str, cls);
        }
        return GsonInstrumentation.fromJson(gson, str, cls);
    }

    public static /* synthetic */ Object toEntity$default(String str, Gson gson, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gson = getGson();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        return !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
    }

    @NotNull
    public static final <T> String toJson(T t11, @NotNull Gson gson) {
        String str;
        Intrinsics.checkNotNullParameter(gson, "gson");
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) t11);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) t11);
        }
        Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(this)");
        return str;
    }

    public static /* synthetic */ String toJson$default(Object obj, Gson gson, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            gson = getGson();
        }
        return toJson(obj, gson);
    }
}
