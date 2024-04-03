package com.instabug.bug;

import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.instabug.bug.BugReporting;
import com.instabug.bug.settings.a;
import com.instabug.bug.settings.b;
import com.instabug.bug.utils.e;
import com.instabug.chat.ChatsDelegate;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Locale;

public abstract class h {
    private static Spanned a(String str) {
        return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static void a(@BugReporting.ReportType int i11) {
        InvocationManager invocationManager;
        InstabugSDKLogger.d("IBG-BR", "BugReporting.show, type: " + i11);
        if (!InstabugCore.isForegroundBusy() && InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING)) {
            int i12 = 1;
            if (i11 == 0) {
                invocationManager = InvocationManager.getInstance();
            } else if (i11 == 1) {
                InvocationManager.getInstance().invoke(2);
                return;
            } else if (i11 == 2) {
                invocationManager = InvocationManager.getInstance();
                i12 = 3;
            } else {
                return;
            }
            invocationManager.invoke(i12);
        }
    }

    private static void a(@BugReporting.ReportType int i11, int i12) {
        b bVar;
        String str;
        if (i11 == 0) {
            bVar = b.f();
            str = "bug";
        } else if (i11 == 1) {
            bVar = b.f();
            str = "feedback";
        } else if (i11 == 2) {
            bVar = b.f();
            str = "ask a question";
        } else {
            return;
        }
        bVar.a(str, i12);
    }

    public static void a(int i11, @BugReporting.ReportType int... iArr) {
        for (int a11 : iArr) {
            a(a11, i11);
        }
    }

    public static void a(Feature.State state) {
        InstabugSDKLogger.d("IBG-BR", "setState: " + state);
        if (state == Feature.State.DISABLED) {
            InstabugCore.cleanVisualUserSteps();
        }
        b.f().a(state);
        InstabugCore.setBugReportingState(state);
        InvocationManager.getInstance().notifyInvocationOptionChanged();
    }

    public static void a(boolean z11) {
        InstabugSDKLogger.d("IBG-BR", "setAutoScreenRecordingEnabled: " + z11);
        if (!z11 || !InstabugCore.isAutoScreenRecordingEnabled()) {
            InstabugCore.setAutoScreenRecordingEnabled(z11);
            if (z11) {
                InternalAutoScreenRecorderHelper.getInstance().start();
            }
        }
    }

    public static void a(boolean z11, boolean z12, boolean z13, boolean z14) {
        InstabugSDKLogger.d("IBG-BR", "setAttachementTypes: initialScreenshot: " + z11 + " extraScreenshot: " + z12 + " imageFromGallery: " + z13 + "screenRecording: " + z14);
        b.f().a(new a(z11, z12, z13, z14));
        ChatsDelegate.setAttachmentTypesEnabled(z12, z13, z14);
    }

    public static void a(int[] iArr) {
        for (int i11 : iArr) {
            InstabugSDKLogger.d("IBG-BR", "setOptions: " + i11);
            if (i11 == 2) {
                b.f().d(false);
            } else if (i11 != 4) {
                if (i11 == 8) {
                    b.f().a(true);
                } else if (i11 == 16) {
                    b.f().g(false);
                }
            } else {
                b.f().d(true);
            }
            b.f().c(false);
        }
    }

    public static void b(int i11, int[] iArr) {
        a(iArr);
        a(i11);
    }

    public static void b(String str) {
        if (str != null && !str.equals("")) {
            Spanned a11 = a(e.a(str, String.format("<font color=\"#%06X\"><a href=\"$2\">$1</a></font>", new Object[]{Integer.valueOf(SettingsManager.getInstance().getPrimaryColor() & 16777215)})));
            if (a11.length() > 100) {
                InstabugSDKLogger.w("IBG-BR", String.format(Locale.getDefault(), "The maximum limit of Disclaimer text is reached. Please note that maximum characters count is %d", new Object[]{100}));
                a11 = (Spanned) a11.subSequence(0, 100);
                if (a11 instanceof SpannableStringBuilder) {
                    ((SpannableStringBuilder) a11).append("...");
                }
            }
            b.f().a(a11);
        }
    }

    public static void b(@BugReporting.ReportType int... iArr) {
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        for (int i11 : iArr) {
            InstabugSDKLogger.d("IBG-BR", "setReportTypes: " + i11);
            if (i11 == 0) {
                z11 = true;
            } else if (i11 == 1) {
                z12 = true;
            } else if (i11 == 2) {
                z13 = true;
            }
        }
        b.f().a("bug", z11);
        b.f().a("feedback", z12);
        b.f().a("ask a question", z13);
        if (InstabugCore.isFeatureEnabled(Feature.BUG_REPORTING)) {
            InstabugCore.setChatsState(z13 ? Feature.State.ENABLED : Feature.State.DISABLED);
        }
        InvocationManager.getInstance().notifyInvocationOptionChanged();
    }
}
