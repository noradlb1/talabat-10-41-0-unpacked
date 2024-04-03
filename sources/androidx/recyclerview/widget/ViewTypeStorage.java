package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray<>();
        int mNextViewType = 0;

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            private SparseIntArray mGlobalToLocalMapping = new SparseIntArray(1);
            private SparseIntArray mLocalToGlobalMapping = new SparseIntArray(1);
            final NestedAdapterWrapper mWrapper;

            public WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            public void dispose() {
                IsolatedViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            public int globalToLocal(int i11) {
                int indexOfKey = this.mGlobalToLocalMapping.indexOfKey(i11);
                if (indexOfKey >= 0) {
                    return this.mGlobalToLocalMapping.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i11 + " does not belong to the adapter:" + this.mWrapper.adapter);
            }

            public int localToGlobal(int i11) {
                int indexOfKey = this.mLocalToGlobalMapping.indexOfKey(i11);
                if (indexOfKey > -1) {
                    return this.mLocalToGlobalMapping.valueAt(indexOfKey);
                }
                int obtainViewType = IsolatedViewTypeStorage.this.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(i11, obtainViewType);
                this.mGlobalToLocalMapping.put(obtainViewType, i11);
                return obtainViewType;
            }
        }

        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i11) {
            NestedAdapterWrapper nestedAdapterWrapper = this.mGlobalTypeToWrapper.get(i11);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        public int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
            int i11 = this.mNextViewType;
            this.mNextViewType = i11 + 1;
            this.mGlobalTypeToWrapper.put(i11, nestedAdapterWrapper);
            return i11;
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                if (this.mGlobalTypeToWrapper.valueAt(size) == nestedAdapterWrapper) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray<>();

        public class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper mWrapper;

            public WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            public void dispose() {
                SharedIdRangeViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            public int globalToLocal(int i11) {
                return i11;
            }

            public int localToGlobal(int i11) {
                List list = SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(i11);
                if (list == null) {
                    list = new ArrayList();
                    SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(i11, list);
                }
                if (!list.contains(this.mWrapper)) {
                    list.add(this.mWrapper);
                }
                return i11;
            }
        }

        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i11) {
            List list = this.mGlobalTypeToWrapper.get(i11);
            if (list != null && !list.isEmpty()) {
                return (NestedAdapterWrapper) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        public void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                List valueAt = this.mGlobalTypeToWrapper.valueAt(size);
                if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int i11);

        int localToGlobal(int i11);
    }

    @NonNull
    ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

    @NonNull
    NestedAdapterWrapper getWrapperForGlobalType(int i11);
}
