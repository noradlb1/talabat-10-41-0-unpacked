package com.google.android.exoplayer2.util;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.List;

public interface FrameProcessor {
    public static final long DROP_OUTPUT_FRAME = -2;
    public static final long RELEASE_OUTPUT_FRAME_IMMEDIATELY = -1;

    public interface Factory {
        FrameProcessor create(Context context, Listener listener, List<Effect> list, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z11) throws FrameProcessingException;
    }

    public interface Listener {
        void onFrameProcessingEnded();

        void onFrameProcessingError(FrameProcessingException frameProcessingException);

        void onOutputFrameAvailable(long j11);

        void onOutputSizeChanged(int i11, int i12);
    }

    Surface getInputSurface();

    int getPendingInputFrameCount();

    void registerInputFrame();

    void release();

    void releaseOutputFrame(long j11);

    void setInputFrameInfo(FrameInfo frameInfo);

    void setOutputSurfaceInfo(@Nullable SurfaceInfo surfaceInfo);

    void signalEndOfInput();
}
