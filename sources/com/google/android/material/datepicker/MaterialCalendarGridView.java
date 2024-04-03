package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void gainFocus(int i11, Rect rect) {
        if (i11 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i11 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i11, rect);
        }
    }

    private View getChildAtPosition(int i11) {
        return getChildAt(i11 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(@Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14) {
        return l11 == null || l12 == null || l13 == null || l14 == null || l13.longValue() > l12.longValue() || l14.longValue() < l11.longValue();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(@NonNull Canvas canvas) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), getFirstVisiblePosition());
        int min = Math.min(adapter.lastPositionInMonth(), getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            F f11 = next.first;
            if (f11 == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                long longValue = ((Long) f11).longValue();
                long longValue2 = ((Long) next.second).longValue();
                if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (longValue < item.longValue()) {
                        if (adapter.isFirstInRow(max)) {
                            i21 = 0;
                        } else if (!isLayoutRtl) {
                            i21 = materialCalendarGridView.getChildAtPosition(max - 1).getRight();
                        } else {
                            i21 = materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                        }
                        i11 = i21;
                        i12 = max;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        i12 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i11 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i12));
                    }
                    if (longValue2 > item2.longValue()) {
                        if (adapter.isLastInRow(min)) {
                            i19 = getWidth();
                        } else if (!isLayoutRtl) {
                            i19 = materialCalendarGridView.getChildAtPosition(min).getRight();
                        } else {
                            i19 = materialCalendarGridView.getChildAtPosition(min).getLeft();
                        }
                        i13 = i19;
                        i14 = min;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        i14 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i13 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i14));
                    }
                    int itemId = (int) adapter.getItemId(i12);
                    int i22 = max;
                    int i23 = min;
                    int itemId2 = (int) adapter.getItemId(i14);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        MonthAdapter monthAdapter = adapter;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (!isLayoutRtl) {
                            if (numColumns > i12) {
                                i16 = 0;
                            } else {
                                i16 = i11;
                            }
                            if (i14 > numColumns2) {
                                i15 = getWidth();
                            } else {
                                i15 = i13;
                            }
                        } else {
                            if (i14 > numColumns2) {
                                i17 = 0;
                            } else {
                                i17 = i13;
                            }
                            if (numColumns > i12) {
                                i18 = getWidth();
                            } else {
                                i18 = i11;
                            }
                            int i24 = i17;
                            i15 = i18;
                            i16 = i24;
                        }
                        canvas.drawRect((float) i16, (float) top, (float) i15, (float) bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        adapter = monthAdapter;
                    }
                    materialCalendarGridView = this;
                    max = i22;
                    min = i23;
                }
            }
        }
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        if (z11) {
            gainFocus(i11, rect);
        } else {
            super.onFocusChanged(false, i11, rect);
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (!super.onKeyDown(i11, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i11) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public void onMeasure(int i11, int i12) {
        if (this.nestedScrollable) {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void setSelection(int i11) {
        if (i11 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i11);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
            }
        });
    }

    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
