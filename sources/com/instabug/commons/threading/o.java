package com.instabug.commons.threading;

import android.os.Looper;
import com.instabug.commons.logging.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class o {
    public static /* synthetic */ Pair a(Thread thread, int i11, boolean z11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            function1 = l.f46361a;
        }
        return a(thread, i11, z11, function1);
    }

    public static final boolean a(@NotNull Thread thread, @Nullable Thread thread2) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        return thread == thread2;
    }

    public static final boolean b(@NotNull Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        if (Looper.getMainLooper() == null || thread != Looper.getMainLooper().getThread()) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final Pair a(@NotNull Thread thread, int i11, boolean z11, @NotNull Function1 function1) {
        List list;
        int i12;
        boolean z12;
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(function1, "preElements");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        StringBuilder sb2 = new StringBuilder();
        function1.invoke(sb2);
        if (i11 >= 0) {
            Intrinsics.checkNotNullExpressionValue(stackTrace, "");
            list = ArraysKt___ArraysKt.take((T[]) stackTrace, i11);
        } else {
            Intrinsics.checkNotNullExpressionValue(stackTrace, "this");
            list = ArraysKt___ArraysKt.toList((T[]) stackTrace);
        }
        Iterator it = list.iterator();
        while (true) {
            i12 = 0;
            z12 = true;
            if (!it.hasNext()) {
                break;
            }
            String format = String.format("\t at %s\n", Arrays.copyOf(new Object[]{(StackTraceElement) it.next()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            sb2.append(format);
        }
        String sb3 = sb2.toString();
        Integer valueOf = Integer.valueOf(i11);
        Integer num = null;
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            Integer valueOf2 = Integer.valueOf(stackTrace.length - valueOf.intValue());
            if (valueOf2.intValue() >= 0) {
                z12 = false;
            }
            if (!z12) {
                num = valueOf2;
            }
            if (num != null) {
                i12 = num.intValue();
            }
        }
        if (z11) {
            a.b("For thread " + thread + ": original frames' count = " + stackTrace.length + ", dropped frames' count = " + i12);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("For thread ");
            sb4.append(thread);
            sb4.append(": latest original frame = ");
            Intrinsics.checkNotNullExpressionValue(stackTrace, "trace");
            sb4.append(ArraysKt___ArraysKt.firstOrNull((T[]) stackTrace));
            sb4.append(", oldest original frame = ");
            sb4.append(ArraysKt___ArraysKt.lastOrNull((T[]) stackTrace));
            a.b(sb4.toString());
        }
        return new Pair(sb3, Integer.valueOf(i12));
    }

    @NotNull
    public static final JSONObject a(@NotNull Thread thread) throws JSONException {
        JSONObject a11;
        Intrinsics.checkNotNullParameter(thread, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("threadName", (Object) thread.getName());
        jSONObject.put("threadId", thread.getId());
        jSONObject.put("threadPriority", thread.getPriority());
        jSONObject.put("threadState", (Object) thread.getState().toString());
        ThreadGroup threadGroup = thread.getThreadGroup();
        if (!(threadGroup == null || (a11 = a(threadGroup)) == null)) {
            jSONObject.put("threadGroup", (Object) a11);
        }
        return jSONObject;
    }

    @NotNull
    public static final JSONObject a(@NotNull Thread thread, @Nullable Thread thread2, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        JSONObject a11 = a(thread);
        a11.put("isMain", b(thread));
        boolean a12 = a(thread, thread2);
        Pair a13 = a(thread, i11, z11 || a12, (Function1) null, 4, (Object) null);
        int intValue = ((Number) a13.component2()).intValue();
        a11.put("stackTrace", (Object) (String) a13.component1());
        a11.put("droppedFrames", intValue);
        a11.put("isCrashing", a12);
        return a11;
    }

    @NotNull
    public static final JSONObject a(@NotNull ThreadGroup threadGroup) throws JSONException {
        Intrinsics.checkNotNullParameter(threadGroup, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object) threadGroup.getName());
        jSONObject.put("maxPriority", threadGroup.getMaxPriority());
        jSONObject.put("activeCount", threadGroup.activeCount());
        return jSONObject;
    }

    @NotNull
    public static final JSONArray a(@NotNull Set set, @Nullable Thread thread, int i11) {
        Object obj;
        Intrinsics.checkNotNullParameter(set, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            Sequence<JSONObject> map = SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.mapIndexed(CollectionsKt___CollectionsKt.asSequence(set), new m(thread, i11)), n.f46364a);
            JSONArray jSONArray = new JSONArray();
            for (JSONObject put : map) {
                jSONArray = jSONArray.put((Object) put);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "threadsList.put(threadObject)");
            }
            obj = Result.m6329constructorimpl(jSONArray);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (JSONArray) a.a(obj, new JSONArray(), "Failed parsing threads data", false, 4, (Object) null);
    }
}
