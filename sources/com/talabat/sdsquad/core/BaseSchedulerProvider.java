package com.talabat.sdsquad.core;

import io.reactivex.Scheduler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "", "io", "Lio/reactivex/Scheduler;", "ui", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BaseSchedulerProvider {
    @NotNull
    Scheduler io();

    @NotNull
    Scheduler ui();
}
