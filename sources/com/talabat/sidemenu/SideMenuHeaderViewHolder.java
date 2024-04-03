package com.talabat.sidemenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.wang.avi.AVLoadingIndicatorView;

public class SideMenuHeaderViewHolder extends RecyclerView.ViewHolder {
    public AVLoadingIndicatorView avLoadingIndicatorView;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f61360h;
    public TextView headerCountTextView;
    public TextView headerTitle;
    public ImageView imageView;
    public View menuHighlightView;
    public TextView notificationBubble;
    public DSTag pendingApplicationView;

    public SideMenuHeaderViewHolder(View view) {
        super(view);
        this.headerTitle = (TextView) view.findViewById(R.id.side_menu_header_title);
        this.imageView = (ImageView) view.findViewById(R.id.side_menu_header_icon);
        this.f61360h = (ViewGroup) view.findViewById(R.id.side_menu_header_view);
        this.notificationBubble = (TextView) view.findViewById(R.id.notification_buble);
        this.headerCountTextView = (TextView) view.findViewById(R.id.talabat_credit_bal);
        this.avLoadingIndicatorView = (AVLoadingIndicatorView) view.findViewById(R.id.credit_bal_loading);
        this.menuHighlightView = view.findViewById(R.id.side_menu_selector);
        this.pendingApplicationView = (DSTag) view.findViewById(R.id.talabat_credit_incomplete_warning);
    }
}
