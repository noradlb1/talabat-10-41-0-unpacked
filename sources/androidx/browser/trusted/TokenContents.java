package androidx.browser.trusted;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TokenContents {
    @NonNull
    private final byte[] mContents;
    @Nullable
    private List<byte[]> mFingerprints;
    @Nullable
    private String mPackageName;

    private TokenContents(@NonNull byte[] bArr) {
        this.mContents = bArr;
    }

    @NonNull
    public static TokenContents b(String str, List<byte[]> list) throws IOException {
        return new TokenContents(createToken(str, list), str, list);
    }

    @NonNull
    public static TokenContents c(@NonNull byte[] bArr) {
        return new TokenContents(bArr);
    }

    /* access modifiers changed from: private */
    public static int compareByteArrays(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        for (int i11 = 0; i11 < Math.min(bArr.length, bArr2.length); i11++) {
            byte b11 = bArr[i11];
            byte b12 = bArr2[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
        }
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        return 0;
    }

    @NonNull
    private static byte[] createToken(@NonNull String str, @NonNull List<byte[]> list) throws IOException {
        Collections.sort(list, new b());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] next : list) {
            dataOutputStream.writeInt(next.length);
            dataOutputStream.write(next);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private void parseIfNeeded() throws IOException {
        if (this.mPackageName == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.mContents));
            this.mPackageName = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.mFingerprints = new ArrayList(readInt);
            int i11 = 0;
            while (i11 < readInt) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.mFingerprints.add(bArr);
                    i11++;
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TokenContents.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mContents, ((TokenContents) obj).mContents);
    }

    @NonNull
    public byte[] getFingerprint(int i11) throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return Arrays.copyOf(list.get(i11), this.mFingerprints.get(i11).length);
        }
        throw new IllegalStateException();
    }

    public int getFingerprintCount() throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return list.size();
        }
        throw new IllegalStateException();
    }

    @NonNull
    public String getPackageName() throws IOException {
        parseIfNeeded();
        String str = this.mPackageName;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return Arrays.hashCode(this.mContents);
    }

    @NonNull
    public byte[] serialize() {
        byte[] bArr = this.mContents;
        return Arrays.copyOf(bArr, bArr.length);
    }

    private TokenContents(@NonNull byte[] bArr, @NonNull String str, @NonNull List<byte[]> list) {
        this.mContents = bArr;
        this.mPackageName = str;
        this.mFingerprints = new ArrayList(list.size());
        for (byte[] next : list) {
            this.mFingerprints.add(Arrays.copyOf(next, next.length));
        }
    }
}
