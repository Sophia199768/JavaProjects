CREATE TABLE IF NOT EXISTS cats
(
    cat_id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name text,
    birthday date,
    breed text,
    color text
);

CREATE TABLE IF NOT EXISTS masters
(
    master_id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login text,
    password text,
    birthday date,
    role smallint,
    CONSTRAINT uniqueLogin PRIMARY KEY (login)
);

CREATE TABLE IF NOT EXISTS cats_friend
(
    cat_friend_one INTEGER,
    cat_friend_two INTEGER,
    PRIMARY KEY (cat_friend_one, cat_friend_two)
);

CREATE TABLE IF NOT EXISTS masters_cats
(
    cat_id INTEGER PRIMARY KEY,
    master_id INTEGER
)