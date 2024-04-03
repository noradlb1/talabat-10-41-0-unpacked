package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {
    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull final Function<In, Out> function, @NonNull final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>() {

            /* renamed from: a  reason: collision with root package name */
            public Out f38127a = null;

            public void onChanged(@Nullable final In in2) {
                TaskExecutor.this.executeOnBackgroundThread(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            Out apply = function.apply(in2);
                            AnonymousClass1 r22 = AnonymousClass1.this;
                            Out out = r22.f38127a;
                            if (out == null && apply != null) {
                                r22.f38127a = apply;
                                mediatorLiveData.postValue(apply);
                            } else if (out != null && !out.equals(apply)) {
                                AnonymousClass1 r23 = AnonymousClass1.this;
                                r23.f38127a = apply;
                                mediatorLiveData.postValue(apply);
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
