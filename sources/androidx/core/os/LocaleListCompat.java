package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.os.BuildCompat;
import androidx.core.text.ICUCompat;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    private final LocaleListInterface mImpl;

    @RequiresApi(21)
    public static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale(ArchiveStreamFactory.AR, "XB")};

        private Api21Impl() {
        }

        @DoNotInline
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        @DoNotInline
        public static boolean b(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
                return false;
            }
            String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (!maximizeAndGetScript.isEmpty()) {
                return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
            return false;
        }

        private static boolean isPseudoLocale(Locale locale) {
            for (Locale equals : PSEUDO_LOCALE) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @DoNotInline
        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static Locale a(String str) {
        if (str.contains(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
            String[] split = str.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains(JavaConstant.Dynamic.DEFAULT_NAME)) {
            return new Locale(str);
        } else {
            String[] split2 = str.split(JavaConstant.Dynamic.DEFAULT_NAME, -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.a(localeArr));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i11 = 0; i11 < length; i11++) {
            localeArr[i11] = Api21Impl.a(split[i11]);
        }
        return create(localeArr);
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.b());
        }
        return create(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.c());
        }
        return create(Locale.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @RequiresApi(21)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean matchesLanguageAndScript(@NonNull Locale locale, @NonNull Locale locale2) {
        if (BuildCompat.isAtLeastT()) {
            return LocaleList.matchesLanguageAndScript(locale, locale2);
        }
        return Api21Impl.b(locale, locale2);
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap((LocaleList) obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.mImpl.equals(((LocaleListCompat) obj).mImpl);
    }

    @Nullable
    public Locale get(int i11) {
        return this.mImpl.get(i11);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.mImpl.getFirstMatch(strArr);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    @RequiresApi(24)
    @NonNull
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }
}
