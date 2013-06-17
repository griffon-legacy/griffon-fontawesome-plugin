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

/**
 * @author Andres Almiray
 */

import griffon.plugins.fontawesome.FontAwesome
import griffon.plugins.fontawesome.FontAwesomeIcon
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.util.concurrent.CountDownLatch

target(fontAwesomeIconSelector: 'Displays all FontAwesome icons') {
    // hack to avoid script from terminating before time
    CountDownLatch latch = new CountDownLatch(1i)
    def swing = new SwingBuilder()
    swing.edt {
        swing.frame(title: 'FontAwesome Icons', pack: true, visible: true, resizable: true,
            defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE,
            windowClosed: { latch.countDown() }) {
            scrollPane(preferredSize: [620, 420]) {
                panel {
                    gridLayout(cols: 4, rows: FontAwesome.values().size() / 4)
                    FontAwesome.values().each { font ->
                        label(font.description, icon: new FontAwesomeIcon(font), toolTipText: font.description)
                    }
                }
            }
        }
    }

    latch.await()
}
setDefaultTarget(fontAwesomeIconSelector)
