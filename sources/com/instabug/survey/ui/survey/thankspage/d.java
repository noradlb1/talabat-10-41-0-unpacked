package com.instabug.survey.ui.survey.thankspage;

import androidx.annotation.Nullable;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import java.lang.ref.WeakReference;

class d extends BasePresenter {
    public d(c cVar) {
        super(cVar);
    }

    @Nullable
    public String a(Survey survey) {
        c cVar = (c) this.f34200f.get();
        if (cVar == null || survey == null) {
            return "";
        }
        int type = survey.getType();
        if (type == 0) {
            String thankYouMessage = survey.getThankYouMessage();
            return thankYouMessage != null ? thankYouMessage : "";
        } else if (type == 1) {
            return survey.getThankYouMessage();
        } else {
            if (type != 2) {
                return "";
            }
            return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SURVEYS_STORE_RATING_THANKS_SUBTITLE, cVar.getLocalizedString(R.string.instabug_store_rating_survey_thanks_subtitle));
        }
    }

    public void a() {
        c cVar;
        WeakReference<V> weakReference = this.f34200f;
        if (weakReference != null && (cVar = (c) weakReference.get()) != null) {
            cVar.a();
        }
    }

    @Nullable
    public String b(Survey survey) {
        c cVar = (c) this.f34200f.get();
        if (cVar == null || survey == null) {
            return "";
        }
        int type = survey.getType();
        if (type == 0) {
            String thankYouTitle = survey.getThankYouTitle();
            return thankYouTitle != null ? thankYouTitle : "";
        } else if (type == 1) {
            return survey.getThankYouTitle();
        } else {
            if (type != 2) {
                return "";
            }
            return PlaceHolderUtils.getPlaceHolder(InstabugCustomTextPlaceHolder.Key.SURVEYS_STORE_RATING_THANKS_TITLE, cVar.getLocalizedString(R.string.instabug_store_rating_survey_thanks_title));
        }
    }
}
