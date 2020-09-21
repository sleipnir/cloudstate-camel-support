package io.cloudstate;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;

import java.util.concurrent.ExecutorService;

/**
 * Cloudstate Camel component support.
 *
 */
@UriEndpoint(firstVersion = "0.1.1", scheme = "cloudstate", title = "Cloudstate", syntax="cloudstate:entityType/action/command",
             consumerClass = CloudStateConsumer.class, label = "custom")
public class CloudStateEndpoint extends DefaultEndpoint {

    @UriParam
    private EntityConfiguration configuration;

    public CloudStateEndpoint() {}

    public CloudStateEndpoint(String uri, CloudStateComponent component, EntityConfiguration configuration) {
        super(uri, component);
        this.configuration = configuration;
    }

    public Producer createProducer() throws Exception {
        return new CloudStateProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new CloudStateConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    /**
     * The component configurations
     */
    public EntityConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(EntityConfiguration configuration) {
        this.configuration = configuration;
    }

    public ExecutorService createExecutor() {
        // TODO: Delete me when you implementy your custom component
        return getCamelContext().getExecutorServiceManager().newSingleThreadExecutor(this, "CloudStateConsumer");
    }
}
