package org.apache.commons.compress.archivers.examples;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.utils.IOUtils;

public class Archiver {
    public static final EnumSet<FileVisitOption> EMPTY_FileVisitOption = EnumSet.noneOf(FileVisitOption.class);

    public static class ArchiverFileVisitor extends SimpleFileVisitor<Path> {
        private final Path directory;
        private final LinkOption[] linkOptions;
        private final ArchiveOutputStream target;

        public FileVisitResult a(Path path, BasicFileAttributes basicFileAttributes, boolean z11) throws IOException {
            Objects.requireNonNull(path);
            Objects.requireNonNull(basicFileAttributes);
            String replace = this.directory.relativize(path).toString().replace('\\', '/');
            if (!replace.isEmpty()) {
                ArchiveOutputStream archiveOutputStream = this.target;
                if (!z11 && !replace.endsWith("/")) {
                    replace = replace + "/";
                }
                this.target.putArchiveEntry(archiveOutputStream.createArchiveEntry(path, replace, this.linkOptions));
                if (z11) {
                    long unused = Files.copy(path, this.target);
                }
                this.target.closeArchiveEntry();
            }
            return FileVisitResult.CONTINUE;
        }

        private ArchiverFileVisitor(ArchiveOutputStream archiveOutputStream, Path path, LinkOption... linkOptionArr) {
            this.target = archiveOutputStream;
            this.directory = path;
            this.linkOptions = linkOptionArr == null ? IOUtils.EMPTY_LINK_OPTIONS : (LinkOption[]) linkOptionArr.clone();
        }

        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            return a(path, basicFileAttributes, false);
        }

        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            return a(path, basicFileAttributes, true);
        }
    }

    private boolean prefersSeekableByteChannel(String str) {
        if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public void create(ArchiveOutputStream archiveOutputStream, File file) throws IOException, ArchiveException {
        create(archiveOutputStream, file.toPath(), EMPTY_FileVisitOption, new LinkOption[0]);
    }

    public void create(ArchiveOutputStream archiveOutputStream, Path path, EnumSet<FileVisitOption> enumSet, LinkOption... linkOptionArr) throws IOException {
        Path unused = Files.walkFileTree(path, enumSet, Integer.MAX_VALUE, new ArchiverFileVisitor(archiveOutputStream, path, linkOptionArr));
        archiveOutputStream.finish();
    }

    public void create(ArchiveOutputStream archiveOutputStream, Path path) throws IOException {
        create(archiveOutputStream, path, EMPTY_FileVisitOption, new LinkOption[0]);
    }

    public void create(SevenZOutputFile sevenZOutputFile, File file) throws IOException {
        create(sevenZOutputFile, file.toPath());
    }

    public void create(SevenZOutputFile sevenZOutputFile, Path path) throws IOException {
        final Path path2 = path;
        final SevenZOutputFile sevenZOutputFile2 = sevenZOutputFile;
        Path unused = Files.walkFileTree(path, new ArchiverFileVisitor((ArchiveOutputStream) null, path, new LinkOption[0]) {
            public FileVisitResult a(Path path, BasicFileAttributes basicFileAttributes, boolean z11) throws IOException {
                Objects.requireNonNull(path);
                Objects.requireNonNull(basicFileAttributes);
                String replace = path2.relativize(path).toString().replace('\\', '/');
                if (!replace.isEmpty()) {
                    SevenZOutputFile sevenZOutputFile = sevenZOutputFile2;
                    if (!z11 && !replace.endsWith("/")) {
                        replace = replace + "/";
                    }
                    sevenZOutputFile2.putArchiveEntry(sevenZOutputFile.createArchiveEntry(path, replace, new LinkOption[0]));
                    if (z11) {
                        sevenZOutputFile2.write(path, new OpenOption[0]);
                    }
                    sevenZOutputFile2.closeArchiveEntry();
                }
                return FileVisitResult.CONTINUE;
            }
        });
        sevenZOutputFile.finish();
    }

    public void create(String str, File file, File file2) throws IOException, ArchiveException {
        create(str, file.toPath(), file2.toPath());
    }

    @Deprecated
    public void create(String str, OutputStream outputStream, File file) throws IOException, ArchiveException {
        create(str, outputStream, file, CloseableConsumer.NULL_CONSUMER);
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
    public void create(java.lang.String r2, java.io.OutputStream r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r5 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DEFAULT     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveOutputStream r2 = r5.createArchiveOutputStream(r2, r3)     // Catch:{ all -> 0x0018 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0018 }
            org.apache.commons.compress.archivers.ArchiveOutputStream r2 = (org.apache.commons.compress.archivers.ArchiveOutputStream) r2     // Catch:{ all -> 0x0018 }
            r1.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r2, (java.io.File) r4)     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.io.OutputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r5 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        k9.c.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r4.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r4 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005f, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r4, java.nio.file.Path r5, java.nio.file.Path r6) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            boolean r0 = r3.prefersSeekableByteChannel(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0039
            r0 = 3
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.WRITE
            r0[r1] = r2
            r1 = 1
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.CREATE
            r0[r1] = r2
            r1 = 2
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.TRUNCATE_EXISTING
            r0[r1] = r2
            java.nio.channels.FileChannel r5 = java.nio.channels.FileChannel.open(r5, r0)
            r3.create((java.lang.String) r4, (java.nio.channels.SeekableByteChannel) r5, (java.nio.file.Path) r6)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x002a
            r5.close()
        L_0x002a:
            return
        L_0x002b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x002d }
        L_0x002d:
            r6 = move-exception
            if (r5 == 0) goto L_0x0038
            r5.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x0038:
            throw r6
        L_0x0039:
            org.apache.commons.compress.archivers.ArchiveStreamFactory r0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DEFAULT
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
            java.io.OutputStream r5 = java.nio.file.Files.newOutputStream(r5, r2)
            org.apache.commons.compress.archivers.ArchiveOutputStream r4 = r0.createArchiveOutputStream(r4, r5)
            java.util.EnumSet<java.nio.file.FileVisitOption> r5 = EMPTY_FileVisitOption     // Catch:{ all -> 0x0052 }
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r1]     // Catch:{ all -> 0x0052 }
            r3.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r4, (java.nio.file.Path) r6, (java.util.EnumSet<java.nio.file.FileVisitOption>) r5, (java.nio.file.LinkOption[]) r0)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0051
            r4.close()
        L_0x0051:
            return
        L_0x0052:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r6 = move-exception
            if (r4 == 0) goto L_0x005f
            r4.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r4 = move-exception
            r5.addSuppressed(r4)
        L_0x005f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.nio.file.Path, java.nio.file.Path):void");
    }

    @Deprecated
    public void create(String str, SeekableByteChannel seekableByteChannel, File file) throws IOException, ArchiveException {
        create(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r2, java.nio.channels.SeekableByteChannel r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            boolean r5 = r1.prefersSeekableByteChannel(r2)     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0019
            java.io.OutputStream r3 = java.nio.channels.Channels.newOutputStream(r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r3 = r0.a(r3)     // Catch:{ all -> 0x0061 }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0061 }
            r1.create((java.lang.String) r2, (java.io.OutputStream) r3, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x0019:
            java.lang.String r5 = "zip"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0030
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream     // Catch:{ all -> 0x0061 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0061 }
            org.apache.commons.compress.archivers.ArchiveOutputStream r2 = (org.apache.commons.compress.archivers.ArchiveOutputStream) r2     // Catch:{ all -> 0x0061 }
            r1.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r2, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x0030:
            java.lang.String r5 = "7z"
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x004a
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r2 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile     // Catch:{ all -> 0x0061 }
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)     // Catch:{ all -> 0x0061 }
            java.io.Closeable r2 = r0.a(r2)     // Catch:{ all -> 0x0061 }
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r2 = (org.apache.commons.compress.archivers.sevenz.SevenZOutputFile) r2     // Catch:{ all -> 0x0061 }
            r1.create((org.apache.commons.compress.archivers.sevenz.SevenZOutputFile) r2, (java.io.File) r4)     // Catch:{ all -> 0x0061 }
        L_0x0046:
            r0.close()
            return
        L_0x004a:
            org.apache.commons.compress.archivers.ArchiveException r3 = new org.apache.commons.compress.archivers.ArchiveException     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r4.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "Don't know how to handle format "
            r4.append(r5)     // Catch:{ all -> 0x0061 }
            r4.append(r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0061 }
            r3.<init>(r2)     // Catch:{ all -> 0x0061 }
            throw r3     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r4 = move-exception
            r2.addSuppressed(r4)
        L_0x006c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.nio.channels.SeekableByteChannel, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r2, java.nio.channels.SeekableByteChannel r3, java.nio.file.Path r4) throws java.io.IOException {
        /*
            r1 = this;
            java.lang.String r0 = "7z"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0020
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r2 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)
            r1.create((org.apache.commons.compress.archivers.sevenz.SevenZOutputFile) r2, (java.nio.file.Path) r4)     // Catch:{ all -> 0x0014 }
            r2.close()
            goto L_0x0038
        L_0x0014:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x001f:
            throw r4
        L_0x0020:
            java.lang.String r0 = "zip"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0045
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
            r2.<init>((java.nio.channels.SeekableByteChannel) r3)
            java.util.EnumSet<java.nio.file.FileVisitOption> r3 = EMPTY_FileVisitOption     // Catch:{ all -> 0x0039 }
            r0 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]     // Catch:{ all -> 0x0039 }
            r1.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r2, (java.nio.file.Path) r4, (java.util.EnumSet<java.nio.file.FileVisitOption>) r3, (java.nio.file.LinkOption[]) r0)     // Catch:{ all -> 0x0039 }
            r2.close()
        L_0x0038:
            return
        L_0x0039:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x003b }
        L_0x003b:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x0044:
            throw r4
        L_0x0045:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.nio.channels.SeekableByteChannel, java.nio.file.Path):void");
    }
}
