package datamodels;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Survey {
    public static String TOKEN;
    public String question;
    public ArrayList<SurveyOptions> surveyDetails;
    public String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Survey survey = (Survey) obj;
        ArrayList<SurveyOptions> arrayList = this.surveyDetails;
        if (arrayList == null ? survey.surveyDetails != null : !arrayList.equals(survey.surveyDetails)) {
            return false;
        }
        String str = this.question;
        if (str == null ? survey.question != null : !str.equals(survey.question)) {
            return false;
        }
        String str2 = this.title;
        String str3 = survey.title;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        ArrayList<SurveyOptions> arrayList = this.surveyDetails;
        int i13 = 0;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        String str = this.question;
        if (str != null) {
            i12 = str.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        return i15 + i13;
    }

    public String toString() {
        return "Survey{surveyDetails=" + this.surveyDetails + ", question='" + this.question + '\'' + ", title='" + this.title + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
