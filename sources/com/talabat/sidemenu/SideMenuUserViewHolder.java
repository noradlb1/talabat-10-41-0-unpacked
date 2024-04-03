package com.talabat.sidemenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.screenrecorder.ScreenRecorder;

public class SideMenuUserViewHolder extends RecyclerView.ViewHolder {
    public View contentView;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f61391h;
    public ImageView userAvatarIcon;
    public TextView userSelectedCountry;
    public ImageView userSelectedCountryIcon;
    public ImageView userSettingsIcon;
    public TextView userTitle;

    public SideMenuUserViewHolder(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(R.id.side_menu_user_title);
        this.userTitle = textView;
        ScreenRecorder.INSTANCE.blockViewRecording(textView);
        this.userSelectedCountry = (TextView) view.findViewById(R.id.side_menu_user_country_name);
        this.userAvatarIcon = (ImageView) view.findViewById(R.id.side_menu_user_avtar_icon);
        this.userSelectedCountryIcon = (ImageView) view.findViewById(R.id.side_menu_user_country_icon);
        this.userSettingsIcon = (ImageView) view.findViewById(R.id.side_menu_user_settings);
        this.f61391h = (ViewGroup) view.findViewById(R.id.sidemenu_content_view);
        this.contentView = view.findViewById(R.id.sidemenu_content_view);
    }
}
