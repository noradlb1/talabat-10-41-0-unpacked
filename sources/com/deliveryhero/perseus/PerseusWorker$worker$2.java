package com.deliveryhero.perseus;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.deliveryhero.perseus.hits.PerseusWorker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/perseus/hits/PerseusWorker;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusWorker$worker$2 extends Lambda implements Function0<PerseusWorker> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f30387g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ WorkerParameters f30388h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PerseusWorker$worker$2(Context context, WorkerParameters workerParameters) {
        super(0);
        this.f30387g = context;
        this.f30388h = workerParameters;
    }

    @NotNull
    public final PerseusWorker invoke() {
        return new PerseusWorker(this.f30387g, this.f30388h);
    }
}
