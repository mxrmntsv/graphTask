CREATE TABLE user_relations
(
    id       UUID NOT NULL,
    index    int,
    relation jsonb,
    primary key (id)
)