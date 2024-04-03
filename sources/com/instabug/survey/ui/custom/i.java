package com.instabug.survey.ui.custom;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class i extends View.BaseSavedState {
    public static final Parcelable.Creator<i> CREATOR = new h();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public float f52472a = 0.0f;

    public i(Parcel parcel) {
        super(parcel);
        this.f52472a = parcel.readFloat();
    }

    public i(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeFloat(this.f52472a);
    }
}
