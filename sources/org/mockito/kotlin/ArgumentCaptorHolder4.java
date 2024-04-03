package org.mockito.kotlin;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u00012\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\fR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lorg/mockito/kotlin/ArgumentCaptorHolder4;", "A", "B", "C", "D", "", "first", "second", "third", "fourth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFourth", "getSecond", "getThird", "component1", "component2", "component3", "component4", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class ArgumentCaptorHolder4<A, B, C, D> {
    private final A first;
    private final D fourth;
    private final B second;
    private final C third;

    public ArgumentCaptorHolder4(A a11, B b11, C c11, D d11) {
        this.first = a11;
        this.second = b11;
        this.third = c11;
        this.fourth = d11;
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
