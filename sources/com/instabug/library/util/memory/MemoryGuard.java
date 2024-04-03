package com.instabug.library.util.memory;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.util.memory.predicate.Predicate;

public class MemoryGuard {

    /* renamed from: a  reason: collision with root package name */
    private final Context f52072a;

    private MemoryGuard(Context context) {
        this.f52072a = context;
    }

    public static MemoryGuard from(@NonNull Context context) {
        return new MemoryGuard(context);
    }

    public ActionExecutor withPredicate(@NonNull Predicate predicate) {
        predicate.setContext(this.f52072a);
        return new ActionExecutor(predicate);
    }

    public ActionExecutor withPredicates(@NonNull Predicate... predicateArr) {
        for (Predicate context : predicateArr) {
            context.setContext(this.f52072a);
        }
        return new ActionExecutor(predicateArr);
    }
}
