package JsonModels;

import com.google.gson.annotations.SerializedName;

public class SwimLane {
    @SerializedName("recommendation_strategy")
    String recommendationStrategy;
    @SerializedName("request_id")
    String requestId;
    @SerializedName("user_id")
    String userId;

    public String getRecommendationStrategy() {
        return this.recommendationStrategy;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setRecommendationStrategy(String str) {
        this.recommendationStrategy = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
