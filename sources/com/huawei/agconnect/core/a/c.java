package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f47540a;

    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public c(Context context) {
        this.f47540a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        String str2;
        StringBuilder sb2;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (ServiceRegistrar) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e11) {
            str2 = "Can not found service class, " + e11.getMessage();
            Log.e("AGC_Registrar", str2);
            return null;
        } catch (InstantiationException e12) {
            e = e12;
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            sb2.append(e.getLocalizedMessage());
            str2 = sb2.toString();
            Log.e("AGC_Registrar", str2);
            return null;
        } catch (IllegalAccessException e13) {
            e = e13;
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            sb2.append(e.getLocalizedMessage());
            str2 = sb2.toString();
            Log.e("AGC_Registrar", str2);
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        Bundle c11 = c();
        if (c11 == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String next : c11.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c11.getString(next))) {
                String[] split = next.split(CertificateUtil.DELIMITER);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e11) {
                        sb2 = new StringBuilder();
                        sb2.append("registrar configuration format error:");
                        next = e11.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("registrar configuration error, ");
                    sb2.append(next);
                    Log.e("AGC_Registrar", sb2.toString());
                }
            }
        }
        ArrayList<Map.Entry> arrayList2 = new ArrayList<>(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        for (Map.Entry key : arrayList2) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        PackageManager packageManager = this.f47540a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f47540a, ServiceDiscovery.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e11.getLocalizedMessage());
        }
    }

    public List<Service> a() {
        Log.i("AGC_Registrar", "getServices");
        List<String> b11 = b();
        ArrayList arrayList = new ArrayList();
        for (String a11 : b11) {
            ServiceRegistrar a12 = a(a11);
            if (a12 != null) {
                a12.initialize(this.f47540a);
                List<Service> services = a12.getServices(this.f47540a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }
}
