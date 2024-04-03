package o00;

import j$.util.function.Supplier;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sequence f27515a;

    public /* synthetic */ a(Sequence sequence) {
        this.f27515a = sequence;
    }

    public final Object get() {
        return StreamsKt.asStream$lambda$4(this.f27515a);
    }
}
