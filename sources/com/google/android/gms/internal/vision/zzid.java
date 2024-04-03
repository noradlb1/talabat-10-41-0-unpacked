package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.lang3.StringUtils;

final class zzid {
    public static String zza(zzic zzic, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zza(zzic, sb2, 0);
        return sb2.toString();
    }

    private static final String zzz(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt)) {
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e5, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01f7, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0208, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x021a, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L_0x01e7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.vision.zzic r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeSet r5 = new java.util.TreeSet
            r5.<init>()
            java.lang.Class r6 = r18.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = r8
        L_0x0020:
            java.lang.String r10 = "get"
            if (r9 >= r7) goto L_0x004f
            r11 = r6[r9]
            java.lang.String r12 = r11.getName()
            r4.put(r12, r11)
            java.lang.Class[] r12 = r11.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x004c
            java.lang.String r12 = r11.getName()
            r3.put(r12, r11)
            java.lang.String r12 = r11.getName()
            boolean r10 = r12.startsWith(r10)
            if (r10 == 0) goto L_0x004c
            java.lang.String r10 = r11.getName()
            r5.add(r10)
        L_0x004c:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x004f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0053:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0269
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = ""
            java.lang.String r9 = r6.replaceFirst(r10, r7)
            java.lang.String r11 = "List"
            boolean r12 = r9.endsWith(r11)
            r13 = 1
            if (r12 == 0) goto L_0x00c9
            java.lang.String r12 = "OrBuilderList"
            boolean r12 = r9.endsWith(r12)
            if (r12 != 0) goto L_0x00c9
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x00c9
            java.lang.String r11 = r9.substring(r8, r13)
            java.lang.String r11 = r11.toLowerCase()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r12 = r9.length()
            int r12 = r12 + -4
            java.lang.String r12 = r9.substring(r13, r12)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            int r14 = r12.length()
            if (r14 == 0) goto L_0x00a1
            java.lang.String r11 = r11.concat(r12)
            goto L_0x00a7
        L_0x00a1:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r11)
            r11 = r12
        L_0x00a7:
            java.lang.Object r12 = r3.get(r6)
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            if (r12 == 0) goto L_0x00c9
            java.lang.Class r14 = r12.getReturnType()
            java.lang.Class<java.util.List> r15 = java.util.List.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x00c9
            java.lang.String r6 = zzz(r11)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.android.gms.internal.vision.zzgs.zza((java.lang.reflect.Method) r12, (java.lang.Object) r0, (java.lang.Object[]) r7)
            zza(r1, r2, r6, r7)
            goto L_0x0053
        L_0x00c9:
            java.lang.String r11 = "Map"
            boolean r12 = r9.endsWith(r11)
            if (r12 == 0) goto L_0x0137
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x0137
            java.lang.String r11 = r9.substring(r8, r13)
            java.lang.String r11 = r11.toLowerCase()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r12 = r9.length()
            int r12 = r12 + -3
            java.lang.String r12 = r9.substring(r13, r12)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            int r14 = r12.length()
            if (r14 == 0) goto L_0x00fc
            java.lang.String r11 = r11.concat(r12)
            goto L_0x0102
        L_0x00fc:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r11)
            r11 = r12
        L_0x0102:
            java.lang.Object r6 = r3.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 == 0) goto L_0x0137
            java.lang.Class r12 = r6.getReturnType()
            java.lang.Class<java.util.Map> r14 = java.util.Map.class
            boolean r12 = r12.equals(r14)
            if (r12 == 0) goto L_0x0137
            java.lang.Class<java.lang.Deprecated> r12 = java.lang.Deprecated.class
            boolean r12 = r6.isAnnotationPresent(r12)
            if (r12 != 0) goto L_0x0137
            int r12 = r6.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0137
            java.lang.String r7 = zzz(r11)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzgs.zza((java.lang.reflect.Method) r6, (java.lang.Object) r0, (java.lang.Object[]) r9)
            zza(r1, r2, r7, r6)
            goto L_0x0053
        L_0x0137:
            int r6 = r9.length()
            java.lang.String r11 = "set"
            if (r6 == 0) goto L_0x0144
            java.lang.String r6 = r11.concat(r9)
            goto L_0x0149
        L_0x0144:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r11)
        L_0x0149:
            java.lang.Object r6 = r4.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 == 0) goto L_0x0053
            java.lang.String r6 = "Bytes"
            boolean r6 = r9.endsWith(r6)
            if (r6 == 0) goto L_0x017d
            int r6 = r9.length()
            int r6 = r6 + -5
            java.lang.String r6 = r9.substring(r8, r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r11 = r6.length()
            if (r11 == 0) goto L_0x0172
            java.lang.String r6 = r10.concat(r6)
            goto L_0x0177
        L_0x0172:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r10)
        L_0x0177:
            boolean r6 = r3.containsKey(r6)
            if (r6 != 0) goto L_0x0053
        L_0x017d:
            java.lang.String r6 = r9.substring(r8, r13)
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r11 = r9.substring(r13)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r12 = r11.length()
            if (r12 == 0) goto L_0x019c
            java.lang.String r6 = r6.concat(r11)
            goto L_0x01a2
        L_0x019c:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r6)
            r6 = r11
        L_0x01a2:
            int r11 = r9.length()
            if (r11 == 0) goto L_0x01ad
            java.lang.String r11 = r10.concat(r9)
            goto L_0x01b2
        L_0x01ad:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10)
        L_0x01b2:
            java.lang.Object r11 = r3.get(r11)
            java.lang.reflect.Method r11 = (java.lang.reflect.Method) r11
            int r12 = r9.length()
            java.lang.String r14 = "has"
            if (r12 == 0) goto L_0x01c5
            java.lang.String r9 = r14.concat(r9)
            goto L_0x01ca
        L_0x01c5:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r14)
        L_0x01ca:
            java.lang.Object r9 = r3.get(r9)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r11 == 0) goto L_0x0053
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Object r11 = com.google.android.gms.internal.vision.zzgs.zza((java.lang.reflect.Method) r11, (java.lang.Object) r0, (java.lang.Object[]) r12)
            if (r9 != 0) goto L_0x0252
            boolean r9 = r11 instanceof java.lang.Boolean
            if (r9 == 0) goto L_0x01ec
            r7 = r11
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x01ea
        L_0x01e7:
            r7 = r13
            goto L_0x024d
        L_0x01ea:
            r7 = r8
            goto L_0x024d
        L_0x01ec:
            boolean r9 = r11 instanceof java.lang.Integer
            if (r9 == 0) goto L_0x01fa
            r7 = r11
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r7 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x01fa:
            boolean r9 = r11 instanceof java.lang.Float
            if (r9 == 0) goto L_0x020b
            r7 = r11
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x020b:
            boolean r9 = r11 instanceof java.lang.Double
            if (r9 == 0) goto L_0x021d
            r7 = r11
            java.lang.Double r7 = (java.lang.Double) r7
            double r14 = r7.doubleValue()
            r16 = 0
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x021d:
            boolean r9 = r11 instanceof java.lang.String
            if (r9 == 0) goto L_0x0226
            boolean r7 = r11.equals(r7)
            goto L_0x024d
        L_0x0226:
            boolean r7 = r11 instanceof com.google.android.gms.internal.vision.zzfh
            if (r7 == 0) goto L_0x0231
            com.google.android.gms.internal.vision.zzfh r7 = com.google.android.gms.internal.vision.zzfh.zzrx
            boolean r7 = r11.equals(r7)
            goto L_0x024d
        L_0x0231:
            boolean r7 = r11 instanceof com.google.android.gms.internal.vision.zzic
            if (r7 == 0) goto L_0x023f
            r7 = r11
            com.google.android.gms.internal.vision.zzic r7 = (com.google.android.gms.internal.vision.zzic) r7
            com.google.android.gms.internal.vision.zzic r7 = r7.zzgd()
            if (r11 != r7) goto L_0x01ea
            goto L_0x01e7
        L_0x023f:
            boolean r7 = r11 instanceof java.lang.Enum
            if (r7 == 0) goto L_0x01ea
            r7 = r11
            java.lang.Enum r7 = (java.lang.Enum) r7
            int r7 = r7.ordinal()
            if (r7 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x024d:
            if (r7 != 0) goto L_0x0250
            goto L_0x025e
        L_0x0250:
            r13 = r8
            goto L_0x025e
        L_0x0252:
            java.lang.Object[] r7 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.android.gms.internal.vision.zzgs.zza((java.lang.reflect.Method) r9, (java.lang.Object) r0, (java.lang.Object[]) r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r13 = r7.booleanValue()
        L_0x025e:
            if (r13 == 0) goto L_0x0053
            java.lang.String r6 = zzz(r6)
            zza(r1, r2, r6, r11)
            goto L_0x0053
        L_0x0269:
            boolean r3 = r0 instanceof com.google.android.gms.internal.vision.zzgs.zze
            if (r3 == 0) goto L_0x02aa
            r3 = r0
            com.google.android.gms.internal.vision.zzgs$zze r3 = (com.google.android.gms.internal.vision.zzgs.zze) r3
            com.google.android.gms.internal.vision.zzgi<com.google.android.gms.internal.vision.zzgs$zzd> r3 = r3.zzwk
            java.util.Iterator r3 = r3.iterator()
        L_0x0276:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02aa
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.google.android.gms.internal.vision.zzgs$zzd r5 = (com.google.android.gms.internal.vision.zzgs.zzd) r5
            int r5 = r5.number
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 13
            r6.<init>(r7)
            java.lang.String r7 = "["
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = "]"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object r4 = r4.getValue()
            zza(r1, r2, r5, r4)
            goto L_0x0276
        L_0x02aa:
            com.google.android.gms.internal.vision.zzgs r0 = (com.google.android.gms.internal.vision.zzgs) r0
            com.google.android.gms.internal.vision.zzjm r0 = r0.zzwd
            if (r0 == 0) goto L_0x02b3
            r0.zza((java.lang.StringBuilder) r1, (int) r2)
        L_0x02b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzid.zza(com.google.android.gms.internal.vision.zzic, java.lang.StringBuilder, int):void");
    }

    public static final void zza(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza : (List) obj) {
                zza(sb2, i11, str, zza);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza2 : ((Map) obj).entrySet()) {
                zza(sb2, i11, str, zza2);
            }
        } else {
            sb2.append(10);
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzjf.zzd(zzfh.zzw((String) obj)));
                sb2.append('\"');
            } else if (obj instanceof zzfh) {
                sb2.append(": \"");
                sb2.append(zzjf.zzd((zzfh) obj));
                sb2.append('\"');
            } else if (obj instanceof zzgs) {
                sb2.append(" {");
                zza((zzgs) obj, sb2, i11 + 2);
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i14 = i11 + 2;
                zza(sb2, i14, "key", entry.getKey());
                zza(sb2, i14, "value", entry.getValue());
                sb2.append(StringUtils.LF);
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj.toString());
            }
        }
    }
}
