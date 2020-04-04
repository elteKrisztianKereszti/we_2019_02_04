insert into issue (title, description, place, status, created_at, updated_at) values ('issue1', 'description1', 'PC-01', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue2', 'description2', 'PC-02', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue3', 'description3', 'PC-03', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue4', 'description4', 'PC-04', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into message (issue_id, text, created_at, updated_at) values (1, 'The things', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (2, 'that should', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (3, 'not', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (3, 'be', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
