package com.talabat.talabatcore.testframework;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0002\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"ActivitiesStack", "Ljava/util/LinkedList;", "Landroidx/appcompat/app/AppCompatActivity;", "getActivitiesStack", "()Ljava/util/LinkedList;", "ActivitiesStack$delegate", "Lkotlin/Lazy;", "activitiesStackUpdater", "Landroid/app/Application$ActivityLifecycleCallbacks;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IntegrationKt {
    @NotNull
    private static final Lazy ActivitiesStack$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, IntegrationKt$ActivitiesStack$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final Application.ActivityLifecycleCallbacks activitiesStackUpdater() {
        return new IntegrationKt$activitiesStackUpdater$1();
    }

    @NotNull
    public static final LinkedList<AppCompatActivity> getActivitiesStack() {
        return (LinkedList) ActivitiesStack$delegate.getValue();
    }
}
