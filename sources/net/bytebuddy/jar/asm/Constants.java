package net.bytebuddy.jar.asm;

import java.util.regex.Pattern;

final class Constants {
    private Constants() {
    }

    public static void a(Object obj) {
        Class<?> cls = obj.getClass();
        String replace = cls.getName().replace('.', '/');
        if (!c(replace)) {
            ClassLoader classLoader = cls.getClassLoader();
            b(classLoader.getResourceAsStream(replace + ".class"));
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.io.InputStream r2) {
        /*
            if (r2 == 0) goto L_0x002d
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0024 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0024 }
            r0.readInt()     // Catch:{ all -> 0x001f }
            int r2 = r0.readUnsignedShort()     // Catch:{ all -> 0x001f }
            r0.close()     // Catch:{ IOException -> 0x0024 }
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r0) goto L_0x0017
            return
        L_0x0017:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = "ASM9_EXPERIMENTAL can only be used by classes compiled with --enable-preview"
            r2.<init>(r0)
            throw r2
        L_0x001f:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0023 }
        L_0x0023:
            throw r2     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "I/O error, can't check class version"
            r0.<init>(r1, r2)
            throw r0
        L_0x002d:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = "Bytecode not available, can't check class version"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Constants.b(java.io.InputStream):void");
    }

    public static boolean c(String str) {
        if (!str.startsWith("net/bytebuddy/jar/asm/")) {
            return false;
        }
        if (!str.contains("Test$")) {
            if (!Pattern.matches("net/bytebuddy/jar/asm/util/Trace" + "(Annotation|Class|Field|Method|Module|RecordComponent|Signature)" + "Visitor(\\$.*)?", str)) {
                if (Pattern.matches("net/bytebuddy/jar/asm/util/Check" + "(Annotation|Class|Field|Method|Module|RecordComponent|Signature)" + "Adapter(\\$.*)?", str)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}
