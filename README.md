# TheBooklist
a simple example of integrating spring boot  Rest service and Vue with a web MVC 

The project can be run from the root directory by simply 'mvn jetty:run'. The site will be live at http://localhost:8080



The  webmvc parent  project is to start off the booklist using the resources from two child projects:

booklist-eclipse-back -> this is a spring boot maven project can be built by 'mvn build ' command;
the target directory holds the generated jar file .The seed data is in data,sql in the repository directory.

and

booklist-sublime-front -> this project can be run independently by ' npm run serve' or 'npm run build' command ;
the resorces produced in the dist directory; 


THe dist files are brought in the webmvc parent project and put in the webapp directory .[currently this step  is not scripted, should be done manualy,if the front end code changes]


The mvn jetty:run from the parent project kicks off the jar file produced in the booklist-eclipse-back project and serves the Vue client html from webapp directory.





