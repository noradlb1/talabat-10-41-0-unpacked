package com.talabat.darkstores.common.base;

import com.talabat.darkstores.common.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "Lcom/talabat/darkstores/common/Result;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BaseFragment$observeHandleErrors$1 extends Lambda implements Function1<Result<T>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f56103g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Result<T>, Unit> f56104h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseFragment$observeHandleErrors$1(BaseFragment baseFragment, Function1<? super Result<T>, Unit> function1) {
        super(1);
        this.f56103g = baseFragment;
        this.f56104h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result<T> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        if (result instanceof Result.Error) {
            this.f56103g.showError(((Result.Error) result).getError());
        }
        if (result instanceof Result.Success) {
            this.f56103g.hideError();
        }
        this.f56104h.invoke(result);
    }
}
