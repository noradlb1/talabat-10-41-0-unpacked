package com.talabat.core.gms.location.data;

import com.talabat.location.domain.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wg.a;
import wg.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\bH\u0016J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/core/gms/location/data/GmsTaskWrapper;", "T", "Lcom/talabat/location/domain/tasks/Task;", "googleTask", "Lcom/google/android/gms/tasks/Task;", "(Lcom/google/android/gms/tasks/Task;)V", "addOnFailureListener", "onFailure", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "addOnSuccessListener", "onSuccess", "isSuccessful", "", "com_talabat_core_gms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GmsTaskWrapper<T> implements Task<T> {
    @NotNull
    private final com.google.android.gms.tasks.Task<T> googleTask;

    public GmsTaskWrapper(@NotNull com.google.android.gms.tasks.Task<T> task) {
        Intrinsics.checkNotNullParameter(task, "googleTask");
        this.googleTask = task;
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnFailureListener$lambda-1  reason: not valid java name */
    public static final void m9593addOnFailureListener$lambda1(Function1 function1, Exception exc) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        Intrinsics.checkNotNullParameter(exc, "p0");
        function1.invoke(exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnSuccessListener$lambda-0  reason: not valid java name */
    public static final void m9594addOnSuccessListener$lambda0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    @NotNull
    public Task<T> addOnFailureListener(@NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFailure");
        com.google.android.gms.tasks.Task<T> addOnFailureListener = this.googleTask.addOnFailureListener(new b(function1));
        Intrinsics.checkNotNullExpressionValue(addOnFailureListener, "googleTask.addOnFailureListener(onFailure)");
        return new GmsTaskWrapper(addOnFailureListener);
    }

    @NotNull
    public Task<T> addOnSuccessListener(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        com.google.android.gms.tasks.Task<T> addOnSuccessListener = this.googleTask.addOnSuccessListener(new a(function1));
        Intrinsics.checkNotNullExpressionValue(addOnSuccessListener, "googleTask.addOnSuccessListener(onSuccess)");
        return new GmsTaskWrapper(addOnSuccessListener);
    }

    public boolean isSuccessful() {
        return this.googleTask.isSuccessful();
    }
}
