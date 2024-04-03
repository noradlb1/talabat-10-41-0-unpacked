package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@Instrumented
public class BitmapWorkerTask extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    @DrawableRes

    /* renamed from: b  reason: collision with root package name */
    public int f52043b;
    private final WeakReference<ImageView> imageViewReference;
    @Nullable
    private OnImageLoadedListener onImageLoadedListener;
    private boolean resize;
    private float targetHeight;
    private float targetWidth;

    public interface OnImageLoadedListener {
        void onImageLoaded();
    }

    public BitmapWorkerTask(ImageView imageView) {
        this.imageViewReference = new WeakReference<>(imageView);
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Bitmap a(String... strArr) {
        try {
            Bitmap decodeSampledBitmapFromLocalPath = BitmapUtils.decodeSampledBitmapFromLocalPath(strArr[0]);
            if (this.resize) {
                return BitmapUtils.resizeBitmap(decodeSampledBitmapFromLocalPath, this.targetWidth, this.targetHeight);
            }
            return decodeSampledBitmapFromLocalPath;
        } catch (Exception | OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while loading bitmap", e11);
            return null;
        }
    }

    public void b(@Nullable Bitmap bitmap) {
        ImageView imageView = this.imageViewReference.get();
        if (bitmap != null) {
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                OnImageLoadedListener onImageLoadedListener2 = this.onImageLoadedListener;
                if (onImageLoadedListener2 != null) {
                    onImageLoadedListener2.onImageLoaded();
                }
            }
        } else if (imageView != null) {
            try {
                imageView.setImageResource(this.f52043b);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while loading image resource", e11);
            }
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BitmapWorkerTask#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BitmapWorkerTask#doInBackground", (ArrayList<String>) null);
        }
        Bitmap a11 = a((String[]) objArr);
        TraceMachine.exitMethod();
        return a11;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(@Nullable Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BitmapWorkerTask#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BitmapWorkerTask#onPostExecute", (ArrayList<String>) null);
        }
        b((Bitmap) obj);
        TraceMachine.exitMethod();
    }

    public BitmapWorkerTask(ImageView imageView, @DrawableRes int i11) {
        this.imageViewReference = new WeakReference<>(imageView);
        this.f52043b = i11;
    }

    public BitmapWorkerTask(ImageView imageView, float f11, float f12) {
        this(imageView);
        this.targetWidth = f11;
        this.targetHeight = f12;
        this.resize = true;
    }

    public BitmapWorkerTask(ImageView imageView, @Nullable OnImageLoadedListener onImageLoadedListener2) {
        this(imageView);
        this.onImageLoadedListener = onImageLoadedListener2;
    }

    public BitmapWorkerTask(ImageView imageView, float f11, float f12, @Nullable OnImageLoadedListener onImageLoadedListener2) {
        this(imageView, f11, f12);
        this.onImageLoadedListener = onImageLoadedListener2;
    }
}
