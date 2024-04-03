package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", "headerId", "", "dataSize", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ZipKt$readOrSkipLocalHeader$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref.ObjectRef<Long> $createdAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastAccessedAtMillis;
    final /* synthetic */ Ref.ObjectRef<Long> $lastModifiedAtMillis;
    final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZipKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = objectRef;
        this.$lastAccessedAtMillis = objectRef2;
        this.$createdAtMillis = objectRef3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, long j11) {
        if (i11 == 21589) {
            long j12 = 1;
            if (j11 >= 1) {
                byte readByte = this.$this_readOrSkipLocalHeader.readByte() & 255;
                boolean z11 = false;
                boolean z12 = (readByte & 1) == 1;
                boolean z13 = (readByte & 2) == 2;
                if ((readByte & 4) == 4) {
                    z11 = true;
                }
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                if (z12) {
                    j12 = 5;
                }
                if (z13) {
                    j12 += 4;
                }
                if (z11) {
                    j12 += 4;
                }
                if (j11 >= j12) {
                    if (z12) {
                        this.$lastModifiedAtMillis.element = Long.valueOf(((long) bufferedSource.readIntLe()) * 1000);
                    }
                    if (z13) {
                        this.$lastAccessedAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                    }
                    if (z11) {
                        this.$createdAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.readIntLe()) * 1000);
                        return;
                    }
                    return;
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            throw new IOException("bad zip: extended timestamp extra too short");
        }
    }
}
