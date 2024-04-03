package com.apptimize;

public class fu {

    /* renamed from: a  reason: collision with root package name */
    private ThreadLocal<a> f42471a = new ThreadLocal<a>() {
        /* renamed from: a */
        public a initialValue() {
            return new a();
        }
    };

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f42473a;

        private a() {
            this.f42473a = 0;
        }

        public static /* synthetic */ int b(a aVar, int i11) {
            int i12 = aVar.f42473a - i11;
            aVar.f42473a = i12;
            return i12;
        }

        public static /* synthetic */ int a(a aVar, int i11) {
            int i12 = aVar.f42473a + i11;
            aVar.f42473a = i12;
            return i12;
        }
    }

    public void a() {
        a.a(this.f42471a.get(), 1);
    }

    public void b() {
        a.b(this.f42471a.get(), 1);
    }

    public int c() {
        return this.f42471a.get().f42473a;
    }
}
