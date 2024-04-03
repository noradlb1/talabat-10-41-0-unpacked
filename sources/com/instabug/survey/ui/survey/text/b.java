package com.instabug.survey.ui.survey.text;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.survey.R;
import com.instabug.survey.ui.survey.c;
import com.instabug.survey.ui.survey.n;
import org.jetbrains.annotations.NotNull;

public abstract class b extends c implements TextWatcher {
    @Nullable
    public EditText N;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Runnable f52585j;

    public static b a(boolean z11, com.instabug.survey.models.b bVar, n nVar) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", bVar);
        bundle.putBoolean("should_change_container_height", z11);
        c cVar = new c();
        cVar.setArguments(bundle);
        cVar.a(nVar);
        return cVar;
    }

    private void a(com.instabug.survey.models.b bVar) {
        EditText editText;
        if (bVar.a() != null && !bVar.a().isEmpty() && (editText = this.N) != null) {
            editText.setText(bVar.a());
        }
    }

    public void afterTextChanged(Editable editable) {
        com.instabug.survey.models.b bVar = this.G;
        if (bVar != null) {
            bVar.a(editable.toString());
            n nVar = this.H;
            if (nVar != null) {
                nVar.d(this.G);
            }
        }
    }

    public void b(com.instabug.survey.models.b bVar) {
        EditText editText = this.N;
        TextView textView = this.I;
        if (textView != null && editText != null) {
            String m02 = bVar.e() != null ? m0(bVar.e()) : null;
            if (m02 != null) {
                textView.setText(m02);
                ViewCompat.setLabelFor(textView, editText.getId());
            }
            editText.setHint(getLocalizedString(R.string.instabug_str_hint_enter_your_answer));
            a aVar = new a(this, editText);
            this.f52585j = aVar;
            editText.postDelayed(aVar, 200);
            a(bVar);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    @Nullable
    public String f() {
        EditText editText = this.N;
        if (editText == null || editText.getText().toString().trim().equals("")) {
            return null;
        }
        return this.N.getText().toString();
    }

    public void i() {
        EditText editText;
        if (getActivity() != null && (editText = this.N) != null) {
            editText.requestFocus();
            com.instabug.survey.utils.c.a(getActivity(), this.N);
        }
    }

    public int i0() {
        return R.layout.instabug_dialog_text_survey;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        this.I = (TextView) view.findViewById(R.id.instabug_text_view_question);
        EditText editText = (EditText) view.findViewById(R.id.instabug_edit_text_answer);
        this.N = editText;
        if (editText != null) {
            editText.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.question_answer_text_height);
            ((RelativeLayout.LayoutParams) editText.getLayoutParams()).bottomMargin = 10;
            g();
        }
    }

    public String m0(String str) {
        return str;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.G = (com.instabug.survey.models.b) getArguments().getSerializable("question");
        }
    }

    public void onDestroy() {
        this.H = null;
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        EditText editText = this.N;
        if (editText != null) {
            editText.removeTextChangedListener(this);
            Runnable runnable = this.f52585j;
            if (runnable != null) {
                editText.removeCallbacks(runnable);
                this.f52585j = null;
                this.N = null;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFocusableInTouchMode(true);
        com.instabug.survey.models.b bVar = this.G;
        if (bVar != null) {
            b(bVar);
        }
    }
}
