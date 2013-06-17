
FontAwesome icon support
------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/fontawesome](http://artifacts.griffon-framework.org/plugin/fontawesome)


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

    label('\uf09b', font: new Font('FontAwesome', Font.PLAIN, 64i))

Scripts
-------

 * **fontawesome-icon-selector** - launches a window that displays all available
 icons (Hover an icon to see the icon name)

[1]: http://fortawesome.github.io/Font-Awesome/
[2]: http://www.jroller.com/neugens/entry/font_awesome
[3]: http://www.jensd.de/wordpress/?p=132

