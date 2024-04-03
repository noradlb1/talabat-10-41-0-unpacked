package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Class<Long> cls = Long.class;
            Long unused = rangeDateSelector.selectedStartItem = (Long) parcel.readValue(cls.getClassLoader());
            Long unused2 = rangeDateSelector.selectedEndItem = (Long) parcel.readValue(cls.getClassLoader());
            return rangeDateSelector;
        }

        @NonNull
        public RangeDateSelector[] newArray(int i11) {
            return new RangeDateSelector[i11];
        }
    };
    private final String invalidRangeEndError = " ";
    private String invalidRangeStartError;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextEnd = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextStart = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedEndItem = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedStartItem = null;

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean isValidRange(long j11, long j12) {
        return j11 <= j12;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    /* access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l11 = this.proposedTextStart;
        if (l11 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(l11.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(@NonNull Context context) {
        int i11;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i11 = R.attr.materialCalendarTheme;
        } else {
            i11 = R.attr.materialCalendarFullscreenTheme;
        }
        return MaterialAttributes.resolveOrThrow(context, i11, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l11 = this.selectedStartItem;
        if (l11 != null) {
            arrayList.add(l11);
        }
        Long l12 = this.selectedEndItem;
        if (l12 != null) {
            arrayList.add(l12);
        }
        return arrayList;
    }

    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l11 = this.selectedStartItem;
        if (l11 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l12 = this.selectedEndItem;
        if (l12 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(l11.longValue())});
        } else if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(l12.longValue())});
        } else {
            Pair<String, String> dateRangeString = DateStrings.getDateRangeString(l11, l12);
            return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[]{dateRangeString.first, dateRangeString.second});
        }
    }

    public boolean isSelectionComplete() {
        Long l11 = this.selectedStartItem;
        if (l11 == null || this.selectedEndItem == null || !isValidRange(l11.longValue(), this.selectedEndItem.longValue())) {
            return false;
        }
        return true;
    }

    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        Long l11 = this.selectedStartItem;
        if (l11 != null) {
            editText.setText(textInputFormat.format(l11));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l12 = this.selectedEndItem;
        if (l12 != null) {
            editText2.setText(textInputFormat.format(l12));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        textInputLayout2.setPlaceholderText(textInputHint);
        SimpleDateFormat simpleDateFormat = textInputFormat;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final TextInputLayout textInputLayout3 = textInputLayout;
        AnonymousClass1 r92 = r0;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        String str = textInputHint;
        final OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        AnonymousClass1 r02 = new DateFormatTextWatcher(textInputHint, simpleDateFormat, textInputLayout, calendarConstraints2) {
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextStart = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            public void onValidDate(@Nullable Long l11) {
                Long unused = RangeDateSelector.this.proposedTextStart = l11;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        };
        editText.addTextChangedListener(r92);
        editText2.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat, textInputLayout2, calendarConstraints2) {
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextEnd = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            public void onValidDate(@Nullable Long l11) {
                Long unused = RangeDateSelector.this.proposedTextEnd = l11;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void select(long j11) {
        Long l11 = this.selectedStartItem;
        if (l11 == null) {
            this.selectedStartItem = Long.valueOf(j11);
        } else if (this.selectedEndItem != null || !isValidRange(l11.longValue(), j11)) {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j11);
        } else {
            this.selectedEndItem = Long.valueOf(j11);
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l11;
        F f11 = pair.first;
        if (!(f11 == null || pair.second == null)) {
            Preconditions.checkArgument(isValidRange(((Long) f11).longValue(), ((Long) pair.second).longValue()));
        }
        F f12 = pair.first;
        Long l12 = null;
        if (f12 == null) {
            l11 = null;
        } else {
            l11 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) f12).longValue()));
        }
        this.selectedStartItem = l11;
        S s11 = pair.second;
        if (s11 != null) {
            l12 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) s11).longValue()));
        }
        this.selectedEndItem = l12;
    }
}
