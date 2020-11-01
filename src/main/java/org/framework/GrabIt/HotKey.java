package org.framework.GrabIt;

import javax.swing.*;

public class HotKey {
	public KeyStroke keyStroke;
    public MediaKey mediaKey;
    public HotKeyListener listener;

    public HotKey(KeyStroke keyStroke, HotKeyListener listener) {
        this.keyStroke = keyStroke;
        this.listener = listener;
    }

    public HotKey(MediaKey mediaKey, HotKeyListener listener) {
        this.mediaKey = mediaKey;
        this.listener = listener;
    }

    public boolean isMedia() {
        return mediaKey != null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HotKey");
        if (keyStroke != null)
            sb.append("{").append(keyStroke.toString().replaceAll("pressed ", ""));
        if (mediaKey != null)
            sb.append("{").append(mediaKey);
        sb.append('}');
        return sb.toString();
    }
}
