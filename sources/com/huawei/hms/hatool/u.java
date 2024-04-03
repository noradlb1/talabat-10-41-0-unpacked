package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private List<b1> f49135a;

    /* renamed from: b  reason: collision with root package name */
    private String f49136b;

    /* renamed from: c  reason: collision with root package name */
    private String f49137c;

    /* renamed from: d  reason: collision with root package name */
    private String f49138d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f49135a = list;
        this.f49136b = str;
        this.f49137c = str2;
        this.f49138d = str3;
    }

    private void a(List<b1> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            for (int i11 = 0; i11 < size; i11++) {
                int i12 = i11 * 500;
                List<b1> subList = list.subList(i12, Math.min(list.size(), i12 + 500));
                String replace = UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
                long currentTimeMillis = System.currentTimeMillis();
                long b11 = ((long) a1.b(str2, str)) * 86400000;
                ArrayList arrayList = new ArrayList();
                for (b1 next : subList) {
                    if (!c0.a(next.b(), currentTimeMillis, b11)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    new l0(str2, str, this.f49138d, arrayList, replace).a();
                } else {
                    v.e("hmsSdk", "No data to report handler");
                }
            }
        }
    }

    public void a() {
        if ("_default_config_tag".equals(this.f49137c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (b1 next : this.f49135a) {
                String c11 = next.c();
                if (TextUtils.isEmpty(c11) || "oper".equals(c11)) {
                    arrayList4.add(next);
                } else if ("maint".equals(c11)) {
                    arrayList.add(next);
                } else if ("preins".equals(c11)) {
                    arrayList2.add(next);
                } else if ("diffprivacy".equals(c11)) {
                    arrayList3.add(next);
                }
            }
            a(arrayList4, "oper", "_default_config_tag");
            a(arrayList, "maint", "_default_config_tag");
            a(arrayList2, "preins", "_default_config_tag");
            a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        a(this.f49135a, this.f49137c, this.f49136b);
    }
}
