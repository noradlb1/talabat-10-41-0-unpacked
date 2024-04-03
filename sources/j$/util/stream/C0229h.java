package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* renamed from: j$.util.stream.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0229h implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseStream f29154a;

    private /* synthetic */ C0229h(BaseStream baseStream) {
        this.f29154a = baseStream;
    }

    public static /* synthetic */ BaseStream v(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C0224g ? ((C0224g) baseStream).f29152a : baseStream instanceof DoubleStream ? H.v((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.Wrapper.convert((IntStream) baseStream) : baseStream instanceof LongStream ? C0270p0.v((LongStream) baseStream) : baseStream instanceof Stream ? Stream.Wrapper.convert((Stream) baseStream) : new C0229h(baseStream);
    }

    public final /* synthetic */ void close() {
        this.f29154a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BaseStream baseStream = this.f29154a;
        if (obj instanceof C0229h) {
            obj = ((C0229h) obj).f29154a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f29154a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f29154a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f29154a.iterator();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return v(this.f29154a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return v(this.f29154a.parallel());
    }

    public final /* synthetic */ BaseStream sequential() {
        return v(this.f29154a.sequential());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.f29154a.spliterator());
    }

    public final /* synthetic */ BaseStream unordered() {
        return v(this.f29154a.unordered());
    }
}
