package com.rd.draw.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class PositionSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PositionSavedState> CREATOR = new Parcelable.Creator<PositionSavedState>() {
        public PositionSavedState createFromParcel(Parcel parcel) {
            return new PositionSavedState(parcel);
        }

        public PositionSavedState[] newArray(int i11) {
            return new PositionSavedState[i11];
        }
    };
    private int lastSelectedPosition;
    private int selectedPosition;
    private int selectingPosition;

    public PositionSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public int getLastSelectedPosition() {
        return this.lastSelectedPosition;
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public int getSelectingPosition() {
        return this.selectingPosition;
    }

    public void setLastSelectedPosition(int i11) {
        this.lastSelectedPosition = i11;
    }

    public void setSelectedPosition(int i11) {
        this.selectedPosition = i11;
    }

    public void setSelectingPosition(int i11) {
        this.selectingPosition = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeInt(this.selectedPosition);
        parcel.writeInt(this.selectingPosition);
        parcel.writeInt(this.lastSelectedPosition);
    }

    private PositionSavedState(Parcel parcel) {
        super(parcel);
        this.selectedPosition = parcel.readInt();
        this.selectingPosition = parcel.readInt();
        this.lastSelectedPosition = parcel.readInt();
    }
}
