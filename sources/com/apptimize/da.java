package com.apptimize;

import java.util.HashMap;
import java.util.Map;

public class da {

    /* renamed from: a  reason: collision with root package name */
    private static final ex<a, db> f41745a = new ex<>(10000);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f41750a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<?> f41751b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f41752c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f41753d;

        public a(String str, Class<?> cls, Class<?> cls2, Integer num) {
            this.f41750a = str;
            this.f41751b = cls;
            this.f41752c = cls2;
            this.f41753d = num;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f41750a;
            if (str == null ? aVar.f41750a != null : !str.equals(aVar.f41750a)) {
                return false;
            }
            Class<?> cls = this.f41751b;
            if (cls == null ? aVar.f41751b != null : !cls.equals(aVar.f41751b)) {
                return false;
            }
            if (this.f41753d != aVar.f41753d) {
                return false;
            }
            Class<?> cls2 = this.f41752c;
            Class<?> cls3 = aVar.f41752c;
            if (cls2 != null) {
                if (cls2.equals(cls3)) {
                    return true;
                }
            } else if (cls3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            String str = this.f41750a;
            int i14 = 0;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            int i15 = i11 * 31;
            Class<?> cls = this.f41751b;
            if (cls != null) {
                i12 = cls.hashCode();
            } else {
                i12 = 0;
            }
            int i16 = (i15 + i12) * 37;
            Class<?> cls2 = this.f41752c;
            if (cls2 != null) {
                i13 = cls2.hashCode();
            } else {
                i13 = 0;
            }
            int i17 = (i16 + i13) * 41;
            Integer num = this.f41753d;
            if (num != null) {
                i14 = num.hashCode();
            }
            return i17 + i14;
        }
    }

    public static db a(String str, Class<?> cls, Class<?> cls2) {
        return a(str, cls, cls2, (Integer) null);
    }

    public static db a(String str, Class<?> cls, Class<?> cls2, Integer num) {
        if (str == null) {
            throw new IllegalStateException("classKey cannot be null");
        } else if (cls != null) {
            a aVar = new a(str, cls, cls2, num);
            ex<a, db> exVar = f41745a;
            db dbVar = exVar.get(aVar);
            if (dbVar != null) {
                return dbVar;
            }
            db dbVar2 = new db((Map<String, Object>) new HashMap<String, Object>(str, cls, cls2, num) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f41746a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Class f41747b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Class f41748c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Integer f41749d;

                {
                    this.f41746a = r1;
                    this.f41747b = r2;
                    this.f41748c = r3;
                    this.f41749d = r4;
                    put(r1, r2.getName());
                    if (r3 != null) {
                        put("parentActivityClass", r3.getName());
                    }
                    if (r4 != null) {
                        put("pageAdapterPosition", r4);
                    }
                }
            });
            exVar.put(aVar, dbVar2);
            return dbVar2;
        } else {
            throw new IllegalStateException("classValue cannot be null");
        }
    }
}
