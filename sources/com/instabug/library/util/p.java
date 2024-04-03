package com.instabug.library.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.FilterEngine;
import com.instabug.library.core.InstabugCore;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

final class p {
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public static final Map f52080b;

    /* renamed from: c  reason: collision with root package name */
    private static final Set f52081c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f52082a;

    static {
        HashMap hashMap = new HashMap();
        f52080b = hashMap;
        hashMap.put("en", d("en"));
        hashMap.put(ArchiveStreamFactory.AR, d(ArchiveStreamFactory.AR));
        hashMap.put("cs", d("cs"));
        hashMap.put("da", d("da"));
        hashMap.put("de", d("de"));
        hashMap.put("es", d("es"));
        hashMap.put("fr", d("fr"));
        hashMap.put("it", d("it"));
        hashMap.put("ja", d("ja"));
        hashMap.put("ko", d("ko"));
        hashMap.put("nl", d("nl"));
        hashMap.put("no", d("no"));
        hashMap.put("pl", d("pl"));
        hashMap.put("pt", d("pt"));
        hashMap.put("ru", d("ru"));
        hashMap.put("sk", d("sk"));
        hashMap.put("sv", d("sv"));
        hashMap.put("tr", d("tr"));
        hashMap.put("zh", d("zh"));
        hashMap.put("fi", d("fi"));
        hashMap.put(FilterEngine.DEEPLINKSORT.ALPHABETIC, d(FilterEngine.DEEPLINKSORT.ALPHABETIC));
        hashMap.put("hu", d("hu"));
        hashMap.put("ca", d("ca"));
        HashSet hashSet = new HashSet();
        f52081c = hashSet;
        hashSet.add("no");
        hashSet.add("nb");
    }

    public p(Context context) {
        this.f52082a = context;
    }

    private String b(String str) {
        return (str.equals("no") || str.equals("nb")) ? "nb-NO" : "default";
    }

    @VisibleForTesting
    @NonNull
    public static List d(String str) {
        ArrayList arrayList = new ArrayList();
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3166:
                if (str.equals("ca")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3588:
                if (str.equals("pt")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                arrayList.add(Profile.Country.ES);
                return arrayList;
            case 1:
                arrayList.add("PT");
                arrayList.add(Profile.Country.BR);
                return arrayList;
            case 2:
                arrayList.add(Profile.Country.CN);
                arrayList.add("TW");
                return arrayList;
            default:
                return Collections.emptyList();
        }
    }

    public String a() {
        return b(InstabugCore.getLocale(this.f52082a));
    }

    @VisibleForTesting
    public boolean c(String str, String str2) {
        List list;
        if (g(str) && (list = (List) f52080b.get(str)) != null && list.contains(str2)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public boolean e(String str) {
        if (!g(str)) {
            return false;
        }
        List list = (List) f52080b.get(str);
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public boolean f(String str) {
        return f52081c.contains(str);
    }

    @VisibleForTesting
    public boolean g(String str) {
        return f52080b.containsKey(str) || f52081c.contains(str);
    }

    public String b(Locale locale) {
        String language = locale.getLanguage();
        return g(language) ? a(language, locale.getCountry()) : "default";
    }

    private String a(String str, String str2) {
        if (g(str) && f(str)) {
            return b(str);
        }
        if (g(str) && e(str)) {
            return str;
        }
        if (g(str) && c(str, str2)) {
            return str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str2;
        } else if (!g(str) || c(str, str2)) {
            return "default";
        } else {
            return str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + a(str);
        }
    }

    private String a(String str) {
        List d11 = d(str);
        return d11.size() > 0 ? (String) d11.get(0) : "";
    }
}
