package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class ModKeybindings {

    public static final KeyBinding FLY_KEY = new KeyBinding("key." + INFINITY.MODID + ".fly_key", GLFW.GLFW_KEY_F, "key.categories." + INFINITY.MODID);

    public static void  register(){

        ClientRegistry.registerKeyBinding(FLY_KEY);

    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event) {

        if (FLY_KEY.isDown()) {

            //System.out.println(FLY_KEY);
            //INFINITY.NETWORK.sendToServer(new FlyArmor(1));
        }

    }

}
