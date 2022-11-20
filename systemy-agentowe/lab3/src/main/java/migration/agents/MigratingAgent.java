package migration.agents;

import jade.content.ContentManager;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.Location;
import jade.domain.mobility.MobilityOntology;
import lombok.Getter;
import lombok.Setter;
import migration.behaviours.RequestContainersListBehaviour;

import java.util.List;

public class MigratingAgent extends Agent {

    @Getter
    @Setter
    private List<Location> locationList;
    @Override
    protected void setup() {
        super.setup();
        ContentManager cm = getContentManager();
        cm.registerLanguage(new SLCodec());
        cm.registerOntology(MobilityOntology.getInstance());
        //register languages
        //register ontologies
        //add behaviours
        this.addBehaviour(new RequestContainersListBehaviour(this));
    }
    @Override
    protected void afterMove() {
        super.afterMove();
        //restore state
        //resume threads
    }
    @Override
    protected void beforeMove() {
        //stop threads
        //save state
        super.beforeMove();
    }
}
