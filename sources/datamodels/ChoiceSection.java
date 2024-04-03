package datamodels;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ChoiceSection implements Serializable {
    @SerializedName("awm")
    boolean allowMultiple;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13841id;
    public boolean isSubChoice = false;
    @SerializedName("ich")
    public ArrayList<ChoiceItem> itemChoices;
    @SerializedName("mxq")
    public int maxQuantity;
    @SerializedName("mnq")
    public int minQuantity;
    @SerializedName("nm")

    /* renamed from: name  reason: collision with root package name */
    public String f13842name;
    @SerializedName("iid")
    public int parentItemId;
    @SerializedName("st")
    public String selectionText;

    public static ChoiceSection createSelectedChoiceSection(ChoiceSection choiceSection) {
        ChoiceSection choiceSection2 = new ChoiceSection();
        choiceSection2.f13842name = choiceSection.f13842name;
        choiceSection2.f13841id = choiceSection.f13841id;
        choiceSection2.maxQuantity = choiceSection.maxQuantity;
        choiceSection2.minQuantity = choiceSection.minQuantity;
        choiceSection2.itemChoices = new ArrayList<>();
        choiceSection2.isSubChoice = choiceSection.isSubChoice;
        choiceSection2.parentItemId = choiceSection.parentItemId;
        return choiceSection2;
    }

    public float getMinimumTotalCost() {
        ArrayList<ChoiceItem> arrayList = this.itemChoices;
        float f11 = 0.0f;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.itemChoices.size();
            float[] fArr = new float[size];
            if (isMandatoryChoiceSection()) {
                Iterator<ChoiceItem> it = this.itemChoices.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    float f12 = it.next().price;
                    if (f12 > 0.0f) {
                        fArr[i11] = f12;
                        i11++;
                    }
                }
                Arrays.sort(fArr);
                int i12 = this.minQuantity;
                if (size >= i12) {
                    size = i12;
                }
                for (int i13 = 0; i13 < size; i13++) {
                    f11 += fArr[i13];
                }
            }
        }
        return f11;
    }

    public boolean isMandatoryChoiceSection() {
        return this.minQuantity > 0;
    }

    public String toString() {
        return this.f13842name;
    }
}
