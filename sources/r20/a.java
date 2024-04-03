package r20;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public final /* synthetic */ class a implements ByteUtils.ByteSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractLZ77CompressorInputStream f28170a;

    public /* synthetic */ a(AbstractLZ77CompressorInputStream abstractLZ77CompressorInputStream) {
        this.f28170a = abstractLZ77CompressorInputStream;
    }

    public final int getAsByte() {
        return this.f28170a.readOneByte();
    }
}
