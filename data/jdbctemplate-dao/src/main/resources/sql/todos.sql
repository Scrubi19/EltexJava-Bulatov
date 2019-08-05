create table todos
(
    id int not null,
    text varchar(255),
    description varchar(255)
);

create unique index todos_id_uindex
    on todos (id);

alter table todos
    add constraint todos_pk
        primary key (id);

insert INTO todos values (1, 'textTest','descriptionTest')
