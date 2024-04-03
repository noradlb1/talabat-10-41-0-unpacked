package com.instabug.library;

import androidx.annotation.Nullable;
import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import java.lang.reflect.Field;

class i0 implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f50571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f50572b;

    public i0(Field field, Object obj) {
        this.f50571a = field;
        this.f50572b = obj;
    }

    @Nullable
    public Object execute() throws Exception {
        return this.f50571a.get(this.f50572b);
    }
}
