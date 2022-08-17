package marumasa.visionkey;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("visionkey")
public class minecraft {
    public static final String modid = "visionkey";
    public minecraft() {
        MinecraftForge.EVENT_BUS.register((new Events()));
    }
}
