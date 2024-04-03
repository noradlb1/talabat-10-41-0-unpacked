package org.apache.commons.compress.archivers.zip;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;
import org.apache.commons.compress.utils.ByteUtils;

public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry, EntryStreamOffsets {
    public static final int CRC_UNKNOWN = -1;
    static final ZipArchiveEntry[] EMPTY_ZIP_ARCHIVE_ENTRY_ARRAY = new ZipArchiveEntry[0];
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private int alignment;
    private CommentSource commentSource;
    private long dataOffset;
    private long diskNumberStart;
    private long externalAttributes;
    private ZipExtraField[] extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private boolean isStreamContiguous;
    private long localHeaderOffset;
    private int method;

    /* renamed from: name  reason: collision with root package name */
    private String f27656name;
    private NameSource nameSource;
    private int platform;
    private int rawFlag;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;
    private int versionMadeBy;
    private int versionRequired;

    public enum CommentSource {
        COMMENT,
        UNICODE_EXTRA_FIELD
    }

    public enum ExtraFieldParsingMode implements ExtraFieldParsingBehavior {
        BEST_EFFORT(r1) {
            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) {
                return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(zipExtraField, bArr, i11, i12, z11);
            }
        },
        STRICT_FOR_KNOW_EXTRA_FIELDS(r1),
        ONLY_PARSEABLE_LENIENT(r4) {
            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) {
                return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(zipExtraField, bArr, i11, i12, z11);
            }
        },
        ONLY_PARSEABLE_STRICT(r4),
        DRACONIC(ExtraFieldUtils.UnparseableExtraField.THROW);
        
        private final ExtraFieldUtils.UnparseableExtraField onUnparseableData;

        /* access modifiers changed from: private */
        public static ZipExtraField fillAndMakeUnrecognizedOnError(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) {
            try {
                return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i11, i12, z11);
            } catch (ZipException unused) {
                UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
                unrecognizedExtraField.setHeaderId(zipExtraField.getHeaderId());
                if (z11) {
                    unrecognizedExtraField.setLocalFileDataData(Arrays.copyOfRange(bArr, i11, i12 + i11));
                } else {
                    unrecognizedExtraField.setCentralDirectoryData(Arrays.copyOfRange(bArr, i11, i12 + i11));
                }
                return unrecognizedExtraField;
            }
        }

        public ZipExtraField createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException {
            return ExtraFieldUtils.createExtraField(zipShort);
        }

        public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) throws ZipException {
            return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i11, i12, z11);
        }

        public ZipExtraField onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException {
            return this.onUnparseableData.onUnparseableExtraField(bArr, i11, i12, z11, i13);
        }

        private ExtraFieldParsingMode(ExtraFieldUtils.UnparseableExtraField unparseableExtraField) {
            this.onUnparseableData = unparseableExtraField;
        }
    }

    public enum NameSource {
        NAME,
        NAME_WITH_EFS_FLAG,
        UNICODE_EXTRA_FIELD
    }

    public ZipArchiveEntry(String str) {
        super(str);
        this.method = -1;
        this.size = -1;
        this.platform = 0;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(str);
    }

    private ZipExtraField[] copyOf(ZipExtraField[] zipExtraFieldArr, int i11) {
        ZipExtraField[] zipExtraFieldArr2 = new ZipExtraField[i11];
        System.arraycopy(zipExtraFieldArr, 0, zipExtraFieldArr2, 0, Math.min(zipExtraFieldArr.length, i11));
        return zipExtraFieldArr2;
    }

    private ZipExtraField findMatching(ZipShort zipShort, List<ZipExtraField> list) {
        for (ZipExtraField next : list) {
            if (zipShort.equals(next.getHeaderId())) {
                return next;
            }
        }
        return null;
    }

    private ZipExtraField findUnparseable(List<ZipExtraField> list) {
        for (ZipExtraField next : list) {
            if (next instanceof UnparseableExtraFieldData) {
                return next;
            }
        }
        return null;
    }

    private ZipExtraField[] getAllExtraFields() {
        ZipExtraField[] allExtraFieldsNoCopy = getAllExtraFieldsNoCopy();
        if (allExtraFieldsNoCopy == this.extraFields) {
            return copyOf(allExtraFieldsNoCopy, allExtraFieldsNoCopy.length);
        }
        return allExtraFieldsNoCopy;
    }

    private ZipExtraField[] getAllExtraFieldsNoCopy() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        if (zipExtraFieldArr == null) {
            return getUnparseableOnly();
        }
        if (this.unparseableExtra != null) {
            return getMergedFields();
        }
        return zipExtraFieldArr;
    }

    private ZipExtraField[] getMergedFields() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        ZipExtraField[] copyOf = copyOf(zipExtraFieldArr, zipExtraFieldArr.length + 1);
        copyOf[this.extraFields.length] = this.unparseableExtra;
        return copyOf;
    }

    private ZipExtraField[] getParseableExtraFields() {
        ZipExtraField[] parseableExtraFieldsNoCopy = getParseableExtraFieldsNoCopy();
        if (parseableExtraFieldsNoCopy == this.extraFields) {
            return copyOf(parseableExtraFieldsNoCopy, parseableExtraFieldsNoCopy.length);
        }
        return parseableExtraFieldsNoCopy;
    }

    private ZipExtraField[] getParseableExtraFieldsNoCopy() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        if (zipExtraFieldArr == null) {
            return ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY;
        }
        return zipExtraFieldArr;
    }

    private ZipExtraField[] getUnparseableOnly() {
        UnparseableExtraFieldData unparseableExtraFieldData = this.unparseableExtra;
        if (unparseableExtraFieldData == null) {
            return ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY;
        }
        return new ZipExtraField[]{unparseableExtraFieldData};
    }

    private void mergeExtraFields(ZipExtraField[] zipExtraFieldArr, boolean z11) {
        ZipExtraField zipExtraField;
        byte[] bArr;
        if (this.extraFields == null) {
            setExtraFields(zipExtraFieldArr);
            return;
        }
        for (ZipExtraField zipExtraField2 : zipExtraFieldArr) {
            if (zipExtraField2 instanceof UnparseableExtraFieldData) {
                zipExtraField = this.unparseableExtra;
            } else {
                zipExtraField = getExtraField(zipExtraField2.getHeaderId());
            }
            if (zipExtraField == null) {
                addExtraField(zipExtraField2);
            } else {
                if (z11) {
                    bArr = zipExtraField2.getLocalFileDataData();
                } else {
                    bArr = zipExtraField2.getCentralDirectoryData();
                }
                if (z11) {
                    try {
                        zipExtraField.parseFromLocalFileData(bArr, 0, bArr.length);
                    } catch (ZipException unused) {
                        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
                        unrecognizedExtraField.setHeaderId(zipExtraField.getHeaderId());
                        if (z11) {
                            unrecognizedExtraField.setLocalFileDataData(bArr);
                            unrecognizedExtraField.setCentralDirectoryData(zipExtraField.getCentralDirectoryData());
                        } else {
                            unrecognizedExtraField.setLocalFileDataData(zipExtraField.getLocalFileDataData());
                            unrecognizedExtraField.setCentralDirectoryData(bArr);
                        }
                        removeExtraField(zipExtraField.getHeaderId());
                        addExtraField(unrecognizedExtraField);
                    }
                } else {
                    zipExtraField.parseFromCentralDirectoryData(bArr, 0, bArr.length);
                }
            }
        }
        setExtra();
    }

    public void addAsFirstExtraField(ZipExtraField zipExtraField) {
        int i11;
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            ZipExtraField[] zipExtraFieldArr = this.extraFields;
            if (zipExtraFieldArr != null) {
                i11 = zipExtraFieldArr.length + 1;
            } else {
                i11 = 1;
            }
            ZipExtraField[] zipExtraFieldArr2 = new ZipExtraField[i11];
            this.extraFields = zipExtraFieldArr2;
            zipExtraFieldArr2[0] = zipExtraField;
            if (zipExtraFieldArr != null) {
                System.arraycopy(zipExtraFieldArr, 0, zipExtraFieldArr2, 1, zipExtraFieldArr2.length - 1);
            }
        }
        setExtra();
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else if (this.extraFields == null) {
            this.extraFields = new ZipExtraField[]{zipExtraField};
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            ZipExtraField[] zipExtraFieldArr = this.extraFields;
            ZipExtraField[] copyOf = copyOf(zipExtraFieldArr, zipExtraFieldArr.length + 1);
            copyOf[copyOf.length - 1] = zipExtraField;
            this.extraFields = copyOf;
        }
        setExtra();
    }

    public Object clone() {
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) super.clone();
        zipArchiveEntry.setInternalAttributes(getInternalAttributes());
        zipArchiveEntry.setExternalAttributes(getExternalAttributes());
        zipArchiveEntry.setExtraFields(getAllExtraFieldsNoCopy());
        return zipArchiveEntry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) obj;
        if (!Objects.equals(getName(), zipArchiveEntry.getName())) {
            return false;
        }
        String comment = getComment();
        String comment2 = zipArchiveEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        if (getTime() == zipArchiveEntry.getTime() && comment.equals(comment2) && getInternalAttributes() == zipArchiveEntry.getInternalAttributes() && getPlatform() == zipArchiveEntry.getPlatform() && getExternalAttributes() == zipArchiveEntry.getExternalAttributes() && getMethod() == zipArchiveEntry.getMethod() && getSize() == zipArchiveEntry.getSize() && getCrc() == zipArchiveEntry.getCrc() && getCompressedSize() == zipArchiveEntry.getCompressedSize() && Arrays.equals(getCentralDirectoryExtra(), zipArchiveEntry.getCentralDirectoryExtra()) && Arrays.equals(getLocalFileDataExtra(), zipArchiveEntry.getLocalFileDataExtra()) && this.localHeaderOffset == zipArchiveEntry.localHeaderOffset && this.dataOffset == zipArchiveEntry.dataOffset && this.gpb.equals(zipArchiveEntry.gpb)) {
            return true;
        }
        return false;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getAllExtraFieldsNoCopy());
    }

    public CommentSource getCommentSource() {
        return this.commentSource;
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public long getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField getExtraField(ZipShort zipShort) {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        if (zipExtraFieldArr == null) {
            return null;
        }
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipShort.equals(zipExtraField.getHeaderId())) {
                return zipExtraField;
            }
        }
        return null;
    }

    public ZipExtraField[] getExtraFields() {
        return getParseableExtraFields();
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        if (extra != null) {
            return extra;
        }
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    public int getMethod() {
        return this.method;
    }

    public String getName() {
        String str = this.f27656name;
        return str == null ? super.getName() : str;
    }

    public NameSource getNameSource() {
        return this.nameSource;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getRawFlag() {
        return this.rawFlag;
    }

    public byte[] getRawName() {
        byte[] bArr = this.rawName;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public long getSize() {
        return this.size;
    }

    public int getUnixMode() {
        if (this.platform != 3) {
            return 0;
        }
        return (int) ((getExternalAttributes() >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getVersionRequired() {
        return this.versionRequired;
    }

    public int hashCode() {
        String name2 = getName();
        if (name2 == null) {
            name2 = "";
        }
        return name2.hashCode();
    }

    public boolean isDirectory() {
        String name2 = getName();
        if (name2 == null || !name2.endsWith("/")) {
            return false;
        }
        return true;
    }

    public boolean isStreamContiguous() {
        return this.isStreamContiguous;
    }

    public boolean isUnixSymlink() {
        return (getUnixMode() & 61440) == 40960;
    }

    public void removeExtraField(ZipShort zipShort) {
        if (this.extraFields != null) {
            ArrayList arrayList = new ArrayList();
            for (ZipExtraField zipExtraField : this.extraFields) {
                if (!zipShort.equals(zipExtraField.getHeaderId())) {
                    arrayList.add(zipExtraField);
                }
            }
            if (this.extraFields.length != arrayList.size()) {
                this.extraFields = (ZipExtraField[]) arrayList.toArray(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY);
                setExtra();
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra != null) {
            this.unparseableExtra = null;
            setExtra();
            return;
        }
        throw new NoSuchElementException();
    }

    public void setAlignment(int i11) {
        if (((i11 - 1) & i11) != 0 || i11 > 65535) {
            throw new IllegalArgumentException("Invalid value for alignment, must be power of two and no bigger than 65535 but is " + i11);
        }
        this.alignment = i11;
    }

    public void setCentralDirectoryExtra(byte[] bArr) {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, false, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT), false);
        } catch (ZipException e11) {
            throw new RuntimeException(e11.getMessage(), e11);
        }
    }

    public void setCommentSource(CommentSource commentSource2) {
        this.commentSource = commentSource2;
    }

    public void setDataOffset(long j11) {
        this.dataOffset = j11;
    }

    public void setDiskNumberStart(long j11) {
        this.diskNumberStart = j11;
    }

    public void setExternalAttributes(long j11) {
        this.externalAttributes = j11;
    }

    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, true, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT), true);
        } catch (ZipException e11) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e11.getMessage(), e11);
        }
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArr) {
        this.unparseableExtra = null;
        ArrayList arrayList = new ArrayList();
        if (zipExtraFieldArr != null) {
            for (UnparseableExtraFieldData unparseableExtraFieldData : zipExtraFieldArr) {
                if (unparseableExtraFieldData instanceof UnparseableExtraFieldData) {
                    this.unparseableExtra = unparseableExtraFieldData;
                } else {
                    arrayList.add(unparseableExtraFieldData);
                }
            }
        }
        this.extraFields = (ZipExtraField[]) arrayList.toArray(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY);
        setExtra();
    }

    public void setGeneralPurposeBit(GeneralPurposeBit generalPurposeBit) {
        this.gpb = generalPurposeBit;
    }

    public void setInternalAttributes(int i11) {
        this.internalAttributes = i11;
    }

    public void setLocalHeaderOffset(long j11) {
        this.localHeaderOffset = j11;
    }

    public void setMethod(int i11) {
        if (i11 >= 0) {
            this.method = i11;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + i11);
    }

    public void setName(String str) {
        if (str != null && getPlatform() == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.f27656name = str;
    }

    public void setNameSource(NameSource nameSource2) {
        this.nameSource = nameSource2;
    }

    public void setPlatform(int i11) {
        this.platform = i11;
    }

    public void setRawFlag(int i11) {
        this.rawFlag = i11;
    }

    public void setSize(long j11) {
        if (j11 >= 0) {
            this.size = j11;
            return;
        }
        throw new IllegalArgumentException("Invalid entry size");
    }

    public void setStreamContiguous(boolean z11) {
        this.isStreamContiguous = z11;
    }

    public void setTime(FileTime fileTime) {
        setTime(fileTime.toMillis());
    }

    public void setUnixMode(int i11) {
        int i12;
        int i13 = i11 << 16;
        int i14 = 0;
        if ((i11 & 128) == 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        int i15 = i12 | i13;
        if (isDirectory()) {
            i14 = 16;
        }
        setExternalAttributes((long) (i15 | i14));
        this.platform = 3;
    }

    public void setVersionMadeBy(int i11) {
        this.versionMadeBy = i11;
    }

    public void setVersionRequired(int i11) {
        this.versionRequired = i11;
    }

    public ZipExtraField[] getExtraFields(boolean z11) {
        if (z11) {
            return getAllExtraFields();
        }
        return getParseableExtraFields();
    }

    public ZipExtraField[] getExtraFields(ExtraFieldParsingBehavior extraFieldParsingBehavior) throws ZipException {
        ZipExtraField zipExtraField;
        if (extraFieldParsingBehavior == ExtraFieldParsingMode.BEST_EFFORT) {
            return getExtraFields(true);
        }
        if (extraFieldParsingBehavior == ExtraFieldParsingMode.ONLY_PARSEABLE_LENIENT) {
            return getExtraFields(false);
        }
        ArrayList<ZipExtraField> arrayList = new ArrayList<>(Arrays.asList(ExtraFieldUtils.parse(getExtra(), true, extraFieldParsingBehavior)));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(ExtraFieldUtils.parse(getCentralDirectoryExtra(), false, extraFieldParsingBehavior)));
        ArrayList arrayList3 = new ArrayList();
        for (ZipExtraField zipExtraField2 : arrayList) {
            if (zipExtraField2 instanceof UnparseableExtraFieldData) {
                zipExtraField = findUnparseable(arrayList2);
            } else {
                zipExtraField = findMatching(zipExtraField2.getHeaderId(), arrayList2);
            }
            if (zipExtraField != null) {
                byte[] centralDirectoryData = zipExtraField.getCentralDirectoryData();
                if (centralDirectoryData != null && centralDirectoryData.length > 0) {
                    zipExtraField2.parseFromCentralDirectoryData(centralDirectoryData, 0, centralDirectoryData.length);
                }
                arrayList2.remove(zipExtraField);
            }
            arrayList3.add(zipExtraField2);
        }
        arrayList3.addAll(arrayList2);
        return (ZipExtraField[]) arrayList3.toArray(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY);
    }

    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getAllExtraFieldsNoCopy()));
    }

    public void setName(String str, byte[] bArr) {
        setName(str);
        this.rawName = bArr;
    }

    public ZipArchiveEntry(ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
        this.method = -1;
        this.size = -1;
        this.platform = 0;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(ExtraFieldUtils.parse(extra, true, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT));
        } else {
            setExtra();
        }
        setMethod(zipEntry.getMethod());
        this.size = zipEntry.getSize();
    }

    public ZipArchiveEntry(ZipArchiveEntry zipArchiveEntry) throws ZipException {
        this((ZipEntry) zipArchiveEntry);
        GeneralPurposeBit generalPurposeBit;
        setInternalAttributes(zipArchiveEntry.getInternalAttributes());
        setExternalAttributes(zipArchiveEntry.getExternalAttributes());
        setExtraFields(getAllExtraFieldsNoCopy());
        setPlatform(zipArchiveEntry.getPlatform());
        GeneralPurposeBit generalPurposeBit2 = zipArchiveEntry.getGeneralPurposeBit();
        if (generalPurposeBit2 == null) {
            generalPurposeBit = null;
        } else {
            generalPurposeBit = (GeneralPurposeBit) generalPurposeBit2.clone();
        }
        setGeneralPurposeBit(generalPurposeBit);
    }

    public ZipArchiveEntry() {
        this("");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ZipArchiveEntry(java.io.File r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = "/"
            boolean r1 = r4.endsWith(r0)
            if (r1 != 0) goto L_0x001d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
        L_0x001d:
            r2.<init>((java.lang.String) r4)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x002d
            long r0 = r3.length()
            r2.setSize(r0)
        L_0x002d:
            long r3 = r3.lastModified()
            r2.setTime(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.<init>(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ZipArchiveEntry(java.nio.file.Path r3, java.lang.String r4, java.nio.file.LinkOption... r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = java.nio.file.Files.isDirectory(r3, r5)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = "/"
            boolean r1 = r4.endsWith(r0)
            if (r1 != 0) goto L_0x001d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
        L_0x001d:
            r2.<init>((java.lang.String) r4)
            boolean r4 = java.nio.file.Files.isRegularFile(r3, r5)
            if (r4 == 0) goto L_0x002d
            long r0 = java.nio.file.Files.size(r3)
            r2.setSize(r0)
        L_0x002d:
            java.nio.file.attribute.FileTime r3 = java.nio.file.Files.getLastModifiedTime(r3, r5)
            r2.setTime(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.<init>(java.nio.file.Path, java.lang.String, java.nio.file.LinkOption[]):void");
    }
}
