package com.talabat.talabatcommon.views.statusViews;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/statusViews/Status;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Status {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final BaseTransientBottomBar.BaseCallback<TalabatNotifySnackBar> errorNotifyCallback = new Status$Companion$errorNotifyCallback$1();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/statusViews/Status$Companion;", "", "()V", "errorNotifyCallback", "Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar;", "notify", "", "activity", "Landroid/app/Activity;", "viewGroup", "Landroid/view/ViewGroup;", "message", "", "title", "callback", "status", "Lcom/talabat/talabatcommon/views/statusViews/ActionStatus;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void notify$default(Companion companion, Activity activity, ViewGroup viewGroup, String str, String str2, BaseTransientBottomBar.BaseCallback baseCallback, ActionStatus actionStatus, int i11, Object obj) {
            ViewGroup viewGroup2;
            String str3;
            BaseTransientBottomBar.BaseCallback baseCallback2;
            ActionStatus actionStatus2;
            if ((i11 & 2) != 0) {
                viewGroup2 = null;
            } else {
                viewGroup2 = viewGroup;
            }
            if ((i11 & 8) != 0) {
                str3 = null;
            } else {
                str3 = str2;
            }
            if ((i11 & 16) != 0) {
                baseCallback2 = Status.errorNotifyCallback;
            } else {
                baseCallback2 = baseCallback;
            }
            if ((i11 & 32) != 0) {
                actionStatus2 = ActionStatus.FAILURE;
            } else {
                actionStatus2 = actionStatus;
            }
            companion.notify(activity, viewGroup2, str, str3, baseCallback2, actionStatus2);
        }

        @JvmOverloads
        public final void notify(@Nullable Activity activity, @Nullable ViewGroup viewGroup, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            notify$default(this, activity, viewGroup, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        }

        @JvmOverloads
        public final void notify(@Nullable Activity activity, @Nullable ViewGroup viewGroup, @NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "message");
            notify$default(this, activity, viewGroup, str, str2, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 48, (Object) null);
        }

        @JvmOverloads
        public final void notify(@Nullable Activity activity, @Nullable ViewGroup viewGroup, @NotNull String str, @Nullable String str2, @NotNull BaseTransientBottomBar.BaseCallback<TalabatNotifySnackBar> baseCallback) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(baseCallback, "callback");
            notify$default(this, activity, viewGroup, str, str2, baseCallback, (ActionStatus) null, 32, (Object) null);
        }

        /* JADX WARNING: type inference failed for: r14v0, types: [com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback, java.lang.Object, com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback<com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void notify(@org.jetbrains.annotations.Nullable android.app.Activity r10, @org.jetbrains.annotations.Nullable android.view.ViewGroup r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.NotNull com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback<com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar> r14, @org.jetbrains.annotations.NotNull com.talabat.talabatcommon.views.statusViews.ActionStatus r15) {
            /*
                r9 = this;
                java.lang.String r0 = "message"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                java.lang.String r0 = "callback"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "status"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                if (r10 == 0) goto L_0x0055
                com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar$Companion r0 = com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar.Companion
                if (r11 != 0) goto L_0x002b
                android.view.Window r11 = r10.getWindow()
                android.view.View r11 = r11.getDecorView()
                r1 = 16908290(0x1020002, float:2.3877235E-38)
                android.view.View r11 = r11.findViewById(r1)
                java.lang.String r1 = "it.window.decorView.find…yId(android.R.id.content)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
                android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            L_0x002b:
                com.talabat.talabatcommon.views.statusViews.StatusNotifyView r8 = new com.talabat.talabatcommon.views.statusViews.StatusNotifyView
                r3 = 0
                r4 = 0
                r6 = 6
                r7 = 0
                r1 = r8
                r2 = r10
                r5 = r15
                r1.<init>(r2, r3, r4, r5, r6, r7)
                r8.setMessage(r12)
                if (r13 == 0) goto L_0x003f
                r8.setTitle(r13)
            L_0x003f:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar r10 = r0.make(r11, r8)
                r11 = 0
                com.google.android.material.snackbar.BaseTransientBottomBar r10 = r10.setDuration(r11)
                com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar r10 = (com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar) r10
                com.google.android.material.snackbar.BaseTransientBottomBar r10 = r10.addCallback(r14)
                com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar r10 = (com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar) r10
                r10.show()
            L_0x0055:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.statusViews.Status.Companion.notify(android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.String, com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback, com.talabat.talabatcommon.views.statusViews.ActionStatus):void");
        }

        @JvmOverloads
        public final void notify(@Nullable Activity activity, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            notify$default(this, activity, (ViewGroup) null, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
    }
}
