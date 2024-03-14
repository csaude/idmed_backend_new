CREATE TABLE public.facility_type (
                                      id varchar(255) NOT NULL,
                                      "version" int8 NOT NULL,
                                      code varchar(255) NOT NULL,
                                      description varchar(255) NOT NULL,
                                      CONSTRAINT facility_type_pkey PRIMARY KEY (id),
                                      CONSTRAINT uk_dw8fqu6vcmx9asdj7hhnyqlnc UNIQUE (code)
);
CREATE INDEX pk_facilitytype_idx ON public.facility_type USING btree (id);

CREATE TABLE public.province (
                                 id varchar(255) NOT NULL,
                                 "version" int8 NOT NULL,
                                 code varchar(255) NOT NULL,
                                 description varchar(255) NOT NULL,
                                 CONSTRAINT province_pkey PRIMARY KEY (id),
                                 CONSTRAINT uk_6k05k4x3elbtlqxrmsuere05q UNIQUE (code)
);
CREATE INDEX pk_province_idx ON public.province USING btree (id);


CREATE TABLE public.district (
                                 id varchar(255) NOT NULL,
                                 "version" int8 NOT NULL,
                                 province_id varchar(255) NOT NULL,
                                 code varchar(255) NOT NULL,
                                 description varchar(255) NOT NULL,
                                 CONSTRAINT district_pkey PRIMARY KEY (id),
                                 CONSTRAINT uk81b35a11253eb55a8d778444f996 UNIQUE (province_id, code)
);
CREATE INDEX pk_district_idx ON public.district USING btree (id);
ALTER TABLE public.district ADD CONSTRAINT fk276utu38g5lgqeth6pwfm3rw2 FOREIGN KEY (province_id) REFERENCES public.province(id);


CREATE TABLE public.clinic (
                               id varchar(255) NOT NULL,
                               "version" int8 NOT NULL,
                               province_id varchar(255) NOT NULL,
                               code varchar(255) NOT NULL,
                               uuid varchar(255) NOT NULL,
                               national_clinic bool NULL,
                               active bool NOT NULL,
                               facility_type_id varchar(255) NOT NULL,
                               district_id varchar(255) NOT NULL,
                               notes varchar(255) NULL,
                               telephone varchar(12) NULL,
                               main_clinic bool NOT NULL,
                               clinic_name varchar(255) NOT NULL,
                               CONSTRAINT clinic_pkey PRIMARY KEY (id),
                               CONSTRAINT uk_2j5tyt28hsc67byvwgxq1y9ty UNIQUE (uuid),
                               CONSTRAINT ukdf9327f8beb951bb03e42c2bde2a UNIQUE (district_id, province_id, clinic_name)
);
CREATE INDEX pk_clinic_idx ON public.clinic USING btree (id);


-- public.clinic foreign keys

ALTER TABLE public.clinic ADD CONSTRAINT fkah5b8llknts8eoitj90ny13le FOREIGN KEY (facility_type_id) REFERENCES public.facility_type(id);
ALTER TABLE public.clinic ADD CONSTRAINT fkf5qpk00evo0bg3u92nn1rprso FOREIGN KEY (province_id) REFERENCES public.province(id);
ALTER TABLE public.clinic ADD CONSTRAINT fkohrqd22pd0ols67rll4xa83ev FOREIGN KEY (district_id) REFERENCES public.district(id);


CREATE TABLE public.clinic_sector (
                                      id varchar(255) NOT NULL,
                                      "version" int8 NOT NULL,
                                      code varchar(255) NOT NULL,
                                      uuid varchar(255) NOT NULL,
                                      active bool NOT NULL,
                                      sync_status varchar(255) NOT NULL,
                                      clinic_id varchar(255) NOT NULL,
                                      description varchar(255) NOT NULL,
                                      CONSTRAINT clinic_sector_pkey PRIMARY KEY (id),
                                      CONSTRAINT uk_hyt5bdpj308x2bs2ykc9pnjr5 UNIQUE (uuid),
                                      CONSTRAINT uk_kv1q1c7k7rf54xxo7ufiq20dd UNIQUE (code)
);



-- public.clinic_sector foreign keys

ALTER TABLE public.clinic_sector ADD CONSTRAINT fkk1tjdieng989pt0iopkw4vwff FOREIGN KEY (clinic_id) REFERENCES public.clinic(id);


-- public.district foreign keys