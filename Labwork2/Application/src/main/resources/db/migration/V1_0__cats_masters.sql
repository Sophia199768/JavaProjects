CREATE TABLE IF NOT EXISTS Cats
(
    catId INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name text,
    birthday date,
    breed text,
    color text
);

CREATE TABLE IF NOT EXISTS Masters
(
    masterId INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name text,
    birthday date
);

CREATE TABLE IF NOT EXISTS Cats_Friend
(
    cat_friend_one INTEGER,
    cat_friend_two INTEGER,
PRIMARY KEY (cat_friend_one, cat_friend_two)
);

CREATE TABLE IF NOT EXISTS Masters_Cats
(
    catId INTEGER PRIMARY KEY,
    masterId INTEGER
)