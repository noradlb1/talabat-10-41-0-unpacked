package com.talabat.talabatcommon.helpers;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\f\u0010\u0013\u001a\u00020\u0014*\u00020\tH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/helpers/SyncLayoutWithLanguageScanner;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "selectedLocale", "Lkotlin/Function0;", "Ljava/util/Locale;", "(Lkotlin/jvm/functions/Function0;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "isAnnotationPresent", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SyncLayoutWithLanguageScanner implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Locale> selectedLocale;

    public SyncLayoutWithLanguageScanner(@NotNull Function0<Locale> function0) {
        Intrinsics.checkNotNullParameter(function0, "selectedLocale");
        this.selectedLocale = function0;
    }

    /* access modifiers changed from: private */
    public final boolean isAnnotationPresent(Activity activity) {
        return activity.getClass().isAnnotationPresent(SyncLayoutWithLanguage.class);
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CoroutinesKt.runHandling$default((Function1) null, new SyncLayoutWithLanguageScanner$onActivityCreated$1(activity, this), 1, (Object) null);
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
