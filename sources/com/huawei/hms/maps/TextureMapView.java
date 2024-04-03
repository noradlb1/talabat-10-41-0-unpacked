package com.huawei.hms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.auth.AuthClient;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IMapViewDelegate;
import com.huawei.hms.maps.model.RuntimeRemoteException;
import com.huawei.hms.maps.provider.inhuawei.MapViewDelegate;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.maps.utils.MapsAdvUtil;

public class TextureMapView extends MapView {

    public static class maa extends MapView.maa {
        public maa(ViewGroup viewGroup, Context context, HuaweiMapOptions huaweiMapOptions) {
            super(viewGroup, context, huaweiMapOptions);
        }

        public IMapViewDelegate a(ICreator iCreator, Context context, HuaweiMapOptions huaweiMapOptions) {
            try {
                LogM.i("TextureMapView", "createTextureMapViewDelegateRemote: ");
                return iCreator.newTextureMapViewDelegate(ObjectWrapper.wrap(context), huaweiMapOptions);
            } catch (RemoteException e11) {
                throw new RuntimeRemoteException(e11);
            }
        }

        public /* bridge */ /* synthetic */ void createDelegate(OnDelegateCreatedListener onDelegateCreatedListener) {
            super.createDelegate(onDelegateCreatedListener);
        }
    }

    public TextureMapView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, true);
        a(context, attributeSet != null ? HuaweiMapOptions.createFromAttributes(context, attributeSet) : null);
    }

    public TextureMapView(Context context, HuaweiMapOptions huaweiMapOptions) {
        super(context, huaweiMapOptions, true);
        a(context, huaweiMapOptions);
    }

    private void a(Context context, HuaweiMapOptions huaweiMapOptions) {
        MapLifecycleDelegate mapLifecycleDelegate;
        if (!MapsInitializer.a()) {
            LogM.e("TextureMapView", "MapsInitializer is not initialized.");
            return;
        }
        if (MapsAdvUtil.containsMapsBasic()) {
            com.huawei.hms.maps.common.util.maa.a(context);
            AuthClient.getInstance().startAuth(context);
            mapLifecycleDelegate = new MapView.mab(this, context, new MapViewDelegate(context, huaweiMapOptions, true));
        } else {
            mapLifecycleDelegate = new maa(this, context, huaweiMapOptions);
        }
        this.f49328a = mapLifecycleDelegate;
    }
}
