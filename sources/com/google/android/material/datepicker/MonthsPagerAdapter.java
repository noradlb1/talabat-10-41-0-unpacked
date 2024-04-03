package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final Context context;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    /* access modifiers changed from: private */
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z11) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z11) {
                textView.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(@NonNull Context context2, DateSelector<?> dateSelector2, @NonNull CalendarConstraints calendarConstraints2, MaterialCalendar.OnDayClickListener onDayClickListener2) {
        int i11;
        Month start = calendarConstraints2.getStart();
        Month end = calendarConstraints2.getEnd();
        Month openAt = calendarConstraints2.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (openAt.compareTo(end) <= 0) {
            int dayHeight = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(context2);
            if (MaterialDatePicker.isFullscreen(context2)) {
                i11 = MaterialCalendar.getDayHeight(context2);
            } else {
                i11 = 0;
            }
            this.context = context2;
            this.itemHeight = dayHeight + i11;
            this.calendarConstraints = calendarConstraints2;
            this.dateSelector = dateSelector2;
            this.onDayClickListener = onDayClickListener2;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    public long getItemId(int i11) {
        return this.calendarConstraints.getStart().monthsLater(i11).getStableId();
    }

    @NonNull
    public Month getPageMonth(int i11) {
        return this.calendarConstraints.getStart().monthsLater(i11);
    }

    @NonNull
    public CharSequence getPageTitle(int i11) {
        return getPageMonth(i11).getLongName(this.context);
    }

    public int getPosition(@NonNull Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i11) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i11);
        viewHolder.monthTitle.setText(monthsLater.getLongName(viewHolder.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                if (materialCalendarGridView.getAdapter().withinMonth(i11)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView.getAdapter().getItem(i11).longValue());
                }
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }
}
