package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.instabug.library.settings.SettingsManager;
import java.util.Locale;

public class LocaleUtils {
    public static String getCurrentLocaleResolved(Context context) {
        return new p(context).a();
    }

    public static String getLocaleStringResource(Locale locale, int i11, @Nullable Context context) {
        return getLocaleStringResource(locale, i11, context, (Object[]) null);
    }

    @TargetApi(17)
    @Nullable
    private static String getLocalizedStringResNewAPI(@Nullable Context context, int i11, Locale locale, @Nullable Object... objArr) {
        String str;
        if (context != null) {
            try {
                Configuration configuration = new Configuration(context.getResources().getConfiguration());
                configuration.setLocale(locale);
                Context createConfigurationContext = context.createConfigurationContext(configuration);
                if (createConfigurationContext == null) {
                    str = null;
                } else {
                    str = createConfigurationContext.getText(i11).toString();
                }
                if (objArr == null || str == null) {
                    return str;
                }
                return String.format(str, objArr);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Error: " + e11.getMessage() + " while getting localized string");
            }
        }
        return null;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    private static String getLocalizedStringResOldAPI(@Nullable Context context, int i11, Locale locale, @Nullable Object... objArr) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        configuration.locale = locale;
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        String string = resources.getString(i11);
        configuration.locale = locale2;
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (objArr != null) {
            return String.format(string, objArr);
        }
        return string;
    }

    public static boolean isRTL(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    public static boolean isSupportedBySdk(Context context, Locale locale) {
        if (context == null || locale == null) {
            return false;
        }
        return new p(context).g(locale.getLanguage());
    }

    public static String resolveLocale(Context context, Locale locale) {
        return new p(context).b(locale);
    }

    public static void setAppLocale(Activity activity) {
        Locale appLocale = SettingsManager.getInstance().getAppLocale();
        if (appLocale != null) {
            setLocale(activity, appLocale);
        }
    }

    public static void setLocale(Activity activity, Locale locale) {
        Configuration configuration = activity.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 24) {
            configuration.setLocale(locale);
        } else if (locale != null) {
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            updateResources(activity, locale);
        }
        activity.getResources().updateConfiguration(configuration, activity.getResources().getDisplayMetrics());
    }

    @TargetApi(24)
    private static Context updateResources(Context context, Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getLocaleStringResource(Locale locale, int i11, @Nullable Context context, @Nullable Object... objArr) {
        String localizedStringResNewAPI = getLocalizedStringResNewAPI(context, i11, locale, objArr);
        if (localizedStringResNewAPI != null) {
            return localizedStringResNewAPI;
        }
        String localizedStringResOldAPI = getLocalizedStringResOldAPI(context, i11, locale, objArr);
        if (localizedStringResOldAPI != null) {
            return localizedStringResOldAPI;
        }
        if (context == null) {
            return "";
        }
        String string = context.getString(i11);
        return objArr != null ? String.format(string, objArr) : string;
    }
}
