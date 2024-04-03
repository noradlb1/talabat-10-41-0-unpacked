package com.instabug.survey.ui.survey.welcomepage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.j;
import com.instabug.survey.utils.o;
import org.jetbrains.annotations.NotNull;

public abstract class a extends InstabugBaseFragment implements c, View.OnClickListener {
    @Nullable
    public Survey G;
    @Nullable
    public TextView H;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Button f52590a;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private TextView f52591d;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void f() {
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SURVEYS_WELCOME_SCREEN_TITLE, getLocalizedString(R.string.instabug_survey_welcome_feedback)));
        }
        TextView textView2 = this.f52591d;
        if (textView2 != null) {
            textView2.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SURVEYS_WELCOME_SCREEN_SUBTITLE, getLocalizedString(R.string.instabug_survey_welcome_feedback_msg)));
        }
        Button button = this.f52590a;
        if (button != null) {
            button.setText(PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SURVEYS_WELCOME_SCREEN_BUTTON, getLocalizedString(R.string.instabug_survey_welcome_button)));
        }
    }

    public static a h(Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("survey", survey);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public void a() {
        View view;
        if (getActivity() != null && (view = this.F) != null) {
            InstabugCore.handlePbiFooter(view);
            InstabugCore.handlePbiFooterThemeColor(this.F, R.color.pbi_footer_color_dark, R.color.pbi_footer_color_light);
        }
    }

    public void h() {
        Survey survey;
        if (getActivity() != null && (survey = this.G) != null && getActivity().getSupportFragmentManager() != null) {
            Fragment findFragmentById = getActivity().getSupportFragmentManager().findFragmentById(R.id.instabug_fragment_container);
            if (findFragmentById != null) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(0, 0).remove(findFragmentById).commit();
            }
            j.b(getActivity().getSupportFragmentManager(), survey);
        }
    }

    public int i0() {
        return R.layout.instabug_survey_fragment_welcome_dialog;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        Button button = (Button) i(R.id.ib_welcome_survey_take_survey);
        this.f52590a = button;
        this.H = (TextView) i(R.id.ib_welcome_survey_title);
        this.f52591d = (TextView) i(R.id.ib_welcome_survey_text);
        if (getContext() != null) {
            if (button != null) {
                button.setOnClickListener(this);
                button.setTextColor(ContextCompat.getColor(requireContext(), 17170443));
                DrawableUtils.setColor(button, k0());
            }
            f();
        }
    }

    public abstract int k0();

    public void onClick(View view) {
        if (view.getId() == R.id.ib_welcome_survey_take_survey) {
            h();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.G = (Survey) getArguments().getSerializable("survey");
        }
        this.C = new d(this);
    }

    public void onResume() {
        super.onResume();
        TextView textView = this.H;
        if (textView != null) {
            o.a(textView);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseContract.Presenter presenter = this.C;
        if (presenter != null) {
            ((d) presenter).a();
        }
    }
}
