package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    private int currentSparseInputStreamIndex;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private final List<TarArchiveStructSparse> globalSparseHeaders;
    private boolean hasHitEOF;
    private final InputStream inputStream;
    private final boolean lenient;
    private final byte[] recordBuffer;
    private final int recordSize;
    private final byte[] smallBuf;
    private List<InputStream> sparseInputStreams;
    private final ZipEncoding zipEncoding;

    public TarArchiveInputStream(InputStream inputStream2) {
        this(inputStream2, 10240, 512);
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map, List<TarArchiveStructSparse> list) throws IOException {
        this.currEntry.updateEntryFromPaxHeaders(map);
        this.currEntry.setSparseHeaders(list);
    }

    private void buildSparseInputStreams() throws IOException {
        this.currentSparseInputStreamIndex = -1;
        this.sparseInputStreams = new ArrayList();
        List<TarArchiveStructSparse> orderedSparseHeaders = this.currEntry.getOrderedSparseHeaders();
        TarArchiveSparseZeroInputStream tarArchiveSparseZeroInputStream = new TarArchiveSparseZeroInputStream();
        long j11 = 0;
        for (TarArchiveStructSparse next : orderedSparseHeaders) {
            int i11 = ((next.getOffset() - j11) > 0 ? 1 : ((next.getOffset() - j11) == 0 ? 0 : -1));
            if (i11 >= 0) {
                if (i11 > 0) {
                    this.sparseInputStreams.add(new BoundedInputStream(tarArchiveSparseZeroInputStream, next.getOffset() - j11));
                }
                if (next.getNumbytes() > 0) {
                    this.sparseInputStreams.add(new BoundedInputStream(this.inputStream, next.getNumbytes()));
                }
                j11 = next.getOffset() + next.getNumbytes();
            } else {
                throw new IOException("Corrupted struct sparse detected");
            }
        }
        if (!this.sparseInputStreams.isEmpty()) {
            this.currentSparseInputStreamIndex = 0;
        }
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i11 = this.blockSize;
        long j11 = bytesRead % ((long) i11);
        if (j11 > 0) {
            count(IOUtils.skip(this.inputStream, ((long) i11) - j11));
        }
    }

    private long getActuallySkipped(long j11, long j12, long j13) throws IOException {
        if (this.inputStream instanceof FileInputStream) {
            j12 = Math.min(j12, j11);
        }
        if (j12 == j13) {
            return j12;
        }
        throw new IOException("Truncated TAR archive");
    }

    private byte[] getRecord() throws IOException {
        byte[] readRecord = readRecord();
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

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, bArr, TarConstants.VERSION_OFFSET, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, bArr, TarConstants.VERSION_OFFSET, 2))) {
            return true;
        }
        if (!ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) || !ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return false;
        }
        return true;
    }

    private void paxHeaders() throws IOException {
        ArrayList arrayList = new ArrayList();
        Map<String, String> parsePaxHeaders = TarUtils.parsePaxHeaders(this, arrayList, this.globalPaxHeaders, this.entrySize);
        if (parsePaxHeaders.containsKey("GNU.sparse.map")) {
            arrayList = new ArrayList(TarUtils.parseFromPAX01SparseHeaders(parsePaxHeaders.get("GNU.sparse.map")));
        }
        getNextEntry();
        if (this.currEntry != null) {
            applyPaxHeadersToCurrentEntry(parsePaxHeaders, arrayList);
            if (this.currEntry.isPaxGNU1XSparse()) {
                this.currEntry.setSparseHeaders(TarUtils.parsePAX1XSparseHeaders(this.inputStream, this.recordSize));
            }
            buildSparseInputStreams();
            return;
        }
        throw new IOException("premature end of tar archive. Didn't find any entry after PAX header.");
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = TarUtils.parsePaxHeaders(this, this.globalSparseHeaders, this.globalPaxHeaders, this.entrySize);
        getNextEntry();
        if (this.currEntry == null) {
            throw new IOException("Error detected parsing the pax header");
        }
    }

    private void readOldGNUSparse() throws IOException {
        TarArchiveSparseEntry tarArchiveSparseEntry;
        if (this.currEntry.isExtended()) {
            do {
                byte[] record = getRecord();
                if (record != null) {
                    tarArchiveSparseEntry = new TarArchiveSparseEntry(record);
                    this.currEntry.getSparseHeaders().addAll(tarArchiveSparseEntry.getSparseHeaders());
                } else {
                    throw new IOException("premature end of tar archive. Didn't find extended_header after header with extended flag.");
                }
            } while (tarArchiveSparseEntry.isExtended());
        }
        buildSparseInputStreams();
    }

    private int readSparse(byte[] bArr, int i11, int i12) throws IOException {
        List<InputStream> list = this.sparseInputStreams;
        if (list == null || list.isEmpty()) {
            return this.inputStream.read(bArr, i11, i12);
        }
        if (this.currentSparseInputStreamIndex >= this.sparseInputStreams.size()) {
            return -1;
        }
        int read = this.sparseInputStreams.get(this.currentSparseInputStreamIndex).read(bArr, i11, i12);
        if (this.currentSparseInputStreamIndex == this.sparseInputStreams.size() - 1) {
            return read;
        }
        if (read == -1) {
            this.currentSparseInputStreamIndex++;
            return readSparse(bArr, i11, i12);
        } else if (read >= i12) {
            return read;
        } else {
            this.currentSparseInputStreamIndex++;
            int readSparse = readSparse(bArr, i11 + read, i12 - read);
            if (readSparse == -1) {
                return read;
            }
            return read + readSparse;
        }
    }

    private void skipRecordPadding() throws IOException {
        if (!isDirectory()) {
            long j11 = this.entrySize;
            if (j11 > 0 && j11 % ((long) this.recordSize) != 0) {
                long available = (long) this.inputStream.available();
                long j12 = this.entrySize;
                int i11 = this.recordSize;
                long j13 = (((j12 / ((long) i11)) + 1) * ((long) i11)) - j12;
                count(getActuallySkipped(available, IOUtils.skip(this.inputStream, j13), j13));
            }
        }
    }

    private long skipSparse(long j11) throws IOException {
        List<InputStream> list = this.sparseInputStreams;
        if (list == null || list.isEmpty()) {
            return this.inputStream.skip(j11);
        }
        long j12 = 0;
        while (j12 < j11 && this.currentSparseInputStreamIndex < this.sparseInputStreams.size()) {
            j12 += this.sparseInputStreams.get(this.currentSparseInputStreamIndex).skip(j11 - j12);
            if (j12 < j11) {
                this.currentSparseInputStreamIndex++;
            }
        }
        return j12;
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean markSupported = this.inputStream.markSupported();
        if (markSupported) {
            this.inputStream.mark(this.recordSize);
        }
        try {
            if ((!isEOFRecord(readRecord())) && markSupported) {
            }
        } finally {
            if (markSupported) {
                pushedBackBytes((long) this.recordSize);
                this.inputStream.reset();
            }
        }
    }

    public int available() throws IOException {
        if (isDirectory()) {
            return 0;
        }
        if (this.currEntry.getRealSize() - this.entryOffset > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (this.currEntry.getRealSize() - this.entryOffset);
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return archiveEntry instanceof TarArchiveEntry;
    }

    public void close() throws IOException {
        List<InputStream> list = this.sparseInputStreams;
        if (list != null) {
            for (InputStream close : list) {
                close.close();
            }
        }
        this.inputStream.close();
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    public byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = read(this.smallBuf);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.smallBuf, 0, read);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, Long.MAX_VALUE);
            skipRecordPadding();
        }
        byte[] record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(record, this.zipEncoding, this.lenient);
            this.currEntry = tarArchiveEntry;
            this.entryOffset = 0;
            this.entrySize = tarArchiveEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
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
                    TarArchiveEntry tarArchiveEntry2 = this.currEntry;
                    tarArchiveEntry2.setName(decode + "/");
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
                this.entrySize = this.currEntry.getSize();
                return this.currEntry;
            } catch (NumberFormatException e11) {
                throw new IOException("Error detected parsing the pax header", e11);
            }
        } catch (IllegalArgumentException e12) {
            throw new IOException("Error detected parsing the header", e12);
        }
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    public boolean isEOFRecord(byte[] bArr) {
        return bArr == null || ArchiveUtils.isArrayZero(bArr, this.recordSize);
    }

    public synchronized void mark(int i11) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i12 == 0) {
            return 0;
        }
        if (isAtEOF() || isDirectory()) {
            return -1;
        }
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        if (tarArchiveEntry == null) {
            throw new IllegalStateException("No current tar entry");
        } else if (this.entryOffset >= tarArchiveEntry.getRealSize()) {
            return -1;
        } else {
            int min = Math.min(i12, available());
            if (this.currEntry.isSparse()) {
                i13 = readSparse(bArr, i11, min);
            } else {
                i13 = this.inputStream.read(bArr, i11, min);
            }
            if (i13 != -1) {
                count(i13);
                this.entryOffset += (long) i13;
            } else if (min <= 0) {
                setAtEOF(true);
            } else {
                throw new IOException("Truncated TAR archive");
            }
            return i13;
        }
    }

    public byte[] readRecord() throws IOException {
        int readFully = IOUtils.readFully(this.inputStream, this.recordBuffer);
        count(readFully);
        if (readFully != this.recordSize) {
            return null;
        }
        return this.recordBuffer;
    }

    public synchronized void reset() {
    }

    public final void setAtEOF(boolean z11) {
        this.hasHitEOF = z11;
    }

    public final void setCurrentEntry(TarArchiveEntry tarArchiveEntry) {
        this.currEntry = tarArchiveEntry;
    }

    public long skip(long j11) throws IOException {
        long j12;
        if (j11 <= 0 || isDirectory()) {
            return 0;
        }
        long available = (long) this.inputStream.available();
        long min = Math.min(j11, this.currEntry.getRealSize() - this.entryOffset);
        if (!this.currEntry.isSparse()) {
            j12 = getActuallySkipped(available, IOUtils.skip(this.inputStream, min), min);
        } else {
            j12 = skipSparse(min);
        }
        count(j12);
        this.entryOffset += j12;
        return j12;
    }

    public TarArchiveInputStream(InputStream inputStream2, boolean z11) {
        this(inputStream2, 10240, 512, (String) null, z11);
    }

    public TarArchiveInputStream(InputStream inputStream2, String str) {
        this(inputStream2, 10240, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream2, int i11) {
        this(inputStream2, i11, 512);
    }

    public TarArchiveInputStream(InputStream inputStream2, int i11, String str) {
        this(inputStream2, i11, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream2, int i11, int i12) {
        this(inputStream2, i11, i12, (String) null);
    }

    public TarArchiveInputStream(InputStream inputStream2, int i11, int i12, String str) {
        this(inputStream2, i11, i12, str, false);
    }

    public TarArchiveInputStream(InputStream inputStream2, int i11, int i12, String str, boolean z11) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.globalSparseHeaders = new ArrayList();
        this.inputStream = inputStream2;
        this.hasHitEOF = false;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i12;
        this.recordBuffer = new byte[i12];
        this.blockSize = i11;
        this.lenient = z11;
    }
}
