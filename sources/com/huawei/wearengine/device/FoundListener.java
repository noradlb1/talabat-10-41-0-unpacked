package com.huawei.wearengine.device;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

public interface FoundListener extends IInterface {

    public static class Default implements FoundListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDeviceFound(List<Device> list) {
        }
    }

    public static abstract class Stub extends Binder implements FoundListener {
        private static final String DESCRIPTOR = "com.huawei.wearengine.device.FoundListener";

        public static class Proxy implements FoundListener {
            public static FoundListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onDeviceFound(List<Device> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.readTypedList(list, Device.CREATOR);
                    } else {
                        Stub.getDefaultImpl().onDeviceFound(list);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static FoundListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof FoundListener)) ? new Proxy(iBinder) : (FoundListener) queryLocalInterface;
        }

        public static FoundListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(FoundListener foundListener) {
            if (Proxy.sDefaultImpl != null || foundListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = foundListener;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                ArrayList<Device> createTypedArrayList = parcel.createTypedArrayList(Device.CREATOR);
                onDeviceFound(createTypedArrayList);
                parcel2.writeNoException();
                parcel2.writeTypedList(createTypedArrayList);
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onDeviceFound(List<Device> list);
}
