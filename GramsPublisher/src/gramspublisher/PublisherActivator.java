package gramspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PublisherActivator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Grams Converter Publisher Started...");
		
		GramsConverter converter = new GramsCalculator();
		registration = context.registerService(GramsConverter.class.getName(), converter, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Grams Converter Publisher Stopped...");
		registration.unregister();
	}
}
