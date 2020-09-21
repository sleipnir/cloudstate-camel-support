package io.cloudstate;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.support.DefaultComponent;

@org.apache.camel.spi.annotations.Component("cloudstate")
public class CloudStateComponent extends DefaultComponent {

    @Metadata
    private EntityConfiguration configuration = new EntityConfiguration();
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        //set configurations
        //entityType/action/command
        if (remaining == null || remaining.trim().length() == 0) {
            throw new IllegalArgumentException("At least the entity type must be specified.");
        }

        final EntityConfiguration configuration
                = this.configuration != null ? this.configuration.copy() : new EntityConfiguration();

        final String[] parts = remaining.split("/");

        // only account name is being set
        configuration.setEntityType(parts[0]);

        // also action name is being set
        if (parts.length > 1) {
            configuration.setAction(parts[1]);
        }

        // also command name is being set
        if (parts.length > 1) {
            configuration.setCommand(parts[2]);
        }

        Endpoint endpoint = new CloudStateEndpoint(uri, this, configuration);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
