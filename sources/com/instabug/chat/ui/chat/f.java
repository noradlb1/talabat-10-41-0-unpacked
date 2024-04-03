package com.instabug.chat.ui.chat;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.chat.R;

class f extends AccessibilityDelegateCompat {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f46201c;

    public f(i iVar) {
        this.f46201c = iVar;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        String str;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (this.f46201c.f46225d != null) {
            i iVar = this.f46201c;
            str = iVar.getLocalizedString(R.string.ibg_chat_conversation_with_name_content_description, iVar.f46225d);
        } else {
            str = this.f46201c.getLocalizedString(R.string.ibg_chat_conversation_content_description);
        }
        accessibilityNodeInfoCompat.setContentDescription(str);
    }
}
