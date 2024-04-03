package com.talabat.location.domain.tasks;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005H&J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0005H&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/location/domain/tasks/Task;", "TResult", "", "addOnFailureListener", "onFailure", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "addOnSuccessListener", "onSuccess", "isSuccessful", "", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Task<TResult> {
    @NotNull
    Task<TResult> addOnFailureListener(@NotNull Function1<? super Exception, Unit> function1);

    @NotNull
    Task<TResult> addOnSuccessListener(@NotNull Function1<? super TResult, Unit> function1);

    boolean isSuccessful();
}
