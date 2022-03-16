create table book (
    id serial not null primary key,
    title varchar(255) not null,
    author varchar(255) not null,
    item_url text not null,
    image_url text not null,
    created_at timestamp not null default current_timestamp
);
