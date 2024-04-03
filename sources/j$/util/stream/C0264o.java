package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

/* renamed from: j$.util.stream.o  reason: case insensitive filesystem */
final class C0264o implements Collector {

    /* renamed from: a  reason: collision with root package name */
    private final Supplier f29185a;

    /* renamed from: b  reason: collision with root package name */
    private final BiConsumer f29186b;

    /* renamed from: c  reason: collision with root package name */
    private final BinaryOperator f29187c;

    /* renamed from: d  reason: collision with root package name */
    private final Function f29188d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f29189e;

    C0264o(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.f29185a = supplier;
        this.f29186b = biConsumer;
        this.f29187c = binaryOperator;
        this.f29188d = function;
        this.f29189e = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    C0264o(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new C0199b(1), set);
        Set set2 = Collectors.f28907a;
    }

    public final BiConsumer accumulator() {
        return this.f29186b;
    }

    public final Set characteristics() {
        return this.f29189e;
    }

    public final BinaryOperator combiner() {
        return this.f29187c;
    }

    public final Function finisher() {
        return this.f29188d;
    }

    public final Supplier supplier() {
        return this.f29185a;
    }
}
