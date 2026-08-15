create table if not exists products(
                                       id serial primary key,
                                       "name" varchar (255) not null,
                                       description text,
                                       image varchar (255),
                                       category varchar (50)
);;