package j$.util.stream;

import j$.util.K;
import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0224g implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseStream f29152a;

    private /* synthetic */ C0224g(BaseStream baseStream) {
        this.f29152a = baseStream;
    }

    public static /* synthetic */ BaseStream v(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C0229h ? ((C0229h) baseStream).f29154a : baseStream instanceof DoubleStream ? G.v((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof LongStream ? C0265o0.v((LongStream) baseStream) : baseStream instanceof Stream ? C0198a3.v((Stream) baseStream) : new C0224g(baseStream);
    }

    public final /* synthetic */ void close() {
        this.f29152a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0224g) {
            obj = ((C0224g) obj).f29152a;
        }
        return this.f29152a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f29152a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f29152a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f29152a.iterator();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return v(this.f29152a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return v(this.f29152a.parallel());
    }

    public final /* synthetic */ BaseStream sequential() {
        return v(this.f29152a.sequential());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return K.f(this.f29152a.spliterator());
    }

    public final /* synthetic */ BaseStream unordered() {
        return v(this.f29152a.unordered());
    }
}
