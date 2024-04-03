package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import fa.m;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Instrumented
public class ImageDownload implements Closeable {
    private static final int MAX_IMAGE_SIZE_BYTES = 1048576;
    @Nullable
    private volatile Future<?> future;
    @Nullable
    private Task<Bitmap> task;
    private final URL url;

    private ImageDownload(URL url2) {
        this.url = url2;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        URLConnection openConnection = URLConnectionInstrumentation.openConnection(this.url.openConnection());
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] byteArray = ByteStreams.toByteArray(ByteStreams.limit(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.TAG, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Downloaded ");
                    sb2.append(byteArray.length);
                    sb2.append(" bytes from ");
                    sb2.append(this.url);
                }
                if (byteArray.length <= 1048576) {
                    return byteArray;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    @Nullable
    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w(Constants.TAG, "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingDownload());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    public Bitmap blockingDownload() throws IOException {
        if (Log.isLoggable(Constants.TAG, 4)) {
            Log.i(Constants.TAG, "Starting download of: " + this.url);
        }
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Successfully downloaded image: ");
                sb2.append(this.url);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.url);
    }

    public void close() {
        this.future.cancel(true);
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.task);
    }

    public void start(ExecutorService executorService) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.future = executorService.submit(new m(this, taskCompletionSource));
        this.task = taskCompletionSource.getTask();
    }
}
