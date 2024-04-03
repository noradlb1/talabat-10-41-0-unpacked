package com.instabug.chat.ui.chats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import com.instabug.chat.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.LocaleUtils;
import java.util.List;

class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List f46269a;

    public d(List list) {
        this.f46269a = list;
    }

    private String a(Context context, @StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), i11, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, com.instabug.chat.ui.chats.c r9, com.instabug.chat.model.d r10) {
        /*
            r7 = this;
            java.util.ArrayList r0 = r10.f()
            com.instabug.chat.model.h r1 = new com.instabug.chat.model.h
            r1.<init>()
            java.util.Collections.sort(r0, r1)
            com.instabug.chat.model.k r0 = r10.b()
            java.lang.String r1 = "null"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0048
            java.lang.String r4 = r0.c()
            if (r4 == 0) goto L_0x0048
            java.lang.String r4 = r0.c()
            java.lang.String r4 = r4.trim()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = r0.c()
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0035
            goto L_0x0048
        L_0x0035:
            android.widget.TextView r4 = r9.f46266d
            if (r4 == 0) goto L_0x00e5
            android.widget.TextView r4 = r9.f46266d
            java.lang.String r5 = r0.c()
        L_0x0043:
            r4.setText(r5)
            goto L_0x00e5
        L_0x0048:
            if (r0 == 0) goto L_0x00e5
            java.util.ArrayList r4 = r0.b()
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00e5
            java.util.ArrayList r4 = r0.b()
            java.util.ArrayList r5 = r0.b()
            int r5 = r5.size()
            int r5 = r5 - r3
            java.lang.Object r4 = r4.get(r5)
            com.instabug.chat.model.a r4 = (com.instabug.chat.model.a) r4
            java.lang.String r4 = r4.f()
            if (r4 == 0) goto L_0x00e5
            android.widget.TextView r5 = r9.f46266d
            if (r5 == 0) goto L_0x00e5
            int r5 = r4.hashCode()
            r6 = -1
            switch(r5) {
                case -831439762: goto L_0x00b3;
                case 93166550: goto L_0x00a8;
                case 112202875: goto L_0x009d;
                case 1698911340: goto L_0x0092;
                case 1710800780: goto L_0x0087;
                case 1830389646: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x00bd
        L_0x007c:
            java.lang.String r5 = "video_gallery"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0085
            goto L_0x00bd
        L_0x0085:
            r6 = 5
            goto L_0x00bd
        L_0x0087:
            java.lang.String r5 = "extra_video"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0090
            goto L_0x00bd
        L_0x0090:
            r6 = 4
            goto L_0x00bd
        L_0x0092:
            java.lang.String r5 = "extra_image"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009b
            goto L_0x00bd
        L_0x009b:
            r6 = 3
            goto L_0x00bd
        L_0x009d:
            java.lang.String r5 = "video"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00a6
            goto L_0x00bd
        L_0x00a6:
            r6 = 2
            goto L_0x00bd
        L_0x00a8:
            java.lang.String r5 = "audio"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00b1
            goto L_0x00bd
        L_0x00b1:
            r6 = r3
            goto L_0x00bd
        L_0x00b3:
            java.lang.String r5 = "image_gallery"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r6 = r2
        L_0x00bd:
            switch(r6) {
                case 0: goto L_0x00d3;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00d3;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00c1;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            goto L_0x00e5
        L_0x00c1:
            android.widget.TextView r4 = r9.f46266d
            com.instabug.library.InstabugCustomTextPlaceHolder$Key r5 = com.instabug.library.InstabugCustomTextPlaceHolder.Key.CHATS_TYPE_VIDEO
            int r6 = com.instabug.chat.R.string.instabug_str_video
            goto L_0x00db
        L_0x00ca:
            android.widget.TextView r4 = r9.f46266d
            com.instabug.library.InstabugCustomTextPlaceHolder$Key r5 = com.instabug.library.InstabugCustomTextPlaceHolder.Key.CHATS_TYPE_AUDIO
            int r6 = com.instabug.chat.R.string.instabug_str_audio
            goto L_0x00db
        L_0x00d3:
            android.widget.TextView r4 = r9.f46266d
            com.instabug.library.InstabugCustomTextPlaceHolder$Key r5 = com.instabug.library.InstabugCustomTextPlaceHolder.Key.CHATS_TYPE_IMAGE
            int r6 = com.instabug.chat.R.string.instabug_str_image
        L_0x00db:
            java.lang.String r6 = r7.a((android.content.Context) r8, (int) r6)
            java.lang.String r5 = com.instabug.library.util.PlaceHolderUtils.getPlaceHolder(r5, r6)
            goto L_0x0043
        L_0x00e5:
            java.lang.String r4 = r10.h()
            android.widget.TextView r5 = r9.f46263a
            if (r5 == 0) goto L_0x011a
            if (r4 == 0) goto L_0x010f
            java.lang.String r5 = ""
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x010f
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x010f
            if (r0 == 0) goto L_0x010f
            boolean r0 = r0.o()
            if (r0 != 0) goto L_0x010f
            android.widget.TextView r0 = r9.f46263a
            r0.setText(r4)
            goto L_0x011a
        L_0x010f:
            android.widget.TextView r0 = r9.f46263a
            java.lang.String r1 = r10.i()
            r0.setText(r1)
        L_0x011a:
            android.widget.TextView r0 = r9.f46265c
            if (r0 == 0) goto L_0x012f
            android.widget.TextView r0 = r9.f46265c
            long r4 = r10.c()
            java.lang.String r1 = com.instabug.library.util.InstabugDateFormatter.formatConversationLastMessageDate(r8, r4)
            r0.setText(r1)
        L_0x012f:
            int r0 = r10.j()
            if (r0 == 0) goto L_0x0188
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r1 = r8.getTheme()
            int r4 = com.instabug.library.R.attr.instabug_unread_message_background_color
            r1.resolveAttribute(r4, r0, r3)
            android.widget.LinearLayout r1 = r9.f46268f
            if (r1 == 0) goto L_0x0152
            android.widget.LinearLayout r1 = r9.f46268f
            int r0 = r0.data
            r1.setBackgroundColor(r0)
        L_0x0152:
            int r0 = com.instabug.library.R.drawable.ibg_core_bg_white_oval
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r8, r0)
            if (r0 == 0) goto L_0x016b
            android.graphics.drawable.Drawable r0 = com.instabug.library.util.Colorizer.getPrimaryColorTintedDrawable(r0)
            android.widget.TextView r1 = r9.f46267e
            if (r1 == 0) goto L_0x016b
            android.widget.TextView r1 = r9.f46267e
            r1.setBackgroundDrawable(r0)
        L_0x016b:
            android.widget.TextView r0 = r9.f46267e
            if (r0 == 0) goto L_0x01a4
            android.widget.TextView r0 = r9.f46267e
            int r1 = r10.j()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            android.widget.TextView r0 = r9.f46267e
            r0.setVisibility(r2)
            goto L_0x01a4
        L_0x0188:
            android.widget.LinearLayout r0 = r9.f46268f
            if (r0 == 0) goto L_0x0195
            android.widget.LinearLayout r0 = r9.f46268f
            r0.setBackgroundColor(r2)
        L_0x0195:
            android.widget.TextView r0 = r9.f46267e
            if (r0 == 0) goto L_0x01a4
            android.widget.TextView r0 = r9.f46267e
            r1 = 8
            r0.setVisibility(r1)
        L_0x01a4:
            java.lang.String r0 = r10.g()
            if (r0 == 0) goto L_0x01b3
            com.instabug.chat.ui.chats.m r0 = new com.instabug.chat.ui.chats.m
            r0.<init>(r7, r10, r8, r9)
            com.instabug.library.util.threading.PoolProvider.postIOTask(r0)
            goto L_0x01c2
        L_0x01b3:
            com.instabug.library.ui.custom.CircularImageView r8 = r9.f46264b
            if (r8 == 0) goto L_0x01c2
            com.instabug.library.ui.custom.CircularImageView r8 = r9.f46264b
            int r9 = com.instabug.chat.R.drawable.ibg_core_ic_avatar
            r8.setImageResource(r9)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.ui.chats.d.a(android.content.Context, com.instabug.chat.ui.chats.c, com.instabug.chat.model.d):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.instabug.chat.model.d dVar, Context context, c cVar) {
        if (dVar.g() != null) {
            BitmapUtils.loadBitmapForAsset(context, dVar.g(), AssetEntity.AssetType.IMAGE, new b(this, cVar));
        }
    }

    /* renamed from: a */
    public com.instabug.chat.model.d getItem(int i11) {
        return (com.instabug.chat.model.d) this.f46269a.get(i11);
    }

    public String a(@StringRes int i11, Context context) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), i11, context);
    }

    public void a(List list) {
        this.f46269a = list;
    }

    public int getCount() {
        return this.f46269a.size();
    }

    public long getItemId(int i11) {
        String id2 = getItem(i11).getId();
        if (id2 != null) {
            i11 = id2.hashCode();
        }
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        c cVar;
        if (viewGroup != null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.instabug_conversation_list_item, viewGroup, false);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(view.getContext(), cVar, getItem(i11));
            ViewCompat.setAccessibilityDelegate(view, new a(this, i11, view));
        }
        return view;
    }
}
