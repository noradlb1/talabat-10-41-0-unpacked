package com.instabug.bug.view.disclaimer;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class h extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f45820a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f45821b;

    public h(Context context, ArrayList arrayList) {
        this.f45820a = context;
        this.f45821b = arrayList;
    }

    /* renamed from: a */
    public a getItem(int i11) {
        return (a) this.f45821b.get(i11);
    }

    public int getCount() {
        return this.f45821b.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            com.instabug.bug.view.disclaimer.a r5 = r4.getItem(r5)
            r0 = 0
            if (r6 != 0) goto L_0x0031
            com.instabug.bug.view.disclaimer.g r6 = new com.instabug.bug.view.disclaimer.g
            r1 = 0
            r6.<init>()
            android.content.Context r1 = r4.f45820a
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.instabug.library.R.layout.instabug_lyt_item_disclaimer
            android.view.View r7 = r1.inflate(r2, r7, r0)
            int r1 = com.instabug.library.R.id.tvKey
            android.view.View r1 = r7.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.f45818a = r1
            int r1 = com.instabug.library.R.id.tvValue
            android.view.View r1 = r7.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.f45819b = r1
            r7.setTag(r6)
            goto L_0x003a
        L_0x0031:
            java.lang.Object r7 = r6.getTag()
            com.instabug.bug.view.disclaimer.g r7 = (com.instabug.bug.view.disclaimer.g) r7
            r3 = r7
            r7 = r6
            r6 = r3
        L_0x003a:
            java.lang.String r1 = r5.a()
            boolean r2 = r5.c()
            if (r2 == 0) goto L_0x0059
            android.text.SpannableString r5 = new android.text.SpannableString
            r5.<init>(r1)
            android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
            r1.<init>()
            int r2 = r5.length()
            r5.setSpan(r1, r0, r2, r0)
            java.lang.String r0 = ""
            r1 = r5
            goto L_0x0061
        L_0x0059:
            java.lang.String r5 = r5.b()
            java.lang.String r0 = java.lang.String.valueOf(r5)
        L_0x0061:
            android.widget.TextView r5 = r6.f45818a
            if (r5 == 0) goto L_0x0068
            r5.setText(r1)
        L_0x0068:
            android.widget.TextView r5 = r6.f45819b
            if (r5 == 0) goto L_0x006f
            r5.setText(r0)
        L_0x006f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.disclaimer.h.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
