package com.fanhl.logview.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by fanhl on 16/5/2.
 */
public class SystemUtil {
    /**
     * Copy text to clipboard.
     *
     * @param context
     * @param string
     */
    public static void copyToClipboard(Context context, String string) {
        ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE))
                .setPrimaryClip(ClipData.newPlainText("text", string));
    }
}
