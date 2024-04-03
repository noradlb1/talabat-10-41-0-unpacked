package com.deliveryhero.chatui.view.chatroom;

import android.view.View;
import android.widget.TextView;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatFragment$noInternetConnectionView$2 extends Lambda implements Function0<TextView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatFragment f29465g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatFragment$noInternetConnectionView$2(ChatFragment chatFragment) {
        super(0);
        this.f29465g = chatFragment;
    }

    @NotNull
    public final TextView invoke() {
        View view = this.f29465g.getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.view_no_internet_connection) : null;
        if (textView != null) {
            return textView;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
