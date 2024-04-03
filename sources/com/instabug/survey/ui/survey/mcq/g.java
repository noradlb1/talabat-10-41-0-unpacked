package com.instabug.survey.ui.survey.mcq;

import android.app.Activity;
import android.widget.ImageView;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AttrResolver;
import com.instabug.survey.R;
import com.instabug.survey.models.b;

public class g extends f {
    public g(Activity activity, b bVar, d dVar) {
        super(activity, bVar, dVar);
    }

    public int b(e eVar) {
        return InstabugCore.getPrimaryColor();
    }

    public int e(e eVar) {
        return AttrResolver.resolveAttributeColor(this.f52577e, R.attr.instabug_survey_mcq_text_color_selected);
    }

    public int g(e eVar) {
        return AttrResolver.resolveAttributeColor(this.f52577e, R.attr.instabug_survey_mcq_unselected_bg);
    }

    public void h(e eVar) {
        ImageView imageView = eVar.f52572c;
        if (imageView != null) {
            imageView.setColorFilter(InstabugCore.getPrimaryColor());
            eVar.f52572c.setImageResource(R.drawable.ibg_survey_ic_mcq_selected);
        }
    }

    public void i(e eVar) {
        ImageView imageView = eVar.f52572c;
        if (imageView != null) {
            imageView.setColorFilter(AttrResolver.resolveAttributeColor(this.f52577e, R.attr.instabug_survey_mcq_radio_icon_color));
            eVar.f52572c.setImageResource(R.drawable.ibg_survey_ic_mcq_unselected);
        }
    }
}
