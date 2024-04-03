package com.huawei.wisesecurity.ucs.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {
    public static final int BUFF_SIZE = 4096;

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        int read = inputStream.read(bArr);
        long j11 = 0;
        while (-1 != read) {
            outputStream.write(bArr, 0, read);
            j11 += (long) read;
            read = inputStream.read(bArr);
        }
        return j11;
    }

    public static long copy(Reader reader, Writer writer) throws IOException {
        return copy(reader, writer, new char[4096]);
    }

    public static long copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        int read = reader.read(cArr);
        long j11 = 0;
        while (-1 != read) {
            writer.write(cArr, 0, read);
            j11 += (long) read;
            read = reader.read(cArr);
        }
        return j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.InputStream r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            copy((java.io.InputStream) r2, (java.io.OutputStream) r0)     // Catch:{ all -> 0x0010 }
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0010 }
            r0.close()
            return r2
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x001b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs.common.utils.IOUtils.toByteArray(java.io.InputStream):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0026, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002c, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002f, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(java.io.InputStream r2, java.lang.String r3) throws java.io.IOException {
        /*
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ all -> 0x0024 }
            r2.<init>()     // Catch:{ all -> 0x0024 }
            copy((java.io.Reader) r0, (java.io.Writer) r2)     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x0018 }
            r2.close()     // Catch:{ all -> 0x0024 }
            r0.close()
            return r3
        L_0x0018:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r3.addSuppressed(r2)     // Catch:{ all -> 0x0024 }
        L_0x0023:
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x002f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs.common.utils.IOUtils.toString(java.io.InputStream, java.lang.String):java.lang.String");
    }
}
