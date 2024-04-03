package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import g7.c1;
import java.nio.ByteBuffer;

public final class CameraMotionRenderer extends BaseRenderer {
    private static final int SAMPLE_WINDOW_DURATION_US = 100000;
    private static final String TAG = "CameraMotionRenderer";
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(1);
    private long lastTimestampUs;
    @Nullable
    private CameraMotionListener listener;
    private long offsetUs;
    private final ParsableByteArray scratch = new ParsableByteArray();

    public CameraMotionRenderer() {
        super(6);
    }

    @Nullable
    private float[] parseMetadata(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.scratch.reset(byteBuffer.array(), byteBuffer.limit());
        this.scratch.setPosition(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i11 = 0; i11 < 3; i11++) {
            fArr[i11] = Float.intBitsToFloat(this.scratch.readLittleEndianInt());
        }
        return fArr;
    }

    private void resetListener() {
        CameraMotionListener cameraMotionListener = this.listener;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    public String getName() {
        return TAG;
    }

    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 8) {
            this.listener = (CameraMotionListener) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        resetListener();
    }

    public void onPositionReset(long j11, boolean z11) {
        this.lastTimestampUs = Long.MIN_VALUE;
        resetListener();
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) {
        this.offsetUs = j12;
    }

    public void render(long j11, long j12) {
        while (!hasReadStreamToEnd() && this.lastTimestampUs < 100000 + j11) {
            this.buffer.clear();
            if (readSource(getFormatHolder(), this.buffer, 0) == -4 && !this.buffer.isEndOfStream()) {
                DecoderInputBuffer decoderInputBuffer = this.buffer;
                this.lastTimestampUs = decoderInputBuffer.timeUs;
                if (this.listener != null && !decoderInputBuffer.isDecodeOnly()) {
                    this.buffer.flip();
                    float[] parseMetadata = parseMetadata((ByteBuffer) Util.castNonNull(this.buffer.data));
                    if (parseMetadata != null) {
                        ((CameraMotionListener) Util.castNonNull(this.listener)).onCameraMotion(this.lastTimestampUs - this.offsetUs, parseMetadata);
                    }
                }
            } else {
                return;
            }
        }
    }

    public int supportsFormat(Format format) {
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(format.sampleMimeType)) {
            return c1.a(4);
        }
        return c1.a(0);
    }
}
