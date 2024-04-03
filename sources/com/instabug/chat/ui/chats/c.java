package com.instabug.chat.ui.chats;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.chat.R;
import com.instabug.library.ui.custom.CircularImageView;

class c {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final TextView f46263a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final CircularImageView f46264b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final TextView f46265c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final TextView f46266d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final TextView f46267e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f46268f;

    public c(View view) {
        this.f46268f = (LinearLayout) view.findViewById(R.id.conversation_list_item_container);
        this.f46263a = (TextView) view.findViewById(R.id.instabug_txt_message_sender);
        this.f46264b = (CircularImageView) view.findViewById(R.id.instabug_message_sender_avatar);
        this.f46265c = (TextView) view.findViewById(R.id.instabug_txt_message_time);
        this.f46267e = (TextView) view.findViewById(R.id.instabug_unread_messages_count);
        this.f46266d = (TextView) view.findViewById(R.id.instabug_txt_message_snippet);
    }
}
