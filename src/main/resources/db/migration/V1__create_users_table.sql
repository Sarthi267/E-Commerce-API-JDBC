create table if not exists users(
                                    id serial primary key,
                                    username varchar(30) not null unique,
                                    password varchar(255) not null unique,
                                    email varchar(50) not null unique,
                                    first_name varchar(50) not null,
                                    last_name varchar(50) not null,
                                    phone_number varchar(20) not null,
                                    address varchar(30) not null unique,
                                    city varchar(30) not null unique,
                                    "state" char(2) not null unique,
                                    country varchar(60) not null unique,
                                    postal_code varchar(15) not null unique
);;