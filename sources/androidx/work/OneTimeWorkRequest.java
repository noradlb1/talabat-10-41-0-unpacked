package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f37997c.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        @NonNull
        /* renamed from: c */
        public OneTimeWorkRequest a() {
            if (!this.f37995a || !this.f37997c.constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        @NonNull
        /* renamed from: d */
        public Builder b() {
            return this;
        }

        @NonNull
        public Builder setInputMerger(@NonNull Class<? extends InputMerger> cls) {
            this.f37997c.inputMergerClassName = cls.getName();
            return this;
        }
    }

    public OneTimeWorkRequest(Builder builder) {
        super(builder.f37996b, builder.f37997c, builder.f37998d);
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> cls) {
        return (OneTimeWorkRequest) new Builder(cls).build();
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<? extends ListenableWorker> builder : list) {
            arrayList.add((OneTimeWorkRequest) new Builder(builder).build());
        }
        return arrayList;
    }
}
