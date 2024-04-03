package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public List<UUID> f37991a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public List<String> f37992b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<String> f37993c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public List<WorkInfo.State> f37994d = new ArrayList();

        private Builder() {
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public static Builder fromIds(@NonNull List<UUID> list) {
            Builder builder = new Builder();
            builder.addIds(list);
            return builder;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public static Builder fromStates(@NonNull List<WorkInfo.State> list) {
            Builder builder = new Builder();
            builder.addStates(list);
            return builder;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public static Builder fromTags(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addTags(list);
            return builder;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public static Builder fromUniqueWorkNames(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addUniqueWorkNames(list);
            return builder;
        }

        @NonNull
        public Builder addIds(@NonNull List<UUID> list) {
            this.f37991a.addAll(list);
            return this;
        }

        @NonNull
        public Builder addStates(@NonNull List<WorkInfo.State> list) {
            this.f37994d.addAll(list);
            return this;
        }

        @NonNull
        public Builder addTags(@NonNull List<String> list) {
            this.f37993c.addAll(list);
            return this;
        }

        @NonNull
        public Builder addUniqueWorkNames(@NonNull List<String> list) {
            this.f37992b.addAll(list);
            return this;
        }

        @NonNull
        public WorkQuery build() {
            if (!this.f37991a.isEmpty() || !this.f37992b.isEmpty() || !this.f37993c.isEmpty() || !this.f37994d.isEmpty()) {
                return new WorkQuery(this);
            }
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        }
    }

    public WorkQuery(@NonNull Builder builder) {
        this.mIds = builder.f37991a;
        this.mUniqueWorkNames = builder.f37992b;
        this.mTags = builder.f37993c;
        this.mStates = builder.f37994d;
    }

    @NonNull
    public List<UUID> getIds() {
        return this.mIds;
    }

    @NonNull
    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    @NonNull
    public List<String> getTags() {
        return this.mTags;
    }

    @NonNull
    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }
}
