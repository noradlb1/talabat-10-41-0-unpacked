package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

public final class Lister {
    private static final ArchiveStreamFactory FACTORY = ArchiveStreamFactory.DEFAULT;

    private static ArchiveInputStream createArchiveInputStream(String[] strArr, InputStream inputStream) throws ArchiveException {
        if (strArr.length > 1) {
            return FACTORY.createArchiveInputStream(strArr[1], inputStream);
        }
        return FACTORY.createArchiveInputStream(inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String detectFormat(java.io.File r2) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r2 = r2.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = java.nio.file.Files.newInputStream(r2, r1)
            r0.<init>(r2)
            java.lang.String r2 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(r0)     // Catch:{ all -> 0x0018 }
            r0.close()
            return r2
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.detectFormat(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void list7z(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            org.apache.commons.compress.archivers.sevenz.SevenZFile r0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile
            r0.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x004f }
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
            r3.println(r1)     // Catch:{ all -> 0x004f }
        L_0x001f:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r3 = r0.getNextEntry()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x004b
            java.lang.String r1 = r3.getName()     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x0041
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r3.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r0.getDefaultName()     // Catch:{ all -> 0x004f }
            r3.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = " (entry name was null)"
            r3.append(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004f }
            goto L_0x0045
        L_0x0041:
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x004f }
        L_0x0045:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x004f }
            r1.println(r3)     // Catch:{ all -> 0x004f }
            goto L_0x001f
        L_0x004b:
            r0.close()
            return
        L_0x004f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x005a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.list7z(java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r3 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listStream(java.io.File r3, java.lang.String[] r4) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r3 = r3.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r3 = java.nio.file.Files.newInputStream(r3, r1)
            r0.<init>(r3)
            org.apache.commons.compress.archivers.ArchiveInputStream r3 = createArchiveInputStream(r4, r0)     // Catch:{ all -> 0x0053 }
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r1.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0045 }
            r1.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0045 }
            r4.println(r1)     // Catch:{ all -> 0x0045 }
        L_0x002e:
            org.apache.commons.compress.archivers.ArchiveEntry r4 = r3.getNextEntry()     // Catch:{ all -> 0x0045 }
            if (r4 == 0) goto L_0x003e
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0045 }
            r1.println(r4)     // Catch:{ all -> 0x0045 }
            goto L_0x002e
        L_0x003e:
            r3.close()     // Catch:{ all -> 0x0053 }
            r0.close()
            return
        L_0x0045:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r1 = move-exception
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x0053 }
        L_0x0052:
            throw r1     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x005e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listStream(java.io.File, java.lang.String[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listZipUsingTarFile(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            org.apache.commons.compress.archivers.tar.TarFile r0 = new org.apache.commons.compress.archivers.tar.TarFile
            r0.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r1.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x0041 }
            r1.append(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0041 }
            r3.println(r1)     // Catch:{ all -> 0x0041 }
            java.util.List r3 = r0.getEntries()     // Catch:{ all -> 0x0041 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0041 }
        L_0x0027:
            boolean r1 = r3.hasNext()     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r3.next()     // Catch:{ all -> 0x0041 }
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = (org.apache.commons.compress.archivers.tar.TarArchiveEntry) r1     // Catch:{ all -> 0x0041 }
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0041 }
            r2.println(r1)     // Catch:{ all -> 0x0041 }
            goto L_0x0027
        L_0x003d:
            r0.close()
            return
        L_0x0041:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x004c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listZipUsingTarFile(java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listZipUsingZipFile(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            org.apache.commons.compress.archivers.zip.ZipFile r0 = new org.apache.commons.compress.archivers.zip.ZipFile
            r0.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x003d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "Created "
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x003d }
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003d }
            r3.println(r1)     // Catch:{ all -> 0x003d }
            java.util.Enumeration r3 = r0.getEntries()     // Catch:{ all -> 0x003d }
        L_0x0023:
            boolean r1 = r3.hasMoreElements()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0039
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r3.nextElement()     // Catch:{ all -> 0x003d }
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r2     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x003d }
            r1.println(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0023
        L_0x0039:
            r0.close()
            return
        L_0x003d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x003f }
        L_0x003f:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x0048:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listZipUsingZipFile(java.io.File):void");
    }

    public static void main(String[] strArr) throws Exception {
        String str;
        if (strArr.length == 0) {
            usage();
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("Analysing " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            PrintStream printStream2 = System.err;
            printStream2.println(file + " doesn't exist or is a directory");
        }
        if (strArr.length > 1) {
            str = strArr[1];
        } else {
            str = detectFormat(file);
        }
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
            list7z(file);
        } else if ("zipfile".equals(str)) {
            listZipUsingZipFile(file);
        } else if ("tarfile".equals(str)) {
            listZipUsingTarFile(file);
        } else {
            listStream(file, strArr);
        }
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]\n");
        System.out.println("the magic archive-type 'zipfile' prefers ZipFile over ZipArchiveInputStream");
        System.out.println("the magic archive-type 'tarfile' prefers TarFile over TarArchiveInputStream");
    }
}
