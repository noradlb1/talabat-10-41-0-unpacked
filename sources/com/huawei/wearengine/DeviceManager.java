package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.device.Device;
import java.util.List;

public interface DeviceManager extends IInterface {

    public static class Default implements DeviceManager {
        public IBinder asBinder() {
            return null;
        }

        public List<Device> getBondedDeviceEx() {
            return null;
        }

        public List<Device> getBondedDevices() {
            return null;
        }

        public String getHiLinkDeviceId(Device device) {
            return null;
        }

        public boolean hasAvailableDevices() {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements DeviceManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.DeviceManager";

        public static class Proxy implements DeviceManager {
            public static DeviceManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public List<Device> getBondedDeviceEx() {
                List<Device> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(Device.CREATOR);
                    } else {
                        createTypedArrayList = Stub.getDefaultImpl().getBondedDeviceEx();
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<Device> getBondedDevices() {
                List<Device> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(Device.CREATOR);
                    } else {
                        createTypedArrayList = Stub.getDefaultImpl().getBondedDevices();
                    }
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getHiLinkDeviceId(Device device) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getHiLinkDeviceId(device);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean hasAvailableDevices() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z11 = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAvailableDevices();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static DeviceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof DeviceManager)) ? new Proxy(iBinder) : (DeviceManager) queryLocalInterface;
        }

        public static DeviceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(DeviceManager deviceManager) {
            if (Proxy.sDefaultImpl != null || deviceManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = deviceManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                List<Device> bondedDevices = getBondedDevices();
                parcel2.writeNoException();
                parcel2.writeTypedList(bondedDevices);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean hasAvailableDevices = hasAvailableDevices();
                parcel2.writeNoException();
                parcel2.writeInt(hasAvailableDevices ? 1 : 0);
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                String hiLinkDeviceId = getHiLinkDeviceId(parcel.readInt() != 0 ? Device.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(hiLinkDeviceId);
                return true;
            } else if (i11 != 4) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                List<Device> bondedDeviceEx = getBondedDeviceEx();
                parcel2.writeNoException();
                parcel2.writeTypedList(bondedDeviceEx);
                return true;
            }
        }
    }

    List<Device> getBondedDeviceEx();

    List<Device> getBondedDevices();

    String getHiLinkDeviceId(Device device);

    boolean hasAvailableDevices();
}
