package org.wannes.plugmodcore.overview;
import org.wannes.plugmodcore.velocity.api.*;
import org.wannes.plugmodcore.network.*;
import org.wannes.plugmodcore.overview.api.OverviewService;
import com.velocitypowered.api.command.SimpleCommand;
public final class OverviewModule implements VelocityModule {
    public void onEnable(PlatformContext platform){if(!(platform instanceof VelocityContext context))throw new IllegalStateException("Velocity runtime required");context.registerService(OverviewService.class,()->context.proxy().getAllServers().size());context.registerCommand("networkservers",new SimpleCommand(){public boolean hasPermission(Invocation i){return i.source().hasPermission("plugmodcore.network.view");}public void execute(Invocation i){i.source().sendMessage(net.kyori.adventure.text.Component.text("Network servers: "+context.proxy().getAllServers().stream().map(s->s.getServerInfo().getName()).sorted().toList()));}});context.log("Native Velocity overview enabled");}
    public void onDisable(){}
}
