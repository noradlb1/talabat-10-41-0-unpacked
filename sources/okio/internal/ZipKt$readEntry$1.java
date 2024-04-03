package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", "headerId", "", "dataSize", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ZipKt$readEntry$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.LongRef $compressedSize;
    final /* synthetic */ Ref.BooleanRef $hasZip64Extra;
    final /* synthetic */ Ref.LongRef $offset;
    final /* synthetic */ long $requiredZip64ExtraSize;
    final /* synthetic */ Ref.LongRef $size;
    final /* synthetic */ BufferedSource $this_readEntry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZipKt$readEntry$1(Ref.BooleanRef booleanRef, long j11, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3) {
        super(2);
        this.$hasZip64Extra = booleanRef;
        this.$requiredZip64ExtraSize = j11;
        this.$size = longRef;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = longRef2;
        this.$offset = longRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, long j11) {
        if (i11 == 1) {
            Ref.BooleanRef booleanRef = this.$hasZip64Extra;
            if (!booleanRef.element) {
                booleanRef.element = true;
                if (j11 >= this.$requiredZip64ExtraSize) {
                    Ref.LongRef longRef = this.$size;
                    long j12 = longRef.element;
                    if (j12 == 4294967295L) {
                        j12 = this.$this_readEntry.readLongLe();
                    }
                    longRef.element = j12;
                    Ref.LongRef longRef2 = this.$compressedSize;
                    long j13 = 0;
                    longRef2.element = longRef2.element == 4294967295L ? this.$this_readEntry.readLongLe() : 0;
                    Ref.LongRef longRef3 = this.$offset;
                    if (longRef3.element == 4294967295L) {
                        j13 = this.$this_readEntry.readLongLe();
                    }
                    longRef3.element = j13;
                    return;
                }
                throw new IOException("bad zip: zip64 extra too short");
            }
            throw new IOException("bad zip: zip64 extra repeated");
        }
    }
}
