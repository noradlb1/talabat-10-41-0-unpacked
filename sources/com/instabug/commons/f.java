package com.instabug.commons;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.RequiresApi;
import com.instabug.commons.logging.a;
import com.instabug.commons.preferences.b;
import com.instabug.commons.preferences.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@RequiresApi(30)
public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f46328b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(f.class, "timeBaseline", "getTimeBaseline()J", 0))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final b f46329a;

    public f(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "baselinePrefSpec");
        this.f46329a = c.a(pair);
    }

    private final long a() {
        return ((Number) this.f46329a.getValue(this, f46328b[0])).longValue();
    }

    private final void a(long j11) {
        this.f46329a.setValue(this, f46328b[0], Long.valueOf(j11));
    }

    @NotNull
    public final e a(@NotNull Context context) {
        Object obj;
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "ctx");
        long a11 = a();
        a(System.currentTimeMillis());
        try {
            Result.Companion companion = Result.Companion;
            List c11 = com.instabug.commons.utils.b.c(context);
            ArrayList<ApplicationExitInfo> arrayList = new ArrayList<>();
            Iterator it = c11.iterator();
            while (true) {
                z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((ApplicationExitInfo) next).getTimestamp() <= a11) {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(next);
                }
            }
            if (a11 < 0) {
                z11 = false;
            }
            e eVar = null;
            if (!z11) {
                arrayList = null;
            }
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                for (ApplicationExitInfo a12 : arrayList) {
                    arrayList2.add(a(a12));
                }
                eVar = new e(a11, a(), arrayList2);
            }
            if (eVar == null) {
                eVar = new e(a11, a(), CollectionsKt__CollectionsKt.emptyList());
            }
            obj = Result.m6329constructorimpl(eVar);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (e) a.a(obj, new e(a11, a(), CollectionsKt__CollectionsKt.emptyList()), "Couldn't extract OS exit info", false);
    }

    private final d a(ApplicationExitInfo applicationExitInfo) {
        return new d(applicationExitInfo.getReason(), applicationExitInfo.getTimestamp(), applicationExitInfo.getImportance());
    }
}
