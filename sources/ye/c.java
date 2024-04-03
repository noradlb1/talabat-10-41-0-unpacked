package ye;

import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import android.view.View;
import com.talabat.adapters.grocery.TagsAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TagsAdapter f57999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryTagsModel f58000c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TagsAdapter.TagItemViewHolder f58001d;

    public /* synthetic */ c(TagsAdapter tagsAdapter, GroceryTagsModel groceryTagsModel, TagsAdapter.TagItemViewHolder tagItemViewHolder) {
        this.f57999b = tagsAdapter;
        this.f58000c = groceryTagsModel;
        this.f58001d = tagItemViewHolder;
    }

    public final void onClick(View view) {
        TagsAdapter.m9498onBindViewHolder$lambda0(this.f57999b, this.f58000c, this.f58001d, view);
    }
}
