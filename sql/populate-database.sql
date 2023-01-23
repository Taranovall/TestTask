insert into degree (id, name)
values  (1, 'Assistant'),
        (2, 'Associate professor'),
        (3, 'Professor');

insert into department (id, name)
values  (1, 'dep1'),
        (2, 'dep2');

insert into lector (id, first_name, last_name, salary, degree_id)
values  (1, 'Ivan', 'Ivanov', 15000, 1),
        (2, 'Sergey', 'Sergeev', 12000, 3),
        (3, 'Romeo', 'Perez', 13000, 2),
        (4, 'Christian', 'Miller', 12000, 2),
        (5, 'Alexis', 'Harris', 17877, 1);

insert into department_lectors (departments_id, lectors_id)
values  (1, 1),
        (1, 2),
        (2, 1),
        (1, 3),
        (1, 4);

insert into head_of_department (id, first_name, last_name, salary,department_id)
values  (1, 'Oscar', 'Hanson', 19000,1),
        (2, 'Elliot', 'Klein', 18000,2);

