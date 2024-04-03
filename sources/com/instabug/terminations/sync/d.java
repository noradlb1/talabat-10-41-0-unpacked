package com.instabug.terminations.sync;

import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.terminations.model.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class d {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c8, code lost:
        if (r1 == null) goto L_0x00ca;
     */
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.instabug.library.networkv2.request.Request a(@org.jetbrains.annotations.NotNull com.instabug.terminations.model.b r12) {
        /*
            r11 = this;
            java.lang.String r0 = "termination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.instabug.library.networkv2.request.Request$Builder r0 = new com.instabug.library.networkv2.request.Request$Builder
            r0.<init>()
            java.lang.String r1 = "/crashes/android_user_termination"
            com.instabug.library.networkv2.request.Request$Builder r0 = r0.endpoint(r1)
            java.lang.String r1 = "POST"
            com.instabug.library.networkv2.request.Request$Builder r0 = r0.method(r1)
            com.instabug.library.networkv2.request.RequestParameter r1 = new com.instabug.library.networkv2.request.RequestParameter
            java.lang.String r2 = com.instabug.library.Instabug.getAppToken()
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0022
            r2 = r3
        L_0x0022:
            java.lang.String r4 = "IBG-APP-TOKEN"
            r1.<init>(r4, r2)
            com.instabug.library.networkv2.request.Request$Builder r0 = r0.addHeader(r1)
            com.instabug.commons.models.IncidentMetadata r1 = r12.getMetadata()
            java.lang.String r1 = r1.getUuid()
            if (r1 != 0) goto L_0x0036
            goto L_0x0048
        L_0x0036:
            com.instabug.library.networkv2.request.RequestParameter r2 = new com.instabug.library.networkv2.request.RequestParameter
            java.lang.String r4 = "id"
            r2.<init>(r4, r1)
            r0.addHeader(r2)
            com.instabug.library.networkv2.request.RequestParameter r2 = new com.instabug.library.networkv2.request.RequestParameter
            r2.<init>(r4, r1)
            r0.addParameter(r2)
        L_0x0048:
            com.instabug.library.model.State r1 = r12.e()
            if (r1 != 0) goto L_0x004f
            goto L_0x008c
        L_0x004f:
            java.util.ArrayList r1 = r1.getStateItems()
            if (r1 != 0) goto L_0x0056
            goto L_0x008c
        L_0x0056:
            kotlin.sequences.Sequence r1 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r1)
            if (r1 != 0) goto L_0x005d
            goto L_0x008c
        L_0x005d:
            com.instabug.terminations.sync.a r2 = com.instabug.terminations.sync.a.f52651a
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt___SequencesKt.filterNot(r1, r2)
            if (r1 != 0) goto L_0x0066
            goto L_0x008c
        L_0x0066:
            com.instabug.terminations.sync.b r2 = com.instabug.terminations.sync.b.f52652a
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt___SequencesKt.dropWhile(r1, r2)
            if (r1 != 0) goto L_0x006f
            goto L_0x008c
        L_0x006f:
            com.instabug.terminations.sync.c r2 = com.instabug.terminations.sync.c.f52653a
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt___SequencesKt.map(r1, r2)
            if (r1 != 0) goto L_0x0078
            goto L_0x008c
        L_0x0078:
            java.util.Iterator r1 = r1.iterator()
        L_0x007c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008c
            java.lang.Object r2 = r1.next()
            com.instabug.library.networkv2.request.RequestParameter r2 = (com.instabug.library.networkv2.request.RequestParameter) r2
            r0.addParameter(r2)
            goto L_0x007c
        L_0x008c:
            com.instabug.library.model.State r1 = r12.e()
            r2 = 0
            if (r1 != 0) goto L_0x0095
            r1 = r2
            goto L_0x0099
        L_0x0095:
            java.util.ArrayList r1 = r1.getStateItems()
        L_0x0099:
            if (r1 != 0) goto L_0x009c
            goto L_0x00ca
        L_0x009c:
            java.util.Iterator r1 = r1.iterator()
        L_0x00a0:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00bf
            java.lang.Object r4 = r1.next()
            r5 = r4
            com.instabug.library.model.State$StateItem r5 = (com.instabug.library.model.State.StateItem) r5
            java.lang.String r6 = "(key, _)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = com.instabug.terminations.sync.e.c(r5)
            java.lang.String r6 = "current_activity"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00a0
            r2 = r4
        L_0x00bf:
            com.instabug.library.model.State$StateItem r2 = (com.instabug.library.model.State.StateItem) r2
            if (r2 != 0) goto L_0x00c4
            goto L_0x00ca
        L_0x00c4:
            java.lang.Object r1 = r2.getValue()
            if (r1 != 0) goto L_0x00cc
        L_0x00ca:
            java.lang.String r1 = "NA"
        L_0x00cc:
            com.instabug.library.networkv2.request.RequestParameter r2 = new com.instabug.library.networkv2.request.RequestParameter
            java.lang.String r4 = "activity_name"
            r2.<init>(r4, r1)
            r0.addParameter(r2)
            java.lang.String r1 = "builder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11.a(r0, r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "name"
            java.lang.String r4 = "User Termination"
            r1.put((java.lang.String) r2, (java.lang.Object) r4)
            com.instabug.terminations.di.d r2 = com.instabug.terminations.di.d.f52610a
            com.instabug.terminations.configuration.c r2 = r2.s()
            long r4 = r2.a()
            r2 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r2
            long r4 = r4 / r6
            r2 = 1
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r8 = 0
            r6[r8] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r2)
            java.lang.String r7 = "The user terminated the app then relaunched it within %d seconds"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            java.lang.String r9 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            java.lang.String r10 = "User Termination: "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r6)
            java.lang.String r10 = "exception"
            r1.put((java.lang.String) r10, (java.lang.Object) r6)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r6[r8] = r4
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r6, r2)
            java.lang.String r2 = java.lang.String.format(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.String r4 = "message"
            r1.put((java.lang.String) r4, (java.lang.Object) r2)
            java.lang.String r2 = "stackTrace"
            r1.put((java.lang.String) r2, (java.lang.Object) r3)
            java.lang.String r2 = "error"
            r12.put((java.lang.String) r2, (java.lang.Object) r1)
            com.instabug.library.networkv2.request.RequestParameter r1 = new com.instabug.library.networkv2.request.RequestParameter
            java.lang.String r12 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r12)
            java.lang.String r2 = "title"
            r1.<init>(r2, r12)
            r0.addParameter(r1)
            com.instabug.library.networkv2.request.Request r12 = r0.build()
            java.lang.String r0 = "builder.build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.sync.d.a(com.instabug.terminations.model.b):com.instabug.library.networkv2.request.Request");
    }

    @NotNull
    public final Request b(@NotNull b bVar) {
        String str;
        ArrayList<State.StateItem> logsItems;
        boolean z11;
        Intrinsics.checkNotNullParameter(bVar, "termination");
        Request.Builder builder = new Request.Builder();
        String g11 = bVar.g();
        if (g11 == null) {
            str = null;
        } else {
            str = new Regex(":crash_token").replace((CharSequence) Endpoints.CRASH_LOGS, g11);
        }
        Request.Builder method = builder.endpoint(str).method("POST");
        State e11 = bVar.e();
        if (!(e11 == null || (logsItems = e11.getLogsItems()) == null)) {
            ArrayList<State.StateItem> arrayList = new ArrayList<>();
            for (T next : logsItems) {
                if (((State.StateItem) next).getKey() == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    arrayList.add(next);
                }
            }
            for (State.StateItem stateItem : arrayList) {
                Intrinsics.checkNotNullExpressionValue(stateItem, "(key, value)");
                String a11 = e.c(stateItem);
                Object b11 = e.d(stateItem);
                if (b11 == null) {
                    b11 = "";
                }
                method.addParameter(new RequestParameter(a11, b11));
            }
        }
        Request build = method.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    private final void a(Request.Builder builder, b bVar) {
        Object obj;
        State e11 = bVar.e();
        if (e11 == null || e11.isMinimalState() || e11.getReportedAt() == 0) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(builder.addParameter(new RequestParameter(State.KEY_REPORTED_AT, Long.valueOf(bVar.b() / 1000))));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r72 = Result.m6332exceptionOrNullimpl(obj);
            if (r72 != null) {
                IBGDiagnostics.reportNonFatal(r72, "Failed to update reported_at in termination reporting request.");
            }
        }
    }
}
