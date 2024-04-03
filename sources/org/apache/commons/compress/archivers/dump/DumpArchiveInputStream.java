package org.apache.commons.compress.archivers.dump;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import k20.a;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;

public class DumpArchiveInputStream extends ArchiveInputStream {
    private DumpArchiveEntry active;
    private byte[] blockBuffer;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private long filepos;
    private boolean hasHitEOF;
    private boolean isClosed;
    private final Map<Integer, Dirent> names;
    private final Map<Integer, DumpArchiveEntry> pending;
    private final Queue<DumpArchiveEntry> queue;
    protected TapeInputStream raw;
    private final byte[] readBuf;
    private int readIdx;
    private int recordOffset;
    private final DumpArchiveSummary summary;
    private final ZipEncoding zipEncoding;

    public DumpArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, (String) null);
    }

    private String getPath(DumpArchiveEntry dumpArchiveEntry) {
        Stack stack = new Stack();
        int ino = dumpArchiveEntry.getIno();
        while (true) {
            if (!this.names.containsKey(Integer.valueOf(ino))) {
                stack.clear();
                break;
            }
            Dirent dirent = this.names.get(Integer.valueOf(ino));
            stack.push(dirent.b());
            if (dirent.a() == dirent.c()) {
                break;
            }
            ino = dirent.c();
        }
        if (stack.isEmpty()) {
            this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
            return null;
        }
        StringBuilder sb2 = new StringBuilder((String) stack.pop());
        while (!stack.isEmpty()) {
            sb2.append('/');
            sb2.append((String) stack.pop());
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(DumpArchiveEntry dumpArchiveEntry, DumpArchiveEntry dumpArchiveEntry2) {
        if (dumpArchiveEntry.getOriginalName() == null || dumpArchiveEntry2.getOriginalName() == null) {
            return Integer.MAX_VALUE;
        }
        return dumpArchiveEntry.getOriginalName().compareTo(dumpArchiveEntry2.getOriginalName());
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < 32) {
            return false;
        }
        if (i11 >= 1024) {
            return DumpArchiveUtil.verify(bArr);
        }
        if (60012 == DumpArchiveUtil.convert32(bArr, 24)) {
            return true;
        }
        return false;
    }

    private void readBITS() throws IOException {
        byte[] readRecord = this.raw.readRecord();
        if (DumpArchiveUtil.verify(readRecord)) {
            DumpArchiveEntry parse = DumpArchiveEntry.parse(readRecord);
            this.active = parse;
            if (DumpArchiveConstants.SEGMENT_TYPE.BITS != parse.getHeaderType()) {
                throw new InvalidFormatException();
            } else if (this.raw.skip(((long) this.active.getHeaderCount()) * 1024) != -1) {
                this.readIdx = this.active.getHeaderCount();
            } else {
                throw new EOFException();
            }
        } else {
            throw new InvalidFormatException();
        }
    }

    private void readCLRI() throws IOException {
        byte[] readRecord = this.raw.readRecord();
        if (DumpArchiveUtil.verify(readRecord)) {
            DumpArchiveEntry parse = DumpArchiveEntry.parse(readRecord);
            this.active = parse;
            if (DumpArchiveConstants.SEGMENT_TYPE.CLRI != parse.getHeaderType()) {
                throw new InvalidFormatException();
            } else if (this.raw.skip(((long) this.active.getHeaderCount()) * 1024) != -1) {
                this.readIdx = this.active.getHeaderCount();
            } else {
                throw new EOFException();
            }
        } else {
            throw new InvalidFormatException();
        }
    }

    private void readDirectoryEntry(DumpArchiveEntry dumpArchiveEntry) throws IOException {
        long entrySize2 = dumpArchiveEntry.getEntrySize();
        boolean z11 = true;
        while (true) {
            if (z11 || DumpArchiveConstants.SEGMENT_TYPE.ADDR == dumpArchiveEntry.getHeaderType()) {
                if (!z11) {
                    this.raw.readRecord();
                }
                if (!this.names.containsKey(Integer.valueOf(dumpArchiveEntry.getIno())) && DumpArchiveConstants.SEGMENT_TYPE.INODE == dumpArchiveEntry.getHeaderType()) {
                    this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
                }
                int headerCount = dumpArchiveEntry.getHeaderCount() * 1024;
                byte[] bArr = this.blockBuffer;
                if (bArr.length < headerCount) {
                    byte[] readRange = IOUtils.readRange((InputStream) this.raw, headerCount);
                    this.blockBuffer = readRange;
                    if (readRange.length != headerCount) {
                        throw new EOFException();
                    }
                } else if (this.raw.read(bArr, 0, headerCount) != headerCount) {
                    throw new EOFException();
                }
                int i11 = 0;
                while (i11 < headerCount - 8 && ((long) i11) < entrySize2 - 8) {
                    int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, i11);
                    int convert16 = DumpArchiveUtil.convert16(this.blockBuffer, i11 + 4);
                    byte[] bArr2 = this.blockBuffer;
                    byte b11 = bArr2[i11 + 6];
                    String a11 = DumpArchiveUtil.a(this.zipEncoding, bArr2, i11 + 8, bArr2[i11 + 7]);
                    if (!RealDiscoveryConfigurationRepository.VERSION_DELIMETER.equals(a11) && !"..".equals(a11)) {
                        this.names.put(Integer.valueOf(convert32), new Dirent(convert32, dumpArchiveEntry.getIno(), b11, a11));
                        for (Map.Entry next : this.pending.entrySet()) {
                            String path = getPath((DumpArchiveEntry) next.getValue());
                            if (path != null) {
                                ((DumpArchiveEntry) next.getValue()).setName(path);
                                ((DumpArchiveEntry) next.getValue()).setSimpleName(this.names.get(next.getKey()).b());
                                this.queue.add(next.getValue());
                            }
                        }
                        for (DumpArchiveEntry ino : this.queue) {
                            this.pending.remove(Integer.valueOf(ino.getIno()));
                        }
                    }
                    i11 += convert16;
                }
                byte[] peek = this.raw.peek();
                if (DumpArchiveUtil.verify(peek)) {
                    dumpArchiveEntry = DumpArchiveEntry.parse(peek);
                    entrySize2 -= 1024;
                    z11 = false;
                } else {
                    throw new InvalidFormatException();
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        if (!this.isClosed) {
            this.isClosed = true;
            this.raw.close();
        }
    }

    public long getBytesRead() {
        return this.raw.getBytesRead();
    }

    @Deprecated
    public int getCount() {
        return (int) getBytesRead();
    }

    public DumpArchiveEntry getNextDumpEntry() throws IOException {
        return getNextEntry();
    }

    public DumpArchiveSummary getSummary() {
        return this.summary;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i12 == 0) {
            return 0;
        }
        if (this.hasHitEOF || this.isClosed) {
            return -1;
        }
        long j11 = this.entryOffset;
        long j12 = this.entrySize;
        if (j11 >= j12) {
            return -1;
        }
        if (this.active != null) {
            if (((long) i12) + j11 > j12) {
                i12 = (int) (j12 - j11);
            }
            int i14 = 0;
            while (i12 > 0) {
                byte[] bArr2 = this.readBuf;
                int length = bArr2.length;
                int i15 = this.recordOffset;
                if (i12 > length - i15) {
                    i13 = bArr2.length - i15;
                } else {
                    i13 = i12;
                }
                if (i15 + i13 <= bArr2.length) {
                    System.arraycopy(bArr2, i15, bArr, i11, i13);
                    i14 += i13;
                    this.recordOffset += i13;
                    i12 -= i13;
                    i11 += i13;
                }
                if (i12 > 0) {
                    if (this.readIdx >= 512) {
                        byte[] readRecord = this.raw.readRecord();
                        if (DumpArchiveUtil.verify(readRecord)) {
                            this.active = DumpArchiveEntry.parse(readRecord);
                            this.readIdx = 0;
                        } else {
                            throw new InvalidFormatException();
                        }
                    }
                    DumpArchiveEntry dumpArchiveEntry = this.active;
                    int i16 = this.readIdx;
                    this.readIdx = i16 + 1;
                    if (!dumpArchiveEntry.isSparseRecord(i16)) {
                        TapeInputStream tapeInputStream = this.raw;
                        byte[] bArr3 = this.readBuf;
                        if (tapeInputStream.read(bArr3, 0, bArr3.length) != this.readBuf.length) {
                            throw new EOFException();
                        }
                    } else {
                        Arrays.fill(this.readBuf, (byte) 0);
                    }
                    this.recordOffset = 0;
                }
            }
            this.entryOffset += (long) i14;
            return i14;
        }
        throw new IllegalStateException("No current dump entry");
    }

    public DumpArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.readBuf = new byte[1024];
        HashMap hashMap = new HashMap();
        this.names = hashMap;
        this.pending = new HashMap();
        this.raw = new TapeInputStream(inputStream);
        this.hasHitEOF = false;
        this.encoding = str;
        ZipEncoding zipEncoding2 = ZipEncodingHelper.getZipEncoding(str);
        this.zipEncoding = zipEncoding2;
        try {
            byte[] readRecord = this.raw.readRecord();
            if (DumpArchiveUtil.verify(readRecord)) {
                DumpArchiveSummary dumpArchiveSummary = new DumpArchiveSummary(readRecord, zipEncoding2);
                this.summary = dumpArchiveSummary;
                this.raw.resetBlockSize(dumpArchiveSummary.getNTRec(), dumpArchiveSummary.isCompressed());
                this.blockBuffer = new byte[4096];
                readCLRI();
                readBITS();
                hashMap.put(2, new Dirent(2, 2, 4, RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
                this.queue = new PriorityQueue(10, new a());
                return;
            }
            throw new UnrecognizedFormatException();
        } catch (IOException e11) {
            throw new ArchiveException(e11.getMessage(), e11);
        }
    }

    public DumpArchiveEntry getNextEntry() throws IOException {
        if (!this.queue.isEmpty()) {
            return this.queue.remove();
        }
        DumpArchiveEntry dumpArchiveEntry = null;
        String str = null;
        while (dumpArchiveEntry == null) {
            if (this.hasHitEOF) {
                return null;
            }
            while (this.readIdx < this.active.getHeaderCount()) {
                DumpArchiveEntry dumpArchiveEntry2 = this.active;
                int i11 = this.readIdx;
                this.readIdx = i11 + 1;
                if (!dumpArchiveEntry2.isSparseRecord(i11) && this.raw.skip(1024) == -1) {
                    throw new EOFException();
                }
            }
            this.readIdx = 0;
            this.filepos = this.raw.getBytesRead();
            byte[] readRecord = this.raw.readRecord();
            if (DumpArchiveUtil.verify(readRecord)) {
                this.active = DumpArchiveEntry.parse(readRecord);
                while (DumpArchiveConstants.SEGMENT_TYPE.ADDR == this.active.getHeaderType()) {
                    if (this.raw.skip(((long) (this.active.getHeaderCount() - this.active.getHeaderHoles())) * 1024) != -1) {
                        this.filepos = this.raw.getBytesRead();
                        byte[] readRecord2 = this.raw.readRecord();
                        if (DumpArchiveUtil.verify(readRecord2)) {
                            this.active = DumpArchiveEntry.parse(readRecord2);
                        } else {
                            throw new InvalidFormatException();
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                if (DumpArchiveConstants.SEGMENT_TYPE.END == this.active.getHeaderType()) {
                    this.hasHitEOF = true;
                    return null;
                }
                DumpArchiveEntry dumpArchiveEntry3 = this.active;
                if (dumpArchiveEntry3.isDirectory()) {
                    readDirectoryEntry(this.active);
                    this.entryOffset = 0;
                    this.entrySize = 0;
                    this.readIdx = this.active.getHeaderCount();
                } else {
                    this.entryOffset = 0;
                    this.entrySize = this.active.getEntrySize();
                    this.readIdx = 0;
                }
                this.recordOffset = this.readBuf.length;
                String path = getPath(dumpArchiveEntry3);
                if (path == null) {
                    dumpArchiveEntry3 = null;
                }
                DumpArchiveEntry dumpArchiveEntry4 = dumpArchiveEntry3;
                str = path;
                dumpArchiveEntry = dumpArchiveEntry4;
            } else {
                throw new InvalidFormatException();
            }
        }
        dumpArchiveEntry.setName(str);
        dumpArchiveEntry.setSimpleName(this.names.get(Integer.valueOf(dumpArchiveEntry.getIno())).b());
        dumpArchiveEntry.setOffset(this.filepos);
        return dumpArchiveEntry;
    }
}
