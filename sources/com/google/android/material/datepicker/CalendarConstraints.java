package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            Class<Month> cls = Month.class;
            return new CalendarConstraints((Month) parcel.readParcelable(cls.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()));
        }

        @NonNull
        public CalendarConstraints[] newArray(int i11) {
            return new CalendarConstraints[i11];
        }
    };
    /* access modifiers changed from: private */
    @NonNull
    public final Month end;
    private final int monthSpan;
    /* access modifiers changed from: private */
    @Nullable
    public Month openAt;
    /* access modifiers changed from: private */
    @NonNull
    public final Month start;
    /* access modifiers changed from: private */
    @NonNull
    public final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j11);
    }

    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        if (month.compareTo(this.end) > 0) {
            return this.end;
        }
        return month;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.start.equals(calendarConstraints.start) || !this.end.equals(calendarConstraints.end) || !ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) || !this.validator.equals(calendarConstraints.validator)) {
            return false;
        }
        return true;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long j11) {
        if (this.start.getDay(1) <= j11) {
            Month month = this.end;
            if (j11 <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.monthSpan = month.monthsUntil(month2) + 1;
            this.yearSpan = (month2.year - month.year) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        @NonNull
        public CalendarConstraints build() {
            Month month;
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month create = Month.create(this.start);
            Month create2 = Month.create(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l11 = this.openAt;
            if (l11 == null) {
                month = null;
            } else {
                month = Month.create(l11.longValue());
            }
            return new CalendarConstraints(create, create2, dateValidator, month);
        }

        @NonNull
        public Builder setEnd(long j11) {
            this.end = j11;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j11) {
            this.openAt = Long.valueOf(j11);
            return this;
        }

        @NonNull
        public Builder setStart(long j11) {
            this.start = j11;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }
    }
}
