package fwfd.com.fwfsdk.util;

import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class FWFBytes {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.lang.Object r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003f }
            r1.<init>()     // Catch:{ all -> 0x003f }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x003d }
            r2.<init>(r1)     // Catch:{ all -> 0x003d }
            boolean r0 = r4 instanceof com.google.gson.internal.LinkedTreeMap     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0018
            boolean r0 = r4 instanceof java.util.List     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            r2.writeObject(r4)     // Catch:{ all -> 0x003a }
            goto L_0x002c
        L_0x0018:
            com.google.gson.Gson r0 = fwfd.com.fwfsdk.util.FWFGson.getInstance()     // Catch:{ all -> 0x003a }
            boolean r3 = r0 instanceof com.google.gson.Gson     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0025
            java.lang.String r4 = r0.toJson((java.lang.Object) r4)     // Catch:{ all -> 0x003a }
            goto L_0x0029
        L_0x0025:
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x003a }
        L_0x0029:
            r2.writeObject(r4)     // Catch:{ all -> 0x003a }
        L_0x002c:
            r2.flush()     // Catch:{ all -> 0x003a }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x003a }
            r2.close()
            r1.close()
            return r4
        L_0x003a:
            r4 = move-exception
            r0 = r2
            goto L_0x0041
        L_0x003d:
            r4 = move-exception
            goto L_0x0041
        L_0x003f:
            r4 = move-exception
            r1 = r0
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r1.close()
        L_0x004b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.util.FWFBytes.toByteArray(java.lang.Object):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object toObject(byte[] r3) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x001d }
            r1.<init>(r3)     // Catch:{ all -> 0x001d }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0018 }
            r3.<init>(r1)     // Catch:{ all -> 0x0018 }
            java.lang.Object r0 = r3.readObject()     // Catch:{ all -> 0x0016 }
            r1.close()
            r3.close()
            return r0
        L_0x0016:
            r0 = move-exception
            goto L_0x0021
        L_0x0018:
            r3 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
            goto L_0x0021
        L_0x001d:
            r3 = move-exception
            r1 = r0
            r0 = r3
            r3 = r1
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()
        L_0x0026:
            if (r3 == 0) goto L_0x002b
            r3.close()
        L_0x002b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.util.FWFBytes.toObject(byte[]):java.lang.Object");
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }
}
