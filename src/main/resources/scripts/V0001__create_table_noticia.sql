create table noticia (
	id bigserial not null,
	titulo character varying(200),
	texto character varying(1000),
	data_publicacao timestamp without time zone,
	constraint noticia_pk primary key(id)
);