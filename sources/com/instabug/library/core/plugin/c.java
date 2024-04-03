package com.instabug.library.core.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f34197a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static List f34198b;

    public static void a(Context context) {
        InstabugSDKLogger.v("IBG-Core", "Initializing plugins");
        synchronized (f34197a) {
            if (f34198b == null) {
                f34198b = new ArrayList();
                String[] strArr = {"com.instabug.crash.CrashPlugin", "com.instabug.ndkcrash.NDKCrashPlugin", "com.instabug.survey.SurveyPlugin", "com.instabug.chat.ChatPlugin", "com.instabug.bug.BugPlugin", "com.instabug.featuresrequest.FeaturesRequestPlugin", "com.instabug.apm.APMPlugin"};
                for (int i11 = 0; i11 < 7; i11++) {
                    String str = strArr[i11];
                    try {
                        Plugin plugin = (Plugin) Class.forName(str).newInstance();
                        plugin.init(context);
                        f34198b.add(plugin);
                        InstabugSDKLogger.d("IBG-Core", "pluginClassPath: " + str);
                    } catch (ClassNotFoundException unused) {
                        if (str.equals("com.instabug.ndkcrash.NDKCrashPlugin")) {
                            InstabugSDKLogger.e("IBG-Core", "NDK Plugin wasn't loaded");
                        } else {
                            InstabugSDKLogger.e("IBG-Core", "ClassNotFoundException Can't get: " + str);
                        }
                    } catch (InstantiationException unused2) {
                        InstabugSDKLogger.e("IBG-Core", "InstantiationException Can't get: " + str);
                    } catch (IllegalAccessException unused3) {
                        InstabugSDKLogger.e("IBG-Core", "IllegalAccessException Can't get: " + str);
                    }
                }
            }
        }
    }

    public static void b(Context context) {
        synchronized (f34197a) {
            if (a("startPlugins()")) {
                for (Plugin startIfPossible : f34198b) {
                    startIfPossible.startIfPossible(context);
                }
            }
        }
    }

    @NonNull
    public static List c() {
        synchronized (f34197a) {
            try {
                if (!a("getFeaturesSessionDataControllers()")) {
                    ArrayList arrayList = new ArrayList();
                    return arrayList;
                }
                List a11 = com.instabug.library.sessionV3.di.c.j().a(f34198b);
                return a11;
            } catch (Throwable th2) {
                IBGDiagnostics.reportNonFatalAndLog(th2, "couldn't getFeaturesSessionDataControllers" + th2.getMessage(), "IBG-Core");
                return new ArrayList();
            }
        }
    }

    @NonNull
    public static List d() {
        synchronized (f34197a) {
            try {
                if (!a("getFeaturesSessionLazyDataProvider()")) {
                    ArrayList arrayList = new ArrayList();
                    return arrayList;
                }
                List b11 = com.instabug.library.sessionV3.di.c.j().b(f34198b);
                return b11;
            } catch (Throwable th2) {
                IBGDiagnostics.reportNonFatalAndLog(th2, "couldn't getFeaturesSessionLazyDataProvider" + th2.getMessage(), "IBG-Core");
                return new ArrayList();
            }
        }
    }

    public static long e() {
        synchronized (f34197a) {
            long j11 = 0;
            if (!a("getLastActivityTime()")) {
                return 0;
            }
            for (Plugin lastActivityTime : f34198b) {
                long lastActivityTime2 = lastActivityTime.getLastActivityTime();
                if (lastActivityTime2 > j11) {
                    j11 = lastActivityTime2;
                }
            }
            return j11;
        }
    }

    @NonNull
    public static ArrayList f() {
        synchronized (f34197a) {
            ArrayList arrayList = new ArrayList();
            if (!a("getPluginsPromptOptions()")) {
                return arrayList;
            }
            for (Plugin promptOptions : f34198b) {
                ArrayList<PluginPromptOption> promptOptions2 = promptOptions.getPromptOptions();
                if (promptOptions2 != null) {
                    arrayList.addAll(promptOptions2);
                }
            }
            a(arrayList);
            return arrayList;
        }
    }

    public static void g() {
        synchronized (f34197a) {
            if (a("initPluginsPromptOptionAvailability()")) {
                for (Plugin initDefaultPromptOptionAvailabilityState : f34198b) {
                    initDefaultPromptOptionAvailabilityState.initDefaultPromptOptionAvailabilityState();
                }
            }
        }
    }

    @SuppressLint({"THREAD_SAFETY_VIOLATION"})
    public static boolean h() {
        synchronized (f34197a) {
            try {
                if (!a("isForegroundBusy()")) {
                    boolean a11 = a();
                    return a11;
                }
                for (Plugin state : f34198b) {
                    if (state.getState() != 0) {
                        return true;
                    }
                }
                boolean a12 = a();
                return a12;
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error in isForegroundBusy", e11);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void i() {
        synchronized (f34197a) {
            if (a("sleep()")) {
                for (Plugin sleepIfPossible : f34198b) {
                    sleepIfPossible.sleepIfPossible();
                }
                PresentationManager.release();
            }
        }
    }

    public static void j() {
        synchronized (f34197a) {
            if (a("stopPlugins()")) {
                for (Plugin stopIfPossible : f34198b) {
                    stopIfPossible.stopIfPossible();
                }
            }
        }
    }

    public static void k() {
        synchronized (f34197a) {
            if (a("wake()")) {
                for (Plugin wakeIfPossible : f34198b) {
                    wakeIfPossible.wakeIfPossible();
                }
            }
        }
    }

    @NonNull
    @Deprecated
    public static List b() {
        synchronized (f34197a) {
            ArrayList arrayList = new ArrayList();
            if (!a("getDataDisposalPolicies()")) {
                return arrayList;
            }
            for (Plugin dataDisposalPolicies : f34198b) {
                arrayList.addAll(dataDisposalPolicies.getDataDisposalPolicies());
            }
            return arrayList;
        }
    }

    private static void b(String str) {
        InstabugSDKLogger.e("IBG-Core", "PluginsManager." + str + " was called before PluginsManager.init() was called");
    }

    @NonNull
    public static ArrayList a(boolean z11) {
        synchronized (f34197a) {
            ArrayList arrayList = new ArrayList();
            if (!a("getPluginOptions()")) {
                return arrayList;
            }
            for (Plugin pluginOptions : f34198b) {
                ArrayList<PluginPromptOption> pluginOptions2 = pluginOptions.getPluginOptions(z11);
                if (pluginOptions2 != null) {
                    arrayList.addAll(pluginOptions2);
                }
            }
            a(arrayList);
            return arrayList;
        }
    }

    public static void a(Locale locale, Locale locale2) {
        synchronized (f34197a) {
            if (a("notifyPluginsLocaleChanged()")) {
                for (Plugin onLocaleChanged : f34198b) {
                    onLocaleChanged.onLocaleChanged(locale, locale2);
                }
            }
        }
    }

    private static void a(ArrayList arrayList) {
        Collections.sort(arrayList, new PluginPromptOption.a());
    }

    public static boolean a() {
        return SettingsManager.getInstance().isPromptOptionsScreenShown() || SettingsManager.getInstance().isRequestPermissionScreenShown() || SettingsManager.getInstance().isOnboardingShowing();
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static Plugin a(Class cls) {
        synchronized (f34197a) {
            if (!a("getXPlugin()")) {
                return null;
            }
            for (Plugin plugin : f34198b) {
                if (cls.isInstance(plugin)) {
                    return plugin;
                }
            }
            return null;
        }
    }

    private static boolean a(String str) {
        if (f34198b != null) {
            return true;
        }
        b(str);
        return false;
    }
}
