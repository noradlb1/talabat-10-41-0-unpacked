package retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final Scheduler scheduler;

    private RxJava2CallAdapterFactory(@Nullable Scheduler scheduler2, boolean z11) {
        this.scheduler = scheduler2;
        this.isAsync = z11;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory((Scheduler) null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory((Scheduler) null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        if (scheduler2 != null) {
            return new RxJava2CallAdapterFactory(scheduler2, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Type type2;
        String str;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        if (rawType == Flowable.class) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (rawType == Single.class) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (rawType == Maybe.class) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (rawType != Observable.class && !z11 && !z12 && !z13) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z11) {
                str = "Flowable";
            } else if (z12) {
                str = "Single";
            } else if (z13) {
                str = "Maybe";
            } else {
                str = "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z15 = false;
                z14 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z14 = true;
            z15 = false;
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z15 = true;
            z14 = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z15, z14, z11, z12, z13, false);
    }
}
