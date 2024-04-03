package com.apptimize;

import com.apptimize.dl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class dp {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, k> f41860a;

    /* renamed from: e  reason: collision with root package name */
    private static final String f41861e = "dp";

    /* renamed from: b  reason: collision with root package name */
    public final m f41862b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41863c;

    /* renamed from: d  reason: collision with root package name */
    public final long f41864d;

    /* renamed from: f  reason: collision with root package name */
    private final long f41865f;

    /* renamed from: g  reason: collision with root package name */
    private final long f41866g;

    /* renamed from: h  reason: collision with root package name */
    private final long f41867h;

    /* renamed from: i  reason: collision with root package name */
    private final long f41868i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Object> f41869j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f41870k;

    public static class a extends dp {

        /* renamed from: com.apptimize.dp$a$a  reason: collision with other inner class name */
        public static abstract class C0036a<T extends C0036a<T>> extends d<T, a> {
            public C0036a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            /* renamed from: a */
            public a f() {
                return new a(this);
            }
        }

        public static class b extends C0036a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public a(C0036a<?> aVar) {
            super(aVar);
        }

        public static C0036a<?> c() {
            return new b(m.APP_TO_BACKGROUND);
        }

        public void e(JSONObject jSONObject) {
        }
    }

    public static class b extends dp {

        public static abstract class a<T extends a<T>> extends d<T, b> {
            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            /* renamed from: a */
            public b f() {
                return new b(this);
            }
        }

        /* renamed from: com.apptimize.dp$b$b  reason: collision with other inner class name */
        public static class C0037b extends a<C0037b> {
            public C0037b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public C0037b j() {
                return this;
            }
        }

        public b(a<?> aVar) {
            super(aVar);
        }

        public static a<?> c() {
            return new C0037b(m.APP_TO_FOREGROUND);
        }

        public void e(JSONObject jSONObject) {
        }
    }

    public static class c extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final Set<Long> f41871e;

        /* renamed from: f  reason: collision with root package name */
        private final List<ek> f41872f;

        public static abstract class a<T extends a<T>> extends d<T, c> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Set<Long> f41873a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public List<ek> f41874b;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T a(Set<Long> set) {
                this.f41873a = set;
                return (a) j();
            }

            public T b(Map<String, Object> map) {
                return (a) j();
            }

            public T a(List<ek> list) {
                this.f41874b = list;
                return (a) j();
            }

            /* renamed from: a */
            public c f() {
                return new c(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public c(a<?> aVar) {
            super(aVar);
            this.f41871e = Collections.unmodifiableSet(new HashSet(aVar.f41873a));
            this.f41872f = new ArrayList(aVar.f41874b);
        }

        public static a<?> c() {
            return new b(m.ATTRIBUTES_CHANGED);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("v", (Object) new JSONArray((Collection<?>) this.f41871e));
            JSONArray jSONArray = new JSONArray();
            for (ek next : this.f41872f) {
                if (!(next.d() == -1 || next.c() == -1)) {
                    jSONArray.put((Object) next.a());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("vp", (Object) jSONArray);
            }
        }
    }

    public static abstract class d<T extends d<T, E>, E extends dp> implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final m f41875a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f41876b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f41877c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public long f41878d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public long f41879e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f41880f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f41881g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public Map<String, Object> f41882h;

        /* renamed from: i  reason: collision with root package name */
        private String f41883i;

        public d(m mVar) {
            this.f41875a = mVar;
        }

        public k c() {
            return null;
        }

        public abstract E f();

        public abstract T j();

        public T a(String str) {
            this.f41883i = str;
            return j();
        }

        public T b(String str) {
            this.f41876b = str;
            return j();
        }

        public T c(long j11) {
            this.f41879e = j11;
            return j();
        }

        public T d(long j11) {
            this.f41878d = j11;
            return j();
        }

        public T e(long j11) {
            this.f41877c = j11;
            return j();
        }

        public Map<String, Object> g() {
            return this.f41882h;
        }

        public m h() {
            return this.f41875a;
        }

        public T a(long j11) {
            this.f41881g = j11;
            return j();
        }

        public T b(long j11) {
            this.f41880f = j11;
            return j();
        }

        public long d() {
            return this.f41880f;
        }

        public long e() {
            return this.f41879e;
        }

        public T a(Map<String, Object> map) {
            this.f41882h = map;
            return j();
        }

        public String b() {
            return this.f41883i;
        }
    }

    public static class e extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final int f41884e;

        public static abstract class a<T extends a<T>> extends d<T, e> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f41885a;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public T a(int i11) {
                this.f41885a = i11;
                return (a) j();
            }

            /* renamed from: a */
            public e f() {
                return new e(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public e(a<?> aVar) {
            super(aVar);
            this.f41884e = aVar.f41885a;
        }

        public static a<?> c() {
            return new b(m.DATA_TYPE_LIMIT_REACHED);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put(c.f41585a, this.f41884e);
        }
    }

    public static class f extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final List<db> f41886e;

        public static abstract class a<T extends a<T>> extends d<T, f> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public List<db> f41887a;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T a(List<db> list) {
                this.f41887a = list;
                return (a) j();
            }

            /* renamed from: a */
            public f f() {
                return new f(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public f(a<?> aVar) {
            super(aVar);
            this.f41886e = new ArrayList(aVar.f41887a);
        }

        public static a<?> c() {
            return new b(m.ELEMENT_SHOWN);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("s", (Object) db.a(this.f41886e));
        }
    }

    public static class g extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final String f41888e;

        /* renamed from: f  reason: collision with root package name */
        private final k f41889f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, Object> f41890g;

        public static abstract class a<T extends a<T>> extends d<T, g> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f41891a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public k f41892b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public Map<String, Object> f41893c;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public T c(String str) {
                this.f41891a = str;
                return (a) j();
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T a(k kVar) {
                this.f41892b = kVar;
                return (a) j();
            }

            public T b(Map<String, Object> map) {
                this.f41893c = map;
                return (a) j();
            }

            public k c() {
                return this.f41892b;
            }

            /* renamed from: a */
            public g f() {
                return new g(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public g(a<?> aVar) {
            super(aVar);
            this.f41888e = aVar.f41891a;
            this.f41889f = aVar.f41892b;
            this.f41890g = Collections.unmodifiableMap(new HashMap(aVar.f41893c));
        }

        public static a<?> c() {
            return new b(m.EVENT);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("n", (Object) this.f41888e);
            jSONObject.put("s", (Object) this.f41889f.a());
            jSONObject.put("a", (Object) new JSONObject((Map<?, ?>) this.f41890g));
        }
    }

    public static class h extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final String f41894e;

        /* renamed from: f  reason: collision with root package name */
        private final Map<String, Object> f41895f;

        public static abstract class a<T extends a<T>> extends d<T, h> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f41896a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public Map<String, Object> f41897b;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T c(String str) {
                this.f41896a = str;
                return (a) j();
            }

            /* renamed from: a */
            public h f() {
                return new h(this);
            }

            public T b(Map<String, Object> map) {
                this.f41897b = map;
                return (a) j();
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public h(a<?> aVar) {
            super(aVar);
            this.f41894e = aVar.f41896a;
            this.f41895f = Collections.unmodifiableMap(new HashMap(aVar.f41897b));
        }

        public static a<?> c() {
            return new b(m.INTERNAL_EVENT);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("n", (Object) this.f41894e);
            jSONObject.put("a", (Object) new JSONObject((Map<?, ?>) this.f41895f));
        }
    }

    public static class i extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final long f41898e;

        /* renamed from: f  reason: collision with root package name */
        private final long f41899f;

        public static abstract class a<T extends a<T>> extends d<T, i> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f41900a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f41901b;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public T f(long j11) {
                this.f41900a = j11;
                return (a) j();
            }

            public T g(long j11) {
                this.f41901b = j11;
                return (a) j();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            /* renamed from: a */
            public i f() {
                return new i(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public i(a<?> aVar) {
            super(aVar);
            this.f41898e = aVar.f41900a;
            this.f41899f = aVar.f41901b;
        }

        public static a<?> c() {
            return new b(m.JUMPED_BACK_IN_TIME);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("f", this.f41898e);
            jSONObject.put("p", this.f41899f);
        }
    }

    public static class j extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final int f41902e;

        /* renamed from: f  reason: collision with root package name */
        private final Set<Long> f41903f;

        /* renamed from: g  reason: collision with root package name */
        private final List<ek> f41904g;

        public static abstract class a<T extends a<T>> extends d<T, j> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f41905a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public Set<Long> f41906b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public List<ek> f41907c;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public T a(int i11) {
                this.f41905a = i11;
                return (a) j();
            }

            public T a(Set<Long> set) {
                this.f41906b = set;
                return (a) j();
            }

            public T a(List<ek> list) {
                this.f41907c = list;
                return (a) j();
            }

            /* renamed from: a */
            public j f() {
                return new j(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public j(a<?> aVar) {
            super(aVar);
            this.f41902e = aVar.f41905a;
            this.f41903f = Collections.unmodifiableSet(new HashSet(aVar.f41906b));
            this.f41904g = new ArrayList(aVar.f41907c);
        }

        public static a<?> c() {
            return new b(m.META_DATA_PROCESSED);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("s", this.f41902e);
            jSONObject.put("v", (Object) new JSONArray((Collection<?>) this.f41903f));
            JSONArray jSONArray = new JSONArray();
            for (ek next : this.f41904g) {
                if (!(next.d() == -1 || next.c() == -1)) {
                    jSONArray.put((Object) next.a());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("vp", (Object) jSONArray);
            }
        }
    }

    public enum k {
        Apptimize("a", ""),
        Mixpanel("m", "mp: "),
        Flurry("f", "fl: "),
        Firebase(fb.f42395a, "fb: "),
        Localytics("l", "lo: "),
        Amplitude("amp", "am: "),
        Appboy("ab", "ab: "),
        GoogleAnalyticsV3("g3", "ga: "),
        GoogleAnalyticsV4("g4", "ga: "),
        OmnitureV2("oa2", "om: "),
        OmnitureV3("oa3", "om: "),
        OmnitureV4("oa4", "om: ");
        

        /* renamed from: m  reason: collision with root package name */
        private final String f41921m;

        /* renamed from: n  reason: collision with root package name */
        private final String f41922n;

        private k(String str, String str2) {
            this.f41921m = str;
            this.f41922n = str2;
        }

        public String a() {
            return this.f41921m;
        }

        public String b() {
            return this.f41922n;
        }
    }

    public static class l extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final long f41923e;

        /* renamed from: f  reason: collision with root package name */
        private final long f41924f;

        /* renamed from: g  reason: collision with root package name */
        private final long f41925g;

        public static abstract class a<T extends a<T>> extends d<T, l> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f41926a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f41927b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f41928c;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public T f(long j11) {
                this.f41926a = j11;
                return (a) j();
            }

            public T g(long j11) {
                this.f41927b = j11;
                return (a) j();
            }

            public T h(long j11) {
                this.f41928c = j11;
                return (a) j();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            /* renamed from: a */
            public l f() {
                return new l(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public l(a<?> aVar) {
            super(aVar);
            this.f41923e = aVar.f41926a;
            this.f41924f = aVar.f41927b;
            this.f41925g = aVar.f41928c;
        }

        public static a<?> c() {
            return new b(m.SUCCESSFULLY_POSTED_ENTRIES);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("t", this.f41923e);
            jSONObject.put("f", this.f41924f);
            jSONObject.put("l", this.f41925g);
        }
    }

    public enum m {
        EVENT("ee"),
        INTERNAL_EVENT("ie"),
        VARIANT_SHOWN("v"),
        APP_TO_FOREGROUND(fg.f42426a),
        APP_TO_BACKGROUND("bg"),
        META_DATA_PROCESSED("md"),
        JUMPED_BACK_IN_TIME("jb"),
        SUCCESSFULLY_POSTED_ENTRIES("sp"),
        DATA_TYPE_LIMIT_REACHED("dl"),
        ATTRIBUTES_CHANGED("ac"),
        ELEMENT_SHOWN("es"),
        ELEMENT_HIDDEN("eh"),
        VIEW_INTERACTION("vi"),
        USERID_START("us"),
        USERID_END("ue");
        

        /* renamed from: p  reason: collision with root package name */
        private final String f41945p;

        private m(String str) {
            this.f41945p = str;
        }

        public String a() {
            return this.f41945p;
        }
    }

    public static class n extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final String f41946e;

        public static abstract class a<T extends a<T>> extends d<T, n> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f41947a;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T c(String str) {
                this.f41947a = str;
                return (a) j();
            }

            /* renamed from: a */
            public n f() {
                return new n(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public n(a<?> aVar) {
            super(aVar);
            this.f41946e = aVar.f41947a;
        }

        public static a<?> c() {
            return new b(m.USERID_END);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("n", (Object) this.f41946e);
        }
    }

    public static class o extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final String f41948e;

        public static abstract class a<T extends a<T>> extends d<T, o> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f41949a;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T c(String str) {
                this.f41949a = str;
                return (a) j();
            }

            /* renamed from: a */
            public o f() {
                return new o(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public o(a<?> aVar) {
            super(aVar);
            this.f41948e = aVar.f41949a;
        }

        public static a<?> c() {
            return new b(m.USERID_START);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("p", (Object) this.f41948e);
        }
    }

    public static class p extends dp {

        /* renamed from: e  reason: collision with root package name */
        private final long f41950e;

        /* renamed from: f  reason: collision with root package name */
        private final ek f41951f;

        public static abstract class a<T extends a<T>> extends d<T, p> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f41952a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public ek f41953b;

            public a(m mVar) {
                super(mVar);
            }

            public /* bridge */ /* synthetic */ d b(long j11) {
                return super.b(j11);
            }

            public /* bridge */ /* synthetic */ d c(long j11) {
                return super.c(j11);
            }

            public /* bridge */ /* synthetic */ long d() {
                return super.d();
            }

            public /* bridge */ /* synthetic */ long e() {
                return super.e();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return super.g();
            }

            public /* bridge */ /* synthetic */ m h() {
                return super.h();
            }

            public /* bridge */ /* synthetic */ d a(long j11) {
                return super.a(j11);
            }

            public /* bridge */ /* synthetic */ d b(String str) {
                return super.b(str);
            }

            public /* bridge */ /* synthetic */ k c() {
                return super.c();
            }

            public /* bridge */ /* synthetic */ d d(long j11) {
                return super.d(j11);
            }

            public /* bridge */ /* synthetic */ d e(long j11) {
                return super.e(j11);
            }

            public T f(long j11) {
                this.f41952a = j11;
                return (a) j();
            }

            public /* bridge */ /* synthetic */ d a(String str) {
                return super.a(str);
            }

            public /* bridge */ /* synthetic */ d a(Map map) {
                return super.a((Map<String, Object>) map);
            }

            public /* bridge */ /* synthetic */ String b() {
                return super.b();
            }

            public T a(ek ekVar) {
                this.f41953b = ekVar;
                return (a) j();
            }

            /* renamed from: a */
            public p f() {
                return new p(this);
            }
        }

        public static class b extends a<b> {
            public b(m mVar) {
                super(mVar);
            }

            /* renamed from: i */
            public b j() {
                return this;
            }
        }

        public p(a<?> aVar) {
            super(aVar);
            this.f41950e = aVar.f41952a;
            this.f41951f = aVar.f41953b;
        }

        public static a<?> c() {
            return new b(m.VARIANT_SHOWN);
        }

        public void e(JSONObject jSONObject) throws JSONException {
            jSONObject.put("v", this.f41950e);
            ek ekVar = this.f41951f;
            if (ekVar != null && ekVar.d() != -1 && this.f41951f.c() != -1) {
                jSONObject.put("vp", (Object) this.f41951f.a());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f41860a = hashMap;
        hashMap.put(dl.b.AmplitudeProperty.a(), k.Amplitude);
        hashMap.put(dl.b.FirebaseProperty.a(), k.Firebase);
        hashMap.put(dl.b.FlurryProperty.a(), k.Flurry);
        hashMap.put(dl.b.MixpanelSuperProperty.a(), k.Mixpanel);
        hashMap.put(dl.b.OmnitureProperty.a(), k.OmnitureV4);
    }

    public dp(d<?, ?> dVar) {
        this.f41862b = dVar.f41875a;
        this.f41863c = dVar.f41876b;
        this.f41864d = dVar.f41877c;
        this.f41865f = dVar.f41878d;
        this.f41866g = dVar.f41879e;
        this.f41867h = dVar.f41880f;
        this.f41868i = dVar.f41881g;
        this.f41869j = Collections.unmodifiableMap(new HashMap(dVar.f41882h));
    }

    public static long a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getLong("ei");
    }

    public static long b(JSONObject jSONObject) throws JSONException {
        return jSONObject.getLong("mt");
    }

    public static Map<String, Object> c(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("pa");
        if (optJSONObject != null) {
            return fh.b(optJSONObject);
        }
        return new HashMap();
    }

    public static String d(JSONObject jSONObject) {
        String optString = jSONObject.optString("ui");
        if (optString == null || optString.length() != 0) {
            return optString;
        }
        return null;
    }

    public abstract void e(JSONObject jSONObject) throws JSONException;

    public static void a(List<JSONObject> list) {
        for (JSONObject remove : list) {
            remove.remove("ui");
        }
    }

    public void b() throws JSONException {
        this.f41870k = c();
    }

    private JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ei", this.f41864d);
        jSONObject.put("mt", this.f41865f);
        jSONObject.put("dt", this.f41866g);
        jSONObject.put("sb", this.f41867h);
        jSONObject.put("bt", this.f41868i);
        jSONObject.put("pa", (Object) new JSONObject((Map<?, ?>) this.f41869j));
        jSONObject.put("ty", (Object) this.f41862b.a());
        String str = this.f41863c;
        if (str != null && str.length() > 0) {
            jSONObject.put("ui", (Object) this.f41863c);
        }
        e(jSONObject);
        return jSONObject;
    }

    public JSONObject a() throws JSONException {
        if (this.f41870k == null) {
            bo.g(f41861e, "json representation should be generated beforehand");
            this.f41870k = c();
        }
        return this.f41870k;
    }
}
