package com.instabug.library;

import androidx.annotation.Nullable;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import java.lang.reflect.Method;

class j0 implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f50573a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50574b;

    public j0(Class cls, String str) {
        this.f50573a = cls;
        this.f50574b = str;
    }

    @Nullable
    /* renamed from: a */
    public Method execute() {
        for (Method method : this.f50573a.getDeclaredMethods()) {
            if (method.getName().equals(this.f50574b)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
