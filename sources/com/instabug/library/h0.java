package com.instabug.library;

import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import java.lang.reflect.Field;

class h0 implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f50568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50569b;

    public h0(Class cls, String str) {
        this.f50568a = cls;
        this.f50569b = str;
    }

    /* renamed from: a */
    public Field execute() throws Exception {
        Field declaredField = this.f50568a.getDeclaredField(this.f50569b);
        declaredField.setAccessible(true);
        return declaredField;
    }
}
