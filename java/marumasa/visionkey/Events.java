package marumasa.visionkey;

import marumasa.visionkey.keybind.ModKeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {
    private static final Minecraft mc = Minecraft.getInstance();

    private static double gamma = mc.options.gamma;

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
        if (ModKeyBind.ModKeys[0].isDown()) {
            ChatComponent chat = Minecraft.getInstance().gui.getChat();
            if (mc.options.gamma == 1024) {
                mc.options.gamma = gamma;
                chat.addMessage(new TranslatableComponent("toggle.visionkey.off"));
            } else {
                gamma = mc.options.gamma;
                mc.options.gamma = 1024;
                chat.addMessage(new TranslatableComponent("toggle.visionkey.on"));
            }
        }
    }
    @SubscribeEvent
    public void reset(PlayerEvent.PlayerLoggedOutEvent event){
        mc.options.gamma = gamma;
    }
}
