
create table players (id bigint not null auto_increment,
                      player_name varchar(255) not null,
                      player_birth_date date,
                      team_id bigint,
                      primary key (id)),
                      foreign key (team_id) references teams(id))