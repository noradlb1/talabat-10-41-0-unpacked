package com.adyen.checkout.ui.internal.common.util.image;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.image.RequestArgs;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Rembrandt {
    private static Rembrandt sInstance;
    private final Application mApplication;
    private final ExecutorService mBackgroundExecutorService = Executors.newFixedThreadPool(10);

    private Rembrandt(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    public static RequestArgs createDefaultLogoRequestArgs(@NonNull Application application, @NonNull Callable<Drawable> callable) {
        return get(application).load(DrawablePreProcessor.wrapCallable(application, callable)).placeholder(R.drawable.ic_image_24dp).error(R.drawable.ic_broken_image_24dp).build();
    }

    @NonNull
    public static synchronized Rembrandt get(@NonNull Application application) {
        Rembrandt rembrandt;
        synchronized (Rembrandt.class) {
            if (sInstance == null) {
                sInstance = new Rembrandt(application);
            }
            rembrandt = sInstance;
        }
        return rembrandt;
    }

    @NonNull
    public Application a() {
        return this.mApplication;
    }

    public void b(@NonNull Request request) {
        this.mBackgroundExecutorService.submit(request);
    }

    @NonNull
    public RequestArgs.Builder load(@NonNull Callable<Drawable> callable) {
        return RequestArgs.newBuilder(this, callable);
    }
}
