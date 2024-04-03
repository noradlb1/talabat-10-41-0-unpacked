package com.talabat.darkstores.feature.product.views;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorRes;
import com.talabat.darkstores.R;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ#\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/TagsLayoutConfig;", "", "productTags", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "displayWidth", "", "textPaint", "Landroid/graphics/Paint;", "resources", "Landroid/content/res/Resources;", "(Ljava/util/List;ILandroid/graphics/Paint;Landroid/content/res/Resources;)V", "collapsedState", "", "getCollapsedState$com_talabat_NewArchi_darkstores_darkstores", "()Ljava/util/List;", "setCollapsedState$com_talabat_NewArchi_darkstores_darkstores", "(Ljava/util/List;)V", "expendedState", "getExpendedState$com_talabat_NewArchi_darkstores_darkstores", "setExpendedState$com_talabat_NewArchi_darkstores_darkstores", "lessTag", "moreTag", "colorResourceToHexString", "", "colorRes", "(Landroid/content/res/Resources;Ljava/lang/Integer;)Ljava/lang/String;", "getTags", "expended", "", "isExpendable", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TagsLayoutConfig {
    @NotNull
    private List<ProductExtendedInfo.Tag> collapsedState = new ArrayList();
    @Nullable
    private List<ProductExtendedInfo.Tag> expendedState;
    @NotNull
    private final ProductExtendedInfo.Tag lessTag;
    @NotNull
    private final ProductExtendedInfo.Tag moreTag;

    public TagsLayoutConfig(@NotNull List<ProductExtendedInfo.Tag> list, int i11, @NotNull Paint paint, @NotNull Resources resources) {
        int i12;
        int i13;
        int i14;
        List<ProductExtendedInfo.Tag> list2;
        List<ProductExtendedInfo.Tag> list3;
        List<ProductExtendedInfo.Tag> list4 = list;
        Paint paint2 = paint;
        Resources resources2 = resources;
        Intrinsics.checkNotNullParameter(list4, "productTags");
        Intrinsics.checkNotNullParameter(paint2, "textPaint");
        Intrinsics.checkNotNullParameter(resources2, "resources");
        int i15 = R.string.product_tag_more;
        String string = resources2.getString(i15);
        int i16 = com.designsystem.marshmallow.R.color.ds_transparent_fill;
        ProductExtendedInfo.ColorResource colorResource = new ProductExtendedInfo.ColorResource("ds_transparent_fill", colorResourceToHexString(resources2, Integer.valueOf(i16)));
        int i17 = com.designsystem.marshmallow.R.color.ds_primary_100;
        this.moreTag = new ProductExtendedInfo.Tag(string, (String) null, colorResource, new ProductExtendedInfo.ColorResource("ds_primary_100", colorResourceToHexString(resources2, Integer.valueOf(i17))));
        this.lessTag = new ProductExtendedInfo.Tag(resources2.getString(R.string.product_tag_less), (String) null, new ProductExtendedInfo.ColorResource("ds_transparent_fill", colorResourceToHexString(resources2, Integer.valueOf(i16))), new ProductExtendedInfo.ColorResource("ds_primary_100", colorResourceToHexString(resources2, Integer.valueOf(i17))));
        int i18 = com.designsystem.marshmallow.R.dimen.ds_xxs;
        int dimensionPixelOffset = resources2.getDimensionPixelOffset(i18);
        int dimensionPixelOffset2 = resources2.getDimensionPixelOffset(i18);
        int dimensionPixelOffset3 = i11 - resources2.getDimensionPixelOffset(com.designsystem.marshmallow.R.dimen.ds_xl);
        String string2 = resources2.getString(i15);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.product_tag_more)");
        Rect rect = new Rect();
        int i19 = 0;
        paint2.getTextBounds(string2, 0, string2.length(), rect);
        int i21 = 2;
        int i22 = dimensionPixelOffset2 * 2;
        int width = rect.width() + dimensionPixelOffset + i22;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        for (Object next : list4) {
            int i26 = i24 + 1;
            if (i24 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ProductExtendedInfo.Tag tag = (ProductExtendedInfo.Tag) next;
            Rect rect2 = new Rect();
            String text = tag.getText();
            String text2 = tag.getText();
            paint2.getTextBounds(text, i19, text2 != null ? text2.length() : i19, rect2);
            int width2 = rect2.width() + dimensionPixelOffset + i22;
            int i27 = i25 + width2;
            if (i27 > dimensionPixelOffset3) {
                i13 = i23 + 1;
                i12 = width2;
            } else {
                i12 = i27;
                i13 = i23;
            }
            if (i23 == 1 && i13 == 2) {
                if (i25 + width <= dimensionPixelOffset3) {
                    List<ProductExtendedInfo.Tag> mutableList = CollectionsKt___CollectionsKt.toMutableList(list4.subList(0, i24));
                    this.collapsedState = mutableList;
                    mutableList.add(this.moreTag);
                } else if ((i25 - width2) + width <= dimensionPixelOffset3) {
                    if (i24 > 0) {
                        list3 = CollectionsKt___CollectionsKt.toMutableList(list4.subList(0, i24 - 1));
                    } else {
                        list3 = new ArrayList<>();
                    }
                    this.collapsedState = list3;
                    list3.add(this.moreTag);
                } else {
                    if (i24 > 1) {
                        i14 = 0;
                        list2 = CollectionsKt___CollectionsKt.toMutableList(list4.subList(0, i24 - 2));
                    } else {
                        i14 = 0;
                        if (i24 > 0) {
                            list2 = CollectionsKt___CollectionsKt.toMutableList(list4.subList(0, i24 - 1));
                        } else {
                            list2 = new ArrayList<>();
                        }
                    }
                    this.collapsedState = list2;
                    list2.add(this.moreTag);
                    i19 = i14;
                    i23 = i13;
                    i25 = i12;
                    i24 = i26;
                    i21 = 2;
                }
            }
            i14 = 0;
            i19 = i14;
            i23 = i13;
            i25 = i12;
            i24 = i26;
            i21 = 2;
        }
        if (i23 < i21) {
            this.collapsedState = CollectionsKt___CollectionsKt.toMutableList(list4);
            this.expendedState = null;
            return;
        }
        List<ProductExtendedInfo.Tag> mutableList2 = CollectionsKt___CollectionsKt.toMutableList(list4);
        this.expendedState = mutableList2;
        if (mutableList2 != null) {
            mutableList2.add(this.lessTag);
        }
    }

    @SuppressLint({"ResourceType"})
    private final String colorResourceToHexString(Resources resources, @ColorRes Integer num) {
        if (num != null) {
            return resources.getString(num.intValue());
        }
        return null;
    }

    @NotNull
    public final List<ProductExtendedInfo.Tag> getCollapsedState$com_talabat_NewArchi_darkstores_darkstores() {
        return this.collapsedState;
    }

    @Nullable
    public final List<ProductExtendedInfo.Tag> getExpendedState$com_talabat_NewArchi_darkstores_darkstores() {
        return this.expendedState;
    }

    @NotNull
    public final List<ProductExtendedInfo.Tag> getTags(boolean z11) {
        if (!z11) {
            return this.collapsedState;
        }
        List<ProductExtendedInfo.Tag> list = this.expendedState;
        if (list == null) {
            return this.collapsedState;
        }
        return list;
    }

    public final boolean isExpendable() {
        return this.expendedState != null;
    }

    public final void setCollapsedState$com_talabat_NewArchi_darkstores_darkstores(@NotNull List<ProductExtendedInfo.Tag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.collapsedState = list;
    }

    public final void setExpendedState$com_talabat_NewArchi_darkstores_darkstores(@Nullable List<ProductExtendedInfo.Tag> list) {
        this.expendedState = list;
    }
}
