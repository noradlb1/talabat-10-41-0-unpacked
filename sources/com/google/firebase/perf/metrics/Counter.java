package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() {
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        public Counter[] newArray(int i11) {
            return new Counter[i11];
        }
    };
    private final AtomicLong count;

    /* renamed from: name  reason: collision with root package name */
    private final String f47451name;

    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.count.get();
    }

    @NonNull
    public String getName() {
        return this.f47451name;
    }

    public void increment(long j11) {
        this.count.addAndGet(j11);
    }

    public void setCount(long j11) {
        this.count.set(j11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f47451name);
        parcel.writeLong(this.count.get());
    }

    public Counter(@NonNull String str) {
        this.f47451name = str;
        this.count = new AtomicLong(0);
    }

    private Counter(Parcel parcel) {
        this.f47451name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }
}
