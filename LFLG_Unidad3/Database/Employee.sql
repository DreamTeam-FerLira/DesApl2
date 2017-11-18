-- Table: public.employees

-- DROP TABLE public.employees;

CREATE TABLE public.employees
(
    id integer NOT NULL DEFAULT nextval('employees_id_seq'::regclass),
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    firstname character varying(20) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(20) COLLATE pg_catalog."default" NOT NULL,
    salary character varying(20) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(20) COLLATE pg_catalog."default" NOT NULL,
    attention character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employees
    OWNER to lira;