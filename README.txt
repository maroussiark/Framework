- Fonctionnalite framework :
    * Traitement de tout les urls de l'app par le FrontServlet
-XML :
    ?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">

    <servlet>
        <servlet-name>FrontServlet</servlet-name>
        <servlet-class>etu1833.framework.servlet.FrontServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>FrontServlet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>jsp</servlet-name>
        <url-pattern>/page/*</url-pattern>
    </servlet-mapping>
    <session-config>
        <session-timeout>
            30
        </session-timeout>
    </session-config>
</web-app>


- Contraintes :
    -> Les class modeles doivent toujours avoir un constructeur vide
    -> Pour envoyer des donnees a un view :
        *Le type de retour des fonctions doit etre de type "ModelView"
        *annoter la fonction ex : @Url(valeur="url")
        *setView = pour ajouter le nom du page pour l'affichage ("***.jsp") 
        *addItem = pour ajouter les donnees a envoyer avec sa cle ("cle",data)
    -> Mettre les fichiers jsp dans le repertoire "page" (meme chemin que le WEB-INF)
    -> Pour recuperer les valeurs venant d'un view :
        *le nom de l'attribut doit etre meme que le nom de l'attribut du requete
        *idem pour le nom du parametre de la fonction