package ir.alirezaiyan.dagger.auth.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

import javax.inject.Inject;

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 5/14/2020 6:49 PM.
 */
public class DeviceIdentifier {
    public String androidId;

    @SuppressLint("HardwareIds")
    @Inject
    public DeviceIdentifier(Context context) {
        this.androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


}
