package fr.titi.infinity.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class FlyArmorN {


    public static int fly;

    public FlyArmorN(int fly){
        this.fly = fly;
    }

    public static void encode(FlyArmorN flyArmorN, PacketBuffer packetBuffer) {
        packetBuffer.writeInt(flyArmorN.fly);
    }

    public static FlyArmorN decode(PacketBuffer packetBuffer) {
        int fly = packetBuffer.readInt();
        return new FlyArmorN(fly);
    }

    public static void handle(FlyArmorN packet, Supplier<NetworkEvent.Context> ctx) {
        ServerPlayerEntity player = ctx.get().getSender();

        int fly = packet.fly;
        if (fly == 1) {
            player.displayClientMessage(new StringTextComponent("nombre : " + fly),true);
            player.abilities.flying = true;
            player.abilities.setFlyingSpeed(0.05f);
        } else {
            player.displayClientMessage(new StringTextComponent("nombre : " + fly),true);
            player.abilities.flying = false;
        }

    }


}
