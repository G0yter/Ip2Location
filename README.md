Launch instructions
1) Firstly it is necessary to clone the repository of the project by
    git clone https://github.com/G0yter/Ip2Location.git
2) Then extract the archive with DB. It is possible to do that by script in the project, but at first that is necessary to give the rights in order to execute this script.
        Go to the working directory. Write to the console:
            1) chmod u+x scripts/extractor.sh
            2) ./scripts/extractor.sh            
3) Go to the DBMS by MySQL Workbench or by command line and write:

            mysql -u {username} -p and make consecutive requests:
            1) CREATE DATABASE ip2location;
            2) USE ip2location;
            3) CREATE TABLE `ip2location_db5`(
                                          `ip_from` INT(10) UNSIGNED,
                                          `ip_to` INT(10) UNSIGNED,
                                          `country_code` CHAR(2),
                                          `country_name` VARCHAR(64),
                                          `region_name` VARCHAR(128),
                                          `city_name` VARCHAR(128),
                                          `latitude` DOUBLE,
                                          `longitude` DOUBLE,
                                          `canonicalip` varchar(15) null,
                                          `ipv4` int(10) null, 
                                          INDEX `idx_ip_from` (`ip_from`),
                                          INDEX `idx_ip_to` (`ip_to`),
                                          INDEX `idx_ip_from_to` (`ip_from`, `ip_to`)
                             ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
            4) LOAD DATA LOCAL
                                 INFILE '{CLASSPATH}:/dat/IP2LOCATION-LITE-DB5.CSV'
                                 INTO TABLE
                                 `ip2location_db5`
                                 FIELDS TERMINATED BY ','
                                 ENCLOSED BY '"'
                                 LINES TERMINATED BY '\r\n'
                                 IGNORE 0 LINES;
                                 
                                 IN LAST QUERY VARIABLE {CLASSPATH} is the absolute path to the file 
4) Change the data to yours in application.properties
5) Build the project mvn clean install
6) Run IT java -jar -jar target/geo-0.0.1-SNAPSHOT.jar
7) (PROBLEM with db migration -- mvn flyway:migrate generate exception THE USED COMMAND IS NOT ALLOWED WITH THIS MYSQL VERSION because of line Load Data Local )

               


Инструкция к запуску:
1) Изначально нужно клонировать репозиторий проекта командой
    git clone https://github.com/G0yter/Ip2Location.git
2) Далее нужно распаковать архив с Базой данных. Это можно сделать скриптом в проекте, но сначала ему нужно дать права.
    Заходим в рабочий каталог. Даем права: 
            chmod u+x scripts/extractor.sh
                               Распаковываем файл:
            ./scripts/extractor.sh
3) Заходим в СУБД через mySQL WorkBench или через командную строку командой:
            mysql -u {username} -p и делаем последовательные запросы:
            1) CREATE DATABASE ip2location;
            2) USE ip2location;
            3) CREATE TABLE `ip2location_db5`(
                                                 `ip_from` INT(10) UNSIGNED,
                                                 `ip_to` INT(10) UNSIGNED,
                                                 `country_code` CHAR(2),
                                                 `country_name` VARCHAR(64),
                                                 `region_name` VARCHAR(128),
                                                 `city_name` VARCHAR(128),
                                                 `latitude` DOUBLE,
                                                 `longitude` DOUBLE,
                                                 `canonicalip` varchar(15) null,
                                                 `ipv4` int(10) null, 
                                                 INDEX `idx_ip_from` (`ip_from`),
                                                 INDEX `idx_ip_to` (`ip_to`),
                                                 INDEX `idx_ip_from_to` (`ip_from`, `ip_to`)
               ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
            4) LOAD DATA LOCAL
                   INFILE '{CLASSPATH}/dat/IP2LOCATION-LITE-DB5.CSV'
                   INTO TABLE
                   `ip2location_db5`
                   FIELDS TERMINATED BY ','
                   ENCLOSED BY '"'
                   LINES TERMINATED BY '\r\n'
                   IGNORE 0 LINES;
                  
                  В ПОСЛЕДНЕМ ЗАПРОСЕ ПЕРЕМЕННАЯ {CLASSPATH} -- ЭТО АБСОЛЮТНЫЙ ПУТЬ К ФАЙЛУ
 
4) Нужно изменить данные в application.properties на свои               
5) Собираем проект : mvn clean install
6) Запускаем проект: java -jar target/geo-0.0.1-SNAPSHOT.jar

7) (Проблема с миграцией БД - mvn flyway:migrate не работает из-за строки LOAD DATA LOCAL -- the used command is not allowed with this mysql version)                  
