package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public interface ListUpdateCallback {
    void onChanged(int i11, int i12, @Nullable Object obj);

    void onInserted(int i11, int i12);

    void onMoved(int i11, int i12);

    void onRemoved(int i11, int i12);
}
