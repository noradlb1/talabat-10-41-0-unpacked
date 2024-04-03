package com.talabat.talabatcore.testframework;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcore/testframework/InstrumentationCore;", "", "()V", "with", "", "application", "Landroid/app/Application;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InstrumentationCore {
    @NotNull
    public static final InstrumentationCore INSTANCE = new InstrumentationCore();

    private InstrumentationCore() {
    }

    public final void with(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(IntegrationKt.activitiesStackUpdater());
    }
}
