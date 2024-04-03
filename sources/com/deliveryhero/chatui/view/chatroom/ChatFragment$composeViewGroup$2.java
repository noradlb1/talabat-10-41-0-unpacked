package com.deliveryhero.chatui.view.chatroom;

import android.view.View;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$composeViewGroup$2 extends Lambda implements Function0<View> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29454g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$composeViewGroup$2(ChatFragment chatFragment) {
        super(0);
        this.f29454g = chatFragment;
    }

    @NotNull
    public final View invoke() {
        View view = this.f29454g.getView();
        View findViewById = view != null ? view.findViewById(R.id.layout_compose) : null;
        if (findViewById != null) {
            return findViewById;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
