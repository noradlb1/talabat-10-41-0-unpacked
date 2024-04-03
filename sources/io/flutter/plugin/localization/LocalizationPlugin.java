package io.flutter.plugin.localization;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class LocalizationPlugin {
    @VisibleForTesting
    @SuppressLint({"AppBundleLocaleChanges", "DiscouragedApi"})

    /* renamed from: a  reason: collision with root package name */
    public final LocalizationChannel.LocalizationMessageHandler f14253a;
    /* access modifiers changed from: private */
    @NonNull
    public final Context context;
    @NonNull
    private final LocalizationChannel localizationChannel;

    public LocalizationPlugin(@NonNull Context context2, @NonNull LocalizationChannel localizationChannel2) {
        AnonymousClass1 r02 = new LocalizationChannel.LocalizationMessageHandler() {
            public String getStringResource(@NonNull String str, @Nullable String str2) {
                Context a11 = LocalizationPlugin.this.context;
                if (str2 != null) {
                    Locale localeFromString = LocalizationPlugin.localeFromString(str2);
                    Configuration configuration = new Configuration(LocalizationPlugin.this.context.getResources().getConfiguration());
                    configuration.setLocale(localeFromString);
                    a11 = LocalizationPlugin.this.context.createConfigurationContext(configuration);
                }
                int identifier = a11.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, LocalizationPlugin.this.context.getPackageName());
                if (identifier != 0) {
                    return a11.getResources().getString(identifier);
                }
                return null;
            }
        };
        this.f14253a = r02;
        this.context = context2;
        this.localizationChannel = localizationChannel2;
        localizationChannel2.setLocalizationMessageHandler(r02);
    }

    @NonNull
    public static Locale localeFromString(@NonNull String str) {
        String str2;
        String[] split = str.replace('_', SignatureVisitor.SUPER).split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, -1);
        String str3 = split[0];
        String str4 = "";
        int i11 = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = str4;
        } else {
            str2 = split[1];
            i11 = 2;
        }
        if (split.length > i11 && split[i11].length() >= 2 && split[i11].length() <= 3) {
            str4 = split[i11];
        }
        return new Locale(str3, str4, str2);
    }

    @Nullable
    public Locale resolveNativeLocale(@Nullable List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList a11 = this.context.getResources().getConfiguration().getLocales();
            int a12 = a11.size();
            for (int i12 = 0; i12 < a12; i12++) {
                Locale a13 = a11.get(i12);
                String language = a13.getLanguage();
                if (!a13.getScript().isEmpty()) {
                    language = language + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + a13.getScript();
                }
                if (!a13.getCountry().isEmpty()) {
                    language = language + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + a13.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(a13.getLanguage()));
                arrayList.add(new Locale.LanguageRange(a13.getLanguage() + "-*"));
            }
            Locale a14 = Locale.lookup(arrayList, list);
            if (a14 != null) {
                return a14;
            }
            return list.get(0);
        } else if (i11 >= 24) {
            LocaleList a15 = this.context.getResources().getConfiguration().getLocales();
            for (int i13 = 0; i13 < a15.size(); i13++) {
                Locale a16 = a15.get(i13);
                for (Locale next : list) {
                    if (a16.equals(next)) {
                        return next;
                    }
                }
                for (Locale next2 : list) {
                    if (a16.getLanguage().equals(next2.toLanguageTag())) {
                        return next2;
                    }
                }
                for (Locale next3 : list) {
                    if (a16.getLanguage().equals(next3.getLanguage())) {
                        return next3;
                    }
                }
            }
            return list.get(0);
        } else {
            Locale locale = this.context.getResources().getConfiguration().locale;
            if (locale != null) {
                for (Locale next4 : list) {
                    if (locale.equals(next4)) {
                        return next4;
                    }
                }
                for (Locale next5 : list) {
                    if (locale.getLanguage().equals(next5.toString())) {
                        return next5;
                    }
                }
            }
            return list.get(0);
        }
    }

    public void sendLocalesToFlutter(@NonNull Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList a11 = configuration.getLocales();
            int a12 = a11.size();
            for (int i11 = 0; i11 < a12; i11++) {
                arrayList.add(a11.get(i11));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.localizationChannel.sendLocales(arrayList);
    }
}
