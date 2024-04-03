package kotlin.collections;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "", "a", "", "count", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
public final class RingBuffer$iterator$1 extends AbstractIterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RingBuffer<T> f23802b;
    private int count;
    private int index;

    public RingBuffer$iterator$1(RingBuffer<T> ringBuffer) {
        this.f23802b = ringBuffer;
        this.count = ringBuffer.size();
        this.index = ringBuffer.startIndex;
    }

    public void a() {
        if (this.count == 0) {
            b();
            return;
        }
        c(this.f23802b.buffer[this.index]);
        this.index = (this.index + 1) % this.f23802b.capacity;
        this.count--;
    }
}
