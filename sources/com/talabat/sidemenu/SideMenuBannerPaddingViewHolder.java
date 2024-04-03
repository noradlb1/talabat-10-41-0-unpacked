package com.talabat.sidemenu;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class SideMenuBannerPaddingViewHolder extends RecyclerView.ViewHolder {
    public ImageView bannerPaddingView;

    public SideMenuBannerPaddingViewHolder(View view) {
        super(view);
        this.bannerPaddingView = (ImageView) view.findViewById(R.id.side_menu_padding_view);
    }
}
