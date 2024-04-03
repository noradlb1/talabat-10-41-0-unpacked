package com.deliveryhero.chatui.domain;

import com.deliveryhero.chatui.domain.UploadPhotoStatus;
import com.deliveryhero.contract.model.BaseMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "fileMessage", "Lcom/deliveryhero/contract/model/BaseMessage;", "error", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UploadImageUseCase$execute$2 extends Lambda implements Function2<BaseMessage, Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<UploadPhotoStatus, Unit> f29402g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadImageUseCase$execute$2(Function1<? super UploadPhotoStatus, Unit> function1) {
        super(2);
        this.f29402g = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((BaseMessage) obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BaseMessage baseMessage, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        this.f29402g.invoke(new UploadPhotoStatus.Error(baseMessage, th2));
    }
}
