insert into issue (title, description, place, status, created_at, updated_at) values ('issue1', 'description1', 'PC-01', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue2', 'description2', 'PC-02', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue3', 'description3', 'PC-03', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (title, description, place, status, created_at, updated_at) values ('issue4', 'description4', 'PC-04', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into message (issue_id, text, created_at, updated_at) values (1, 'The things', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (2, 'that should', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (3, 'not', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (3, 'be', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into label (text, created_at, updated_at) values ('Low', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('High', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('Blocked', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('Need approval', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into issue_labels (issues_id, labels_id) values (1, 1);
insert into issue_labels (issues_id, labels_id) values (1, 3);
insert into issue_labels (issues_id, labels_id) values (1, 4);
insert into issue_labels (issues_id, labels_id) values (2, 1);
insert into issue_labels (issues_id, labels_id) values (3, 2);

insert into user (username, password, enabled, role) values ('user1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');
insert into user (username, password, enabled, role) values ('user2', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER'); 
