package com.talabat.bugreport;

import android.app.Application;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J!\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/bugreport/TalabatBugReport;", "", "blockViewsRecording", "", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "initializeBugReporter", "application", "Landroid/app/Application;", "removeViewBlocking", "com_talabat_NewArchi_BugReport_BugReport"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatBugReport {
    void blockViewsRecording(@NotNull View... viewArr);

    void initializeBugReporter(@NotNull Application application);

    void removeViewBlocking(@NotNull View... viewArr);
}
