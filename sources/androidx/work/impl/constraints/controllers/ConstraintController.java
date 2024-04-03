package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback mCallback;
    private T mCurrentValue;
    private final List<String> mMatchingWorkSpecIds = new ArrayList();
    private ConstraintTracker<T> mTracker;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NonNull List<String> list);

        void onConstraintNotMet(@NonNull List<String> list);
    }

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.mTracker = constraintTracker;
    }

    private void updateCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback, @Nullable T t11) {
        if (!this.mMatchingWorkSpecIds.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t11 == null || b(t11)) {
                onConstraintUpdatedCallback.onConstraintNotMet(this.mMatchingWorkSpecIds);
            } else {
                onConstraintUpdatedCallback.onConstraintMet(this.mMatchingWorkSpecIds);
            }
        }
    }

    public abstract boolean a(@NonNull WorkSpec workSpec);

    public abstract boolean b(@NonNull T t11);

    public boolean isWorkSpecConstrained(@NonNull String str) {
        T t11 = this.mCurrentValue;
        if (t11 == null || !b(t11) || !this.mMatchingWorkSpecIds.contains(str)) {
            return false;
        }
        return true;
    }

    public void onConstraintChanged(@Nullable T t11) {
        this.mCurrentValue = t11;
        updateCallback(this.mCallback, t11);
    }

    public void replace(@NonNull Iterable<WorkSpec> iterable) {
        this.mMatchingWorkSpecIds.clear();
        for (WorkSpec next : iterable) {
            if (a(next)) {
                this.mMatchingWorkSpecIds.add(next.f38092id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener(this);
        } else {
            this.mTracker.addListener(this);
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public void reset() {
        if (!this.mMatchingWorkSpecIds.isEmpty()) {
            this.mMatchingWorkSpecIds.clear();
            this.mTracker.removeListener(this);
        }
    }

    public void setCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.mCallback != onConstraintUpdatedCallback) {
            this.mCallback = onConstraintUpdatedCallback;
            updateCallback(onConstraintUpdatedCallback, this.mCurrentValue);
        }
    }
}
