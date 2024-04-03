package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        public class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            public WrapperStableIdLookup() {
            }

            public long localToGlobal(long j11) {
                Long l11 = this.mLocalToGlobalLookup.get(j11);
                if (l11 == null) {
                    l11 = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j11, l11);
                }
                return l11.longValue();
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        public long obtainId() {
            long j11 = this.mNextStableId;
            this.mNextStableId = 1 + j11;
            return j11;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() {
            public long localToGlobal(long j11) {
                return -1;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() {
            public long localToGlobal(long j11) {
                return j11;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j11);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
