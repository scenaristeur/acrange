# Système multi-agent en ligne

Ce projet permet d'exécuter des agents écrits avec le langage [SARL](http://www.sarl.io) et de les exécuter sur un serveur en ligne en utilisant la plateforme [Janus](http://www.janusproject.io) (version 2) pour exécuter les agents.

## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -cp target/classes:target/dependency/* com.example.Main

