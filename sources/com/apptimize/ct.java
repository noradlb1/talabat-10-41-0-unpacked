package com.apptimize;

import java.util.Stack;

public abstract class ct<V, S> {

    /* renamed from: a  reason: collision with root package name */
    private Stack<S> f41705a;

    /* renamed from: b  reason: collision with root package name */
    private Class<V> f41706b;

    public ct(Class<V> cls, S s11) {
        Stack<S> stack = new Stack<>();
        this.f41705a = stack;
        this.f41706b = cls;
        stack.push(s11);
    }

    public abstract S a(V v11);

    public void a(cs csVar) {
        if (this.f41706b.isInstance(csVar)) {
            this.f41705a.push(a(this.f41706b.cast(csVar)));
        }
    }

    public void b(cs csVar) {
        if (this.f41706b.isInstance(csVar)) {
            this.f41705a.pop();
        }
    }

    public S a() {
        return this.f41705a.peek();
    }
}
