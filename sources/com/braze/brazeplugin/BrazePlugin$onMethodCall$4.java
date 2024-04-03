package com.braze.brazeplugin;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "user", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BrazePlugin$onMethodCall$4 extends Lambda implements Function1<BrazeUser, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f43638g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f43639h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazePlugin$onMethodCall$4(String str, String str2) {
        super(1);
        this.f43638g = str;
        this.f43639h = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "user");
        brazeUser.setCustomUserAttribute(this.f43638g, this.f43639h);
    }
}
