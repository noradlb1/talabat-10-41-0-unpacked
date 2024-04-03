package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.rewards.presentation.R;

public final class MissionBlockSectionBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvSectionText;
    @NonNull
    public final TextView tvSectionTitle;
    @NonNull
    public final View vSectionSeparator;

    private MissionBlockSectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view) {
        this.rootView = constraintLayout;
        this.tvSectionText = textView;
        this.tvSectionTitle = textView2;
        this.vSectionSeparator = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.talabat.feature.rewards.presentation.R.id.v_section_separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding bind(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.talabat.feature.rewards.presentation.R.id.tv_section_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.talabat.feature.rewards.presentation.R.id.tv_section_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.talabat.feature.rewards.presentation.R.id.v_section_separator
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding r0 = new com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding.bind(android.view.View):com.talabat.feature.rewards.presentation.databinding.MissionBlockSectionBinding");
    }

    @NonNull
    public static MissionBlockSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MissionBlockSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mission_block_section, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
