package com.deliveryhero.perseus.logger;

import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.data.remote.api.model.BackLogInfoRequest;
import io.reactivex.CompletableSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "infoRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/BackLogInfoRequest;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DatabaseInfoLogger$logBacklogInfo$2 extends Lambda implements Function1<BackLogInfoRequest, CompletableSource> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PerseusParamsConfig f30409g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DatabaseInfoLogger f30410h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatabaseInfoLogger$logBacklogInfo$2(PerseusParamsConfig perseusParamsConfig, DatabaseInfoLogger databaseInfoLogger) {
        super(1);
        this.f30409g = perseusParamsConfig;
        this.f30410h = databaseInfoLogger;
    }

    public final CompletableSource invoke(@NotNull BackLogInfoRequest backLogInfoRequest) {
        Intrinsics.checkNotNullParameter(backLogInfoRequest, "infoRequest");
        if (this.f30409g.getDebuggable()) {
            this.f30410h.logLocal(backLogInfoRequest);
        }
        return this.f30410h.logRemote(backLogInfoRequest);
    }
}
