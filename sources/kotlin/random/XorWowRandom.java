package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XorWowRandom extends Random implements Serializable {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v  reason: collision with root package name */
    private int f23896v;

    /* renamed from: w  reason: collision with root package name */
    private int f23897w;

    /* renamed from: x  reason: collision with root package name */
    private int f23898x;

    /* renamed from: y  reason: collision with root package name */
    private int f23899y;

    /* renamed from: z  reason: collision with root package name */
    private int f23900z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public XorWowRandom(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f23898x = i11;
        this.f23899y = i12;
        this.f23900z = i13;
        this.f23897w = i14;
        this.f23896v = i15;
        this.addend = i16;
        int i17 = i11 | i12 | i13 | i14 | i15;
        if (i17 != 0) {
            for (int i18 = 0; i18 < 64; i18++) {
                nextInt();
            }
            return;
        }
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    public int nextBits(int i11) {
        return RandomKt.takeUpperBits(nextInt(), i11);
    }

    public int nextInt() {
        int i11 = this.f23898x;
        int i12 = i11 ^ (i11 >>> 2);
        this.f23898x = this.f23899y;
        this.f23899y = this.f23900z;
        this.f23900z = this.f23897w;
        int i13 = this.f23896v;
        this.f23897w = i13;
        int i14 = ((i12 ^ (i12 << 1)) ^ i13) ^ (i13 << 4);
        this.f23896v = i14;
        int i15 = this.addend + 362437;
        this.addend = i15;
        return i14 + i15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XorWowRandom(int r8, int r9) {
        /*
            r7 = this;
            r3 = 0
            r4 = 0
            int r5 = ~r8
            int r0 = r8 << 10
            int r1 = r9 >>> 4
            r6 = r0 ^ r1
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.XorWowRandom.<init>(int, int):void");
    }
}
