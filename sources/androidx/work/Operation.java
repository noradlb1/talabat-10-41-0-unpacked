package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;

public interface Operation {
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.IN_PROGRESS IN_PROGRESS = new State.IN_PROGRESS();
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.SUCCESS SUCCESS = new State.SUCCESS();

    public static abstract class State {

        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public FAILURE(@NonNull Throwable th2) {
                this.mThrowable = th2;
            }

            @NonNull
            public Throwable getThrowable() {
                return this.mThrowable;
            }

            @NonNull
            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.mThrowable.getMessage()});
            }
        }

        public static final class IN_PROGRESS extends State {
            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        public static final class SUCCESS extends State {
            @NonNull
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }
    }

    @NonNull
    ListenableFuture<State.SUCCESS> getResult();

    @NonNull
    LiveData<State> getState();
}
