package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
    private static final Object sDecodeLock = new Object();
    private final Bitmap.Config mDecodeConfig;
    @GuardedBy("mLock")
    @Nullable
    private Response.Listener<Bitmap> mListener;
    private final Object mLock;
    private final int mMaxHeight;
    private final int mMaxWidth;
    private final ImageView.ScaleType mScaleType;

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i11, int i12, ImageView.ScaleType scaleType, Bitmap.Config config, @Nullable Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.mLock = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.mListener = listener;
        this.mDecodeConfig = config;
        this.mMaxWidth = i11;
        this.mMaxHeight = i12;
        this.mScaleType = scaleType;
    }

    private Response<Bitmap> doParse(NetworkResponse networkResponse) {
        Bitmap bitmap;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.mMaxWidth == 0 && this.mMaxHeight == 0) {
            options.inPreferredConfig = this.mDecodeConfig;
            bitmap = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length, options);
            int i11 = options.outWidth;
            int i12 = options.outHeight;
            int resizedDimension = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i11, i12, this.mScaleType);
            int resizedDimension2 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, i12, i11, this.mScaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i11, i12, resizedDimension, resizedDimension2);
            bitmap = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > resizedDimension || bitmap.getHeight() > resizedDimension2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, resizedDimension, resizedDimension2, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap == null) {
            return Response.error(new ParseError(networkResponse));
        }
        return Response.success(bitmap, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    @VisibleForTesting
    public static int findBestSampleSize(int i11, int i12, int i13, int i14) {
        double min = Math.min(((double) i11) / ((double) i13), ((double) i12) / ((double) i14));
        float f11 = 1.0f;
        while (true) {
            float f12 = 2.0f * f11;
            if (((double) f12) > min) {
                return (int) f11;
            }
            f11 = f12;
        }
    }

    private static int getResizedDimension(int i11, int i12, int i13, int i14, ImageView.ScaleType scaleType) {
        if (i11 == 0 && i12 == 0) {
            return i13;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            if (i11 == 0) {
                return i13;
            }
            return i11;
        } else if (i11 == 0) {
            return (int) (((double) i13) * (((double) i12) / ((double) i14)));
        } else if (i12 == 0) {
            return i11;
        } else {
            double d11 = ((double) i14) / ((double) i13);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d12 = (double) i12;
                if (((double) i11) * d11 < d12) {
                    return (int) (d12 / d11);
                }
                return i11;
            }
            double d13 = (double) i12;
            if (((double) i11) * d11 > d13) {
                return (int) (d13 / d11);
            }
            return i11;
        }
    }

    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> doParse;
        synchronized (sDecodeLock) {
            try {
                doParse = doParse(networkResponse);
            } catch (OutOfMemoryError e11) {
                VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), getUrl());
                return Response.error(new ParseError((Throwable) e11));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return doParse;
    }

    public void deliverResponse(Bitmap bitmap) {
        Response.Listener<Bitmap> listener;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(bitmap);
        }
    }

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i11, int i12, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i11, i12, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }
}
