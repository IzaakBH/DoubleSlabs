package cjminecraft.doubleslabs;

import cjminecraft.doubleslabs.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(name = DoubleSlabs.NAME, version = DoubleSlabs.VERSION, modid = DoubleSlabs.MODID, acceptedMinecraftVersions = DoubleSlabs.ACCEPTED_MC_VERSIONS)
public class DoubleSlabs
{
    public static final String NAME = "DoubleSlabs";
    public static final String MODID = "doubleslabs";
    public static final String VERSION = "${version}";
    public static final String ACCEPTED_MC_VERSIONS = "[1.12,1.12.2]";
    public static final String SERVER_PROXY_CLASS = "cjminecraft.doubleslabs.proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "cjminecraft.doubleslabs.proxy.ClientProxy";
    public static final Logger LOGGER = LogManager.getFormatterLogger(NAME);

    @SidedProxy(serverSide = SERVER_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
