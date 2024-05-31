create table courses
(
    id          bigint not null auto_increment,
    teachers_id bigint,
    course_name varchar(255),
    primary key (id)
) engine = InnoDB;
create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table students
(
    age        integer not null,
    id         bigint  not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
) engine = InnoDB;
create table students_has_courses
(
    mark       integer not null,
    course_id  bigint,
    id         bigint  not null auto_increment,
    student_id bigint,
    primary key (id)
) engine = InnoDB;
create table teachers
(
    id         bigint not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
) engine = InnoDB;
create table users
(
    id       bigint not null auto_increment,
    username varchar(50),
    password varchar(255),
    primary key (id)
) engine = InnoDB;
create table users_rolesset
(
    rolesset_id bigint not null,
    users_id    bigint not null,
    primary key (rolesset_id, users_id)
) engine = InnoDB;
alter table courses
    add constraint UK_5unjjhtbffe6hcet1kar3sl8k unique (teachers_id);
alter table courses
    add constraint FKbapq8w0y157a9mms0n69nhir2 foreign key (teachers_id) references teachers (id);
alter table students
    add constraint FK7xqmtv7r2eb5axni3jm0a80su foreign key (id) references users (id);
alter table students_has_courses
    add constraint FKb56uvya34elqw4pmblir4q60a foreign key (course_id) references courses (id);
alter table students_has_courses
    add constraint FKm2x4af26f4lg8fsvjuqea3mpc foreign key (student_id) references students (id);
alter table teachers
    add constraint FKpavufmal5lbtc60csriy8sx3 foreign key (id) references users (id);
alter table users_rolesset
    add constraint FKbae8tw2kg6p1ja9cges83x7ha foreign key (rolesset_id) references roles (id);
alter table users_rolesset
    add constraint FKt7213is417582bjg6e95g5w53 foreign key (users_id) references users (id);