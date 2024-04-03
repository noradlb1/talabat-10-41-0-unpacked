package q20;

import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public final /* synthetic */ class a implements LZ77Compressor.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BlockLZ4CompressorOutputStream f28157a;

    public /* synthetic */ a(BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream) {
        this.f28157a = blockLZ4CompressorOutputStream;
    }

    public final void accept(LZ77Compressor.Block block) {
        this.f28157a.lambda$new$0(block);
    }
}
