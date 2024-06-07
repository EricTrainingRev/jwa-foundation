-- Use this script to set up your Planetarium database

-- needed for referential integrity enforcement
PRAGMA foreign_keys = 1;

drop table if exists moons;

drop table if exists planets;

drop table if exists users;

create table users(
	id integer primary key,
	username text unique not null check (length(username) <= 30),
	password text not null check (length(password) <= 30)
);

insert into users (username, password) values ('Batman', 'I am the night');

create table planets(
	id integer primary key,
	name text not null check (length(name) <= 30),
	ownerId integer references users(id)
);

create table moons(
	id integer primary key,
	name text not null check (length(name) <= 30),
	myPlanetId integer references planets(id)
);