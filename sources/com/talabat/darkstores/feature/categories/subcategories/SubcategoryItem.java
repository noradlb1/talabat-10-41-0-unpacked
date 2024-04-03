package com.talabat.darkstores.feature.categories.subcategories;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "", "()V", "headlineIndex", "", "getHeadlineIndex", "()I", "id", "", "getId", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryProduct;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SubcategoryItem {
    private SubcategoryItem() {
    }

    public /* synthetic */ SubcategoryItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getHeadlineIndex();

    @NotNull
    public abstract String getId();
}
