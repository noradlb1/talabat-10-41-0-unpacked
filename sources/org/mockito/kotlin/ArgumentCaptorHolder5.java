package org.mockito.kotlin;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u00012\u00020\u0006B-\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\t\u001a\u00028\u0002\u0012\u0006\u0010\n\u001a\u00028\u0003\u0012\u0006\u0010\u000b\u001a\u00028\u0004¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0015\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0016\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0017\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0018\u001a\u00028\u0004H\u0002¢\u0006\u0002\u0010\u000eR\u0013\u0010\u000b\u001a\u00028\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\n\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0019"}, d2 = {"Lorg/mockito/kotlin/ArgumentCaptorHolder5;", "A", "B", "C", "D", "E", "", "first", "second", "third", "fourth", "fifth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFifth", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFirst", "getFourth", "getSecond", "getThird", "component1", "component2", "component3", "component4", "component5", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class ArgumentCaptorHolder5<A, B, C, D, E> {
    private final E fifth;
    private final A first;
    private final D fourth;
    private final B second;
    private final C third;

    public ArgumentCaptorHolder5(A a11, B b11, C c11, D d11, E e11) {
        this.first = a11;
        this.second = b11;
        this.third = c11;
        this.fourth = d11;
        this.fifth = e11;
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.fourth;
    }

    public final E component5() {
        return this.fifth;
    }

    public final E getFifth() {
        return this.fifth;
    }

    public final A getFirst() {
        return this.first;
    }

    public final D getFourth() {
        return this.fourth;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }
}
