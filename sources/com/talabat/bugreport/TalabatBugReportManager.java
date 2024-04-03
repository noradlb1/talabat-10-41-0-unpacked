package com.talabat.bugreport;

import android.app.Application;
import android.view.View;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u001f\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/bugreport/TalabatBugReportManager;", "", "()V", "talabatBugReport", "Lcom/talabat/bugreport/TalabatBugReport;", "blockViewsRecording", "", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "initializeBugReporter", "application", "Landroid/app/Application;", "removeViewBlocking", "setTalabatBugReportManager", "com_talabat_NewArchi_BugReport_BugReport"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatBugReportManager {
    @NotNull
    public static final TalabatBugReportManager INSTANCE = new TalabatBugReportManager();
    private static TalabatBugReport talabatBugReport;

    private TalabatBugReportManager() {
    }

    public final void blockViewsRecording(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        TalabatBugReport talabatBugReport2 = talabatBugReport;
        if (talabatBugReport2 != null) {
            if (talabatBugReport2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("talabatBugReport");
                talabatBugReport2 = null;
            }
            talabatBugReport2.blockViewsRecording((View[]) Arrays.copyOf(viewArr, viewArr.length));
        }
    }

    public final void initializeBugReporter(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        TalabatBugReport talabatBugReport2 = talabatBugReport;
        if (talabatBugReport2 != null) {
            if (talabatBugReport2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("talabatBugReport");
                talabatBugReport2 = null;
            }
            talabatBugReport2.initializeBugReporter(application);
        }
    }

    public final void removeViewBlocking(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        TalabatBugReport talabatBugReport2 = talabatBugReport;
        if (talabatBugReport2 != null) {
            if (talabatBugReport2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("talabatBugReport");
                talabatBugReport2 = null;
            }
            talabatBugReport2.removeViewBlocking((View[]) Arrays.copyOf(viewArr, viewArr.length));
        }
    }

    public final void setTalabatBugReportManager(@NotNull TalabatBugReport talabatBugReport2) {
        Intrinsics.checkNotNullParameter(talabatBugReport2, "talabatBugReport");
        talabatBugReport = talabatBugReport2;
    }
}
