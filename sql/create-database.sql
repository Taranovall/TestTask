create table degree
(
    id bigint not null
        primary key,
    name varchar(255)
);

create table lector
(
    id bigint not null
        primary key,
    first_name varchar(255),
    last_name varchar(255),
    salary integer not null,
    degree_id bigint
        constraint fkgl1ov1mr5r06n5eikvwla30f1
            references degree
);

create table department
(
    id bigint not null
        primary key,
    name varchar(255)
);

create table department_lectors
(
    departments_id bigint not null
        constraint fkrhobawa2w94ofp4h5845ok2bi
            references department,
    lectors_id bigint not null
        constraint fkrp3vnn4rpynyn3ao6t5kls5ge
            references lector
);

create table head_of_department
(
    id bigint not null
        primary key,
    first_name varchar(255),
    last_name varchar(255),
    salary integer not null,
    department_id bigint
        constraint fkg0exds5uh5pk9b7587c4ws6m1
            references department
);

