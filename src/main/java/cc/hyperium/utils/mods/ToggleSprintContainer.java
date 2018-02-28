/*
 * Hyperium Client, Free client with huds and popular mod
 *     Copyright (C) 2018  Hyperium Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.hyperium.utils.mods;

import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.KeyBindDisableEvent;
import cc.hyperium.event.KeyBindEnableEvent;
import cc.hyperium.handlers.handlers.chat.GeneralChatHandler;
import cc.hyperium.handlers.handlers.keybinds.KeyBindHandler;
import cc.hyperium.mixins.MixinKeyBinding;
import net.minecraft.client.Minecraft;

public class ToggleSprintContainer {
    @InvokeEvent
    public static void onkeyBindEnable(KeyBindEnableEvent event) {
        if (event.getKey() == KeyBindHandler.toggleSprint.getKey()) {
            GeneralChatHandler.instance().sendMessage("ToggleSprint Enabled!");
        }
    }

    @InvokeEvent
    public static void onKeyBindDisable(KeyBindDisableEvent event) {
        if (event.getKey() == KeyBindHandler.toggleSprint.getKey()) {
            // Disables ToggleSprint
            GeneralChatHandler.instance().sendMessage("ToggleSprint Disabled!");
            ((MixinKeyBinding) Minecraft.getMinecraft().gameSettings.keyBindSprint).setPressed(false);
        }
    }
}
