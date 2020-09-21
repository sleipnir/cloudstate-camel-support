package io.cloudstate;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

import java.util.concurrent.ExecutorService;

/**
 * Cloudstate component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "0.1.1", scheme = "cloudstate", title = "Cloudstate", syntax="cloudstate:name",
             consumerClass = CloudstateConsumer.class, label = "custom")
public class CloudstateEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = true)
    private String name;
    @UriParam(defaultValue = "10")
    private int option = 10;

    public CloudstateEndpoint() {
    }

    public CloudstateEndpoint(String uri, CloudstateComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new CloudstateProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new CloudstateConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public ExecutorService createExecutor() {
        // TODO: Delete me when you implementy your custom component
        return getCamelContext().getExecutorServiceManager().newSingleThreadExecutor(this, "CloudstateConsumer");
    }
}