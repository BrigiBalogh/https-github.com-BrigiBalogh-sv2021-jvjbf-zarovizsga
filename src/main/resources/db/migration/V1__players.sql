create table players (id bigint not null auto_increment,
                     player_name varchar(255) not nul,
                     player_birth_date date ,
                     primary key (id)),
                      foreign key (team_id) references teams(id));

