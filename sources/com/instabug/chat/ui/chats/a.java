package com.instabug.chat.ui.chats;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.chat.R;

class a extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46259c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f46260d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d f46261e;

    public a(d dVar, int i11, View view) {
        this.f46261e = dVar;
        this.f46259c = i11;
        this.f46260d = view;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        String str;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.f46261e.getItem(this.f46259c).i() != null) {
            str = String.format(this.f46261e.a(R.string.ibg_chat_conversation_with_name_content_description, this.f46260d.getContext()), new Object[]{this.f46261e.getItem(this.f46259c).i()});
        } else {
            str = this.f46261e.a(R.string.ibg_chat_conversation_content_description, this.f46260d.getContext());
        }
        accessibilityNodeInfoCompat.setContentDescription(str);
    }
}
