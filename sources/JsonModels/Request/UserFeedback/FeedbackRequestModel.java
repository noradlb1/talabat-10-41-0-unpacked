package JsonModels.Request.UserFeedback;

import com.google.gson.annotations.SerializedName;

public class FeedbackRequestModel {
    @SerializedName("TransId")
    public String encryptedTransactionId;
    @SerializedName("DeliveryMainFeedback")
    public boolean feedback;
    @SerializedName("DeliveryFeedback")
    public String smiley;

    public FeedbackRequestModel(String str, boolean z11, String str2) {
        this.encryptedTransactionId = str;
        this.feedback = z11;
        this.smiley = str2;
    }
}
