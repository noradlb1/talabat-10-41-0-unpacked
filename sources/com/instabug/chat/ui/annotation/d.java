package com.instabug.chat.ui.annotation;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.instabug.chat.R;
import com.instabug.library.annotation.AnnotationLayout;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.ToolbarFragment;

@SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE", "ERADICATE_FIELD_NOT_INITIALIZED"})
public class d extends ToolbarFragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f46178a;

    /* renamed from: b  reason: collision with root package name */
    private String f46179b;

    /* renamed from: c  reason: collision with root package name */
    private String f46180c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f46181d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private AnnotationLayout f46182e;

    /* renamed from: f  reason: collision with root package name */
    private c f46183f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ProgressDialog f46184g;

    public static d a(String str, String str2, Uri uri, String str3) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("chat_id", str2);
        bundle.putParcelable("image_uri", uri);
        bundle.putString("attachment_type", str3);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void finish() {
        ProgressDialog progressDialog = this.f46184g;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f46184g.dismiss();
        }
        c cVar = this.f46183f;
        if (cVar != null) {
            cVar.a(this.f46179b, this.f46181d, this.f46180c);
        }
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().getSupportFragmentManager().popBackStack("annotation_fragment_for_chat", 1);
        }
    }

    public void k() {
        if (getActivity() != null && this.f46184g != null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.f46184g = progressDialog;
            progressDialog.setCancelable(false);
            this.f46184g.setMessage(getLocalizedString(R.string.instabug_str_dialog_message_preparing));
            this.f46184g.show();
        }
    }

    public int k0() {
        return R.layout.instabug_fragment_annotation;
    }

    public String l0() {
        return this.f46178a;
    }

    public void m0(View view, @Nullable Bundle bundle) {
        ImageButton imageButton = (ImageButton) view.findViewById(com.instabug.library.R.id.instabug_btn_toolbar_right);
        if (imageButton != null) {
            imageButton.setImageResource(com.instabug.library.R.drawable.ibg_core_ic_send);
        }
        AnnotationLayout annotationLayout = (AnnotationLayout) view.findViewById(com.instabug.library.R.id.annotationLayout);
        this.f46182e = annotationLayout;
        if (annotationLayout != null) {
            annotationLayout.setBaseImage(this.f46181d, (Runnable) null);
        }
    }

    public void n0() {
        c cVar = this.f46183f;
        if (cVar != null) {
            cVar.a(this.f46179b, this.f46181d);
        }
    }

    public void o0() {
        AnnotationLayout annotationLayout;
        BaseContract.Presenter presenter = this.C;
        if (presenter != null && (annotationLayout = this.f46182e) != null) {
            ((a) presenter).a(annotationLayout.getAnnotatedBitmap(), this.f46181d);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!(getActivity() == null || getActivity().getSupportFragmentManager().findFragmentByTag("chat_fragment") == null)) {
            this.f46183f = (c) getActivity().getSupportFragmentManager().findFragmentByTag("chat_fragment");
        }
        if (getArguments() != null) {
            this.f46178a = getArguments().getString("title");
            this.f46179b = getArguments().getString("chat_id");
            this.f46180c = getArguments().getString("attachment_type");
            this.f46181d = (Uri) getArguments().getParcelable("image_uri");
        }
        this.C = new f(this);
    }
}
