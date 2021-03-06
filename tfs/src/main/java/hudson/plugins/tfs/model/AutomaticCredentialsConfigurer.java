package hudson.plugins.tfs.model;

import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import hudson.Extension;
import hudson.plugins.tfs.TeamCollectionConfiguration;
import org.kohsuke.stapler.DataBoundConstructor;

import java.net.URI;

public class AutomaticCredentialsConfigurer extends CredentialsConfigurer {
    private static final long serialVersionUID = 1L;

    @DataBoundConstructor
    public AutomaticCredentialsConfigurer() {

    }

    @Override
    public StandardUsernamePasswordCredentials getCredentials(final String collectionUriString) {
        final URI collectionUri = URI.create(collectionUriString);
        return TeamCollectionConfiguration.findCredentialsForCollection(collectionUri);
    }

    @Extension
    public static final class DescriptorImpl extends CredentialsConfigurerDescriptor {

        @Override
        public String getDisplayName() {
            return "Automatic";
        }
    }
}
