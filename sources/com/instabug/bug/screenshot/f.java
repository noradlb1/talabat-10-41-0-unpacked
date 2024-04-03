package com.instabug.bug.screenshot;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.braze.models.FeatureFlag;
import com.instabug.bug.n;
import com.instabug.bug.screenshot.viewhierarchy.b;
import com.instabug.bug.screenshot.viewhierarchy.e;
import com.instabug.library.R;
import com.instabug.library.instacapture.screenshot.FieldHelper;
import com.instabug.library.instacapture.screenshot.RootViewInfo;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yb.a;
import yb.c;
import yb.d;
import yb.g;

@Instrumented
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45734a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45735b = true;

    static {
        new a((DefaultConstructorMarker) null);
    }

    private final int a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        int max = Math.max(decorView.getHeight(), decorView.getWidth());
        if (max > 640) {
            return max / 640;
        }
        return 1;
    }

    private final JSONObject a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (bVar.c() != null) {
                jSONObject.put("id", (Object) bVar.c());
            }
            if (bVar.b() != null) {
                jSONObject.put("icon", (Object) bVar.b());
            }
            if (bVar.k() != null) {
                jSONObject.put("type", (Object) bVar.k());
            }
            if (bVar.i() != null) {
                jSONObject.put(FeatureFlag.PROPERTIES, (Object) bVar.i());
            }
            if (bVar.a() != null) {
                jSONObject.put(TypedValues.AttributesType.S_FRAME, (Object) bVar.a());
            }
            if (bVar.f() != null && bVar.n()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = bVar.f().iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) it.next();
                    Intrinsics.checkNotNullExpressionValue(bVar2, "child");
                    jSONArray.put((Object) a(bVar2));
                }
                jSONObject.put("nodes", (Object) jSONArray);
            }
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-BR", Intrinsics.stringPlus("Converting view hierarchy to json got json exception: ", e11.getMessage()), e11);
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity, b bVar, Function0 function0) {
        PoolProvider.postIOTask(new yb.f(bVar, activity, function0));
    }

    private final void a(Activity activity, ArrayList arrayList, b bVar, Function1 function1) {
        PoolProvider.postIOTask(new d(this, arrayList, bVar, activity, function1));
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity, List list, Function0 function0) {
        PoolProvider.postMainThreadTask(new c(this, list, activity, function0));
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, b bVar, Function0 function0) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(bVar, "$viewHierarchy");
        Intrinsics.checkNotNullParameter(function0, "$onTaskCompletedCallback");
        if (!fVar.f45734a) {
            if (bVar.d() != null) {
                InstabugSDKLogger.v("ActivityViewInspectorTask", Intrinsics.stringPlus("Started saving image on disk, viewHierarchyId: ", bVar.c()));
                com.instabug.bug.screenshot.viewhierarchy.utilities.d.a(bVar);
                bVar.p();
                InstabugSDKLogger.v("ActivityViewInspectorTask", Intrinsics.stringPlus("view hierarchy image saved successfully, uri: ", bVar.e()));
            }
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, ArrayList arrayList, b bVar, Activity activity, Function1 function1) {
        b bVar2;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(arrayList, "$rootViewsReturnableExecutables");
        Intrinsics.checkNotNullParameter(bVar, "$rootViewHierarchy");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(function1, "$callback");
        if (!fVar.f45734a) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    bVar2 = (b) ((ReturnableExecutable) it.next()).execute();
                } catch (Exception unused) {
                    bVar2 = null;
                }
                bVar.a(bVar2);
                if (!MemoryUtils.isLowMemory(activity)) {
                    List b11 = e.b(bVar2);
                    Intrinsics.checkNotNullExpressionValue(b11, "convertViewHierarchyToLi…                        )");
                    arrayList2.addAll(b11);
                }
            }
            function1.invoke(arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, List list, Activity activity, Function0 function0) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(list, "$flatViewHierarchies");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(function0, "$onTaskCompletedCallback");
        if (!fVar.f45734a) {
            if (!list.isEmpty()) {
                b bVar = (b) list.get(0);
                if (!MemoryUtils.isLowMemory(activity)) {
                    b b11 = com.instabug.bug.screenshot.viewhierarchy.utilities.c.b(bVar);
                    Intrinsics.checkNotNullExpressionValue(b11, "captureViewHierarchy(\n  …chy\n                    )");
                    fVar.a(b11, (Function0) new b(fVar, activity, list, function0));
                    return;
                }
                return;
            }
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar, Activity activity, Function0 function0) {
        com.instabug.bug.model.d c11;
        Intrinsics.checkNotNullParameter(bVar, "$seedViewHierarchy");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(function0, "$onTaskCompletedCallback");
        Uri b11 = com.instabug.bug.screenshot.viewhierarchy.utilities.d.b(bVar);
        if (b11 != null) {
            InstabugSDKLogger.v("IBG-BR", "viewHierarchy images zipped successfully, zip file uri: " + b11 + ", time in MS: " + System.currentTimeMillis());
        }
        if (!(n.e().c() == null || b11 == null || (c11 = n.e().c()) == null)) {
            c11.a(b11, Attachment.Type.VIEW_HIERARCHY);
        }
        DiskUtils.cleanDirectory(com.instabug.bug.screenshot.viewhierarchy.utilities.d.a((Context) activity));
        function0.invoke();
    }

    private final void a(b bVar, Function0 function0) {
        PoolProvider.postIOTask(new g(this, bVar, function0));
    }

    /* access modifiers changed from: private */
    public static final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        DiskUtils.cleanDirectory(com.instabug.bug.screenshot.viewhierarchy.utilities.d.a(context));
    }

    /* access modifiers changed from: private */
    public static final void b(f fVar, b bVar) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(bVar, "$rootViewHierarchy");
        InstabugSDKLogger.v("IBG-BR", "Activity view inspection done successfully");
        if (n.e().c() != null) {
            com.instabug.bug.model.d c11 = n.e().c();
            Intrinsics.checkNotNull(c11);
            JSONObject a11 = fVar.a(bVar);
            c11.g(!(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11));
            if (n.e().c() != null) {
                com.instabug.bug.model.d c12 = n.e().c();
                Intrinsics.checkNotNull(c12);
                c12.a(com.instabug.bug.model.c.DONE);
                com.instabug.bug.screenshot.viewhierarchy.utilities.e.a().post(com.instabug.bug.screenshot.viewhierarchy.d.COMPLETED);
                fVar.f45735b = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(b bVar) {
        PoolProvider.postIOTask(new yb.b(this, bVar));
    }

    /* access modifiers changed from: private */
    public static final void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DiskUtils.cleanDirectory(com.instabug.bug.screenshot.viewhierarchy.utilities.d.a((Context) activity));
    }

    public final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f45735b) {
            InstabugSDKLogger.d("IBG-BR", "CancelViewInspection called");
            this.f45734a = true;
            PoolProvider.postIOTask(new a(context));
        }
    }

    public final void b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (n.e().c() != null) {
            com.instabug.bug.model.d c11 = n.e().c();
            Intrinsics.checkNotNull(c11);
            c11.a(com.instabug.bug.model.c.IN_PROGRESS);
        }
        com.instabug.bug.screenshot.viewhierarchy.utilities.e.a().post(com.instabug.bug.screenshot.viewhierarchy.d.STARTED);
        b bVar = new b();
        bVar.a(activity.getWindow().getDecorView());
        try {
            bVar.a(e.a(activity, a(activity)));
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-BR", Intrinsics.stringPlus("inspect activity frame got error", e11.getMessage()), e11);
        }
        List<RootViewInfo> rootViews = FieldHelper.getRootViews(activity, new int[]{R.id.instabug_decor_view, R.id.instabug_in_app_notification, R.id.instabug_intro_dialog});
        if (rootViews.size() > 0) {
            bVar.a(true);
        }
        ArrayList arrayList = new ArrayList(rootViews.size());
        int size = rootViews.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar2 = new b();
            bVar2.b(String.valueOf(i11));
            bVar2.a(rootViews.get(i11).getView());
            bVar2.b(true);
            bVar2.a(a(activity));
            arrayList.add(e.c(bVar2));
        }
        try {
            a(activity, arrayList, bVar, (Function1) new e(this, activity, bVar));
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-BR", Intrinsics.stringPlus("activity view inspection got error: ", e12.getMessage()), e12);
            com.instabug.bug.model.d c12 = n.e().c();
            if (c12 != null) {
                c12.a(com.instabug.bug.model.c.FAILED);
            }
            com.instabug.bug.screenshot.viewhierarchy.utilities.e.a().post(com.instabug.bug.screenshot.viewhierarchy.d.FAILED);
            PoolProvider.postIOTask(new yb.e(activity));
        }
    }
}
