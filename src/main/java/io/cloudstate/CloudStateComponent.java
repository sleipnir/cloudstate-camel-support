package io.cloudstate;

import java.util.Map;

import org.apache.camel.Endpoint;

import org.apache.camel.support.DefaultComponent;

import org.apache.camel.spi.Metadata;

@org.apache.camel.spi.annotations.Component("cloudstate")
public class CloudStateComponent extends DefaultComponent {

    @Metadata
    private EntityConfiguration configuration = new EntityConfiguration();
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        //set configuration
        Endpoint endpoint = new CloudStateEndpoint(uri, this, configuration);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
