# GeoDistance
### Starting GeoDistance application:
* Create database 'geo_distance'
* Open 'application.properties' which is in src->main->resources
* Set 'spring.datasource.url', 'spring.datasource.username' and 'spring.datasource.password'
* Data for database is provided by flyway migration, and there is no need to manually add them. Data is downloaded from this link: https://www.freemaptools.com/download/full-postcodes/ukpostcodesmysql.zip and reduced on 10.000 rows, for faster initializing database.
* Run 'mvn clean install' in root project directory
* Start app with command from root directory 'java -jar target/GeoDistance-0.0.1-SNAPSHOT.jar'
* You can run app from command line or from eclipse
