package com.instabug.library.invocation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.InitialScreenshotHelper;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.core.plugin.c;
import com.instabug.library.invocation.invocationdialog.InstabugDialogItem;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.ui.promptoptions.b;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;

public class d implements a {
    private boolean d() {
        return SettingsManager.isInitialScreenShotAllowed();
    }

    private void e() {
        if (SettingsManager.getInstance().getOnInvokeCallback() != null) {
            SettingsManager.getInstance().getOnInvokeCallback().onInvoke();
        }
    }

    public void a(@Nullable Uri uri) {
        h(uri);
    }

    public void b(int i11) {
        PluginPromptOption pluginPromptOption;
        if (i11 == 1) {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(0, true);
        } else if (i11 == 2) {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(1, true);
        } else if (i11 != 3) {
            if (i11 == 4) {
                c(2);
            } else if (i11 == 5) {
                c(5);
                return;
            }
            pluginPromptOption = null;
        } else {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(3, true);
        }
        if (pluginPromptOption == null) {
            return;
        }
        if (d()) {
            d(pluginPromptOption);
        } else {
            c((Uri) null, pluginPromptOption);
        }
    }

    @VisibleForTesting
    public void c(@Nullable Uri uri, @NonNull PluginPromptOption pluginPromptOption) {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            InstabugDialogItem a11 = b.a().a(pluginPromptOption, (InstabugDialogItem) null);
            if (a11 == null || a11.getSubItems() == null || a11.getSubItems().isEmpty()) {
                pluginPromptOption.invoke(uri, new String[0]);
            } else {
                b.a().a(currentActivity, uri, pluginPromptOption.getTitle(), a11.getSubItems());
            }
        }
    }

    @VisibleForTesting
    public void f() {
        InitialScreenshotHelper.captureScreenshot(new b(this));
    }

    @VisibleForTesting
    @SuppressLint({"SwitchIntDef"})
    public void g(int i11) {
        PluginPromptOption pluginPromptOption;
        if (i11 == 1) {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(0, false);
        } else if (i11 == 2) {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(1, false);
        } else if (i11 != 3) {
            if (i11 == 4) {
                c(2);
            } else if (i11 == 5) {
                c(5);
                return;
            }
            pluginPromptOption = null;
        } else {
            pluginPromptOption = com.instabug.library.core.plugin.d.a(3, false);
        }
        if (pluginPromptOption == null) {
            return;
        }
        if (d()) {
            d(pluginPromptOption);
        } else {
            c((Uri) null, pluginPromptOption);
        }
    }

    @VisibleForTesting
    @SuppressLint({"SwitchIntDef"})
    public void h(@Nullable Uri uri) {
        if (InstabugCore.isForegroundBusy()) {
            InstabugSDKLogger.d("IBG-Core", "handleInvocationRequested() called with: screenShotUri = [" + uri + "] but SDK is Busy");
            return;
        }
        int i11 = i();
        if (i11 == 5) {
            c(5);
        } else if (i11 == 4) {
            c(2);
        } else if (uri != null || !d()) {
            if (i11 == 0) {
                e();
                j(uri);
            } else if (i11 == 1 || i11 == 2 || i11 == 3) {
                e();
                c(uri, (PluginPromptOption) c.f().get(0));
            }
        } else if (i11 == 0) {
            e();
            f();
        } else if (i11 == 1 || i11 == 2 || i11 == 3) {
            e();
            d((PluginPromptOption) c.f().get(0));
        }
    }

    @VisibleForTesting
    public int i() {
        ArrayList f11 = c.f();
        if (f11.size() > 1) {
            return 0;
        }
        if (f11.isEmpty()) {
            return -1;
        }
        int promptOptionIdentifier = ((PluginPromptOption) f11.get(0)).getPromptOptionIdentifier();
        if (promptOptionIdentifier == 0) {
            return 1;
        }
        if (promptOptionIdentifier == 1) {
            return 2;
        }
        if (promptOptionIdentifier == 2) {
            return 4;
        }
        int i11 = 3;
        if (promptOptionIdentifier != 3) {
            i11 = 5;
            if (promptOptionIdentifier != 5) {
                return -1;
            }
        }
        return i11;
    }

    @VisibleForTesting
    public void j(@Nullable Uri uri) {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            b.a().a(currentActivity, uri);
        }
    }

    public void a() {
        h((Uri) null);
    }

    @VisibleForTesting
    public void d(PluginPromptOption pluginPromptOption) {
        InitialScreenshotHelper.captureScreenshot(new c(this, pluginPromptOption));
    }

    private void c(@PluginPromptOption.PromptOptionIdentifier int i11) {
        PluginPromptOption a11 = com.instabug.library.core.plugin.d.a(i11, false);
        if (a11 != null) {
            c((Uri) null, a11);
        }
    }
}
