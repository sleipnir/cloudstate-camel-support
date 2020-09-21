
package io.cloudstate;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

@UriParams
public class EntityConfiguration implements Cloneable {
    
    //protocol:entityType/action/command
   // cloudstate:eventsourced/snapshot/handleSnapshot

    @UriPath 
    @Metadata(required = true)
    private String entityType;

    @UriPath 
    @Metadata(required = true)
    private String action;

    @UriPath 
    @Metadata(required = true)
    private String command;

    /**
    * Set Entity type. E.g.: eventsourced, actions, crdt
    */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    /**
    * Set action. E.g.: snapshot, command, event
    */
    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    /**
     * Set command. E.g.: addItem, getItem
     */
    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}