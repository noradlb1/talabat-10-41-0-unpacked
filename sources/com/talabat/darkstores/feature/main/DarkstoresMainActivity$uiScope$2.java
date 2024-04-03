package com.talabat.darkstores.feature.main;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMainActivity$uiScope$2 extends Lambda implements Function0<CoroutineScope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56459g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$uiScope$2(DarkstoresMainActivity darkstoresMainActivity) {
        super(0);
        this.f56459g = darkstoresMainActivity;
    }

    @NotNull
    public final CoroutineScope invoke() {
        return CoroutineScopeKt.CoroutineScope(this.f56459g.getCoroutineDispatchersFactory().main().plus(JobKt.Job$default((Job) null, 1, (Object) null)));
    }
}
