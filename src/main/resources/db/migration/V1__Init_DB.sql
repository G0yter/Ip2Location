CREATE TABLE ip2location(
                                ip_from bigint NOT NULL,
                                ip_to bigint NOT NULL,
                                country_code character(2) NOT NULL,
                                country_name character varying(64) NOT NULL,
                                region_name character varying(128) NOT NULL,
                                city_name character varying(128) NOT NULL,
                                latitude real NOT NULL,
                                longitude real NOT NULL,
                                CONSTRAINT ip2location_pkey PRIMARY KEY (ip_from, ip_to)

);

COPY ip2location FROM '/home/goyter/developing/IdeaProjects/geo/data/IP2LOCATION-LITE-DB5.CSV' WITH CSV QUOTE AS '"';

ALTER TABLE ip2location ADD canonicalip character varying(20) NULL;
ALTER TABLE ip2location ADD ipv4 bigint NULL;

