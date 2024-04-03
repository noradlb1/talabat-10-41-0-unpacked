package com.talabat.bugreport;

import android.app.Application;
import android.view.View;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.instabug.Instabug;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\f\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/talabat/bugreport/TalabatBugReportImpl;", "Lcom/talabat/bugreport/TalabatBugReport;", "()V", "blockViewsRecording", "", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "initializeBugReporter", "application", "Landroid/app/Application;", "removeViewBlocking", "com_talabat_NewArchi_BugReport_BugReport"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatBugReportImpl implements TalabatBugReport {
    public void blockViewsRecording(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        Instabug.INSTANCE.blockViewsRecording((View[]) Arrays.copyOf(viewArr, viewArr.length));
    }

    public void initializeBugReporter(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Instabug.INSTANCE.initialiseInstabug(application);
    }

    public void removeViewBlocking(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        Instabug.INSTANCE.removeViewBlocking((View[]) Arrays.copyOf(viewArr, viewArr.length));
    }
}
