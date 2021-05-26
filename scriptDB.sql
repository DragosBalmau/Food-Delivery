create table users
(
    id               int auto_increment primary key,
    first_name       varchar(20)      not null,
    last_name        varchar(20)      not null,
    password         varchar(20)      not null,
    location         varchar(50)      null,
    card_id          varchar(16)      null,
    telephone_number varchar(12)      null,
    email            varchar(20)      null,
    balance          double default 0 null
);

create table restaurants
(
    name             varchar(20) not null primary key,
    telephone_number varchar(12) not null,
    location         varchar(50) not null
);


create table deliverymen
(
    id               int auto_increment primary key,
    first_name       varchar(20)      not null,
    last_name        varchar(20)      not null,
    password         varchar(20)      not null,
    location         varchar(20)      null,
    card_id          varchar(16)      null,
    telephone_number varchar(12)      null,
    email            varchar(20)      null,
    balance          double default 0 null,
    vehicle_type     varchar(20)      not null,
    rating           int    default 0 null
);

create table commands
(
    id                 int auto_increment primary key,
    products           varchar(200) not null,
    user_id_fk         int          not null,
    restaurant_name_fk varchar(20)  not null,
    deliverymen_id_fk  int          not null,
    constraint commands_deliverymen_fk foreign key (deliverymen_id_fk) references deliverymen (id),
    constraint commands_restaurants_fk foreign key (restaurant_name_fk) references restaurants (name),
    constraint commands_users_fk foreign key (user_id_fk) references users (id)
);