package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.rewards.presentation.R;

public final class MissionTextSectionBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;

    private MissionTextSectionBinding(@NonNull TextView textView) {
        this.rootView = textView;
    }

    @NonNull
    public static MissionTextSectionBinding bind(@NonNull View view) {
        if (view != null) {
            return new MissionTextSectionBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MissionTextSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MissionTextSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mission_text_section, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }
}
