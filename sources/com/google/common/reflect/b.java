package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Types.JavaVersion f44699b;

    public /* synthetic */ b(Types.JavaVersion javaVersion) {
        this.f44699b = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.f44699b.typeName((Type) obj);
    }
}
