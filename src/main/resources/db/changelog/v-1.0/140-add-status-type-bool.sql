alter table albums
    drop column status;

alter table images drop column if exists status;

alter table images drop column if exists extension;

alter table images add column extension varchar not null;

alter table albums
    add column status bool not null;
