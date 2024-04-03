package com.instabug.library.invocation.invocationdialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.library.R;

class g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public View f51296a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ImageView f51297b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public TextView f51298c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public TextView f51299d;

    public g(View view) {
        this.f51296a = view.findViewById(R.id.instabug_prompt_option_container);
        this.f51297b = (ImageView) view.findViewById(R.id.instabug_prompt_option_icon);
        this.f51298c = (TextView) view.findViewById(R.id.instabug_prompt_option_title);
        this.f51299d = (TextView) view.findViewById(R.id.instabug_prompt_option_description);
    }
}
