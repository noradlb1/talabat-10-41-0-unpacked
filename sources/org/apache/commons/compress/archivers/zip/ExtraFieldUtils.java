package org.apache.commons.compress.archivers.zip;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.zip.ZipException;

public class ExtraFieldUtils {
    static final ZipExtraField[] EMPTY_ZIP_EXTRA_FIELD_ARRAY = new ZipExtraField[0];
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    public static final class UnparseableExtraField implements UnparseableExtraFieldBehavior {
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);
        public static final int READ_KEY = 2;
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final int SKIP_KEY = 1;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final int THROW_KEY = 0;
        private final int key;

        private UnparseableExtraField(int i11) {
            this.key = i11;
        }

        public int getKey() {
            return this.key;
        }

        public ZipExtraField onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException {
            int i14 = this.key;
            if (i14 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bad extra field starting at ");
                sb2.append(i11);
                sb2.append(".  Block length of ");
                sb2.append(i13);
                sb2.append(" bytes exceeds remaining data of ");
                sb2.append(i12 - 4);
                sb2.append(" bytes.");
                throw new ZipException(sb2.toString());
            } else if (i14 == 1) {
                return null;
            } else {
                if (i14 == 2) {
                    UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
                    if (z11) {
                        unparseableExtraFieldData.parseFromLocalFileData(bArr, i11, i12);
                    } else {
                        unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i11, i12);
                    }
                    return unparseableExtraFieldData;
                }
                throw new ZipException("Unknown UnparseableExtraField key: " + this.key);
            }
        }
    }

    static {
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
        register(ResourceAlignmentExtraField.class);
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        ZipExtraField createExtraFieldNoDefault = createExtraFieldNoDefault(zipShort);
        if (createExtraFieldNoDefault != null) {
            return createExtraFieldNoDefault;
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static ZipExtraField createExtraFieldNoDefault(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        return null;
    }

    public static ZipExtraField fillExtraField(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) throws ZipException {
        if (z11) {
            try {
                zipExtraField.parseFromLocalFileData(bArr, i11, i12);
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(zipExtraField.getHeaderId().getValue())).initCause(e11));
            }
        } else {
            zipExtraField.parseFromCentralDirectoryData(bArr, i11, i12);
        }
        return zipExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        boolean z11;
        int i11;
        byte[] centralDirectoryData;
        int length = zipExtraFieldArr.length;
        if (length <= 0 || !(zipExtraFieldArr[length - 1] instanceof UnparseableExtraFieldData)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            i11 = length - 1;
        } else {
            i11 = length;
        }
        int i12 = i11 * 4;
        for (ZipExtraField centralDirectoryLength : zipExtraFieldArr) {
            i12 += centralDirectoryLength.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            System.arraycopy(zipExtraFieldArr[i14].getHeaderId().getBytes(), 0, bArr, i13, 2);
            System.arraycopy(zipExtraFieldArr[i14].getCentralDirectoryLength().getBytes(), 0, bArr, i13 + 2, 2);
            i13 += 4;
            byte[] centralDirectoryData2 = zipExtraFieldArr[i14].getCentralDirectoryData();
            if (centralDirectoryData2 != null) {
                System.arraycopy(centralDirectoryData2, 0, bArr, i13, centralDirectoryData2.length);
                i13 += centralDirectoryData2.length;
            }
        }
        if (z11 && (centralDirectoryData = zipExtraFieldArr[length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(centralDirectoryData, 0, bArr, i13, centralDirectoryData.length);
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        boolean z11;
        int i11;
        byte[] localFileDataData;
        int length = zipExtraFieldArr.length;
        if (length <= 0 || !(zipExtraFieldArr[length - 1] instanceof UnparseableExtraFieldData)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            i11 = length - 1;
        } else {
            i11 = length;
        }
        int i12 = i11 * 4;
        for (ZipExtraField localFileDataLength : zipExtraFieldArr) {
            i12 += localFileDataLength.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i12];
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            System.arraycopy(zipExtraFieldArr[i14].getHeaderId().getBytes(), 0, bArr, i13, 2);
            System.arraycopy(zipExtraFieldArr[i14].getLocalFileDataLength().getBytes(), 0, bArr, i13 + 2, 2);
            i13 += 4;
            byte[] localFileDataData2 = zipExtraFieldArr[i14].getLocalFileDataData();
            if (localFileDataData2 != null) {
                System.arraycopy(localFileDataData2, 0, bArr, i13, localFileDataData2.length);
                i13 += localFileDataData2.length;
            }
        }
        if (z11 && (localFileDataData = zipExtraFieldArr[length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(localFileDataData, 0, bArr, i13, localFileDataData.length);
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (InstantiationException unused2) {
            throw new RuntimeException(cls + " is not a concrete class");
        } catch (IllegalAccessException unused3) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        }
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z11) throws ZipException {
        return parse(bArr, z11, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z11, final UnparseableExtraField unparseableExtraField) throws ZipException {
        return parse(bArr, z11, (ExtraFieldParsingBehavior) new ExtraFieldParsingBehavior() {
            public ZipExtraField createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException {
                return ExtraFieldUtils.createExtraField(zipShort);
            }

            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) throws ZipException {
                return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i11, i12, z11);
            }

            public ZipExtraField onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException {
                return unparseableExtraField.onUnparseableExtraField(bArr, i11, i12, z11, i13);
            }
        });
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z11, ExtraFieldParsingBehavior extraFieldParsingBehavior) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i11 = 0;
        while (true) {
            if (i11 > length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i11);
            int value = new ZipShort(bArr, i11 + 2).getValue();
            int i12 = i11 + 4;
            if (i12 + value > length) {
                ZipExtraField onUnparseableExtraField = extraFieldParsingBehavior.onUnparseableExtraField(bArr, i11, length - i11, z11, value);
                if (onUnparseableExtraField != null) {
                    arrayList.add(onUnparseableExtraField);
                }
            } else {
                try {
                    ZipExtraField createExtraField = extraFieldParsingBehavior.createExtraField(zipShort);
                    Objects.requireNonNull(createExtraField, "createExtraField must not return null");
                    ZipExtraField fill = extraFieldParsingBehavior.fill(createExtraField, bArr, i12, value, z11);
                    Objects.requireNonNull(fill, "fill must not return null");
                    arrayList.add(fill);
                    i11 += value + 4;
                } catch (IllegalAccessException | InstantiationException e11) {
                    throw ((ZipException) new ZipException(e11.getMessage()).initCause(e11));
                }
            }
        }
        return (ZipExtraField[]) arrayList.toArray(EMPTY_ZIP_EXTRA_FIELD_ARRAY);
    }
}
