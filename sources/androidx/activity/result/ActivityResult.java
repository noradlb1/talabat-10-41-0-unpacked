package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        public ActivityResult[] newArray(int i11) {
            return new ActivityResult[i11];
        }
    };
    @Nullable
    private final Intent mData;
    private final int mResultCode;

    public ActivityResult(int i11, @Nullable Intent intent) {
        this.mResultCode = i11;
        this.mData = intent;
    }

    @NonNull
    public static String resultCodeToString(int i11) {
        return i11 != -1 ? i11 != 0 ? String.valueOf(i11) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int i12;
        parcel.writeInt(this.mResultCode);
        if (this.mData == null) {
            i12 = 0;
        } else {
            i12 = 1;
        }
        parcel.writeInt(i12);
        Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i11);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
