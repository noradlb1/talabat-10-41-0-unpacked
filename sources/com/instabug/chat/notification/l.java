package com.instabug.chat.notification;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.instabug.chat.R;
import com.instabug.chat.model.n;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.ui.custom.CircularImageView;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;

class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f46120b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CircularImageView f46121c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f46122d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f46123e;

    public l(s sVar, View view, CircularImageView circularImageView, n nVar) {
        this.f46123e = sVar;
        this.f46120b = view;
        this.f46121c = circularImageView;
        this.f46122d = nVar;
    }

    public void run() {
        Context applicationContext = Instabug.getApplicationContext();
        this.f46123e.a(Instabug.getTheme());
        Button button = (Button) this.f46120b.findViewById(R.id.replyButton);
        Button button2 = (Button) this.f46120b.findViewById(R.id.dismissButton);
        String placeHolder = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPLIES_NOTIFICATION_REPLY_BUTTON, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(applicationContext), R.string.instabug_str_reply, applicationContext));
        if (button != null) {
            button.setText(placeHolder);
            button.setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(applicationContext), R.string.ibg_notification_reply_btn_content_description, applicationContext));
        }
        String placeHolder2 = PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.REPLIES_NOTIFICATION_DISMISS_BUTTON, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(applicationContext), R.string.instabug_str_dismiss, applicationContext));
        if (button2 != null) {
            button2.setText(placeHolder2);
            button2.setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(applicationContext), R.string.ibg_notification_dismiss_btn_content_description, applicationContext));
        }
        this.f46121c.setBackgroundResource(R.drawable.ibg_core_ic_avatar);
        TextView textView = (TextView) this.f46120b.findViewById(R.id.senderNameTextView);
        TextView textView2 = (TextView) this.f46120b.findViewById(R.id.senderMessageTextView);
        if (!(this.f46122d.c() == null || textView == null)) {
            textView.setText(this.f46122d.c());
        }
        if (this.f46122d.b() != null && textView2 != null) {
            textView2.setText(this.f46122d.b());
        }
    }
}
