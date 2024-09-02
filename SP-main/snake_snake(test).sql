create table test
(  id number not null);

insert into test values (1);

select * from test;

create table tbl_class  
(classidx int not null,
 classname varchar(10) not null,
 classgrade int not null);
 
 insert into tbl_class values (1,'Å×½ºÆ®',1);
 
 select * from tbl_class;
 
 commit;