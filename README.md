# Spring boot jdbctemplate rest api with pgsql

## create database and user
```
psql postgres
create database sb_psql;
create user sbdb with encrypted password 'sbp@$$w0rd';
grant all privileges on database sb_psql to sbdb;
```

## Install postgres UUID extension
```
CREATE EXTENSION "uuid-ossp";
SELECT uuid_generate_v4();
```
