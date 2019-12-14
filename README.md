Launch instructions
1) Firstly it is necessary to clone the repository of the project by
    git clone https://github.com/G0yter/Ip2Location.git
2) Then to extract the archive with DB. It is possible to do that by script in the project, but at first that is necessary to give the rights to execute this script.
        Go to the working directory. Write to the console:
            1) chmod u+x scripts/extractor.sh
            2) ./scripts/extractor.sh            
3) Go to the DBMS by MySQL Workbench or by command line and write:

            mysql -u {username} -p and make consecutive requests:
            1) CREATE DATABASE ip2location;
            
4) Change the data in application.properties, pom.xml(settings of flyway plugin) on yours and indicate a right path to the file .csv in migration file(V1__Init_DB.sql)
5) Build the project mvn clean install
6) Run IT java -jar target/geo-0.0.1-SNAPSHOT.jar

               


Инструкция к запуску:
1) Изначально нужно клонировать репозиторий проекта командой
    git clone https://github.com/G0yter/Ip2Location.git
2) Далее нужно распаковать архив с Базой данных. Это можно сделать скриптом в проекте, но сначала ему нужно дать права.
    Заходим в рабочий каталог. Даем права: 
            chmod u+x scripts/extractor.sh
                               Распаковываем файл:
            ./scripts/extractor.sh
3) Пишем в консоль:
            mysql -u {username} -p и делаем последовательные запросы:
            1) CREATE DATABASE ip2location;
            
4) Нужно изменить данные в application.properties, pom.xml(настройка flyway плагина) на свои, а также указать верный путь к файлу .csv в файле миграции               
5) Собираем проект : mvn clean install
6) Запускаем проект: java -jar target/geo-0.0.1-SNAPSHOT.jar
