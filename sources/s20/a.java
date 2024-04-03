package s20;

import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public final /* synthetic */ class a implements ByteUtils.ByteSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FramedSnappyCompressorInputStream f28185a;

    public /* synthetic */ a(FramedSnappyCompressorInputStream framedSnappyCompressorInputStream) {
        this.f28185a = framedSnappyCompressorInputStream;
    }

    public final int getAsByte() {
        return this.f28185a.readOneByte();
    }
}
