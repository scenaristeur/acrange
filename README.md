# Système multi-agent en ligne

j'avais testé ce code sur HEROKU.com pour créer un système multi-agent (janus-project) en ligne avec jetty, mais les dépendances Maven semblent maintenant poser problème ... GRRRR si quelqu'un a une idée :-) voir le fichier https://github.com/scenaristeur/acrange/blob/master/error.txt

ça donnait ça : https://acrange.herokuapp.com/hello

## Running the application locally

First build with:

    $mvn clean install

Then run it with:

    $java -cp target/classes:target/dependency/* com.example.Main

