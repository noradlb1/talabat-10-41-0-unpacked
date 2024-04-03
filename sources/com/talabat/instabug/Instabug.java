package com.talabat.instabug;

import android.app.Application;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.bug.BugReporting;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.talabat.secrets.Secrets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/instabug/Instabug;", "", "()V", "blockViewsRecording", "", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "getInstabugKey", "", "secrets", "Lcom/talabat/secrets/Secrets;", "debug", "", "initialiseInstabug", "application", "Landroid/app/Application;", "removeViewBlocking", "com_talabat_ThirdPartyLibs_Instabug_Instabug"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Instabug {
    @NotNull
    public static final Instabug INSTANCE = new Instabug();

    private Instabug() {
    }

    public final void blockViewsRecording(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        if (com.instabug.library.Instabug.isBuilt()) {
            com.instabug.library.Instabug.addPrivateViews((View[]) Arrays.copyOf(viewArr, viewArr.length));
        }
    }

    @NotNull
    @VisibleForTesting
    public final String getInstabugKey(@NotNull Secrets secrets, boolean z11) {
        Intrinsics.checkNotNullParameter(secrets, "secrets");
        if (z11) {
            return secrets.getInstabugDebugKey();
        }
        return secrets.getInstabugRelaseKey();
    }

    public final void initialiseInstabug(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        new Instabug.Builder(application, getInstabugKey(new Secrets(), false)).setInvocationEvents(InstabugInvocationEvent.SHAKE, InstabugInvocationEvent.SCREENSHOT).build();
        InstabugColorTheme instabugColorTheme = InstabugColorTheme.InstabugColorThemeLight;
        com.instabug.library.Instabug.setColorTheme(instabugColorTheme);
        com.instabug.library.Instabug.setColorTheme(instabugColorTheme);
        com.instabug.library.Instabug.setWelcomeMessageState(WelcomeMessage.State.LIVE);
        InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder = new InstabugCustomTextPlaceHolder();
        instabugCustomTextPlaceHolder.set(InstabugCustomTextPlaceHolder.Key.REPORT_FEEDBACK, "Send Feedback");
        instabugCustomTextPlaceHolder.set(InstabugCustomTextPlaceHolder.Key.REPORT_BUG, "Send Bug Report");
        com.instabug.library.Instabug.setCustomTextPlaceHolders(instabugCustomTextPlaceHolder);
        BugReporting.setShakingThreshold(500);
    }

    public final void removeViewBlocking(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        if (com.instabug.library.Instabug.isBuilt()) {
            com.instabug.library.Instabug.removePrivateViews((View[]) Arrays.copyOf(viewArr, viewArr.length));
        }
    }
}
