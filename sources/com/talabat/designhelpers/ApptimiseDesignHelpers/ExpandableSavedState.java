package com.talabat.designhelpers.ApptimiseDesignHelpers;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ExpandableSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ExpandableSavedState> CREATOR = new Parcelable.Creator<ExpandableSavedState>() {
        public ExpandableSavedState createFromParcel(Parcel parcel) {
            return new ExpandableSavedState(parcel);
        }

        public ExpandableSavedState[] newArray(int i11) {
            return new ExpandableSavedState[i11];
        }
    };
    private int size;
    private float weight;

    public ExpandableSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public int getSize() {
        return this.size;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setSize(int i11) {
        this.size = i11;
    }

    public void setWeight(float f11) {
        this.weight = f11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeInt(this.size);
        parcel.writeFloat(this.weight);
    }

    private ExpandableSavedState(Parcel parcel) {
        super(parcel);
        this.size = parcel.readInt();
        this.weight = parcel.readFloat();
    }
}
