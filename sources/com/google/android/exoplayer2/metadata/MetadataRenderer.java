package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import g7.c1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_INVOKE_RENDERER = 0;
    private static final String TAG = "MetadataRenderer";
    private final MetadataInputBuffer buffer;
    @Nullable
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    @Nullable
    private final Handler outputHandler;
    private final boolean outputMetadataEarly;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    @Nullable
    private Metadata pendingMetadata;
    private long subsampleOffsetUs;

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    private void decodeWrappedMetadata(Metadata metadata, List<Metadata.Entry> list) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Format wrappedMetadataFormat = metadata.get(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.decoderFactory.supportsFormat(wrappedMetadataFormat)) {
                list.add(metadata.get(i11));
            } else {
                MetadataDecoder createDecoder = this.decoderFactory.createDecoder(wrappedMetadataFormat);
                byte[] bArr = (byte[]) Assertions.checkNotNull(metadata.get(i11).getWrappedMetadataBytes());
                this.buffer.clear();
                this.buffer.ensureSpaceForWrite(bArr.length);
                ((ByteBuffer) Util.castNonNull(this.buffer.data)).put(bArr);
                this.buffer.flip();
                Metadata decode = createDecoder.decode(this.buffer);
                if (decode != null) {
                    decodeWrappedMetadata(decode, list);
                }
            }
        }
    }

    @SideEffectFree
    private long getPresentationTimeUs(long j11) {
        boolean z11;
        boolean z12 = true;
        if (j11 != C.TIME_UNSET) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            z12 = false;
        }
        Assertions.checkState(z12);
        return j11 - this.outputStreamOffsetUs;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    private boolean outputMetadata(long j11) {
        boolean z11;
        Metadata metadata = this.pendingMetadata;
        if (metadata == null || (!this.outputMetadataEarly && metadata.presentationTimeUs > getPresentationTimeUs(j11))) {
            z11 = false;
        } else {
            invokeRenderer(this.pendingMetadata);
            this.pendingMetadata = null;
            z11 = true;
        }
        if (this.inputStreamEnded && this.pendingMetadata == null) {
            this.outputStreamEnded = true;
        }
        return z11;
    }

    private void readMetadata() {
        if (!this.inputStreamEnded && this.pendingMetadata == null) {
            this.buffer.clear();
            FormatHolder formatHolder = getFormatHolder();
            int readSource = readSource(formatHolder, this.buffer, 0);
            if (readSource == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                    return;
                }
                MetadataInputBuffer metadataInputBuffer = this.buffer;
                metadataInputBuffer.subsampleOffsetUs = this.subsampleOffsetUs;
                metadataInputBuffer.flip();
                Metadata decode = ((MetadataDecoder) Util.castNonNull(this.decoder)).decode(this.buffer);
                if (decode != null) {
                    ArrayList arrayList = new ArrayList(decode.length());
                    decodeWrappedMetadata(decode, arrayList);
                    if (!arrayList.isEmpty()) {
                        this.pendingMetadata = new Metadata(getPresentationTimeUs(this.buffer.timeUs), (List<? extends Metadata.Entry>) arrayList);
                    }
                }
            } else if (readSource == -5) {
                this.subsampleOffsetUs = ((Format) Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
            }
        }
    }

    public String getName() {
        return TAG;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeRendererInternal((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.pendingMetadata = null;
        this.decoder = null;
        this.outputStreamOffsetUs = C.TIME_UNSET;
    }

    public void onPositionReset(long j11, boolean z11) {
        this.pendingMetadata = null;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
        Metadata metadata = this.pendingMetadata;
        if (metadata != null) {
            this.pendingMetadata = metadata.copyWithPresentationTimeUs((metadata.presentationTimeUs + this.outputStreamOffsetUs) - j12);
        }
        this.outputStreamOffsetUs = j12;
    }

    public void render(long j11, long j12) {
        boolean z11 = true;
        while (z11) {
            readMetadata();
            z11 = outputMetadata(j11);
        }
    }

    public int supportsFormat(Format format) {
        int i11;
        if (!this.decoderFactory.supportsFormat(format)) {
            return c1.a(0);
        }
        if (format.cryptoType == 0) {
            i11 = 4;
        } else {
            i11 = 2;
        }
        return c1.a(i11);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        this(metadataOutput, looper, metadataDecoderFactory, false);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory, boolean z11) {
        super(5);
        Handler handler;
        this.output = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.outputMetadataEarly = z11;
        this.buffer = new MetadataInputBuffer();
        this.outputStreamOffsetUs = C.TIME_UNSET;
    }
}
