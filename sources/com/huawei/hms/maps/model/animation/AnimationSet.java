package com.huawei.hms.maps.model.animation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.ArrayList;
import java.util.List;

public class AnimationSet extends Animation {
    public static final Parcelable.Creator<AnimationSet> CREATOR = new Parcelable.Creator<AnimationSet>() {
        /* renamed from: a */
        public AnimationSet createFromParcel(Parcel parcel) {
            return new AnimationSet(new ParcelReader(parcel));
        }

        /* renamed from: a */
        public AnimationSet[] newArray(int i11) {
            return new AnimationSet[0];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private boolean f49580h;

    /* renamed from: i  reason: collision with root package name */
    private List<Animation> f49581i = new ArrayList();

    public AnimationSet(ParcelReader parcelReader) {
        super(parcelReader);
        this.f49580h = parcelReader.readBoolean(8, false);
        this.f49581i = parcelReader.createTypedList(9, Animation.CREATOR, new ArrayList());
    }

    public AnimationSet(boolean z11) {
        this.f49573a = 5;
        this.f49580h = z11;
    }

    public void a(ParcelWrite parcelWrite, int i11) {
        parcelWrite.writeBoolean(8, this.f49580h);
        parcelWrite.writeTypedList(9, this.f49581i, false);
    }

    public void addAnimation(Animation animation) {
        if (this.f49580h) {
            animation.setInterpolator(this.f49578f);
        }
        this.f49581i.add(animation);
    }

    public void cleanAnimation() {
        this.f49581i.clear();
    }

    public List<Animation> getAnimations() {
        return this.f49581i;
    }

    public boolean isShareInterpolator() {
        return this.f49580h;
    }

    public void setDuration(long j11) {
        this.f49577e = j11;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f49578f = interpolator;
        if (this.f49580h) {
            for (Animation interpolator2 : this.f49581i) {
                interpolator2.setInterpolator(interpolator);
            }
        }
    }
}
