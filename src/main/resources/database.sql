USE itransition_bd;

CREATE TABLE users (
                       username varchar(255),
                       password varchar(255),
                       enabled tinyint(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(255),
                             authority varchar(255),
                             FOREIGN KEY (username) references users(username)
) ;

INSERT INTO itransition_bd.users (username, password, enabled)
VALUES
('zaur', '{noop}zaur', 1),
('damp', '{noop}damp', 1),
('ivan', '{noop}ivan', 1);

INSERT INTO itransition_bd.authorities (username, authority)
VALUES
('zaur', 'ROLE_USER'),
('damp', 'ROLE_USER'),
('damp', 'ROLE_ADMIN'),
('ivan', 'ROLE_USER');
    
    