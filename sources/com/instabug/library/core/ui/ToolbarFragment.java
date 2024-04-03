package com.instabug.library.core.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.instabug.library.R;
import com.instabug.library.util.SystemServiceUtils;

public abstract class ToolbarFragment extends InstabugBaseFragment {
    @Nullable
    public ImageButton G;
    @Nullable
    public ImageButton H;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            FragmentActivity activity = ToolbarFragment.this.getActivity();
            if (activity != null) {
                SystemServiceUtils.hideInputMethod(activity);
            }
            ToolbarFragment.this.o0();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ToolbarFragment.this.n0();
        }
    }

    private void initToolbarViews() {
        ImageButton imageButton = (ImageButton) i(R.id.instabug_btn_toolbar_right);
        this.G = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new a());
        }
        ImageButton imageButton2 = (ImageButton) i(R.id.instabug_btn_toolbar_left);
        this.H = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new b());
        }
    }

    public int i0() {
        return R.layout.instabug_fragment_toolbar;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        initToolbarViews();
        ViewStub viewStub = (ViewStub) i(R.id.instabug_content);
        if (viewStub != null) {
            viewStub.setLayoutResource(k0());
            viewStub.inflate();
        }
        m0(view, bundle);
        setTitle(l0());
    }

    @LayoutRes
    public abstract int k0();

    public abstract String l0();

    public abstract void m0(View view, @Nullable Bundle bundle);

    public void n0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            SystemServiceUtils.hideInputMethod(activity);
            activity.onBackPressed();
            return;
        }
        Log.w("ToolbarFragment", "onCloseButtonClicked can't be executed due to null getActivity() reference");
    }

    public abstract void o0();

    public void setTitle(String str) {
        TextView textView;
        if (this.F != null && (textView = (TextView) i(R.id.instabug_fragment_title)) != null) {
            textView.setText(str);
        }
    }
}
