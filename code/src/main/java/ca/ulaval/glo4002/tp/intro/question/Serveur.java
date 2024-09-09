package ca.ulaval.glo4002.tp.intro.question;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import ca.ulaval.glo4002.tp.intro.question.interfaces.ConfigurationServeurRest;

public class Serveur implements Runnable {
    private static final int PORT = 8181;

    public static void main(String[] args) {
        new Serveur().run();
    }

    public void run() {
        Server serveur = new Server(PORT);
        ServletContextHandler contexte = new ServletContextHandler("/");
        serveur.setHandler(contexte);
        ResourceConfig configurationPackage = new ResourceConfig()
            .packages("ca.ulaval.glo4002.tp.intro.question")
            .register(ConfigurationServeurRest.class);
        ServletContainer conteneur = new ServletContainer(configurationPackage);
        ServletHolder conteneurServlet = new ServletHolder(conteneur);

        contexte.addServlet(conteneurServlet, "/*");

        try {
            serveur.start();
            System.out.println("Le serveur a démarré sur le port " + PORT);
            serveur.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serveur.isRunning()) {
                serveur.destroy();
            }
        }
    }
}
