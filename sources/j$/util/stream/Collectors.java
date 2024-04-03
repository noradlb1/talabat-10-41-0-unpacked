package j$.util.stream;

import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Collectors {

    /* renamed from: a  reason: collision with root package name */
    static final Set f28907a;

    /* renamed from: b  reason: collision with root package name */
    static final Set f28908b;

    /* renamed from: c  reason: collision with root package name */
    static final Set f28909c = Collections.emptySet();

    static {
        C0234i iVar = C0234i.CONCURRENT;
        C0234i iVar2 = C0234i.UNORDERED;
        C0234i iVar3 = C0234i.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(iVar, iVar2, iVar3));
        Collections.unmodifiableSet(EnumSet.of(iVar, iVar2));
        f28907a = Collections.unmodifiableSet(EnumSet.of(iVar3));
        f28908b = Collections.unmodifiableSet(EnumSet.of(iVar2, iVar3));
        Collections.unmodifiableSet(EnumSet.of(iVar2));
    }

    static void a(double[] dArr, double d11) {
        double d12 = d11 - dArr[1];
        double d13 = dArr[0];
        double d14 = d13 + d12;
        dArr[1] = (d14 - d13) - d12;
        dArr[0] = d14;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [j$.util.function.Function, j$.util.function.Function<R, RR>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, A, R, RR> j$.util.stream.Collector<T, A, RR> collectingAndThen(j$.util.stream.Collector<T, A, R> r7, j$.util.function.Function<R, RR> r8) {
        /*
            java.util.Set r0 = r7.characteristics()
            j$.util.stream.i r1 = j$.util.stream.C0234i.IDENTITY_FINISH
            boolean r2 = r0.contains(r1)
            if (r2 == 0) goto L_0x0021
            int r2 = r0.size()
            r3 = 1
            if (r2 != r3) goto L_0x0016
            java.util.Set r0 = f28909c
            goto L_0x0021
        L_0x0016:
            java.util.EnumSet r0 = java.util.EnumSet.copyOf(r0)
            r0.remove(r1)
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
        L_0x0021:
            r6 = r0
            j$.util.stream.o r0 = new j$.util.stream.o
            j$.util.function.Supplier r2 = r7.supplier()
            j$.util.function.BiConsumer r3 = r7.accumulator()
            j$.util.function.BinaryOperator r4 = r7.combiner()
            j$.util.function.Function r7 = r7.finisher()
            j$.util.function.Function r5 = r7.andThen(r8)
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Collectors.collectingAndThen(j$.util.stream.Collector, j$.util.function.Function):j$.util.stream.Collector");
    }

    public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> function, Supplier<M> supplier, Collector<? super T, A, D> collector) {
        C0254m mVar = new C0254m(function, collector.supplier(), collector.accumulator());
        C0288t tVar = new C0288t(3, collector.combiner());
        if (collector.characteristics().contains(C0234i.IDENTITY_FINISH)) {
            return new C0264o(supplier, mVar, tVar, f28907a);
        }
        return new C0264o(supplier, mVar, tVar, new C0259n(collector.finisher()), f28909c);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return joining(charSequence, "", "");
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new C0264o(new C0254m(charSequence, charSequence2, charSequence3), new N0(11), new C0249l(8), new N0(12), f28909c);
    }

    public static <T> Collector<T, ?, Long> summingLong(ToLongFunction<? super T> toLongFunction) {
        return new C0264o(new C0199b(2), new C0194a(3, toLongFunction), new C0249l(3), new C0199b(3), f28909c);
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> supplier) {
        return new C0264o(supplier, new N0(7), new C0249l(0), f28907a);
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new C0264o(new N0(15), new N0(16), new C0249l(1), f28907a);
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new C0264o(new N0(9), new N0(10), new C0249l(2), f28908b);
    }
}
