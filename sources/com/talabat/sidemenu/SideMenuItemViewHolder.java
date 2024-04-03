package com.talabat.sidemenu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class SideMenuItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: h  reason: collision with root package name */
    public View f61365h;
    public TextView headerTitle;
    public ImageView imageView;

    public SideMenuItemViewHolder(View view) {
        super(view);
        this.f61365h = view.findViewById(R.id.side_menu_item_icon_view);
        this.headerTitle = (TextView) view.findViewById(R.id.side_menu_item_icon_title);
        this.imageView = (ImageView) view.findViewById(R.id.side_menu_item_icon);
    }
}
