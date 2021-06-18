package com.zebra.jamesswinton.sonimpttremapper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class SonimPTTReceiver extends BroadcastReceiver {

    // WFC PTT Intents
    private static final String WFC_PTT_PRESSED = "com.symbol.wfc.ptt_pressed";
    private static final String WFC_PTT_RELEASED = "com.symbol.wfc.ptt_released";

    // Sonim PTT Intents
    private static final String SONIM_PTT_PRESSED = "com.sonim.intent.action.PTT_KEY_DOWN";
    private static final String SONIM_PTT_RELEASED = "com.sonim.intent.action.PTT_KEY_UP";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            switch (intentAction) {
                case SONIM_PTT_PRESSED:
                    context.sendBroadcast(new Intent(WFC_PTT_PRESSED));
                    break;
                case SONIM_PTT_RELEASED:
                    context.sendBroadcast(new Intent(WFC_PTT_RELEASED));
                    break;
            }
        }
    }
}
