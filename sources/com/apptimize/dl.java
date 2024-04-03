package com.apptimize;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dl {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f41827a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f41828b;

    public interface a {
        boolean a(Map.Entry<String, Object> entry);
    }

    public enum b {
        DeviceProperty("$"),
        UserAttribute("%"),
        AmplitudeProperty(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS),
        MixpanelSuperProperty("m"),
        FlurryProperty("f"),
        FirebaseProperty("F"),
        OmnitureProperty("o"),
        LocalAttribute("l"),
        InternalAttribute("^"),
        AirshipProperty("U");
        

        /* renamed from: k  reason: collision with root package name */
        private String f41840k;

        private b(String str) {
            this.f41840k = str;
        }

        public String a() {
            return this.f41840k;
        }

        public String a(String str) {
            if (!str.startsWith(this.f41840k)) {
                return null;
            }
            return str.substring(this.f41840k.length());
        }
    }

    public dl() {
        this.f41828b = null;
        this.f41827a = new HashMap();
    }

    public static dl a(JSONObject jSONObject) throws JSONException {
        return new dl(fh.b(jSONObject));
    }

    private static String b(b bVar, String str) {
        return bVar.a() + str;
    }

    public synchronized Map<String, Object> c() {
        if (this.f41828b == null) {
            this.f41828b = Collections.unmodifiableMap(this.f41827a);
        }
        return this.f41828b;
    }

    public static dl b(JSONObject jSONObject) throws JSONException {
        Map<String, Object> b11 = fh.b(jSONObject);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : b11.entrySet()) {
            hashMap.put(b(b.UserAttribute, (String) next.getKey()), next.getValue());
        }
        return new dl(hashMap);
    }

    public synchronized JSONObject a() throws JSONException {
        return new JSONObject((Map<?, ?>) this.f41827a);
    }

    private dl(Map<String, Object> map) {
        this.f41828b = null;
        this.f41827a = new HashMap(map);
    }

    public synchronized boolean a(b bVar, Map<String, Object> map) {
        boolean z11;
        z11 = false;
        for (Map.Entry next : map.entrySet()) {
            String b11 = b(bVar, (String) next.getKey());
            Object value = next.getValue();
            if (!fx.b(value, this.f41827a.get(b11))) {
                if (value == null) {
                    this.f41827a.remove(b11);
                } else {
                    this.f41827a.put(b11, value);
                }
                z11 = true;
            }
        }
        if (z11) {
            this.f41828b = null;
        }
        return z11;
    }

    public Map<String, Object> b(b bVar) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : c().entrySet()) {
            String a11 = bVar.a((String) next.getKey());
            if (a11 != null) {
                hashMap.put(a11, next.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a b() {
        return new a() {
            public boolean a(Map.Entry<String, Object> entry) {
                if (b.LocalAttribute.a(entry.getKey()) == null) {
                    return true;
                }
                return false;
            }
        };
    }

    public synchronized void a(b bVar) {
        Iterator<Map.Entry<String, Object>> it = this.f41827a.entrySet().iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (bVar.a((String) next.getKey()) != null) {
                z11 = next.getValue() != null;
                it.remove();
            }
        }
        if (z11) {
            this.f41828b = null;
        }
    }

    public synchronized Object a(b bVar, String str) {
        return this.f41827a.get(b(bVar, str));
    }

    public Map<String, Object> a(a aVar) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : c().entrySet()) {
            if (aVar.a(next)) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
