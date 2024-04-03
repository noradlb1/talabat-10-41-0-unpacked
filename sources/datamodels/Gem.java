package datamodels;

import com.google.gson.annotations.SerializedName;

public class Gem {
    @SerializedName("clr")
    private String color;
    @SerializedName("tieramt")
    public float conditionAmount;
    @SerializedName("cntid")
    int countryId;
    private float deductionValue = 0.0f;
    @SerializedName("disc")
    private float discount;
    private Gem flooringGem;
    private int index = -1;
    private boolean isLastOffer = false;
    private boolean isSelected = false;
    int offerId;
    long reservationCode;

    public Gem(float f11, float f12) {
        this.conditionAmount = f11;
        this.discount = f12;
    }

    public String getColor() {
        return this.color;
    }

    public float getConditionAmount() {
        return this.conditionAmount;
    }

    public float getDeductionValue() {
        return this.conditionAmount - this.discount;
    }

    public float getDiscount() {
        return this.discount;
    }

    public Gem getFlooringGem() {
        return this.flooringGem;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isLastOffer() {
        return this.isLastOffer;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setFlooringGem(Gem gem) {
        this.flooringGem = gem;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setLastOffer(boolean z11) {
        this.isLastOffer = z11;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }
}
