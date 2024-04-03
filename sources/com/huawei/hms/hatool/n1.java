package com.huawei.hms.hatool;

import android.util.Pair;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public abstract class n1 {
    public static long a(String str, long j11) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j11))).getTime();
        } catch (ParseException unused) {
            v.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0;
        }
    }

    public static Pair<String, String> a(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    public static String a(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static String a(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str2;
    }

    public static String a(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str2 + "#" + str3;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (!"_default_config_tag".equals(next)) {
                String str = next + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + "oper";
                String str2 = next + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + "maint";
                hashSet.add(str);
                hashSet.add(str2);
                hashSet.add(next + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + "diffprivacy");
            } else {
                hashSet.add("_default_config_tag");
            }
        }
        return hashSet;
    }
}
