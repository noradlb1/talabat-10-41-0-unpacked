package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() {
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        public IntentSenderRequest[] newArray(int i11) {
            return new IntentSenderRequest[i11];
        }
    };
    @Nullable
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    @NonNull
    private final IntentSender mIntentSender;

    public IntentSenderRequest(@NonNull IntentSender intentSender, @Nullable Intent intent, int i11, int i12) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = i11;
        this.mFlagsValues = i12;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    @NonNull
    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeParcelable(this.mIntentSender, i11);
        parcel.writeParcelable(this.mFillInIntent, i11);
        parcel.writeInt(this.mFlagsMask);
        parcel.writeInt(this.mFlagsValues);
    }

    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(@NonNull IntentSender intentSender) {
            this.mIntentSender = intentSender;
        }

        @NonNull
        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        @NonNull
        public Builder setFillInIntent(@Nullable Intent intent) {
            this.mFillInIntent = intent;
            return this;
        }

        @NonNull
        public Builder setFlags(int i11, int i12) {
            this.mFlagsValues = i11;
            this.mFlagsMask = i12;
            return this;
        }

        public Builder(@NonNull PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }
    }

    public IntentSenderRequest(@NonNull Parcel parcel) {
        this.mIntentSender = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = parcel.readInt();
        this.mFlagsValues = parcel.readInt();
    }
}
