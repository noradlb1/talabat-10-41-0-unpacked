package com.huawei.hms.maps.model.animation;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;

public abstract class Animation implements Parcelable {
    public static final Parcelable.Creator<Animation> CREATOR = new Parcelable.Creator<Animation>() {
        /* renamed from: a */
        public Animation createFromParcel(Parcel parcel) {
            return Animation.b(parcel);
        }

        /* renamed from: a */
        public Animation[] newArray(int i11) {
            return new Animation[0];
        }
    };
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    /* renamed from: a  reason: collision with root package name */
    protected int f49573a;

    /* renamed from: b  reason: collision with root package name */
    protected int f49574b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f49575c = 1;

    /* renamed from: d  reason: collision with root package name */
    protected int f49576d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected long f49577e = 250;

    /* renamed from: f  reason: collision with root package name */
    protected Interpolator f49578f;

    /* renamed from: g  reason: collision with root package name */
    protected AnimationListener f49579g;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public Animation() {
    }

    public Animation(ParcelReader parcelReader) {
        this.f49573a = parcelReader.readInt(2, 0);
        this.f49574b = parcelReader.readInt(3, 0);
        this.f49575c = parcelReader.readInt(4, 0);
        this.f49576d = parcelReader.readInt(5, 0);
        this.f49577e = parcelReader.readLong(6, 0);
        IBinder readIBinder = parcelReader.readIBinder(7, (IBinder) null);
        if (readIBinder != null) {
            this.f49578f = (Interpolator) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(readIBinder));
        }
    }

    /* access modifiers changed from: private */
    public static Animation b(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        int readInt = parcelReader.readInt(2, 0);
        if (readInt == 1) {
            return new AlphaAnimation(parcelReader);
        }
        if (readInt == 2) {
            return new RotateAnimation(parcelReader);
        }
        if (readInt == 3) {
            return new ScaleAnimation(parcelReader);
        }
        if (readInt == 4) {
            return new TranslateAnimation(parcelReader);
        }
        if (readInt != 5) {
            return null;
        }
        return new AnimationSet(parcelReader);
    }

    public abstract void a(ParcelWrite parcelWrite, int i11);

    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.f49577e;
    }

    public int getFillMode() {
        return this.f49574b;
    }

    public Interpolator getInterpolator() {
        return this.f49578f;
    }

    public AnimationListener getListener() {
        return this.f49579g;
    }

    public int getRepeatCount() {
        return this.f49576d;
    }

    public int getRepeatMode() {
        return this.f49575c;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.f49579g = animationListener;
    }

    public abstract void setDuration(long j11);

    public void setFillMode(int i11) {
        this.f49574b = i11;
    }

    public abstract void setInterpolator(Interpolator interpolator);

    public void setRepeatCount(int i11) {
        this.f49576d = i11;
    }

    public void setRepeatMode(int i11) {
        this.f49575c = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeInt(2, this.f49573a);
        parcelWrite.writeInt(3, this.f49574b);
        parcelWrite.writeInt(4, this.f49575c);
        parcelWrite.writeInt(5, this.f49576d);
        parcelWrite.writeLong(6, this.f49577e);
        parcelWrite.writeIBinder(7, ObjectWrapper.wrap(this.f49578f).asBinder(), false);
        a(parcelWrite, i11);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
