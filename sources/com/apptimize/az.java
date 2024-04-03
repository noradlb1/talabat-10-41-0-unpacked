package com.apptimize;

import com.apptimize.bq;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.bytebuddy.description.type.TypeDescription;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class az {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41301a = "az";

    /* renamed from: b  reason: collision with root package name */
    private static final Map<ba, bc> f41302b;

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f41303c = Pattern.compile("\\d+");

    /* renamed from: d  reason: collision with root package name */
    private au f41304d;

    /* renamed from: e  reason: collision with root package name */
    private bc f41305e;

    /* renamed from: f  reason: collision with root package name */
    private f f41306f;

    /* renamed from: g  reason: collision with root package name */
    private ba f41307g;

    /* renamed from: h  reason: collision with root package name */
    private Object f41308h;

    public static class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private String f41311a;

        public b(String str) {
            super();
            this.f41311a = str;
        }

        public Object a(bb bbVar) {
            return bbVar.c().get(this.f41311a);
        }

        public void a(JSONObject jSONObject) throws JSONException {
            jSONObject.put("prefixedAttribute", (Object) this.f41311a);
        }

        public void a() {
            String b11 = az.f41301a;
            bo.i(b11, "Filter requests an unsupplied prefixed attribute: " + this.f41311a + ". Not Matching.");
        }
    }

    public static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private String f41312a;

        public c(String str) {
            super();
            this.f41312a = str;
        }

        public Object a(bb bbVar) {
            return az.b(this.f41312a, bbVar.a());
        }

        public boolean b(bb bbVar) {
            return bbVar.a().c(this.f41312a);
        }

        public void a(JSONObject jSONObject) throws JSONException {
            jSONObject.put("property", (Object) this.f41312a);
        }

        public void a() {
            String b11 = az.f41301a;
            bo.c(b11, "Filter has an unsupported property: " + this.f41312a + ". Not Matching.");
        }
    }

    public static class d extends f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f41313a;

        public d(String str) {
            super();
            this.f41313a = str;
        }

        public void a() {
        }

        public Object a(bb bbVar) {
            if (bbVar.d() != null && !bbVar.d().isEmpty()) {
                try {
                    return bbVar.d().get(az.a(bbVar.e().m().get(this.f41313a), bbVar.c(), bbVar.f()));
                } catch (MalformedURLException e11) {
                    bo.d(az.f41301a, "Apptimize secondary url request malformed", e11);
                } catch (UnsupportedEncodingException e12) {
                    bo.d(az.f41301a, "Apptimize secondary url encoding failed", e12);
                    return null;
                }
            }
            return null;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            String str = this.f41313a;
            if (str != null && "".compareTo(str) != 0) {
                jSONObject.put("callServerUrlKey", (Object) this.f41313a);
            }
        }
    }

    public static class e extends f {

        /* renamed from: a  reason: collision with root package name */
        private String f41314a;

        public e(String str) {
            super();
            this.f41314a = str;
        }

        public Object a(bb bbVar) {
            return bbVar.b().get(this.f41314a);
        }

        public void a(JSONObject jSONObject) throws JSONException {
            jSONObject.put("userAttribute", (Object) this.f41314a);
        }

        public void a() {
            String b11 = az.f41301a;
            bo.i(b11, "Filter requests an unsupplied user attribute: " + this.f41314a + ". Not Matching.");
        }
    }

    public static abstract class f {
        private f() {
        }

        public abstract Object a(bb bbVar);

        public abstract void a();

        public abstract void a(JSONObject jSONObject) throws JSONException;

        public boolean b(bb bbVar) {
            return false;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f41302b = hashMap;
        ba baVar = ba.Equals;
        bc bcVar = bc.Simple;
        hashMap.put(baVar, bcVar);
        hashMap.put(ba.NotEquals, bcVar);
        hashMap.put(ba.Regex, bcVar);
        hashMap.put(ba.NotRegex, bcVar);
        hashMap.put(ba.GreaterThan, bcVar);
        hashMap.put(ba.GreaterThanOrEqual, bcVar);
        hashMap.put(ba.LessThan, bcVar);
        hashMap.put(ba.LessThanOrEqual, bcVar);
        hashMap.put(ba.ValueOf, bcVar);
        ba baVar2 = ba.InList;
        bc bcVar2 = bc.List;
        hashMap.put(baVar2, bcVar2);
        hashMap.put(ba.NotInList, bcVar2);
        hashMap.put(ba.Intersection, bc.Set);
        ba baVar3 = ba.CompoundAnd;
        bc bcVar3 = bc.Compound;
        hashMap.put(baVar3, bcVar3);
        hashMap.put(ba.CompoundOr, bcVar3);
        hashMap.put(ba.CompoundNot, bcVar3);
        hashMap.put(ba.CompoundIsNull, bcVar3);
        hashMap.put(ba.CompoundIsNotNull, bcVar3);
        ba baVar4 = ba.IsPropertyNull;
        bc bcVar4 = bc.Propertyless;
        hashMap.put(baVar4, bcVar4);
        hashMap.put(ba.IsPropertyNotNull, bcVar4);
        hashMap.put(ba.IsRecognizedProperty, bcVar4);
        hashMap.put(ba.IsNotRecognizedProperty, bcVar4);
        hashMap.put(ba.IsRecognizedOperator, bcVar4);
        hashMap.put(ba.IsNotRecognizedOperator, bcVar4);
    }

    private az(bc bcVar, f fVar, ba baVar, Object obj, au auVar) {
        this.f41305e = bcVar;
        this.f41306f = fVar;
        this.f41307g = baVar;
        this.f41308h = obj;
        this.f41304d = auVar;
    }

    private String d(bb bbVar) throws MalformedURLException, UnsupportedEncodingException, ca {
        f fVar = this.f41306f;
        String str = null;
        if (!(fVar instanceof d)) {
            return null;
        }
        String a11 = ((d) fVar).f41313a;
        if (a11 != null) {
            str = bbVar.e().m().get(a11);
        }
        if (str != null) {
            return a(str, bbVar.c(), bbVar.f());
        }
        throw new ca("Unrecognized call server URL key");
    }

    private Boolean e(bb bbVar) {
        Boolean b11;
        Boolean b12;
        Boolean b13;
        if (this.f41305e == bc.Compound) {
            Object obj = this.f41308h;
            if (obj == null) {
                return null;
            }
            List<az> list = (List) obj;
            boolean z11 = true;
            if (list.size() < 1) {
                bo.f(f41301a, "Compound filter does not contain any children. Not matching.");
                return null;
            }
            ba baVar = this.f41307g;
            if (baVar == ba.CompoundAnd) {
                Boolean bool = Boolean.TRUE;
                for (az azVar : list) {
                    if (azVar == null || (b13 = azVar.b(bbVar)) == null) {
                        bool = null;
                    } else if (!b13.booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return bool;
            } else if (baVar == ba.CompoundOr) {
                Boolean bool2 = Boolean.FALSE;
                for (az azVar2 : list) {
                    if (azVar2 == null || (b12 = azVar2.b(bbVar)) == null) {
                        bool2 = null;
                    } else if (b12.booleanValue()) {
                        return Boolean.TRUE;
                    }
                }
                return bool2;
            } else if (baVar != ba.CompoundNot) {
                ba baVar2 = ba.CompoundIsNull;
                if (baVar != baVar2 && baVar != ba.CompoundIsNotNull) {
                    return null;
                }
                if (list.size() != 1) {
                    bo.b(f41301a, "FilterOperator " + a(this.f41307g) + " has more than one child. Not matching.");
                    return null;
                }
                az azVar3 = (az) list.get(0);
                if (azVar3 == null) {
                    if (this.f41307g != baVar2) {
                        z11 = false;
                    }
                    return Boolean.valueOf(z11);
                } else if (azVar3.b(bbVar) == null) {
                    if (this.f41307g != baVar2) {
                        z11 = false;
                    }
                    return Boolean.valueOf(z11);
                } else {
                    if (this.f41307g == baVar2) {
                        z11 = false;
                    }
                    return Boolean.valueOf(z11);
                }
            } else if (list.size() != 1) {
                bo.b(f41301a, "FilterOperator Not has more than one child. Not matching.");
                return null;
            } else {
                az azVar4 = (az) list.get(0);
                if (azVar4 == null || (b11 = azVar4.b(bbVar)) == null) {
                    return null;
                }
                return Boolean.valueOf(!b11.booleanValue());
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private Object f(bb bbVar) {
        bc bcVar = this.f41305e;
        if (bcVar == bc.Simple || bcVar == bc.List || bcVar == bc.Set) {
            Object a11 = this.f41306f.a(bbVar);
            if (a11 == null) {
                this.f41306f.a();
            }
            return a11;
        }
        throw new IllegalStateException("currentValue only valid for simple, list, and fold filters");
    }

    public Set<String> c(bb bbVar) throws MalformedURLException, UnsupportedEncodingException, ca {
        HashSet hashSet = new HashSet();
        a((Set<String>) hashSet, bbVar);
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.apptimize.az a(org.json.JSONObject r12, com.apptimize.au r13) throws org.json.JSONException {
        /*
            java.lang.String r0 = "property"
            r1 = 0
            java.lang.String r0 = r12.optString(r0, r1)
            if (r0 == 0) goto L_0x000f
            com.apptimize.az$c r2 = new com.apptimize.az$c
            r2.<init>(r0)
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            java.lang.String r3 = "userAttribute"
            java.lang.String r3 = r12.optString(r3, r1)
            if (r3 == 0) goto L_0x001d
            com.apptimize.az$e r2 = new com.apptimize.az$e
            r2.<init>(r3)
        L_0x001d:
            java.lang.String r4 = "prefixedAttribute"
            java.lang.String r4 = r12.optString(r4, r1)
            if (r4 == 0) goto L_0x002a
            com.apptimize.az$b r2 = new com.apptimize.az$b
            r2.<init>(r4)
        L_0x002a:
            java.lang.String r4 = "namedFilter"
            java.lang.String r4 = r12.optString(r4, r1)
            if (r4 == 0) goto L_0x0037
            com.apptimize.az$a r2 = new com.apptimize.az$a
            r2.<init>(r4, r13)
        L_0x0037:
            java.lang.String r5 = "callServerUrlKey"
            java.lang.String r5 = r12.optString(r5, r1)
            if (r5 == 0) goto L_0x0044
            com.apptimize.az$d r2 = new com.apptimize.az$d
            r2.<init>(r5)
        L_0x0044:
            r8 = r2
            java.lang.String r2 = "operator"
            java.lang.String r2 = r12.optString(r2)
            com.apptimize.ba r9 = a((java.lang.String) r2)
            com.apptimize.bc r7 = b((com.apptimize.ba) r9)
            com.apptimize.bc r2 = com.apptimize.bc.Compound
            r5 = 0
            java.lang.String r6 = "value"
            if (r7 != r2) goto L_0x0087
            org.json.JSONArray r12 = r12.optJSONArray(r6)
            if (r12 != 0) goto L_0x0062
            goto L_0x0084
        L_0x0062:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6 = r5
        L_0x0068:
            int r10 = r12.length()
            if (r6 == r10) goto L_0x0080
            org.json.JSONObject r10 = r12.getJSONObject(r6)     // Catch:{ Exception -> 0x007a }
            com.apptimize.az r10 = a((org.json.JSONObject) r10, (com.apptimize.au) r13)     // Catch:{ Exception -> 0x007a }
            r2.add(r10)     // Catch:{ Exception -> 0x007a }
            goto L_0x007d
        L_0x007a:
            r2.add(r1)
        L_0x007d:
            int r6 = r6 + 1
            goto L_0x0068
        L_0x0080:
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
        L_0x0084:
            r10 = r1
            goto L_0x014e
        L_0x0087:
            com.apptimize.bc r2 = com.apptimize.bc.List
            if (r7 != r2) goto L_0x00c8
            org.json.JSONArray r12 = r12.optJSONArray(r6)
            if (r12 != 0) goto L_0x0092
            goto L_0x0084
        L_0x0092:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6 = r5
        L_0x0098:
            int r10 = r12.length()
            if (r6 == r10) goto L_0x00c3
            boolean r10 = r12.isNull(r6)
            if (r10 == 0) goto L_0x00a8
            r2.add(r1)
            goto L_0x00c0
        L_0x00a8:
            java.lang.Object r10 = r12.get(r6)
            boolean r11 = r10 instanceof java.lang.String
            if (r11 != 0) goto L_0x00b9
            boolean r10 = r10 instanceof java.lang.Number
            if (r10 == 0) goto L_0x00b5
            goto L_0x00b9
        L_0x00b5:
            r2.add(r1)
            goto L_0x00c0
        L_0x00b9:
            java.lang.Object r10 = r12.get(r6)
            r2.add(r10)
        L_0x00c0:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00c3:
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
            goto L_0x0084
        L_0x00c8:
            com.apptimize.bc r2 = com.apptimize.bc.Set
            if (r7 != r2) goto L_0x0121
            com.apptimize.ba r2 = com.apptimize.ba.Intersection
            if (r9 != r2) goto L_0x0121
            org.json.JSONArray r12 = r12.optJSONArray(r6)
            if (r12 != 0) goto L_0x00d7
            goto L_0x0084
        L_0x00d7:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r6 = r5
        L_0x00dd:
            int r10 = r12.length()
            if (r6 == r10) goto L_0x011a
            boolean r10 = r12.isNull(r6)
            if (r10 == 0) goto L_0x00ed
            r2.add(r1)
            goto L_0x0117
        L_0x00ed:
            java.lang.Object r10 = r12.get(r6)
            boolean r11 = r10 instanceof java.lang.String
            if (r11 == 0) goto L_0x00ff
            java.lang.Object r10 = r12.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            r2.add(r10)
            goto L_0x0117
        L_0x00ff:
            boolean r11 = r10 instanceof java.lang.Integer
            if (r11 != 0) goto L_0x010c
            boolean r10 = r10 instanceof java.lang.Number
            if (r10 == 0) goto L_0x0108
            goto L_0x010c
        L_0x0108:
            r2.add(r1)
            goto L_0x0117
        L_0x010c:
            java.lang.Object r10 = r12.get(r6)
            java.lang.String r10 = r10.toString()
            r2.add(r10)
        L_0x0117:
            int r6 = r6 + 1
            goto L_0x00dd
        L_0x011a:
            java.util.Set r12 = java.util.Collections.unmodifiableSet(r2)
            r1 = r12
            goto L_0x0084
        L_0x0121:
            com.apptimize.bc r2 = com.apptimize.bc.Simple
            if (r7 == r2) goto L_0x0137
            com.apptimize.bc r2 = com.apptimize.bc.Propertyless
            if (r7 != r2) goto L_0x012a
            goto L_0x0137
        L_0x012a:
            java.lang.String r1 = f41301a
            java.lang.String r2 = "Unknown filter type. Setting value without any type checking."
            com.apptimize.bo.c(r1, r2)
            java.lang.Object r1 = r12.opt(r6)
            goto L_0x0084
        L_0x0137:
            boolean r2 = r12.isNull(r6)
            if (r2 == 0) goto L_0x013f
            goto L_0x0084
        L_0x013f:
            java.lang.Object r12 = r12.get(r6)
            boolean r2 = r12 instanceof java.lang.String
            if (r2 != 0) goto L_0x014d
            boolean r2 = r12 instanceof java.lang.Number
            if (r2 != 0) goto L_0x014d
            goto L_0x0084
        L_0x014d:
            r10 = r12
        L_0x014e:
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r5] = r0
            r0 = 1
            r12[r0] = r3
            r1 = 2
            r12[r1] = r4
            int r12 = com.apptimize.fx.a((java.lang.Object[]) r12)
            if (r12 > r0) goto L_0x0167
            com.apptimize.az r12 = new com.apptimize.az
            r6 = r12
            r11 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r12
        L_0x0167:
            org.json.JSONException r12 = new org.json.JSONException
            java.lang.String r13 = "At most one of property, userAttribute, and namedFilter can be non-null"
            r12.<init>((java.lang.String) r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.az.a(org.json.JSONObject, com.apptimize.au):com.apptimize.az");
    }

    public static Set<az> b(List<az> list, bb bbVar) {
        HashSet hashSet = new HashSet(list);
        hashSet.removeAll(a(list, bbVar));
        return hashSet;
    }

    public static class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final String f41309a;

        /* renamed from: b  reason: collision with root package name */
        private final au f41310b;

        public a(String str, au auVar) {
            super();
            this.f41309a = str;
            this.f41310b = auVar;
        }

        public Object a(bb bbVar) {
            Boolean a11 = bbVar.a(this.f41309a);
            if (a11 == null) {
                bo.e(az.f41301a, "Reference detected to unknown or out-of-order named filter");
                this.f41310b.a().a(bq.b.UnknownNamedFilter);
            }
            return a11;
        }

        public void a() {
        }

        public void a(JSONObject jSONObject) throws JSONException {
            jSONObject.put("namedFilter", (Object) this.f41309a);
        }
    }

    private static boolean c(String str, be beVar) {
        boolean b11 = beVar.b(str);
        if (!b11) {
            String str2 = f41301a;
            bo.f(str2, "Notice: Property: '" + str + "' is not available in this version of the Apptimize library. Returning null.");
        }
        return b11;
    }

    public Boolean b(bb bbVar) {
        bc bcVar = this.f41305e;
        if (bcVar == bc.Unknown) {
            bo.c(f41301a, "Filter has FilterType Unknown. Not Matching.");
            return null;
        }
        bc bcVar2 = bc.Simple;
        if (bcVar == bcVar2 || bcVar == bc.List || bcVar == bc.Set) {
            f fVar = this.f41306f;
            if (fVar == null) {
                bo.j(f41301a, "A specified filter is not supported in this version of Apptimize and will not be matched. Please consider updating.");
                return null;
            }
            boolean b11 = fVar.b(bbVar);
            Object f11 = f(bbVar);
            if (f11 == null) {
                return null;
            }
            bc bcVar3 = this.f41305e;
            if (bcVar3 == bcVar2) {
                return a(f11, b11);
            }
            if (bcVar3 == bc.List) {
                return b(f11, b11);
            }
            if (bcVar3 == bc.Set) {
                return a(f11);
            }
            return Boolean.FALSE;
        } else if (bcVar == bc.Compound) {
            return e(bbVar);
        } else {
            if (bcVar == bc.Propertyless) {
                return a(bbVar.a());
            }
            String str = f41301a;
            bo.b(str, "Filter Type not handled by doesFilterMatch: " + this.f41305e);
            return null;
        }
    }

    private static Boolean b(String str, String str2) {
        try {
            return Boolean.valueOf(Pattern.compile(str2, 2).matcher(str).matches());
        } catch (PatternSyntaxException unused) {
            String str3 = f41301a;
            bo.g(str3, "Targeting regex was invalid: " + str2);
            return null;
        }
    }

    private Boolean b(Object obj, boolean z11) {
        if (this.f41305e == bc.List) {
            Object obj2 = this.f41308h;
            if (obj2 == null) {
                return null;
            }
            List list = (List) obj2;
            if (obj == null) {
                bo.c(f41301a, "Unexpected currentValue is null. Not Matching.");
                return null;
            }
            bo.i(f41301a, "List Filter with operator \"" + a(this.f41307g) + "\" is comparing " + obj + " and " + list);
            Boolean bool = Boolean.FALSE;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next == null) {
                    bo.i(f41301a, "Filter with operator \"=\" is comparing " + obj + " and null");
                } else if (obj.equals(next)) {
                    bool = Boolean.TRUE;
                    bo.i(f41301a, "Filter with operator \"=\" is comparing " + obj + " and " + next);
                    break;
                } else {
                    Boolean a11 = a(obj, ba.Equals, next, z11);
                    if (a11 != null) {
                        if (a11.booleanValue()) {
                            bool = Boolean.TRUE;
                            break;
                        }
                    }
                }
                bool = null;
            }
            if (bool == null && (obj instanceof Set)) {
                bool = Boolean.valueOf(((Set) obj).containsAll(list));
                bo.i(f41301a, "Applying list filter to set " + obj);
            }
            if (bool == null) {
                return null;
            }
            ba baVar = this.f41307g;
            if (baVar == ba.NotInList) {
                return Boolean.valueOf(!bool.booleanValue());
            }
            if (baVar == ba.InList) {
                return bool;
            }
            return null;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public static Object b(String str, be beVar) {
        if (!c(str, beVar)) {
            return null;
        }
        try {
            Object a11 = beVar.a(str);
            if (a11 == null) {
                String str2 = f41301a;
                bo.f(str2, "Could not get value for device property: " + str);
            }
            return a11;
        } catch (RuntimeException e11) {
            String str3 = f41301a;
            bo.b(str3, "Error getting device property: " + str, e11);
            bo.f(str3, "Could not get value for device property: " + str);
            return null;
        }
    }

    public static bc b(ba baVar) {
        Map<ba, bc> map = f41302b;
        if (map.containsKey(baVar)) {
            return map.get(baVar);
        }
        String str = f41301a;
        bo.e(str, "Operator " + baVar + " is not mapped to a FilterType.");
        return bc.Unknown;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        f fVar = this.f41306f;
        if (fVar != null) {
            fVar.a(jSONObject);
        }
        jSONObject.put("operator", (Object) a(this.f41307g));
        Object obj = this.f41308h;
        if (obj != null) {
            bc bcVar = this.f41305e;
            if (bcVar == bc.Compound) {
                JSONArray jSONArray = new JSONArray();
                for (az azVar : (List) obj) {
                    if (azVar == null) {
                        jSONArray.put(JSONObject.NULL);
                    } else {
                        jSONArray.put((Object) azVar.a());
                    }
                }
                jSONObject.put("value", (Object) jSONArray);
            } else if (bcVar == bc.List) {
                JSONArray jSONArray2 = new JSONArray();
                for (Object put : (List) obj) {
                    jSONArray2.put(put);
                }
                jSONObject.put("value", (Object) jSONArray2);
            } else if (bcVar == bc.Set) {
                JSONArray jSONArray3 = new JSONArray();
                for (Object put2 : (Set) obj) {
                    jSONArray3.put(put2);
                }
                jSONObject.put("value", (Object) jSONArray3);
            } else {
                jSONObject.put("value", obj);
            }
        }
        return jSONObject;
    }

    public static JSONArray a(List<az> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (az a11 : list) {
            jSONArray.put((Object) a11.a());
        }
        return jSONArray;
    }

    public JSONObject a(bb bbVar) throws JSONException {
        bc bcVar = this.f41305e;
        if (bcVar != bc.Simple && bcVar != bc.List && bcVar != bc.Set) {
            return null;
        }
        JSONObject a11 = a();
        a11.put("current_device_value", f(bbVar));
        return a11;
    }

    public static Set<az> a(List<az> list, bb bbVar) {
        HashSet hashSet = new HashSet();
        for (az next : list) {
            Boolean b11 = next.b(bbVar);
            if (b11 != null && b11.booleanValue()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    public static JSONArray a(Collection<az> collection, bb bbVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (az a11 : collection) {
            JSONObject a12 = a11.a(bbVar);
            if (a12 != null) {
                jSONArray.put((Object) a12);
            }
        }
        return jSONArray;
    }

    private Boolean a(Object obj, boolean z11) {
        if (this.f41305e != bc.Simple) {
            throw new IllegalStateException();
        } else if (obj != null) {
            return a(obj, this.f41307g, this.f41308h, z11);
        } else {
            bo.c(f41301a, "Unexpected currentValue is null. Not Matching.");
            return null;
        }
    }

    private static Boolean a(Object obj, ba baVar, Object obj2, boolean z11) {
        Boolean bool;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Number) && (obj2 instanceof String)) {
            try {
                obj2 = Double.valueOf((String) obj2);
            } catch (NumberFormatException unused) {
            }
        }
        if ((obj instanceof String) && (obj2 instanceof Number)) {
            try {
                obj = Double.valueOf((String) obj);
            } catch (NumberFormatException unused2) {
            }
        }
        if (obj instanceof String) {
            if (obj2 == null) {
                bo.e(f41301a, "Filter expected String value but has null filter value");
                return null;
            } else if (obj2 instanceof String) {
                return a((String) obj, baVar, (String) obj2, z11);
            } else {
                String str = f41301a;
                bo.e(str, "Filter expected String value but has invalid filter value:" + obj2 + " (class = " + obj2.getClass() + "). Not Matching.");
                return null;
            }
        } else if (!(obj instanceof Number)) {
            boolean z12 = obj instanceof Boolean;
            if (z12 && obj2 == null && baVar == ba.ValueOf) {
                return (Boolean) obj;
            }
            if (z12 && (obj2 instanceof String)) {
                if (obj2.equals("true")) {
                    bool = Boolean.TRUE;
                } else if (obj2.equals("false")) {
                    bool = Boolean.FALSE;
                } else {
                    String str2 = f41301a;
                    bo.e(str2, "Filter with boolean value got unexpected value " + obj2);
                }
                return a(((Boolean) obj).booleanValue(), baVar, bool.booleanValue());
            }
            return null;
        } else if (obj2 == null) {
            bo.e(f41301a, "Filter expected Number value but has null filter value");
            return null;
        } else if (obj2 instanceof Number) {
            return a(((Number) obj).doubleValue(), baVar, ((Number) obj2).doubleValue());
        } else {
            String str3 = f41301a;
            bo.e(str3, "Filter expected Number value but has invalid filter value:" + obj2 + " (class = " + obj2.getClass() + ") when Number expected. Not Matching.");
            return null;
        }
    }

    private static Boolean a(boolean z11, ba baVar, boolean z12) {
        String str = f41301a;
        bo.i(str, "Filter with operator \"" + a(baVar) + "\" is comparing " + z11 + " and " + z12);
        if (baVar != ba.Equals) {
            bo.e(str, "Filter with boolean value got unexpected operator " + baVar);
            return null;
        }
        return Boolean.valueOf(z11 == z12);
    }

    private static Boolean a(double d11, ba baVar, double d12) {
        bo.i(f41301a, "Filter with operator \"" + a(baVar) + "\" is comparing " + d11 + " and " + d12);
        double d13 = d11 - d12;
        boolean z11 = true;
        if (baVar == ba.Equals) {
            if (Math.abs(d13) >= 1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        } else if (baVar == ba.NotEquals) {
            if (Math.abs(d13) <= 1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        } else if (baVar == ba.GreaterThan) {
            if (d13 <= 1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        } else if (baVar == ba.GreaterThanOrEqual) {
            if (d13 <= -1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        } else if (baVar == ba.LessThan) {
            if (d13 >= -1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        } else if (baVar != ba.LessThanOrEqual) {
            return null;
        } else {
            if (d13 >= 1.0E-8d) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        }
    }

    private static Boolean a(String str, ba baVar, String str2, boolean z11) {
        bo.i(f41301a, "Filter with operator \"" + a(baVar) + "\" is comparing " + str + " and " + str2);
        if (baVar == ba.Regex) {
            return b(str, str2);
        }
        boolean z12 = true;
        if (baVar == ba.NotRegex) {
            Boolean b11 = b(str, str2);
            if (b11 == null) {
                return null;
            }
            return Boolean.valueOf(!b11.booleanValue());
        }
        if (z11) {
            try {
                if (baVar == ba.Equals) {
                    if (a(str, str2) != 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                } else if (baVar == ba.NotEquals) {
                    if (a(str, str2) == 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                } else if (baVar == ba.GreaterThan) {
                    if (a(str, str2) <= 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                } else if (baVar == ba.GreaterThanOrEqual) {
                    if (a(str, str2) < 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                } else if (baVar == ba.LessThan) {
                    if (a(str, str2) >= 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                } else if (baVar == ba.LessThanOrEqual) {
                    if (a(str, str2) > 0) {
                        z12 = false;
                    }
                    return Boolean.valueOf(z12);
                }
            } catch (NumberFormatException e11) {
                bo.b(f41301a, "Unable to compare version strings.", e11);
                return null;
            }
        } else if (baVar == ba.Equals) {
            return Boolean.valueOf(str.toLowerCase().equals(str2.toLowerCase()));
        } else {
            if (baVar == ba.NotEquals) {
                return Boolean.valueOf(!str.toLowerCase().equals(str2.toLowerCase()));
            }
        }
        return null;
    }

    private void a(Set<String> set, bb bbVar) throws MalformedURLException, UnsupportedEncodingException, ca {
        Object obj = this.f41308h;
        if (obj == null || this.f41305e != bc.Compound) {
            String d11 = d(bbVar);
            if (d11 != null && "".compareTo(d11) != 0) {
                set.add(d11);
                return;
            }
            return;
        }
        for (az a11 : (List) obj) {
            a11.a(set, bbVar);
        }
    }

    public static String a(String str, Map<String, Object> map, int i11) throws MalformedURLException, UnsupportedEncodingException {
        String a11 = a(str, map);
        if (a11 == null) {
            return null;
        }
        return a(new URL(a11), "metadataSequenceNumber", Integer.toString(i11)).toString();
    }

    public static String a(String str, Map<String, Object> map) throws UnsupportedEncodingException {
        Pattern compile = Pattern.compile("\\{([^\\}]+)\\}");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            Object obj = map.get(matcher.group(1));
            if (obj == null) {
                return null;
            }
            String encode = URLEncoder.encode(obj.toString(), "UTF-8");
            String replaceFirst = matcher.replaceFirst(encode);
            int start = matcher.start(0) + encode.length();
            Matcher matcher2 = compile.matcher(replaceFirst);
            matcher2.region(start, replaceFirst.length());
            matcher = matcher2;
            str = replaceFirst;
        }
        return str;
    }

    public static URL a(URL url, String str, String str2) throws MalformedURLException, UnsupportedEncodingException {
        String query = url.getQuery();
        return new URL(url.toString() + (((query == null || query.length() == 0) ? TypeDescription.Generic.OfWildcardType.SYMBOL : ContainerUtils.FIELD_DELIMITER) + URLEncoder.encode(str.toString(), "UTF-8") + "=" + URLEncoder.encode(str2.toString(), "UTF-8")));
    }

    public static int a(String str, String str2) throws NumberFormatException {
        Pattern pattern = f41303c;
        Matcher matcher = pattern.matcher(str);
        Matcher matcher2 = pattern.matcher(str2);
        boolean z11 = true;
        boolean z12 = true;
        while (true) {
            int i11 = 0;
            if (!z11 && !z12) {
                return 0;
            }
            z11 = matcher.find();
            int parseInt = z11 ? Integer.parseInt(matcher.group()) : 0;
            boolean find = matcher2.find();
            if (find) {
                i11 = Integer.parseInt(matcher2.group());
            }
            if (parseInt < i11) {
                return -1;
            }
            if (parseInt > i11) {
                return 1;
            }
            z12 = find;
        }
    }

    private Boolean a(Object obj) {
        if (this.f41305e == bc.Set) {
            Object obj2 = this.f41308h;
            if (obj2 == null) {
                return null;
            }
            Set set = (Set) obj2;
            if (obj == null) {
                bo.c(f41301a, "Unexpected currentValue is null. Not Matching.");
                return null;
            }
            String str = f41301a;
            bo.i(str, "Set Filter with operator \"" + a(this.f41307g) + "\" is comparing " + obj + " and " + set);
            HashSet hashSet = new HashSet(set);
            hashSet.retainAll((Set) obj);
            return new Boolean(!hashSet.isEmpty());
        }
        throw new IllegalStateException();
    }

    private Boolean a(be beVar) {
        Object obj = this.f41308h;
        if (obj == null || !(obj instanceof String)) {
            ba baVar = this.f41307g;
            if (baVar == ba.IsPropertyNull || baVar == ba.IsNotRecognizedProperty || baVar == ba.IsNotRecognizedOperator) {
                return Boolean.TRUE;
            }
            if (baVar == ba.IsPropertyNotNull || baVar == ba.IsRecognizedProperty || baVar == ba.IsRecognizedOperator) {
                return Boolean.FALSE;
            }
            bo.e(f41301a, "Operator is not handled by propertylessMatches: " + a(this.f41307g));
            return null;
        }
        ba baVar2 = this.f41307g;
        boolean z11 = false;
        if (baVar2 == ba.IsPropertyNull) {
            if (b((String) obj, beVar) == null) {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        } else if (baVar2 == ba.IsPropertyNotNull) {
            if (b((String) obj, beVar) != null) {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        } else if (baVar2 == ba.IsRecognizedProperty) {
            return Boolean.valueOf(c((String) obj, beVar));
        } else {
            if (baVar2 == ba.IsNotRecognizedProperty) {
                return Boolean.valueOf(!c((String) obj, beVar));
            }
            if (baVar2 == ba.IsRecognizedOperator) {
                if (a((String) obj) != ba.Unknown) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            } else if (baVar2 == ba.IsNotRecognizedOperator) {
                if (a((String) obj) == ba.Unknown) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            } else {
                bo.e(f41301a, "Operator is not handled by propertylessMatches: " + a(this.f41307g));
                return null;
            }
        }
    }

    public static ba a(String str) {
        ba a11 = ba.a(str);
        if (a11 == ba.Unknown) {
            String str2 = f41301a;
            bo.j(str2, "Operator \"" + str + "\" is not recognized by this Apptimize library");
        }
        return a11;
    }

    public static String a(ba baVar) {
        if (baVar == ba.Unknown) {
            String str = f41301a;
            bo.e(str, "Operator " + baVar + " is not mapped to a String.");
        }
        return baVar.toString();
    }
}
