package datamodels;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class RateTag {
    @SerializedName("rating")
    public float rate;
    @SerializedName("tags")
    public ArrayList<Tag> tags;

    public static class Tag {
        @SerializedName("id")
        public int tagId;
        @SerializedName("tagText")
        public String tagText;

        public int getTagId() {
            return this.tagId;
        }

        public String getTagText() {
            return this.tagText;
        }

        public void setTagId(int i11) {
            this.tagId = i11;
        }

        public void setTagText(String str) {
            this.tagText = str;
        }
    }
}
