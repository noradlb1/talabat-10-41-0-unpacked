package org.apache.commons.compress.archivers.examples;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class Expander {

    public interface ArchiveEntrySupplier {
        ArchiveEntry getNextReadableEntry() throws IOException;
    }

    public interface EntryWriter {
        void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ArchiveEntry lambda$expand$0(ArchiveInputStream archiveInputStream) throws IOException {
        ArchiveEntry nextEntry = archiveInputStream.getNextEntry();
        while (nextEntry != null && !archiveInputStream.canReadEntryData(nextEntry)) {
            nextEntry = archiveInputStream.getNextEntry();
        }
        return nextEntry;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ArchiveEntry lambda$expand$2(Iterator it) throws IOException {
        if (it.hasNext()) {
            return (ArchiveEntry) it.next();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$expand$3(org.apache.commons.compress.archivers.tar.TarFile r0, org.apache.commons.compress.archivers.ArchiveEntry r1, java.io.OutputStream r2) throws java.io.IOException {
        /*
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = (org.apache.commons.compress.archivers.tar.TarArchiveEntry) r1
            java.io.InputStream r0 = r0.getInputStream(r1)
            org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x000e
            r0.close()
        L_0x000e:
            return
        L_0x000f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            if (r0 == 0) goto L_0x001c
            r0.close()     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.lambda$expand$3(org.apache.commons.compress.archivers.tar.TarFile, org.apache.commons.compress.archivers.ArchiveEntry, java.io.OutputStream):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024 A[EDGE_INSN: B:11:0x0024->B:10:0x0024 ?: BREAK  
    EDGE_INSN: B:13:0x0024->B:10:0x0024 ?: BREAK  , RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ org.apache.commons.compress.archivers.ArchiveEntry lambda$expand$4(java.util.Enumeration r3, org.apache.commons.compress.archivers.zip.ZipFile r4) throws java.io.IOException {
        /*
            boolean r0 = r3.hasMoreElements()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.Object r0 = r3.nextElement()
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x0024
            boolean r2 = r4.canReadEntryData(r0)
            if (r2 != 0) goto L_0x0024
            boolean r0 = r3.hasMoreElements()
            if (r0 == 0) goto L_0x000e
            java.lang.Object r0 = r3.nextElement()
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r0
            goto L_0x000f
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.lambda$expand$4(java.util.Enumeration, org.apache.commons.compress.archivers.zip.ZipFile):org.apache.commons.compress.archivers.ArchiveEntry");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$expand$5(org.apache.commons.compress.archivers.zip.ZipFile r0, org.apache.commons.compress.archivers.ArchiveEntry r1, java.io.OutputStream r2) throws java.io.IOException {
        /*
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r1 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r1
            java.io.InputStream r0 = r0.getInputStream(r1)
            org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x000e
            r0.close()
        L_0x000e:
            return
        L_0x000f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            if (r0 == 0) goto L_0x001c
            r0.close()     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.lambda$expand$5(org.apache.commons.compress.archivers.zip.ZipFile, org.apache.commons.compress.archivers.ArchiveEntry, java.io.OutputStream):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$expand$6(SevenZFile sevenZFile, ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = sevenZFile.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private boolean prefersSeekableByteChannel(String str) {
        if (ArchiveStreamFactory.TAR.equalsIgnoreCase(str) || ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r5 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.io.File r4, java.io.File r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r1 = r4.toPath()
            r2 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r2]
            java.io.InputStream r1 = java.nio.file.Files.newInputStream(r1, r2)
            r0.<init>(r1)
            java.lang.String r1 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(r0)     // Catch:{ all -> 0x001b }
            r0.close()
            r3.expand((java.lang.String) r1, (java.io.File) r4, (java.io.File) r5)
            return
        L_0x001b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001d }
        L_0x001d:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r0 = move-exception
            r4.addSuppressed(r0)
        L_0x0026:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.io.File, java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r5 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        r4.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r4, java.io.File r5, java.io.File r6) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            boolean r0 = r3.prefersSeekableByteChannel(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0031
            java.nio.file.Path r5 = r5.toPath()
            r0 = 1
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.READ
            r0[r1] = r2
            java.nio.channels.FileChannel r5 = java.nio.channels.FileChannel.open(r5, r0)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r0 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x0023 }
            r3.expand((java.lang.String) r4, (java.nio.channels.SeekableByteChannel) r5, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r0)     // Catch:{ all -> 0x0023 }
            if (r5 == 0) goto L_0x0022
            r5.close()
        L_0x0022:
            return
        L_0x0023:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r6 = move-exception
            if (r5 == 0) goto L_0x0030
            r5.close()     // Catch:{ all -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r5 = r5.toPath()
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r5 = java.nio.file.Files.newInputStream(r5, r1)
            r0.<init>(r5)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r5 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x0049 }
            r3.expand((java.lang.String) r4, (java.io.InputStream) r0, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r5)     // Catch:{ all -> 0x0049 }
            r0.close()
            return
        L_0x0049:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004b }
        L_0x004b:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r6 = move-exception
            r4.addSuppressed(r6)
        L_0x0054:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.io.File, java.io.File):void");
    }

    @Deprecated
    public void expand(InputStream inputStream, File file) throws IOException, ArchiveException {
        expand(inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.io.InputStream r2, java.io.File r3, org.apache.commons.compress.archivers.examples.CloseableConsumer r4) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r4)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r4 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DEFAULT     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = r4.createArchiveInputStream(r2)     // Catch:{ all -> 0x0018 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = (org.apache.commons.compress.archivers.ArchiveInputStream) r2     // Catch:{ all -> 0x0018 }
            r1.expand((org.apache.commons.compress.archivers.ArchiveInputStream) r2, (java.io.File) r3)     // Catch:{ all -> 0x0018 }
            r0.close()
            return
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r4 = move-exception
            r2.addSuppressed(r4)
        L_0x0023:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.io.InputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    @Deprecated
    public void expand(String str, InputStream inputStream, File file) throws IOException, ArchiveException {
        expand(str, inputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r2, java.io.InputStream r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r5 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DEFAULT     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = r5.createArchiveInputStream(r2, r3)     // Catch:{ all -> 0x0018 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveInputStream r2 = (org.apache.commons.compress.archivers.ArchiveInputStream) r2     // Catch:{ all -> 0x0018 }
            r1.expand((org.apache.commons.compress.archivers.ArchiveInputStream) r2, (java.io.File) r4)     // Catch:{ all -> 0x0018 }
            r0.close()
            return
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r4 = move-exception
            r2.addSuppressed(r4)
        L_0x0023:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.io.InputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    @Deprecated
    public void expand(String str, SeekableByteChannel seekableByteChannel, File file) throws IOException, ArchiveException {
        expand(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void expand(java.lang.String r2, java.nio.channels.SeekableByteChannel r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            boolean r5 = r1.prefersSeekableByteChannel(r2)     // Catch:{ all -> 0x0078 }
            if (r5 != 0) goto L_0x0019
            java.io.InputStream r3 = java.nio.channels.Channels.newInputStream(r3)     // Catch:{ all -> 0x0078 }
            java.io.Closeable r3 = r0.a(r3)     // Catch:{ all -> 0x0078 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ all -> 0x0078 }
            r1.expand((java.lang.String) r2, (java.io.InputStream) r3, (java.io.File) r4)     // Catch:{ all -> 0x0078 }
            goto L_0x005d
        L_0x0019:
            java.lang.String r5 = "tar"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0030
            org.apache.commons.compress.archivers.tar.TarFile r2 = new org.apache.commons.compress.archivers.tar.TarFile     // Catch:{ all -> 0x0078 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0078 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0078 }
            org.apache.commons.compress.archivers.tar.TarFile r2 = (org.apache.commons.compress.archivers.tar.TarFile) r2     // Catch:{ all -> 0x0078 }
            r1.expand((org.apache.commons.compress.archivers.tar.TarFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0078 }
            goto L_0x005d
        L_0x0030:
            java.lang.String r5 = "zip"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0047
            org.apache.commons.compress.archivers.zip.ZipFile r2 = new org.apache.commons.compress.archivers.zip.ZipFile     // Catch:{ all -> 0x0078 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0078 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0078 }
            org.apache.commons.compress.archivers.zip.ZipFile r2 = (org.apache.commons.compress.archivers.zip.ZipFile) r2     // Catch:{ all -> 0x0078 }
            r1.expand((org.apache.commons.compress.archivers.zip.ZipFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0078 }
            goto L_0x005d
        L_0x0047:
            java.lang.String r5 = "7z"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0061
            org.apache.commons.compress.archivers.sevenz.SevenZFile r2 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch:{ all -> 0x0078 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0078 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0078 }
            org.apache.commons.compress.archivers.sevenz.SevenZFile r2 = (org.apache.commons.compress.archivers.sevenz.SevenZFile) r2     // Catch:{ all -> 0x0078 }
            r1.expand((org.apache.commons.compress.archivers.sevenz.SevenZFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0078 }
        L_0x005d:
            r0.close()
            return
        L_0x0061:
            org.apache.commons.compress.archivers.ArchiveException r3 = new org.apache.commons.compress.archivers.ArchiveException     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r4.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r5 = "Don't know how to handle format "
            r4.append(r5)     // Catch:{ all -> 0x0078 }
            r4.append(r2)     // Catch:{ all -> 0x0078 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0078 }
            r3.<init>(r2)     // Catch:{ all -> 0x0078 }
            throw r3     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r4 = move-exception
            r2.addSuppressed(r4)
        L_0x0083:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(java.lang.String, java.nio.channels.SeekableByteChannel, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    public void expand(ArchiveInputStream archiveInputStream, File file) throws IOException, ArchiveException {
        expand((ArchiveEntrySupplier) new a(archiveInputStream), (EntryWriter) new b(archiveInputStream), file);
    }

    public void expand(TarFile tarFile, File file) throws IOException, ArchiveException {
        expand((ArchiveEntrySupplier) new e(tarFile.getEntries().iterator()), (EntryWriter) new f(tarFile), file);
    }

    public void expand(ZipFile zipFile, File file) throws IOException, ArchiveException {
        expand((ArchiveEntrySupplier) new c(zipFile.getEntries(), zipFile), (EntryWriter) new d(zipFile), file);
    }

    public void expand(SevenZFile sevenZFile, File file) throws IOException, ArchiveException {
        sevenZFile.getClass();
        expand((ArchiveEntrySupplier) new g(sevenZFile), (EntryWriter) new h(sevenZFile), file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        if (r2 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a5, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        r7.addSuppressed(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a9, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void expand(org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier r7, org.apache.commons.compress.archivers.examples.Expander.EntryWriter r8, java.io.File r9) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = r9.getCanonicalPath()
            java.lang.String r1 = java.io.File.separator
            boolean r2 = r0.endsWith(r1)
            if (r2 != 0) goto L_0x001b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
        L_0x001b:
            org.apache.commons.compress.archivers.ArchiveEntry r1 = r7.getNextReadableEntry()
        L_0x001f:
            if (r1 == 0) goto L_0x00cd
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r1.getName()
            r2.<init>(r9, r3)
            java.lang.String r3 = r2.getCanonicalPath()
            boolean r3 = r3.startsWith(r0)
            if (r3 == 0) goto L_0x00aa
            boolean r3 = r1.isDirectory()
            java.lang.String r4 = "Failed to create directory "
            if (r3 == 0) goto L_0x005e
            boolean r1 = r2.isDirectory()
            if (r1 != 0) goto L_0x0097
            boolean r1 = r2.mkdirs()
            if (r1 == 0) goto L_0x0049
            goto L_0x0097
        L_0x0049:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x005e:
            java.io.File r3 = r2.getParentFile()
            boolean r5 = r3.isDirectory()
            if (r5 != 0) goto L_0x0084
            boolean r5 = r3.mkdirs()
            if (r5 == 0) goto L_0x006f
            goto L_0x0084
        L_0x006f:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0084:
            java.nio.file.Path r2 = r2.toPath()
            r3 = 0
            java.nio.file.OpenOption[] r3 = new java.nio.file.OpenOption[r3]
            java.io.OutputStream r2 = java.nio.file.Files.newOutputStream(r2, r3)
            r8.writeEntryDataTo(r1, r2)     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x0097
            r2.close()
        L_0x0097:
            org.apache.commons.compress.archivers.ArchiveEntry r1 = r7.getNextReadableEntry()
            goto L_0x001f
        L_0x009c:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x009e }
        L_0x009e:
            r8 = move-exception
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ all -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r9 = move-exception
            r7.addSuppressed(r9)
        L_0x00a9:
            throw r8
        L_0x00aa:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Expanding "
            r8.append(r0)
            java.lang.String r0 = r1.getName()
            r8.append(r0)
            java.lang.String r0 = " would create file outside of "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Expander.expand(org.apache.commons.compress.archivers.examples.Expander$ArchiveEntrySupplier, org.apache.commons.compress.archivers.examples.Expander$EntryWriter, java.io.File):void");
    }
}
