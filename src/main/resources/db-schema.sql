create table if not exists current_states (id smallint primary key, state_code char(2), name varchar(50));
insert into current_states(id, state_code, name) values(1, 'MA', 'Massachusetts') ON DUPLICATE KEY UPDATE id=id;
insert into current_states(id, state_code, name) values(2, 'NH', 'New Hampshire') ON DUPLICATE KEY UPDATE id=id;
insert into current_states(id, state_code, name) values(3, 'ME', 'Maine') ON DUPLICATE KEY UPDATE id=id;
insert into current_states(id, state_code, name) values(4, 'VT', 'Vermont') ON DUPLICATE KEY UPDATE id=id;
insert into current_states(id, state_code, name) values(6, 'XX', 'XXssssVermont') ON DUPLICATE KEY UPDATE id=id;

create table if not exists location(id int primary key, name varchar(50), num_emp int );
insert into location values(1, 'PromA', 1400) ON DUPLICATE KEY UPDATE id=id;
insert into location values(2, 'PromB', 1200) ON DUPLICATE KEY UPDATE id=id;
insert into location values(3, 'PromC', 1100) ON DUPLICATE KEY UPDATE id=id;
insert into location values(4, 'PromD', 1300) ON DUPLICATE KEY UPDATE id=id;
insert into location values(5, 'PromE', 1400) ON DUPLICATE KEY UPDATE id=id;
insert into location values(6, 'PromF', 1000) ON DUPLICATE KEY UPDATE id=id;

create table if not exists car(id int primary key, num_seats int, car_num varchar(50), year_purchased year,
							   availability boolean);
insert into car values(1, 4, "BA3415", 2005, true) ON DUPLICATE KEY UPDATE id=id;
insert into car values(2, 4, "DP3415", 2005, true) ON DUPLICATE KEY UPDATE id=id;
insert into car values(3, 6, "BA34D5", 2005, true) ON DUPLICATE KEY UPDATE id=id;
insert into car values(4, 4, "LE3415", 2005, true) ON DUPLICATE KEY UPDATE id=id;
insert into car values(5, 6, "BA3W15", 2005, true) ON DUPLICATE KEY UPDATE id=id;
insert into car values(6, 4, "B9K215", 2005, true) ON DUPLICATE KEY UPDATE id=id;

create table if not exists employee( id int primary key, name varchar(50), loc_id int references location(id),
									 emailid varchar(50));
insert into employee values(1, 'anish', 5, 'ashrigondekar@vmware.com') ON DUPLICATE KEY UPDATE id=id;
insert into employee values(2, 'rohit', 2, 'rmenon@vmware.com') ON DUPLICATE KEY UPDATE id=id;
insert into employee values(3, 'piyush', 3, 'pparmar@vmware.com') ON DUPLICATE KEY UPDATE id=id;
insert into employee values(4, 'ashish', 1, 'abagate@vmware.com') ON DUPLICATE KEY UPDATE id=id;

create table if not exists trip(id int primary key AUTO_INCREMENT, eid int references employee(id), car_id int references car(id), source int references
								location(loc_id), destination int references location(id), checkin_time time,
								checkout_time time);

create table if not exists queue(eid int references employee(id), resv_time time, req_time time, 
								 source int references location(id) );
						
create table if not exists login(eid int references employee(id), password varchar(40));
insert into login values(4, 'bagate') ON DUPLICATE KEY UPDATE eid=eid;


create table if not exists receptionist(eid int references employee(id) );
insert into receptionist values(4) ON DUPLICATE KEY UPDATE eid=eid;

