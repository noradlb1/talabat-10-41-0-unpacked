package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public VersionedParcel a() {
        Parcel parcel = this.mParcel;
        int dataPosition = parcel.dataPosition();
        int i11 = this.mNextRead;
        if (i11 == this.mOffset) {
            i11 = this.mEnd;
        }
        int i12 = i11;
        return new VersionedParcelParcel(parcel, dataPosition, i12, this.mPrefix + "  ", this.f37897a, this.f37898b, this.f37899c);
    }

    public void closeField() {
        int i11 = this.mCurrentField;
        if (i11 >= 0) {
            int i12 = this.mPositionLookup.get(i11);
            int dataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(i12);
            this.mParcel.writeInt(dataPosition - i12);
            this.mParcel.setDataPosition(dataPosition);
        }
    }

    public CharSequence d() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    public void n(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.mParcel, 0);
    }

    public boolean readBoolean() {
        return this.mParcel.readInt() != 0;
    }

    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    public byte[] readByteArray() {
        int readInt = this.mParcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.mParcel.readByteArray(bArr);
        return bArr;
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public boolean readField(int i11) {
        while (this.mNextRead < this.mEnd) {
            int i12 = this.mFieldId;
            if (i12 == i11) {
                return true;
            }
            if (String.valueOf(i12).compareTo(String.valueOf(i11)) > 0) {
                return false;
            }
            this.mParcel.setDataPosition(this.mNextRead);
            int readInt = this.mParcel.readInt();
            this.mFieldId = this.mParcel.readInt();
            this.mNextRead += readInt;
        }
        if (this.mFieldId == i11) {
            return true;
        }
        return false;
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public <T extends Parcelable> T readParcelable() {
        return this.mParcel.readParcelable(getClass().getClassLoader());
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public void setOutputField(int i11) {
        closeField();
        this.mCurrentField = i11;
        this.mPositionLookup.put(i11, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(i11);
    }

    public void writeBoolean(boolean z11) {
        this.mParcel.writeInt(z11 ? 1 : 0);
    }

    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr);
            return;
        }
        this.mParcel.writeInt(-1);
    }

    public void writeDouble(double d11) {
        this.mParcel.writeDouble(d11);
    }

    public void writeFloat(float f11) {
        this.mParcel.writeFloat(f11);
    }

    public void writeInt(int i11) {
        this.mParcel.writeInt(i11);
    }

    public void writeLong(long j11) {
        this.mParcel.writeLong(j11);
    }

    public void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    public void writeString(String str) {
        this.mParcel.writeString(str);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }

    private VersionedParcelParcel(Parcel parcel, int i11, int i12, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = i11;
        this.mEnd = i12;
        this.mNextRead = i11;
        this.mPrefix = str;
    }

    public void writeByteArray(byte[] bArr, int i11, int i12) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr, i11, i12);
            return;
        }
        this.mParcel.writeInt(-1);
    }
}
