package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    /* access modifiers changed from: private */
    public OnDoubleTapListener onDoubleTapListener;
    /* access modifiers changed from: private */
    public OnPeriodChangeListener onPeriodChangeListener;
    /* access modifiers changed from: private */
    public OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int i11);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int i11);
    }

    public TimePickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setUpDisplay() {
        Chip chip = this.minuteView;
        int i11 = R.id.selection_type;
        chip.setTag(i11, 12);
        this.hourView.setTag(i11, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener access$200 = TimePickerView.this.onDoubleTapListener;
                if (access$200 == null) {
                    return false;
                }
                access$200.onDoubleTap();
                return true;
            }
        });
        AnonymousClass4 r12 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(r12);
        this.hourView.setOnTouchListener(r12);
    }

    private void updateToggleConstraints() {
        boolean z11;
        if (this.toggle.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) this);
            int i11 = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = 2;
            }
            constraintSet.clear(R.id.material_clock_display, i11);
            constraintSet.applyTo(this);
        }
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (view == this && i11 == 0) {
            updateToggleConstraints();
        }
    }

    public void setActiveSelection(int i11) {
        boolean z11;
        Chip chip = this.minuteView;
        boolean z12 = true;
        if (i11 == 12) {
            z11 = true;
        } else {
            z11 = false;
        }
        chip.setChecked(z11);
        Chip chip2 = this.hourView;
        if (i11 != 10) {
            z12 = false;
        }
        chip2.setChecked(z12);
    }

    public void setAnimateOnTouchUp(boolean z11) {
        this.clockHandView.setAnimateOnTouchUp(z11);
    }

    public void setHandRotation(float f11) {
        this.clockHandView.setHandRotation(f11);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, accessibilityDelegateCompat);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.hourView, accessibilityDelegateCompat);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    public void setOnDoubleTapListener(@Nullable OnDoubleTapListener onDoubleTapListener2) {
        this.onDoubleTapListener = onDoubleTapListener2;
    }

    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener2) {
        this.onPeriodChangeListener = onPeriodChangeListener2;
    }

    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    public void setValues(String[] strArr, @StringRes int i11) {
        this.clockFace.setValues(strArr, i11);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTime(int i11, int i12, int i13) {
        int i14;
        if (i11 == 1) {
            i14 = R.id.material_clock_period_pm_button;
        } else {
            i14 = R.id.material_clock_period_am_button;
        }
        this.toggle.check(i14);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i13)});
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i12)});
        this.minuteView.setText(format);
        this.hourView.setText(format2);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHandRotation(float f11, boolean z11) {
        this.clockHandView.setHandRotation(f11, z11);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.selectionListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z11) {
                int i12;
                if (i11 == R.id.material_clock_period_pm_button) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                if (TimePickerView.this.onPeriodChangeListener != null && z11) {
                    TimePickerView.this.onPeriodChangeListener.onPeriodChange(i12);
                }
            }
        });
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.minuteView = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.hourView = chip2;
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        ViewCompat.setAccessibilityLiveRegion(chip, 2);
        ViewCompat.setAccessibilityLiveRegion(chip2, 2);
        setupDoubleTap();
        setUpDisplay();
    }
}
