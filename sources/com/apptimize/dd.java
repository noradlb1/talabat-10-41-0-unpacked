package com.apptimize;

import java.util.HashMap;
import java.util.Map;

public class dd {

    /* renamed from: a  reason: collision with root package name */
    private static final ex<b, db> f41757a = new ex<>(10000);

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final String f41761a = b("PhoneWindowDecorView");

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, String> f41762b = new HashMap<String, String>() {
            {
                put("com.android.internal.policy.impl.PhoneWindow$DecorView", a.f41761a);
                put("com.android.internal.policy.PhoneWindow$DecorView", a.f41761a);
                put("com.android.internal.policy.DecorView", a.f41761a);
            }
        };

        private static String b(String str) {
            return "apptimize.renames.osagnostic." + str;
        }

        public static String a(String str) {
            String str2 = f41762b.get(str);
            return str2 != null ? str2 : str;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f41763a;

        /* renamed from: b  reason: collision with root package name */
        private final String f41764b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f41765c;

        public b(Class<?> cls, String str, Integer num) {
            this.f41763a = cls;
            this.f41764b = str;
            this.f41765c = num;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            Class<?> cls = this.f41763a;
            if (cls == null ? bVar.f41763a != null : !cls.equals(bVar.f41763a)) {
                return false;
            }
            String str = this.f41764b;
            if (str == null ? bVar.f41764b != null : !str.equals(bVar.f41764b)) {
                return false;
            }
            Integer num = this.f41765c;
            Integer num2 = bVar.f41765c;
            if (num != null) {
                if (num.equals(num2)) {
                    return true;
                }
            } else if (num2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12;
            Class<?> cls = this.f41763a;
            int i13 = 0;
            if (cls != null) {
                i11 = cls.hashCode();
            } else {
                i11 = 0;
            }
            int i14 = i11 * 31;
            String str = this.f41764b;
            if (str != null) {
                i12 = str.hashCode();
            } else {
                i12 = 0;
            }
            int i15 = (i14 + i12) * 31;
            Integer num = this.f41765c;
            if (num != null) {
                i13 = num.hashCode();
            }
            return i15 + i13;
        }
    }

    public static db a(Class cls, String str, Integer num) {
        if (cls == null) {
            throw new IllegalArgumentException("viewClass cannot be null");
        } else if (str != null) {
            b bVar = new b(cls, str, num);
            ex<b, db> exVar = f41757a;
            db dbVar = exVar.get(bVar);
            if (dbVar != null) {
                return dbVar;
            }
            db dbVar2 = new db((Map<String, Object>) new HashMap<String, Object>(cls, num, str) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Class f41758a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Integer f41759b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f41760c;

                {
                    this.f41758a = r2;
                    this.f41759b = r3;
                    this.f41760c = r4;
                    put("viewClass", a.a(r2.getName()));
                    if (r3 != null) {
                        put(r4, r3);
                    }
                }
            });
            exVar.put(bVar, dbVar2);
            return dbVar2;
        } else {
            throw new IllegalArgumentException("extraKey cannot be null");
        }
    }

    public static void a(Map<String, Object> map) {
        Object obj = map.get("viewClass");
        if (obj instanceof String) {
            map.put("viewClass", a.a((String) obj));
        }
    }
}
