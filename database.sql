-- Table: public.categorias

-- DROP TABLE IF EXISTS public.categorias;

CREATE TABLE IF NOT EXISTS public.categorias
(
    id_categoria integer NOT NULL DEFAULT nextval('categorias_id_categoria_seq'::regclass),
    nombre_categoria character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categorias_pkey PRIMARY KEY (id_categoria),
    CONSTRAINT categorias_nombre_categoria_key UNIQUE (nombre_categoria)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categorias
    OWNER to postgres;

-- Table: public.empleados

-- DROP TABLE IF EXISTS public.empleados;

CREATE TABLE IF NOT EXISTS public.empleados
(
    id_empleado integer NOT NULL DEFAULT nextval('empleados_id_empleados_seq'::regclass),
    nombre character varying(100) COLLATE pg_catalog."default" NOT NULL,
    puesto character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT empleados_pkey PRIMARY KEY (id_empleado)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.empleados
    OWNER to postgres;

-- Table: public.productos

-- DROP TABLE IF EXISTS public.productos;

CREATE TABLE IF NOT EXISTS public.productos
(
    nombre_producto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    precio numeric NOT NULL,
    stock integer NOT NULL,
    id_categoria integer,
    id_proveedor integer,
    id_producto integer NOT NULL DEFAULT nextval('productos_id_producto_seq'::regclass),
    CONSTRAINT productos_pkey PRIMARY KEY (id_producto),
    CONSTRAINT productos_id_categoria_fkey FOREIGN KEY (id_categoria)
        REFERENCES public.categorias (id_categoria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT productos_id_proveedor_fkey FOREIGN KEY (id_proveedor)
        REFERENCES public.proveedores (id_proveedor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.productos
    OWNER to postgres;


 -- Table: public.proveedores

 -- DROP TABLE IF EXISTS public.proveedores;

 CREATE TABLE IF NOT EXISTS public.proveedores
 (
     id_proveedor integer NOT NULL DEFAULT nextval('proveedores_id_proveedores_seq'::regclass),
     contacto character varying(100) COLLATE pg_catalog."default" NOT NULL,
     suministra character varying(100) COLLATE pg_catalog."default" NOT NULL,
     nombre_proveedor character varying(50) COLLATE pg_catalog."default",
     CONSTRAINT proveedores_pkey PRIMARY KEY (id_proveedor),
     CONSTRAINT proveedores_contacto_key UNIQUE (contacto)
 )

 TABLESPACE pg_default;

 ALTER TABLE IF EXISTS public.proveedores
     OWNER to postgres;

-- Table: public.ventas

-- DROP TABLE IF EXISTS public.ventas;

CREATE TABLE IF NOT EXISTS public.ventas
(
    id_venta integer NOT NULL DEFAULT nextval('ventas_id_venta_seq'::regclass),
    fecha character varying(20) COLLATE pg_catalog."default",
    total numeric NOT NULL,
    id_empleado integer,
    CONSTRAINT ventas_pkey PRIMARY KEY (id_venta),
    CONSTRAINT ventas_id_empleado_fkey FOREIGN KEY (id_empleado)
        REFERENCES public.empleados (id_empleado) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.ventas
    OWNER to postgres;