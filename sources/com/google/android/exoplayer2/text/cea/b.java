package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;

public final /* synthetic */ class b implements DecoderOutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CeaDecoder f35048a;

    public /* synthetic */ b(CeaDecoder ceaDecoder) {
        this.f35048a = ceaDecoder;
    }

    public final void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
        this.f35048a.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
    }
}
