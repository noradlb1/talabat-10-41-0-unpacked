package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;
import java.io.IOException;
import pd.c;
import pd.d;

public class VideoManipulationUtils {
    public static void extractFirstVideoFrame(String str, OnVideoFrameReady onVideoFrameReady) {
        PoolProvider.postIOTask(new d(str, onVideoFrameReady));
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static long extractVideoDuration(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j11 = -1;
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                j11 = Long.parseLong(extractMetadata);
            }
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e11) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e11);
            }
        } catch (Exception e12) {
            InstabugSDKLogger.d("IBG-Core", "Error while extracting video duration" + e12);
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e13) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e13);
            }
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e14) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e14);
            }
            throw th2;
        }
        return j11;
    }

    @SuppressLint({"RESOURCE_LEAK"})
    @Nullable
    public static Bitmap extractVideoFrame(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            try {
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (IOException e11) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e11);
                return frameAtTime;
            }
        } catch (IllegalArgumentException e12) {
            InstabugSDKLogger.e("IBG-Core", "Error while extracting video frame", e12);
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e13) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e13);
            }
            return null;
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e14) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e14);
            }
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$extractFirstVideoFrame$1(String str, OnVideoFrameReady onVideoFrameReady) {
        Bitmap bitmap;
        if (new File(str).exists()) {
            bitmap = extractVideoFrame(str);
        } else {
            bitmap = null;
        }
        PoolProvider.postMainThreadTask(new c(onVideoFrameReady, bitmap));
    }
}
