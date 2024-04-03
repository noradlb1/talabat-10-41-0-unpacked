package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> consumerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> producerNode = new AtomicReference<>();

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue((Object) null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e11) {
            this.value = e11;
        }

        public LinkedQueueNode(E e11) {
            spValue(e11);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public LinkedQueueNode<T> a() {
        return this.consumerNode.get();
    }

    public LinkedQueueNode<T> b() {
        return this.consumerNode.get();
    }

    public LinkedQueueNode<T> c() {
        return this.producerNode.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.queue.MpscLinkedQueue.clear():void");
    }

    public void d(LinkedQueueNode<T> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    public LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return b() == c();
    }

    public boolean offer(T t11) {
        if (t11 != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t11);
            e(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public T poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode a11 = a();
        LinkedQueueNode lvNext2 = a11.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        } else if (a11 == c()) {
            return null;
        } else {
            do {
                lvNext = a11.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            d(lvNext);
            return andNullValue2;
        }
    }

    public boolean offer(T t11, T t12) {
        offer(t11);
        offer(t12);
        return true;
    }
}
