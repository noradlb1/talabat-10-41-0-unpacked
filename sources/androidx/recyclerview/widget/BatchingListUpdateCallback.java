package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;
    int mLastEventPosition = -1;
    int mLastEventType = 0;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i11 = this.mLastEventType;
        if (i11 != 0) {
            if (i11 == 1) {
                this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
            } else if (i11 == 2) {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            } else if (i11 == 3) {
                this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
            }
            this.mLastEventPayload = null;
            this.mLastEventType = 0;
        }
    }

    public void onChanged(int i11, int i12, Object obj) {
        int i13;
        if (this.mLastEventType == 3) {
            int i14 = this.mLastEventPosition;
            int i15 = this.mLastEventCount;
            if (i11 <= i14 + i15 && (i13 = i11 + i12) >= i14 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i11, i14);
                this.mLastEventCount = Math.max(i15 + i14, i13) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i11;
        this.mLastEventCount = i12;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    public void onInserted(int i11, int i12) {
        int i13;
        if (this.mLastEventType == 1 && i11 >= (i13 = this.mLastEventPosition)) {
            int i14 = this.mLastEventCount;
            if (i11 <= i13 + i14) {
                this.mLastEventCount = i14 + i12;
                this.mLastEventPosition = Math.min(i11, i13);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i11;
        this.mLastEventCount = i12;
        this.mLastEventType = 1;
    }

    public void onMoved(int i11, int i12) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i11, i12);
    }

    public void onRemoved(int i11, int i12) {
        int i13;
        if (this.mLastEventType != 2 || (i13 = this.mLastEventPosition) < i11 || i13 > i11 + i12) {
            dispatchLastEvent();
            this.mLastEventPosition = i11;
            this.mLastEventCount = i12;
            this.mLastEventType = 2;
            return;
        }
        this.mLastEventCount += i12;
        this.mLastEventPosition = i11;
    }
}
