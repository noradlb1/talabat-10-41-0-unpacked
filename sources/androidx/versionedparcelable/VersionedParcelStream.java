package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName("UTF-16");

    /* renamed from: d  reason: collision with root package name */
    public int f37901d;

    /* renamed from: e  reason: collision with root package name */
    public int f37902e;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    public static class FieldBuffer {

        /* renamed from: a  reason: collision with root package name */
        public final ByteArrayOutputStream f37904a;

        /* renamed from: b  reason: collision with root package name */
        public final DataOutputStream f37905b;
        private final int mFieldId;
        private final DataOutputStream mTarget;

        public FieldBuffer(int i11, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f37904a = byteArrayOutputStream;
            this.f37905b = new DataOutputStream(byteArrayOutputStream);
            this.mFieldId = i11;
            this.mTarget = dataOutputStream;
        }

        public void a() throws IOException {
            int i11;
            this.f37905b.flush();
            int size = this.f37904a.size();
            int i12 = this.mFieldId << 16;
            if (size >= 65535) {
                i11 = 65535;
            } else {
                i11 = size;
            }
            this.mTarget.writeInt(i12 | i11);
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.f37904a.writeTo(this.mTarget);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private void readObject(int i11, String str, Bundle bundle) {
        switch (i11) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) b(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, c());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, e());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, h());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, i());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, f());
                return;
            default:
                throw new RuntimeException("Unknown type " + i11);
        }
    }

    private void writeObject(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            l((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            m((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            o((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            q((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            r((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            p((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    public VersionedParcel a() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.f37897a, this.f37898b, this.f37899c);
    }

    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f37904a.size() != 0) {
                    this.mFieldBuffer.a();
                }
                this.mFieldBuffer = null;
            } catch (IOException e11) {
                throw new VersionedParcel.ParcelException(e11);
            }
        }
    }

    public CharSequence d() {
        return null;
    }

    public boolean isStream() {
        return true;
    }

    public void n(CharSequence charSequence) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i11 = 0; i11 < readInt; i11++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return bArr;
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public boolean readField(int i11) {
        while (true) {
            try {
                int i12 = this.mFieldId;
                if (i12 == i11) {
                    return true;
                }
                if (String.valueOf(i12).compareTo(String.valueOf(i11)) > 0) {
                    return false;
                }
                int i13 = this.f37901d;
                int i14 = this.f37902e;
                if (i13 < i14) {
                    this.mMasterInput.skip((long) (i14 - i13));
                }
                this.f37902e = -1;
                int readInt = this.mMasterInput.readInt();
                this.f37901d = 0;
                int i15 = readInt & 65535;
                if (i15 == 65535) {
                    i15 = this.mMasterInput.readInt();
                }
                this.mFieldId = (readInt >> 16) & 65535;
                this.f37902e = i15;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return new String(bArr, UTF_16);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int i11) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i11, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.f37905b;
    }

    public void setSerializationFlags(boolean z11, boolean z12) {
        if (z11) {
            this.mIgnoreParcelables = z12;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void writeBoolean(boolean z11) {
        try {
            this.mCurrentOutput.writeBoolean(z11);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.mCurrentOutput.writeInt(keySet.size());
                for (String next : keySet) {
                    writeString(next);
                    writeObject(bundle.get(next));
                }
            } catch (IOException e11) {
                throw new VersionedParcel.ParcelException(e11);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.mCurrentOutput.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
            } catch (IOException e11) {
                throw new VersionedParcel.ParcelException(e11);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeDouble(double d11) {
        try {
            this.mCurrentOutput.writeDouble(d11);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public void writeFloat(float f11) {
        try {
            this.mCurrentOutput.writeFloat(f11);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public void writeInt(int i11) {
        try {
            this.mCurrentOutput.writeInt(i11);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public void writeLong(long j11) {
        try {
            this.mCurrentOutput.writeLong(j11);
        } catch (IOException e11) {
            throw new VersionedParcel.ParcelException(e11);
        }
    }

    public void writeParcelable(Parcelable parcelable) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(UTF_16);
                this.mCurrentOutput.writeInt(bytes.length);
                this.mCurrentOutput.write(bytes);
            } catch (IOException e11) {
                throw new VersionedParcel.ParcelException(e11);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f37901d = 0;
        this.mFieldId = -1;
        this.f37902e = -1;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) {
            public int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i11 = versionedParcelStream.f37902e;
                if (i11 == -1 || versionedParcelStream.f37901d < i11) {
                    int read = super.read();
                    VersionedParcelStream.this.f37901d++;
                    return read;
                }
                throw new IOException();
            }

            public long skip(long j11) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i11 = versionedParcelStream.f37902e;
                if (i11 == -1 || versionedParcelStream.f37901d < i11) {
                    long skip = super.skip(j11);
                    if (skip > 0) {
                        VersionedParcelStream.this.f37901d += (int) skip;
                    }
                    return skip;
                }
                throw new IOException();
            }

            public int read(byte[] bArr, int i11, int i12) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i13 = versionedParcelStream.f37902e;
                if (i13 == -1 || versionedParcelStream.f37901d < i13) {
                    int read = super.read(bArr, i11, i12);
                    if (read > 0) {
                        VersionedParcelStream.this.f37901d += read;
                    }
                    return read;
                }
                throw new IOException();
            }
        }) : null;
        this.mMasterInput = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = dataInputStream;
        this.mCurrentOutput = dataOutputStream;
    }

    public void writeByteArray(byte[] bArr, int i11, int i12) {
        if (bArr != null) {
            try {
                this.mCurrentOutput.writeInt(i12);
                this.mCurrentOutput.write(bArr, i11, i12);
            } catch (IOException e11) {
                throw new VersionedParcel.ParcelException(e11);
            }
        } else {
            this.mCurrentOutput.writeInt(-1);
        }
    }
}
