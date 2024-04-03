package org.apache.commons.compress.archivers.sevenz;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.CRC32;
import m20.b;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class SevenZFile implements Closeable {
    private static final String DEFAULT_FILE_NAME = "unknown archive";
    private static final CharsetEncoder PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();
    static final int SIGNATURE_HEADER_SIZE = 32;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, Ascii.FS};
    private final Archive archive;
    private SeekableByteChannel channel;
    /* access modifiers changed from: private */
    public long compressedBytesReadFromCurrentEntry;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private final String fileName;
    private final SevenZFileOptions options;
    private byte[] password;
    /* access modifiers changed from: private */
    public long uncompressedBytesReadFromCurrentEntry;

    public static class ArchiveStatistics {
        /* access modifiers changed from: private */
        public BitSet folderHasCrc;
        /* access modifiers changed from: private */
        public long numberOfCoders;
        /* access modifiers changed from: private */
        public int numberOfEntries;
        /* access modifiers changed from: private */
        public int numberOfEntriesWithStream;
        /* access modifiers changed from: private */
        public int numberOfFolders;
        /* access modifiers changed from: private */
        public long numberOfInStreams;
        /* access modifiers changed from: private */
        public long numberOfOutStreams;
        /* access modifiers changed from: private */
        public int numberOfPackedStreams;
        /* access modifiers changed from: private */
        public long numberOfUnpackSubStreams;

        private ArchiveStatistics() {
        }

        private long bindPairSize() {
            return 16;
        }

        private long coderSize() {
            return 22;
        }

        private long entrySize() {
            return 100;
        }

        private long folderSize() {
            return 30;
        }

        private long streamMapSize() {
            return (long) ((this.numberOfFolders * 8) + (this.numberOfPackedStreams * 8) + (this.numberOfEntries * 4));
        }

        public void r(int i11) throws IOException {
            int i12 = this.numberOfEntriesWithStream;
            if (i12 > 0 && this.numberOfFolders == 0) {
                throw new IOException("archive with entries but no folders");
            } else if (((long) i12) <= this.numberOfUnpackSubStreams) {
                long s11 = s() / 1024;
                if (((long) i11) < s11) {
                    throw new MemoryLimitException(s11, i11);
                }
            } else {
                throw new IOException("archive doesn't contain enough substreams for entries");
            }
        }

        public long s() {
            int i11 = this.numberOfPackedStreams;
            long folderSize = (((long) i11) * 16) + ((long) (i11 / 8)) + (((long) this.numberOfFolders) * folderSize()) + (this.numberOfCoders * coderSize()) + ((this.numberOfOutStreams - ((long) this.numberOfFolders)) * bindPairSize());
            long j11 = this.numberOfInStreams;
            long j12 = this.numberOfOutStreams;
            return (folderSize + (((j11 - j12) + ((long) this.numberOfFolders)) * 8) + (j12 * 8) + (((long) this.numberOfEntries) * entrySize()) + streamMapSize()) * 2;
        }

        public String toString() {
            return "Archive with " + this.numberOfEntries + " entries in " + this.numberOfFolders + " folders. Estimated size " + (s() / 1024) + " kB.";
        }
    }

    public SevenZFile(File file, char[] cArr) throws IOException {
        this(file, cArr, SevenZFileOptions.DEFAULT);
    }

    private static int assertFitsIntoNonNegativeInt(String str, long j11) throws IOException {
        if (j11 <= 2147483647L && j11 >= 0) {
            return (int) j11;
        }
        throw new IOException("Cannot handle " + str + " " + j11);
    }

    private InputStream buildDecoderStack(Folder folder, long j11, int i11, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        SeekableByteChannel unused = this.channel.position(j11);
        AnonymousClass1 r102 = new FilterInputStream(new BufferedInputStream(new BoundedSeekableByteChannelInputStream(this.channel, this.archive.f27599b[i11]))) {
            private void count(int i11) {
                SevenZFile sevenZFile = SevenZFile.this;
                long unused = sevenZFile.compressedBytesReadFromCurrentEntry = sevenZFile.compressedBytesReadFromCurrentEntry + ((long) i11);
            }

            public int read() throws IOException {
                int read = this.in.read();
                if (read >= 0) {
                    count(1);
                }
                return read;
            }

            public int read(byte[] bArr) throws IOException {
                return read(bArr, 0, bArr.length);
            }

            public int read(byte[] bArr, int i11, int i12) throws IOException {
                if (i12 == 0) {
                    return 0;
                }
                int read = this.in.read(bArr, i11, i12);
                if (read >= 0) {
                    count(read);
                }
                return read;
            }
        };
        LinkedList linkedList = new LinkedList();
        InputStream inputStream = r102;
        for (Coder next : folder.c()) {
            if (next.f27609b == 1 && next.f27610c == 1) {
                SevenZMethod byId = SevenZMethod.byId(next.f27608a);
                inputStream = Coders.a(this.fileName, inputStream, folder.e(next), next, this.password, this.options.getMaxMemoryLimitInKb());
                linkedList.addFirst(new SevenZMethodConfiguration(byId, Coders.c(byId).e(next, inputStream)));
            } else {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
        }
        sevenZArchiveEntry.setContentMethods(linkedList);
        if (folder.f27623g) {
            return new CRC32VerifyingInputStream(inputStream, folder.d(), folder.f27624h);
        }
        return inputStream;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: org.apache.commons.compress.utils.CRC32VerifyingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildDecodingStream(int r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r11.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r1 = r0.f27605h
            if (r1 == 0) goto L_0x0080
            int[] r1 = r1.f27638d
            r1 = r1[r12]
            if (r1 >= 0) goto L_0x0012
            java.util.ArrayList<java.io.InputStream> r12 = r11.deferredBlockStreams
            r12.clear()
            return
        L_0x0012:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.f27604g
            r2 = r0[r12]
            int r3 = r11.currentFolderIndex
            r4 = 0
            if (r3 != r1) goto L_0x0045
            if (r12 <= 0) goto L_0x0028
            int r3 = r12 + -1
            r0 = r0[r3]
            java.lang.Iterable r0 = r0.getContentMethods()
            r2.setContentMethods(r0)
        L_0x0028:
            if (r13 == 0) goto L_0x0043
            java.lang.Iterable r0 = r2.getContentMethods()
            if (r0 != 0) goto L_0x0043
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r11.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r3 = r0.f27605h
            int[] r3 = r3.f27637c
            r3 = r3[r1]
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.f27604g
            r0 = r0[r3]
            java.lang.Iterable r0 = r0.getContentMethods()
            r2.setContentMethods(r0)
        L_0x0043:
            r0 = 1
            goto L_0x004b
        L_0x0045:
            r11.currentFolderIndex = r1
            r11.reopenFolderInputStream(r1, r2)
            r0 = r4
        L_0x004b:
            if (r13 == 0) goto L_0x0051
            boolean r4 = r11.skipEntriesWhenNeeded(r12, r0, r1)
        L_0x0051:
            if (r13 == 0) goto L_0x005a
            int r13 = r11.currentEntryIndex
            if (r13 != r12) goto L_0x005a
            if (r4 != 0) goto L_0x005a
            return
        L_0x005a:
            org.apache.commons.compress.utils.BoundedInputStream r6 = new org.apache.commons.compress.utils.BoundedInputStream
            java.io.InputStream r12 = r11.currentFolderInputStream
            long r0 = r2.getSize()
            r6.<init>(r12, r0)
            boolean r12 = r2.getHasCrc()
            if (r12 == 0) goto L_0x007a
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r12 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            long r7 = r2.getSize()
            long r9 = r2.getCrcValue()
            r5 = r12
            r5.<init>((java.io.InputStream) r6, (long) r7, (long) r9)
            r6 = r12
        L_0x007a:
            java.util.ArrayList<java.io.InputStream> r12 = r11.deferredBlockStreams
            r12.add(r6)
            return
        L_0x0080:
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r13 = "Archive doesn't contain stream information to read entries"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.buildDecodingStream(int, boolean):void");
    }

    private void calculateStreamMap(Archive archive2) throws IOException {
        int i11;
        Folder[] folderArr;
        StreamMap streamMap = new StreamMap();
        Folder[] folderArr2 = archive2.f27602e;
        if (folderArr2 != null) {
            i11 = folderArr2.length;
        } else {
            i11 = 0;
        }
        streamMap.f27635a = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            streamMap.f27635a[i13] = i12;
            i12 += archive2.f27602e[i13].f27621e.length;
        }
        int length = archive2.f27599b.length;
        streamMap.f27636b = new long[length];
        long j11 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            streamMap.f27636b[i14] = j11;
            j11 += archive2.f27599b[i14];
        }
        streamMap.f27637c = new int[i11];
        streamMap.f27638d = new int[archive2.f27604g.length];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            SevenZArchiveEntry[] sevenZArchiveEntryArr = archive2.f27604g;
            if (i15 < sevenZArchiveEntryArr.length) {
                if (sevenZArchiveEntryArr[i15].hasStream() || i16 != 0) {
                    if (i16 == 0) {
                        while (true) {
                            folderArr = archive2.f27602e;
                            if (i17 >= folderArr.length) {
                                break;
                            }
                            streamMap.f27637c[i17] = i15;
                            if (folderArr[i17].f27625i > 0) {
                                break;
                            }
                            i17++;
                        }
                        if (i17 >= folderArr.length) {
                            throw new IOException("Too few folders in archive");
                        }
                    }
                    streamMap.f27638d[i15] = i17;
                    if (archive2.f27604g[i15].hasStream() && (i16 = i16 + 1) >= archive2.f27602e[i17].f27625i) {
                        i17++;
                        i16 = 0;
                    }
                } else {
                    streamMap.f27638d[i15] = -1;
                }
                i15++;
            } else {
                archive2.f27605h = streamMap;
                return;
            }
        }
    }

    private void checkEntryIsInitialized(Map<Integer, SevenZArchiveEntry> map, int i11) {
        if (map.get(Integer.valueOf(i11)) == null) {
            map.put(Integer.valueOf(i11), new SevenZArchiveEntry());
        }
    }

    private static void get(ByteBuffer byteBuffer, byte[] bArr) throws IOException {
        if (byteBuffer.remaining() >= bArr.length) {
            byteBuffer.get(bArr);
            return;
        }
        throw new EOFException();
    }

    private static char getChar(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 2) {
            return byteBuffer.getChar();
        }
        throw new EOFException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream getCurrentStream() throws java.io.IOException {
        /*
            r6 = this;
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r6.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.f27604g
            int r1 = r6.currentEntryIndex
            r0 = r0[r1]
            long r0 = r0.getSize()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x001a
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            byte[] r1 = org.apache.commons.compress.utils.ByteUtils.EMPTY_BYTE_ARRAY
            r0.<init>(r1)
            return r0
        L_0x001a:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005b
        L_0x0022:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            int r0 = r0.size()
            r1 = 1
            r4 = 0
            if (r0 <= r1) goto L_0x0052
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            java.lang.Object r0 = r0.remove(r4)
            java.io.InputStream r0 = (java.io.InputStream) r0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            org.apache.commons.compress.utils.IOUtils.skip(r0, r4)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            r6.compressedBytesReadFromCurrentEntry = r2
            goto L_0x0022
        L_0x0044:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r2 = move-exception
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0051:
            throw r2
        L_0x0052:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            java.lang.Object r0 = r0.get(r4)
            java.io.InputStream r0 = (java.io.InputStream) r0
            return r0
        L_0x005b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No current 7z entry (call getNextEntry() first)."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.getCurrentStream():java.io.InputStream");
    }

    private static int getInt(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            return byteBuffer.getInt();
        }
        throw new EOFException();
    }

    private static long getLong(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 8) {
            return byteBuffer.getLong();
        }
        throw new EOFException();
    }

    private static int getUnsignedByte(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        throw new EOFException();
    }

    private boolean hasCurrentEntryBeenRead() {
        boolean z11;
        if (this.deferredBlockStreams.isEmpty()) {
            return false;
        }
        ArrayList<InputStream> arrayList = this.deferredBlockStreams;
        InputStream inputStream = arrayList.get(arrayList.size() - 1);
        if (!(inputStream instanceof CRC32VerifyingInputStream) || ((CRC32VerifyingInputStream) inputStream).getBytesRemaining() == this.archive.f27604g[this.currentEntryIndex].getSize()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!(inputStream instanceof BoundedInputStream)) {
            return z11;
        }
        if (((BoundedInputStream) inputStream).getBytesRemaining() != this.archive.f27604g[this.currentEntryIndex].getSize()) {
            return true;
        }
        return false;
    }

    private Archive initializeArchive(StartHeader startHeader, byte[] bArr, boolean z11) throws IOException {
        assertFitsIntoNonNegativeInt("nextHeaderSize", startHeader.f27633b);
        SeekableByteChannel unused = this.channel.position(startHeader.f27632a + 32);
        ByteBuffer order = ByteBuffer.allocate((int) startHeader.f27633b).order(ByteOrder.LITTLE_ENDIAN);
        readFully(order);
        if (z11) {
            CRC32 crc32 = new CRC32();
            crc32.update(order.array());
            if (startHeader.f27634c != crc32.getValue()) {
                throw new IOException("NextHeader CRC mismatch");
            }
        }
        Archive archive2 = new Archive();
        int unsignedByte = getUnsignedByte(order);
        if (unsignedByte == 23) {
            order = readEncodedHeader(order, archive2, bArr);
            archive2 = new Archive();
            unsignedByte = getUnsignedByte(order);
        }
        if (unsignedByte == 1) {
            readHeader(order, archive2);
            archive2.f27603f = null;
            return archive2;
        }
        throw new IOException("Broken or unsupported archive: no Header");
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < sevenZSignature.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = sevenZSignature;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    private BitSet readAllOrBits(ByteBuffer byteBuffer, int i11) throws IOException {
        if (getUnsignedByte(byteBuffer) == 0) {
            return readBits(byteBuffer, i11);
        }
        BitSet bitSet = new BitSet(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            bitSet.set(i12, true);
        }
        return bitSet;
    }

    private void readArchiveProperties(ByteBuffer byteBuffer) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            get(byteBuffer, new byte[((int) readUint64(byteBuffer))]);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
    }

    private BitSet readBits(ByteBuffer byteBuffer, int i11) throws IOException {
        boolean z11;
        BitSet bitSet = new BitSet(i11);
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 == 0) {
                i13 = getUnsignedByte(byteBuffer);
                i12 = 128;
            }
            if ((i13 & i12) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            bitSet.set(i14, z11);
            i12 >>>= 1;
        }
        return bitSet;
    }

    private ByteBuffer readEncodedHeader(ByteBuffer byteBuffer, Archive archive2, byte[] bArr) throws IOException {
        int position = byteBuffer.position();
        ArchiveStatistics archiveStatistics = new ArchiveStatistics();
        sanityCheckStreamsInfo(byteBuffer, archiveStatistics);
        archiveStatistics.r(this.options.getMaxMemoryLimitInKb());
        byteBuffer.position(position);
        readStreamsInfo(byteBuffer, archive2);
        Folder[] folderArr = archive2.f27602e;
        if (folderArr == null || folderArr.length == 0) {
            throw new IOException("no folders, can't read encoded header");
        }
        long[] jArr = archive2.f27599b;
        if (jArr == null || jArr.length == 0) {
            throw new IOException("no packed streams, can't read encoded header");
        }
        Folder folder = folderArr[0];
        SeekableByteChannel unused = this.channel.position(archive2.f27598a + 32 + 0);
        BoundedSeekableByteChannelInputStream boundedSeekableByteChannelInputStream = new BoundedSeekableByteChannelInputStream(this.channel, archive2.f27599b[0]);
        CRC32VerifyingInputStream cRC32VerifyingInputStream = boundedSeekableByteChannelInputStream;
        for (Coder next : folder.c()) {
            if (next.f27609b == 1 && next.f27610c == 1) {
                cRC32VerifyingInputStream = Coders.a(this.fileName, cRC32VerifyingInputStream, folder.e(next), next, bArr, this.options.getMaxMemoryLimitInKb());
            } else {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
        }
        if (folder.f27623g) {
            cRC32VerifyingInputStream = new CRC32VerifyingInputStream(cRC32VerifyingInputStream, folder.d(), folder.f27624h);
        }
        int assertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("unpackSize", folder.d());
        byte[] readRange = IOUtils.readRange(cRC32VerifyingInputStream, assertFitsIntoNonNegativeInt);
        if (readRange.length >= assertFitsIntoNonNegativeInt) {
            cRC32VerifyingInputStream.close();
            return ByteBuffer.wrap(readRange).order(ByteOrder.LITTLE_ENDIAN);
        }
        throw new IOException("premature end of stream");
    }

    private void readFilesInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        boolean z11;
        boolean z12;
        ByteBuffer byteBuffer2 = byteBuffer;
        Archive archive3 = archive2;
        int readUint64 = (int) readUint64(byteBuffer);
        HashMap hashMap = new HashMap();
        BitSet bitSet = null;
        BitSet bitSet2 = null;
        BitSet bitSet3 = null;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            int i11 = 0;
            if (unsignedByte == 0) {
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < readUint64; i14++) {
                    SevenZArchiveEntry sevenZArchiveEntry = (SevenZArchiveEntry) hashMap.get(Integer.valueOf(i14));
                    if (sevenZArchiveEntry != null) {
                        boolean z13 = true;
                        if (bitSet == null || !bitSet.get(i14)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        sevenZArchiveEntry.setHasStream(z11);
                        if (!sevenZArchiveEntry.hasStream()) {
                            if (bitSet2 == null || !bitSet2.get(i12)) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            sevenZArchiveEntry.setDirectory(z12);
                            if (bitSet3 == null || !bitSet3.get(i12)) {
                                z13 = false;
                            }
                            sevenZArchiveEntry.setAntiItem(z13);
                            sevenZArchiveEntry.setHasCrc(false);
                            sevenZArchiveEntry.setSize(0);
                            i12++;
                        } else if (archive3.f27603f != null) {
                            sevenZArchiveEntry.setDirectory(false);
                            sevenZArchiveEntry.setAntiItem(false);
                            sevenZArchiveEntry.setHasCrc(archive3.f27603f.f27640b.get(i13));
                            sevenZArchiveEntry.setCrcValue(archive3.f27603f.f27641c[i13]);
                            sevenZArchiveEntry.setSize(archive3.f27603f.f27639a[i13]);
                            if (sevenZArchiveEntry.getSize() >= 0) {
                                i13++;
                            } else {
                                throw new IOException("broken archive, entry with negative size");
                            }
                        } else {
                            throw new IOException("Archive contains file with streams but no subStreamsInfo");
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (SevenZArchiveEntry sevenZArchiveEntry2 : hashMap.values()) {
                    if (sevenZArchiveEntry2 != null) {
                        arrayList.add(sevenZArchiveEntry2);
                    }
                }
                archive3.f27604g = (SevenZArchiveEntry[]) arrayList.toArray(SevenZArchiveEntry.EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY);
                calculateStreamMap(archive3);
                return;
            }
            long readUint642 = readUint64(byteBuffer);
            if (unsignedByte != 25) {
                switch (unsignedByte) {
                    case 14:
                        bitSet = readBits(byteBuffer2, readUint64);
                        break;
                    case 15:
                        bitSet2 = readBits(byteBuffer2, bitSet.cardinality());
                        break;
                    case 16:
                        bitSet3 = readBits(byteBuffer2, bitSet.cardinality());
                        break;
                    case 17:
                        getUnsignedByte(byteBuffer);
                        int i15 = (int) (readUint642 - 1);
                        byte[] bArr = new byte[i15];
                        get(byteBuffer2, bArr);
                        int i16 = 0;
                        int i17 = 0;
                        while (i11 < i15) {
                            if (bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                                checkEntryIsInitialized(hashMap, i17);
                                ((SevenZArchiveEntry) hashMap.get(Integer.valueOf(i17))).setName(new String(bArr, i16, i11 - i16, StandardCharsets.UTF_16LE));
                                i17++;
                                i16 = i11 + 2;
                            }
                            i11 += 2;
                            Archive archive4 = archive2;
                        }
                        if (i16 != i15 || i17 != readUint64) {
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        BitSet readAllOrBits = readAllOrBits(byteBuffer2, readUint64);
                        getUnsignedByte(byteBuffer);
                        while (i11 < readUint64) {
                            checkEntryIsInitialized(hashMap, i11);
                            SevenZArchiveEntry sevenZArchiveEntry3 = (SevenZArchiveEntry) hashMap.get(Integer.valueOf(i11));
                            sevenZArchiveEntry3.setHasCreationDate(readAllOrBits.get(i11));
                            if (sevenZArchiveEntry3.getHasCreationDate()) {
                                sevenZArchiveEntry3.setCreationDate(getLong(byteBuffer));
                            }
                            i11++;
                        }
                        break;
                    case 19:
                        BitSet readAllOrBits2 = readAllOrBits(byteBuffer2, readUint64);
                        getUnsignedByte(byteBuffer);
                        while (i11 < readUint64) {
                            checkEntryIsInitialized(hashMap, i11);
                            SevenZArchiveEntry sevenZArchiveEntry4 = (SevenZArchiveEntry) hashMap.get(Integer.valueOf(i11));
                            sevenZArchiveEntry4.setHasAccessDate(readAllOrBits2.get(i11));
                            if (sevenZArchiveEntry4.getHasAccessDate()) {
                                sevenZArchiveEntry4.setAccessDate(getLong(byteBuffer));
                            }
                            i11++;
                        }
                        break;
                    case 20:
                        BitSet readAllOrBits3 = readAllOrBits(byteBuffer2, readUint64);
                        getUnsignedByte(byteBuffer);
                        while (i11 < readUint64) {
                            checkEntryIsInitialized(hashMap, i11);
                            SevenZArchiveEntry sevenZArchiveEntry5 = (SevenZArchiveEntry) hashMap.get(Integer.valueOf(i11));
                            sevenZArchiveEntry5.setHasLastModifiedDate(readAllOrBits3.get(i11));
                            if (sevenZArchiveEntry5.getHasLastModifiedDate()) {
                                sevenZArchiveEntry5.setLastModifiedDate(getLong(byteBuffer));
                            }
                            i11++;
                        }
                        break;
                    case 21:
                        BitSet readAllOrBits4 = readAllOrBits(byteBuffer2, readUint64);
                        getUnsignedByte(byteBuffer);
                        while (i11 < readUint64) {
                            checkEntryIsInitialized(hashMap, i11);
                            SevenZArchiveEntry sevenZArchiveEntry6 = (SevenZArchiveEntry) hashMap.get(Integer.valueOf(i11));
                            sevenZArchiveEntry6.setHasWindowsAttributes(readAllOrBits4.get(i11));
                            if (sevenZArchiveEntry6.getHasWindowsAttributes()) {
                                sevenZArchiveEntry6.setWindowsAttributes(getInt(byteBuffer));
                            }
                            i11++;
                        }
                        break;
                    default:
                        skipBytesFully(byteBuffer2, readUint642);
                        break;
                }
            } else {
                skipBytesFully(byteBuffer2, readUint642);
            }
            archive3 = archive2;
        }
        throw new IOException("Error parsing file names");
    }

    private Folder readFolder(ByteBuffer byteBuffer) throws IOException {
        boolean z11;
        boolean z12;
        ByteBuffer byteBuffer2 = byteBuffer;
        Folder folder = new Folder();
        int readUint64 = (int) readUint64(byteBuffer);
        Coder[] coderArr = new Coder[readUint64];
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        while (i11 < readUint64) {
            coderArr[i11] = new Coder();
            int unsignedByte = getUnsignedByte(byteBuffer);
            int i12 = unsignedByte & 15;
            boolean z13 = true;
            if ((unsignedByte & 16) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((unsignedByte & 32) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((unsignedByte & 128) == 0) {
                z13 = false;
            }
            byte[] bArr = new byte[i12];
            coderArr[i11].f27608a = bArr;
            get(byteBuffer2, bArr);
            if (z11) {
                Coder coder = coderArr[i11];
                coder.f27609b = 1;
                coder.f27610c = 1;
            } else {
                coderArr[i11].f27609b = readUint64(byteBuffer);
                coderArr[i11].f27610c = readUint64(byteBuffer);
            }
            Coder coder2 = coderArr[i11];
            j11 += coder2.f27609b;
            j12 += coder2.f27610c;
            if (z12) {
                byte[] bArr2 = new byte[((int) readUint64(byteBuffer))];
                coderArr[i11].f27611d = bArr2;
                get(byteBuffer2, bArr2);
            }
            if (!z13) {
                i11++;
            } else {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
        }
        folder.f27617a = coderArr;
        folder.f27618b = j11;
        folder.f27619c = j12;
        long j13 = j12 - 1;
        int i13 = (int) j13;
        BindPair[] bindPairArr = new BindPair[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            BindPair bindPair = new BindPair();
            bindPairArr[i14] = bindPair;
            bindPair.f27606a = readUint64(byteBuffer);
            bindPairArr[i14].f27607b = readUint64(byteBuffer);
        }
        folder.f27620d = bindPairArr;
        long j14 = j11 - j13;
        int i15 = (int) j14;
        long[] jArr = new long[i15];
        if (j14 == 1) {
            int i16 = 0;
            while (i16 < ((int) j11) && folder.a(i16) >= 0) {
                i16++;
            }
            jArr[0] = (long) i16;
        } else {
            for (int i17 = 0; i17 < i15; i17++) {
                jArr[i17] = readUint64(byteBuffer);
            }
        }
        folder.f27621e = jArr;
        return folder;
    }

    private void readFully(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.rewind();
        IOUtils.readFully((ReadableByteChannel) this.channel, byteBuffer);
        byteBuffer.flip();
    }

    private void readHeader(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        int position = byteBuffer.position();
        sanityCheckAndCollectStatistics(byteBuffer).r(this.options.getMaxMemoryLimitInKb());
        byteBuffer.position(position);
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            readArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 3) {
            if (unsignedByte == 4) {
                readStreamsInfo(byteBuffer, archive2);
                unsignedByte = getUnsignedByte(byteBuffer);
            }
            if (unsignedByte == 5) {
                readFilesInfo(byteBuffer, archive2);
                getUnsignedByte(byteBuffer);
                return;
            }
            return;
        }
        throw new IOException("Additional streams unsupported");
    }

    private Archive readHeaders(byte[] bArr) throws IOException {
        ByteBuffer order = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        readFully(order);
        byte[] bArr2 = new byte[6];
        order.get(bArr2);
        if (Arrays.equals(bArr2, sevenZSignature)) {
            byte b11 = order.get();
            byte b12 = order.get();
            boolean z11 = false;
            if (b11 == 0) {
                long j11 = ((long) order.getInt()) & 4294967295L;
                if (j11 == 0) {
                    long a11 = this.channel.position();
                    ByteBuffer allocate = ByteBuffer.allocate(20);
                    readFully(allocate);
                    SeekableByteChannel unused = this.channel.position(a11);
                    while (true) {
                        if (allocate.hasRemaining()) {
                            if (allocate.get() != 0) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    z11 = true;
                } else {
                    z11 = true;
                }
                if (z11) {
                    return initializeArchive(readStartHeader(j11), bArr, true);
                }
                if (this.options.getTryToRecoverBrokenArchives()) {
                    return tryToLocateEndHeader(bArr);
                }
                throw new IOException("archive seems to be invalid.\nYou may want to retry and enable the tryToRecoverBrokenArchives if the archive could be a multi volume archive that has been closed prematurely.");
            }
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", new Object[]{Byte.valueOf(b11), Byte.valueOf(b12)}));
        }
        throw new IOException("Bad 7z signature");
    }

    private void readPackInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        archive2.f27598a = readUint64(byteBuffer);
        int readUint64 = (int) readUint64(byteBuffer);
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 9) {
            archive2.f27599b = new long[readUint64];
            int i11 = 0;
            while (true) {
                long[] jArr = archive2.f27599b;
                if (i11 >= jArr.length) {
                    break;
                }
                jArr[i11] = readUint64(byteBuffer);
                i11++;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 10) {
            archive2.f27600c = readAllOrBits(byteBuffer, readUint64);
            archive2.f27601d = new long[readUint64];
            for (int i12 = 0; i12 < readUint64; i12++) {
                if (archive2.f27600c.get(i12)) {
                    archive2.f27601d[i12] = ((long) getInt(byteBuffer)) & 4294967295L;
                }
            }
            getUnsignedByte(byteBuffer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        r10.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.archivers.sevenz.StartHeader readStartHeader(long r10) throws java.io.IOException {
        /*
            r9 = this;
            org.apache.commons.compress.archivers.sevenz.StartHeader r0 = new org.apache.commons.compress.archivers.sevenz.StartHeader
            r0.<init>()
            java.io.DataInputStream r1 = new java.io.DataInputStream
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r8 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream r3 = new org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream
            java.nio.channels.SeekableByteChannel r2 = r9.channel
            r4 = 20
            r3.<init>(r2, r4)
            r2 = r8
            r6 = r10
            r2.<init>((java.io.InputStream) r3, (long) r4, (long) r6)
            r1.<init>(r8)
            long r10 = r1.readLong()     // Catch:{ all -> 0x0078 }
            long r10 = java.lang.Long.reverseBytes(r10)     // Catch:{ all -> 0x0078 }
            r0.f27632a = r10     // Catch:{ all -> 0x0078 }
            r2 = 0
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0070
            r2 = 32
            long r10 = r10 + r2
            java.nio.channels.SeekableByteChannel r4 = r9.channel     // Catch:{ all -> 0x0078 }
            long r4 = r4.size()     // Catch:{ all -> 0x0078 }
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x0070
            long r10 = r1.readLong()     // Catch:{ all -> 0x0078 }
            long r10 = java.lang.Long.reverseBytes(r10)     // Catch:{ all -> 0x0078 }
            r0.f27633b = r10     // Catch:{ all -> 0x0078 }
            long r4 = r0.f27632a     // Catch:{ all -> 0x0078 }
            long r10 = r10 + r4
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0068
            long r10 = r10 + r2
            java.nio.channels.SeekableByteChannel r2 = r9.channel     // Catch:{ all -> 0x0078 }
            long r2 = r2.size()     // Catch:{ all -> 0x0078 }
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 > 0) goto L_0x0068
            int r10 = r1.readInt()     // Catch:{ all -> 0x0078 }
            int r10 = java.lang.Integer.reverseBytes(r10)     // Catch:{ all -> 0x0078 }
            long r10 = (long) r10     // Catch:{ all -> 0x0078 }
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r10 = r10 & r2
            r0.f27634c = r10     // Catch:{ all -> 0x0078 }
            r1.close()
            return r0
        L_0x0068:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0078 }
            java.lang.String r11 = "nextHeaderSize is out of bounds"
            r10.<init>(r11)     // Catch:{ all -> 0x0078 }
            throw r10     // Catch:{ all -> 0x0078 }
        L_0x0070:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0078 }
            java.lang.String r11 = "nextHeaderOffset is out of bounds"
            r10.<init>(r11)     // Catch:{ all -> 0x0078 }
            throw r10     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x007a }
        L_0x007a:
            r11 = move-exception
            r1.close()     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r10.addSuppressed(r0)
        L_0x0083:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.readStartHeader(long):org.apache.commons.compress.archivers.sevenz.StartHeader");
    }

    private void readStreamsInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            readPackInfo(byteBuffer, archive2);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            readUnpackInfo(byteBuffer, archive2);
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            archive2.f27602e = Folder.f27616j;
        }
        if (unsignedByte == 8) {
            readSubStreamsInfo(byteBuffer, archive2);
            getUnsignedByte(byteBuffer);
        }
    }

    private void readSubStreamsInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        Archive archive3 = archive2;
        for (Folder folder : archive3.f27602e) {
            folder.f27625i = 1;
        }
        long length = (long) archive3.f27602e.length;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 13) {
            long j11 = 0;
            for (Folder folder2 : archive3.f27602e) {
                long readUint64 = readUint64(byteBuffer);
                folder2.f27625i = (int) readUint64;
                j11 += readUint64;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
            length = j11;
        }
        int i11 = (int) length;
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.f27639a = new long[i11];
        subStreamsInfo.f27640b = new BitSet(i11);
        subStreamsInfo.f27641c = new long[i11];
        int i12 = 0;
        for (Folder folder3 : archive3.f27602e) {
            if (folder3.f27625i != 0) {
                long j12 = 0;
                if (unsignedByte == 9) {
                    int i13 = 0;
                    while (i13 < folder3.f27625i - 1) {
                        long readUint642 = readUint64(byteBuffer);
                        subStreamsInfo.f27639a[i12] = readUint642;
                        j12 += readUint642;
                        i13++;
                        i12++;
                    }
                }
                if (j12 <= folder3.d()) {
                    subStreamsInfo.f27639a[i12] = folder3.d() - j12;
                    i12++;
                } else {
                    throw new IOException("sum of unpack sizes of folder exceeds total unpack size");
                }
            }
        }
        if (unsignedByte == 9) {
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        int i14 = 0;
        for (Folder folder4 : archive3.f27602e) {
            int i15 = folder4.f27625i;
            if (i15 != 1 || !folder4.f27623g) {
                i14 += i15;
            }
        }
        if (unsignedByte == 10) {
            BitSet readAllOrBits = readAllOrBits(byteBuffer, i14);
            long[] jArr = new long[i14];
            for (int i16 = 0; i16 < i14; i16++) {
                if (readAllOrBits.get(i16)) {
                    jArr[i16] = ((long) getInt(byteBuffer)) & 4294967295L;
                }
            }
            int i17 = 0;
            int i18 = 0;
            for (Folder folder5 : archive3.f27602e) {
                if (folder5.f27625i != 1 || !folder5.f27623g) {
                    for (int i19 = 0; i19 < folder5.f27625i; i19++) {
                        subStreamsInfo.f27640b.set(i17, readAllOrBits.get(i18));
                        subStreamsInfo.f27641c[i17] = jArr[i18];
                        i17++;
                        i18++;
                    }
                } else {
                    subStreamsInfo.f27640b.set(i17, true);
                    subStreamsInfo.f27641c[i17] = folder5.f27624h;
                    i17++;
                }
            }
            getUnsignedByte(byteBuffer);
        }
        archive3.f27603f = subStreamsInfo;
    }

    private static long readUint64(ByteBuffer byteBuffer) throws IOException {
        long unsignedByte = (long) getUnsignedByte(byteBuffer);
        int i11 = 128;
        long j11 = 0;
        for (int i12 = 0; i12 < 8; i12++) {
            if ((((long) i11) & unsignedByte) == 0) {
                return ((unsignedByte & ((long) (i11 - 1))) << (i12 * 8)) | j11;
            }
            j11 |= ((long) getUnsignedByte(byteBuffer)) << (i12 * 8);
            i11 >>>= 1;
        }
        return j11;
    }

    private void readUnpackInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        getUnsignedByte(byteBuffer);
        int readUint64 = (int) readUint64(byteBuffer);
        Folder[] folderArr = new Folder[readUint64];
        archive2.f27602e = folderArr;
        getUnsignedByte(byteBuffer);
        for (int i11 = 0; i11 < readUint64; i11++) {
            folderArr[i11] = readFolder(byteBuffer);
        }
        getUnsignedByte(byteBuffer);
        for (int i12 = 0; i12 < readUint64; i12++) {
            Folder folder = folderArr[i12];
            assertFitsIntoNonNegativeInt("totalOutputStreams", folder.f27619c);
            folder.f27622f = new long[((int) folder.f27619c)];
            for (int i13 = 0; ((long) i13) < folder.f27619c; i13++) {
                folder.f27622f[i13] = readUint64(byteBuffer);
            }
        }
        if (getUnsignedByte(byteBuffer) == 10) {
            BitSet readAllOrBits = readAllOrBits(byteBuffer, readUint64);
            for (int i14 = 0; i14 < readUint64; i14++) {
                if (readAllOrBits.get(i14)) {
                    Folder folder2 = folderArr[i14];
                    folder2.f27623g = true;
                    folder2.f27624h = ((long) getInt(byteBuffer)) & 4294967295L;
                } else {
                    folderArr[i14].f27623g = false;
                }
            }
            getUnsignedByte(byteBuffer);
        }
    }

    private void reopenFolderInputStream(int i11, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        this.deferredBlockStreams.clear();
        InputStream inputStream = this.currentFolderInputStream;
        if (inputStream != null) {
            inputStream.close();
            this.currentFolderInputStream = null;
        }
        Archive archive2 = this.archive;
        Folder folder = archive2.f27602e[i11];
        StreamMap streamMap = archive2.f27605h;
        int i12 = streamMap.f27635a[i11];
        this.currentFolderInputStream = buildDecoderStack(folder, archive2.f27598a + 32 + streamMap.f27636b[i12], i12, sevenZArchiveEntry);
    }

    private ArchiveStatistics sanityCheckAndCollectStatistics(ByteBuffer byteBuffer) throws IOException {
        ArchiveStatistics archiveStatistics = new ArchiveStatistics();
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            sanityCheckArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 3) {
            if (unsignedByte == 4) {
                sanityCheckStreamsInfo(byteBuffer, archiveStatistics);
                unsignedByte = getUnsignedByte(byteBuffer);
            }
            if (unsignedByte == 5) {
                sanityCheckFilesInfo(byteBuffer, archiveStatistics);
                unsignedByte = getUnsignedByte(byteBuffer);
            }
            if (unsignedByte == 0) {
                return archiveStatistics;
            }
            throw new IOException("Badly terminated header, found " + unsignedByte);
        }
        throw new IOException("Additional streams unsupported");
    }

    private void sanityCheckArchiveProperties(ByteBuffer byteBuffer) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            long assertFitsIntoNonNegativeInt = (long) assertFitsIntoNonNegativeInt("propertySize", readUint64(byteBuffer));
            if (skipBytesFully(byteBuffer, assertFitsIntoNonNegativeInt) >= assertFitsIntoNonNegativeInt) {
                unsignedByte = getUnsignedByte(byteBuffer);
            } else {
                throw new IOException("invalid property size");
            }
        }
    }

    private void sanityCheckFilesInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int unused = archiveStatistics.numberOfEntries = assertFitsIntoNonNegativeInt("numFiles", readUint64(byteBuffer));
        int i11 = -1;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            if (unsignedByte == 0) {
                int o11 = archiveStatistics.numberOfEntries;
                if (i11 <= 0) {
                    i11 = 0;
                }
                int unused2 = archiveStatistics.numberOfEntriesWithStream = o11 - i11;
                return;
            }
            long readUint64 = readUint64(byteBuffer);
            switch (unsignedByte) {
                case 14:
                    i11 = readBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    break;
                case 15:
                    if (i11 != -1) {
                        readBits(byteBuffer, i11);
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                    }
                case 16:
                    if (i11 != -1) {
                        readBits(byteBuffer, i11);
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                    }
                case 17:
                    if (getUnsignedByte(byteBuffer) == 0) {
                        int assertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("file names length", readUint64 - 1);
                        if ((assertFitsIntoNonNegativeInt & 1) == 0) {
                            int i12 = 0;
                            for (int i13 = 0; i13 < assertFitsIntoNonNegativeInt; i13 += 2) {
                                if (getChar(byteBuffer) == 0) {
                                    i12++;
                                }
                            }
                            if (i12 == archiveStatistics.numberOfEntries) {
                                break;
                            } else {
                                throw new IOException("Invalid number of file names (" + i12 + " instead of " + archiveStatistics.numberOfEntries + ")");
                            }
                        } else {
                            throw new IOException("File names length invalid");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 18:
                    int cardinality = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) == 0) {
                        long j11 = (long) (cardinality * 8);
                        if (skipBytesFully(byteBuffer, j11) >= j11) {
                            break;
                        } else {
                            throw new IOException("invalid creation dates size");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 19:
                    int cardinality2 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) == 0) {
                        long j12 = (long) (cardinality2 * 8);
                        if (skipBytesFully(byteBuffer, j12) >= j12) {
                            break;
                        } else {
                            throw new IOException("invalid access dates size");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 20:
                    int cardinality3 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) == 0) {
                        long j13 = (long) (cardinality3 * 8);
                        if (skipBytesFully(byteBuffer, j13) >= j13) {
                            break;
                        } else {
                            throw new IOException("invalid modification dates size");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 21:
                    int cardinality4 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) == 0) {
                        long j14 = (long) (cardinality4 * 4);
                        if (skipBytesFully(byteBuffer, j14) >= j14) {
                            break;
                        } else {
                            throw new IOException("invalid windows attributes size");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 24:
                    throw new IOException("kStartPos is unsupported, please report");
                case 25:
                    if (skipBytesFully(byteBuffer, readUint64) >= readUint64) {
                        break;
                    } else {
                        throw new IOException("Incomplete kDummy property");
                    }
                default:
                    if (skipBytesFully(byteBuffer, readUint64) >= readUint64) {
                        break;
                    } else {
                        throw new IOException("Incomplete property of type " + unsignedByte);
                    }
            }
        }
    }

    private int sanityCheckFolder(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        boolean z11;
        boolean z12;
        ByteBuffer byteBuffer2 = byteBuffer;
        ArchiveStatistics archiveStatistics2 = archiveStatistics;
        int assertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("numCoders", readUint64(byteBuffer));
        if (assertFitsIntoNonNegativeInt != 0) {
            long unused = archiveStatistics2.numberOfCoders = archiveStatistics.numberOfCoders + ((long) assertFitsIntoNonNegativeInt);
            int i11 = 0;
            long j11 = 0;
            long j12 = 0;
            int i12 = 0;
            while (true) {
                long j13 = 1;
                boolean z13 = true;
                if (i12 < assertFitsIntoNonNegativeInt) {
                    int unsignedByte = getUnsignedByte(byteBuffer);
                    get(byteBuffer2, new byte[(unsignedByte & 15)]);
                    if ((unsignedByte & 16) == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((unsignedByte & 32) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if ((unsignedByte & 128) == 0) {
                        z13 = false;
                    }
                    if (!z13) {
                        if (z11) {
                            j11++;
                        } else {
                            j11 += (long) assertFitsIntoNonNegativeInt("numInStreams", readUint64(byteBuffer));
                            j13 = (long) assertFitsIntoNonNegativeInt("numOutStreams", readUint64(byteBuffer));
                        }
                        j12 += j13;
                        if (z12) {
                            long assertFitsIntoNonNegativeInt2 = (long) assertFitsIntoNonNegativeInt("propertiesSize", readUint64(byteBuffer));
                            if (skipBytesFully(byteBuffer2, assertFitsIntoNonNegativeInt2) < assertFitsIntoNonNegativeInt2) {
                                throw new IOException("invalid propertiesSize in folder");
                            }
                        }
                        i12++;
                    } else {
                        throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
                    }
                } else {
                    assertFitsIntoNonNegativeInt("totalInStreams", j11);
                    assertFitsIntoNonNegativeInt("totalOutStreams", j12);
                    long unused2 = archiveStatistics2.numberOfOutStreams = archiveStatistics.numberOfOutStreams + j12;
                    long unused3 = archiveStatistics2.numberOfInStreams = archiveStatistics.numberOfInStreams + j11;
                    if (j12 != 0) {
                        int assertFitsIntoNonNegativeInt3 = assertFitsIntoNonNegativeInt("numBindPairs", j12 - 1);
                        long j14 = (long) assertFitsIntoNonNegativeInt3;
                        if (j11 >= j14) {
                            BitSet bitSet = new BitSet((int) j11);
                            int i13 = 0;
                            while (i13 < assertFitsIntoNonNegativeInt3) {
                                int assertFitsIntoNonNegativeInt4 = assertFitsIntoNonNegativeInt("inIndex", readUint64(byteBuffer));
                                if (j11 > ((long) assertFitsIntoNonNegativeInt4)) {
                                    bitSet.set(assertFitsIntoNonNegativeInt4);
                                    if (j12 > ((long) assertFitsIntoNonNegativeInt("outIndex", readUint64(byteBuffer)))) {
                                        i13++;
                                    } else {
                                        throw new IOException("outIndex is bigger than number of outStreams");
                                    }
                                } else {
                                    throw new IOException("inIndex is bigger than number of inStreams");
                                }
                            }
                            int assertFitsIntoNonNegativeInt5 = assertFitsIntoNonNegativeInt("numPackedStreams", j11 - j14);
                            if (assertFitsIntoNonNegativeInt5 != 1) {
                                while (i11 < assertFitsIntoNonNegativeInt5) {
                                    if (((long) assertFitsIntoNonNegativeInt("packedStreamIndex", readUint64(byteBuffer))) < j11) {
                                        i11++;
                                    } else {
                                        throw new IOException("packedStreamIndex is bigger than number of totalInStreams");
                                    }
                                }
                            } else if (bitSet.nextClearBit(0) == -1) {
                                throw new IOException("Couldn't find stream's bind pair index");
                            }
                            return (int) j12;
                        }
                        throw new IOException("Total input streams can't be less than the number of bind pairs");
                    }
                    throw new IOException("Total output streams can't be 0");
                }
            }
        } else {
            throw new IOException("Folder without coders");
        }
    }

    private void sanityCheckPackInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        ByteBuffer byteBuffer2 = byteBuffer;
        long readUint64 = readUint64(byteBuffer);
        long j11 = 0;
        if (readUint64 >= 0) {
            long j12 = 32 + readUint64;
            if (j12 <= this.channel.size() && j12 >= 0) {
                int unused = archiveStatistics.numberOfPackedStreams = assertFitsIntoNonNegativeInt("numPackStreams", readUint64(byteBuffer));
                int unsignedByte = getUnsignedByte(byteBuffer);
                if (unsignedByte == 9) {
                    int i11 = 0;
                    long j13 = 0;
                    while (i11 < archiveStatistics.numberOfPackedStreams) {
                        long readUint642 = readUint64(byteBuffer);
                        j13 += readUint642;
                        long j14 = j12 + j13;
                        if (readUint642 < j11 || j14 > this.channel.size() || j14 < readUint64) {
                            throw new IOException("packSize (" + readUint642 + ") is out of range");
                        }
                        i11++;
                        j11 = 0;
                    }
                    unsignedByte = getUnsignedByte(byteBuffer);
                }
                if (unsignedByte == 10) {
                    long cardinality = (long) (readAllOrBits(byteBuffer2, archiveStatistics.numberOfPackedStreams).cardinality() * 4);
                    if (skipBytesFully(byteBuffer2, cardinality) >= cardinality) {
                        unsignedByte = getUnsignedByte(byteBuffer);
                    } else {
                        throw new IOException("invalid number of CRCs in PackInfo");
                    }
                }
                if (unsignedByte != 0) {
                    throw new IOException("Badly terminated PackInfo (" + unsignedByte + ")");
                }
                return;
            }
        }
        throw new IOException("packPos (" + readUint64 + ") is out of range");
    }

    private void sanityCheckStreamsInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            sanityCheckPackInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            sanityCheckUnpackInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 8) {
            sanityCheckSubStreamsInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void sanityCheckSubStreamsInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int i11;
        int unsignedByte = getUnsignedByte(byteBuffer);
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i12 = 0;
        if (unsignedByte == 13) {
            for (int i13 = 0; i13 < archiveStatistics.numberOfFolders; i13++) {
                linkedList.add(Integer.valueOf(assertFitsIntoNonNegativeInt("numStreams", readUint64(byteBuffer))));
            }
            long unused = archiveStatistics.numberOfUnpackSubStreams = ((Long) Collection.EL.stream(linkedList).collect(Collectors.summingLong(new b()))).longValue();
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            long unused2 = archiveStatistics.numberOfUnpackSubStreams = (long) archiveStatistics.numberOfFolders;
        }
        assertFitsIntoNonNegativeInt("totalUnpackStreams", archiveStatistics.numberOfUnpackSubStreams);
        if (unsignedByte == 9) {
            for (Integer intValue : linkedList) {
                int intValue2 = intValue.intValue();
                if (intValue2 != 0) {
                    int i14 = 0;
                    while (i14 < intValue2 - 1) {
                        if (readUint64(byteBuffer) >= 0) {
                            i14++;
                        } else {
                            throw new IOException("negative unpackSize");
                        }
                    }
                    continue;
                }
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (!linkedList.isEmpty()) {
            int i15 = 0;
            for (Integer intValue3 : linkedList) {
                int intValue4 = intValue3.intValue();
                if (intValue4 == 1 && archiveStatistics.folderHasCrc != null) {
                    int i16 = i15 + 1;
                    if (!archiveStatistics.folderHasCrc.get(i15)) {
                        i15 = i16;
                    } else {
                        i15 = i16;
                    }
                }
                i12 += intValue4;
            }
            i11 = i12;
        } else if (archiveStatistics.folderHasCrc == null) {
            i11 = archiveStatistics.numberOfFolders;
        } else {
            i11 = archiveStatistics.numberOfFolders - archiveStatistics.folderHasCrc.cardinality();
        }
        if (unsignedByte == 10) {
            assertFitsIntoNonNegativeInt("numDigests", (long) i11);
            long cardinality = (long) (readAllOrBits(byteBuffer, i11).cardinality() * 4);
            if (skipBytesFully(byteBuffer, cardinality) >= cardinality) {
                unsignedByte = getUnsignedByte(byteBuffer);
            } else {
                throw new IOException("invalid number of missing CRCs in SubStreamInfo");
            }
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated SubStreamsInfo");
        }
    }

    private void sanityCheckUnpackInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 11) {
            int unused = archiveStatistics.numberOfFolders = assertFitsIntoNonNegativeInt("numFolders", readUint64(byteBuffer));
            if (getUnsignedByte(byteBuffer) == 0) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                for (int i11 = 0; i11 < archiveStatistics.numberOfFolders; i11++) {
                    linkedList.add(Integer.valueOf(sanityCheckFolder(byteBuffer, archiveStatistics)));
                }
                if (archiveStatistics.numberOfInStreams - (archiveStatistics.numberOfOutStreams - ((long) archiveStatistics.numberOfFolders)) >= ((long) archiveStatistics.numberOfPackedStreams)) {
                    int unsignedByte2 = getUnsignedByte(byteBuffer);
                    if (unsignedByte2 == 12) {
                        for (Integer intValue : linkedList) {
                            int intValue2 = intValue.intValue();
                            int i12 = 0;
                            while (true) {
                                if (i12 < intValue2) {
                                    if (readUint64(byteBuffer) >= 0) {
                                        i12++;
                                    } else {
                                        throw new IllegalArgumentException("negative unpackSize");
                                    }
                                }
                            }
                        }
                        int unsignedByte3 = getUnsignedByte(byteBuffer);
                        if (unsignedByte3 == 10) {
                            BitSet unused2 = archiveStatistics.folderHasCrc = readAllOrBits(byteBuffer, archiveStatistics.numberOfFolders);
                            long cardinality = (long) (archiveStatistics.folderHasCrc.cardinality() * 4);
                            if (skipBytesFully(byteBuffer, cardinality) >= cardinality) {
                                unsignedByte3 = getUnsignedByte(byteBuffer);
                            } else {
                                throw new IOException("invalid number of CRCs in UnpackInfo");
                            }
                        }
                        if (unsignedByte3 != 0) {
                            throw new IOException("Badly terminated UnpackInfo");
                        }
                        return;
                    }
                    throw new IOException("Expected kCodersUnpackSize, got " + unsignedByte2);
                }
                throw new IOException("archive doesn't contain enough packed streams");
            }
            throw new IOException("External unsupported");
        }
        throw new IOException("Expected kFolder, got " + unsignedByte);
    }

    private static long skipBytesFully(ByteBuffer byteBuffer, long j11) throws IOException {
        if (j11 < 1) {
            return 0;
        }
        int position = byteBuffer.position();
        long remaining = (long) byteBuffer.remaining();
        if (remaining < j11) {
            j11 = remaining;
        }
        byteBuffer.position(position + ((int) j11));
        return j11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: org.apache.commons.compress.utils.CRC32VerifyingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean skipEntriesWhenNeeded(int r10, boolean r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r9.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.f27604g
            r0 = r0[r10]
            int r1 = r9.currentEntryIndex
            if (r1 != r10) goto L_0x0012
            boolean r1 = r9.hasCurrentEntryBeenRead()
            if (r1 != 0) goto L_0x0012
            r10 = 0
            return r10
        L_0x0012:
            org.apache.commons.compress.archivers.sevenz.Archive r1 = r9.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r1 = r1.f27605h
            int[] r1 = r1.f27637c
            int r2 = r9.currentFolderIndex
            r1 = r1[r2]
            r2 = 1
            if (r11 == 0) goto L_0x0029
            int r11 = r9.currentEntryIndex
            if (r11 >= r10) goto L_0x0026
            int r1 = r11 + 1
            goto L_0x0029
        L_0x0026:
            r9.reopenFolderInputStream(r12, r0)
        L_0x0029:
            if (r1 >= r10) goto L_0x0060
            org.apache.commons.compress.archivers.sevenz.Archive r11 = r9.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r11 = r11.f27604g
            r11 = r11[r1]
            org.apache.commons.compress.utils.BoundedInputStream r4 = new org.apache.commons.compress.utils.BoundedInputStream
            java.io.InputStream r12 = r9.currentFolderInputStream
            long r5 = r11.getSize()
            r4.<init>(r12, r5)
            boolean r12 = r11.getHasCrc()
            if (r12 == 0) goto L_0x0051
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r12 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            long r5 = r11.getSize()
            long r7 = r11.getCrcValue()
            r3 = r12
            r3.<init>((java.io.InputStream) r4, (long) r5, (long) r7)
            r4 = r12
        L_0x0051:
            java.util.ArrayList<java.io.InputStream> r12 = r9.deferredBlockStreams
            r12.add(r4)
            java.lang.Iterable r12 = r0.getContentMethods()
            r11.setContentMethods(r12)
            int r1 = r1 + 1
            goto L_0x0029
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.skipEntriesWhenNeeded(int, boolean, int):boolean");
    }

    private Archive tryToLocateEndHeader(byte[] bArr) throws IOException {
        long j11;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        long a11 = this.channel.position() + 20;
        if (this.channel.position() + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED > this.channel.size()) {
            j11 = this.channel.position();
        } else {
            j11 = this.channel.size() - PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        long a12 = this.channel.size() - 1;
        while (a12 > j11) {
            a12--;
            SeekableByteChannel unused = this.channel.position(a12);
            allocate.rewind();
            if (this.channel.read(allocate) >= 1) {
                byte b11 = allocate.array()[0];
                if (b11 == 23 || b11 == 1) {
                    try {
                        StartHeader startHeader = new StartHeader();
                        startHeader.f27632a = a12 - a11;
                        startHeader.f27633b = this.channel.size() - a12;
                        Archive initializeArchive = initializeArchive(startHeader, bArr, false);
                        if (initializeArchive.f27599b.length > 0 && initializeArchive.f27604g.length > 0) {
                            return initializeArchive;
                        }
                    } catch (Exception unused2) {
                        continue;
                    }
                }
            } else {
                throw new EOFException();
            }
        }
        throw new IOException("Start header corrupt and unable to guess end header");
    }

    private static byte[] utf16Decode(char[] cArr) throws IOException {
        if (cArr == null) {
            return null;
        }
        ByteBuffer encode = PASSWORD_ENCODER.encode(CharBuffer.wrap(cArr));
        if (encode.hasArray()) {
            return encode.array();
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    public void close() throws IOException {
        SeekableByteChannel seekableByteChannel = this.channel;
        if (seekableByteChannel != null) {
            try {
                seekableByteChannel.close();
            } finally {
                this.channel = null;
                byte[] bArr = this.password;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public String getDefaultName() {
        if (DEFAULT_FILE_NAME.equals(this.fileName) || this.fileName == null) {
            return null;
        }
        String name2 = new File(this.fileName).getName();
        int lastIndexOf = name2.lastIndexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        if (lastIndexOf > 0) {
            return name2.substring(0, lastIndexOf);
        }
        return name2 + "~";
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return new ArrayList(Arrays.asList(this.archive.f27604g));
    }

    public InputStream getInputStream(SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        int i11 = 0;
        while (true) {
            SevenZArchiveEntry[] sevenZArchiveEntryArr = this.archive.f27604g;
            if (i11 >= sevenZArchiveEntryArr.length) {
                i11 = -1;
                break;
            } else if (sevenZArchiveEntry == sevenZArchiveEntryArr[i11]) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            buildDecodingStream(i11, true);
            this.currentEntryIndex = i11;
            this.currentFolderIndex = this.archive.f27605h.f27638d[i11];
            return getCurrentStream();
        }
        throw new IllegalArgumentException("Can not find " + sevenZArchiveEntry.getName() + " in " + this.fileName);
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        int i11 = this.currentEntryIndex;
        SevenZArchiveEntry[] sevenZArchiveEntryArr = this.archive.f27604g;
        if (i11 >= sevenZArchiveEntryArr.length - 1) {
            return null;
        }
        int i12 = i11 + 1;
        this.currentEntryIndex = i12;
        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[i12];
        if (sevenZArchiveEntry.getName() == null && this.options.getUseDefaultNameForUnnamedEntries()) {
            sevenZArchiveEntry.setName(getDefaultName());
        }
        buildDecodingStream(this.currentEntryIndex, false);
        this.compressedBytesReadFromCurrentEntry = 0;
        this.uncompressedBytesReadFromCurrentEntry = 0;
        return sevenZArchiveEntry;
    }

    public InputStreamStatistics getStatisticsForCurrentEntry() {
        return new InputStreamStatistics() {
            public long getCompressedCount() {
                return SevenZFile.this.compressedBytesReadFromCurrentEntry;
            }

            public long getUncompressedCount() {
                return SevenZFile.this.uncompressedBytesReadFromCurrentEntry;
            }
        };
    }

    public int read() throws IOException {
        int read = getCurrentStream().read();
        if (read >= 0) {
            this.uncompressedBytesReadFromCurrentEntry++;
        }
        return read;
    }

    public String toString() {
        return this.archive.toString();
    }

    public SevenZFile(File file, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), utf16Decode(cArr), true, sevenZFileOptions);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int read = getCurrentStream().read(bArr, i11, i12);
        if (read > 0) {
            this.uncompressedBytesReadFromCurrentEntry += (long) read;
        }
        return read;
    }

    @Deprecated
    public SevenZFile(File file, byte[] bArr) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), bArr, true, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this(seekableByteChannel, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, (char[]) null, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr) throws IOException {
        this(seekableByteChannel, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, cArr, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr) throws IOException {
        this(seekableByteChannel, str, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, utf16Decode(cArr), false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        this(seekableByteChannel, str, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, (byte[]) null, false, sevenZFileOptions);
    }

    @Deprecated
    public SevenZFile(SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, bArr);
    }

    @Deprecated
    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr) throws IOException {
        this(seekableByteChannel, str, bArr, false, SevenZFileOptions.DEFAULT);
    }

    private SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z11, SevenZFileOptions sevenZFileOptions) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.deferredBlockStreams = new ArrayList<>();
        this.channel = seekableByteChannel;
        this.fileName = str;
        this.options = sevenZFileOptions;
        try {
            this.archive = readHeaders(bArr);
            if (bArr != null) {
                this.password = Arrays.copyOf(bArr, bArr.length);
            } else {
                this.password = null;
            }
        } catch (Throwable th2) {
            if (z11) {
                this.channel.close();
            }
            throw th2;
        }
    }

    public SevenZFile(File file) throws IOException {
        this(file, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(File file, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(file, (char[]) null, sevenZFileOptions);
    }
}
