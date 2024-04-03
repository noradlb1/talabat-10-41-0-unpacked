package datamodels;

import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.GlobalDataModel;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class BenefitItem {
    public int CouponId;
    public List<ChoiceSection> choiceCategories;
    public boolean choiceSelected = false;
    public boolean containsChoices;
    public String description;

    /* renamed from: id  reason: collision with root package name */
    public int f13836id;
    private String image;
    public int itemId;

    /* renamed from: name  reason: collision with root package name */
    public String f13837name;
    public int quantity;
    public float totalPrice;

    public String getDisplayTotalPrice() {
        if (this.totalPrice > 0.0f) {
            return TalabatFormatter.getInstance().getFormattedCurrency(this.totalPrice);
        }
        return "0";
    }

    public String getImage() {
        String str = this.image;
        if (str != null && str.contains("http://")) {
            return this.image;
        }
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + this.image).replace(" ", "%20");
    }

    public String getSelectedChoiceNames() {
        StringBuilder sb2 = new StringBuilder();
        List<ChoiceSection> list = this.choiceCategories;
        if (list != null) {
            for (ChoiceSection next : list) {
                if (next != null) {
                    Iterator<ChoiceItem> it = next.itemChoices.iterator();
                    while (it.hasNext()) {
                        ChoiceItem next2 = it.next();
                        if (sb2.length() > 0) {
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                        }
                        sb2.append(next2.f13840name);
                    }
                }
            }
        }
        return sb2.toString();
    }

    public boolean hasThumbnail() {
        String str = this.image;
        return str != null && !str.equals("");
    }
}
