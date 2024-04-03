package com.huawei.hms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.internal.IMapFragmentDelegate;
import com.huawei.hms.maps.internal.mab;
import com.huawei.hms.maps.internal.mac;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapsAdvUtil;

public class mad {
    public static View a(Activity activity, IMapFragmentDelegate iMapFragmentDelegate, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle a11 = mac.a(bundle);
            Context d11 = MapsAdvUtil.containsMapsBasic() ? activity : mab.d(activity);
            if (iMapFragmentDelegate == null) {
                return LayoutInflater.from(d11).inflate(R.layout.hms_map_empty_layout_sdk, (ViewGroup) null);
            }
            LogM.d("MapFragmentUtil", "sdk onCreateView iMapFragmentDelegate" + iMapFragmentDelegate);
            View view = (View) ObjectWrapper.unwrap(iMapFragmentDelegate.onCreateView(ObjectWrapper.wrap(LayoutInflater.from(d11)), ObjectWrapper.wrap(viewGroup), a11));
            if (view == null) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return view;
            }
            LogM.d("MapFragmentUtil", "onCreateView: removeView");
            ((ViewGroup) parent).removeView(view);
            return view;
        } catch (RemoteException e11) {
            throw new RuntimeRemoteException(e11);
        }
    }
}
