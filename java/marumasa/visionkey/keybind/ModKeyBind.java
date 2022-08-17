package marumasa.visionkey.keybind;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class ModKeyBind {
    public static KeyMapping[] ModKeys;

    public static void register() {
        ModKeys = new KeyMapping[1];
        ModKeys[0] = crate("toggle", KeyEvent.VK_V);

        for (KeyMapping modKey : ModKeys) {
            ClientRegistry.registerKeyBinding(modKey);
        }
    }

    private static KeyMapping crate(String name, int key) {
        return new KeyMapping("key.visionkey." + name, key, "key.category.visionkey");
    }
}