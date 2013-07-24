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
class FontawesomeGriffonPlugin {
    // the plugin version
    String version = '1.1.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.3.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.3.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-fontawesome-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = "FontAwesome icon support"
    String description = '''
Provides a shortcut for adding icons based on [Font-Awesome][1]. This plugin is
inspired in the work done by [Mario Torre][2] and [Jens Deters][3].

Usage
-----

The following nodes will become available on a View script upon installing this
plugin

| *Node*          | *Property* | *Type* | *Default*   | *Bindable* |
| --------------- | ---------- | ------ | ----------- | ---------- |
| fontAwesomeIcon | icon       | String |             | no         |
|                 | size       | int    | 16          | no         |
|                 | color      | Color  | Color.BLACK | no         |

Valid values for `icon` can be obtained by running **fontawesome-icon-selector**
and inspecting the tooltip of the chosen icon. `FontAwesome` is automatically
registered with the local GraphicsEnvironment, which means you can use it anywhere,
for example

    label('\\uf09b', font: new Font('FontAwesome', Font.PLAIN, 64i))

Scripts
-------

 * **fontawesome-icon-selector** - launches a window that displays all available
 icons (Hover an icon to see the icon name)

[1]: http://fortawesome.github.io/Font-Awesome/
[2]: http://www.jroller.com/neugens/entry/font_awesome
[3]: http://www.jensd.de/wordpress/?p=132
'''
}
