package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SentMessageViewHolder$messageIndicatorIcon$2 extends Lambda implements Function0<ImageView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f29677g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SentMessageViewHolder$messageIndicatorIcon$2(View view) {
        super(0);
        this.f29677g = view;
    }

    @NotNull
    public final ImageView invoke() {
        View findViewById = this.f29677g.findViewById(R.id.icon_message_received_indicator);
        if (findViewById != null) {
            return (ImageView) findViewById;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }
}
