package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.internal.security.CertificateUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

@RequiresApi(19)
class ProfileTranscoder {
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f37393a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f37394b = {112, 114, 109, 0};

    private ProfileTranscoder() {
    }

    public static byte[] a(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, Encoding.d(inputStream, bArr.length))) {
            return Encoding.d(inputStream, ProfileVersion.f37396b.length);
        }
        throw Encoding.c("Invalid magic");
    }

    @NonNull
    public static DexProfileData[] b(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f37400f)) {
            if (!Arrays.equals(ProfileVersion.f37395a, bArr2)) {
                return c(inputStream, bArr, dexProfileDataArr);
            }
            throw Encoding.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, ProfileVersion.f37401g)) {
            return d(inputStream, bArr2, dexProfileDataArr);
        } else {
            throw Encoding.c("Unsupported meta version");
        }
    }

    @NonNull
    public static DexProfileData[] c(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f37400f)) {
            int j11 = Encoding.j(inputStream);
            byte[] e11 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
                try {
                    DexProfileData[] readMetadataForNBody = readMetadataForNBody(byteArrayInputStream, j11, dexProfileDataArr);
                    byteArrayInputStream.close();
                    return readMetadataForNBody;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported meta version");
        }
        throw th;
    }

    private static int computeMethodFlags(@NonNull DexProfileData dexProfileData) {
        int i11 = 0;
        for (Map.Entry<Integer, Integer> value : dexProfileData.f37390i.entrySet()) {
            i11 |= ((Integer) value.getValue()).intValue();
        }
        return i11;
    }

    @NonNull
    private static byte[] createCompressibleBody(@NonNull DexProfileData[] dexProfileDataArr, @NonNull byte[] bArr) throws IOException {
        int i11 = 0;
        int i12 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i12 += Encoding.k(generateDexKey(dexProfileData.f37382a, dexProfileData.f37383b, bArr)) + 16 + (dexProfileData.f37386e * 2) + dexProfileData.f37387f + getMethodBitmapStorageSize(dexProfileData.f37388g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i12);
        if (Arrays.equals(bArr, ProfileVersion.f37397c)) {
            int length = dexProfileDataArr.length;
            while (i11 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i11];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.f37382a, dexProfileData2.f37383b, bArr));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i11++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.f37382a, dexProfileData3.f37383b, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i11 < length2) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i11]);
                i11++;
            }
        }
        if (byteArrayOutputStream.size() == i12) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i12);
    }

    private static WritableFileSection createCompressibleClassSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        int i12 = 0;
        while (i11 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i11];
                Encoding.p(byteArrayOutputStream, i11);
                Encoding.p(byteArrayOutputStream, dexProfileData.f37386e);
                i12 = i12 + 2 + 2 + (dexProfileData.f37386e * 2);
                writeClasses(byteArrayOutputStream, dexProfileData);
                i11++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i12 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i12, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i12 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static WritableFileSection createCompressibleMethodsSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        int i12 = 0;
        while (i11 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i11];
                int computeMethodFlags = computeMethodFlags(dexProfileData);
                byte[] createMethodBitmapRegion = createMethodBitmapRegion(dexProfileData);
                byte[] createMethodsWithInlineCaches = createMethodsWithInlineCaches(dexProfileData);
                Encoding.p(byteArrayOutputStream, i11);
                int length = createMethodBitmapRegion.length + 2 + createMethodsWithInlineCaches.length;
                Encoding.q(byteArrayOutputStream, (long) length);
                Encoding.p(byteArrayOutputStream, computeMethodFlags);
                byteArrayOutputStream.write(createMethodBitmapRegion);
                byteArrayOutputStream.write(createMethodsWithInlineCaches);
                i12 = i12 + 2 + 4 + length;
                i11++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i12 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i12, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i12 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] createMethodBitmapRegion(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodBitmap(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static byte[] createMethodsWithInlineCaches(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @NonNull
    public static DexProfileData[] d(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int h11 = Encoding.h(inputStream);
        byte[] e11 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
            try {
                DexProfileData[] readMetadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr, h11, dexProfileDataArr);
                byteArrayInputStream.close();
                return readMetadataV002Body;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw Encoding.c("Content found after the end of file");
        }
        throw th;
    }

    @NonNull
    public static DexProfileData[] e(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f37396b)) {
            int j11 = Encoding.j(inputStream);
            byte[] e11 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
                try {
                    DexProfileData[] readUncompressedBody = readUncompressedBody(byteArrayInputStream, str, j11);
                    byteArrayInputStream.close();
                    return readUncompressedBody;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported version");
        }
        throw th;
    }

    @NonNull
    private static String enforceSeparator(@NonNull String str, @NonNull String str2) {
        if ("!".equals(str2)) {
            return str.replace(CertificateUtil.DELIMITER, "!");
        }
        if (CertificateUtil.DELIMITER.equals(str2)) {
            return str.replace("!", CertificateUtil.DELIMITER);
        }
        return str;
    }

    @NonNull
    private static String extractKey(@NonNull String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(CertificateUtil.DELIMITER);
        }
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static boolean f(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f37395a)) {
            writeProfileForS(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f37396b)) {
            writeProfileForP(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f37398d)) {
            writeProfileForO(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f37397c)) {
            writeProfileForO_MR1(outputStream, dexProfileDataArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.f37399e)) {
            return false;
        } else {
            writeProfileForN(outputStream, dexProfileDataArr);
            return true;
        }
    }

    @Nullable
    private static DexProfileData findByDexName(@NonNull DexProfileData[] dexProfileDataArr, @NonNull String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String extractKey = extractKey(str);
        for (int i11 = 0; i11 < dexProfileDataArr.length; i11++) {
            if (dexProfileDataArr[i11].f37383b.equals(extractKey)) {
                return dexProfileDataArr[i11];
            }
        }
        return null;
    }

    public static void g(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f37393a);
        outputStream.write(bArr);
    }

    @NonNull
    private static String generateDexKey(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String a11 = ProfileVersion.a(bArr);
        if (str.length() <= 0) {
            return enforceSeparator(str2, a11);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(CertificateUtil.DELIMITER)) {
            return enforceSeparator(str2, a11);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.a(bArr) + str2;
    }

    private static int getMethodBitmapStorageSize(int i11) {
        return roundUpToByte(i11 * 2) / 8;
    }

    private static int methodFlagBitmapIndex(int i11, int i12, int i13) {
        if (i11 == 1) {
            throw Encoding.c("HOT methods are not stored in the bitmap");
        } else if (i11 == 2) {
            return i12;
        } else {
            if (i11 == 4) {
                return i12 + i13;
            }
            throw Encoding.c("Unexpected flag: " + i11);
        }
    }

    private static int[] readClasses(@NonNull InputStream inputStream, int i11) throws IOException {
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += Encoding.h(inputStream);
            iArr[i13] = i12;
        }
        return iArr;
    }

    private static int readFlagsFromBitmap(@NonNull BitSet bitSet, int i11, int i12) {
        int i13 = 2;
        if (!bitSet.get(methodFlagBitmapIndex(2, i11, i12))) {
            i13 = 0;
        }
        if (bitSet.get(methodFlagBitmapIndex(4, i11, i12))) {
            return i13 | 4;
        }
        return i13;
    }

    private static void readHotMethodRegion(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int available = inputStream.available() - dexProfileData.f37387f;
        int i11 = 0;
        while (inputStream.available() > available) {
            i11 += Encoding.h(inputStream);
            dexProfileData.f37390i.put(Integer.valueOf(i11), 1);
            for (int h11 = Encoding.h(inputStream); h11 > 0; h11--) {
                skipInlineCache(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Encoding.c("Read too much data during profile line parse");
        }
    }

    @NonNull
    private static DexProfileData[] readMetadataForNBody(@NonNull InputStream inputStream, int i11, DexProfileData[] dexProfileDataArr) throws IOException {
        int i12 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i11 == dexProfileDataArr.length) {
            String[] strArr = new String[i11];
            int[] iArr = new int[i11];
            for (int i13 = 0; i13 < i11; i13++) {
                int h11 = Encoding.h(inputStream);
                iArr[i13] = Encoding.h(inputStream);
                strArr[i13] = Encoding.f(inputStream, h11);
            }
            while (i12 < i11) {
                DexProfileData dexProfileData = dexProfileDataArr[i12];
                if (dexProfileData.f37383b.equals(strArr[i12])) {
                    int i14 = iArr[i12];
                    dexProfileData.f37386e = i14;
                    dexProfileData.f37389h = readClasses(inputStream, i14);
                    i12++;
                } else {
                    throw Encoding.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    @NonNull
    private static DexProfileData[] readMetadataV002Body(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i11, DexProfileData[] dexProfileDataArr) throws IOException {
        int i12 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i11 == dexProfileDataArr.length) {
            while (i12 < i11) {
                Encoding.h(inputStream);
                String f11 = Encoding.f(inputStream, Encoding.h(inputStream));
                long i13 = Encoding.i(inputStream);
                int h11 = Encoding.h(inputStream);
                DexProfileData findByDexName = findByDexName(dexProfileDataArr, f11);
                if (findByDexName != null) {
                    findByDexName.f37385d = i13;
                    int[] readClasses = readClasses(inputStream, h11);
                    if (Arrays.equals(bArr, ProfileVersion.f37399e)) {
                        findByDexName.f37386e = h11;
                        findByDexName.f37389h = readClasses;
                    }
                    i12++;
                } else {
                    throw Encoding.c("Missing profile key: " + f11);
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        BitSet valueOf = BitSet.valueOf(Encoding.d(inputStream, Encoding.a(dexProfileData.f37388g * 2)));
        int i11 = 0;
        while (true) {
            int i12 = dexProfileData.f37388g;
            if (i11 < i12) {
                int readFlagsFromBitmap = readFlagsFromBitmap(valueOf, i11, i12);
                if (readFlagsFromBitmap != 0) {
                    Integer num = dexProfileData.f37390i.get(Integer.valueOf(i11));
                    if (num == null) {
                        num = 0;
                    }
                    dexProfileData.f37390i.put(Integer.valueOf(i11), Integer.valueOf(readFlagsFromBitmap | num.intValue()));
                }
                i11++;
            } else {
                return;
            }
        }
    }

    @NonNull
    private static DexProfileData[] readUncompressedBody(@NonNull InputStream inputStream, @NonNull String str, int i11) throws IOException {
        InputStream inputStream2 = inputStream;
        int i12 = i11;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int h11 = Encoding.h(inputStream);
            int h12 = Encoding.h(inputStream);
            long i14 = Encoding.i(inputStream);
            String str2 = str;
            dexProfileDataArr[i13] = new DexProfileData(str2, Encoding.f(inputStream2, h11), Encoding.i(inputStream), 0, h12, (int) i14, (int) Encoding.i(inputStream), new int[h12], new TreeMap());
        }
        for (int i15 = 0; i15 < i12; i15++) {
            DexProfileData dexProfileData = dexProfileDataArr[i15];
            readHotMethodRegion(inputStream2, dexProfileData);
            dexProfileData.f37389h = readClasses(inputStream2, dexProfileData.f37386e);
            readMethodBitmap(inputStream2, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static int roundUpToByte(int i11) {
        return ((i11 + 8) - 1) & -8;
    }

    private static void setMethodBitmapBit(@NonNull byte[] bArr, int i11, int i12, @NonNull DexProfileData dexProfileData) {
        int methodFlagBitmapIndex = methodFlagBitmapIndex(i11, i12, dexProfileData.f37388g);
        int i13 = methodFlagBitmapIndex / 8;
        bArr[i13] = (byte) ((1 << (methodFlagBitmapIndex % 8)) | bArr[i13]);
    }

    private static void skipInlineCache(@NonNull InputStream inputStream) throws IOException {
        Encoding.h(inputStream);
        int j11 = Encoding.j(inputStream);
        if (j11 != 6 && j11 != 7) {
            while (j11 > 0) {
                Encoding.j(inputStream);
                for (int j12 = Encoding.j(inputStream); j12 > 0; j12--) {
                    Encoding.h(inputStream);
                }
                j11--;
            }
        }
    }

    private static void writeClasses(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int i11 = 0;
        for (int valueOf : dexProfileData.f37389h) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            Encoding.p(outputStream, valueOf2.intValue() - i11);
            i11 = valueOf2.intValue();
        }
    }

    private static WritableFileSection writeDexFileSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.p(byteArrayOutputStream, dexProfileDataArr.length);
            int i11 = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.q(byteArrayOutputStream, dexProfileData.f37384c);
                Encoding.q(byteArrayOutputStream, dexProfileData.f37385d);
                Encoding.q(byteArrayOutputStream, (long) dexProfileData.f37388g);
                String generateDexKey = generateDexKey(dexProfileData.f37382a, dexProfileData.f37383b, ProfileVersion.f37395a);
                int k11 = Encoding.k(generateDexKey);
                Encoding.p(byteArrayOutputStream, k11);
                i11 = i11 + 4 + 4 + 4 + 2 + (k11 * 1);
                Encoding.n(byteArrayOutputStream, generateDexKey);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i11 == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i11, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static void writeLineData(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        writeMethodsWithInlineCaches(outputStream, dexProfileData);
        writeClasses(outputStream, dexProfileData);
        writeMethodBitmap(outputStream, dexProfileData);
    }

    private static void writeLineHeader(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData, @NonNull String str) throws IOException {
        Encoding.p(outputStream, Encoding.k(str));
        Encoding.p(outputStream, dexProfileData.f37386e);
        Encoding.q(outputStream, (long) dexProfileData.f37387f);
        Encoding.q(outputStream, dexProfileData.f37384c);
        Encoding.q(outputStream, (long) dexProfileData.f37388g);
        Encoding.n(outputStream, str);
    }

    private static void writeMethodBitmap(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSize(dexProfileData.f37388g)];
        for (Map.Entry next : dexProfileData.f37390i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                setMethodBitmapBit(bArr, 2, intValue, dexProfileData);
            }
            if ((intValue2 & 4) != 0) {
                setMethodBitmapBit(bArr, 4, intValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    private static void writeMethodsWithInlineCaches(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int i11 = 0;
        for (Map.Entry next : dexProfileData.f37390i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                Encoding.p(outputStream, intValue - i11);
                Encoding.p(outputStream, 0);
                i11 = intValue;
            }
        }
    }

    private static void writeProfileForN(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.p(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.f37382a, dexProfileData.f37383b, ProfileVersion.f37399e);
            Encoding.p(outputStream, Encoding.k(generateDexKey));
            Encoding.p(outputStream, dexProfileData.f37390i.size());
            Encoding.p(outputStream, dexProfileData.f37389h.length);
            Encoding.q(outputStream, dexProfileData.f37384c);
            Encoding.n(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.f37390i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
            }
            for (int p11 : dexProfileData.f37389h) {
                Encoding.p(outputStream, p11);
            }
        }
    }

    private static void writeProfileForO(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.r(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.f37382a, dexProfileData.f37383b, ProfileVersion.f37398d);
            Encoding.p(outputStream, Encoding.k(generateDexKey));
            Encoding.p(outputStream, dexProfileData.f37389h.length);
            Encoding.q(outputStream, (long) (dexProfileData.f37390i.size() * 4));
            Encoding.q(outputStream, dexProfileData.f37384c);
            Encoding.n(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.f37390i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
                Encoding.p(outputStream, 0);
            }
            for (int p11 : dexProfileData.f37389h) {
                Encoding.p(outputStream, p11);
            }
        }
    }

    private static void writeProfileForO_MR1(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.f37397c);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, createCompressibleBody);
    }

    private static void writeProfileForP(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.f37396b);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, createCompressibleBody);
    }

    private static void writeProfileForS(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        writeProfileSections(outputStream, dexProfileDataArr);
    }

    private static void writeProfileSections(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        int i11;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(writeDexFileSection(dexProfileDataArr));
        arrayList.add(createCompressibleClassSection(dexProfileDataArr));
        arrayList.add(createCompressibleMethodsSection(dexProfileDataArr));
        long length = ((long) ProfileVersion.f37395a.length) + ((long) f37393a.length) + 4 + ((long) (arrayList.size() * 16));
        Encoding.q(outputStream, (long) arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i12);
            Encoding.q(outputStream, writableFileSection.f37402a.getValue());
            Encoding.q(outputStream, length);
            if (writableFileSection.f37405d) {
                byte[] bArr = writableFileSection.f37404c;
                byte[] b11 = Encoding.b(bArr);
                arrayList2.add(b11);
                Encoding.q(outputStream, (long) b11.length);
                Encoding.q(outputStream, (long) bArr.length);
                i11 = b11.length;
            } else {
                arrayList2.add(writableFileSection.f37404c);
                Encoding.q(outputStream, (long) writableFileSection.f37404c.length);
                Encoding.q(outputStream, 0);
                i11 = writableFileSection.f37404c.length;
            }
            length += (long) i11;
        }
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            outputStream.write((byte[]) arrayList2.get(i13));
        }
    }
}
