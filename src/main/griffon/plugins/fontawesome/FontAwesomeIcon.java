/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.fontawesome;

import javax.swing.Icon;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Based on original code by Mario Torre<br/>
 * http://icedtea.classpath.org/people/neugens/SwingUIPatterns/file/f4528c35cc0c/src/main/java/org/icedtea/ui/patterns/swing/images/FontAwesomeIcon.java
 *
 * @author Andres Almiray
 */
public class FontAwesomeIcon implements Icon {
    private static final String AWESOME_SET = "META-INF/resources/webjars/font-awesome/3.1.1/font/fontawesome-webfont.ttf";

    private int size;
    private BufferedImage buffer;

    private FontAwesome id;
    private static final Font awesome;

    private Font font;

    static {
        try {
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(AWESOME_SET);
            awesome = Font.createFont(Font.TRUETYPE_FONT, stream);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(awesome);
            stream.close();
        } catch (FontFormatException ffe) {
            throw new RuntimeException(ffe);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public FontAwesomeIcon(FontAwesome id) {
        this.id = id;
        setSize(16);
    }

    public FontAwesomeIcon(String description) {
        this(FontAwesome.findByDescription(description));
    }

    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        if (buffer == null) {
            buffer = new BufferedImage(getIconWidth(), getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);

            Graphics2D graphics = (Graphics2D) buffer.getGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

            graphics.setFont(font);
            graphics.setColor(Color.BLACK);

            int sy = size - (size / 4) + (size/16);
            graphics.drawString(String.valueOf(id.getCode()), 0, sy);

            graphics.dispose();
        }

        g.drawImage(buffer, x, y, null);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
            font = awesome.deriveFont(Font.PLAIN, size);
        }
    }

    public int getIconHeight() {
        return size;
    }

    public int getIconWidth() {
        return size;
    }
}
