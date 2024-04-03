package com.instabug.bug;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.bug.di.a;
import com.instabug.bug.reportingpromptitems.g;
import com.instabug.bug.settings.b;
import com.instabug.library.Feature;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import xb.e;

public abstract class t {
    public static OnSdkDismissCallback.DismissType a(o oVar) {
        int i11 = s.f45717a[oVar.ordinal()];
        return i11 != 2 ? i11 != 3 ? OnSdkDismissCallback.DismissType.CANCEL : OnSdkDismissCallback.DismissType.ADD_ATTACHMENT : OnSdkDismissCallback.DismissType.SUBMIT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.instabug.library.OnSdkDismissCallback.ReportType a(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = -191501435(0xfffffffff495eb85, float:-9.502309E31)
            r2 = 4
            r3 = 3
            r4 = 2
            if (r0 == r1) goto L_0x003a
            r1 = 97908(0x17e74, float:1.37198E-40)
            if (r0 == r1) goto L_0x0030
            r1 = 253684815(0xf1eec4f, float:7.835513E-30)
            if (r0 == r1) goto L_0x0026
            r1 = 1621082316(0x609fc0cc, float:9.20914E19)
            if (r0 == r1) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            java.lang.String r0 = "ask a question"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = r3
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "not-available"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = r2
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "bug"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "feedback"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = r4
            goto L_0x0045
        L_0x0044:
            r5 = -1
        L_0x0045:
            if (r5 == r4) goto L_0x0054
            if (r5 == r3) goto L_0x0051
            if (r5 == r2) goto L_0x004e
            com.instabug.library.OnSdkDismissCallback$ReportType r5 = com.instabug.library.OnSdkDismissCallback.ReportType.BUG
            return r5
        L_0x004e:
            com.instabug.library.OnSdkDismissCallback$ReportType r5 = com.instabug.library.OnSdkDismissCallback.ReportType.OTHER
            return r5
        L_0x0051:
            com.instabug.library.OnSdkDismissCallback$ReportType r5 = com.instabug.library.OnSdkDismissCallback.ReportType.QUESTION
            return r5
        L_0x0054:
            com.instabug.library.OnSdkDismissCallback$ReportType r5 = com.instabug.library.OnSdkDismissCallback.ReportType.FEEDBACK
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.t.a(java.lang.String):com.instabug.library.OnSdkDismissCallback$ReportType");
    }

    public static Disposable a(Consumer consumer) {
        return SDKCoreEventSubscriber.subscribe(consumer);
    }

    public static Consumer a(Context context) {
        return new q(context);
    }

    private static void a() {
        if (b.f().r()) {
            b();
        }
    }

    private static void a(ArrayList arrayList, Context context) {
        if (e() && d()) {
            arrayList.add(new com.instabug.bug.reportingpromptitems.b().a(context));
        }
    }

    private static void b() {
        ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new e()).orchestrate();
    }

    private static boolean b(String str) {
        return b.f().b(str);
    }

    public static void c() {
        h.b(0, 1, 2);
    }

    public static void c(Context context) {
        b.a(context);
        a();
    }

    private static boolean d() {
        return InstabugCore.isFeatureEnabled(Feature.CHATS);
    }

    private static boolean e() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == Feature.State.ENABLED;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f() {
        a.a().a();
        a.c().a();
        b.f().e(false);
    }

    public static void g() {
    }

    public static ArrayList i(boolean z11, Context context) {
        com.instabug.bug.reportingpromptitems.b bVar;
        ArrayList arrayList = new ArrayList();
        if (z11 || !InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING)) {
            if (z11) {
                arrayList.add(new com.instabug.bug.reportingpromptitems.e().a(context));
                arrayList.add(new g().a(context));
                bVar = new com.instabug.bug.reportingpromptitems.b();
            }
            return arrayList;
        }
        arrayList.add(new com.instabug.bug.reportingpromptitems.e().a(context));
        arrayList.add(new g().a(context));
        bVar = new com.instabug.bug.reportingpromptitems.b();
        arrayList.add(bVar.a(context));
        return arrayList;
    }

    public static void j(@Nullable Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public static ArrayList k(Context context) {
        ArrayList arrayList = new ArrayList();
        if (InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING)) {
            if (b("bug")) {
                arrayList.add(new com.instabug.bug.reportingpromptitems.e().a(context));
            }
            if (b("feedback")) {
                arrayList.add(new g().a(context));
            }
            if (b("ask a question")) {
                a(arrayList, context);
            }
        }
        return arrayList;
    }
}
