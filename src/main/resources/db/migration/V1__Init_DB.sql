CREATE TABLE `ip2location_db5`(
                                  `ip_from` INT UNSIGNED,
                                  `ip_to` INT UNSIGNED,
                                  `country_code` CHAR(2),
                                  `country_name` VARCHAR(64),
                                  `region_name` VARCHAR(64),
                                  `city_name` VARCHAR(64),
                                  `latitude` DOUBLE,
                                  `longitude` DOUBLE,
                                  `canonicalip` VARCHAR(15) null,
                                  `ipv4` INT UNSIGNED null
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOAD DATA LOCAL
    INFILE '/home/goyter/developing/IdeaProjects/geo/data/IP2LOCATION-LITE-DB5.CSV'
    INTO TABLE
    `ip2location_db5`
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\r\n'
    IGNORE 0 LINES;

CREATE INDEX idx_ip_from_to ON ip2location_db5(ip_from,ip_to);