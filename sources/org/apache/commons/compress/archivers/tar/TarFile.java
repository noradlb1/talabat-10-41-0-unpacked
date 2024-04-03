package org.apache.commons.compress.archivers.tar;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

public class TarFile implements Closeable {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final SeekableByteChannel archive;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    private final LinkedList<TarArchiveEntry> entries;
    private Map<String, String> globalPaxHeaders;
    private final List<TarArchiveStructSparse> globalSparseHeaders;
    private boolean hasHitEOF;
    private final boolean lenient;
    private final ByteBuffer recordBuffer;
    private final int recordSize;
    private final byte[] smallBuf;
    /* access modifiers changed from: private */
    public final Map<String, List<InputStream>> sparseInputStreams;
    private final ZipEncoding zipEncoding;

    public final class BoundedTarEntryInputStream extends BoundedArchiveInputStream {
        private final SeekableByteChannel channel;
        private int currentSparseInputStreamIndex;
        private final TarArchiveEntry entry;
        private long entryOffset;

        public BoundedTarEntryInputStream(TarArchiveEntry tarArchiveEntry, SeekableByteChannel seekableByteChannel) throws IOException {
            super(tarArchiveEntry.getDataOffset(), tarArchiveEntry.getRealSize());
            if (seekableByteChannel.size() - tarArchiveEntry.getSize() >= tarArchiveEntry.getDataOffset()) {
                this.entry = tarArchiveEntry;
                this.channel = seekableByteChannel;
                return;
            }
            throw new IOException("entry size exceeds archive size");
        }

        private int readArchive(long j11, ByteBuffer byteBuffer) throws IOException {
            SeekableByteChannel unused = this.channel.position(j11);
            return this.channel.read(byteBuffer);
        }

        private int readSparse(long j11, ByteBuffer byteBuffer, int i11) throws IOException {
            List list = (List) TarFile.this.sparseInputStreams.get(this.entry.getName());
            if (list == null || list.isEmpty()) {
                return readArchive(this.entry.getDataOffset() + j11, byteBuffer);
            }
            if (this.currentSparseInputStreamIndex >= list.size()) {
                return -1;
            }
            byte[] bArr = new byte[i11];
            int read = ((InputStream) list.get(this.currentSparseInputStreamIndex)).read(bArr);
            if (read != -1) {
                byteBuffer.put(bArr, 0, read);
            }
            if (this.currentSparseInputStreamIndex == list.size() - 1) {
                return read;
            }
            if (read == -1) {
                this.currentSparseInputStreamIndex++;
                return readSparse(j11, byteBuffer, i11);
            } else if (read >= i11) {
                return read;
            } else {
                this.currentSparseInputStreamIndex++;
                int readSparse = readSparse(j11 + ((long) read), byteBuffer, i11 - read);
                if (readSparse == -1) {
                    return read;
                }
                return read + readSparse;
            }
        }

        public int read(long j11, ByteBuffer byteBuffer) throws IOException {
            int i11;
            if (this.entryOffset >= this.entry.getRealSize()) {
                return -1;
            }
            if (this.entry.isSparse()) {
                i11 = readSparse(this.entryOffset, byteBuffer, byteBuffer.limit());
            } else {
                i11 = readArchive(j11, byteBuffer);
            }
            if (i11 != -1) {
                this.entryOffset += (long) i11;
                byteBuffer.flip();
            } else if (byteBuffer.array().length <= 0) {
                TarFile.this.setAtEOF(true);
            } else {
                throw new IOException("Truncated TAR archive");
            }
            return i11;
        }
    }

    public TarFile(byte[] bArr) throws IOException {
        this((SeekableByteChannel) new SeekableInMemoryByteChannel(bArr));
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map, List<TarArchiveStructSparse> list) throws IOException {
        this.currEntry.updateEntryFromPaxHeaders(map);
        this.currEntry.setSparseHeaders(list);
    }

    private void buildSparseInputStreams() throws IOException {
        ArrayList arrayList = new ArrayList();
        List<TarArchiveStructSparse> orderedSparseHeaders = this.currEntry.getOrderedSparseHeaders();
        TarArchiveSparseZeroInputStream tarArchiveSparseZeroInputStream = new TarArchiveSparseZeroInputStream();
        long j11 = 0;
        long j12 = 0;
        for (TarArchiveStructSparse next : orderedSparseHeaders) {
            long offset = next.getOffset() - j11;
            int i11 = (offset > 0 ? 1 : (offset == 0 ? 0 : -1));
            if (i11 >= 0) {
                if (i11 > 0) {
                    arrayList.add(new BoundedInputStream(tarArchiveSparseZeroInputStream, offset));
                    j12 += offset;
                }
                if (next.getNumbytes() > 0) {
                    long dataOffset = (this.currEntry.getDataOffset() + next.getOffset()) - j12;
                    if (next.getNumbytes() + dataOffset >= dataOffset) {
                        arrayList.add(new BoundedSeekableByteChannelInputStream(dataOffset, next.getNumbytes(), this.archive));
                    } else {
                        throw new IOException("Unreadable TAR archive, sparse block offset or length too big");
                    }
                }
                j11 = next.getOffset() + next.getNumbytes();
            } else {
                throw new IOException("Corrupted struct sparse detected");
            }
        }
        this.sparseInputStreams.put(this.currEntry.getName(), arrayList);
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long a11 = this.archive.position();
        int i11 = this.blockSize;
        long j11 = a11 % ((long) i11);
        if (j11 > 0) {
            repositionForwardBy(((long) i11) - j11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r1 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getLongNameData() throws java.io.IOException {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = r5.currEntry
            java.io.InputStream r1 = r5.getInputStream(r1)
        L_0x000b:
            byte[] r2 = r5.smallBuf     // Catch:{ all -> 0x0040 }
            int r2 = r1.read(r2)     // Catch:{ all -> 0x0040 }
            r3 = 0
            if (r2 < 0) goto L_0x001a
            byte[] r4 = r5.smallBuf     // Catch:{ all -> 0x0040 }
            r0.write(r4, r3, r2)     // Catch:{ all -> 0x0040 }
            goto L_0x000b
        L_0x001a:
            r1.close()
            r5.getNextTarEntry()
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = r5.currEntry
            if (r1 != 0) goto L_0x0026
            r0 = 0
            return r0
        L_0x0026:
            byte[] r0 = r0.toByteArray()
            int r1 = r0.length
        L_0x002b:
            if (r1 <= 0) goto L_0x0036
            int r2 = r1 + -1
            byte r2 = r0[r2]
            if (r2 != 0) goto L_0x0036
            int r1 = r1 + -1
            goto L_0x002b
        L_0x0036:
            int r2 = r0.length
            if (r1 == r2) goto L_0x003f
            byte[] r2 = new byte[r1]
            java.lang.System.arraycopy(r0, r3, r2, r3, r1)
            r0 = r2
        L_0x003f:
            return r0
        L_0x0040:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r2 = move-exception
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ all -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x004d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarFile.getLongNameData():byte[]");
    }

    private TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        if (tarArchiveEntry != null) {
            repositionForwardTo(tarArchiveEntry.getDataOffset() + this.currEntry.getSize());
            throwExceptionIfPositionIsNotInArchive();
            skipRecordPadding();
        }
        ByteBuffer record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(record.array(), this.zipEncoding, this.lenient, this.archive.position());
            this.currEntry = tarArchiveEntry2;
            if (tarArchiveEntry2.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.zipEncoding.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                String decode = this.zipEncoding.decode(longNameData2);
                this.currEntry.setName(decode);
                if (this.currEntry.isDirectory() && !decode.endsWith("/")) {
                    TarArchiveEntry tarArchiveEntry3 = this.currEntry;
                    tarArchiveEntry3.setName(decode + "/");
                }
            }
            if (this.currEntry.isGlobalPaxHeader()) {
                readGlobalPaxHeaders();
            }
            try {
                if (this.currEntry.isPaxHeader()) {
                    paxHeaders();
                } else if (!this.globalPaxHeaders.isEmpty()) {
                    applyPaxHeadersToCurrentEntry(this.globalPaxHeaders, this.globalSparseHeaders);
                }
                if (this.currEntry.isOldGNUSparse()) {
                    readOldGNUSparse();
                }
                return this.currEntry;
            } catch (NumberFormatException e11) {
                throw new IOException("Error detected parsing the pax header", e11);
            }
        } catch (IllegalArgumentException e12) {
            throw new IOException("Error detected parsing the header", e12);
        }
    }

    private ByteBuffer getRecord() throws IOException {
        ByteBuffer readRecord = readRecord();
        setAtEOF(isEOFRecord(readRecord));
        if (!isAtEOF() || readRecord == null) {
            return readRecord;
        }
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    }

    private boolean isDirectory() {
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        return tarArchiveEntry != null && tarArchiveEntry.isDirectory();
    }

    private boolean isEOFRecord(ByteBuffer byteBuffer) {
        return byteBuffer == null || ArchiveUtils.isArrayZero(byteBuffer.array(), this.recordSize);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (r0 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r1 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void paxHeaders() throws java.io.IOException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = r5.currEntry
            java.io.InputStream r1 = r5.getInputStream(r1)
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.globalPaxHeaders     // Catch:{ all -> 0x0083 }
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r3 = r5.currEntry     // Catch:{ all -> 0x0083 }
            long r3 = r3.getSize()     // Catch:{ all -> 0x0083 }
            java.util.Map r2 = org.apache.commons.compress.archivers.tar.TarUtils.parsePaxHeaders(r1, r0, r2, r3)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x001c
            r1.close()
        L_0x001c:
            java.lang.String r1 = "GNU.sparse.map"
            boolean r3 = r2.containsKey(r1)
            if (r3 == 0) goto L_0x0033
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = org.apache.commons.compress.archivers.tar.TarUtils.parseFromPAX01SparseHeaders(r1)
            r0.<init>(r1)
        L_0x0033:
            r5.getNextTarEntry()
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r1 = r5.currEntry
            if (r1 == 0) goto L_0x007b
            r5.applyPaxHeadersToCurrentEntry(r2, r0)
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            boolean r0 = r0.isPaxGNU1XSparse()
            if (r0 == 0) goto L_0x0077
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            java.io.InputStream r0 = r5.getInputStream(r0)
            int r1 = r5.recordSize     // Catch:{ all -> 0x0069 }
            java.util.List r1 = org.apache.commons.compress.archivers.tar.TarUtils.parsePAX1XSparseHeaders(r0, r1)     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0056
            r0.close()
        L_0x0056:
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            r0.setSparseHeaders(r1)
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            long r1 = r0.getDataOffset()
            int r3 = r5.recordSize
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.setDataOffset(r1)
            goto L_0x0077
        L_0x0069:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006b }
        L_0x006b:
            r2 = move-exception
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0076:
            throw r2
        L_0x0077:
            r5.buildSparseInputStreams()
            return
        L_0x007b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "premature end of tar archive. Didn't find any entry after PAX header."
            r0.<init>(r1)
            throw r0
        L_0x0083:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r2 = move-exception
            if (r1 == 0) goto L_0x0090
            r1.close()     // Catch:{ all -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0090:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarFile.paxHeaders():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readGlobalPaxHeaders() throws java.io.IOException {
        /*
            r5 = this;
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            java.io.InputStream r0 = r5.getInputStream(r0)
            java.util.List<org.apache.commons.compress.archivers.tar.TarArchiveStructSparse> r1 = r5.globalSparseHeaders     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.globalPaxHeaders     // Catch:{ all -> 0x002b }
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r3 = r5.currEntry     // Catch:{ all -> 0x002b }
            long r3 = r3.getSize()     // Catch:{ all -> 0x002b }
            java.util.Map r1 = org.apache.commons.compress.archivers.tar.TarUtils.parsePaxHeaders(r0, r1, r2, r3)     // Catch:{ all -> 0x002b }
            r5.globalPaxHeaders = r1     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            r5.getNextTarEntry()
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r0 = r5.currEntry
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Error detected parsing the pax header"
            r0.<init>(r1)
            throw r0
        L_0x002b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002d }
        L_0x002d:
            r2 = move-exception
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0038:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarFile.readGlobalPaxHeaders():void");
    }

    private void readOldGNUSparse() throws IOException {
        TarArchiveSparseEntry tarArchiveSparseEntry;
        if (this.currEntry.isExtended()) {
            do {
                ByteBuffer record = getRecord();
                if (record != null) {
                    tarArchiveSparseEntry = new TarArchiveSparseEntry(record.array());
                    this.currEntry.getSparseHeaders().addAll(tarArchiveSparseEntry.getSparseHeaders());
                    TarArchiveEntry tarArchiveEntry = this.currEntry;
                    tarArchiveEntry.setDataOffset(tarArchiveEntry.getDataOffset() + ((long) this.recordSize));
                } else {
                    throw new IOException("premature end of tar archive. Didn't find extended_header after header with extended flag.");
                }
            } while (tarArchiveSparseEntry.isExtended());
        }
        buildSparseInputStreams();
    }

    private ByteBuffer readRecord() throws IOException {
        this.recordBuffer.rewind();
        if (this.archive.read(this.recordBuffer) != this.recordSize) {
            return null;
        }
        return this.recordBuffer;
    }

    private void repositionForwardBy(long j11) throws IOException {
        repositionForwardTo(this.archive.position() + j11);
    }

    private void repositionForwardTo(long j11) throws IOException {
        if (j11 >= this.archive.position()) {
            SeekableByteChannel unused = this.archive.position(j11);
            return;
        }
        throw new IOException("trying to move backwards inside of the archive");
    }

    private void skipRecordPadding() throws IOException {
        if (!isDirectory() && this.currEntry.getSize() > 0 && this.currEntry.getSize() % ((long) this.recordSize) != 0) {
            long size = this.currEntry.getSize();
            int i11 = this.recordSize;
            repositionForwardBy((((size / ((long) i11)) + 1) * ((long) i11)) - this.currEntry.getSize());
            throwExceptionIfPositionIsNotInArchive();
        }
    }

    private void throwExceptionIfPositionIsNotInArchive() throws IOException {
        if (this.archive.size() < this.archive.position()) {
            throw new IOException("Truncated TAR archive");
        }
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        try {
            if (!(!isEOFRecord(readRecord()))) {
            }
        } finally {
            SeekableByteChannel seekableByteChannel = this.archive;
            SeekableByteChannel unused = seekableByteChannel.position(seekableByteChannel.position() - ((long) this.recordSize));
        }
    }

    public void close() throws IOException {
        this.archive.close();
    }

    public List<TarArchiveEntry> getEntries() {
        return new ArrayList(this.entries);
    }

    public InputStream getInputStream(TarArchiveEntry tarArchiveEntry) throws IOException {
        try {
            return new BoundedTarEntryInputStream(tarArchiveEntry, this.archive);
        } catch (RuntimeException e11) {
            throw new IOException("Corrupted TAR archive. Can't read entry", e11);
        }
    }

    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    public final void setAtEOF(boolean z11) {
        this.hasHitEOF = z11;
    }

    public TarFile(byte[] bArr, String str) throws IOException {
        this(new SeekableInMemoryByteChannel(bArr), 10240, 512, str, false);
    }

    public TarFile(byte[] bArr, boolean z11) throws IOException {
        this(new SeekableInMemoryByteChannel(bArr), 10240, 512, (String) null, z11);
    }

    public TarFile(File file) throws IOException {
        this(file.toPath());
    }

    public TarFile(File file, String str) throws IOException {
        this(file.toPath(), str);
    }

    public TarFile(File file, boolean z11) throws IOException {
        this(file.toPath(), z11);
    }

    public TarFile(Path path) throws IOException {
        this(Files.newByteChannel(path, new OpenOption[0]), 10240, 512, (String) null, false);
    }

    public TarFile(Path path, String str) throws IOException {
        this(Files.newByteChannel(path, new OpenOption[0]), 10240, 512, str, false);
    }

    public TarFile(Path path, boolean z11) throws IOException {
        this(Files.newByteChannel(path, new OpenOption[0]), 10240, 512, (String) null, z11);
    }

    public TarFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this(seekableByteChannel, 10240, 512, (String) null, false);
    }

    public TarFile(SeekableByteChannel seekableByteChannel, int i11, int i12, String str, boolean z11) throws IOException {
        this.smallBuf = new byte[256];
        this.entries = new LinkedList<>();
        this.globalSparseHeaders = new ArrayList();
        this.globalPaxHeaders = new HashMap();
        this.sparseInputStreams = new HashMap();
        this.archive = seekableByteChannel;
        this.hasHitEOF = false;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i12;
        this.recordBuffer = ByteBuffer.allocate(i12);
        this.blockSize = i11;
        this.lenient = z11;
        while (true) {
            TarArchiveEntry nextTarEntry = getNextTarEntry();
            if (nextTarEntry != null) {
                this.entries.add(nextTarEntry);
            } else {
                return;
            }
        }
    }
}
