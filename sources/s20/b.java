package s20;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream;

public final /* synthetic */ class b implements LZ77Compressor.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SnappyCompressorOutputStream f28186a;

    public /* synthetic */ b(SnappyCompressorOutputStream snappyCompressorOutputStream) {
        this.f28186a = snappyCompressorOutputStream;
    }

    public final void accept(LZ77Compressor.Block block) {
        this.f28186a.lambda$new$0(block);
    }
}
