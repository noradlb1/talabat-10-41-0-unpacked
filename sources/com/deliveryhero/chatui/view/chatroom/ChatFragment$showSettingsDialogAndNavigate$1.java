package com.deliveryhero.chatui.view.chatroom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$showSettingsDialogAndNavigate$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f29491g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29492h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$showSettingsDialogAndNavigate$1(Context context, ChatFragment chatFragment) {
        super(0);
        this.f29491g = context;
        this.f29492h = chatFragment;
    }

    public final void invoke() {
        this.f29492h.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.f29491g.getPackageName())));
    }
}
