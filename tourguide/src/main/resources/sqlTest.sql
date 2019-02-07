create table tour(
	site_name varchar2(20 char),
	state varchar2(10 char) not null,
	district varchar2(10 char) not null,
	contents varchar2(1000 char) not null,
	position varchar2(10 char) not null,
	homepage varchar2(30) not null,
	primary key(site_name)
);

insert into tour values('test1', 'test2', 'test3', 'test4', 'test5', 'test6');
select * from tour;

CREATE SEQUENCE SEQ_ID INCREMENT BY 1 START WITH 10000;

INSERT INTO MYTABLE VALUES( SEQ_ID.NEXTVAL, '홍길동');