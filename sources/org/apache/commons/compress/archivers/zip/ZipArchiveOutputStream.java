package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;

public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;
    @Deprecated
    public static final int EFS_FLAG = 2048;
    static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    private static final byte[] LZERO = {0, 0, 0, 0};
    private static final byte[] ONE = ZipLong.getBytes(1);
    public static final int STORED = 0;
    private static final byte[] ZERO = {0, 0};
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    private final Calendar calendarInstance;
    private long cdDiskNumberStart;
    private long cdLength;
    private long cdOffset;
    private final SeekableByteChannel channel;
    private String comment;
    private final byte[] copyBuffer;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipArchiveEntry> entries;
    private CurrentEntry entry;
    private long eocdLength;
    private boolean fallbackToUTF8;
    protected boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private final boolean isSplitZip;
    private int level;
    private final Map<ZipArchiveEntry, EntryMetaData> metaData;
    private int method;
    private final Map<Integer, Integer> numberOfCDInDiskData;
    private final OutputStream out;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;

    public static final class CurrentEntry {
        /* access modifiers changed from: private */
        public long bytesRead;
        /* access modifiers changed from: private */
        public boolean causedUseOfZip64;
        /* access modifiers changed from: private */
        public long dataStart;
        /* access modifiers changed from: private */
        public final ZipArchiveEntry entry;
        /* access modifiers changed from: private */
        public boolean hasWritten;
        /* access modifiers changed from: private */
        public long localDataStart;

        private CurrentEntry(ZipArchiveEntry zipArchiveEntry) {
            this.entry = zipArchiveEntry;
        }
    }

    public static final class EntryMetaData {
        /* access modifiers changed from: private */
        public final long offset;
        /* access modifiers changed from: private */
        public final boolean usesDataDescriptor;

        private EntryMetaData(long j11, boolean z11) {
            this.offset = j11;
            this.usesDataDescriptor = z11;
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");

        /* renamed from: name  reason: collision with root package name */
        private final String f27662name;

        private UnicodeExtraFieldPolicy(String str) {
            this.f27662name = str;
        }

        public String toString() {
            return this.f27662name;
        }
    }

    public ZipArchiveOutputStream(OutputStream outputStream) {
        this.comment = "";
        this.level = -1;
        this.method = 8;
        this.entries = new LinkedList();
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        this.out = outputStream;
        this.channel = null;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(outputStream, deflater);
        this.isSplitZip = false;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry zipArchiveEntry, boolean z11, ByteBuffer byteBuffer) throws IOException {
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy = this.createUnicodeExtraFields;
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy2 = UnicodeExtraFieldPolicy.ALWAYS;
        if (unicodeExtraFieldPolicy == unicodeExtraFieldPolicy2 || !z11) {
            zipArchiveEntry.addExtraField(new UnicodePathExtraField(zipArchiveEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment2 = zipArchiveEntry.getComment();
        if (comment2 != null && !"".equals(comment2)) {
            boolean canEncode = this.zipEncoding.canEncode(comment2);
            if (this.createUnicodeExtraFields == unicodeExtraFieldPolicy2 || !canEncode) {
                ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
                zipArchiveEntry.addExtraField(new UnicodeCommentExtraField(comment2, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
            }
        }
    }

    private boolean checkIfNeedsZip64(Zip64Mode zip64Mode2) throws ZipException {
        boolean isZip64Required = isZip64Required(this.entry.entry, zip64Mode2);
        if (!isZip64Required || zip64Mode2 != Zip64Mode.Never) {
            return isZip64Required;
        }
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
    }

    private void closeCopiedEntry(boolean z11) throws IOException {
        preClose();
        CurrentEntry currentEntry = this.entry;
        long unused = currentEntry.bytesRead = currentEntry.entry.getSize();
        closeEntry(checkIfNeedsZip64(getEffectiveZip64Mode(this.entry.entry)), z11);
    }

    private void closeEntry(boolean z11, boolean z12) throws IOException {
        if (!z12 && this.channel != null) {
            rewriteSizesAndCrc(z11);
        }
        if (!z12) {
            writeDataDescriptor(this.entry.entry);
        }
        this.entry = null;
    }

    private void copyFromZipInputStream(InputStream inputStream) throws IOException {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            boolean unused = this.entry.hasWritten = true;
            while (true) {
                int read = inputStream.read(this.copyBuffer);
                if (read >= 0) {
                    this.streamCompressor.writeCounted(this.copyBuffer, 0, read);
                    count(read);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("No current entry");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = r5.zip64Mode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] createCentralFileHeader(org.apache.commons.compress.archivers.zip.ZipArchiveEntry r6) throws java.io.IOException {
        /*
            r5 = this;
            java.util.Map<org.apache.commons.compress.archivers.zip.ZipArchiveEntry, org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream$EntryMetaData> r0 = r5.metaData
            java.lang.Object r0 = r0.get(r6)
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream$EntryMetaData r0 = (org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.EntryMetaData) r0
            boolean r1 = r5.hasZip64Extra(r6)
            if (r1 != 0) goto L_0x0043
            long r1 = r6.getCompressedSize()
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0043
            long r1 = r6.getSize()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0043
            long r1 = r0.offset
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0043
            long r1 = r6.getDiskNumberStart()
            r3 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0043
            org.apache.commons.compress.archivers.zip.Zip64Mode r1 = r5.zip64Mode
            org.apache.commons.compress.archivers.zip.Zip64Mode r2 = org.apache.commons.compress.archivers.zip.Zip64Mode.Always
            if (r1 == r2) goto L_0x0043
            org.apache.commons.compress.archivers.zip.Zip64Mode r2 = org.apache.commons.compress.archivers.zip.Zip64Mode.AlwaysWithCompatibility
            if (r1 != r2) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = 0
            goto L_0x0044
        L_0x0043:
            r1 = 1
        L_0x0044:
            if (r1 == 0) goto L_0x0055
            org.apache.commons.compress.archivers.zip.Zip64Mode r2 = r5.zip64Mode
            org.apache.commons.compress.archivers.zip.Zip64Mode r3 = org.apache.commons.compress.archivers.zip.Zip64Mode.Never
            if (r2 == r3) goto L_0x004d
            goto L_0x0055
        L_0x004d:
            org.apache.commons.compress.archivers.zip.Zip64RequiredException r6 = new org.apache.commons.compress.archivers.zip.Zip64RequiredException
            java.lang.String r0 = "Archive's size exceeds the limit of 4GByte."
            r6.<init>(r0)
            throw r6
        L_0x0055:
            long r2 = r0.offset
            r5.handleZip64Extra(r6, r2, r1)
            java.nio.ByteBuffer r2 = r5.getName(r6)
            byte[] r6 = r5.createCentralFileHeader(r6, r2, r0, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.createCentralFileHeader(org.apache.commons.compress.archivers.zip.ZipArchiveEntry):byte[]");
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, boolean z11, boolean z12, long j11) {
        ResourceAlignmentExtraField resourceAlignmentExtraField;
        boolean z13;
        ZipArchiveEntry zipArchiveEntry2 = zipArchiveEntry;
        boolean z14 = z12;
        ZipShort zipShort = ResourceAlignmentExtraField.ID;
        ZipExtraField extraField = zipArchiveEntry2.getExtraField(zipShort);
        if (extraField != null) {
            zipArchiveEntry2.removeExtraField(zipShort);
        }
        if (extraField instanceof ResourceAlignmentExtraField) {
            resourceAlignmentExtraField = (ResourceAlignmentExtraField) extraField;
        } else {
            resourceAlignmentExtraField = null;
        }
        int alignment = zipArchiveEntry.getAlignment();
        if (alignment <= 0 && resourceAlignmentExtraField != null) {
            alignment = resourceAlignmentExtraField.getAlignment();
        }
        boolean z15 = true;
        if (alignment > 1 || (resourceAlignmentExtraField != null && !resourceAlignmentExtraField.allowMethodChange())) {
            int limit = (int) (((((-j11) - ((long) (((byteBuffer.limit() + 30) - byteBuffer.position()) + zipArchiveEntry.getLocalFileDataExtra().length))) - 4) - 2) & ((long) (alignment - 1)));
            if (resourceAlignmentExtraField == null || !resourceAlignmentExtraField.allowMethodChange()) {
                z13 = false;
            } else {
                z13 = true;
            }
            zipArchiveEntry2.addExtraField(new ResourceAlignmentExtraField(alignment, z13, limit));
        }
        byte[] localFileDataExtra = zipArchiveEntry.getLocalFileDataExtra();
        int limit2 = byteBuffer.limit() - byteBuffer.position();
        int i11 = limit2 + 30;
        byte[] bArr = new byte[(localFileDataExtra.length + i11)];
        System.arraycopy(LFH_SIG, 0, bArr, 0, 4);
        int method2 = zipArchiveEntry.getMethod();
        boolean usesDataDescriptor = usesDataDescriptor(method2, z14);
        ZipShort.putShort(versionNeededToExtract(method2, hasZip64Extra(zipArchiveEntry), usesDataDescriptor), bArr, 4);
        if (z11 || !this.fallbackToUTF8) {
            z15 = false;
        }
        getGeneralPurposeBits(z15, usesDataDescriptor).encode(bArr, 6);
        ZipShort.putShort(method2, bArr, 8);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 10);
        if (z14 || (method2 != 8 && this.channel == null)) {
            ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 14);
        } else {
            System.arraycopy(LZERO, 0, bArr, 14, 4);
        }
        if (hasZip64Extra(this.entry.entry)) {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            zipLong.putLong(bArr, 18);
            zipLong.putLong(bArr, 22);
        } else if (z14) {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        } else if (method2 == 8 || this.channel != null) {
            byte[] bArr2 = LZERO;
            System.arraycopy(bArr2, 0, bArr, 18, 4);
            System.arraycopy(bArr2, 0, bArr, 22, 4);
        } else {
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        }
        ZipShort.putShort(limit2, bArr, 26);
        ZipShort.putShort(localFileDataExtra.length, bArr, 28);
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, limit2);
        System.arraycopy(localFileDataExtra, 0, bArr, i11, localFileDataExtra.length);
        return bArr;
    }

    private void flushDeflater() throws IOException {
        if (this.entry.entry.getMethod() == 8) {
            this.streamCompressor.flushDeflater();
        }
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry zipArchiveEntry) {
        if (this.zip64Mode == Zip64Mode.AsNeeded && this.channel == null && zipArchiveEntry.getMethod() == 8 && zipArchiveEntry.getSize() == -1) {
            return Zip64Mode.Never;
        }
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry zipArchiveEntry) {
        if (this.zipEncoding.canEncode(zipArchiveEntry.getName()) || !this.fallbackToUTF8) {
            return this.zipEncoding;
        }
        return ZipEncodingHelper.UTF8_ZIP_ENCODING;
    }

    private GeneralPurposeBit getGeneralPurposeBits(boolean z11, boolean z12) {
        boolean z13;
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        if (this.useUTF8Flag || z11) {
            z13 = true;
        } else {
            z13 = false;
        }
        generalPurposeBit.useUTF8ForNames(z13);
        if (z12) {
            generalPurposeBit.useDataDescriptor(true);
        }
        return generalPurposeBit;
    }

    private ByteBuffer getName(ZipArchiveEntry zipArchiveEntry) throws IOException {
        return getEntryEncoding(zipArchiveEntry).encode(zipArchiveEntry.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField;
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            boolean unused = currentEntry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        ZipExtraField extraField = zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (extraField instanceof Zip64ExtendedInformationExtraField) {
            zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) extraField;
        } else {
            zip64ExtendedInformationExtraField = null;
        }
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new Zip64ExtendedInformationExtraField();
        }
        zipArchiveEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    private boolean handleSizesAndCrc(long j11, long j12, Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 8) {
            this.entry.entry.setSize(this.entry.bytesRead);
            this.entry.entry.setCompressedSize(j11);
            this.entry.entry.setCrc(j12);
        } else if (this.channel != null) {
            this.entry.entry.setSize(j11);
            this.entry.entry.setCompressedSize(j11);
            this.entry.entry.setCrc(j12);
        } else if (this.entry.entry.getCrc() != j12) {
            throw new ZipException("Bad CRC checksum for entry " + this.entry.entry.getName() + ": " + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(j12));
        } else if (this.entry.entry.getSize() != j11) {
            throw new ZipException("Bad size for entry " + this.entry.entry.getName() + ": " + this.entry.entry.getSize() + " instead of " + j11);
        }
        return checkIfNeedsZip64(zip64Mode2);
    }

    private void handleZip64Extra(ZipArchiveEntry zipArchiveEntry, long j11, boolean z11) {
        boolean z12;
        Zip64Mode zip64Mode2;
        if (z11) {
            Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(zipArchiveEntry);
            if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || (zip64Mode2 = this.zip64Mode) == Zip64Mode.Always || zip64Mode2 == Zip64Mode.AlwaysWithCompatibility) {
                zip64Extra.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
                zip64Extra.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            } else {
                zip64Extra.setCompressedSize((ZipEightByteInteger) null);
                zip64Extra.setSize((ZipEightByteInteger) null);
            }
            boolean z13 = false;
            if (j11 >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (zipArchiveEntry.getDiskNumberStart() >= WebSocketProtocol.PAYLOAD_SHORT_MAX || this.zip64Mode == Zip64Mode.Always) {
                z13 = true;
            }
            if (z12 || z13) {
                zip64Extra.setRelativeHeaderOffset(new ZipEightByteInteger(j11));
            }
            if (z13) {
                zip64Extra.setDiskStartNumber(new ZipLong(zipArchiveEntry.getDiskNumberStart()));
            }
            zipArchiveEntry.setExtra();
        }
    }

    private boolean hasZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) instanceof Zip64ExtendedInformationExtraField;
    }

    private boolean isTooLargeForZip32(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L;
    }

    private boolean isZip64Required(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode2) {
        if (zip64Mode2 == Zip64Mode.Always || zip64Mode2 == Zip64Mode.AlwaysWithCompatibility || isTooLargeForZip32(zipArchiveEntry)) {
            return true;
        }
        return false;
    }

    private void preClose() throws IOException {
        if (!this.finished) {
            CurrentEntry currentEntry = this.entry;
            if (currentEntry == null) {
                throw new IOException("No current entry to close");
            } else if (!currentEntry.hasWritten) {
                write(ByteUtils.EMPTY_BYTE_ARRAY, 0, 0);
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    private void rewriteSizesAndCrc(boolean z11) throws IOException {
        long a11 = this.channel.position();
        SeekableByteChannel unused = this.channel.position(this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (!hasZip64Extra(this.entry.entry) || !z11) {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        } else {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            writeOut(zipLong.getBytes());
            writeOut(zipLong.getBytes());
        }
        if (hasZip64Extra(this.entry.entry)) {
            ByteBuffer name2 = getName(this.entry.entry);
            SeekableByteChannel unused2 = this.channel.position(this.entry.localDataStart + 12 + 4 + ((long) (name2.limit() - name2.position())) + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!z11) {
                SeekableByteChannel unused3 = this.channel.position(this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(versionNeededToExtract(this.entry.entry.getMethod(), false, false)));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        SeekableByteChannel unused4 = this.channel.position(a11);
    }

    private void setDefaults(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getMethod() == -1) {
            zipArchiveEntry.setMethod(this.method);
        }
        if (zipArchiveEntry.getTime() == -1) {
            zipArchiveEntry.setTime(System.currentTimeMillis());
        }
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode2) {
        if (zip64Mode2 == Zip64Mode.Always || zip64Mode2 == Zip64Mode.AlwaysWithCompatibility || zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L || (zipArchiveEntry.getSize() == -1 && this.channel != null && zip64Mode2 != Zip64Mode.Never)) {
            return true;
        }
        return false;
    }

    private boolean shouldUseZip64EOCD() {
        int i11;
        int i12;
        if (this.isSplitZip) {
            i11 = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
        } else {
            i11 = 0;
        }
        if (this.numberOfCDInDiskData.get(Integer.valueOf(i11)) == null) {
            i12 = 0;
        } else {
            i12 = this.numberOfCDInDiskData.get(Integer.valueOf(i11)).intValue();
        }
        if (i11 >= 65535 || this.cdDiskNumberStart >= WebSocketProtocol.PAYLOAD_SHORT_MAX || i12 >= 65535 || this.entries.size() >= 65535 || this.cdLength >= 4294967295L || this.cdOffset >= 4294967295L) {
            return true;
        }
        return false;
    }

    private boolean usesDataDescriptor(int i11, boolean z11) {
        return !z11 && i11 == 8 && this.channel == null;
    }

    private void validateIfZip64IsNeededInEOCD() throws Zip64RequiredException {
        int i11;
        if (this.zip64Mode == Zip64Mode.Never) {
            int i12 = 0;
            if (this.isSplitZip) {
                i11 = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
            } else {
                i11 = 0;
            }
            if (i11 >= 65535) {
                throw new Zip64RequiredException("Number of the disk of End Of Central Directory exceeds the limit of 65535.");
            } else if (this.cdDiskNumberStart < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (this.numberOfCDInDiskData.get(Integer.valueOf(i11)) != null) {
                    i12 = this.numberOfCDInDiskData.get(Integer.valueOf(i11)).intValue();
                }
                if (i12 >= 65535) {
                    throw new Zip64RequiredException("Number of entries on this disk exceeds the limit of 65535.");
                } else if (this.entries.size() >= 65535) {
                    throw new Zip64RequiredException("Archive contains more than 65535 entries.");
                } else if (this.cdLength >= 4294967295L) {
                    throw new Zip64RequiredException("The size of the entire central directory exceeds the limit of 4GByte.");
                } else if (this.cdOffset >= 4294967295L) {
                    throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
                }
            } else {
                throw new Zip64RequiredException("Number of the disk with the start of Central Directory exceeds the limit of 65535.");
            }
        }
    }

    private void validateSizeInformation(Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 0 && this.channel == null) {
            if (this.entry.entry.getSize() == -1) {
                throw new ZipException("Uncompressed size is required for STORED method when not writing to a file");
            } else if (this.entry.entry.getCrc() != -1) {
                this.entry.entry.setCompressedSize(this.entry.entry.getSize());
            } else {
                throw new ZipException("CRC checksum is required for STORED method when not writing to a file");
            }
        }
        if ((this.entry.entry.getSize() >= 4294967295L || this.entry.entry.getCompressedSize() >= 4294967295L) && zip64Mode2 == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private int versionNeededToExtract(int i11, boolean z11, boolean z12) {
        if (z11) {
            return 45;
        }
        if (z12) {
            return 20;
        }
        return versionNeededToExtractMethod(i11);
    }

    private int versionNeededToExtractMethod(int i11) {
        return i11 == 8 ? 20 : 10;
    }

    private void writeCentralDirectoryInChunks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        while (true) {
            int i11 = 0;
            for (ZipArchiveEntry createCentralFileHeader : this.entries) {
                byteArrayOutputStream.write(createCentralFileHeader(createCentralFileHeader));
                i11++;
                if (i11 > 1000) {
                    writeCounted(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                }
            }
            writeCounted(byteArrayOutputStream.toByteArray());
            return;
        }
    }

    private void writeCounted(byte[] bArr) throws IOException {
        this.streamCompressor.writeCounted(bArr);
    }

    public void addRawArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStream inputStream) throws IOException {
        boolean z11;
        ZipArchiveEntry zipArchiveEntry2 = new ZipArchiveEntry(zipArchiveEntry);
        if (hasZip64Extra(zipArchiveEntry2)) {
            zipArchiveEntry2.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        }
        if (zipArchiveEntry2.getCrc() == -1 || zipArchiveEntry2.getSize() == -1 || zipArchiveEntry2.getCompressedSize() == -1) {
            z11 = false;
        } else {
            z11 = true;
        }
        putArchiveEntry(zipArchiveEntry2, z11);
        copyFromZipInputStream(inputStream);
        closeCopiedEntry(z11);
    }

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        if (zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || !ZipUtil.canHandleEntryData(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            destroy();
        }
    }

    public void closeArchiveEntry() throws IOException {
        preClose();
        flushDeflater();
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten() - this.entry.dataStart;
        long crc32 = this.streamCompressor.getCrc32();
        long unused = this.entry.bytesRead = this.streamCompressor.getBytesRead();
        closeEntry(handleSizesAndCrc(totalBytesWritten, crc32, getEffectiveZip64Mode(this.entry.entry)), false);
        this.streamCompressor.reset();
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new ZipArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    public final void deflate() throws IOException {
        this.streamCompressor.deflate();
    }

    public void destroy() throws IOException {
        try {
            SeekableByteChannel seekableByteChannel = this.channel;
            if (seekableByteChannel != null) {
                seekableByteChannel.close();
            }
        } finally {
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (this.entry == null) {
            long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
            this.cdOffset = totalBytesWritten;
            if (this.isSplitZip) {
                ZipSplitOutputStream zipSplitOutputStream = (ZipSplitOutputStream) this.out;
                this.cdOffset = zipSplitOutputStream.getCurrentSplitSegmentBytesWritten();
                this.cdDiskNumberStart = (long) zipSplitOutputStream.getCurrentSplitSegmentIndex();
            }
            writeCentralDirectoryInChunks();
            this.cdLength = this.streamCompressor.getTotalBytesWritten() - totalBytesWritten;
            ByteBuffer encode = this.zipEncoding.encode(this.comment);
            this.eocdLength = (((long) encode.limit()) - ((long) encode.position())) + 22;
            writeZip64CentralDirectory();
            writeCentralDirectoryEnd();
            this.metaData.clear();
            this.entries.clear();
            this.streamCompressor.close();
            if (this.isSplitZip) {
                this.out.close();
            }
            this.finished = true;
        } else {
            throw new IOException("This archive contains unclosed entries.");
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        return this.channel != null;
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        putArchiveEntry(archiveEntry, false);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.createUnicodeExtraFields = unicodeExtraFieldPolicy;
    }

    public void setEncoding(String str) {
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(str)) {
            this.useUTF8Flag = false;
        }
    }

    public void setFallbackToUTF8(boolean z11) {
        this.fallbackToUTF8 = z11;
    }

    public void setLevel(int i11) {
        if (i11 < -1 || i11 > 9) {
            throw new IllegalArgumentException("Invalid compression level: " + i11);
        } else if (this.level != i11) {
            this.hasCompressionLevelChanged = true;
            this.level = i11;
        }
    }

    public void setMethod(int i11) {
        this.method = i11;
    }

    public void setUseLanguageEncodingFlag(boolean z11) {
        this.useUTF8Flag = z11 && ZipEncodingHelper.isUTF8(this.encoding);
    }

    public void setUseZip64(Zip64Mode zip64Mode2) {
        this.zip64Mode = zip64Mode2;
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            count(this.streamCompressor.write(bArr, i11, i12, this.entry.entry.getMethod()));
            return;
        }
        throw new IllegalStateException("No current entry");
    }

    public void writeCentralDirectoryEnd() throws IOException {
        int i11;
        if (!this.hasUsedZip64 && this.isSplitZip) {
            ((ZipSplitOutputStream) this.out).prepareToWriteUnsplittableContent(this.eocdLength);
        }
        validateIfZip64IsNeededInEOCD();
        writeCounted(EOCD_SIG);
        int i12 = 0;
        if (this.isSplitZip) {
            i11 = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
        } else {
            i11 = 0;
        }
        writeCounted(ZipShort.getBytes(i11));
        writeCounted(ZipShort.getBytes((int) this.cdDiskNumberStart));
        int size = this.entries.size();
        if (!this.isSplitZip) {
            i12 = size;
        } else if (this.numberOfCDInDiskData.get(Integer.valueOf(i11)) != null) {
            i12 = this.numberOfCDInDiskData.get(Integer.valueOf(i11)).intValue();
        }
        writeCounted(ZipShort.getBytes(Math.min(i12, 65535)));
        writeCounted(ZipShort.getBytes(Math.min(size, 65535)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer encode = this.zipEncoding.encode(this.comment);
        int limit = encode.limit() - encode.position();
        writeCounted(ZipShort.getBytes(limit));
        this.streamCompressor.writeCounted(encode.array(), encode.arrayOffset(), limit);
    }

    public void writeCentralFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        writeCounted(createCentralFileHeader(zipArchiveEntry));
    }

    public void writeDataDescriptor(ZipArchiveEntry zipArchiveEntry) throws IOException {
        if (usesDataDescriptor(zipArchiveEntry.getMethod(), false)) {
            writeCounted(DD_SIG);
            writeCounted(ZipLong.getBytes(zipArchiveEntry.getCrc()));
            if (!hasZip64Extra(zipArchiveEntry)) {
                writeCounted(ZipLong.getBytes(zipArchiveEntry.getCompressedSize()));
                writeCounted(ZipLong.getBytes(zipArchiveEntry.getSize()));
                return;
            }
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getCompressedSize()));
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getSize()));
        }
    }

    public void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        writeLocalFileHeader(zipArchiveEntry, false);
    }

    public final void writeOut(byte[] bArr) throws IOException {
        this.streamCompressor.writeOut(bArr, 0, bArr.length);
    }

    public void writePreamble(byte[] bArr) throws IOException {
        writePreamble(bArr, 0, bArr.length);
    }

    public void writeZip64CentralDirectory() throws IOException {
        long j11;
        int i11;
        if (this.zip64Mode != Zip64Mode.Never) {
            if (!this.hasUsedZip64 && shouldUseZip64EOCD()) {
                this.hasUsedZip64 = true;
            }
            if (this.hasUsedZip64) {
                long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
                if (this.isSplitZip) {
                    ZipSplitOutputStream zipSplitOutputStream = (ZipSplitOutputStream) this.out;
                    totalBytesWritten = zipSplitOutputStream.getCurrentSplitSegmentBytesWritten();
                    j11 = (long) zipSplitOutputStream.getCurrentSplitSegmentIndex();
                } else {
                    j11 = 0;
                }
                writeOut(ZIP64_EOCD_SIG);
                writeOut(ZipEightByteInteger.getBytes(44));
                writeOut(ZipShort.getBytes(45));
                writeOut(ZipShort.getBytes(45));
                int i12 = 0;
                if (this.isSplitZip) {
                    i11 = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
                } else {
                    i11 = 0;
                }
                writeOut(ZipLong.getBytes((long) i11));
                writeOut(ZipLong.getBytes(this.cdDiskNumberStart));
                if (!this.isSplitZip) {
                    i12 = this.entries.size();
                } else if (this.numberOfCDInDiskData.get(Integer.valueOf(i11)) != null) {
                    i12 = this.numberOfCDInDiskData.get(Integer.valueOf(i11)).intValue();
                }
                writeOut(ZipEightByteInteger.getBytes((long) i12));
                writeOut(ZipEightByteInteger.getBytes((long) this.entries.size()));
                writeOut(ZipEightByteInteger.getBytes(this.cdLength));
                writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
                if (this.isSplitZip) {
                    ((ZipSplitOutputStream) this.out).prepareToWriteUnsplittableContent(this.eocdLength + 20);
                }
                writeOut(ZIP64_EOCD_LOC_SIG);
                writeOut(ZipLong.getBytes(j11));
                writeOut(ZipEightByteInteger.getBytes(totalBytesWritten));
                if (this.isSplitZip) {
                    writeOut(ZipLong.getBytes((long) (((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex() + 1)));
                } else {
                    writeOut(ONE);
                }
            }
        }
    }

    private void putArchiveEntry(ArchiveEntry archiveEntry, boolean z11) throws IOException {
        ZipEightByteInteger zipEightByteInteger;
        ZipEightByteInteger zipEightByteInteger2;
        if (!this.finished) {
            if (this.entry != null) {
                closeArchiveEntry();
            }
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            CurrentEntry currentEntry = new CurrentEntry(zipArchiveEntry);
            this.entry = currentEntry;
            this.entries.add(currentEntry.entry);
            setDefaults(this.entry.entry);
            Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
            validateSizeInformation(effectiveZip64Mode);
            if (shouldAddZip64Extra(this.entry.entry, effectiveZip64Mode)) {
                Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(this.entry.entry);
                if (z11) {
                    zipEightByteInteger2 = new ZipEightByteInteger(this.entry.entry.getSize());
                    zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getCompressedSize());
                } else {
                    if (this.entry.entry.getMethod() != 0 || this.entry.entry.getSize() == -1) {
                        zipEightByteInteger2 = ZipEightByteInteger.ZERO;
                    } else {
                        zipEightByteInteger2 = new ZipEightByteInteger(this.entry.entry.getSize());
                    }
                    zipEightByteInteger = zipEightByteInteger2;
                }
                zip64Extra.setSize(zipEightByteInteger2);
                zip64Extra.setCompressedSize(zipEightByteInteger);
                this.entry.entry.setExtra();
            }
            if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
                this.def.setLevel(this.level);
                this.hasCompressionLevelChanged = false;
            }
            writeLocalFileHeader(zipArchiveEntry, z11);
            return;
        }
        throw new IOException("Stream has already been finished");
    }

    private void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry, boolean z11) throws IOException {
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ByteBuffer name2 = getName(zipArchiveEntry);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(zipArchiveEntry, canEncode, name2);
        }
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
        if (this.isSplitZip) {
            ZipSplitOutputStream zipSplitOutputStream = (ZipSplitOutputStream) this.out;
            zipArchiveEntry.setDiskNumberStart((long) zipSplitOutputStream.getCurrentSplitSegmentIndex());
            totalBytesWritten = zipSplitOutputStream.getCurrentSplitSegmentBytesWritten();
        }
        byte[] createLocalFileHeader = createLocalFileHeader(zipArchiveEntry, name2, canEncode, z11, totalBytesWritten);
        this.metaData.put(zipArchiveEntry, new EntryMetaData(totalBytesWritten, usesDataDescriptor(zipArchiveEntry.getMethod(), z11)));
        long unused = this.entry.localDataStart = totalBytesWritten + 14;
        writeCounted(createLocalFileHeader);
        long unused2 = this.entry.dataStart = this.streamCompressor.getTotalBytesWritten();
    }

    public final void writeOut(byte[] bArr, int i11, int i12) throws IOException {
        this.streamCompressor.writeOut(bArr, i11, i12);
    }

    public void writePreamble(byte[] bArr, int i11, int i12) throws IOException {
        if (this.entry == null) {
            this.streamCompressor.writeCounted(bArr, i11, i12);
            return;
        }
        throw new IllegalStateException("Preamble must be written before creating an entry");
    }

    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (!this.finished) {
            return new ZipArchiveEntry(path, str, new LinkOption[0]);
        }
        throw new IOException("Stream has already been finished");
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, EntryMetaData entryMetaData, boolean z11) throws IOException {
        Zip64Mode zip64Mode2;
        if (this.isSplitZip) {
            int currentSplitSegmentIndex = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
            if (this.numberOfCDInDiskData.get(Integer.valueOf(currentSplitSegmentIndex)) == null) {
                this.numberOfCDInDiskData.put(Integer.valueOf(currentSplitSegmentIndex), 1);
            } else {
                this.numberOfCDInDiskData.put(Integer.valueOf(currentSplitSegmentIndex), Integer.valueOf(this.numberOfCDInDiskData.get(Integer.valueOf(currentSplitSegmentIndex)).intValue() + 1));
            }
        }
        byte[] centralDirectoryExtra = zipArchiveEntry.getCentralDirectoryExtra();
        int length = centralDirectoryExtra.length;
        String comment2 = zipArchiveEntry.getComment();
        if (comment2 == null) {
            comment2 = "";
        }
        ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
        int limit = byteBuffer.limit() - byteBuffer.position();
        int limit2 = encode.limit() - encode.position();
        int i11 = limit + 46;
        int i12 = i11 + length;
        byte[] bArr = new byte[(i12 + limit2)];
        System.arraycopy(CFH_SIG, 0, bArr, 0, 4);
        ZipShort.putShort((zipArchiveEntry.getPlatform() << 8) | (!this.hasUsedZip64 ? 20 : 45), bArr, 4);
        int method2 = zipArchiveEntry.getMethod();
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ZipShort.putShort(versionNeededToExtract(method2, z11, entryMetaData.usesDataDescriptor), bArr, 6);
        getGeneralPurposeBits(!canEncode && this.fallbackToUTF8, entryMetaData.usesDataDescriptor).encode(bArr, 8);
        ZipShort.putShort(method2, bArr, 10);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 12);
        ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 16);
        byte[] bArr2 = centralDirectoryExtra;
        if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || (zip64Mode2 = this.zip64Mode) == Zip64Mode.Always || zip64Mode2 == Zip64Mode.AlwaysWithCompatibility) {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            zipLong.putLong(bArr, 20);
            zipLong.putLong(bArr, 24);
        } else {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 20);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 24);
        }
        ZipShort.putShort(limit, bArr, 28);
        ZipShort.putShort(length, bArr, 30);
        ZipShort.putShort(limit2, bArr, 32);
        if (!this.isSplitZip) {
            System.arraycopy(ZERO, 0, bArr, 34, 2);
        } else if (zipArchiveEntry.getDiskNumberStart() >= WebSocketProtocol.PAYLOAD_SHORT_MAX || this.zip64Mode == Zip64Mode.Always) {
            ZipShort.putShort(65535, bArr, 34);
        } else {
            ZipShort.putShort((int) zipArchiveEntry.getDiskNumberStart(), bArr, 34);
        }
        ZipShort.putShort(zipArchiveEntry.getInternalAttributes(), bArr, 36);
        ZipLong.putLong(zipArchiveEntry.getExternalAttributes(), bArr, 38);
        if (entryMetaData.offset >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
            ZipLong.putLong(4294967295L, bArr, 42);
        } else {
            ZipLong.putLong(Math.min(entryMetaData.offset, 4294967295L), bArr, 42);
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 46, limit);
        System.arraycopy(bArr2, 0, bArr, i11, length);
        System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i12, limit2);
        return bArr;
    }

    public ZipArchiveOutputStream(File file) throws IOException {
        this(file.toPath(), new OpenOption[0]);
    }

    public ZipArchiveOutputStream(Path path, OpenOption... openOptionArr) throws IOException {
        StreamCompressor streamCompressor2;
        SeekableByteChannel seekableByteChannel;
        this.comment = "";
        this.level = -1;
        this.method = 8;
        this.entries = new LinkedList();
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        OutputStream outputStream = null;
        try {
            seekableByteChannel = Files.newByteChannel(path, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]);
            try {
                streamCompressor2 = StreamCompressor.create(seekableByteChannel, deflater);
            } catch (IOException unused) {
                IOUtils.closeQuietly(seekableByteChannel);
                OutputStream a11 = Files.newOutputStream(path, openOptionArr);
                seekableByteChannel = null;
                outputStream = a11;
                streamCompressor2 = StreamCompressor.create(a11, this.def);
                this.out = outputStream;
                this.channel = seekableByteChannel;
                this.streamCompressor = streamCompressor2;
                this.isSplitZip = false;
            }
        } catch (IOException unused2) {
            seekableByteChannel = null;
            IOUtils.closeQuietly(seekableByteChannel);
            OutputStream a112 = Files.newOutputStream(path, openOptionArr);
            seekableByteChannel = null;
            outputStream = a112;
            streamCompressor2 = StreamCompressor.create(a112, this.def);
            this.out = outputStream;
            this.channel = seekableByteChannel;
            this.streamCompressor = streamCompressor2;
            this.isSplitZip = false;
        }
        this.out = outputStream;
        this.channel = seekableByteChannel;
        this.streamCompressor = streamCompressor2;
        this.isSplitZip = false;
    }

    public ZipArchiveOutputStream(File file, long j11) throws IOException {
        this.comment = "";
        this.level = -1;
        this.method = 8;
        this.entries = new LinkedList();
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        ZipSplitOutputStream zipSplitOutputStream = new ZipSplitOutputStream(file, j11);
        this.out = zipSplitOutputStream;
        this.streamCompressor = StreamCompressor.create((OutputStream) zipSplitOutputStream, deflater);
        this.channel = null;
        this.isSplitZip = true;
    }

    public ZipArchiveOutputStream(SeekableByteChannel seekableByteChannel) throws IOException {
        this.comment = "";
        this.level = -1;
        this.method = 8;
        this.entries = new LinkedList();
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        this.channel = seekableByteChannel;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(seekableByteChannel, deflater);
        this.out = null;
        this.isSplitZip = false;
    }
}
