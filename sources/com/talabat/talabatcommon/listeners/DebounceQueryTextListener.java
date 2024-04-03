package com.talabat.talabatcommon.listeners;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0007J*\u0010\u001c\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/listeners/DebounceQueryTextListener;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/text/TextWatcher;", "debouncePeriod", "", "viewAction", "Lkotlin/Function1;", "", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onDebounceQueryTextChange", "afterTextAction", "Landroid/text/Editable;", "(JLkotlin/jvm/functions/Function1;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "searchJob", "Lkotlinx/coroutines/Job;", "afterTextChanged", "s", "beforeTextChanged", "", "start", "", "count", "after", "destroy", "onTextChanged", "before", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebounceQueryTextListener implements LifecycleObserver, TextWatcher {
    @Nullable
    private final Function1<Editable, Unit> afterTextAction;
    @NotNull
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final long debouncePeriod;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<String, Unit> onDebounceQueryTextChange;
    @Nullable
    private Job searchJob;
    /* access modifiers changed from: private */
    @Nullable
    public final Function1<String, Unit> viewAction;

    public DebounceQueryTextListener(long j11, @Nullable Function1<? super String, Unit> function1, @Nullable Lifecycle lifecycle, @NotNull Function1<? super String, Unit> function12, @Nullable Function1<? super Editable, Unit> function13) {
        Intrinsics.checkNotNullParameter(function12, "onDebounceQueryTextChange");
        this.debouncePeriod = j11;
        this.viewAction = function1;
        this.onDebounceQueryTextChange = function12;
        this.afterTextAction = function13;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    public void afterTextChanged(@Nullable Editable editable) {
        Function1<Editable, Unit> function1;
        if (editable != null && (function1 = this.afterTextAction) != null) {
            function1.invoke(editable);
        }
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DebounceQueryTextListener$onTextChanged$1(charSequence, this, (Continuation<? super DebounceQueryTextListener$onTextChanged$1>) null), 3, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DebounceQueryTextListener(long j11, Function1 function1, Lifecycle lifecycle, Function1 function12, Function1 function13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1000 : j11, (i11 & 2) != 0 ? null : function1, lifecycle, function12, (i11 & 16) != 0 ? null : function13);
    }
}
