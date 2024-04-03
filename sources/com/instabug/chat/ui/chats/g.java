package com.instabug.chat.ui.chats;

import com.instabug.chat.R;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f46270b;

    public g(h hVar) {
        this.f46270b = hVar;
    }

    public void run() {
        if (this.f46270b.getView() != null) {
            this.f46270b.getView().announceForAccessibility(this.f46270b.getLocalizedString(R.string.ibg_chats_conversations_screen_content_description));
        }
    }
}
