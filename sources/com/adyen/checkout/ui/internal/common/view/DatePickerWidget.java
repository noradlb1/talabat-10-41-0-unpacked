package com.adyen.checkout.ui.internal.common.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatTextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class DatePickerWidget extends AppCompatTextView implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Date mDate;
    private DateFormat mDisplayDateFormat;
    private HashSet<OnDateChangeListener> mListener;

    public interface OnDateChangeListener {
        void onDateChanged(@NonNull Date date);
    }

    public static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public long f40257b;

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeLong(this.f40257b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f40257b = 0;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f40257b = 0;
            this.f40257b = parcel.readLong();
        }
    }

    public DatePickerWidget(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void notifyOnDateChangedListeners() {
        Iterator<OnDateChangeListener> it = this.mListener.iterator();
        while (it.hasNext()) {
            it.next().onDateChanged(this.mDate);
        }
    }

    private void showPickerDialog() {
        Calendar instance = Calendar.getInstance();
        Date date = this.mDate;
        if (date != null) {
            instance.setTime(date);
        }
        new DatePickerDialog(getContext(), this, instance.get(1), instance.get(2), instance.get(5)).show();
    }

    public void addOnDateChangeListener(@NonNull OnDateChangeListener onDateChangeListener) {
        this.mListener.add(onDateChangeListener);
    }

    @Nullable
    public Date getDate() {
        return this.mDate;
    }

    public void onClick(@NonNull View view) {
        showPickerDialog();
    }

    public void onDateSet(@NonNull DatePicker datePicker, int i11, int i12, int i13) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i11);
        instance.set(2, i12);
        instance.set(5, i13);
        Date time = instance.getTime();
        this.mDate = time;
        setText(this.mDisplayDateFormat.format(time));
        notifyOnDateChangedListeners();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }

    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f40257b != 0) {
            Date date = new Date(savedState.f40257b);
            this.mDate = date;
            setText(this.mDisplayDateFormat.format(date));
            notifyOnDateChangedListeners();
        }
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Date date = this.mDate;
        if (date != null) {
            savedState.f40257b = date.getTime();
        }
        return savedState;
    }

    public void removeOnDateChangeListener(@NonNull OnDateChangeListener onDateChangeListener) {
        this.mListener.remove(onDateChangeListener);
    }

    public void setDate(@NonNull Date date) {
        this.mDate = date;
        setText(this.mDisplayDateFormat.format(date));
        notifyOnDateChangedListeners();
    }

    public void setDisplayDateFormat(@NonNull DateFormat dateFormat) {
        this.mDisplayDateFormat = dateFormat;
    }

    public DatePickerWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle);
        this.mListener = new HashSet<>();
        this.mDisplayDateFormat = DateFormat.getDateInstance(2);
    }

    public DatePickerWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet);
    }
}
