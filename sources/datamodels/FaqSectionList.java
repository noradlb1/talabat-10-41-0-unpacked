package datamodels;

import com.google.gson.annotations.SerializedName;

public class FaqSectionList {
    @SerializedName("deeplinkId")
    public Integer deeplinkId;
    @SerializedName("id")
    public int faqSectionId;
    public FaqQuestionsAns[] questions;
    @SerializedName("sectionName")
    public String sectionName;
}
