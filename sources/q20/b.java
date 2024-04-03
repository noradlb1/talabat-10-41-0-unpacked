package q20;

import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public final /* synthetic */ class b implements ByteUtils.ByteSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FramedLZ4CompressorInputStream f28158a;

    public /* synthetic */ b(FramedLZ4CompressorInputStream framedLZ4CompressorInputStream) {
        this.f28158a = framedLZ4CompressorInputStream;
    }

    public final int getAsByte() {
        return this.f28158a.readOneByte();
    }
}
